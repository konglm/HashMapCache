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



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List; 

public class MainClass{ 

	public static void main(String[] args) throws Exception { 
	
		List news1 = null; 
		
		List news2 = null; 
		
		NewsBean bean = null; 
		
		Cache c = new Cache();
		
		news1 = (List) c.get("news", MainClass.class.getResource("").getPath() + "news.xml", XmlFileParser.class, ListTypeInstantiator.class, NewsBean.class); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		
		System.out.println("time===" + sdf.format(new Date()));
		for (int i = 0; i < news1.size(); i++) { 
		
			bean = (NewsBean) news1.get(i); 
			
			bean.getTitle(); 
			
			bean.getDetail(); 
			
			bean.getTitle(); 
			
			bean.getImage(); 
		
		} 
		System.out.println("");
		System.out.println("time===" + sdf.format(new Date()));
		
		news2 = (List) c.get("news", MainClass.class.getResource("").getPath() + "news.xml", XmlFileParser.class, ListTypeInstantiator.class, NewsBean.class); 
		
		System.out.println("time===" + sdf.format(new Date()));
		for (int i = 0; i < news2.size(); i++) { 
		
			bean = (NewsBean) news2.get(i); 
			
			bean.getTitle(); 
			
			bean.getDetail(); 
			
			bean.getTitle(); 
			
			bean.getImage(); 
		
		} 
		System.out.println("");
		System.out.println("time===" + sdf.format(new Date()));
	}

} 

