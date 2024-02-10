package com.inetbanking.testcases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class TC_LoginTest_001 extends BaseClass{

    @Test
    public void loginTest() throws IOException {
   //     driver.get(BaseURL);
        logger.info("URL is opened");
        LoginPage lp=new LoginPage(driver);

        lp.setUserName(username);
        logger.info("username entered successfully");

        lp.setPassword(password);
        logger.info("password entered successfully");

/*        lp.clickReset();
        logger.info("Data entered is reset");

        lp.setUserName(username);
        logger.info("username entered again");
        lp.setPassword(password);*/

        lp.clickSubmit();


        if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
        }

    }
}
