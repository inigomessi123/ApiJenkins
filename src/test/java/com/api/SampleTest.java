package com.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		File file=new File("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\list.json");
		
		ObjectMapper mapper=new ObjectMapper();
		Root r = mapper.readValue(file, Root.class);
		ArrayList<Datum> data = r.getData();
	for (Datum x : data) {
		System.out.println(x.getAvatar());
		System.out.println(x.getEmail());
		System.out.println(x.getFirst_name());
		System.out.println(x.getLast_name());
		System.out.println(x.getId());
		
	}
	
		
		
	}

}
