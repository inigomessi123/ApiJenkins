package Sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		File file=new File("C:\\Users\\inigo\\eclipse-workspace\\ApiTest\\src\\test\\resources\\creat.json");
		ObjectMapper mapper=new ObjectMapper();
		Datum d=new Datum(22, "ram@gmail.com", "ram", "kumar", "www.amazon.com");
		Datum d1=new Datum(33, "sam@gmail.com", "sam", "son", "www.flipkart.com");
		Datum d2=new Datum(44, "ramki@gmail.com", "ramki", "messi", "www.snapdeal.com");
		
		ArrayList<Datum> list=new ArrayList<Datum>();
		list.add(d);
		list.add(d1);
		list.add(d2);
		
		Support s=new Support("www.facebook.com", "messi");
		
		Root r=new Root(1, 3, 7, 9, list, s);
		
		mapper.writeValue(file, r);
	}

} 
