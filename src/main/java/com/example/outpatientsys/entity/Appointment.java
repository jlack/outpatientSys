package com.sample;


public class Appointment {

  private long appId;
  private long doctorId;
  private long patientId;
  private java.sql.Timestamp appTime;
  private java.sql.Timestamp orderTime;
  private String analysis;


  public long getAppId() {
    return appId;
  }

  public void setAppId(long appId) {
    this.appId = appId;
  }


  public long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(long doctorId) {
    this.doctorId = doctorId;
  }


  public long getPatientId() {
    return patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }


  public java.sql.Timestamp getAppTime() {
    return appTime;
  }

  public void setAppTime(java.sql.Timestamp appTime) {
    this.appTime = appTime;
  }


  public java.sql.Timestamp getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(java.sql.Timestamp orderTime) {
    this.orderTime = orderTime;
  }


  public String getAnalysis() {
    return analysis;
  }

  public void setAnalysis(String analysis) {
    this.analysis = analysis;
  }

}
