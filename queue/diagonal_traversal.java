/*Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

*/

    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            ArrayList<Integer> list=new ArrayList<>();
            Queue<Pair<Integer,Integer>> q=new LinkedList<>();
            int row=nums.size();
            int cols=nums.get(0).size();
            q.add(new Pair(0,0));
            int k=0;
            while(!q.isEmpty()){
                    Pair<Integer,Integer> p=q.poll();
                    int r=p.getKey();
                    int c=p.getValue();
                    list.add(nums.get(r).get(c));
                    if(c==0&&r+1<row)
                    q.add(new Pair(r+1,c));
                    if(c+1<nums.get(r).size())
                    q.add(new Pair(r,c+1));
                }
            int res[]=new int[list.size()];
            for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
            return res;
        }
    }
