class TreeNode{
    int val;
    List<TreeNode> children;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
        children = new ArrayList<>();
    }
}

class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++){
            map.put(i, new TreeNode(i));
        }
        for (int i = 1; i < parent.length; i++){
            map.get(parent[i]).children.add(map.get(i));
        }
        int[] depths = new int[parent.length];
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(map.get(0));
        int h = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                depths[node.val] = h + 1;
                for (TreeNode child : node.children){
                    queue.add(child);
                }
            }
            h++;
        }
        long sum = 0;
        for (int i = 0; i < parent.length; i++){
            sum += (long) nums[i] * (h - depths[i] + 1);
        }
        return sum;
    }
}