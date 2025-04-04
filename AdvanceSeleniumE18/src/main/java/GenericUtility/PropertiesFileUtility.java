package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String readingDataFromPropFile(String Key) throws IOException {
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\git\\E18_Batch\\AdvanceSeleniumE18\\src\\test\\resources\\commondata.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String data=prop.getProperty(Key);
		return data;
	}
}
