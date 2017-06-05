package tree;
/**
 * ClassName: MyBST
 * Description: A class that implement BST which has find, delete and insert functions 
 * Date: 2017-4-21
 *
 * Update History:
 * 1. Adding calculating height function of current BST /2017-4-22
 * 2. Adding preorder traversal the BST/2017-4-22
 * 3. Adding preorder traversal without recursion with the new feature of Stack/2017-4-22
 * 4. Change the current TreeNode have both tree features and linked list feature
 * 
 * @version 5.0 
 * @author Steve Shao
 */

/*
 * Tree Node of BST
 */
class TreeNode{
	private int data;
	public TreeNode next;//using in the stack function
	public TreeNode leftchild;
	public TreeNode rightchild;
	
	//constructor
	public TreeNode(int data){
		this.setData(data);
		next=null;
		leftchild=null;
		rightchild=null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
/*
 * Mystack that could be used to store tree structure here
 */
class Stack{
	public TreeNode first;
	
	public Stack(){
		first=null;
	}
   
	public TreeNode pop(){
		if(first==null)
			throw new IllegalArgumentException("cannot pop empty stack");	
		else{
			TreeNode tempelement;
		    tempelement=first;
		    first=tempelement.next;
			return tempelement;
		}
    }
    public void push(TreeNode newelement){
    	    newelement.next=first;
    	    first=newelement;
    }
}
/*
 * My own BST
 */
class BST{
	
	public TreeNode root;
	
	//constructor
	public BST(){
	    root=null;
	}
	
	public TreeNode find(int data){
		TreeNode newnode = new TreeNode(data);
		/*
		 * use two node pointer to keep track of nodes here
		 */
		TreeNode currentnode=root;
		if(root==null)
			throw new IllegalArgumentException("Cannot find TreeNode in a empty BST");
		while(currentnode!=null){
		   if(newnode.getData()>currentnode.getData())
			   currentnode=currentnode.rightchild;
		   if(newnode.getData()<currentnode.getData())
			   currentnode=currentnode.leftchild;
		   if(currentnode.getData()==newnode.getData())
			   return currentnode;
		}
		throw new IllegalArgumentException("Cannot find TreeNode in a empty BST");
	}
	
	public void insert(int data){
		TreeNode newnode = new TreeNode(data);
		
		if(root==null)//when the tree is empty
			root=newnode;
		else{
			/*
			 * use two node pointer to keep the track of node need to be inserted
			 */
			TreeNode currentnode=root;
			TreeNode parentnode;
			while(currentnode!=null){
			   parentnode=currentnode;
			   if(newnode.getData()>=currentnode.getData()){
				   currentnode=currentnode.rightchild;
				   if(currentnode==null)
					   parentnode.rightchild=newnode;
			   }
			   else{
				   currentnode=currentnode.leftchild;
				   if(currentnode==null)
					   parentnode.leftchild=newnode;
			   }		   
			}
		}		
	}

	/*
	 * delete has three different situations here 
	 * 1.the delete node has no child
	 * 2.the delete node has one child
	 * 3.the delete node has two children
	 */
	public void delete(int data){
		TreeNode deletednode=new TreeNode(data);
		TreeNode currentnode=root;
		TreeNode parentnode = null;
		boolean isright = false;
		boolean isleft = false;
		/*
		 * find the node firstly
		 * And also record the parent node of current deleted node
		 */
		if(root==null)
			throw new IllegalArgumentException("cannot delete a empty BST");
		else{
			while(currentnode!=null){
			   parentnode=currentnode;
			   if(deletednode.getData()>currentnode.getData()){
				   currentnode=currentnode.rightchild;
				   isright=true;
			   }
			   if(deletednode.getData()<currentnode.getData()){
				   currentnode=currentnode.leftchild;
				   isleft=true;
			   }
			   if(deletednode.getData()==currentnode.getData())
				   break;
			}
			if(currentnode==null)
				throw new IllegalArgumentException("cannot find that data in BST");
		}
		/*
		 * first case
		 */
		if(currentnode.leftchild==null&currentnode.rightchild==null){
			if(isright)
				parentnode.rightchild=null;
		    if(isleft)
		    	parentnode.leftchild=null;
		}
		/*
		 * second case
		 */
		if(currentnode.leftchild!=null&currentnode.rightchild==null){
			if(isright)
				parentnode.rightchild=currentnode.leftchild;
		    if(isleft)
		    	parentnode.leftchild=currentnode.leftchild;
		}
		if(currentnode.leftchild==null&currentnode.rightchild!=null){
			if(isright)
				parentnode.rightchild=currentnode.rightchild;
		    if(isleft)
		    	parentnode.leftchild=currentnode.rightchild;
		}
		/*
		 * the third case 
		 * find the submission of current node and then replace that
		 */
		if(currentnode.leftchild!=null&currentnode.rightchild!=null){
			/*
			 * find the successor firstly
			 */
			TreeNode parent = currentnode;
			TreeNode successor=currentnode.rightchild;
			while(successor.leftchild!=null){
				parent=successor;
				successor=successor.leftchild;
				}
			/*
			 * if successor is not the rightchild of currentnode then make connection
			 */
			if(successor!=currentnode.rightchild){
				parent.leftchild=null;
				successor.leftchild=currentnode.leftchild;
				successor.rightchild=currentnode.rightchild;
			}
			else
				successor.leftchild=currentnode.leftchild;
			/*
			 * make connection to the parent node here
			 */
			if(isright)
				parentnode.rightchild=successor;
		    if(isleft)
		    	parentnode.leftchild=successor;	
		    if(currentnode==root)//no parent node update root
		    	root=successor;
		    	
		}
		
	}
	/*
	 * preorder traversal display the BST
	 */
	public void preordertraversal(TreeNode root){
        TreeNode tempnode=root;		
		System.out.print(tempnode.getData()+" ");
		if(tempnode.leftchild!=null)
			preordertraversal(tempnode.leftchild);
		if(tempnode.rightchild!=null)
			preordertraversal(tempnode.rightchild);
	}
	/*
	 * preorder traversal without recursion
	 * using stack feature to finish this function here
	 */
	public void preordertraversalwithoutrecursion(TreeNode root){
		Stack mystack = new Stack();
		//TreeNode currentnode = root;
		if(root==null)
			throw new IllegalArgumentException("cannot display empty BST");
		else{		
			mystack.push(root);
		}
		while(mystack.first!=null){
			TreeNode tempnode=mystack.first;
			System.out.print(mystack.pop().getData()+" ");//pop the first data and display
			if(tempnode.rightchild!=null)
				mystack.push(tempnode.rightchild);
			if(tempnode.leftchild!=null)
				mystack.push(tempnode.leftchild);			
		}
		
	}
	/*
	 * calculate the current height of BST
	 * @variable current root of tree
	 */
	public int calculateheight(TreeNode currentnode,int height){
		int leftheight=0;
		int rightheight=0;
		
		if(currentnode==null)// the current point is null return current height
			return height;
		else{
			if(currentnode.leftchild!=null)
				leftheight=calculateheight(currentnode.leftchild,height);
			if(currentnode.rightchild!=null)
				rightheight=calculateheight(currentnode.rightchild,height);	
		}
		
		if(leftheight>rightheight)
			return leftheight+1;
		else
			return rightheight+1;
	}

}
/*
 * test main function
 */
public class MyBST {
	public static void main(String[] args){
		BST mybst=new BST();
		mybst.insert(100);
		mybst.insert(50);
		mybst.insert(25);
		mybst.insert(75);
		mybst.insert(150);
	    mybst.insert(125);
		mybst.insert(175);
		mybst.insert(110);
		//mybst.display(mybst.root);
		//mybst.delete(3);
		mybst.preordertraversal(mybst.root);
		mybst.preordertraversalwithoutrecursion(mybst.root);
		//System.out.println(mybst.calculateheight(mybst.root, 0));
		//System.out.println(mybst.find(1).getData());
		
	}
}
