
public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> prev;


	protected T getData(){
		return data;
	}
	protected void setData(T t){
		data = t ;
	} 

	protected Node<T> getNext(){
		return (Node<T>) next ; 
	}

	protected Node<T> getPrevious(){
		return (Node<T>) prev;
	}
	protected void setNext(Node<T> n){
		next = n ; 
	}

	protected void setPrevious(Node<T> n ){
		prev=n;
	}

	protected Node(T t, Node<T> pre, Node<T> nex){
		data= t;
		prev=pre;
		next=nex;
	}

	protected Node(T t,Node<T> n){
		data = (T) t;
		next = n;
	}

	protected Node(T t){
		data=t;
		next=null;
		prev=null;
	}


}
