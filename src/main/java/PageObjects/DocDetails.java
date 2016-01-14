package PageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class DocDetails {
	
	private AndroidDriver driver;
	
	public DocDetails(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void selectCity(String name){
		driver.findElement(By.name(name)).click();
	}
	
	public void selectSpeciality(String specialityname){
		driver.findElement(By.name(specialityname)).click();
	}
	
	public void selectDoc(String docname){
		driver.findElement(By.name(docname)).click();
	}

}
