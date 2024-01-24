/*
 * Distance of nearest cell having 1
 *
 * Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
   The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, an   d i2,j2 are the row number and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.

Example 1:

Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
Explanation: The grid is-
0 1 1 0
1 1 0 0
0 0 1 1
0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
(2,1) are at a distance of 1 from 1's at (0,1),
(0,2), (0,2), (2,3), (1,0) and (1,1)
respectively.

Example 2:

Input: grid = {{1,0,1},{1,1,0},{1,0,0}}
Output: {{0,1,0},{0,0,1},{0,1,2}}
Explanation: The grid is-
1 0 1
1 1 0
1 0 0
0's at (0,1), (1,2), (2,1) and (2,2) are at a
distance of 1, 1, 1 and 2 from 1's at (0,0),
(0,2), (2,0) and (1,1) respectively.

*/
class Pair
{
    int a;int b;int step;
    public Pair(int a,int b,int s)
    {
        this.a=a;
        this.b=b;
        this.step=s;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        int res[][]=new int[grid.length][grid[0].length];
        //using BFS
        Queue<Pair> q=new LinkedList();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        while(!q.isEmpty())
        {
           Pair p=q.poll();
           int a=p.a;
           int b=p.b;
           int step=p.step;
           res[a][b]=step;
           for(int i=0;i<4;i++)
           {
               int nrow=a+delrow[i];
               int ncol=b+delcol[i];
               if(nrow>=0&&nrow<grid.length&&ncol>=0&&ncol<grid[0].length&&visited[nrow][ncol]==false)
               {
                   q.offer(new Pair(nrow,ncol,step+1));
                   visited[nrow][ncol]=true;
               }
           }
        }
        return res;
    }
}
