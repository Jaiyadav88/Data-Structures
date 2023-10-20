/* Problem Satement-
 * Our task is to Implement K stacks that should use only one array. The K stacks must support these functions
   push(int x, int sn): pushes element x to stack number ‘sn’ where sn ranges from 0 to k-1.
   pop(int sn): pops an element from stack number ‘sn’ where sn ranges from 0 to k-1.
*/
import java.util.*;
class maxdiff{
    int arr[];
    int top[];
    int next[];
    int freespot;
    int k,s;
    public maxdiff(int k ,int s)
    {
        this.k=k;
        this.s=s;
        arr=new int[s];
        top=new int[k];
        next=new int[s];
        Arrays.fill(top,-1);
        for(int i=0;i<s;i++)
         next[i]=i+1;
        next[s-1]=-1;
        freespot=0;
    }
    void push(int val,int k)
    {
        if(freespot==-1){
          System.err.println("Overflow\n");
          return;
        }
        int index=freespot;
        freespot=next[index];
        arr[index]=val;
        next[index]=top[k-1];
        top[k-1]=index;
    }
    void pop(int k)
    {
        if(top[k-1]==-1)
        {
            System.err.println("Underflow\n");
            return;
        }
        int index=top[k-1];
        top[k-1]=next[index];
        next[index]=freespot;
        freespot=index;
    }
   void display(int k)
    {
         int index=top[k-1];
         while(index!=-1)
         {
              System.out.print(arr[index]+" ");
              index=next[index];
         }
    }
    public static void main(String args[])
    {
        maxdiff obj=new maxdiff(3,5);
        obj.push(10,1);
        obj.push(20,1);
        obj.push(30,1);
        obj.push(40,2);
        obj.display(1);
        obj.display(2);

    }
}
