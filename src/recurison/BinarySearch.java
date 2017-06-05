package recurison;
/**
 * ClassName: BinarySearch
 * Description: A class that implement binary search
 * Date: 2017-4-26
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class BinarySearch {

	/*
	 * binary search method
	 */
	public static int binarysearch(int[] array,int target){
		if(array==null)
			throw new IllegalArgumentException("cannot serach in an empty array");
		int mid=array.length/2;
		if(target<array[mid]){
			int[] newarray=new int[mid];
			for(int i=0;i<mid;i++)
				newarray[i]=array[i];
			return binarysearch(newarray,target);
		}
		if(target>array[mid]){
			int[] newarray = new int[array.length-1-mid];
			for(int i=0;i<array.length-mid-1;i++)
				newarray[i]=array[i+mid+1];
			return binarysearch(newarray,target)+mid+1;
		}
		if(target==array[mid])
			return mid;
		
		throw new IllegalArgumentException("cannot find the target value in this array");
	}
	/*
	 * test main funciton
	 */
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9,10,11};
		System.out.print(binarysearch(a,11));
		
	}
}
