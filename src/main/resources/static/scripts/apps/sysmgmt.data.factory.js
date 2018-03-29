(function() {
'use strict';
angular.module('wdApp.apps.sysmgmt.data', [])
	.factory('SysMgmtData', ['$injector',  function($injector){
  
		if (WebDaptiveAppConfig.wdBackend === 'PHP') 
		{
			return $injector.get('SysMgmtDataPHP');
		} 
		else 
		{
			return $injector.get('SysMgmtDataJava');
		}
}]);

}).call(this);

