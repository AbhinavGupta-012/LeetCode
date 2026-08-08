/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        int prev = head.val;
        head = head.next;
        int count = 0;
        int idx = 0;
        while (head.next != null){
            if (head.val > prev && head.val > head.next.val){
                arr.add(idx);
                count++;
            }
            else if (head.val < prev && head.val < head.next.val){
                arr.add(idx);
                count++;
            }
            idx++;
            prev = head.val;
            head = head.next;
        }
        if (count < 2){
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        int max = arr.get(arr.size() - 1) - arr.get(0);
        for (int i = 0; i < arr.size() - 1; i++){
            if (arr.get(i + 1) - arr.get(i) < min){
                min = arr.get(i + 1) - arr.get(i);
            }
        }
        return new int[]{min, max};
    }
}