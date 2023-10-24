/*Problem Statement-The problem statement suggest to find out the largest area with all 1's in an binary array 2d array 
 *
 *
 * Example: Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.*/

/*Code */
public static void main(String args[])
    {
        int arr[][]={{1,0,0,1,1},
                   {0,0,0,1,1},
                   {1,1,1,1,1},
                   {0,1,1,1,1}};
        int res=getlargestarea(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1)
                 arr[i][j]+=arr[i-1][j];
            }
            res=Math.max(res,getlargestarea(arr[i]));
        }
        System.err.println(res);

    }
    public static int getlargestarea(int arr[])
    {
        Deque<Integer> s=new ArrayDeque<>();
        s.push(0);
        int res=0;
        for(int i=1;i<arr.length;i++)
        {
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i])
            {
                int tp=s.pop();
                tp=arr[tp]*(s.isEmpty()?i:i-s.peek()-1);
                res=Math.max(res,tp);
            }
            s.push(i);
        }
        while(!s.isEmpty())
        {
            int tp=s.pop();
            tp=arr[tp]*(s.isEmpty()?arr.length:arr.length-s.peek()-1);
            res=Math.max(res,tp);
        }
        return res;
    }//to find out largest area of histogram

