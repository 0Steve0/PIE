package tree;

/**
 * ClassName: Myheap
 * Description: A class that implement heap in java
 * Date: 2017-4-23
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * Heap node for my own designed heap
 */
class heapnode{
	private int data;
	
	//constructor
	public heapnode(int data){
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}	
}
/*
 * Heap class
 * Heap is actually an array that has a weakly ordered completed tree
 */
class Heap{
	private heapnode[] heaparray;
	private int maxsize;
	private int currentsize;
	
	//constructor
	public Heap(int maxsize){
		currentsize=0;
		this.maxsize=maxsize;
		heaparray=new heapnode[maxsize];
	}
	
	/*
	 * insert function
	 * insert at the last index of an array and then trickle it up
	 */
	public void insert(int data){
		heapnode newnode = new heapnode(data);
		if(currentsize==maxsize)
			throw new IllegalArgumentException("cannot insert into a full heap");
		else{
			heaparray[currentsize]=newnode;
		    trickleup(currentsize++);		
		}
	}
	private void trickleup(int index) {
		int parent=	(index-1)/2;
		heapnode bottom= heaparray[index];
		while(index>0&&heaparray[parent].getData()<bottom.getData()){
			heaparray[index]=heaparray[parent];
			index=parent;
			parent=(parent-1)/2;
		}
		heaparray[index]=bottom;
	}

	/*
	 * delete function
	 * delete the first and use the last of this array to trick it down
	 */
	public heapnode delete(){
		if(currentsize==0)
			throw new IllegalArgumentException("cannot delete an empty heap");
		else{
			heapnode root=heaparray[0];
			currentsize--;
			heaparray[0]=heaparray[currentsize];
			trickledown(0);
			return root;
		}
	}
	
	private void trickledown(int index) {
		int largerchild;
		heapnode top=heaparray[index];
		while(index<currentsize/2){
			int leftchild=2*index+1;
			int rightchild=leftchild+1;
			if(rightchild<currentsize&heaparray[leftchild].getData()<heaparray[rightchild].getData())
				largerchild=rightchild;
			else
				largerchild=leftchild;
			if(top.getData()>=heaparray[largerchild].getData())
				break;
			
			heaparray[index]=heaparray[largerchild];
			index=largerchild;	
		}
		heaparray[index]=top;
		
	}

	//display the heap in the array form
	public void displayinarray(){
		for(int i=0;i<currentsize;i++)
			System.out.println(heaparray[i].getData());	
	}
	
	//display the heap in the tree form
	public void displayintree(){
		int itemofcurrentrow=1;
		int currentrow=0;
		int currentitem=0;
		while(currentitem!=currentsize){
			System.out.print(heaparray[currentitem].getData()+" ");
			currentitem++;
		    if(currentitem>=itemofcurrentrow){
		    	System.out.print("\n");
		    	currentrow++;
		    	itemofcurrentrow=itemofcurrentrow+(int) Math.pow(2,currentrow);
		    }
		}
	}
	
}
public class Myheap {
	public static void main(String[] args){
		Heap myheap = new Heap(10);
		myheap.insert(1);
		myheap.insert(2);
		myheap.insert(3);
		myheap.insert(4);
		myheap.insert(5);
		myheap.insert(6);
		myheap.insert(7);
		myheap.insert(8);
		//myheap.delete();
		//myheap.delete();
		//myheap.displayinarray();
		myheap.displayintree();
		//System.out.println((2+1)/2);
	}
}
