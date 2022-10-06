package aayushpatelframework.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonMapData() throws IOException
	{
		// reading json as String 
	String content = FileUtils.readFileToString(new File(
				System.getProperty("User.dir") + "\\src\\test\\java\\aayushpatelframework\\data\\purchaseOrder.json"),
				StandardCharsets.UTF_8);
	
	//String To HashMap
	
	ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(content,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
}
