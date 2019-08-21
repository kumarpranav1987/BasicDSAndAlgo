package graph.undirected;

//https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
public class ArticulationPoint {
	public static void main(String[] args) {
		/*
		 * UndirectedGraph g1 = new UndirectedGraph(5); g1.addEdge(1, 0); g1.addEdge(0,
		 * 2); g1.addEdge(2, 1); g1.addEdge(0, 3); g1.addEdge(3, 4);
		 * g1.getAllArticulationPoints().forEach(x->System.out.print(x+" "));
		 * 
		 * UndirectedGraph g2 = new UndirectedGraph(4); g2.addEdge(0, 1); g2.addEdge(1,
		 * 2); g2.addEdge(2, 3); System.out.println();
		 * g2.getAllArticulationPoints().forEach(x->System.out.print(x+" "));
		 */
		
		UndirectedGraph g3 = new UndirectedGraph(7);
		g3.addEdge(0, 1); 
		g3.addEdge(1, 2); 
		g3.addEdge(2, 0); 
		g3.addEdge(1, 3); 
		g3.addEdge(1, 4); 
		g3.addEdge(1, 6); 
		g3.addEdge(3, 5); 
		g3.addEdge(4, 5); 
		System.out.println();
		g3.getAllArticulationPoints().forEach(x->System.out.print(x+" "));
	}
}