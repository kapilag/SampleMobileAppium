package simpleApp;

import org.testng.annotations.Test;

import PageObjects.DocDetails;

public class PractoDocSearch extends Driver {
	
	
	@Test
	public void docdetailsTest(){
		DocDetails doc = new DocDetails(driver);
		doc.selectCity(TestData.city);
		doc.selectSpeciality(TestData.speciality);
		doc.selectDoc(TestData.docName);
		scrollUp(3);
		back();
		back();
	}

}
