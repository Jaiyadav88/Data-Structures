import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DisjointSet
 * Author: Jai Yadav
 */
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int find(int node) {
        if (node == parent.get(node))
            return node;
        int ulp = find(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void union(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v))
            parent.set(ulp_u, ulp_v);
        else if (rank.get(ulp_u) > rank.get(ulp_v))
            parent.set(ulp_v, ulp_u);
        else {
            parent.set(ulp_v, ulp_u);
            int val = rank.get(ulp_u);
            rank.set(ulp_u, val + 1);
        }
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge e) {
        return this.wt - e.wt;
    }
}

public class Main {
    public static void main(String[] args) {
        DisjointSet d = new DisjointSet(7);

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 4, 1));
        edges.add(new Edge(2, 4, 3));
        edges.add(new Edge(2, 5, 10));
        edges.add(new Edge(3, 1, 4));
        edges.add(new Edge(3, 6, 5));
        edges.add(new Edge(4, 3, 2));
        edges.add(new Edge(4, 5, 7));
        edges.add(new Edge(4, 6, 8));
        edges.add(new Edge(5, 6, 6));

        kruskalMST(d, edges);
    }

    public static void kruskalMST(DisjointSet ds, List<Edge> edges) {
        Collections.sort(edges);

        for (Edge edge : edges) {
            int srcParent = ds.find(edge.src);
            int destParent = ds.find(edge.dest);

            if (srcParent != destParent) {
                System.out.println("Edge: " + edge.src + " - " + edge.dest + " Weight: " + edge.wt);
                ds.union(srcParent, destParent);
            }
        }
    }
}

