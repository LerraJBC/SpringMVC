package net.lerraj.spring.util;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtil {
	
	public static void appendToList(JSONObject jsonObj, JSONObject toBeAppended) {

        JSONArray arr = (JSONArray) jsonObj.get("Students");        
        arr.add(toBeAppended);
    }
	
	public static JSONObject getFileJSONObject(){
		JSONObject jsonObj = new JSONObject();
		
		try{
			
		JSONParser parser = new JSONParser();
	    Object obj = parser.parse(new FileReader("C:/Users/Costiniano/Desktop/TORO/Spring/MySpringMvcJDBC/jsonfiles/students.json"));
	    jsonObj = (JSONObject) obj;
	    
		}
	 catch (Exception e) {
         e.printStackTrace();
     }
		return jsonObj;
	}
	
	public boolean writeToFile(JSONObject jsonObject){
		boolean status = true;
		try{
			FileWriter file = new FileWriter("C:/Users/Costiniano/Desktop/TORO/Spring/MySpringMvcJDBC/jsonfiles/students.json");
			file.write(jsonObject.toJSONString());
			file.flush();
            file.close();
		}
		catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
		return status;
	}
	
	
	
	public long incrementId() {
       
        JSONObject jsonObj = JSONFileUtil.getFileJSONObject();
        JSONArray arr = (JSONArray) jsonObj.get("Students"); 
        long jsonObjectSize = arr.size();

        return jsonObjectSize + 1;
    }
	
}
