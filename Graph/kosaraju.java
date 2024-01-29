/*
 * Strongly Connected Components (Kosaraju's Algo)
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 *
 * 
*/

import java.util.*;

class maxdiff {
  public static void main(String args[]) {
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++)
      adj.add(new ArrayList<>());
    addedge(adj, 0, 1);
    addedge(adj, 1, 2);
    addedge(adj, 2, 1);
    addedge(adj, 1, 3);
    addedge(adj, 3, 4);
    addedge(adj, 4, 5);
    addedge(adj, 5, 4);
    topo(adj, V);
  }

  public static void addedge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(u).add(v);
  }

  public static void reverseedge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
    adj.get(v).add(u);
  }

  public static void topo(ArrayList<ArrayList<Integer>> adj, int V) {
    Stack<Integer> st = new Stack<Integer>();
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == false)
        DFS(adj, i, visited, st);
    }
    adj.clear();
    for (int i = 0; i < V; i++)
      adj.add(new ArrayList<>());
    reverseedge(adj, 0, 1);
    reverseedge(adj, 1, 2);
    reverseedge(adj, 2, 1);
    reverseedge(adj, 1, 3);
    reverseedge(adj, 3, 4);
    reverseedge(adj, 4, 5);
    reverseedge(adj, 5, 4);
    Arrays.fill(visited, false);
    while (!st.isEmpty()) {
      int ele = st.pop();
      if (visited[ele] == false) {
        DFSutil(adj, ele, visited);
        System.err.println();
      }
    }

  }

  public static void DFS(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[], Stack<Integer> st) {
    visited[s] = true;
    for (int u : adj.get(s)) {
      if (visited[u] == false)
        DFS(adj, u, visited, st);
    }
    st.push(s);
  }

  public static void DFSutil(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[]) {
    visited[s] = true;
    System.err.print(s + " ");
    for (int u : adj.get(s)) {
      if (visited[u] == false)
        DFSutil(adj, u, visited);
    }
  }

}

