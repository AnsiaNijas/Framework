package com.supermarketdemo.tests;

import org.testng.annotations.Test;

public class DashBoardTest  extends BaseClass{
  @Test(dependsOnGroups="login")
  public void verifyCategoryPageFromDashBoard() {
  }
}
