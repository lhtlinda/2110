
public class Node<T> {
	private Object data;
	private Node<T> next;
	private Node<T> prev;
	
	@SuppressWarnings("unchecked")
	public T getData(){
		return (T) data;
	}
	public void setData(T t){
		data = (T) t ;
	} 
	
	public Node<T> getNext(){
		return (Node<T>) next ; 
	}
	
	public Node<T> getPrevious(){
		return (Node<T>) prev;
	}
	public void setNext(Node<T> n){
		next = n ; 
	}
	
	public void setPrevious(Node<T> n ){
		prev=n;
	}
	
	public Node(T t, Node<T> pre, Node<T> nex){
		data= (T) t;
		prev=pre;
		next=nex;
	}
	
	public Node(T t,Node<T> n){
		data = (T) t;
		next = n;
	}
	
	public Node(T t){
		data=t;
		next=null;
		prev=null;
	}
	public Node( ){
		this (null) ; 
	}

}
