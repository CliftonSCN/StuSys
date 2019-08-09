package com.clifton.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
* @author Clifton  
* @date 2019年7月30日 下午8:52:08 
* @project jsj
*/
public class Jsontest {
	
	public static void main(String[] args) {
		
		/*response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
		 response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题
		 StringjsonStr ="{\"id\":\"123\",\"name\":\"小黎\"}";*/

		String data="{" + 
	            "   \"name\":\"韩超\"," + 
	            "   \"age\":18," + 
	            "   \"code\":1507030123," + 
	            "   \"hobbies\":[\"football\",\"game\",\"baskerball\"]," + 
	            "   \"details\":" + 
	            "   {" + 
	            "       \"birthday\":869760000," + 
	            "       \"extar\":[1321,\"hahaha\",\"zzz421\"]" + 
	            "   }" + 
	            "}";
	    //创建一个ObjectMapper对象
	    ObjectMapper objectMapper=new ObjectMapper();
	    //读取json数据,返回一个JsonNode对象指向根节点
	    try {
	        JsonNode jsonNode=objectMapper.readTree(data);
	        //利用JsonNode的path方法获取子节点,path方法的返回值也是JsonNode
	        JsonNode subNode=jsonNode.path("details");//得到details节点
	        //JsonNode对象的asInt(),asText()等方法用于获取值
	        
	        System.out.println(jsonNode.path("name").asText());//返回字符串,韩超
	        System.out.println(jsonNode.path("age").asInt());//返回整形数据,18
	        System.out.println(jsonNode.path("code").asLong());//返回长整型数据,1507030123
	        
	        //对于数组,可以使用size方法获取数组长度,get(index)获取索取为index的值
	        for(int i=0;i<jsonNode.path("hobbies").size();i++)
	            System.out.println(jsonNode.path("hobbies").get(i).asText());//输出hobbies对应的数组
	        
	        //获取details.birthday
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");  
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	        System.out.println(sdf.format(new Date(subNode.path("birthday").asLong()*1000)));
	        
	        for(int i=0;i<subNode.path("extar").size();i++)
	            System.out.println(subNode.path("extar").get(i).asText());//输出details.extar对应的数组
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}

}
