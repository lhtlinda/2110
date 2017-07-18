



import org.junit.Test;

public class GraphTest {



	/**@Test
	public void graphConstructor(){
		Graph graph= new Graph();
		Person[] people = new Person[2];
		people = graph.populate();
	}*/


	@Test
	public void testDFS(){
		Graph graph= new Graph();
		Person[] people = new Person[2];
		people = graph.populate();
		Graph.DFS(people[0],people[1]);
	}

	@Test
	public void testBFS(){
		Graph graph= new Graph();
		Person[] people = new Person[2];
		people = graph.populate();
		Graph.BFS(people[0],people[1]);
	}

	@Test
	public void testBiDirectionalBFS(){
		Graph graph= new Graph();
		Person[] people = new Person[2];
		people = graph.populate();
		Graph.BidirectionalBFS(people[0],people[1]);
	}
	
	




}
