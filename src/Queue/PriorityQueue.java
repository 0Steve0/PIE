package Queue;
/**
 * ClassName: PriorityQueue
 * Description: A class to implement priority queue
 * Date: 2017-5-3
 *
 * Update History:
 *
 * 
 * @version 1.0 
 * @author Steve Shao
 */
public class PriorityQueue {
	public class PriorityQ{
		private int maxSize;
		private long[] queArray;
		private int nItems;
		
		//constructor
		public PriorityQ(int s){
			maxSize=s;
			queArray=new long[maxSize];
			nItems=0;
		}
		
		public void insert(long item){
			int j;
			if(nItems==0)
				queArray[nItems++]=item;
			else{
				for(j=nItems-1;j>=0;j--){
					if(item>queArray[j])
						queArray[j+1] = queArray[j];
					else
						break;
				}
				queArray[j+1]=item;
				nItems++;
			}
		}
		public long remove(){
			return queArray[--nItems];
		}
		
	}
}
