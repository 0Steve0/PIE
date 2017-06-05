package linkedlist;
/**
 * ClassName: Mystack
 * Description: A class to implement stack in java using generic
 * Date: 2017-4-18
 *
 * Update History:
 *
 * 
 * @version 1.0 
 * @author Steve Shao
 */
/*
 *Stack element class, which holds data and contains next which points to next Node.
 */
class Element<T>{
	private T data;
	public Element<T> next;
	
	public Element(T data){
		this.data=data;
	}
	
	public void setdata(T data){
		this.data=data;
	}
	public T getdata(){
		return data;
	}
	public void display(){
		System.out.print(data+" ");
	}
}
/*
 * Stack class that has three functions pop() push() and peek()
 */
class Stack<T>{
	private Element<T> first;
	private int currentsize;
    private int capacity;
    
	public Stack(int capicity){
		first=null;
		currentsize=0;
		this.capacity=capicity;
	}
   
	public Element<T> pop(){
		if(first==null)
			throw new IllegalArgumentException("cannot pop empty stack");	
		else{
			Element<T> tempelement;
		    tempelement=first;
		    first=tempelement.next;
			currentsize--;
		    return tempelement;
			
		}
    }
    public void push(T data){
    	if(peek()){
    		throw new IllegalArgumentException("cannot push more data");
    	}   		
    	else{
    		Element<T> newelement=new Element<T>(data);
    	    newelement.next=first;
    	    first=newelement;
    	    currentsize++;
    	}
    }
    public boolean peek(){
    	return currentsize==capacity;
    }
    
    public void display(){
    	Element<T> tempelement;
    	if(first!=null){
    		tempelement=first;
    		System.out.print("Stack has: ");
    		while(tempelement!=null){
    			tempelement.display();
    			tempelement=tempelement.next;
    		}
    	}
    	else
    		throw new IllegalArgumentException("cannnot display empty stack");
    }
}

public class Mystack {
  public static void main(String[] args){
	  Stack<Integer> mystack=new Stack<Integer>(3);
	  mystack.push(1);
	  mystack.push(2);
	  mystack.push(3);
	  mystack.push(4);
	  mystack.pop();
	  mystack.display();
	  
	  
  }
}
