console.log("angular object",angular); //used for debugging and training only do not put in production
var WebDaptiveAppConfig = {
	//Main area for config URLs for WebDaptive
	
	/* When set to false a query parameter is used to pass on the auth token.
	 * This might be desirable if headers don't work correctly in some
	 * environments and is still secure when using https. */
	useAuthTokenHeader: true,
	wdBrand: 'WebDaptive - Angular',
	wdDefaultUser: 'Taz',
	//What is the back-end PHP, Java, NET
	//example 	wdBackend: 'PHP', or 	wdBackend: 'Java', or 	wdBackend: 'NET',
	wdBackend: 'Java',
	//values for the rest calls to jDpative, nDaptive or PHP Back-end so the county and/or provider applications work
	//restAuthBase = string to check for rest calls to jDpative, nDaptive or PHP Back-end so the angular http provider can inject x-auth token
	//Java URLs & Settings
	restAuthBase: 'qat-sysmgmt-controller-rest',
	authenticationURL: 'http://localhost:8080/qat-sysmgmt-controller-rest/auth/api/authenticate',		
	base_county_url: 'http://localhost:8080/qat-sysmgmt-controller-rest/county/api',
	base_procedure_url: 'http://localhost:8080/qat-sysmgmt-controller-rest/procedure/api',	
	//PHP URLs & Settings
	//restAuthBase: 'sysmgmt-php',	
	//authenticationURL: 'http://localhost:8200/sysmgmt-php/auth/api/authenticate',		
	//base_county_url: 'http://localhost:8200/sysmgmt-php/county/api',	
	//below are the same for all backends	
	fetch_url: '/fetchPage',
	refresh_url: '/refresh',
	create_url: '/insert',
	update_url: '/update',		
	delete_url: '/delete'    	
};

(function() {
  'use strict';
	var wdApp = angular.module('wdApp', 
				['ngRoute', 'ngAnimate', 'ui.bootstrap', 'textAngular', 'ui.grid', 'ngCookies','pascalprecht.translate',
				'ui.grid.resizeColumns', 'ui.grid.selection', 'ui.grid.pagination',	'ui.tree', 'ngMap', 
				'ngTagsInput', 'toastr', 'angular-loading-bar', 'chart.js', 'ngecharts', 'base64', 'ngSlimScroll', 
				'LocalStorageModule', 'validation.match', 'wdApp.controllers', 'wdApp.directives', 'wdApp.httpint',
				'wdApp.localization', 'wdApp.ui.controllers', 'wdApp.forms.controllers', 'wdApp.tables.controllers', 
				'wdApp.tasks', 'wdApp.charts.chartjs.controllers', 'wdApp.charts.echarts.controllers',  'wdApp.dashboard.controllers',
				'wdApp.authentication', 'wdApp.pages.controllers', 'wdApp.demodata', 'wdApp.apps.stocks', 
				'wdApp.apps.stocksdata','wdApp.apps.counties', 	'wdApp.apps.procedures','wdApp.apps.sysmgmt.data', 
				'wdApp.apps.sysmgmt.datajava', 'wdApp.apps.sysmgmt.dataphp']);  
  
	wdApp.config(['$routeProvider',
		function($routeProvider) {
			var routes, setRoutes;
			//all available routes
			routes = ['dashboard', 'ui/typography', 'ui/buttons', 
			'ui/icons', 'ui/grids', 'ui/widgets', 'ui/components', 
			'ui/timeline', 'ui/tree', 'ui/pricing-tables', 'ui/maps', 
			'tables/static', 'tables/dynamic', 'tables/responsive', 
			'forms/elements', 'forms/layouts', 'forms/validation',  
			'charts/chartjs', 'charts/echarts', 'pages/404', 'pages/500', 'pages/blank',
			'pages/invoice', 'pages/profile', 'pages/signin', 'mail/compose', 
			'mail/inbox', 'mail/single', 'tasks/tasks', 
			'apps/stocks', 'apps/counties', 'apps/procedures'];
			
			//generic routine for building route from array
			setRoutes = function(route) {
				var config, url;
				url = '/' + route;
				config = {
				templateUrl: 'views/' + route + '.html'
				};
				$routeProvider.when(url, config);
				return $routeProvider;
			};
			
			//build routes for this application
			routes.forEach(function(route) {
				return setRoutes(route);
			});
			
			//routes not automatically built specified here
			return $routeProvider.when('/', {
				redirectTo: '/dashboard'
			}).when('/404', {
				templateUrl: 'views/pages/404.html'
			}).otherwise({
				redirectTo: '/404'
			});
			
	}]);
	
	//config localstorage
	wdApp.config(['localStorageServiceProvider', function(localStorageServiceProvider) {
		//sets local storage application prefix for all keys
		localStorageServiceProvider.setPrefix('wdAppLS');
	}]);
	
	//config router
	wdApp.config(['$locationProvider', function($locationProvider) {
		//nulls the default hashprefix which is ! on Router
		$locationProvider.hashPrefix('');
	}]);	
	
	//config i18n
	wdApp.config(['$translateProvider', function($translateProvider) { 
	
            $translateProvider.useStaticFilesLoader({
                prefix: 'i18n/resources-locale_',
                suffix: '.json'
            });

            $translateProvider.preferredLanguage('en');
            $translateProvider.useSanitizeValueStrategy(null);	
	}]);	

	//config http interceptor
	wdApp.config(['$httpProvider', function($httpProvider) { 
			//register WebDaptive interceptor factory
			$httpProvider.interceptors.push('WDHttpInterceptors');		
	}]);
	
	//temp fix ui-grid
	wdApp.config(['$qProvider', function ($qProvider) {
		$qProvider.errorOnUnhandledRejections(false);
	}]);	

	//run each time angular app comes up (runs only once)
	wdApp.run(function($rootScope, $location, localStorageService) {
		
		$rootScope.main = {
			brand: WebDaptiveAppConfig.wdBrand,
			name: WebDaptiveAppConfig.wdDefaultUser,
			backend: WebDaptiveAppConfig.wdBackend
		};		
		
		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});
		
		//the hasRole method that drives the hide/show of html 
		$rootScope.hasRole = function(role) {
			
			if ($rootScope.user === undefined) {
				return false;
			}
			
			if ($rootScope.user.roles[role] === undefined) {
				return false;
			}
			
			return $rootScope.user.roles[role];
		};		
		
		//logout function clears all relevant presistent storage
		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $rootScope.authToken;
			delete $rootScope.callingPath;
			delete $rootScope.displayRoles;			
			$rootScope.main.name = WebDaptiveAppConfig.wdDefaultUser;
			localStorageService.clearAll();
		};
		
		/* Try getting valid user from localStorage */	
		if (localStorageService.get('authToken') !==  null){
			$rootScope.authToken = localStorageService.get('authToken');
			$rootScope.user = localStorageService.get('currentUser');
			$rootScope.main.name = 	$rootScope.user.user;
			$rootScope.displayRoles = localStorageService.get('displayRoles');	
		}

		 //flag to let us know everything is full initialized can be referenced anywhere
		$rootScope.initialized = true;
	});	

})();
