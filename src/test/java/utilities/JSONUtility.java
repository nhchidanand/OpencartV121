package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtility {
	
	public List<HashMap<String, String>> JsonDataReader(String path) throws IOException
	{
	File file = new File(path);
	String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();  
	TypeReference<List<HashMap<String, String>>> typeRef = new TypeReference<List<HashMap<String, String>>>(){};
	ObjectMapper mapper =  new ObjectMapper();
	data = mapper.readValue(jsonContent, typeRef);
	return data;
	}
}
