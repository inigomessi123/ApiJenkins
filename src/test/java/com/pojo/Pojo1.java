package com.pojo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Pojo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream stream=new FileInputStream("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\greens.properties");
		Properties properties=new Properties();
		properties.load(stream);
		Object object=properties.get("userName");
		System.out.println(object);
		
		Object object2 = properties.get("passWord");
		System.out.println(object2);
		
	}

}
