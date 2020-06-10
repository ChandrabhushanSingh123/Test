package File;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {
	
	public static JsonPath rawToJson(String response) 
	
	{
		JsonPath Js1=new JsonPath(response);
		return Js1;
	}
	
}
