package arrayandstring;

import java.util.HashMap;

/**
 * ClassName: Removecertaincharacters
 * Description: A class that remove certain characters in the string
 * Date: 2017-4-25
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Removecertaincharacters {
	
	public static String remove(String str, String remove){
		
		/*
		 * create a Hash Map to check if str contains character in remove 
		 */
		HashMap<Character,Boolean> myhashmap = new HashMap<Character,Boolean>();
		for(int i=0;i<remove.length();i++)
			myhashmap.put(remove.charAt(i), true);
		
		/*
		 * String is immutable
		 * use string buffer to store the new string
		 */
		StringBuffer stringbuffer = new StringBuffer();
		
		for(int i=0;i<str.length();i++){
			if(!myhashmap.containsKey(str.charAt(i)))
				stringbuffer.append(str.charAt(i));					
		}		
		return stringbuffer.toString();		
	}
	
	/*
	 * test main funciton
	 */
	
	public static void main(String[] args){
		
		System.out.print(remove("pIcb ppblkkobbvkke ccybbobkku bbXbbucc kkYpaccn","pkbc"));
		
		
	}
}
