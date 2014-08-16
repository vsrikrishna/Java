import java.util.ArrayList;

import java.util.Arrays;

import java.util.Random;

import java.util.LinkedList;

import java.util.Scanner;

class StudentRecord{

private String Id;

private StudentRecord next;

StudentRecord(String inputId){

Id = inputId;

next = null;

}

public StudentRecord getNext(){

 return next;

}

public void setNext(StudentRecord nextRecord){

}

public String getId(){

}

};

public class Hashing {

StudentRecord[] studentArray;

static int sizeofthearray;

next = nextRecord;

return Id;

static int hashNumber;

Hashing(int size) {

sizeofthearray = size;

studentArray = new StudentRecord[size];

for(int i=0; i< sizeofthearray;i++){

studentArray[i]= null;

}

}

 public void put(String Id){

 int hash = getHashValueFromDiv(Id);

 if(studentArray[hash] == null)

 studentArray[hash] = new StudentRecord(Id);

 else{

 StudentRecord record = studentArray[hash];

 while(record.getNext() != null)

 record = record.getNext();

 record.setNext(new StudentRecord(Id));

 }

 }

 

 public int getHashValueFromDiv(String input){

 return Integer.parseInt(input) % hashNumber; 

 }

public void listDisplay(){

 for(int i=0; i<sizeofthearray; i++){

 StudentRecord temp = studentArray[i];

 if(temp == null){

 System.out.println(i+"--> empty");

 }

 else{

 System.out.print(i+" --> "+temp.getId()

+" ");

 temp =temp.getNext();

 while(temp != null){

 System.out.print(temp.getId()+" "); 

 temp = temp.getNext();

 } 

 System.out.println();

 }

 }

 }

 public static void getHashNumber(){

for (int i = 50; i<64; i++) {

if (checkprime(i)){

 hashNumber =i;

}

 break;

 sizeofthearray = hashNumber; 

 }

 }

 

public static boolean checkprime(int number) {

if (number % 2 == 0)

return false;

for (int i = 3; i * i <= number; i += 2) {

if (number % i == 0)

}

return true;

return false;

}

public int findId(String Id) {

 int hash = getHashValueFromDiv(Id);

 

 if (studentArray[hash] == null)

 return -1;

 else {

 StudentRecord entry = studentArray[hash];

 while (entry != null && !(entry.getId().equals(Id)

))

 entry = entry.getNext();

 if (entry == null)

 return -1;

 else

 return Integer.parseInt(entry.getId());

 }

 }

 public static void main(String[] args) {

 getHashNumber();

900000);

Hashing hash = new Hashing(hashNumber);

Random rand = new Random();

int arr[] = new int[160];

for (int i = 0; i < 160; i++) 

{

arr[i] = 100000 + (int)(rand.nextFloat() * 

}

String[] displayelements = new

String[arr.length];

for (int j = 0; j < arr.length; j++)

{

 displayelements[j]=String.valueOf(arr[j]);

 hash.put(displayelements[j]);

}

hash.listDisplay();

Scanner reader = new Scanner(System.in);

int i=0;

 while(i<=2)

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

 

}

 }

}

}