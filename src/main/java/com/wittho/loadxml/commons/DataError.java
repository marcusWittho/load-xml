package com.wittho.loadxml.commons;

public class DataError {

  private String error;

  public static DataError createDataError(String error) {

    DataError dataError = new DataError();

    dataError.setError(error);

    return dataError;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
