package linkedlist;
/**
 * ClassName: MystackusingArray
 * Description: A class to implement stack in java using array
 * Date: 2017-5-13
 *
 * Update History:
 *
 * @version 1.0 
 * @author Steve Shao
 */
class Mystack2{
	private int capacity;
	private int top;
	private int[] stackarray;
	
	
	/*
	 * constructor
	 */
	public Mystack2(int capacity){
		stackarray = new int[capacity];
		top=0;
		this.capacity=capacity;
	}
	
	public void push(int element){
		if(top==capacity)
			throw new IllegalArgumentException("cannot push more data");
		stackarray[top]=element;
		top++;
	}
	
	public int pop(){
		if(top==0)
			throw new IllegalArgumentException("cannot pop more data");
		top--;
		return stackarray[top];
		
	}
	
}
public class MystackusingArray {
	
	public static void main(String[] args){
		Mystack2 mystack = new Mystack2(5);
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
	}
}
