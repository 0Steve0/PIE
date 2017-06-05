package tree;
/**
 * ClassName: Balancedunbalancedtree
 * Description: A class that balance the unbalanced tree 
 * Date: 2017-4-23
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */

public class Balancedunbalancedtree {
	/*
	 * a class that store those values into an array
	 */
	public static int inordertravanse(node root,int count,node[] array){
		if(root==null)
			return count;
			//throw new IllegalArgumentException("cannot travanse a empty tree");
		if(root.leftchild!=null)
			count=inordertravanse(root.leftchild,count,array);
		if(array!=null)
			array[count]=root;
		count++;
		if(root.rightchild!=null)
			count=inordertravanse(root.rightchild,count,array);			
		return count;
	}
	
	/*
	 * Balance that unbalanced tree
	 * find the middle point to be the root
	 * cut off all the connection and them insert the rest of array
	 */
	public static BSTformal balance(node root){
		
		int count=0;
		int size=inordertravanse(root,count,null);
		//System.out.println(size);
		node[] array = new node[size];
		inordertravanse(root,count,array);
		
		int middle=size/2;
		node newroot=array[middle];
		BSTformal mynewbst= new BSTformal();
		//insert the new root firstly
		mynewbst.insert(newroot.getData());
		//then insert the rest of array besides the new root
		for(int i=0;i<size;i++){
			if(array[i]!=array[middle])
				mynewbst.insert(array[i].getData());		
		}
		
		return mynewbst;
	}
	public static void main(String[] args){
		BSTformal mybst =new BSTformal();
		mybst.insert(6);
		mybst.insert(4);
		mybst.insert(7);
		mybst.insert(2);
		mybst.insert(5);
	    mybst.insert(1);
		mybst.insert(3);
		//System.out.println(inordertravanse(mybst.root,0,null));
		System.out.println(balance(mybst.root).root.getData());
	}
}

