package arrayandstring;
/**
 * ClassName: StringtoInteger
 * Description: A class that converse string to integer
 * Date: 2017-4-26
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class StringtoInteger {
	
	/*
	 * change string to integer
	 */	
	public static int stringtoint(String str){
		boolean isnegative = false;
		int num=0,i=0;
		if(str.charAt(0)=='-'){
			isnegative = true;
			i=1;
		}	
		while(i<str.length()){
			num=num*10;
			num=num+(str.charAt(i)-'0');
			i++;
		}
		if(isnegative)
			num=-num;
		return num;
	}
	/*
	 * change int to string
	 */
	public static String inttostring(int num){
		boolean isnegative = false;
		StringBuffer mystringbuffer = new StringBuffer();
		StringBuffer tempstringbuffer = new StringBuffer();
		if(num<0){
			isnegative=true;
			num=-num;
		}
		while(num!=0){
			tempstringbuffer.append(num%10);
			num=num/10;
		}
		if(isnegative){
			mystringbuffer.append('-');
		}
		for(int i=tempstringbuffer.length()-1;i>=0;i--)
			mystringbuffer.append(tempstringbuffer.charAt(i));
		return mystringbuffer.toString();
	}
	public static void main(String[] args){
		System.out.println(inttostring(-1234));
		System.out.print(stringtoint("-1234"));
		
	}
}
