package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.j2objc.annotations.Property;

public class FileUtility {
	
	/**
	 * Method used to read data from Property file
	 * @param key
	 * @return value
	 * @throws Throwable
	 * @author Viraj
	 * @throws IOException 
	 */
	
	
	public String getCommonData(String key) throws IOException  {
		
		FileInputStream fis = new FileInputStream(IPathConstant.propertyFilePath);
		
		Properties pro = new Properties();
		pro.load(fis);
		
		String value = pro.getProperty(key);
		return value;
	}
	


}
