package linkedlist;

/**
 * ClassName: MtoLastLinkedlist
 * Description: A class to implement single linked list and return m to last elements
 * Date: 2017-4-19
 *
 * Update History:
 * 
 * 
 * @version 1.0 
 * @author Steve Shao
 */
 

 
/**
 * generic Single LinkedList class (Generic implementation)
 */
class Linkedlist2<T> {
    private Node<T> first; 
    public int currentsize;
    /**
     * generic Single LinkedList constructor
     */
    public Linkedlist2(){
    	first=null;
    	currentsize=0;
           /* first.setnextnode(null) will throw a nullobject exception
            * Calling the instance method of a null object.
              Accessing or modifying the field of a null object.
              Taking the length of null as if it were an array.
              Accessing or modifying the slots of null as if it were an array.
              Throwing null as if it were a Throwable value.
           */
    }
    
    /*
     * check the single linkedlist is empty 
     */
     public boolean isEmpty(){
		 if(first==null)
		 return true;
		 else
		 return false;
     }
    /**
     * Insert New Node at first position of generic Single LinkedList 
     */
    public void insertFirst(T data) {
       Node<T> newNode = new Node<T>(data);  //Creation of New Node.
       newNode.next=first;   //newLink ---> old first
       first = newNode;  //first ---> newNode
       currentsize++;
    }
 
    /**
     * Deletes first Node of generic Single LinkedList 
     */
    public Node<T> deleteFirst()
    {
       if(first==null){              
    	   throw new IllegalArgumentException("Cannot remove the empty linkedlist"); 
    	 
       }
       Node<T> tempNode = first; // save reference to first Node in tempNode- so that we could return saved reference.
       first = first.next; // delete first Node (make first point to second node)
       currentsize--;
       return tempNode; // return tempNode (i.e. deleted Node)
    }
    
           
    /**
     * Display generic Single LinkedList 
     */
    public void displayLinkedList() {
       System.out.print("Displaying LinkedList [first--->last]: ");
       Node<T> tempDisplay = first; // start at the beginning of linkedList
       while (tempDisplay != null){ // Executes until we don't find end of list.
              tempDisplay.displaydata();
              tempDisplay = tempDisplay.next; // move to next Node
       }
       System.out.println(" "); 
    }
    /*
     * reverse the current linked list and then take the m elements out from the start point
     * O(N) in time and O(N) in memory footprint
     */
    public Linkedlist2<T> MtoLast(int m){
    	if(first==null)
    		throw new IllegalArgumentException("cannot take from empty linkedlist");
    	if(m<0) 
    		throw new IllegalArgumentException("wrong input value of m");
    	if(m>=currentsize)
    		throw new IllegalArgumentException("wrong input value of m");
    	Node<T> currentposition=first;
    	/*
    	 * move current position to the last element of linked list
    	 * and also reverse the current linked list
    	 */
    	Linkedlist2<T> reverselinkedlist= new Linkedlist2<T>();
    	while(currentposition!=null){
    		reverselinkedlist.insertFirst(currentposition.getdata());
    		currentposition=currentposition.next;
    	}
    	
    	//take all the elements out starting from last element
    	Linkedlist2<T> newlinkedlist= new Linkedlist2<T>();
    	Node<T> tempposition=reverselinkedlist.first;
    	for(int i=0;i<m+1;i++){
    		newlinkedlist.insertFirst(tempposition.getdata());
    		tempposition=tempposition.next;
    	}
    	
    	return newlinkedlist;
    }
    public Node<T> Melement(int m){
    	Node<T> firstpointer, secondpointer;
    	if(first==null)
    		return null;
    	firstpointer=first;
    	
    	for(int i=0;i<=m;i++){
    		if(firstpointer!=null)
    			firstpointer=firstpointer.next;	
    		else
    			return null;
    	}
    	
    	secondpointer=first;
    	while(firstpointer!=null){
    		firstpointer=firstpointer.next;
    		secondpointer=secondpointer.next;
    	}
    	return secondpointer;
    	
    }
}
/*
 * test main function
 */
public class MtoLastLinkedlist {
	public static void main(String[] args){
		Linkedlist2<Integer> mylist=new Linkedlist2<Integer>();
		mylist.insertFirst(1);
		mylist.insertFirst(2);
		mylist.insertFirst(3);
		mylist.displayLinkedList();
	    mylist.Melement(3).displaydata();
	}
}
