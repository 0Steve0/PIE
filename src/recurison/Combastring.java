package recurison;
/**
 * ClassName: Combastring
 * Description: A class that print all combination of string
 * Date: 2017-4-26
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Combastring {
	
	/*
	 * combination class
	 * 1.combination: select one character each time, append and print
	 * 2.move to next and do the same thing for the rest
	 * a,ab,abc,b,bc,c
	 */
	public static void comba(String prefix,String str){
		int n = str.length();
		System.out.println(prefix);
		for(int i=0;i<n;i++)
			comba(prefix+str.charAt(i),str.substring(i+1));	
	}
	
	/*
	 * test main function
	 */
	public static void main(String[] args){
		
		comba("","abc");
	}
}
