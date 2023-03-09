package reusableComponents;

import java.io.FileInputStream;
import java.util.Properties;

import io.opentelemetry.api.internal.StringUtils;

public class PropertiesOperation {
	
	public static String getPropertyDataByKey(String key) throws Exception {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/config.properties");
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	if(StringUtils.isNullOrEmpty(value)) {
		throw new Exception("Value not found for specifie key "+key+"in Properties File.");
	}
	return value;
	}

}
