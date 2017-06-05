package tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: heapifytree
 * Description: A class that tranform a unordered BST to heap 
 * Date: 2017-4-23
 *
 * Update History:
 *
 * @version 1.0
 * @author Steve Shao
 */

public class heapifytree {
	
	private int travanse(TreeNode root,int count, TreeNode[] array){
		if(root!=null){
			count++;
			if(array!=null)
				array[count]=root;
		}
		if(root.leftchild!=null)
			travanse(root.leftchild,count,array);
		if(root.rightchild!=null)
			travanse(root.rightchild,count,array);
		return count;
	}
	
	public void heapify(TreeNode root){
		
		int size=travanse(root,0,null);
		TreeNode[] nodearray= new TreeNode[size];
		travanse(root,0,nodearray);
		
		//sort the array
		Arrays.sort( nodearray, new Comparator<TreeNode>(){
			@Override public int compare(TreeNode m, TreeNode n){
				int mv = m.getData();
				int	nv = n.getData();
				return ( mv < nv ? -1 : ( mv == nv ? 0 : 1));
				}
				});
		
		//heapify the array into heap
		for(int i=0;i<size;i++){
			int parent=i;
			int left=2*i+1;
			int right=left+1;
			if(left<size)
				nodearray[parent].leftchild=nodearray[left];
			else
				nodearray[parent].leftchild=null;
			if(right<size)
				nodearray[parent].rightchild=nodearray[right];
			else
				nodearray[parent].rightchild=null;			
		}
		
	}
	
	
}
