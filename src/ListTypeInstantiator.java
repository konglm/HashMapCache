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



import java.util.ArrayList; 

import java.util.List; 

import org.apache.commons.beanutils.BeanUtils; 

import org.jdom.Element; 

public class ListTypeInstantiator implements Instantiator { 

	public ListTypeInstantiator() { 
	
		super(); 
	
	} 

	public Object instantiate(Class clazz, Object configuration) { 
	
		List arr = new ArrayList(); 
		
		Object bean = null; 
		
		List children = (List) configuration; 
		
		Element child = null; 
		
		List attributes = null; 
		
		Element attribute = null; 
		
		try { 
		
			for(int i=0; i<children.size(); i++) {  
					
				child = (Element) children.get(i); 
			
				bean = clazz.newInstance(); 
				
				attributes = child.getChildren(); 
				
				for(int j=0; j<attributes.size(); j++) { 
					
					attribute = (Element) attributes.get(j); 
					
					BeanUtils.setProperty(bean, attribute.getName(), attribute.getText()); 
			
				} 
			
				arr.add(bean); 
	
			} 
		
		} catch(Exception e) { 
		
			e.printStackTrace(); 
		
		}

		return arr; 
	
	} 

} 
