package com.kaustav.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class EvaluateTest extends TestCase {

	Evaluate evaluate = new Evaluate();
	MutateToDLList mutateToDLList = new MutateToDLList();
	List list1,list2,list3;
	List<Integer> expected1, expected2, expected3, actual1, actual2, actual3;
	Node node1, node2, node3;
	
	protected void setUp() {
		list1 = new ArrayList<Integer>();//2 8 3 3 5 5
		list2 = new ArrayList<Integer>();//1 2
		list3 = new ArrayList<Integer>();//2 3 1 1 3 3 10 4 1 3
		
		list1.add(2);
		list1.add(8);
		list1.add(3);
		list1.add(3);
		list1.add(5);
		list1.add(5);
		
		list2.add(2);
		list2.add(1);
		
		list3.add(2);
		list3.add(3);
		list3.add(1);
		list3.add(1);
		list3.add(3);
		list3.add(3);
		list3.add(10);
		list3.add(4);
		list3.add(1);
		list3.add(3);
		
		expected1 = Arrays.asList(5, 8);
		expected2 = Arrays.asList(2);
		expected3 = Arrays.asList(3, 3, 3, 10);
		
		actual1 = new ArrayList<Integer>();
		actual2 = new ArrayList<Integer>();
		actual3 = new ArrayList<Integer>();
		
		node1 = evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list1)));
		while(node1!=null) {
			actual1.add(node1.getSkill());
			node1=node1.getNext();
		}
		
		node2 = evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list2)));
		while(node2!=null) {
			actual2.add(node2.getSkill());
			node2=node2.getNext();
		}
		
		node3 = evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list3)));
		while(node3!=null) {
			actual3.add(node3.getSkill());
			node3=node3.getNext();
		}
	}
	
	public void testKillAllPossible() {
		
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		
	}

	public void testMinimumSum() {
		assertEquals(13, evaluate.minimumSum(evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list1)))));
		assertEquals(2, evaluate.minimumSum(evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list2)))));
		assertEquals(19, evaluate.minimumSum(evaluate.killAllPossible(mutateToDLList.mutate(evaluate.sortList(list3)))));
	}
	
}
