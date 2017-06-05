package arrayandstring;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * ClassName: Firstnonrepeatedcharacter
 * Description: A class that find first nonrepeated character
 * Date: 2017-4-25
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Firstnonrepeatedchararter {
	/*
	 * find the first non-repeated character using array
	 */
	public static char Findfirstcharusingarray(String input){
		/*
		 * initialize an array that store frequency of input character
		 */
		int[] charfrequency = new int[26];
		for(int i=0;i<26;i++)
			charfrequency[i]=0;
		
		/*
		 * store the frequecny of character in this array
		 */
		for(int j=0;j<input.length();j++){
			charfrequency[input.charAt(j)-97]++;
		}
		
		//find the first character that has frequency equals one
		for(int k=0;k<input.length();k++){
			if(charfrequency[input.charAt(k)-97]==1)
				return input.charAt(k);
		}
		
		throw new IllegalArgumentException("No nonrepeated character for this input");
	}
	
	/*
	 * find the first non-repeated character using hash table
	 */
	public static char Findfirstcharusinghashtable(String input){
		//create and initialize the hash table
		Hashtable<Character,Integer> myhashtable = new Hashtable<Character,Integer>();
		
		for(int i=0;i<input.length();i++){
			if(myhashtable.containsKey(input.charAt(i)))
				myhashtable.put(input.charAt(i),myhashtable.get(input.charAt(i))+1);
			else
				myhashtable.put(input.charAt(i),1);
			
		}
		
		for(int i=0;i<input.length();i++){
			if(myhashtable.get(input.charAt(i))==1)
				return input.charAt(i);
		}
		
		throw new IllegalArgumentException("No nonrepeated character for this input"); 
	}
	
	/*
	 * improving compared with second one
	 * improving on unicode ways
	 * using three types instead count all of different frequency
	 */
	public static String FirstNonRepeatedimproved( String str ){
		HashMap<Integer,Object> charHash = new HashMap<Integer,Object>();
		Object seenOnce = new Object(), seenMultiple = new Object();
		Object seen;
		int i;
		final int length = str.length();
		// Scan str, building hash table
		for (i = 0; i < length; ) { //increment intentionally omitted
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp); //increment based on code point
			seen = charHash.get(cp);
			if (seen == null) { // not present
				charHash.put(cp, seenOnce);
				} 
			else {
				if (seen == seenOnce) {
					charHash.put(cp, seenMultiple);
					}
				}
		}
		// Search hash table in order of str
		for (i = 0; i < length; ) {
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			if (charHash.get(cp) == seenOnce) {
				return new String(Character.toChars(cp));
			}
		}
		return null;
		}

	public static void main(String[] args){
		System.out.print(Findfirstcharusinghashtable("hheello"));
	}
}
