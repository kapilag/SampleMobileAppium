package simpleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public abstract class Driver {
	
	public static AndroidDriver driver;
	
	@BeforeTest
	public void setUp(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "4.4");
        String userDir = System.getProperty("user.dir");
        String localApp = "com.practo.fabric-1.5.4-19_APKdot.com.apk";
        File app = new File(userDir,localApp);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.practo.fabric");
        //CityActivity
        capabilities.setCapability("appActivity", "com.practo.fabric.MainActivity");
        try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void scrollUp(int noOfTimes){
		
		
		Dimension dimension = driver.manage().window().getSize();
		int startx = (int) (dimension.getWidth()/2);
		int starty = (int)(dimension.getHeight()*0.8);
		int endy = (int)(dimension.getHeight()*0.5);
		for(int i=0;i<noOfTimes;i++){
		driver.swipe(startx,starty, startx, endy, 1000);
		}
	}
	
	public static void back(){
		driver.navigate().back();
	}
	
	@AfterTest
	public void cleanUp(){
		driver.quit();
	}
	

}
