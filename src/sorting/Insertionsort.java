package sorting;
/**
 * ClassName: Insertionsort
 * Description: A class that implement insertion sort
 * Date: 2017-4-27
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Insertionsort {

	/*
	 * insetion sort
	 */
	public static int[] insertionsort(int[] array){
		for(int which=1;which<array.length;which++){
			int val = array[which];
			for(int i=0;i<which;i++){
				if(array[i]>val){
					System.arraycopy(array, i, array, i+1, which-i);
					array[i]=val;
					break;
				}
			}
		}
		return array;
	}
	
	/*
	 * test main function
	 */
	public static void main(String[] args){
		int[] a={6,2,1,4,5};
		for(int i=0;i<a.length;i++)
			System.out.print(insertionsort(a)[i]);
		
	}
}
