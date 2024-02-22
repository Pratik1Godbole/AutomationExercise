package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.TestCasePage;

public class TestCaesTest extends BaseClass{
	TestCasePage TcP;
  @Test
  public void VerifyTCsPage() {
	 TcP = new TestCasePage();
	 TcP.TestCase();
  }
}
