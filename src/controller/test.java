package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import VO.keywordVo;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List ls = new ArrayList();
		ls.add("xyz");
		ls.add("pqr");
		Map myMap = new  HashMap();
		
		String line[]={"pqr", "aaaaaaaaaaaaaaa", "xyz ","pqr","xyz"};
		
		for (Iterator iterator = ls.iterator(); iterator.hasNext();) {
			String str = (String) iterator.next();
			//System.out.println(str.getKeywordName());
			

			for (int i = 0; i < line.length; i++) {
				
			
			if (line[i] != null && line[i].contains(str)) {
	
				
				System.out.println(myMap.get(str));
				 
				Integer in = myMap.get(str)==null?0:(Integer)myMap.get(str);
				 
				in=in+1;
				 myMap.put(str,in);
				    
				 	System.out.println("KEYWORD::"+str);
					System.out.println("size::::::"+myMap.get(str));
				
			}
			}

		}

	}

}
