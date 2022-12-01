package com.sample;


import java.sql.Date;

public class Patient {

  private long patientId;
  private String patientName;
  private String password;
  private String salt;
  private String trueName;
  private java.sql.Date bornDate;
  private String idNum;
  private String phone;
  private long gender;
  private long isDelete;

  public Patient(){};

  public String getTrueName() {
    return trueName;
  }

  public void setTrueName(String trueName) {
    this.trueName = trueName;
  }

  public Patient(String patientName, String password, Date bornDate, String idNum, String phone, long gender, long isDelete) {
    this.patientName = patientName;
    this.password = password;
    this.bornDate = bornDate;
    this.idNum = idNum;
    this.phone = phone;
    this.gender = gender;
    this.isDelete = isDelete;
  }

  public long getPatientId() {
    return patientId;
  }

  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }


  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public java.sql.Date getBornDate() {
    return bornDate;
  }

  public void setBornDate(java.sql.Date bornDate) {
    this.bornDate = bornDate;
  }


  public String getIdNum() {
    return idNum;
  }

  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
  }

}
