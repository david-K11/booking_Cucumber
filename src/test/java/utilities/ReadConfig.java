package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getEmail() {
		String email = pro.getProperty("email");
		return email;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getBrowser() {
		String br = pro.getProperty("browser");
		return br;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getFirstName() {
		String firstname = pro.getProperty("firstname");
		return firstname;
	}
	public String getLastName() {
		String lastname = pro.getProperty("lastname");
		return lastname;
	}
}
