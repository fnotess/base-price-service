package com.sysco.rps.entity.pp.masterdata.enums;

public enum ActivationStatus {
  ACTIVE("Active"),
  INACTIVE("Inactive");


  private String value;

  private ActivationStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}