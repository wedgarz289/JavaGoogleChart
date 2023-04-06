package com.java.google.html.charts;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class GoogleCharts
{
  private String html_text; // texto html y texto javascript
  private String chartScriptText; // instrucciones javascript para crear las graficas
  private String drawChartText; // instrucciones javascript para dibbujar las graficas
  private String functionsChartText; // funciones para crear las graficas
  private String optionChart; // texto de opciones para la grafica
  private String tableHtmlText; // texto para crear la tabla en html
  private String subplot_matrix[][]; // matriz para gener la tabla html para comolar las graficas
  private int    count_charts;  //contador de graficas
  private int    rows,cols;

  public GoogleCharts()
  {
    this.html_text          = "";
    this.chartScriptText    = "";
    this.drawChartText      = "";
    this.functionsChartText = "";
    this.optionChart        = "";
    this.tableHtmlText      = "";
    this.count_charts       = 1;
    this.rows               = 0;
    this.cols               = 0;
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

  public void setOptionChart(String optionChart){
    this.optionChart = optionChart;
  }

  public void PieChart(Map<String,Integer> xy)
  {
    GooglePieChart pieChart = new GooglePieChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    pieChart.setOptionPieChart(this.optionChart);
    pieChart.generateCodePieChart(xy);
    this.drawChartText      = this.drawChartText      + pieChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + pieChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
  }

  public void BarChart(Map<String,Double> xy, String label_column_x, String label_column_y)
  {
    GoogleBarChart barChart = new GoogleBarChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    barChart.setOptionBarChart(this.optionChart);
    barChart.generateCodeBarChart(xy,label_column_x,label_column_y);
    this.drawChartText      = this.drawChartText      + barChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + barChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
  }

  public void BarChart(double[][] table,String[] table_label)
  {
    GoogleBarChart barChart = new GoogleBarChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    barChart.setOptionBarChart(this.optionChart);
    barChart.generateCodeBarChart(table,table_label);
    this.drawChartText      = this.drawChartText      + barChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + barChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
  }

  public void LineChart(double[][] table,String[] table_label)
  {
    GoogleLineChart lineChart = new GoogleLineChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    lineChart.setOptionLineChart(this.optionChart);
    lineChart.generateCodeLineChart(table,table_label);
    this.drawChartText      = this.drawChartText      + lineChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + lineChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
  }

  public void LineChart(String[] column_1,double[][] table,String[] table_label)
  {
    GoogleLineChart lineChart = new GoogleLineChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    lineChart.setOptionLineChart(this.optionChart);
    lineChart.generateCodeLineChart(column_1,table,table_label);
    this.drawChartText      = this.drawChartText      + lineChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + lineChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
  }

  public void ScatterChart(double[][] table,String[] table_label)
  {
    GoogleScatterChart scatterChart = new GoogleScatterChart("drawChart_" + String.valueOf(this.count_charts),"drawChart_div_" + String.valueOf(this.count_charts));
    scatterChart.setOptionScatterChart(this.optionChart);
    scatterChart.generateCodeScatterChart(table,table_label);
    this.drawChartText      = this.drawChartText      + scatterChart.getDrawChartText();
    this.functionsChartText = this.functionsChartText + scatterChart.getFunctionChartText();
    this.count_charts++;
    this.optionChart = "";
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
  }
}
