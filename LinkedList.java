
public class LinkedList<T> {
	protected Node<T> header,current;
	private int length;

	
	public void join(T t){
		if (current.equals(header)){
			Node<T> temp =new Node<T>(t,header,null);
			header.setNext(temp);
			current=temp;
		}
		else
		{
			Node<T> temp =new Node<T>(t,current.getPrevious().getNext(),null);
			current.getPrevious().getNext().setNext(temp);
			current=temp;
		}
		length++;
	}
	
	

	public void leave(){
		 if (current!=null&&current.equals(header)){
			 if (current.getNext()!=null){
				 current.getPrevious().setNext(current.getNext());
				 current.getNext().setPrevious(current.getPrevious());
				 current=current.getNext();		 
			 }
			 else
			 {
				current=null; 
			 }
		 }
		 else
		 {
			 System.out.println("Empty!");
		 }
		 
	 }
	 
	public int getLength(){
		return this.length;
	}
	
	public boolean isFull(){
		return false;
	}
	
	public boolean isEmpty(){
		return (length==0);
	}
	

	public LinkedList(T t){;
		this.length=0;
		this.header=new Node<T>(null,null,null);
		this.current=header;
		join(t);
	}
	

	public LinkedList(){
		this.length=0;
		this.header=new Node<T>(null,null);
		this.current=header;
	
}

}
