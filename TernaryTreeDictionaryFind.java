package pree;
import java.*;

class Node{
  char val;
  boolean isEnd;
  Node left, right, middle;
  Node(){
	  val=0;
	  left=right=middle=null;
	  isEnd=false;	  
  }
  Node(char value){
	  val=value;
	  left=right=middle=null;
	  isEnd=false;
  }
};

public class TernaryTree {
    static Node root;
    TernaryTree(){
        root=new Node();
    	root.val=0;
    	root.left=root.right=root.middle=null;
    	root.isEnd = false;
    }
    public static Node insertWord(Node n1, char[] word, int ptr){
    	if(n1==null){
    		n1 = new Node(word[ptr]);
    		if(ptr+1 <word.length){
    		   n1.middle=insertWord(n1.middle,word, ptr+1);
    		}
    	}
    	if(word[ptr]<n1.val){
           n1.left=insertWord(n1.left,word,ptr);           
    	}
    	else if(word[ptr]>n1.val){
           n1.right=insertWord(n1.right,word,ptr);           
     	}
    	else{
           if(ptr+1 < word.length){
              insertWord(n1.middle,word,ptr+1);	        	   
           }
           else{
        	  n1.isEnd=true; 
           }
        }
    	return n1;
    };
    public static boolean findWord(Node n1, char[] word,int ptr){
        if(n1==null) return false;
    	if(n1.isEnd) return true;
        else{
            if(word[ptr]==n1.val){
            	if(ptr+1 < word.length){
            	   return(findWord(n1.middle,word,ptr+1));
            	}
            	else return true;
            }
            else if(word[ptr]<n1.val){
            	return(findWord(n1.left,word,ptr));
            }
            else if(word[ptr]>n1.val){
            	return(findWord(n1.right,word,ptr));
            }
            else return false;
        }
    }
    /*
    public static void printDictionaryWord(Node nDict,char[] word,int pos){
        if(nDict==null){
        	System.out.println("No matching Dictionary words were found");
        	return;
        }
        else{
        	if(nDict.val==word[pos]){
        		printDictionaryWord(nDict,word,pos++);
        	}
        	else if(nDict.val != word[pos]){
        		if()
        	}
        }
    	System.out.println("");	
    }
    */
	public static void main(String args[]){
        Node n = null;
        char[] word1 = "krishna".toCharArray();
        char[] word2 = "vijayapuri".toCharArray();
        char[] word3 = "vijy".toCharArray();
        n=insertWord(n,word1,0);
        n=insertWord(n,word2,0);
        boolean wordIsPresent = findWord(n, word2,0);
        System.out.println("vijayapuri word is present: "+wordIsPresent);
        wordIsPresent = findWord(n, word3,0);
        System.out.println("Sri word is present: "+wordIsPresent);
    }
};
