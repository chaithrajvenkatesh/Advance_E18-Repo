package DDTPractice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
	JSONParser parser= new JSONParser();
	FileReader file= new FileReader("D:\\java_folder\\M118\\AdvanceSeleniumE18\\src\\test\\resources\\Data_E18.json");
	Object javaObj=parser.parse(file);
	
	JSONObject obj=(JSONObject)javaObj;
	String name=obj.get("name").toString();
	String id=obj.get("id").toString();
	Object id1=obj.get("id");
	String branch=obj.get("Branch").toString();
	String age=obj.get("Age").toString();
	String isStudent=obj.get("isStudent").toString();
	Object isStudent1=obj.get("isStudent");
	//String backlogs=obj.get("backlogs").toString();
	Object backlogs1=obj.get("backlogs");
	System.out.println(name);
	System.out.println(id);
	System.out.println(id1);
	System.out.println(branch);
	System.out.println(age);
	System.out.println(isStudent);
	System.out.println(isStudent1);
	//System.out.println(backlogs);
	System.out.println(backlogs1);
	}

}
