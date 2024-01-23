/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
 *
 * Expected Time Complexity: O(V + E).
 * Expected Auxiliary Space: O(V).
 */

import java.util.*;

class Kahns_Algo {
  public static void main(String args[]) {
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < V; i++)
      adj.add(new ArrayList<Integer>());
    addEdge(adj, 5, 0);
    addEdge(adj, 5, 2);
    addEdge(adj, 2, 3);
    addEdge(adj, 1, 3);
    addEdge(adj, 4, 1);
    addEdge(adj, 4, 0);
    toposort(adj, V);
  }

  static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
  }

  static void toposort(ArrayList<ArrayList<Integer>> adj, int V) {
    int indegree[] = new int[V];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < adj.size(); i++) {
      for (int u : adj.get(i))
        indegree[u]++;
    }
    for (int i = 0; i < V; i++)
      if (indegree[i] == 0)
        q.offer(i);
    while (!q.isEmpty()) {
      int curr = q.poll();
      System.err.print(curr + " ");
      for (int neighbour : adj.get(curr)) {
        indegree[neighbour]--;
        if (indegree[neighbour] == 0)
          q.offer(neighbour);
      }
    }
  }
}
