/*

In Java, we need to declare the size of an array before we can use it. Once the size of an array is declared, it's hard to change it.

To handle this issue, we can use the ArrayList class. It allows us to create resizable arrays.

Unlike arrays, arraylists can automatically adjust its capacity when we add or remove elements from it. Hence, arraylists are also known as dynamic arrays

Syntax of Creating an ArrayList:

// create Integer type arraylist
ArrayList arrayList = new ArrayList<>()

In the above program, we have used Integer not int. It is because we cannot use primitive types while creating an arraylist. Instead, we have to use the corresponding wrapper classes.

Basic syntax:

ArrayListName.size() : use this to get the size of arraylist.
ArrayListName.add(x) : Use this to append an element x to the ArrayList.
ArrayListName.get(i) : use this to access the ith index element in the ArrayList. Remember ArrayList uses 0 based indexing.

*/

/*

Task:

You are given a stream of positive integers as input and the stream ends when you encounter an negative element.

You need to save this numbers in an ArrayList and then print this numbers in reverse order.


*/

import java.lang.*;
import java.util.*;

public class Main {
  public static void main (String[] args) { 
    Scanner inp = new Scanner(System.in);
    ArrayList<Integer> arr = new ArrayList<Integer>();
    
    while(true) {
      int a = inp.nextInt();
      inp.nextLine();
      if(a < 0) break;
      add.add(a);
    
    }
    inp.close();
    for(int i = arr.size() -1; i >=0; i--)
      System.out.println(arr.get(i)+"");
    System.out.println();
  }
}
