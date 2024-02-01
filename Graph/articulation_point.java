/*
 * Articulation Point - I
 *
 * Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnects the graph into 2 or more components and return it in sorted manner.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.


Your Task:
You don't need to read or print anything. Your task is to complete the function articulationPoints() which takes V and adj as input parameters and returns a list containing all the vertices removing which turn the graph into two or more disconnected components in sorted order. If there are no such vertices then returns a list containing -1.

Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

*/
class articulate_point
{   int timer=1;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> al=new ArrayList();
        boolean vis[]=new boolean[V];
        int dis[]=new int[V];
        int low[]=new int[V];
        int ap[]=new int[V];
        for(int i=0;i<V;i++){
             dfs(adj,i,-1,vis,dis,low,ap);
        }

        for(int i=0;i<V;i++)
         if(ap[i]==1)
          al.add(i);
        if(al.size()==0)
         al.add(-1);
        return al;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj,int s,int parent,boolean vis[],int dis[],int low[],int ap[])
    {
        vis[s]=true;
        dis[s]=low[s]=++timer;
        int child=0;
        for(int v:adj.get(s))
        {
            if(s==parent)
             continue;
            if(vis[v]==false)
            {
                dfs(adj,v,s,vis,dis,low,ap);
                low[s]=Math.min(low[s],low[v]);
                if(low[v]>=dis[s]&&parent!=-1)
                 ap[s]=1;
                child++;

            }
            else
              low[s] = Math.min(low[s], dis[v]);
        }
        if(child>1&&parent==-1)
         ap[s]=1;
    }

}
