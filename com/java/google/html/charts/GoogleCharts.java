package com.java.google.html.charts;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GoogleCharts
{
  private String html_text; // texto html y texto javascript
  private String chartScriptText; // instrucciones javascript para crear las graficas
  private String drawChartText; // instrucciones javascript para dibbujar las graficas
  private String functionsChartText; // funciones para crear las graficas
  private String optionChart; // texto de opciones para la grafica
  private String tableHtmlText; // texto para crear la tabla en html
  private String tableJavaScript; // creea la tabla en lenguaje javascript
  private String subplot_matrix[][]; // matriz para gener la tabla html para comolar las graficas
  private String type_chart; // tipo de grafica
  private String func_name; // nombre de la funcion en javascript
  private String id_element; // identificador para html
  private int    count_charts;  //contador de graficas
  private int    rows,cols;    // dimension de la matriz para los subplots

  // Constantes
  public static final String PIE_CHART     = "PieChart";
  public static final String COLUMN_CHART  = "ColumnChart";
  public static final String LINE_CHART    = "LineChart";
  public static final String SCATTER_CHART = "ScatterChart";
  public static final String BUBBLE_CHART  = "BubbleChart";
  public static final String AREA_CHART    = "AreaChart";

  public GoogleCharts()
  {
    this.html_text          = "";
    this.chartScriptText    = "";
    this.drawChartText      = "";
    this.functionsChartText = "";
    this.optionChart        = "";
    this.tableHtmlText      = "";
    this.tableJavaScript    = "";
    this.func_name          = "";
    this.id_element         = "";
    this.count_charts       = 1;
    this.rows               = 0;
    this.cols               = 0;
  }

  public void printData(ArrayList<DataArray> data)
  {
    int size_row = data.get(0).getData().length;
    int size_col = data.size();
    for (int row = 0; row<size_row; row++) {
      for (int col = 0; col<size_col; col++) {
        System.out.print(data.get(col).getData()[row] + " ");
      }
      System.out.println("");
    }
  }
  private void writeHTML()
  {
    try {
      FileWriter file_html = new FileWriter("index.html");
      file_html.write(this.html_text);
      file_html.close();
    } catch(IOException e) {
      System.out.println("Error:");
      e.printStackTrace();
    }
  }

  private void createTableHTML()
  {
    this.tableHtmlText = this.tableHtmlText +
                         "    <!--Table and divs that hold the pie charts-->\n" +
                         "    <table class=\"subplots\">\n";
    for (int i = 0; i<this.rows; i++) {
      this.tableHtmlText = this.tableHtmlText + "     <tr>\n";
      for (int j = 0; j<this.cols; j++)
      {
        if (!(this.subplot_matrix[i][j]).equals(""))
        {
          this.tableHtmlText = this.tableHtmlText +
          "       <td><div id=\"" + this.subplot_matrix[i][j] + "\" style=\"border: 1px solid #ccc\"></div></td>\n";
        }
        else
        {
          this.tableHtmlText = this.tableHtmlText +
          "       <td><div style=\"border: 1px solid #ccc\"></div></td>\n";
        }
      }
      this.tableHtmlText = this.tableHtmlText + "     </tr>\n";
    }
    this.tableHtmlText = this.tableHtmlText + "    </table>\n";
  }


  private void generateCodeChartJavaScript()
  {
    this.drawChartText      = this.drawChartText +
                              "    // Draw the pie chart for " + this.func_name + " when Charts is loaded.\n" +
                              "    google.charts.setOnLoadCallback(" + this.func_name + ");\n";

    this.functionsChartText = this.functionsChartText +
                              "    // Callback that draws the pie chart for " + this.func_name +  ".\n" +
                              "    function " + this.func_name + "(){\n"  +
                              "     // Create the data table for " + this.func_name +  ".\n" +
                              "     var data = new google.visualization.arrayToDataTable([\n";

    this.functionsChartText = this.functionsChartText +
                              this.tableJavaScript    +
                              "     ]);\n";

    if (!this.optionChart.equals("")) {this.functionsChartText = this.functionsChartText + this.optionChart;}
    else{this.functionsChartText = this.functionsChartText +
                                   "     // Set chart options\n" +
                                   "     var options = {};\n";
        }

    this.functionsChartText = this.functionsChartText +
      "     // Instantiate and draw the chart for " + this.func_name +  ".\n" +
      "     var chart = new google.visualization." + this.type_chart + "(document.getElementById('" + this.id_element + "'));\n" +
      "     chart.draw(data,options);\n" +
      "    }\n";
  }

  public void sizeMatrixSubplots(int rows, int cols)
  {
    this.rows = rows;
    this.cols = cols;
    this.subplot_matrix = new String[rows][cols];
    for (int i = 0; i<rows; i++) {
      for (int j = 0; j<cols; j++) {
        this.subplot_matrix[i][j] = "";
      }
    }
  }

  public void subplots(int n_rows, int n_cols)
  {
    this.subplot_matrix[n_rows-1][n_cols-1] = "drawChart_div_" + String.valueOf(this.count_charts);
  }

  public void setDataOfChart(Map<String,Integer> xy,String[] column_labels)
  {
    int count = 0;
    this.tableJavaScript = this.tableJavaScript +
                          "       [" + String.join(",",column_labels) + "],\n";
    for (Map.Entry map : xy.entrySet() )
    {
      if (count == (xy.size() - 1)) {
        this.tableJavaScript = this.tableJavaScript + "       [" + map.getKey() + "," + String.valueOf(map.getValue()) + "]\n";
      }
      else{
        this.tableJavaScript = this.tableJavaScript + "       [" + map.getKey() + "," + String.valueOf(map.getValue()) + "],\n";
      }
      count++;
    }
  }

  public void setDataOfChart(double[][] table, String[] column_labels)
  {
    this.tableJavaScript = this.tableJavaScript +
                          "       [" + String.join(",",column_labels) + "],\n";
    for (int row = 0; row<table.length; row++) {
      this.tableJavaScript = this.tableJavaScript + "       [";
      for (int col = 0; col<table[row].length; col++) {
        if (col == (table[row].length - 1)){
          this.tableJavaScript = this.tableJavaScript + String.valueOf(table[row][col]);
        }
        else{
          this.tableJavaScript = this.tableJavaScript + String.valueOf(table[row][col]) + ",";
        }
      }
      if (row == (table.length - 1)) {
        this.tableJavaScript = this.tableJavaScript + "]\n";
      }
      else{
        this.tableJavaScript = this.tableJavaScript + "],\n";
      }
    }
  }

  public void setDataOfChart(ArrayList<DataArray> data, String[] column_labels)
  {
    this.tableJavaScript = this.tableJavaScript +
                          "       [" + String.join(",",column_labels) + "],\n";
    int size_row = data.get(0).getData().length;
    int size_col = data.size();
    for (int row = 0; row<size_row; row++) {
      this.tableJavaScript = this.tableJavaScript + "       [";
      for (int col = 0; col<size_col; col++) {
        if (!(data.get(col).getData()[row].getClass().equals(String.class)))
        {
          this.tableJavaScript = this.tableJavaScript + String.valueOf(data.get(col).getData()[row]);
        }
        else
        {
          this.tableJavaScript = this.tableJavaScript + data.get(col).getData()[row];
        }
        if (col < (size_col-1)) {
          this.tableJavaScript = this.tableJavaScript + ",";
        }
      }
      if (row < (size_row-1)) {
        this.tableJavaScript = this.tableJavaScript + "],\n";
      }
      else{
        this.tableJavaScript = this.tableJavaScript + "]\n";
      }
    }

  }

  public void plot(String type_chart,String option)
  {
    this.type_chart = type_chart;
    this.func_name  = "drawChart_" + String.valueOf(this.count_charts);
    this.id_element = "drawChart_div_" + String.valueOf(this.count_charts);
    this.optionChart = "     // Set chart options\n" +
                       "     var options = {" + option + "};\n";
    this.generateCodeChartJavaScript();
    this.count_charts++;
    this.func_name       = "";
    this.id_element      = "";
    this.optionChart     = "";
    this.tableJavaScript = "";
  }

  public void create()
  {
    this.html_text = "" +
    "<html>\n" +
    " <head>\n" +
    "  <!--Load the AJAX API-->\n" +
    "   <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
    "   <script type=\"text/javascript\">\n" +
    "    // Load the Visualization API and the corechart package.\n" +
    "    google.charts.load('current', {'packages':['corechart']});\n" +
    this.drawChartText +
    this.functionsChartText +
    "   </script>\n" +
    "  </head>\n" +
    "  <body>\n";
    if(this.count_charts == 2)
    {
      this.html_text = this.html_text +
      "    <!--Div that will hold the pie chart-->\n" +
      "    <div id=\"drawChart_div_1\"></div>\n";
    }
    else
    {
      this.createTableHTML();
      this.html_text = this.html_text + this.tableHtmlText;
    }
    this.html_text = this.html_text +
    "  </body>\n"+
    "</html>\n";

    // System.out.println(this.html_text);
    this.writeHTML();
    this.drawChartText      = "";
    this.functionsChartText = "";
    this.html_text          = "";
  }
}
