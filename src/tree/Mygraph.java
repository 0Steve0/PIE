package tree;
/**
 * ClassName: Mygraph
 * Description: A class that implement graph using dfs in java
 * Date: 2017-4-25
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * stack that using fixed size array
 */
class Stackusingarray{
	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	//constructor
	public Stackusingarray(){
		st=new int[SIZE];
		top=-1;
	}
	
	public void push(int j){
		if(top==(SIZE-1))
			throw new IllegalArgumentException("canot push more data");
		else{
			top++;
			st[top]=j;
		}
	}
	
	public int pop(){
		int temp;
		if(top==-1)
			throw new IllegalArgumentException("cannot pop empty stack");
		else{
			temp = st[top];
		    top--;
		}
		return temp;
	}
	
	public int peek(){
		return st[top];
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}
/*
 * Queue using fixed array
 */
class Queueusingarray{
	private final int SIZE = 20;
	private int[] st;
	private int currentsize;
	private int bottom;
	
	//constructor
	public Queueusingarray(){
		st=new int[SIZE];
		currentsize=0;
		bottom=0;
	}
	
	public void push(int j){
		if(currentsize==SIZE)
			throw new IllegalArgumentException("canot push more data");
		else{
			st[currentsize]=j;
			currentsize++;
		}
	}
	
	public int pop(){
		int temp;
		if(currentsize==0)
			throw new IllegalArgumentException("cannot pop empty queue");
		else{
			temp = st[bottom];	
			bottom++;
		}
		return temp;
	}
	
	public int peek(){
		return st[bottom];
	}
	
	public boolean isEmpty(){
		if(currentsize==0)
			return true;
		else{
		if(currentsize<=bottom)
			return true;
		else
			return false;
		}
	}
}
/*
 * vertex class in graph
 */
class Vertex{
	public String label;
	public boolean wasvisited;
	
	public Vertex(String label){
		this.label=label;
		wasvisited=false;
	}
}
/*
 * graph class
 */
class Graph{
	private final int MAX_VERTEXS=20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stackusingarray mystack;
	private Queueusingarray myqueue;
	
	//constructor
	public Graph(){
		vertexList = new Vertex[MAX_VERTEXS];
		adjMat = new int[MAX_VERTEXS][MAX_VERTEXS];
		nVerts=0;
		for(int j=0;j<MAX_VERTEXS;j++)
			for(int i=0;i<MAX_VERTEXS;i++)
				adjMat[j][i]=0;
		mystack = new Stackusingarray();
		myqueue = new Queueusingarray();
	}
	
	public void addVertex(String label){		
		vertexList[nVerts] = new Vertex(label);
		nVerts++;
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	/*
	 * deepth first search
	 */
	public void dfs(){
		vertexList[0].wasvisited = true;
		displayVertex(0);
		mystack.push(0);
		
		while(!mystack.isEmpty()){
			int v = getAdjUnvisitedVertex(mystack.peek());
			if(v==-1)
				mystack.pop();
			else{
				vertexList[v].wasvisited=true;
				displayVertex(v);
				mystack.push(v);
			}
		}
		
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasvisited=false;
		}
	}
	/*
	 * breadth first search
	 */
	public void bfs(){
		vertexList[0].wasvisited = true;
		displayVertex(0);
		myqueue.push(0);
		
		while(!myqueue.isEmpty()){
			int v = getAdjUnvisitedVertex(myqueue.peek());
			if(v==-1)
				myqueue.pop();
			else{
				vertexList[v].wasvisited=true;
				displayVertex(v);
				myqueue.push(v);
			}
		}
		
		for(int i=0; i<nVerts; i++){
			vertexList[i].wasvisited=false;
		}
	}
	private int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
		  if(adjMat[v][j]==1 && vertexList[j].wasvisited==false)
			  return j;
		return -1;
	}
}
/*
 * test main function
 */
public class Mygraph {
	public static void main(String[] args)
	{
	Graph theGraph = new Graph();
	theGraph.addVertex("A"); // 0 (start for dfs)
	theGraph.addVertex("B"); // 1
	theGraph.addVertex("C"); // 2
	theGraph.addVertex("D"); // 3
	theGraph.addVertex("E"); // 4
	theGraph.addEdge(0, 1); // AB
	theGraph.addEdge(1, 2); // BC
	theGraph.addEdge(0, 3); // AD
	theGraph.addEdge(3, 4); // DE
	System.out.print("Visits: ");
	//theGraph.dfs(); // depth-first search
	theGraph.bfs();
	System.out.println();
	}
}
