package sorting;
/**
 * ClassName: Selectionsort
 * Description: A class that implement selection sort
 * Date: 2017-4-27
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
public class Selectionsort {

	/*
	 * selection sort
	 */
	public static int[] selectionsort(int[] array){
		int[] orderedarray=new int[array.length];
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[i]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
			orderedarray[i]=array[i];
		}
		return orderedarray;
	}
	/*
	 * test main function
	 */
	public static void main(String[] args){
		int[] a={6,2,1,4,5,5};
		for(int i=0;i<a.length;i++)
			System.out.print(selectionsort(a)[i]);
	}
}
