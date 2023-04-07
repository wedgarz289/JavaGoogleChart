package com.java.google.html.charts;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args) {

    String optionChart = "";

    GoogleCharts charts                = new GoogleCharts();
    Map <String,Integer> data_pieChart = new HashMap<String,Integer>();
    // Map <String,Double>  data_barChart = new HashMap<String,Double>();

    String width  = "500";
    String height = "400";

    data_pieChart.put("Mushrooms",1);
    data_pieChart.put("Onions"   ,1);
    data_pieChart.put("Olives"   ,2);
    data_pieChart.put("Zucchini" ,2);
    data_pieChart.put("Pepperoni",1);

    // data_barChart.put("Acrocanthosaurus (top-spined lizard)", 12.2);
    // data_barChart.put("Albertosaurus (Alberta lizard)", 9.1);
    // data_barChart.put("Allosaurus (other lizard)", 12.2);
    // data_barChart.put("Apatosaurus (deceptive lizard)", 22.9);
    // data_barChart.put("Archaeopteryx (ancient wing)", 0.9);
    // data_barChart.put("Argentinosaurus (Argentina lizard)", 36.6);
    // data_barChart.put("Baryonyx (heavy claws)", 9.1);
    // data_barChart.put("Brachiosaurus (arm lizard)", 30.5);
    // data_barChart.put("Ceratosaurus (horned lizard)", 6.1);
    // data_barChart.put("Coelophysis (hollow form)", 2.7);
    // data_barChart.put("Compsognathus (elegant jaw)", 0.9);
    // data_barChart.put("Deinonychus (terrible claw)", 2.7);
    // data_barChart.put("Diplodocus (double beam)", 27.1);
    // data_barChart.put("Dromicelomimus (emu mimic)", 3.4);
    // data_barChart.put("Gallimimus (fowl mimic)", 5.5);
    // data_barChart.put("Mamenchisaurus (Mamenchi lizard)", 21.0);
    // data_barChart.put("Megalosaurus (big lizard)", 7.9);
    // data_barChart.put("Microvenator (small hunter)", 1.2);
    // data_barChart.put("Ornithomimus (bird mimic)", 4.6);
    // data_barChart.put("Oviraptor (egg robber)", 1.5);
    // data_barChart.put("Plateosaurus (flat lizard)", 7.9);
    // data_barChart.put("Sauronithoides (narrow-clawed lizard)", 2.0);
    // data_barChart.put("Seismosaurus (tremor lizard)", 45.7);
    // data_barChart.put("Spinosaurus (spiny lizard)", 12.2);
    // data_barChart.put("Supersaurus (super lizard)", 30.5);
    // data_barChart.put("Tyrannosaurus (tyrant lizard)", 15.2);
    // data_barChart.put("Ultrasaurus (ultra lizard)", 30.5);
    // data_barChart.put("Velociraptor (swift robber)", 1.0);

    double[][] data_barChart = {
       {3237.3  , 4792.2  , 4074.3  , 4444.1 },
       {6346.3  , 4685.6  , 3903    , 3787.7 },
       {4599.6  , 5285.1  , 5349.9  , 7521.9 },
       {4192.6  , 5929.4  , 4470.2  , 6673.7 },
       {4880.5  , 5560.8  , 4031.9  , 7015.5 }
    };
    String[] data_barChart_label    ={"Winter", "Spring", "Summer", "Fall"};

    charts.sizeMatrixSubplots(2,3);
    charts.subplots(1,1);
    optionChart = "'title':'How Much Pizza I Ate Last Night',\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + "";
    charts.setOptionChart(optionChart);
    charts.PieChart(data_pieChart);

    charts.subplots(1,2);
    // optionChart = "title: 'Lengths of dinosaurs, in meters',\n" +
    //               "                    legend : { position: 'none' },\n" +
    //               "                    'width' :" + width  + ",\n" +
    //               "                    'height':" + height + "," +
    //               "                    chartArea: { width: 300 }";

    optionChart = "title: 'Seasons',\n" +
                  "                    legend : { position: 'none' },\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + "," +
                  "                    chartArea: { width: 300 }";

    charts.setOptionChart(optionChart);
    // charts.BarChart(data_barChart,"Dinosaur","Length");
    charts.BarChart(data_barChart,data_barChart_label);

    // double[][] data_lineChart = {
    //   {0 , 0, 0  }, {1, 10, 5  }, {2 , 23, 15}, {3 , 17, 9} , {4, 18, 10 }, {5, 9, 5   },
    //   {6 , 11, 3 }, {7, 27, 19 }, {8 , 33, 25}, {9 , 40, 32}, {10, 32, 24}, {11, 35, 27},
    //   {12, 30, 22}, {13, 40, 32}, {14, 42, 34}, {15, 47, 39}, {16, 44, 36}, {17, 48, 40},
    //   {18, 52, 44}, {19, 54, 46}, {20, 42, 34}, {21, 55, 47}, {22, 56, 48}, {23, 57, 49},
    //   {24, 60, 52}, {25, 50, 42}, {26, 52, 44}, {27, 51, 43}, {28, 49, 41}, {29, 53, 45},
    //   {30, 55, 47}, {31, 60, 52}, {32, 61, 53}, {33, 59, 51}, {34, 62, 54}, {35, 65, 57},
    //   {36, 62, 54}, {37, 58, 50}, {38, 55, 47}, {39, 61, 53}, {40, 64, 56}, {41, 65, 57},
    //   {42, 63, 55}, {43, 66, 58}, {44, 67, 59}, {45, 69, 61}, {46, 69, 61}, {47, 70, 62},
    //   {48, 72, 64}, {49, 68, 60}, {50, 66, 58}, {51, 65, 57}, {52, 67, 59}, {53, 70, 62},
    //   {54, 71, 63}, {55, 72, 64}, {56, 73, 65}, {57, 75, 67}, {58, 70, 62}, {59, 68, 60},
    //   {60, 64, 56}, {61, 60, 52}, {62, 65, 57}, {63, 67, 59}, {64, 68, 60}, {65, 69, 61},
    //   {66, 70, 62}, {67, 72, 64}, {68, 75, 67}, {69, 80, 72}
    // };
    // String[] template  = {"x","Dogs","Cat"};
    // String[] type_data = {"number","number","number"};

    double[][] data_lineChart = {
      {1000, 400 },
      {1170, 460 },
      {660 , 1120},
      {1030, 540 }
    };
    String[] column_1  = {"2004","2005","2006","2007"};

    String[] template  = {"Year", "Sales", "Expenses"};
    optionChart = "title: 'Company Performance',\n" +
                  "                    curveType: 'function',\n" +
                  "                    legend: { position: 'bottom' },\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + ",\n" +
                  "                    crosshair: {color: '#000',trigger: 'selection'}";

    charts.subplots(1,3);
    charts.setOptionChart(optionChart);
    charts.LineChart(column_1,data_lineChart,template);


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
    String[] table_label = {"Student ID","Hours Studied","Final"};
    optionChart = "'title':'Students\\' Final Grades - based on hours studied',\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + ",\n" +
                  "                    series: {0: {targetAxisIndex: 0},1: {targetAxisIndex: 1}},\n" +
                  "                    vAxes: {\n" +
                  "                            // Adds titles to each axis.\n" +
                  "                             0: {title: 'Hours Studied'},\n" +
                  "                             1: {title: 'Final Exam Grade'}\n" +
                  "                            }\n";
    charts.subplots(2,1);
    charts.setOptionChart(optionChart);
    charts.ScatterChart(data_scatterChart,table_label);

    String data_bubbleChart = "" +
    "    ['ID', 'Life Expectancy', 'Fertility Rate', 'Region',     'Population'],\n" +
    "    ['CAN',    80.66,              1.67,      'North America',  33739900],\n" +
    "    ['DEU',    79.84,              1.36,      'Europe',         81902307],\n" +
    "    ['DNK',    78.6,               1.84,      'Europe',         5523095],\n" +
    "    ['EGY',    72.73,              2.78,      'Middle East',    79716203],\n" +
    "    ['GBR',    80.05,              2,         'Europe',         61801570],\n" +
    "    ['IRN',    72.49,              1.7,       'Middle East',    73137148],\n" +
    "    ['IRQ',    68.09,              4.77,      'Middle East',    31090763],\n" +
    "    ['ISR',    81.55,              2.96,      'Middle East',    7485600],\n" +
    "    ['RUS',    68.6,               1.54,      'Europe',         141850000],\n" +
    "    ['USA',    78.09,              2.05,      'North America',  307007000]\n";
    optionChart = "title: 'Fertility rate vs life expectancy in selected countries (2010).' +\n" +
                  "                    ' X=Life Expectancy, Y=Fertility, Bubble size=Population, Bubble color=Region',\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + ",\n" +
                  "                     hAxis: {title: 'Life Expectancy'},\n" +
                  "                     vAxis: {title: 'Fertility Rate'},\n" +
                  "                     bubble: {textStyle: {fontSize: 11}}\n";
    charts.subplots(2,2);
    charts.setOptionChart(optionChart);
    charts.BubbleChart(data_bubbleChart);

    String[] areaChart_column_1 = {"2013","2014","2015","2016"};
    double[][] data_areaChart = {
       {1000,      400 },
       {1170,      460 },
       {660,       1120},
       {1030,      540 }
    };
    String[] areaChart_table_label = {"'Year'", "'Sales'", "'Expenses'"};
    optionChart = "title: 'Company Performance',\n" +
                  "                    'width' :" + width  + ",\n" +
                  "                    'height':" + height + ",\n" +
                  "                     hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},\n" +
                  "                     vAxis: {minValue: 0}\n";
    charts.subplots(2,3);
    charts.setOptionChart(optionChart);
    charts.AreaChart(areaChart_column_1,data_areaChart,areaChart_table_label);

    charts.create();



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
    
    int size = list.get(0).getData().length;
    for (int row = 0; row<size; row++) {
      for (int col = 0; col<list.size(); col++) {
        System.out.print(list.get(col).getData()[row] + " ");
      }
      System.out.println("");
    }

  }
}
