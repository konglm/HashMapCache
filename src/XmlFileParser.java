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



import java.io.FileInputStream; 

import java.io.IOException; 

import org.jdom.Document; 

import org.jdom.Element; 

import org.jdom.input.SAXBuilder; 

public class XmlFileParser implements FileParser { 

	public XmlFileParser() { 
	
		super(); 
	
	} 

	public Object parse(String path) { 
	
		FileInputStream fi = null; 
	
		try { 
		
			fi = new FileInputStream(path); 
			
			SAXBuilder sb = new SAXBuilder(); 
			
			Document doc = sb.build(fi); 
			
			Element root = doc.getRootElement(); 
			
			return root.getChildren(); 
		
		} catch (Exception e) { 
		
			e.printStackTrace(); 
			
			return null;
		
		} finally { 
		
			try { 
			
				fi.close(); 
			
			} catch (IOException e1) { 
			
			} 
		
		} 
	
	} 

} 
