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
public class Telephonewords {

	/*
	 * get character class
	 */
	private static char getchar(char telephonekey, int place){
		switch(telephonekey){
		case '0': 
			return '0';
		case '1': 
			return '1';
		case '2':
		{
			if(place==1)
				return 'A';
			if(place==2)
				return 'B';
			if(place==3)
				return 'C';
			}
			break;
		case '3': 
		{
			if(place==1)
				return 'D';
			if(place==2)
				return 'E';
			if(place==3)
				return 'F';
			}	
			break;
		case '4': 
		{
			if(place==1)
				return 'G';
			if(place==2)
				return 'H';
			if(place==3)
				return 'I';
			}	
			break;
		case '5': 
		{
			if(place==1)
				return 'J';
			if(place==2)
				return 'K';
			if(place==3)
				return 'L';
			}	
			break;
		case '6': 
		{
			if(place==1)
				return 'M';
			if(place==2)
				return 'N';
			if(place==3)
				return 'O';
			}
			break;
		case '7': 
		{
			if(place==1)
				return 'P';
			if(place==2)
				return 'R';
			if(place==3)
				return 'S';
			}	
			break;
		case '8': 
		{
			if(place==1)
				return 'T';
			if(place==2)
				return 'U';
			if(place==3)
				return 'V';
			}	
			break;
		case '9': 
		{
			if(place==1)
				return 'W';
			if(place==2)
				return 'X';
			if(place==3)
				return 'Y';
			}	
			break;
		}
		throw new IllegalArgumentException("wrong input variable");
	}
	
	/*
	 * combination of telephone number
	 */
	public static void combinate(String output,String telephonenumber,int originallength){
		int N = telephonenumber.length();
		if(output.length()==originallength)//when output length is the telephonenumber length-->print
			System.out.println(output);
		for(int i=0;i<N;i++)
			if(telephonenumber.charAt(i)=='0'||telephonenumber.charAt(i)=='1')
				combinate(output+getchar(telephonenumber.charAt(i),1),telephonenumber.substring(i+1),originallength);
			else{
				for(int j=1;j<=3;j++)
					combinate(output+getchar(telephonenumber.charAt(i),j),telephonenumber.substring(i+1),originallength);
			}
	}
	/*
	 * combination of telephone number without recursion
	 */
	
	public static void combinatewithoutrecursion(String telephonenumber){
		int N = telephonenumber.length();
		char[] result = new char[N];
		//initialize result with the first telephone choice
		for(int i=0;i<N;i++)
			result[i] = getchar(telephonenumber.charAt(i),1);
		
		for(;;){
			for(int i=0;i<N;i++)
				System.out.print(result[i]);
			System.out.print('\n');
			
			/*
			 * start at the end and try to increment from right to left
			 */
			for(int i=N-1;i>=-1;i--){
				if(i==-1)
					return;
				/* Start with high value, carry case so 0 and 1
				* special cases are dealt with right away
				*/
				if( getchar( telephonenumber.charAt(i), 3 ) == result[i] ||
						telephonenumber.charAt(i) == 0 || telephonenumber.charAt(i) == 1 ){
				result[i] = getchar( telephonenumber.charAt(i), 1 );
				// No break, so loop continues to next digit
				} else if ( getchar( telephonenumber.charAt(i), 1 ) == result[i] ) {
				result[i] = getchar( telephonenumber.charAt(i), 2 );
				break;
				} else if ( getchar( telephonenumber.charAt(i), 2 ) == result[i] ) {
				result[i] = getchar( telephonenumber.charAt(i), 3 );
				break;
				}
				
			}
		}
		
	}
	/*
	 * test main function
	 */
	public static void main(String[] args){
		String a="01234";
		combinate("",a,5);
	}
}
