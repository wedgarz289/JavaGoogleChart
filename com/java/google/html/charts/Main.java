package com.java.google.html.charts;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args) {

    String optionChart = "";

    GoogleCharts charts                = new GoogleCharts();

    String width  = "500";
    String height = "400";

    Map <String,Integer> data_pieChart = new HashMap<String,Integer>();
    data_pieChart.put("'Mushrooms'",1);
    data_pieChart.put("'Onions'"   ,1);
    data_pieChart.put("'Olives'"   ,2);
    data_pieChart.put("'Zucchini'" ,2);
    data_pieChart.put("'Pepperoni'",1);


    // tamaño de la matriz de subplots
    charts.sizeMatrixSubplots(2,3);

    // posicion primera grafica Pie Chart
    charts.subplots(1,1);
    optionChart = "'title':'How Much Pizza I Ate Last Night',\n" +
                  "                    width :" + width  + ",\n" +
                  "                    height:" + height + "";

    charts.setDataOfChart(data_pieChart, new String[]{"'Flavor'","'Count'"});
    charts.plot(GoogleCharts.PIE_CHART,optionChart);

    // segunda grafica
    double[][] data_barChart = {
       {3237.3  , 4792.2  , 4074.3  , 4444.1 },
       {6346.3  , 4685.6  , 3903    , 3787.7 },
       {4599.6  , 5285.1  , 5349.9  , 7521.9 },
       {4192.6  , 5929.4  , 4470.2  , 6673.7 },
       {4880.5  , 5560.8  , 4031.9  , 7015.5 }
    };
    charts.subplots(1,2);
    optionChart = "title: 'Seasons',\n" +
                  "                    legend : { position: 'none' },\n" +
                  "                    width :" + width  + ",\n" +
                  "                    height:" + height + "," +
                  "                    chartArea: { width: 300 }";
    charts.setDataOfChart(data_barChart,new String[]{"'Winter'", "'Spring'", "'Summer'", "'Fall'"});
    charts.plot(GoogleCharts.COLUMN_CHART,optionChart);

    // tercera grafica
    ArrayList<DataArray> data_lineChart = new ArrayList<DataArray>();
    // columna 1
    data_lineChart.add(new DataArray<String>(new String[]{"'2004'","'2005'","'2006'","'2007'"}));
    // columna 2
    data_lineChart.add(new DataArray<Integer>(new Integer[]{1000, 1170, 660 , 1030 }));
    // columna 3
    data_lineChart.add(new DataArray<Integer>(new Integer[]{400,  460 , 1120,  540 }));
    charts.subplots(1,3);
    optionChart = "title: 'Company Performance',\n" +
                  "                    curveType: 'function',\n" +
                  "                    legend: { position: 'bottom' },\n" +
                  "                    width :" + width  + ",\n" +
                  "                    height:" + height + ",\n" +
                  "                    crosshair: {color: '#000',trigger: 'selection'}";
    charts.setDataOfChart(data_lineChart,new String[]{"'Year'", "'Sales'", "'Expenses'"});
    charts.plot(GoogleCharts.LINE_CHART,optionChart);

    // cuarta grafica
    double[][] data_scatterChart = {
      {0, 0, 67},  {1, 1, 88},   {2, 2, 77},
      {3, 3, 93},  {4, 4, 85},   {5, 5, 91},
      {6, 6, 71},  {7, 7, 78},   {8, 8, 93},
      {9, 9, 80},  {10, 10, 82}, {11, 0, 75},
      {12, 5, 80}, {13, 3, 90},  {14, 1, 72},
      {15, 5, 75}, {16, 6, 68},  {17, 7, 98},
      {18, 3, 82}, {19, 9, 94},  {20, 2, 79},
      {21, 2, 95}, {22, 2, 86},  {23, 3, 67},
      {24, 4, 60}, {25, 2, 80},  {26, 6, 92},
      {27, 2, 81}, {28, 8, 79},  {29, 9, 83}
    };
    charts.subplots(2,1);
    optionChart = "'title':'Students\\' Final Grades - based on hours studied',\n" +
                  "                    width :" + width  + ",\n" +
                  "                    height:" + height + ",\n" +
                  "                    series: {0: {targetAxisIndex: 0},1: {targetAxisIndex: 1}},\n" +
                  "                    vAxes: {\n" +
                  "                            // Adds titles to each axis.\n" +
                  "                             0: {title: 'Hours Studied'},\n" +
                  "                             1: {title: 'Final Exam Grade'}\n" +
                  "                            }\n";
    charts.setDataOfChart(data_scatterChart,new String[]{"'Student ID'","'Hours Studied'","'Final'"});
    charts.plot(GoogleCharts.SCATTER_CHART,optionChart);

    // quinta grafica
    ArrayList<DataArray> data_bubbleChart = new ArrayList<DataArray>();
    data_bubbleChart.add(new DataArray<String>(new String[]{"'CAN'","'DEU'","'DNK'","'EGY'","'GBR'","'IRN'","'IRQ'","'ISR'","'RUS'","'USA'"}));
    data_bubbleChart.add(new DataArray<Double>(new Double[]{80.66,79.84,78.6, 72.73,80.05,72.49,68.09,81.55,68.6,78.09}));
    data_bubbleChart.add(new DataArray<Double>(new Double[]{1.67,1.36,1.84,2.78,2.0,1.7, 4.77,2.96,1.54,2.05}));
    data_bubbleChart.add(new DataArray<String>(new String[]{"'North America'","'Europe'","'Europe'","'Middle East'","'Europe'",
                                                            "'Middle East'","'Middle East'","'Middle East'","'Europe'","'North America'"}));
    data_bubbleChart.add(new DataArray<Integer>(new Integer[]{33739900,81902307,5523095,79716203,61801570,73137148,31090763,7485600,141850000,307007000}));

    charts.subplots(2,2);
    optionChart = "title: 'Fertility rate vs life expectancy in selected countries (2010).' +\n" +
                  "                    ' X=Life Expectancy, Y=Fertility, Bubble size=Population, Bubble color=Region',\n" +
                  "                     width :" + width  + ",\n" +
                  "                     height:" + height + ",\n" +
                  "                     hAxis: {title: 'Life Expectancy'},\n" +
                  "                     vAxis: {title: 'Fertility Rate'},\n" +
                  "                     bubble: {textStyle: {fontSize: 11}}\n";
    charts.setDataOfChart(data_bubbleChart,new String[]{"'ID'","'Life Expectancy'","'Fertility Rate'","'Region'","'Population'"});
    charts.plot(GoogleCharts.BUBBLE_CHART,optionChart);

    // sexta grafica
    ArrayList<DataArray> data_areaChart = new ArrayList<DataArray>();
    data_areaChart.add(new DataArray<String>(new String[]{"'2013'","'2014'","'2015'","'2016'"}));
    data_areaChart.add(new DataArray<Integer>(new Integer[]{1000,1170,660,1030}));
    data_areaChart.add(new DataArray<Integer>(new Integer[]{400,460,1120,540}));

    optionChart = "title: 'Company Performance',\n" +
                  "                     width :" + width  + ",\n" +
                  "                     height:" + height + ",\n" +
                  "                     hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},\n" +
                  "                     vAxis: {minValue: 0}\n";
    charts.subplots(2,3);
    charts.setDataOfChart(data_areaChart,new String[]{"'Year'", "'Sales'", "'Expenses'"});
    charts.plot(GoogleCharts.AREA_CHART,optionChart);


    charts.create("index.html");



    // test
    DataArray<String> col_1 = new DataArray<String>();
    col_1.setData(new String[]{"2005","2006","2007"});
    // col_1.setDataString(new String[]{"2005","2006","2007"});
    DataArray<Double> col_2 = new DataArray<Double>();
    col_2.setData(new Double[]{1.2,1.3,1.4});

    DataArray<Integer> col_3 = new DataArray<Integer>();
    col_3.setData(new Integer[]{1,2,3});

    ArrayList<DataArray> list = new ArrayList<DataArray>();
    list.add(col_1);
    list.add(col_2);
    list.add(col_3);

    charts.printData(list);
  }
}
