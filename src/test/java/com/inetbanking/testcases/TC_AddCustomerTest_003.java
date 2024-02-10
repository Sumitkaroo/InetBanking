package com.inetbanking.testcases;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust=new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        Thread.sleep(3000);
        addcust.closePop();

        logger.info("providing customer details....");

        addcust.custName("Sumit");
        addcust.custgender("male");
        addcust.custdob("10","15","1985");
        Thread.sleep(2000);
        addcust.custaddress("INDIA");
        addcust.custcity("HYD");
        addcust.custstate("AP");
        addcust.custpinno("5000074");
        addcust.custtelephoneno("987890091");
        Thread.sleep(2000);

        addcust.custemailid(randomstring()+"@gmail.com");
        Thread.sleep(2000);

        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

        if(res==true)
        {
            Assert.assertTrue(true);
        }
        else {
            captureScreen(driver,"addNewCustomer");
            Assert.assertTrue(false);
        }
    }


}
