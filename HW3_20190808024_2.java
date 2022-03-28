/*
 * @author Dicle Bahceli
 * @since 27.12.2021
 * 
 */


import java.io.File;
import java.util.Scanner;


class BinarySearchT {

	Node root;
	
	
	void inorder() { 
       inorder_Recur(root); 
   } 
  
	
   
   void inorder_Recur(Node root) { 
       if (root != null) { 
           inorder_Recur(root.left); 
           System.out.print(root.val + " "); 
           inorder_Recur(root.right); 
       } 
   }
	
	public BinarySearchT(){
		this.root = null;
	}

	
	public boolean PathSum(int sum) {
		return PathSum(this.root,sum);
	}
	public boolean PathSum(Node node, int sum)
    {
      boolean first = false;
      int subSum = sum - node.val;
      if(subSum == 0 && node.left == null && node.right == null)
        return(first = true);
      if(node.left != null) 
         
    	  
    	  first = first || PathSum(node.left, subSum);       
      
      if(node.right != null)
         
    	  first = first || PathSum(node.right, subSum);   
      return(first);
    }
	
	
	public void insert(int newData) {
	    this.root = insert_Recur(this.root, newData);
	  }

	  public Node insert_Recur(Node root, int data) {
	    if(root == null)
	    {
	      root = new Node(data);
	      return root;
	    }

	    else if(data > root.val) {
	        root.right = insert_Recur(root.right, data);
	    }
	    else{
	        root.left = insert_Recur(root.left, data);
	    }
	    return root;
	  }}


class Node {
	 Node left = null;
	 Node right = null;
	 int val;
	 
	public Node(int data) {
		this.val = data;
	}

	

}





public class HW3_20190808024_2 {

	public static void main(String[] args) throws Exception {


		BinarySearchT t = new BinarySearchT();
		t.inorder();
		
		
		try{
			File file = new File(args[0]);
			Scanner scan = new Scanner(file);
			for(String i : scan.nextLine().split(" ")) {
				t.insert(Integer.parseInt(i));
			}
			int valuee = scan.nextInt();
			t.inorder();
			System.out.println(t.PathSum(valuee));
		}
		catch(Exception e) {
			throw e;
		}

		
		
		
		
		

	}



		
	}





