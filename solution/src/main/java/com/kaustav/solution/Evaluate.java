package com.kaustav.solution;

import java.util.Collections;
import java.util.List;

public class Evaluate {
	
	Node killAllPossible(Node node) {
		Node head = node;
		Node currentPlayer = head.getNext();
		while(currentPlayer!=null) {
			Node prevPlayer = currentPlayer.getPrev();
			while(prevPlayer!=null) {
				if(currentPlayer.getSkill()>prevPlayer.getSkill()) {
					head = killPlayer(head, currentPlayer, prevPlayer);
					//System.out.println("Removed: "+prevPlayer.getSkill());
					break;
				}
				prevPlayer = prevPlayer.getPrev();
			}
			currentPlayer=currentPlayer.getNext();
		}
		
		return head;
	}

	private Node killPlayer(Node head, Node currentPlayer, Node prevPlayer) {
		Node tempHead = head;
		if(prevPlayer==head) {
			Node temp = tempHead;
			tempHead = tempHead.getNext();
			temp.setNext(null);
			tempHead.setPrev(null);			
		}
		else {
			Node cursor = currentPlayer;
			while(cursor.getPrev()!=prevPlayer)
				cursor=cursor.getPrev();
			
			prevPlayer.getPrev().setNext(cursor);
			cursor.setPrev(prevPlayer.getPrev());
			prevPlayer.setNext(null);
			prevPlayer.setPrev(null);
		}
		return tempHead;
	}
	
	long minimumSum(Node head) {
		Node tempHead = head;
		long sum = 0;
		while(tempHead!=null) {
			sum+=tempHead.getSkill();
			tempHead=tempHead.getNext();
		}
		return sum;
	}

	public List<Integer> sortList(List<Integer> list) {
		List<Integer> unsortedList = list;
		Collections.sort(unsortedList);
		return unsortedList;
	}

}
