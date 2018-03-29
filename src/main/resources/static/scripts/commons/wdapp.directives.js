(function() {
	'use strict';
	var commonDirectives = angular.module('wdApp.directives', []);
    // swtich for mini style NAV, realted to 'collapseNav' directive uses jQuery
	commonDirectives.directive('toggleNavCollapsedMin', ['$rootScope', function($rootScope) {
		return {
			restrict: 'A',
			link: function(scope, ele, attrs) {
				var wdApp;
				wdApp = $('#wdApp');
				return ele.on('click', function(e) {
					if (wdApp.hasClass('nav-collapsed-min')) {
						wdApp.removeClass('nav-collapsed-min');
					} else {
						wdApp.addClass('nav-collapsed-min');
						$rootScope.$broadcast('nav:reset');
					}
					return e.preventDefault();
				});
			}
		};
	}]);

	// for accordion/collapse style NAV uses jQuery
	commonDirectives.directive('collapseNav', [function() {
		return {
			restrict: 'A',
			link: function(scope, ele, attrs) {
				    var $a, $aRest, $app, $lists, $listsRest, $nav, $window, Timer, prevWidth, slideTime, updateClass;

					slideTime = 250;

					$window = $(window);

					$lists = ele.find('ul').parent('li');

					$lists.append('<i class="ti-angle-down icon-has-ul-h"></i><i class="ti-angle-right icon-has-ul"></i>');

					$a = $lists.children('a');

					$listsRest = ele.children('li').not($lists);

					$aRest = $listsRest.children('a');

					$app = $('#wdApp');

					$nav = $('#nav-container');

					$a.on('click', function(event) {
						var $parent, $this;
						if ($app.hasClass('nav-collapsed-min') || ($nav.hasClass('nav-horizontal') && $window.width() >= 768)) {
							return false;
						}
						$this = $(this);
						$parent = $this.parent('li');
						$lists.not($parent).removeClass('open').find('ul').slideUp(slideTime);
						$parent.toggleClass('open').find('ul').stop().slideToggle(slideTime);
						event.preventDefault();
					});

					$aRest.on('click', function(event) {
						$lists.removeClass('open').find('ul').slideUp(slideTime);
					});

					scope.$on('nav:reset', function(event) {
						$lists.removeClass('open').find('ul').slideUp(slideTime);
					});

					Timer = void 0;

					prevWidth = $window.width();

					updateClass = function() {
						var currentWidth;
						currentWidth = $window.width();
						if (currentWidth < 768) {
							$app.removeClass('nav-collapsed-min');
						}
						if (prevWidth < 768 && currentWidth >= 768 && $nav.hasClass('nav-horizontal')) {
							$lists.removeClass('open').find('ul').slideUp(slideTime);
						}
						prevWidth = currentWidth;
					};

					$window.resize(function() {
						var t;
						clearTimeout(t);
						t = setTimeout(updateClass, 300);
					});
			}
		};
	}]);

	 // Add 'active' class to li based on url, muli-level supported, does NOT use jQuery
	commonDirectives.directive('highlightActive', [function() {
		return {
			restrict: "A",
			controller: [
			'$scope', '$element', '$attrs', '$location', function($scope, $element, $attrs, $location) {
				var highlightActive, links, path;

				links = $element.find('a');

				path = function() {
					return $location.path();
				};

				highlightActive = function(links, path) {
					path = '#' + path;
					return angular.forEach(links, function(link) {
						var $li, $link, href;
						$link = angular.element(link);
						$li = $link.parent('li');
						href = $link.attr('href');
						if ($li.hasClass('active')) {
							$li.removeClass('active');
						}
						if (path.indexOf(href) === 0) {
							return $li.addClass('active');
						}
					});
				};

				highlightActive(links, $location.path());

				$scope.$watch(path, function(newVal, oldVal) {
					if (newVal === oldVal) {
						return;
					}
					return highlightActive(links, $location.path());
				});
			}]
		};	
	}]);
	
	//footer directive
	commonDirectives.directive('uiFooter', [function() {
		return {
			restrict: 'A',
			replace: true,
			templateUrl: "views/footer.html",
			controller: ['$scope', function ($scope) {
				$scope.cDate = new Date().getFullYear();
			}]
		};
	}]);	

	// toggle on-canvas for small screen, with CSS uses jQuery
	commonDirectives.directive('toggleOffCanvas', [function() {
		return {
			restrict: 'A',
			link : function(scope, ele, attrs) {
				ele.on('click', function() {
					return $('#wdApp').toggleClass('on-canvas');
				});         
			}
		};
	}]);

	//know the why
	commonDirectives.directive('focus', [ '$timeout', function ($timeout) {
		return {
			scope : {
				trigger : '@focus'
			},
			link : function(scope, element) {
				scope.$watch('trigger', function(value) {
					if (value === "true") {
						$timeout(function() {
							element[0].focus();
						});
					}
				});
			}
		};
	} ]);

})();
