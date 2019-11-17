package com.kaustav.solution;

import java.util.List;

public class MutateToDLList {
	
	public Node mutate(List<Integer> list) {
		Node head = null;
		Node tail = null;
		for(Integer i: list) {
			if(head == null && tail == null) {
				head = new Node();
				head.setPrev(null);
				head.setSkill(i);
				head.setNext(null);
				tail = head;
			}
			else {
				Node temp = new Node();
				temp.setPrev(tail);
				temp.setSkill(i);
				temp.setNext(null);
				tail.setNext(temp);
				tail = temp;
			}
		}
		
		return head;
	}

}

class Node {
	private Node prev;
	private Integer skill;
	private Node next;
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public Integer getSkill() {
		return skill;
	}
	public void setSkill(Integer skill) {
		this.skill = skill;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}