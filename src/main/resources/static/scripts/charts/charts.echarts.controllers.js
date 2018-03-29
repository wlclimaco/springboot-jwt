(function () {
    'use strict';
	var echartsCommon  = angular.module('wdApp.charts.echarts.controllers', []); 
	
	echartsCommon.controller('EChartsController', ['$scope', function ($scope) {
			// Build ECharts with Bar, Line, Pie, Scatter, Chord, Combo
			var evm = this;				
	
			evm.line3 = {};
			evm.bar4 = {};
			evm.pie1 = {};
			evm.scatter2 = {};
			evm.chord1 = {};
			evm.combo = {};
			evm.fdirect = {};	
			evm.bgauge = {};			
	
			evm.line3.options = {
				title : {
					text: 'Sales',
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:['Intention','Pre-order','Deal closed']
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
				xAxis : [
					{
						type : 'category',
						boundaryGap : false,
						data : ['Mon.','Tue.','Wed.','Thu.','Fri.','Sat.','Sun.']
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'Deal closed',
						type:'line',
						smooth:true,
						itemStyle: {normal: {areaStyle: {type: 'default'}}},
						data:[10, 12, 21, 54, 260, 830, 710]
					},
					{
						name:'Pre-order',
						type:'line',
						smooth:true,
						itemStyle: {normal: {areaStyle: {type: 'default'}}},
						data:[30, 182, 434, 791, 390, 30, 10]
					},
					{
						name:'Intention',
						type:'line',
						smooth:true,
						itemStyle: {normal: {areaStyle: {type: 'default'}}},
						data:[1320, 1132, 601, 234, 120, 90, 20]
					}
				]
			};
			
			evm.bar4.options = {
				tooltip : {
					trigger: 'axis',
					axisPointer : {            
						type : 'shadow'
					}
				},
				legend: {
					data:['Direct', 'Email','Partner','Video Ads','Search']
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
				xAxis : [
					{
						type : 'value'
					}
				],
				yAxis : [
					{
						type : 'category',
						data : ['Mon.','Tue.','Wed.','Thu.','Fri.','Sat.','Sun.']
					}
				],
				series : [
					{
						name:'Direct',
						type:'bar',
						stack: 'Sum',
						itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
						data:[320, 302, 301, 334, 390, 330, 320]
					},
					{
						name:'Email',
						type:'bar',
						stack: 'Sum',
						itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
						data:[120, 132, 101, 134, 90, 230, 210]
					},
					{
						name:'Partner',
						type:'bar',
						stack: 'Sum',
						itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
						data:[220, 182, 191, 234, 290, 330, 310]
					},
					{
						name:'Video Ads',
						type:'bar',
						stack: 'Sum',
						itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
						data:[150, 212, 201, 154, 190, 330, 410]
					},
					{
						name:'Search',
						type:'bar',
						stack: 'Sum',
						itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
						data:[820, 832, 901, 934, 1290, 1330, 1320]
					}
				]
			};
	
			evm.pie1.options = {
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
					data:['Direct','Email','Partner','Video Ads','Search']
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
							{value:335, name:'Direct'},
							{value:310, name:'Email'},
							{value:234, name:'Partner'},
							{value:135, name:'Video Ads'},
							{value:1548, name:'Search'}
						]
					}
				]
			};
			
			function random(){
				var r = Math.round(Math.random() * 100);
				return (r * (r % 2 == 0 ? 1 : -1));
			}
			
			function randomDataArray() {
				var d = [];
				var len = 100;
				while (len--) {
					d.push([
						random(),
						random(),
						Math.abs(random()),
					]);
				}
				return d;
			}  			
	
			evm.scatter2.options = {
				tooltip : {
					trigger: 'axis',
					showDelay : 0,
					axisPointer:{
						show: true,
						type : 'cross',
						lineStyle: {
							type : 'dashed',
							width : 1
						}
					}
				},
				legend: {
					data:['scatter1','scatter2']
				},
				toolbox: {
					show : true,
					feature : {
						dataView : {show: true, readOnly: false, title: "data",  lang:['Data View', 'close', 'refresh']},						
						restore : {show: true, title: "restore"},
						saveAsImage : {show: true, title: "save as image"}
					}
				},
				xAxis : [
					{
						type : 'value',
						splitNumber: 4,
						scale: true
					}
				],
				yAxis : [
					{
						type : 'value',
						splitNumber: 4,
						scale: true
					}
				],
				series : [
					{
						name:'scatter1',
						type:'scatter',
						symbolSize: function (value){
							return Math.round(value[2] / 5);
						},
						data: randomDataArray()
					},
					{
						name:'scatter2',
						type:'scatter',
						symbolSize: function (value){
							return Math.round(value[2] / 5);
						},
						data: randomDataArray()
					}
				]
			};
	
			evm.chord1.options = {
				title : {
					text: 'Test Data',
					subtext: 'From Taz & Wikipedia',
					x:'right',
					y:'bottom'
				},
				tooltip : {
					trigger: 'item',
					formatter: function (params) {
						if (params.indicator2) { // is edge
							return params.value.weight;
						} else {// is node
							return params.name
						}
					}
				},
				toolbox: {
					show : true,
					feature : {
						restore : {show: true, title: "restore"},
						saveAsImage : {show: true, title: "save as image"}
					}
				},
				legend: {
					x: 'left',
					data:['group1','group2', 'group3', 'group4']
				},
				series : [
					{
						type:'chord',
						sort : 'ascending',
						sortSub : 'descending',
						showScale : true,
						showScaleText : true,
						data : [
							{name : 'group1'},
							{name : 'group2'},
							{name : 'group3'},
							{name : 'group4'}
						],
						itemStyle : {
							normal : {
								label : {
									show : false
								}
							}
						},
						matrix : [
							[11975,  5871, 8916, 2868],
							[ 1951, 10048, 2060, 6171],
							[ 8010, 16145, 8090, 8045],
							[ 1013,   990,  940, 6907]
						]
					}
				]
			};
			
			evm.combo.options = {
				tooltip : {
					trigger: 'axis'
				},
				toolbox: {
					show : true,
					feature : {
						dataView : {show: true, readOnly: false, title: "data",  lang:['Data View', 'close', 'refresh']},
						magicType: {show: true, type: ['line', 'bar'], title: { line : 'line', bar : 'bar'}},
						restore : {show: true, title: "restore"},
						saveAsImage : {show: true, title: "save as image"}
					}
				},
				calculable : true,
				legend: {
					data:['Evaporation', 'Precipitation', 'Average Temperature']
				},
				xAxis : [
					{
						type : 'category',
						data : ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
					}
				],
				yAxis : [
					{
						type : 'value',
						name : 'Water Volume',
						axisLabel : {
							formatter: '{value} ml'
						}
					},
					{
						type : 'value',
						name : 'Temperature',
						axisLabel : {
							formatter: '{value} °C'
						}
					}
				],
				series : [

					{
						name:'Evaporation',
						type:'bar',
						data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
					},
					{
						name:'Precipitation',
						type:'bar',
						data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
					},
					{
						name:'Average Temperature',
						type:'line',
						yAxisIndex: 1,
						data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
					}
				]
			};
                   			
//
    }]);  
})(); 
