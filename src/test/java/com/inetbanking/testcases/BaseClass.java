package com.inetbanking.testcases;
import com.beust.jcommander.Parameter;
import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    /*public String BaseURL="https://demo.guru99.com/v4/";
    public String username="mngr550779";
    public String password="sEsedYg";*/
//Commenting hardcoded values as we have created a properties file(config.properties) in which all the values are stored. We'll pe pulling all the values from that file to ReadConfig file and then to BaseClass file
    ReadConfig readconfig=new ReadConfig();
    public String BaseURL=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void Setup(String br)
    {

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            driver=new ChromeDriver();

        }
        else if (br.equals("ie"))
        {
            System.setProperty("webdriver.edge.driver",readconfig.getMicrosoftEdgePath());
            driver=new EdgeDriver();
        }

    //    System.setProperty("WebDriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
      //  System.setProperty("WebDriver.chrome.driver",readconfig.getChromePath());
        //System.getProperty("user.dir") instead of this ./ also can be used
      //  driver=new ChromeDriver();
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BaseURL);


    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomstring()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }
    public String randomNum()
    {
        String generatedString2= RandomStringUtils.randomNumeric(4);
        return generatedString2;
    }


}
