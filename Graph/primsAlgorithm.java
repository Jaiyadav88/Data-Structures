/*
 * Minimum Spanning Tree
 *
 * Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree. Given adjacency list adj as input parameters . Here adj[i] contains vectors of size 2, where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.
 *
 * Example 1:

Input:
3 3
0 1 5
1 2 3
0 2 1

Output:
4

Example 2:

Input:
2 1
0 1 5

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.

*/
import java.util.*;

class Pair implements Comparable<Pair> {
  int v, wt;

  public Pair(int v, int wt) {
    this.v = v;
    this.wt = wt;
  }

  @Override
  public int compareTo(Pair p) {
    if (p.wt < this.wt)
      return 1;
    return -1;
  }
}

class maxdiff {
  public static void main(String args[]) {
    int V = 5;
    int edges[][] = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 }, { 0, 5, 7, 9, 0 } };
    createAdjancencylist(edges, V);
  }

  static void createAdjancencylist(int edges[][], int V) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++)
      adj.add(new ArrayList<Pair>());
    for (int i = 0; i < V; i++) {
      for (int j = i + 1; j < V; j++) {
        if (edges[i][j] != 0) {
          adj.get(i).add(new Pair(j, edges[i][j]));
          adj.get(j).add(new Pair(i, edges[i][j]));
        }
      }
    }
    PrimsAlgo(adj, V);
  }

  static void PrimsAlgo(ArrayList<ArrayList<Pair>> adj, int V) {

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int s = 0;
    boolean inMST[] = new boolean[V];
    pq.offer(new Pair(0, 0));
    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int v = p.v;
      int wt = p.wt;
      if (inMST[v] == true)
        continue;
      s = s + wt;
      inMST[v] = true;
      for (Pair neighbour : adj.get(v)) {
        int a = neighbour.v;
        int b = neighbour.wt;
        if (inMST[a] == false) {
          pq.offer(new Pair(a, b));
        }
      }

    }
    System.err.println(s);
  }

}
