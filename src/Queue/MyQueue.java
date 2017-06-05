package Queue;
/**
 * ClassName: MyQueue
 * Description: My own implementation of queue in java
 * 
 * Date: 2017-5-14
 *
 * Update History:
 *
 * @version 1.0 
 * @author Steve Shao
 */
class Queue
{
		private int maxSize;
		private long[] queArray;
		private int front;
		private int rear;
		
		public Queue(int s) // constructor
		{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		}
		
		public void insert(long j) // put item at rear of queue
		{
		if(rear == maxSize-1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		}

		public long remove() // take item from front of queue
		{
		long temp = queArray[front++]; // get value and incr front
		if(front == maxSize) // deal with wraparound
			front = 0;
		return temp;
		}
}
public class MyQueue {

}
