package DS;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements GraphInterface{

	private HashMap<String, Vertex> vertices;
	
	public Graph() {
		this.vertices = new HashMap<String, Vertex>();
	}
	
	@Override
	public void addVertex(String name) {
		if (vertices.containsKey(name)) {
			return;
		}
		Vertex v = new Vertex(name);
		vertices.put(name, v);
	}

	public void print() {
		System.out.println("Printing Graph");
		Vertex[] allVertices = vertices.values().toArray(new Vertex[0]);
		
		for (Vertex v:allVertices) {
			v.print();
		}
	}
	
	@Override
	public void addEdge(String first, String second) {
		if (!vertices.containsKey(first) || !vertices.containsKey(second)) {
			return;
		}
		Vertex firstVertex = vertices.get(first);
		Vertex secondVertex = vertices.get(second);
		if (firstVertex.isAdjacent(secondVertex)) {
			return;
		}
		Edge e = new Edge();
		e.first = firstVertex;
		e.second = secondVertex;
		firstVertex.addEdge(e);
		secondVertex.addEdge(e);
	}
	@Override
	public void removeVertex(String name) {
		if (!vertices.containsKey(name)) {
			return;
		}
		
		Vertex toBeRemoved = vertices.get(name);
		vertices.remove(name);
		ArrayList<Vertex> adjacentVertices = toBeRemoved.getAdjacent();
		for (Vertex adjacentVertex:adjacentVertices) {
			adjacentVertex.removeEdgeWith(toBeRemoved);
		}
		
	}

	@Override
	public void removeEdge(String first, String second) {
		if (!vertices.containsKey(first) || !vertices.containsKey(second)) {
			return;
		}
		Vertex firstVertex = vertices.get(first);
		Vertex secondVertex = vertices.get(second);
		firstVertex.removeEdgeWith(secondVertex);
		secondVertex.removeEdgeWith(firstVertex);
	}

	@Override
	public ArrayList<String> getAdjacent(String name) {
		if (!vertices.containsKey(name)) {
			return null;
		}
		Vertex vertex = vertices.get(name);
		ArrayList<Vertex> adjacent = vertex.getAdjacent();	
		ArrayList<String> output = new ArrayList<String>();
		for (Vertex v: adjacent) {
			String name1 = v.name;
			output.add(name1);
		}
		return output;
	}

	@Override
	public int getDegree(String name) {
		if (!vertices.containsKey(name)) {
			return -1;
		}
		
		Vertex vertex = vertices.get(name);
		return vertex.getDegree();
	}

	@Override
	public int numberVertices() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int numberOfEdges() {
		// TODO Auto-generated method stub
		int count = 0;
		Vertex[] allVertices = vertices.values().toArray(new Vertex[0]);
		for (int i =0; i < allVertices.length; i++) {
			Vertex v = allVertices[i];
			count += v.getDegree();
		}
		return count/2;
	}

	@Override
	public boolean areTwoVerticesConnected(String first, String second) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
