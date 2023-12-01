/*
 *  Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same Node class where the right child pointer points to the next   node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

 */

class Solution
{
    public static void flatten(Node root)
    {
        //morris traversal
        Node curr=root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                Node pred=predecessor(curr);
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
                curr=curr.right;
            }
            else
             curr=curr.right;
        }
    }
    public static Node predecessor(Node root)
    {
        root=root.left;
        while(root.right!=null)
         root=root.right;
        return root;
    }
}
