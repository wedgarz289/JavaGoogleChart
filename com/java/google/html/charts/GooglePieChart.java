package com.java.google.html.charts;

import java.util.Map;

public class GooglePieChart
{
  private String chartScriptText; // instrucciones javascript para crear las graficas
  private String drawChartText; // instrucciones javascript para dibbujar las graficas
  private String functionsChartText; // funciones para crear las graficas
  private String optionChart; // texto de opciones para la grafica
  private String func_name; // nombre de la funcion en javascript
  private String id_element; // identificador para html
  public GooglePieChart(String func_name, String id_element)
  {
    this.chartScriptText    = "";
    this.drawChartText      = "";
    this.functionsChartText = "";
    this.optionChart        = "";
    this.func_name          = func_name;
    this.id_element         = id_element;
  }

  public void setOptionPieChart(String option)
  {
    this.optionChart = "     // Set chart options\n" +
                       "     var options = {" + option + "};\n";
  }
  public void generateCodePieChart(Map<String,Integer> xy)
  {
    this.drawChartText      = this.drawChartText +
                              "    // Draw the pie chart for " + this.func_name + " when Charts is loaded.\n" +
                              "    google.charts.setOnLoadCallback(" + this.func_name + ");\n";

    this.functionsChartText = "    // Callback that draws the pie chart for " + this.func_name +  ".\n" +
                              "    function " + this.func_name + "(){\n"  +
                              "     // Create the data table for " + this.func_name +  ".\n" +
                              "     var data = new google.visualization.DataTable();\n" +
                              "     data.addColumn('string', 'Topping');\n" +
                              "     data.addColumn('number', 'Slices');\n"  +
                              "     data.addRows([\n";
    int count = 0;
    for ( Map.Entry map:xy.entrySet() ) {
      if (count == (xy.size() -1 )) {
        this.functionsChartText = this.functionsChartText + "       ['" + map.getKey() + "'," + String.valueOf(map.getValue()) + "]\n";
      }
      else{
        this.functionsChartText = this.functionsChartText + "       ['" + map.getKey() + "'," + String.valueOf(map.getValue()) + "],\n";
      }
      count++;
    }
    this.functionsChartText = this.functionsChartText + "     ]);\n";

    if (!this.optionChart.equals("")) {this.functionsChartText = this.functionsChartText + this.optionChart;}
    else{this.functionsChartText = this.functionsChartText +
                                   "     // Set chart options\n" +
                                   "     var options = {};\n";
        }

    this.functionsChartText = this.functionsChartText +
      "     // Instantiate and draw the chart for " + this.func_name +  ".\n" +
      "     var chart = new google.visualization.PieChart(document.getElementById('" + this.id_element + "'));\n" +
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
