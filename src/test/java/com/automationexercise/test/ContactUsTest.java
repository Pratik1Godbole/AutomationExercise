package com.automationexercise.test;

import org.testng.annotations.Test;

import com.automationexercise.Base.BaseClass;
import com.automationexercise.Pages.ContactUsPage;


public class ContactUsTest extends BaseClass{
	ContactUsPage contactUs;
	
  @Test
  public void ContactUsForm() {
	  contactUs = new ContactUsPage();
	  contactUs.contactUs();
  }
}
