package sorting;
/**
 * ClassName: Stableselectionsort
 * Description: A class that implement selection sort in a stable way
 * Date: 2017-4-29
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * original selection sort suffers from unstable problems. 
 * the reason is swap the element change the order of array.
 * in this approach, we change to insert instead of swap
 * 
 * we could also use linked list instead of array to improve the performance when it comes to delete and insert
 */
public class Stableselectionsort {

	/*
	 * stable selection sort
	 */
	// Sort an array using a stable selection sort.
	public void selectionSortStable( int[] data ){
		for( int start = 0; start < data.length - 1; ++start ){
			insert( data, start, findMinimumIndex( data, start ) );
		}
	}
	// Insert the data into the array, shifting the array as necessary.
	private void insert( int[] data, int start, int minIndex ){
		if( minIndex > start ){
			int tmp = data[minIndex];
			System.arraycopy( data, start, data, start +1 , minIndex - start);
			data[start] = tmp;
		}
	}
	private int findMinimumIndex( int[] data, int start ) {
		int minPos = start;
		for( int i = start + 1; i < data.length; ++i ){
			if( data[i] < data[minPos] ){
			minPos = i;
			}
		}
		return minPos;
	}
	
	/*
	 * test main function
	 */
	public static void main(String[] args){
		
		
	}
}
