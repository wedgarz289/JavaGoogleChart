    // -------- add this in your html file --------
    // <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    // <script type="text/javascript" src="myChart.js"></script>
    // --------------------------------------------
    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});
    // Draw the pie chart for drawChart_1 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_1);
    // Draw the pie chart for drawChart_2 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_2);
    // Draw the pie chart for drawChart_3 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_3);
    // Draw the pie chart for drawChart_4 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_4);
    // Draw the pie chart for drawChart_5 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_5);
    // Draw the pie chart for drawChart_6 when Charts is loaded.
    google.charts.setOnLoadCallback(drawChart_6);
    // Callback that draws the pie chart for drawChart_1.
    function drawChart_1(){
     // Create the data table for drawChart_1.
     var data = new google.visualization.arrayToDataTable([
       ['Flavor','Count'],
       ['Zucchini',2],
       ['Onions',1],
       ['Olives',2],
       ['Pepperoni',1],
       ['Mushrooms',1]
     ]);
     // Set chart options
     var options = {'title':'How Much Pizza I Ate Last Night',
                    width :500,
                    height:400};
     // Instantiate and draw the chart for drawChart_1.
     var chart = new google.visualization.PieChart(document.getElementById('drawChart_div_1'));
     chart.draw(data,options);
    }
    // Callback that draws the pie chart for drawChart_2.
    function drawChart_2(){
     // Create the data table for drawChart_2.
     var data = new google.visualization.arrayToDataTable([
       ['Winter','Spring','Summer','Fall'],
       [3237.3,4792.2,4074.3,4444.1],
       [6346.3,4685.6,3903.0,3787.7],
       [4599.6,5285.1,5349.9,7521.9],
       [4192.6,5929.4,4470.2,6673.7],
       [4880.5,5560.8,4031.9,7015.5]
     ]);
     // Set chart options
     var options = {title: 'Seasons',
                    legend : { position: 'none' },
                    width :500,
                    height:400,                    chartArea: { width: 300 }};
     // Instantiate and draw the chart for drawChart_2.
     var chart = new google.visualization.ColumnChart(document.getElementById('drawChart_div_2'));
     chart.draw(data,options);
    }
    // Callback that draws the pie chart for drawChart_3.
    function drawChart_3(){
     // Create the data table for drawChart_3.
     var data = new google.visualization.arrayToDataTable([
       ['Year','Sales','Expenses'],
       ['2004',1000,400],
       ['2005',1170,460],
       ['2006',660,1120],
       ['2007',1030,540]
     ]);
     // Set chart options
     var options = {title: 'Company Performance',
                    curveType: 'function',
                    legend: { position: 'bottom' },
                    width :500,
                    height:400,
                    crosshair: {color: '#000',trigger: 'selection'}};
     // Instantiate and draw the chart for drawChart_3.
     var chart = new google.visualization.LineChart(document.getElementById('drawChart_div_3'));
     chart.draw(data,options);
    }
    // Callback that draws the pie chart for drawChart_4.
    function drawChart_4(){
     // Create the data table for drawChart_4.
     var data = new google.visualization.arrayToDataTable([
       ['Student ID','Hours Studied','Final'],
       [0.0,0.0,67.0],
       [1.0,1.0,88.0],
       [2.0,2.0,77.0],
       [3.0,3.0,93.0],
       [4.0,4.0,85.0],
       [5.0,5.0,91.0],
       [6.0,6.0,71.0],
       [7.0,7.0,78.0],
       [8.0,8.0,93.0],
       [9.0,9.0,80.0],
       [10.0,10.0,82.0],
       [11.0,0.0,75.0],
       [12.0,5.0,80.0],
       [13.0,3.0,90.0],
       [14.0,1.0,72.0],
       [15.0,5.0,75.0],
       [16.0,6.0,68.0],
       [17.0,7.0,98.0],
       [18.0,3.0,82.0],
       [19.0,9.0,94.0],
       [20.0,2.0,79.0],
       [21.0,2.0,95.0],
       [22.0,2.0,86.0],
       [23.0,3.0,67.0],
       [24.0,4.0,60.0],
       [25.0,2.0,80.0],
       [26.0,6.0,92.0],
       [27.0,2.0,81.0],
       [28.0,8.0,79.0],
       [29.0,9.0,83.0]
     ]);
     // Set chart options
     var options = {'title':'Students\' Final Grades - based on hours studied',
                    width :500,
                    height:400,
                    series: {0: {targetAxisIndex: 0},1: {targetAxisIndex: 1}},
                    vAxes: {
                            // Adds titles to each axis.
                             0: {title: 'Hours Studied'},
                             1: {title: 'Final Exam Grade'}
                            }
};
     // Instantiate and draw the chart for drawChart_4.
     var chart = new google.visualization.ScatterChart(document.getElementById('drawChart_div_4'));
     chart.draw(data,options);
    }
    // Callback that draws the pie chart for drawChart_5.
    function drawChart_5(){
     // Create the data table for drawChart_5.
     var data = new google.visualization.arrayToDataTable([
       ['ID','Life Expectancy','Fertility Rate','Region','Population'],
       ['CAN',80.66,1.67,'North America',33739900],
       ['DEU',79.84,1.36,'Europe',81902307],
       ['DNK',78.6,1.84,'Europe',5523095],
       ['EGY',72.73,2.78,'Middle East',79716203],
       ['GBR',80.05,2.0,'Europe',61801570],
       ['IRN',72.49,1.7,'Middle East',73137148],
       ['IRQ',68.09,4.77,'Middle East',31090763],
       ['ISR',81.55,2.96,'Middle East',7485600],
       ['RUS',68.6,1.54,'Europe',141850000],
       ['USA',78.09,2.05,'North America',307007000]
     ]);
     // Set chart options
     var options = {title: 'Fertility rate vs life expectancy in selected countries (2010).' +
                    ' X=Life Expectancy, Y=Fertility, Bubble size=Population, Bubble color=Region',
                     width :500,
                     height:400,
                     hAxis: {title: 'Life Expectancy'},
                     vAxis: {title: 'Fertility Rate'},
                     bubble: {textStyle: {fontSize: 11}}
};
     // Instantiate and draw the chart for drawChart_5.
     var chart = new google.visualization.BubbleChart(document.getElementById('drawChart_div_5'));
     chart.draw(data,options);
    }
    // Callback that draws the pie chart for drawChart_6.
    function drawChart_6(){
     // Create the data table for drawChart_6.
     var data = new google.visualization.arrayToDataTable([
       ['Year','Sales','Expenses'],
       ['2013',1000,400],
       ['2014',1170,460],
       ['2015',660,1120],
       ['2016',1030,540]
     ]);
     // Set chart options
     var options = {title: 'Company Performance',
                     width :500,
                     height:400,
                     hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
                     vAxis: {minValue: 0}
};
     // Instantiate and draw the chart for drawChart_6.
     var chart = new google.visualization.AreaChart(document.getElementById('drawChart_div_6'));
     chart.draw(data,options);
    }
