package day5;

import java.util.Iterator;
import java.util.PriorityQueue;


public class PQExample {
    public static void main(String args[]) {
    	PriorityQueue<String> pQueue=new PriorityQueue<String>();
    	pQueue.add("C"); 
        pQueue.add("C++"); 
        pQueue.add("Java"); 
        pQueue.add("Python"); 
  
        // Printing the most priority element 
        System.out.println("Head value using peek function:"
                                           + pQueue.peek()); 
  
        // Printing all elements 
        System.out.println("The queue elements:"); 
        Iterator itr = pQueue.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
    }

}
