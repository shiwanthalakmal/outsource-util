package com.outsource.qa.connections;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 4/18/2016.
 */
public class DriverConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverConnection.class);

    protected static RemoteWebDriver driver = null;
    protected static DesiredCapabilities capability;

    public static RemoteWebDriver getDeriverInstance(){
        if(driver == null) {
            setDesiredCapabilities();
            setWebBrowserInstance();
        }
        setWebDriverSettings();
        return driver;
    }

    private static void setWebBrowserInstance(){
        driver = new FirefoxDriver(capability);
    }

    private static void setWebDriverSettings(){
        try {
            LOGGER.info("[NOTE]: Initiate Firefox Driver");
            String strAppUrl = "https://www.railplus.com.au/";

            driver.manage().timeouts().implicitlyWait((long)8000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.navigate().to(strAppUrl);
            LOGGER.info("[NOTE]: Browser Loaded And Navigated To : [" + strAppUrl + " ]");
        } catch (Throwable var1) {
            //throw new FrameworkException(var1.getCause().toString());
        }
    }

    private static void setDesiredCapabilities(){
        capability = DesiredCapabilities.firefox();
        capability.setCapability("acceptSslCerts", true);
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
