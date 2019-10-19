package com.clifton.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* @author Clifton  
* @date 2019年8月16日 下午3:18:51 
* @project stusys
*/
public class JsonUtil {
	
	public static String parseSingleString(String string, String index) {
		ObjectMapper objectMapper=new ObjectMapper();
		String text = null;
	    try {
			JsonNode jsonNode=objectMapper.readTree(string);
			text = jsonNode.findPath(index).asText();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return text;
	}

}
