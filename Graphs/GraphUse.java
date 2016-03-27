package DS;

public class GraphUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		
		g.addVertex("d");
		g.addVertex("g");
		g.addVertex("n");
		g.addEdge("d", "g");
		g.addEdge("d", "n");
		g.addEdge("n", "g");
		g.addEdge("d", "g");
		g.addEdge("d", "g");
		g.removeEdge("d", "g");
		g.print();
		System.out.println(g.numberOfEdges());
	}

}
