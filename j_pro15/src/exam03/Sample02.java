package exam03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Sample02 {

	public static void main(String[] args) {
		String userHome = System.getProperty("user.home");
		String file = "/eclipse/jee-2021-12/eclipse/configuration/config.ini";
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream(new File(userHome + file)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		System.out.println(prop.get("eclipse.product"));
		System.out.println(prop.getProperty("eclipse.product"));
		
		prop.put("x", "100");
		prop.put("key", "Hello");
		prop.setProperty("name", "eclipse");
		
		String otherFile = "/eclipse/jee-2021-12/eclipse/configuration/config.copy";
		
		try {
			prop.store(new FileOutputStream(new File(userHome + otherFile)), "This is Comment");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
