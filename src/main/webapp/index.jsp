<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/echarts.min.js"></script>
<script src="js/dark.js"></script>
<script src="js/jquery.min.js"></script>
<head>
    <title>访问数据实时访问</title>
    <style>
        #main{
            width: 400px;
            height: 400px;
        }
    </style>
</head>
<body style="background-color: rgb(51,51,51);">
<div id="main"></div>
</body>
<script>
	
    var chart1 = echarts.init(document.getElementById('main'),'dark');
   function go() {
	   $.get('/value.do').done(function (data) {
	    	 chart1.setOption({
	    	        tooltip : {
	    	            trigger: 'axis',
	    	            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	    	                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	    	            }
	    	        },
	    	        legend: {
	    	            data: ['其他平台', 'WP销售','京东访问','淘宝访问','天猫销售']
	    	        },
	    	        grid: {
	    	            left: '3%',
	    	            right: '4%',
	    	            bottom: '3%',
	    	            containLabel: true
	    	        },
	    	        xAxis:  {
	    	            type: 'value'
	    	        },
	    	        yAxis: {
	    	            type: 'category',
	    	            data: ['周一','周二','周三','周四','周五','周六','周日']
	    	        },
	    	        series: [
	    	            {
	    	                name: '其他平台',
	    	                type: 'bar',
	    	                stack: '总量',
	    	                label: {
	    	                    normal: {
	    	                        show: true,
	    	                        position: 'insideRight'
	    	                    }
	    	                },
	    	                data: data.count1
	    	            },
	    	            {
	    	                name: 'WP销售',
	    	                type: 'bar',
	    	                stack: '总量',
	    	                label: {
	    	                    normal: {
	    	                        show: true,
	    	                        position: 'insideRight'
	    	                    }
	    	                },
	    	                data: data.count2
	    	            },
	    	            {
	    	                name: '京东访问',
	    	                type: 'bar',
	    	                stack: '总量',
	    	                label: {
	    	                    normal: {
	    	                        show: true,
	    	                        position: 'insideRight'
	    	                    }
	    	                },
	    	                data: data.count3
	    	            },
	    	            {
	    	                name: '淘宝访问',
	    	                type: 'bar',
	    	                stack: '总量',
	    	                label: {
	    	                    normal: {
	    	                        show: true,
	    	                        position: 'insideRight'
	    	                    }
	    	                },
	    	                data: data.count4
	    	            },
	    	            {
	    	                name: '天猫销售',
	    	                type: 'bar',
	    	                stack: '总量',
	    	                label: {
	    	                    normal: {
	    	                        show: true,
	    	                        position: 'insideRight'
	    	                    }
	    	                },
	    	                data: data.count5
	    	            }
	    	        ]
	    	    });
		})
	}
   setInterval("go()","1000");
</script>
</html>
