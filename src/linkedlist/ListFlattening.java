package linkedlist;
/**
 * ClassName: ListFlattening
 * Description: A class to implement doubly linked list and flatten the list to show on a single level
 * Date: 2017-4-21
 *
 * Update History:
 * 
 * 
 * @version 1.0 
 * @author Steve Shao
 */
/*
 * the basic element in a doubly linked list
 */
class Doublylinkedlistelement<T>{
	private T data;
	public Doublylinkedlistelement<T> pre;
	public Doublylinkedlistelement<T> next;
	public Doublylinkedlistelement<T> child;
	
	//constructor
	public Doublylinkedlistelement(T data){
		this.data=data;
		pre=null;
		next=null;
		child=null;
	}
    /*
     * set and get method for data in this element
     * avoiding null pointer exception here.
     */
	public T getdata(){
		return data;
	}
	
	public void setdata(T data){
		this.data=data;
	}
	
	public void displaydata() {
		System.out.print(data+" ");	
	}
}
/*
 * the class that implement doubly linked list
 */
class Doublylinkedlist<T>{
	public Doublylinkedlistelement<T> head;
	public Doublylinkedlistelement<T> tail;
	
	//constructor
	public Doublylinkedlist(){
		head=null;
	}
	/*
	 * insert into the top of this doubly linked list and keep track of tail element.
	 */
	public void insert(Doublylinkedlistelement<T> newelement){
		
		if(head==null){
			head=newelement;
			tail=null;
		}
		else{
			newelement.next=head;
			head.pre=newelement;
			tail=head;
			head=newelement;	
		}		
	}
	/*
	 * delete the first value of this doubly linked list
	 */
	public Doublylinkedlistelement<T> delete(){
		if(head==null)
			throw new IllegalArgumentException("cannot delete the empty doubly linked list");
		Doublylinkedlistelement<T> tempelement;
		tempelement=head;
		head=head.next;
		return tempelement;
	}
	/*
	 * display doubly linkedlist in the console
	 */
    public void display() {
        System.out.print("Displaying LinkedList [first--->last]: ");
        Doublylinkedlistelement<T> tempDisplay = head; // start at the beginning of linkedList
        while (tempDisplay != null){ // Executes until we don't find end of list.
               tempDisplay.displaydata();
               tempDisplay = tempDisplay.next; // move to next Node
        }
        System.out.println(" "); 
    }
	
    public void flattenshowindepth(Doublylinkedlistelement<T> head){
  
		Doublylinkedlistelement<T> tempDisplay = head; // start at the beginning of linkedList
		while (tempDisplay != null){ // Executes until we don't find end of list. 
		   tempDisplay.displaydata();
		      if(tempDisplay.child!=null){
		    	  flattenshowindepth(tempDisplay.child);
		      }
		      tempDisplay = tempDisplay.next; // move to next Node
		   }
		   System.out.println(" ");
		}
    /*
     * flatten show the linked list in bredth
     */
    public void flattenshowinbredth(){
		
    	Doublylinkedlistelement<T> tempDisplay = head; // start at the beginning of linkedList
		while (tempDisplay != null){ // Executes until we don't find end of list. 
		   tempDisplay.displaydata();
		      if(tempDisplay.child!=null)
		    	  appendtotail(tempDisplay.child);
		      tempDisplay = tempDisplay.next; // move to next Node
		   }
		   System.out.println(" ");
		}
   
    public void appendtotail(Doublylinkedlistelement<T> newelement){
    	tail.next=newelement;
    	newelement.pre=tail;
    	if(newelement!=null)
    		newelement=newelement.next;
    	tail=newelement;
    }
    
    /*
     * unflatten the linked list we have here
     */
    public void unflatten(Doublylinkedlistelement<T> head){
		Doublylinkedlistelement<T> tempDisplay = head; // start at the beginning of linkedList
		while (tempDisplay != null){ // Executes until we don't find end of list. 
		   tempDisplay.displaydata();
		      if(tempDisplay.child!=null){
		    	  tempDisplay.child.pre.next=null;
		    	  tempDisplay.child.pre=null;
		    	  unflatten(tempDisplay.child);
		      }
		      tempDisplay = tempDisplay.next; // move to next Node
		   }
		   System.out.println(" ");
    }
}
/*
 * test main function	
 */
public class ListFlattening {
	public static void main(String[] args){
		Doublylinkedlist<Integer> mylist1=new Doublylinkedlist<Integer>();
		Doublylinkedlist<Integer> mylist2=new Doublylinkedlist<Integer>();
		Doublylinkedlist<Integer> mylist3=new Doublylinkedlist<Integer>();
		Doublylinkedlistelement<Integer> element1=new Doublylinkedlistelement<Integer>(1);
		Doublylinkedlistelement<Integer> element2=new Doublylinkedlistelement<Integer>(2);
		Doublylinkedlistelement<Integer> element3=new Doublylinkedlistelement<Integer>(3);
		Doublylinkedlistelement<Integer> element4=new Doublylinkedlistelement<Integer>(4);
		Doublylinkedlistelement<Integer> element5=new Doublylinkedlistelement<Integer>(5);
		Doublylinkedlistelement<Integer> element6=new Doublylinkedlistelement<Integer>(6);
		mylist1.insert(element1);
		mylist1.insert(element2);
		mylist2.insert(element3);
		mylist2.insert(element4);
		mylist3.insert(element5);
		mylist3.insert(element6);
		element2.child=element4;
		//element4.child=element6;
		//mylist.delete();
		//mylist.head.displaydata();
		//mylist.tail.displaydata();
		//mylist.display();
		//mylist1.flattenshowindepth(mylist1.head);
		mylist1.flattenshowinbredth();
		mylist1.unflatten(mylist1.head);
		
	}
}
