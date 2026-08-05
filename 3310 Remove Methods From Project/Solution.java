class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : invocations){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int v = queue.poll();
                set.add(v);
                for (int neighbour : graph.getOrDefault(v, new ArrayList<>())){
                    if (!visited.contains(neighbour)){
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        for (int val : set){
            for (int num : map.getOrDefault(val, new HashSet<>())){
                if (!set.contains(num)){
                    List<Integer> res = new ArrayList<>();
                    for (int i = 0; i < n; i++){
                        res.add(i);
                    }
                    return res;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}