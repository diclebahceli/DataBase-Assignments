/*
 * @author Dicle Bahceli
 * @since 27.12.2021
 * 
 */


import java.util.Scanner;
import java.io.*;
public class HW3_20190808024_1 {

	public static void main(String[] args) {
		
		BinarySearchT t = new BinarySearchT();
		t.inorder();
		
		
		try{
			File file = new File(args[0]);
			Scanner scan = new Scanner(file);
			for(String i : scan.nextLine().split(" ")) {
				t.insert(Integer.parseInt(i));
			}
			t.inorder();
			System.out.println(t.balancedOrNot());
		}
		catch(Exception e) {
			
		}

		
		
		
		
		

	}





}

class Node {
	 Node left = null;
	 Node right = null;
	 int value;

	public Node(int data) {
		this.value = data;
	}

	
	public boolean Leaf(){
		if(this.right == null && this.left == null)
			return true;
		return false;
	}

}

class BinarySearchT {

	Node root;
	
	
	void inorder() { 
        inorder_Recur(root); 
    } 
   
    
    void inorder_Recur(Node root) { 
        if (root != null) { 
            inorder_Recur(root.left); 
            System.out.print(root.value + " "); 
            inorder_Recur(root.right); 
        } 
    }
	
	public BinarySearchT(){
		this.root = null;
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

	    else if(data > root.value) {
	        root.right = insert_Recur(root.right, data);
	    }
	    else{
	        root.left = insert_Recur(root.left, data);
	    }
	    return root;
	  }
	  
	  public int balancedOrNot() {
		  return balancedOrNot(this.root);
	  }

	public int balancedOrNot(Node root) {

		if(root == null)
			return 0;

		int leftHeight = balancedOrNot(root.left);
		if(leftHeight == -1) return -1;

		int rightHeight = balancedOrNot(root.right);
		if(rightHeight == -1) return -1;

		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		return(1 + Math.max(leftHeight, rightHeight));
	}
}

