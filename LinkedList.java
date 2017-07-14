
public class LinkedList<T> {
	@SuppressWarnings("rawtypes")
	private Node header,current;
	private int length;

	@SuppressWarnings("unchecked")
	public void join(T t){
		Node<T> temp =new Node<T>(t);
		current.setNext(temp);
		current=temp;
		length++;
	}
	
	
	@SuppressWarnings("unchecked")
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
	
	public LinkedList(Person p){;
		this.length=0;
		this.header=new Node<Person>(null);
		this.current=new Node<Person>(p);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedList(){
		this.length=0;
		this.header=new Node(null,null);
		this.current=header;
	
}

}
