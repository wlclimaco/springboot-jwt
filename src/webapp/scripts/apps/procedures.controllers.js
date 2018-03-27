(function() {
  angular.module('wdApp.apps.procedures', []).controller('ProceduresController', 
  ['$scope', 'SysMgmtData', 'toastr', 'toastrConfig',
	function($scope, SysMgmtData, toastr, toastrConfig) {
		//why?
		var pvm = this;
		var skipPage = false;	 //used to ensure not calling server multiple times
		var fetch_url = WebDaptiveAppConfig.base_procedure_url +  WebDaptiveAppConfig.fetch_url;
		var refresh_url =  WebDaptiveAppConfig.base_procedure_url +  WebDaptiveAppConfig.refresh_url;
		var create_url =  WebDaptiveAppConfig.base_procedure_url +  WebDaptiveAppConfig.create_url;
		var update_url =  WebDaptiveAppConfig.base_procedure_url +  WebDaptiveAppConfig.update_url;	
		var delete_url =  WebDaptiveAppConfig.base_procedure_url +  WebDaptiveAppConfig.delete_url;	
		//must be part of scope since needs to referenced in the html		
		pvm.isActive = false;
		toastrConfig.closeButton = true;	
		
		//form model data
		pvm.procedure = {
			id: '',
			code: '',
			description: '',
			price: '',
			version: ''
		};
		
		//pagination Options
		var paginationOptions = {
			pageNumber: 1,
			pageSize: 20,
		};	
		
		//grid column defs
		var procedureColumnDefs = [
			{displayName: "Id", field: "id", enableColumnMenu: false, enableSorting: false, maxWidth: 200},
			{displayName: "Procedure Code", field: "code", enableColumnMenu: false, enableSorting: false, maxWidth: 250},	
			{displayName: "Procedure Description", field: "description", enableColumnMenu: false, enableSorting: false, cellTooltip: true},
			{displayName: "Price", field: "price", enableColumnMenu: false, enableSorting: false, cellFilter: 'currency' },
			{displayName: "Version", field: "version", enableColumnMenu: false, enableSorting: false, maxWidth: 100}			
		];
		
		//grid options
		pvm.procedureGridOptions = {
			columnDefs: procedureColumnDefs,
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
					pvm.procedure.id = row.entity.id;
					pvm.procedure.code = row.entity.code;			
					pvm.procedure.description = row.entity.description;		
					pvm.procedure.price = row.entity.price;
					pvm.procedure.version = row.entity.version;					
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
		//reusable processGetData (refresh)
		function processGetData(_url, _skip){
			//console.log(_url);			
			SysMgmtData.processGetPageData(_url,  function(res){
				var dataThisPage = (res.procedures) ?  res.procedures : new Array();
				pvm.procedureGridOptions.data = dataThisPage;	
				pvm.isActive = false;					
				pvm.procedureGridOptions.totalItems = (res) ? res.resultsSetInfo.totalRowsAvailable : 0;
				skipPage = _skip;				
				//this events causes paginationChanged to be fired so a special switch is used to prevent server double call				
				pvm.procedureGridOptions.paginationCurrentPage = (res) ? res.resultsSetInfo.startPage + 1 : 0;	
				//console.log(res.resultsSetInfo);	
				skipPage =  false;					
			});				
		};	

		//reusable processGetData (insert, update, pagedFetch, delete)
		function processPostData(_url, _req, _skip){
			//console.log(_url);	
			SysMgmtData.processPostPageData(_url, _req, function(res){
				var dataThisPage = (res.procedures) ?  res.procedures : new Array();
				pvm.procedureGridOptions.data = dataThisPage;	
				pvm.isActive = false;					
				pvm.procedureGridOptions.totalItems = (res) ? res.resultsSetInfo.totalRowsAvailable : 0;
				skipPage = _skip;					
				//this events causes paginationChanged to be fired so a special switch is used to prevent server double call				
				pvm.procedureGridOptions.paginationCurrentPage = (res) ? res.resultsSetInfo.startPage + 1 : 0;	
				//console.log(res.resultsSetInfo);	
				skipPage =  false;					
			});				
		};			
		
		//refresh procedure function
		pvm.refreshProcedures = function(refreshCount) {	
			pvm.isActive = !pvm.isActive;
			//clear form data
			pvm.clearForm();
			var send_url = refresh_url + "?refreshInt=" + refreshCount + "&retList=true&retPaged=true";
			processGetData(send_url, true);
		};			
		
		//form methods
		//reusable clear form logic
		pvm.clearForm = function(){
			//clear data
			pvm.procedure.id = '';
			pvm.procedure.code = '';			
			pvm.procedure.description = '';		
			pvm.procedure.price = '';
			pvm.procedure.version = '';	
			//set form to pristine
			pvm.form_procedure.$setPristine();				
			//clear grid selection //why?
			$scope.gridApi.selection.clearSelectedRows();	
		};

		//reusable button form logic	
		pvm.processButtons = function(_btnType){	
			if (pvm.form_procedure.$valid){	
				//set switch so server not called twice					
				switch (_btnType) {
				//Add Button							
				case 'A':
					processPostData(create_url, new qat.model.reqProc( new qat.model.procedure(pvm.procedure.id, pvm.procedure.code, 
								pvm.procedure.description, pvm.procedure.price, pvm.procedure.version),true, true), true);						
					break;
				//Update Button						
				case 'U':
					processPostData(update_url, new qat.model.reqProc( new qat.model.procedure(pvm.procedure.id, pvm.procedure.code, 
								pvm.procedure.description, pvm.procedure.price, pvm.procedure.version),true, true), true);						
					break;
				//Delete Button	
				case 'D':
					processPostData(delete_url, new qat.model.reqProc( new qat.model.procedure(pvm.procedure.id, pvm.procedure.code, 
								pvm.procedure.description, pvm.procedure.price, pvm.procedure.version),true, true), true);						
					break;	
				//List Button	
				case 'L':
					processPostData(fetch_url, new qat.model.pagedInquiryRequest( 0, true), true);					
					break;						
				default: 
					console.log('Invalid button type: ' + _btnType);					
				};
			
				//clear the form
				pvm.clearForm();
			}
			else
			{
				if (_btnType == 'L'){
					//set switch so server not called twice					
					processPostData(fetch_url, new qat.model.pagedInquiryRequest( 0, true), true);
					//clear the form
					pvm.clearForm();
				}
				else{					
					toastr.error('Procedure form error, please correct and resubmit.', 'Error');
				}	
			}		
		};		
		
    }
  ]);
}).call(this);



