class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ele = 0;
        int total = 0;
        for (int req : requests){
            total += Math.abs(ele - req);
            ele = req;
        }
        return total;
    }
}