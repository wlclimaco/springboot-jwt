(function() {
  angular.module('wdApp.apps.stocks', []).controller('StocksController', 
  ['$scope', 'StockData', function($scope, StockData) {
	   //know the why here.....
	    var svm = this;
		var	gstocks = ['AAPL', 'AMZN', 'AXP', 'BA','FDX', 'GOOG', 'IBM', 'MSFT', 'NFLX','ORCL', 'GM'];	
		
		var stockColumnDefs = [
			{displayName: "Symbol", field: "symbol", enableHiding: false},
			{displayName: "Company", field: "companyName", enableHiding: false, cellTooltip: true},
			{displayName: "Sector", field: "sector", enableHiding: false, cellTooltip: true},			
			{displayName: "Stock Exchange", field: "primaryExchange", enableHiding: false},
			{displayName: "Market Cap", field: "marketCap", enableHiding: false, cellFilter: 'currency' },
			{displayName: "52 Week Low", field: "week52Low", enableHiding: false, cellFilter: 'currency' },			
			{displayName: "52 Week High", field: "week52High", enableHiding: false, cellFilter: 'currency' },
			{displayName: "Last Trade Price", field: "latestPrice", enableHiding: false, cellFilter: 'currency' },
			{displayName: "Last Trade Date (ET)", field: "latestUpdate", enableColumnMenu: false, enableSorting: false, cellFilter: 'date:"MM/dd/yyyy @ h:mma"' }
		];

		svm.stockGridOptions = {
			columnDefs: stockColumnDefs,
			enableColumnResizing: true,
			showGridFooter: true		
		};
		
		//initload
		StockData.getStockData(gstocks,function(res){
			svm.stockGridOptions.data = res;
		});
    }
  ]);
}).call(this);



