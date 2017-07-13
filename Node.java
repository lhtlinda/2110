package edu.cornell.sneha;

public class Node {
	private Person data;
	private Node next;
	
	public Person getData(){
		return data;
	}
	public void setData(Person p){
		data = p ;
	} 
	public Node getNext(){
		return next ; 
	} 
	public void setNext(Node n){
		next = n ; 
	}
	public Node(Person p,Node n){
		data = p ; next = n ; 
	}
	public Node(Person p){
		this (p,null);
	}
	public Node( ){
		this (null) ; 
	}

}
