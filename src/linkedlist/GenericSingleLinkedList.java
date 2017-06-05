package linkedlist;
/**
 * ClassName: GenericSingleLinkedList
 * Description: A class to implement single linkedlist in java using generic
 * Date: 2017-4-17
 *
 * Update History:
 * 1.adding delete and find methods in the program/2017-4-18
 * 2.adding determine the linked list is acylic or cylic mehod
 * @version 3.0 
 * @author Steve Shao
 */
 
/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node<T> {
	public T data; // data in Node.
    public Node<T> next; // points to next Node in list.
 
    /**
     * Constructor
     */
    public Node(T data){
    	this.data = data;
    }
     
    public T getdata() {
    	return data;
    }   
    public void setdata(T data){
    	this.data=data;
    }
    
    public void displaydata(){
    	System.out.print(data+" ");
    }
    /*
     * i don't recommend using set/get for link to next point. cause it could be null 
     * will have a null object expection
     */
}
 
 
/**
 * generic Single LinkedList class (Generic implementation)
 */
class LinkedList<T> {
    private Node<T> first; 
 
    /**
     * generic Single LinkedList constructor
     */
    public LinkedList(){
           first=null;
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
    public void insertFirst(Node<T> newNode) {
           //Node<T> newNode = new Node<T>(data);  //Creation of New Node.
           newNode.next=first;   //newLink ---> old first
           first = newNode;  //first ---> newNode
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
     * delete the specific value of linkedlist
     */
    public Node<T> deletebyvalue(T data){
    	Node<T> tempnodecur=first;
    	Node<T> tempnodepre=first;
    	if(tempnodecur==null)
    		throw new IllegalArgumentException("Cannot delete an empty linkedlist"); 
    	else 
    	{ 
    	    while(tempnodecur!=null)	
    	    {
    		  if(tempnodecur.getdata()==data){
    		      tempnodepre.next=tempnodecur.next;
    			  return tempnodecur;
    			  }
    		  else{
    			  tempnodepre=tempnodecur;
    			  tempnodecur=first.next;
    			  }
    		      
            }
    	    throw new IllegalArgumentException("Cannot find the value you given"); 
    	}
		
    }
    
    /*
     * find the specific value of linkedlist
     */
    public Node<T> findbyvalue(T data){
    	Node<T> tempnode=first;
    	if(tempnode==null)
    		throw new IllegalArgumentException("Cannot find an empty linkedlist"); 
    	else 
    	{ 
    	    while(tempnode!=null)	
    	    {
    		  if(tempnode.getdata()==data)
    		      return tempnode;
    		  else
    			  tempnode=first.next;
            }
    	    throw new IllegalArgumentException("Cannot find the value you given"); 
    	} 	 
    }
    public boolean determinecylic(LinkedList<T> mylist){
    	Node<T> fast=mylist.first.next;
    	Node<T> slow=mylist.first;

    	while(fast!=null){
    		slow=slow.next;
		    fast=fast.next.next;
    	    if(fast==slow||slow.next==fast)
    			return true;
    		if(fast==null)
        		return false;
    	}
    	return false;
    }
}
 

/**
 * Main class - To test generic Single LinkedList .
 */
public class GenericSingleLinkedList {
    public static void main(String[] args) {
           LinkedList<Integer> linkedList = new LinkedList<Integer>(); // creation of Linked List
           
           Node<Integer> newNode1=new Node<Integer>(1);
           Node<Integer> newNode2=new Node<Integer>(2);
           Node<Integer> newNode3=new Node<Integer>(3);
           Node<Integer> newNode4=new Node<Integer>(4);
           Node<Integer> newNode5=new Node<Integer>(5);
           //Node<Integer> newNode6=new Node<Integer>(6);
           linkedList.insertFirst(newNode1);
           linkedList.insertFirst(newNode2);
           linkedList.insertFirst(newNode3);
           linkedList.insertFirst(newNode4);
           linkedList.insertFirst(newNode5);
           newNode1.next=newNode3;
           
           //linkedList.displayLinkedList(); 
           if(linkedList.determinecylic(linkedList))
        	   System.out.print("Is cylic");
           //linkedList.deleteFirst();  
           //linkedList.displayLinkedList();                              
           //linkedList.deleteFirst();    
          // linkedList.displayLinkedList(); 
          // System.out.println(linkedList.deletebyvalue(12).data);
           //linkedList.displayLinkedList();  

    }
}