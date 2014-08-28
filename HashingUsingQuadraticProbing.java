import java.util.ArrayList;

import java.util.Arrays;

import java.util.Random;

import java.util.LinkedList;

import java.util.Scanner;

class Record{

private String Id;

Record(String inputId){

}

public String getId(){

}

};

public class quadraticProbing {

static Scanner reader = new Scanner(System.in);

Record[] studentArray;

static int sizeOfTheArray;

quadraticProbing(int size) {

}

 public void put(String Id){

 int hash = getHashValue(Id);

 int position = getArrayPos(hash);

 if(studentArray[position] == null)

 studentArray[position] = new Record(Id);

 else{

 System.out.println("storing record into non 0 

location");

 }

 }

 

 

 public int getArrayPos(int val){

 int offset = 1;

 

 while( studentArray[ val ] != null)

 {

 val += offset; // Compute ith probe

 offset += 2;

 if(offset >= studentArray.length)

 offset -= studentArray.length;

 if( val >= studentArray.length)

 val -= studentArray.length;

 } 

 return val; 

 }

 public int getHashValue(String input){

 return Integer.parseInt(input) % sizeOfTheArray; 

 }

 

 public void listDisplay(){

 for(int i=0; i<sizeOfTheArray; i++){

 Record temp = studentArray[i];

 if(temp == null){

 System.out.println(i+"--> empty");

 }

 else{

 System.out.print(i+" --> "+temp.getId()

+" ");

 System.out.println();

 }

 }

 }

 

 public static void getArraySize(){

 System.out.println("Enter the size of array");

 sizeOfTheArray = reader.nextInt();

 }

 

public int findId(String Id) {

 for (int i=0;i<sizeOfTheArray;i++) {

 if(studentArray[i] != null && 

studentArray[i].getId().equals(Id)){

 flag = true;

 break;

 }

 }

 if(flag)

 return 1;

 else

 return -1;

 }

public static void main(String[] args) {

 getArraySize();

quadraticProbing(sizeOfTheArray);

900000);

String[arr.length];

 displayelements[j]=String.valueOf(arr[j]);

 hash.put(displayelements[j]);

 while(i<2)

 {

 System.out.println("Enter the Id to be 

searched");

 String searchKey=reader.next();

 

 if(hash.findId(searchKey) > 0){

 System.out.println("Id found in the hash 

table");

 }

 else{

 System.out.println("Id not found");

 i++;

 }

}

}