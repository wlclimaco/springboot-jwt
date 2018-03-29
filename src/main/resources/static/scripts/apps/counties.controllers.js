(function() {
  angular.module('wdApp.apps.counties', []).controller('CountiesController', 
  ['$scope', 'SysMgmtData', 'toastr', 'toastrConfig',
	function($scope, SysMgmtData, toastr, toastrConfig) {
		//why?
		var cvm = this;	
		var fetch_url = WebDaptiveAppConfig.base_county_url +  WebDaptiveAppConfig.fetch_url;
		var refresh_url =  WebDaptiveAppConfig.base_county_url +  WebDaptiveAppConfig.refresh_url;
		var create_url =  WebDaptiveAppConfig.base_county_url +  WebDaptiveAppConfig.create_url;
		var update_url =  WebDaptiveAppConfig.base_county_url +  WebDaptiveAppConfig.update_url;	
		var delete_url =  WebDaptiveAppConfig.base_county_url +  WebDaptiveAppConfig.delete_url;		
		cvm.isActive = false;
		var skipPage = false;	//used to ensure not calling server multiple times
		toastrConfig.closeButton = true;		
		
		//form model data
		cvm.county = {
			id: '',
			description: ''
		};
		
		//pagination Options
		var paginationOptions = {
			pageNumber: 1,
			pageSize: 20,
		};		
		
		//grid column defs
		var countyColumnDefs = [
			{displayName: "County Id", field: "id", enableColumnMenu: false, enableSorting: false, maxWidth: 200},
			{displayName: "County Description", field: "description", enableColumnMenu: false, enableSorting: false, cellTooltip: true}
	
		];
		
 		//grid options
		cvm.countyGridOptions = {
			columnDefs: countyColumnDefs,
			enableFullRowSelection: true,
			enableRowHeaderSelection: false,
			multiSelect: false,			
			paginationPageSizes: [20],			
			pagingPageSize: 20,
			useExternalPagination: true,
			enableColumnResizing: true,
			onRegisterApi: function (gridApi) {
				//why is this needed
				$scope.gridApi = gridApi;
				//grid row select function				
				gridApi.selection.on.rowSelectionChanged($scope,function(row){
					cvm.county.id = row.entity.id;
					cvm.county.description = row.entity.description;
					//console.log(row);
				});	
				gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
					//this events fires anytime page number is changed pay attention to the logic and api to figure out the why					
					//console.log("np1: " + newPage + " skipPage " + skipPage);
					if (!skipPage)
					{		
						paginationOptions.pageNumber = newPage;
						paginationOptions.pageSize = pageSize;
						processPostData(fetch_url, new qat.model.pagedInquiryRequest(newPage - 1, true), false);
					}
					else
					{
						skipPage = false;
						//console.log("np2: " + newPage + " skipPage " + skipPage);						
					}		
				});
			}			
		};
		
		//initial data load
		processPostData(fetch_url, new qat.model.pagedInquiryRequest( 0, true), true);
		
		//reusable data methods
		//reusable processGetData (refresh,delete)
		function processGetData(_url, _skip)
		{
			//console.log(_url);			
			SysMgmtData.processGetPageData(_url,  function(res){
				var dataThisPage = (res.counties) ?  res.counties : new Array();
				cvm.gList =  dataThisPage;	
				cvm.countyGridOptions.data = dataThisPage;	
				cvm.isActive = false;					
				cvm.countyGridOptions.totalItems = (res) ? res.resultsSetInfo.totalRowsAvailable : 0;
				skipPage = _skip;				
				//this events causes paginationChanged to be fired so a special switch is used to prevent server double call					
				cvm.countyGridOptions.paginationCurrentPage = (res) ? res.resultsSetInfo.startPage + 1 : 0;	
				//console.log(res.resultsSetInfo);	
				skipPage =  false;					
			});				
		};	

		//reusable processGetData (insert, update, pagedFetch)
		function processPostData(_url, _req, _skip)
		{
			//console.log(_url);	
			SysMgmtData.processPostPageData(_url, _req, function(res){
					//console.log("ppdcc");				
					//console.log(res);				
					var dataThisPage = (res.counties) ?  res.counties : new Array();
					cvm.gList =  dataThisPage;	
					cvm.countyGridOptions.data = dataThisPage;
					cvm.isActive = false;	
					cvm.countyGridOptions.totalItems = (res) ? res.resultsSetInfo.totalRowsAvailable : 0;	
					skipPage = _skip;
					//this events causes paginationChanged to be fired so a special switch is used to prevent server double call
					cvm.countyGridOptions.paginationCurrentPage = (res) ? res.resultsSetInfo.startPage + 1 : 0;	
					//console.log(res.resultsSetInfo);	
					skipPage =  false;						
			});			

		};	

		
		//refresh county function
		cvm.refreshCounties = function(refreshCount) {
			cvm.isActive = !cvm.isActive;
			//clear form data
			cvm.clearForm();		
			var send_url = refresh_url + "?refreshInt=" + refreshCount + "&retList=true&retPaged=true";
			processGetData(send_url, true);
		};			
		
		//form methods
		//reusable clear form logic
		cvm.clearForm = function (){
			//clear data
			cvm.county.id = "";
			cvm.county.description = "";
			//set form to pristine
			cvm.form_county.$setPristine();	
			//clear grid selection //why?
			$scope.gridApi.selection.clearSelectedRows();
		};
		
		//reusable button form logic		
		cvm.processButtons = function(_btnType){	
			//console.log(_btnType);		
			if (cvm.form_county.$valid)
			{	
				switch (_btnType) {
				//Add Button							
				case 'A':
					processPostData(create_url,  new qat.model.reqCounty( new qat.model.county(cvm.county.id, cvm.county.description),true, true), true);	
					break;
				//Update Button						
				case 'U':
					processPostData(update_url,  new qat.model.reqCounty( new qat.model.county(cvm.county.id, cvm.county.description),true, true), true);	
					break;
				//Delete Button	
				case 'D':
					var send_url = delete_url + "?countyId=" + cvm.county.id + "&retList=true&retPaged=true";
					processGetData(send_url, true);
					break;	
				//List Button	
				case 'L':
					processPostData(fetch_url, new qat.model.pagedInquiryRequest( 0, true), true);
					break;					
				default: 
					console.log('Invalid button type: ' + _btnType);					
				};
				//clear the form
				cvm.clearForm();
			}
			else{
				if (_btnType == 'L'){
					processPostData(fetch_url, new qat.model.pagedInquiryRequest( 0, true), true);
					//clear the form
					cvm.clearForm();
				}
				else{	
					toastr.error('County form error, please correct and resubmit.', 'Error');
				}	
			}		
		};
		
    }
  ]);
}).call(this);

