package com.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class utility {

	public static String yamlFilePath = "src/test/resources/TestData/testData.yml";

	public String getURL() throws FileNotFoundException {
		
		Reader doc = new FileReader(yamlFilePath);
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		System.out.println(object);
	    String value = object.toString();
	    String [] split1 = value.split("=");
	    String  url1 = split1[1].trim();
	    String [] url2 = url1.split("}");
	    String url =url2[0].trim();
	    System.out.println(url);
	    
	   return url;
	    
		

	}
	
	
}
