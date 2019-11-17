package com.kaustav.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter: ");
        int numOfPlayer = Integer.parseInt(sc.nextLine());
        boolean flag = true;
        String stArr[] = null;
        
        
        while(flag) {
        	String input = sc.nextLine();
        	stArr = input.split(" ");
        	
        	if(stArr.length==numOfPlayer) {
        		flag = false;
        		sc.close();
        	}
        	else {
        		System.out.println("Entered number doesnot matches the number of possible inputs");
        	}
            
        }
        
        
        
        
       
        int arr[] = new int[numOfPlayer];
        
        try {
        	for(int i = 0;i<numOfPlayer;i++) {
            	arr[i] = Integer.parseInt(stArr[i]);
            	if(arr[i]<0)
            		throw new Exception();
            }
        }catch (Exception e) {
			System.out.println("Only positive Integer Allowed");
			System.exit(0);
		}
        
        List<Integer> list = Arrays.stream(arr)
        		.boxed().collect(Collectors.toList());
        
        List<Integer> sortedList = new Evaluate().sortList(list);
        
        Node temp = new MutateToDLList().mutate(sortedList);
        
        Node survived = new Evaluate().killAllPossible(temp);
        
//        while(survived!=null) {
//        	System.out.print(survived.getSkill()+" ");
//        	survived=survived.getNext();
//        }
        
        System.out.println("Minimum Sum: "+new Evaluate().minimumSum(survived));
        
    }
}
