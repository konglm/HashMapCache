/*----------------------------------------------------------------
 *  Copyright (C) 2017山东金视野教育科技股份有限公司
 * 版权所有。 
 *
 * 文件名：
 * 文件功能描述：
 *
 * 
 * 创建标识：
 *
 * 修改标识：
 * 修改描述：
 *----------------------------------------------------------------*/



import java.io.File; 

import java.util.HashMap; 

public class Cache { 

	HashMap mapLastModified = new HashMap(); 
	
	HashMap mapValues = new HashMap(); 
	
	public Cache() { 
	
		super(); 
	
	} 

	public Object get(String name, String path, Class clsParser, Class clsInstantiator, Class clsObj) { 
	
		Object obj = null; 
		
		String absPath = path; 
		
		Long modified = getModified(name, absPath); 
		
		if (modified != null) { 
		
			obj = readObject(absPath, clsParser, clsInstantiator, clsObj); 
			
			mapLastModified.put(name, modified); 
			
			mapValues.put(name, obj); 
			
			System.out.println("get object from file"); 
		
		} else { 
		
			obj = mapValues.get(name); 
			
			System.out.println("get object from cache"); 
		
		} 
		
		return obj; 
	
	} 
	
	private Long getModified(String name, String path) { 
	
		Long modified = new Long(new File(path).lastModified()); 
		
		Long saveModified = (Long) mapLastModified.get(name); 
		
		if ((saveModified != null) && (saveModified.longValue() >= modified.longValue())) { 
		
			modified = null; 
		
		} 
		
		return modified; 
	
	} 
	
	private Object readObject(String path, Class clsParser, Class clsInstantiator, Class clsObj) { 
	
		try { 
		
			FileParser parser = (FileParser) clsParser.newInstance(); 
			
			Instantiator instantiator = (Instantiator) clsInstantiator.newInstance(); 
			
			Object config = parser.parse(path); 
			
			return instantiator.instantiate(clsObj, config); 
		
		} catch (InstantiationException e) { 
		
			e.printStackTrace(); 
		
		} catch (IllegalAccessException e) { 
		
			e.printStackTrace(); 
		
		} 
		
		return null; 
	
	} 

}

