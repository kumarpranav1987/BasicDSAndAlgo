package graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//I am assuming Vertices are name from 0 to n for simplicity and to to only focus on the algos
public class UndirectedGraph {
	private int numberOfVertices;
	private int numberOfEdges;
	private List<List<Integer>> adjacencyList;
	private int time;
	public UndirectedGraph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		adjacencyList = new ArrayList<List<Integer>>();
		for (int i = 0; i < numberOfVertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
	}

	public UndirectedGraph(int numberOfVertices, int numberOfEdges) {
		this(numberOfVertices);
		this.numberOfEdges = numberOfEdges;
	}

	public void addEdge(int start, int end) {
		adjacencyList.get(start).add(end);
		adjacencyList.get(end).add(start);
	}

	public Set<Integer> getAllArticulationPoints() {
		Set<Integer> atPoints = new HashSet<Integer>();
		boolean[] visited = new boolean[numberOfVertices];
		int[] entryTimeOfNodeTime = new int[numberOfVertices];
		int[] parent = new int[numberOfVertices];
		Arrays.fill(parent, -1);
		int[] lowestReachableNode = new int[numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			if (!visited[i]) {
				atPointUtil(i, visited, entryTimeOfNodeTime, parent, lowestReachableNode, atPoints);
			}
		}
		return atPoints;
	}

	private void atPointUtil(int u, boolean[] visited, int[] entryTimeOfNode, int[] parent,
			int[] lowestReachableNodeTime,  Set<Integer> atPoints) {
		visited[u] = true;
		entryTimeOfNode[u] = ++time;
		lowestReachableNodeTime[u] = entryTimeOfNode[u];
		int children = 0;
		for (int v : adjacencyList.get(u)) {
			if (!visited[v]) {
				children++;
				parent[v] = u;
				atPointUtil(v, visited, entryTimeOfNode, parent, lowestReachableNodeTime, atPoints);
				lowestReachableNodeTime[u]=Math.min(lowestReachableNodeTime[u], lowestReachableNodeTime[v]);
				if (parent[u] == -1 && children > 1) {
					atPoints.add(u);
				} else if (parent[u] != -1 && lowestReachableNodeTime[v] >= entryTimeOfNode[u]) {
					atPoints.add(u);
				}
			} else if (parent[u] != v) {
				lowestReachableNodeTime[u] = Math.min(lowestReachableNodeTime[u], entryTimeOfNode[v]);
			}
		}
	}

}
