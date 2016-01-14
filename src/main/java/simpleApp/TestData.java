package simpleApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class TestData {
	
	public static String docName;
	public static String city;
	public static String speciality;
	private static String testDataFileName = "TestData.properties";
	private static final Logger LOGGER = Logger
			.getLogger(TestData.class);
	
	static{
		String testDataFilePath = System.getProperty("user.dir")+"/src/test/resources/"+testDataFileName.replace("/",File.separator);
		FileInputStream fis;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(new File(testDataFilePath));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		docName = prop.getProperty("doc_name");
		city = prop.getProperty("city");
		speciality = prop.getProperty("speciality");
	}

}
