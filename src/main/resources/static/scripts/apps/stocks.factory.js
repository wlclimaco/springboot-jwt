(function() {
'use strict';
angular.module('wdApp.apps.stocksdata', [])
	.factory('StockData', ['$http', 'toastr', 'toastrConfig', function($http, toastr, toastrConfig){

		toastrConfig.closeButton = true;
	
		return{
				getStockData: function(_stocks, _callback){
					var defs = {
						baseURL: 'https://api.iextrading.com/1.0/stock/market/batch?types=quote&symbols=',
					};
		
					defs.url = defs.baseURL + _stocks;	
						
					$http.get(defs.url).
					  then(function(_resp) {
					  
						var _quotes = [];
						
						for (var i in _stocks) {
							_quotes[i] = _resp.data[_stocks[i]].quote;
						};
					  
						_callback(_quotes);
					  }).catch( // Catch
						function(_respError) {
							toastr.error('Error calling the REST stock api: ' + _respError.status + " " +  _respError.statusText, 'Error');						
							_respError = "";  
							_callback(_respError);
					 });
				}
			};
}]);

}).call(this);

