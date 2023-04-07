package com.java.google.html.charts;

public class DataArray<T>{
  // private String[] dataString;
  // private double[] dataDouble;
  // private int   [] dataInteger;
  private T[] data;

  public void setData(T[] data)
  {
    this.data = data;
  }
  public T[] getData()
  {
    return data;
  }
}
