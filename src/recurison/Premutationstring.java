package recurison;
/**
 * ClassName: Premutationstring
 * Description: A class that permuted string 
 * Date: 2017-4-26
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Premutationstring {
	/*
	 * the solution from text book 
	 */
	public static class Permutations{
		private boolean[] used;
		private StringBuilder out = new StringBuilder();
		private final String in;
		
		public Permutations(final String str){
			in=str;
			used=new boolean[in.length()];
		}
		
		public void permute(){
			if(out.length()==in.length()){
				System.out.println(out);
				return;
			}
			for(int i=0;i<in.length();i++){
				if(used[i]) continue;
				out.append(in.charAt(i));
				used[i]=true;
				permute();
				used[i]=false;
				out.setLength(out.length()-1);
				
			}	
		}
	}
	/*
	 *  another solution
	 *  take one character each time and permuted the rest string each time with taking first character
	 */
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	/*
	 * test main function
	 */
	public static void main(String[] args){
		Permutations mypermutaion = new Permutations("abc");
		mypermutaion.permute();
		permutation("abc");
	}
	
}
