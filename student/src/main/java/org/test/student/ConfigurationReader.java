package org.test.student;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	private Properties propertiesFile;

	public ConfigurationReader() {
		propertiesFile = new Properties();
		try {
			propertiesFile.load(new FileInputStream(new File("conf/configuration.properties")));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getProperty(String key) {
		return this.propertiesFile.getProperty(key);
	}

}
