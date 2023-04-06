package com.java.google.html.charts;

import java.util.Map;

public class GoogleLineChart
{
  private String chartScriptText; // instrucciones javascript para crear las graficas
  private String drawChartText; // instrucciones javascript para dibbujar las graficas
  private String functionsChartText; // funciones para crear las graficas
  private String optionChart; // texto de opciones para la grafica
  private String func_name; // nombre de la funcion en javascript
  private String id_element; // identificador para html
  public GoogleLineChart(String func_name, String id_element)
  {
    this.chartScriptText    = "";
    this.drawChartText      = "";
    this.functionsChartText = "";
    this.optionChart        = "";
    this.func_name          = func_name;
    this.id_element         = id_element;
  }

  public void setOptionLineChart(String option)
  {
    this.optionChart = "     // Set chart options\n" +
                       "     var options = {" + option + "};\n";
  }

  public void generateCodeLineChart(double[][] table,String[] table_label)
  {
    this.drawChartText      = this.drawChartText +
                              "    // Draw the pie chart for " + this.func_name + " when Charts is loaded.\n" +
                              "    google.charts.setOnLoadCallback(" + this.func_name + ");\n";

    this.functionsChartText = "    // Callback that draws the pie chart for " + this.func_name +  ".\n" +
                              "    function " + this.func_name + "(){\n"  +
                              "     // Create the data table for " + this.func_name +  ".\n" +
                              "     var data = new google.visualization.arrayToDataTable([";
    this.functionsChartText = this.functionsChartText + "       [";
    for (int col_label = 0; col_label<table_label.length; col_label++) {
      if (col_label == (table_label.length - 1)){
        this.functionsChartText = this.functionsChartText + "\"" + table_label[col_label] + "\"";
      }
      else{
        this.functionsChartText = this.functionsChartText + "\"" + table_label[col_label] + "\"" + ",";
      }
    }
    this.functionsChartText = this.functionsChartText + "],\n";
    for (int row = 0; row<table.length; row++) {
      this.functionsChartText = this.functionsChartText + "       [";
      for (int col = 0; col<table[row].length; col++) {
        if (col == (table[row].length - 1)){
          this.functionsChartText = this.functionsChartText + String.valueOf(table[row][col]);
        }
        else{
          this.functionsChartText = this.functionsChartText + String.valueOf(table[row][col]) + ",";
        }
      }
      if (row == (table.length - 1)) {
        this.functionsChartText = this.functionsChartText + "]\n";
      }
      else{
        this.functionsChartText = this.functionsChartText + "],\n";
      }
    }
    this.functionsChartText = this.functionsChartText + "]);\n";

    if (!this.optionChart.equals("")) {this.functionsChartText = this.functionsChartText + this.optionChart;}
    else{this.functionsChartText = this.functionsChartText +
                                   "     // Set chart options\n" +
                                   "     var options = {};\n";
        }

    this.functionsChartText = this.functionsChartText +
      "     // Instantiate and draw the chart for " + this.func_name +  ".\n" +
      "     var chart = new google.visualization.LineChart(document.getElementById('" + this.id_element + "'));\n" +
      "     chart.draw(data,options);\n" +
      "    }\n";
  }
  public void generateCodeLineChart(String[] column_1,double[][] table,String[] table_label)
  {
    this.drawChartText      = this.drawChartText +
                              "    // Draw the pie chart for " + this.func_name + " when Charts is loaded.\n" +
                              "    google.charts.setOnLoadCallback(" + this.func_name + ");\n";

    this.functionsChartText = "    // Callback that draws the pie chart for " + this.func_name +  ".\n" +
                              "    function " + this.func_name + "(){\n"  +
                              "     // Create the data table for " + this.func_name +  ".\n" +
                              "     var data = new google.visualization.arrayToDataTable([\n";
    this.functionsChartText = this.functionsChartText + "       [";
    for (int col_label = 0; col_label<table_label.length; col_label++) {
      if (col_label == (table_label.length - 1)){
        this.functionsChartText = this.functionsChartText + "\"" + table_label[col_label] + "\"";
      }
      else{
        this.functionsChartText = this.functionsChartText + "\"" + table_label[col_label] + "\"" + ",";
      }
    }
    this.functionsChartText = this.functionsChartText + "],\n";
    for (int row = 0; row<table.length; row++) {
      this.functionsChartText = this.functionsChartText + "       [";
      this.functionsChartText = this.functionsChartText + "\"" + column_1[row] + "\",";
      for (int col = 0; col<table[row].length; col++) {
        if (col == (table[row].length - 1)){
          this.functionsChartText = this.functionsChartText + String.valueOf(table[row][col]);
        }
        else{
          this.functionsChartText = this.functionsChartText + String.valueOf(table[row][col]) + ",";
        }
      }
      if (row == (table.length - 1)) {
        this.functionsChartText = this.functionsChartText + "]\n";
      }
      else{
        this.functionsChartText = this.functionsChartText + "],\n";
      }
    }
    this.functionsChartText = this.functionsChartText + "]);\n";

    if (!this.optionChart.equals("")) {this.functionsChartText = this.functionsChartText + this.optionChart;}
    else{this.functionsChartText = this.functionsChartText +
                                   "     // Set chart options\n" +
                                   "     var options = {};\n";
        }

    this.functionsChartText = this.functionsChartText +
      "     // Instantiate and draw the chart for " + this.func_name +  ".\n" +
      "     var chart = new google.visualization.LineChart(document.getElementById('" + this.id_element + "'));\n" +
      "     chart.draw(data,options);\n" +
      "    }\n";
  }
  public String getDrawChartText()
  {
    return this.drawChartText;
  }
  public String getFunctionChartText()
  {
    return this.functionsChartText;
  }
}
