package Utilitiess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {
   public String readDataFromProperty(String key) throws Throwable {
	   FileInputStream f=new FileInputStream("./commandata.properties");
	   Properties p=new Properties();
	   p.load(f);
	return p.getProperty(key);
   }
}
