package arrayandstring;

/**
 * ClassName: ReverseWords
 * Description: A class that reverse words
 * Date: 2017-4-25
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */

public class ReverseWords {
    
	/*
	 * reverse the current string
	 */
	public static String reversewords(String str){
		
		StringBuffer mystringbuffer = new StringBuffer();	
		StringBuffer tempstringbuffer = new StringBuffer();
		
		for(int i=str.length()-1;i>=0;i--){
			if(str.charAt(i)!=32)//append char into tempstringbuffer if word is not space
				tempstringbuffer.append(str.charAt(i));
			else{
				/*
				 * reverse word and append into mystringbuffer 
				 * reset tempstringbuffer in order to reuse it
				 */
				tempstringbuffer=reverse(tempstringbuffer);
				mystringbuffer=mystringbuffer.append(tempstringbuffer);
				mystringbuffer.append(" ");
				tempstringbuffer.setLength(0);
			}
			//in the end reverse and append
			if(i==0){
				tempstringbuffer=reverse(tempstringbuffer);
				mystringbuffer=mystringbuffer.append(tempstringbuffer);
			}
				
		}
		return mystringbuffer.toString();
	}
    /*
     * reverse the current word 
     */
	private static StringBuffer reverse(StringBuffer mystringbuffer) {
		StringBuffer newstringbuffer = new StringBuffer();
		for(int i=mystringbuffer.length()-1;i>=0;i--){
			newstringbuffer.append(mystringbuffer.charAt(i));
		}
		return newstringbuffer;
	}
	/*
	 * test main function
	 */
	public static void main(String[] args){
		System.out.print(reversewords("hello! shao liujia"));
		
	}

}
