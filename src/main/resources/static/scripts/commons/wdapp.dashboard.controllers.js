(function() {
  'use strict';
	var dashboardControllers =  angular.module('wdApp.dashboard.controllers', []);
  
	dashboardControllers.controller('DBRealTimeController', ['$scope', '$interval', function($scope, $interval) {
			var maximum = 300;
			var cvm = this;
			cvm.data = [[]];
			cvm.labels = [];
			cvm.options = {
			  animation: {
				duration: 0
			  },
			  elements: {
				line: {
				  borderWidth: 0.5
				},
				point: {
				  radius: 0
				}
			  },
			  legend: {
				display: false
			  },
			  scales: {
				xAxes: [{
				  display: false
				}],
				yAxes: [{
				  display: false
				}],
				gridLines: {
				  display: false
				}
			  },
			  tooltips: {
				enabled: false
			  }
			};

			// Update the dataset at 25FPS for a smooth-animating chart
			$interval(function () {
			  getLiveChartData();
			}, 40);

		  function getLiveChartData () {
			  if (cvm.data[0].length) {
				cvm.labels = cvm.labels.slice(1);
				cvm.data[0] = cvm.data[0].slice(1);
			  }

			  while (cvm.data[0].length < maximum) {
				cvm.labels.push('');
				cvm.data[0].push(getRandomValue(cvm.data[0]));
			  }
		  };

		  function getRandomValue (data) {
			var l = data.length, previous = l ? data[l - 1] : 50;
			var y = previous + Math.random() * 10 - 5;
			return y < 0 ? 0 : y > 100 ? 100 : y;
		  };
	}]);

	dashboardControllers.controller('DBPieController', ['$scope', function($scope) {
			var cvm = this;
		    cvm.pie1 = {};
			cvm.pie1.options = {
				animation: true,
				title : {
					text: 'Traffic Source',
					x:'center'
				},
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					orient : 'vertical',
					x : 'left',
					data:['Search', 'Direct', 'Email','Video Ads']
				},				
				toolbox: {
					show : true,
					feature : {
						dataView : {show: true, readOnly: false, title: "data",  lang:['Data View', 'close', 'refresh']},						
						restore : {show: true, title: "restore"},
						saveAsImage : {show: true, title: "save as image"}
					}
				},				
				calculable : true,
				series : [
					{
						name:'Vist source',
						type:'pie',
						radius : '55%',
						center: ['50%', '60%'],
						data:[
							{
								value:335,
								name:'Direct',
								itemStyle:{                                
									normal:{
										color: $scope.color.success,
										label: {
											show: true,
											textStyle: {
												color: $scope.color.success
											}
										},
										labelLine : {
											show: true,
											lineStyle: {
												color: $scope.color.success
											}
										}                                    
									}
								}
							}, {
								value:310,
								name:'Email',
								itemStyle:{
									normal:{
										color: $scope.color.infoAlt,
										label: {
											show: true,
											textStyle: {
												color: $scope.color.infoAlt
											}
										},
										labelLine : {
											show: true,
											lineStyle: {
												color: $scope.color.infoAlt
											}
										}
									}
								}                            
							},{
								value:135,
								name:'Video Ads',
								itemStyle:{
									normal:{
										color: $scope.color.warning,
										label: {
											show: true,
											textStyle: {
												color: $scope.color.warning
											}
										},
										labelLine : {
											show: true,
											lineStyle: {
												color: $scope.color.warning
											}
										}
									}
								} 
							}, {
								value:1548,
								name:'Search',
								itemStyle:{
									normal:{
										color: $scope.color.info,
										label: {
											show: true,
											textStyle: {
												color: $scope.color.info
											}
										},
										labelLine : {
											show: true,
											lineStyle: {
												color: $scope.color.info
											}
										}
									}
								} 
							}
						]
					}
				]
			};			
			

	}]);
})();
