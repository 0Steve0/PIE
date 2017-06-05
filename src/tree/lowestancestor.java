package tree;

/**
 * ClassName: lowestancestor
 * Description: A class that implement BST that find the lowest ancestor of two nodes 
 * Date: 2017-4-22
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */
/*
 * tree node for a BST
 */
class node{
	private int data;
	public node leftchild;
	public node rightchild;
	
	//constructor
	public node(int data){
		this.setData(data);
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
class BSTformal{
	node root;
	//constructor
		public BSTformal(){
		    root=null;
		}
		
		public node find(int data){
			node newnode = new node(data);
			/*
			 * use two node pointer to keep track of nodes here
			 */
			node currentnode=root;
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
			node newnode = new node(data);
			
			if(root==null)//when the tree is empty
				root=newnode;
			else{
				/*
				 * use two node pointer to keep the track of node need to be inserted
				 */
				node currentnode=root;
				node parentnode;
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
			node deletednode=new node(data);
			node currentnode=root;
			node parentnode = null;
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
				node parent = currentnode;
				node successor=currentnode.rightchild;
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
		 * find lowest ancestor of two given points
		 */
		public int findlowestancestor(int data1,int data2){
			node currentnode = root;
			if(root==null)
				throw new IllegalArgumentException("cannot find in a empty BST");
			else{
				while(currentnode!=null){
					if(currentnode.getData()>bigger(data1,data2))
						currentnode=currentnode.leftchild;
					if(currentnode.getData()<smaller(data1,data2))
						currentnode=currentnode.rightchild;	
					if(currentnode.getData()>=smaller(data1,data2)&&currentnode.getData()<=bigger(data1,data2))
						return currentnode.getData();
				}
			}
	        throw new IllegalArgumentException("cannot find the ancestor");
		} 

		private int smaller(int data1, int data2) {
			if(data1<data2)
				return data1;
			else
				return data2;
		}

		private int bigger(int data1, int data2) {
			if(data1>data2)
				return data1;
			else
				return data2;
		}
}
/*
 * test main function
 */
public class lowestancestor {
	public static void main(String[] args){
		BSTformal mybst =new BSTformal();
		mybst.insert(100);
		mybst.insert(50);
		mybst.insert(25);
		mybst.insert(75);
		mybst.insert(150);
	    mybst.insert(125);
		mybst.insert(175);
		mybst.insert(110);
		System.out.print(mybst.findlowestancestor(110, 175));
		
	}
}
