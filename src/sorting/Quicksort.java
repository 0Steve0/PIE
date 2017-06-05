package sorting;
/**
 * ClassName: Quicksort
 * Description: A class that implement quick sort
 * Date: 2017-4-27
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * quick sort class
 */
class Arrayquicksort {
	private int[] theArray;
	private int nElems;
	
	public Arrayquicksort(int[] theArray){
		this.theArray=theArray;
		nElems=theArray.length;
	}
	public void display() {
		for(int i=0;i<nElems;i++)
			System.out.print(theArray[i]);	
	}
	/*
	 * quick sort 
	 */
	public void quicksort(){
		requicksort(0,nElems-1);
	}
	
	public void requicksort(int left,int right){
		if(right-left<=0)
			return;
		else{
			int pivot = theArray[right];
			int partition = partitionIt(left,right,pivot);
			requicksort(left,partition-1);
			requicksort(partition+1,right);
		}
	}

	private int partitionIt(int left, int right, int pivot) {
		int leftPtr = left-1;
		int rightPtr = right;
		while(true){
			while(theArray[++leftPtr]<pivot)
				;
			while(rightPtr>0&&theArray[--rightPtr]>pivot)
				;
			if(leftPtr>=rightPtr)
				break;
			else
				swap(leftPtr,rightPtr);	
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	private void swap(int leftPtr, int rightPtr) {
		int temp = theArray[leftPtr];
		theArray[leftPtr]=theArray[rightPtr];
		theArray[rightPtr]=temp;
	}
	
}
/*
 * test main function
 */
public class Quicksort{
	public static void main(String[] args){
		int[] test = {0,2,3,1,4,5,3,6,7,9,8};
		Arrayquicksort myquicksort = new Arrayquicksort(test);
		myquicksort.quicksort();
		myquicksort.display();
	}
}