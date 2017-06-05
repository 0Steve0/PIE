package concurrency;

import java.util.Random;

/**
 * ClassName: ProducerandConsumer
 * Description: A class that implement producer and consumer
 * Date: 2017-4-29
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * Buffer area for one producer and consumer
 */
class Buffer{
	private int index;
	private int[] buffer = new int[10];
	
	//constructor
	public Buffer(){
		index=0;
	}
	
	//add elements to buffer area
	public void add(int num){
		while(true){
			if(index<buffer.length){
				buffer[index++]=num;
				return;
			}
		}
	}
	//remove elements from buffer area
	public int remove(){
		while(true){
			if(index>0)
				return buffer[--index];
		}
	}
}
/*
 * Producer class
 */
class Producer extends Thread{
	private Buffer mybuffer;
	
	//constructor
	public Producer(Buffer mybuffer){
		this.mybuffer=mybuffer;
	}
	
	public void run(){
		Random r = new Random();
		while(true){
			int num = r.nextInt();
			mybuffer.add(num);
			System.out.println("Produced: " +num);
		}
	}
}
/*
 * Consumer class
 */
class Consumer extends Thread{
	private Buffer mybuffer;
	
	//constructor
	public Consumer(Buffer mybuffer){
		this.mybuffer=mybuffer;
	}
	
	public void run(){
		while(true){
			int num=mybuffer.remove();
			System.out.println("Consumed: " +num);
		}
	}
}
/*
 * test main function
 */
public class ProducerandConsumer {
	public static void main(String[] args){
		Buffer b = new Buffer();
		Producer p = new Producer( b );
		Consumer c = new Consumer( b );
		p.start();
		c.start();
	}
}
