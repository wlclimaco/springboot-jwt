(function() {
'use strict';
angular.module('wdApp.apps.sysmgmt.dataphp', [])
	.service('SysMgmtDataPHP', ['$http', 'toastr', 'toastrConfig',  function($http, toastr, toastrConfig){

		toastrConfig.closeButton = true;
	
		//common process error logic
		function process_errors(_resp, _callback){
			toastr.error('AJAX Error calling sysmgmt rest api: ' + _resp.status + " " +  _resp.statusText, 'Error');		
			//_resp = "";  
			_callback(_resp);			
		};
		
		//common process business error logic
		function process_business_errors(_resp, _callback){
				//console.log("pbe:");
				//console.log(_resp);				
				var msgOut = "Data Processing Error calling sysmgmt rest api: ";
				if (_resp == null){
					//use default message
				}
				else
				{
					//console.log("pbe2:");
					msgOut = msgOut + _resp.messageList;
				}
				toastr.warning(msgOut, 'Warning');
				//_resp = "";  				
				_callback(_resp);			
		};		
		
		//common process data logic		
		function process_data(_resp, _callback)	{
			//console.log("pd:")
			//console.log(_resp);
			//Successful Return and got some type of object back
			if (_resp != null && (_resp.operationSuccess)){
				//checks for business errors
				if (($.isArray(_resp.messageList)) && (_resp.messageList.length > 0) || (_resp.messageList))
				{
					process_business_errors(_resp, _callback);	
				}
				else{
					_callback(_resp);
				}
			}
			else{
				process_business_errors(_resp, _callback);								
			};			
		};		
	
		return{
				processPostPageData: function(_url, _req, _callback){
					var res = $http.post(_url, _req);
					res.then(function(response) {
						//process success data	
						//console.log(response);							
						process_data(response.data, _callback)						
					}).catch( // Catch
						function(responseError) {
							process_errors(responseError, _callback);;
					});
					
				},
				processGetPageData: function(_url, _callback){
					var res = $http.get(_url);
					res.then(function(response) {
						//process success data						
						process_data(response.data, _callback)						
					}).catch( // Catch
						function(responseError) {
							process_errors(responseError, _callback);;
					});				
				}				
			};
			
}]);

}).call(this);

