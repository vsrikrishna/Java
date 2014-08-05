package pree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

class Record{
	private String Id;
	private String name;
	private char[] grades;
	
	Record(String inputId, String inName, String inGrades){
		Id = inputId;
		name = inName;
		grades = new char[10];
		if(inGrades.length() > 10){
			System.out.println("More than 10 grades entered");
		}
		for(int i=0;i<10;i++){
			grades[i]= inGrades.charAt(i);
		}
	}
	public void setId(String inputId){
		Id = inputId;
	}
	
	public int getId(){
		return Integer.parseInt(Id);
	}
	
	public String getName(){
		return name;
	}
	public String getGrades(){
		String temp = "";
		for(int i=0; i<grades.length; i++){
			temp+= grades[i];
		}
		return temp;
	}
}

class node{
    Record studentData;
    node left;
    node right;
}
class BST {
	node root;
	
	BST(){
		root = null;
	}

    void insertNode(Record inData){
        if(root != null){
            insertNode(root,inData);	  	 
        }
        else{
            root = new node();
            root.studentData = inData;
            root.left = null;
            root.right = null;
        }  
    }

    void inOrderTraversal(){
        if(root == null){
    	    System.out.println("No elements in tree");
        }
        else{
        	inOrderTraversal(root);        	
        }
    }
    
    public void insertNode(node inNode, Record inData){
        if(inData.getId()<=inNode.studentData.getId()){
    	    if(inNode.left == null){
    	    	inNode.left = new node();
    	    	inNode.left.studentData = inData;
    	    	inNode.left.left = null;
    	    	inNode.left.right = null;
    	    }
    	    else{
                insertNode(inNode.left, inData);    		    	
    	    }
    	}
    	else{
    	    if(inNode.right == null){
    	    	inNode.right = new node();
    	    	inNode.right.studentData = inData;
    	    	inNode.right.left = null;
    	    	inNode.right.right = null;
    	    }
    	    else{
                insertNode(inNode.right, inData);    		    	
    	    }
    	}
    }
    public void inOrderTraversal(node traverse){
    	if(traverse != null){
    		inOrderTraversal(traverse.left);
    		System.out.println();
            System.out.println("Student Id is: "+traverse.studentData.getId());
            System.out.println("Student name is: "+traverse.studentData.getName());
            String gradeString = traverse.studentData.getGrades();
            System.out.print("Student grades are: ");
            for(int j=0; j<10;j++){
            	System.out.print(gradeString.charAt(j)+", ");
            }
            System.out.println();
    		inOrderTraversal(traverse.right);
    	}
    }
    
    public boolean searchRecord(int inputId){
    	if(root!=null){
    		return searchRecord(root,inputId);
    	}
    	return false;
    }
    
    public boolean searchRecord(node root, int inputId){
    	if(root == null) return false;
    	if(inputId == root.studentData.getId()){
    		System.out.println("Found Student record");
    		System.out.println("Student Id is: "+root.studentData.getId());
    		System.out.println("Student Name is: "+root.studentData.getName());
    		System.out.print("Student grades are: ");
              for(int j=0; j<10;j++){
              	System.out.print(root.studentData.getGrades().charAt(j)+", ");
              }
    		return true;
    	}
    	else if(inputId < root.studentData.getId()){
    		return searchRecord(root.left, inputId);
    	}
    	else if(inputId > root.studentData.getId()){
    		return searchRecord(root.right, inputId);
    	}
    	return false;
    }
    
    public void delete(int toDelete)
    {
       root = delete(root, toDelete);
    }
    public node delete(node p, int toDelete)
    {
       if (p == null) System.out.println("Null pointer found"); //throw new RuntimeException("cannot delete.");
       else if (toDelete < p.studentData.getId())
           p.left = delete (p.left, toDelete);
       else if (toDelete > p.studentData.getId())
           p.right = delete (p.right, toDelete);
       else{
          if (p.left == null) return p.right;
          else if (p.right == null) return p.left;
          else{
          // get data from the rightmost node in the left subtree
             int temp = retrieveData(p.left);
             p.studentData.setId(String.valueOf(temp));
          // delete the rightmost node in the left subtree
             p.left =  delete(p.left, p.studentData.getId()) ;
          }
       }
       return p;
    }
    public int retrieveData(node p)
    {
       while (p.right != null) p = p.right;
       return p.studentData.getId();
    }
    
}

public class binarySearchTree{
	static Scanner reader = new Scanner(System.in);
	static Record[] studentArray;

	public static void ArrayDisplay(){
       	for(int i=0; i<21; i++){
       		Record temp = studentArray[i];
       		String gradeString = temp.getGrades();
       	            
            System.out.println("Student "+(i+1)+" record");
            System.out.println("Student Id is: "+temp.getId());
            System.out.println("Student name is: "+temp.getName());
            System.out.print("Student grades are: ");
            for(int j=0; j<10;j++){
            	System.out.print(gradeString.charAt(j)+", ");
            }
            System.out.println();
            System.out.println();            
       	}
    }

	public static void main(String[] args) {
        String[] names = {"John","Jack","Eric","Nathan","Gautham","Bob","Mat","Alan","Chris","Mark","James","Giles","Pat","George","Brad","Jason","Scott","Ray","Jose","Rob","Mary"};
        String [] grades = {"AAAAAAAAAA","AAAAAAAAAB","AAAAAAAABA","AAAAAAABAA","AAAAAABAAA","AAAAABAAAA","AAAABAAAAA","AAABAAAAAA","AABAAAAAAA","ABAAAAAAAA","BBBBBBBBBB","BBBBBBBBBA","BBBBBBBBAB","BBBBBBBABB","BBBBBBABBB","BBBBBABBBB","BBBBABBBBB","BBBABBBBBB","BBABBBBBBB","BABBBBBBBB","CCCCCCCCCC"};
		Random rand = new Random();
		int temp;
	
        studentArray = new Record[21];
        for(int i=0;i<21;i++){
        	temp = 100000 + (int)(rand.nextFloat() * 900000);
            studentArray[i] = new Record(String.valueOf(temp),names[i],grades[i]);	
        }
        ArrayDisplay();
        
        BST bst = new BST();        
        for(int i=0; i<21; i++){
        	bst.insertNode(studentArray[i]);
        }
        
        /*
         * In Order Traversal
         */
        bst.inOrderTraversal();
        
        /*
         * Searching for 2 records in the tree
         */
        for(int i=0;i<2;i++){
            System.out.println("\nEnter the Id to be searched:");
            int searchKey=reader.nextInt();
            if(!bst.searchRecord(searchKey)){
                 System.out.println("Key not found in the tree.");	
            }
            System.out.println();
        }
        
        /*
         * Delete 2 nodes in binary tree
         */
        for(int i=0;i<2;i++){
            System.out.println("\nEnter the Id to be deleted:");
            int searchKey=reader.nextInt();
            bst.delete(searchKey);
            
            bst.inOrderTraversal();
        }
        
        /*
         * Insert a node into the binary tree
         */
        System.out.println("\nEnter the name of the new Student");
        String name=reader.next();
        System.out.println("\nEnter the grade of the Student");
        String tempGrade=reader.next();
        temp = 100000 + (int)(rand.nextFloat() * 900000);
        bst.insertNode(new Record(String.valueOf(temp),name,tempGrade));
        System.out.println("\nThe updated tree after adding a student record is: ");
        bst.inOrderTraversal();
    }
} 













