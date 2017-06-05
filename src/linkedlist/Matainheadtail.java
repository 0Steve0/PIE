package linkedlist;
/**
 * ClassName: Matainheadtail
 * Description: A class to matain head and tail using singly linked list with java using generic
 * Date: 2017-4-18
 *
 * Update History:
 *
 * 
 * @version 1.0 
 * @author Steve Shao
 */

/*
 * this is the class that implement singly linked list which has two main functions
 */
class Mylinkedlist<T>{
	private Element<T> head;
	private Element<T> tail;
	private int currentsize;
	
	/*
	 * constructor
	 */
	public Mylinkedlist(){
		head=null;
		tail=null;
		currentsize=0;
	}
	/*
	 * check the linked list is empty or not first.
	 * delete from the beginning, if is head then update the head information, take care of the special case for one element linked list
	 * delete from the middle, if delete the last one, update the tail information
	 */
	public boolean delete(Element<T> e){
		Element<T> currentposition=head;
		Element<T> previousposition=head;
		
		if(tail==null)
			throw new IllegalArgumentException("cannot delete empty linked list");
		
		if(e.getdata()==head.getdata()){
			head=head.next;
			/*
			 * special case for one element list
			 */
			if(head==null)
				tail=null;
			currentsize--;
			return true;
		}
	    while(currentposition!=null){
	        if(currentposition.getdata()==e.getdata()){
	        	previousposition.next=currentposition.next;
	        	/*
	        	 * special case for deleting at the last, updating tail
	        	 */
	        	if(previousposition.next==null)
	        		tail=previousposition;	
	        	currentsize--;
	        	return true;
	        	}
	        	previousposition=currentposition;
	        	currentposition=currentposition.next;
	        }
	        return false;		
	}
	
	public boolean insertAfter(Element<T> e, T data){
		
		Element<T> newelement=new Element<T>(data);
        Element<T> currentposition=head;
        
        //insert at the beginning of list
        if(e==null){
        	newelement.next=head;
        	head=newelement;
        	
        	//special case for empty list
        	if(tail==null)
        		tail=newelement;
        	currentsize++;
        	return true;
        	
        }
        while(currentposition!=null){
        	if(currentposition.getdata()==e.getdata()){
        		newelement.next=currentposition.next;
        		currentposition.next=newelement;
        		/*
        		 * special case for insert at the end of linked list
        		 * remember updating tail 
        		 */
        		if(newelement.next==null)
        			tail=newelement;
        		currentsize++;
        		return true;
        		
        	}
        	currentposition=currentposition.next;
        }
        return false;
	}
	
	/*
	 * display all the values in the linked list
	 */
    public void display(){
    	Element<T> tempelement;
    	if(head!=null){
    		tempelement=head;
    		System.out.print("Linkedlist has: ");
    		while(tempelement!=null){
    			tempelement.display();
    			tempelement=tempelement.next;
    		}
    	}
    	else
    		throw new IllegalArgumentException("cannnot display empty linkedlist");
    }
}
/*
 * test main function
 */
public class Matainheadtail {
   public static void main(String[] args){
	   Mylinkedlist<Integer> mylist= new Mylinkedlist<Integer>();
	   Element<Integer> e= new Element<Integer>(10);
	   Element<Integer> e1= new Element<Integer>(12);
	   mylist.insertAfter(null, 10);
	   mylist.insertAfter(e, 11);
	   mylist.insertAfter(e, 12);
	   mylist.delete(e1);
	   mylist.delete(e);
	   mylist.display();
	   
   }
}
