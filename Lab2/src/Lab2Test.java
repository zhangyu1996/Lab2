import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;  
import java.io.FileReader;  
import java.util.List;  
import org.openqa.selenium.firefox.FirefoxDriver;
import com.opencsv.CSVReader;import static org.junit.Assert.*;

import org.junit.Test;

public class Lab2Test {
	WebDriver web;
	File file;
	FileReader fReader;
	CSVReader csvReader;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:/firefox40/firefox.exe"); 
		 web = new FirefoxDriver();
		 file = new File("G:/java/X/inputgit.csv");  
		 fReader = new FileReader(file);  
		 csvReader = new CSVReader(fReader); 
		 csvReader.readNext();
	}
	@Test
	public void test()throws Exception {
		
		String [] nextLine;  
		List<String> list0 =new ArrayList<String>();  //¥Ê—ß∫≈
	    List<String> list1 =new ArrayList<String>();  //¥ÊÕ¯÷∑
		 while((nextLine=csvReader.readNext())!=null){           
		    	list0.add(nextLine[0]); 
		    	list1.add(nextLine[2]);
		    }  
		    System.setProperty("webdriver.firefox.bin", "D:/firefox40/firefox.exe"); 
			
			
		    for(int i=0;i<list0.size();i++){
		        web.get("http://121.193.130.195:8080");
		    	web.findElement(By.id("name")).clear();
		  	    web.findElement(By.id("name")).sendKeys(list0.get(i));
		  	    web.findElement(By.id("pwd")).clear();
		  	    web.findElement(By.id("pwd")).sendKeys(list0.get(i).substring(4));
		  	    web.findElement(By.id("submit")).click();
		  	    assertEquals(list1.get(i), web.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
		  	
		    }
	}
	@After
	  public void tearDown() throws Exception {
		csvReader.close();
	    web.quit();
	    
	  }

}
