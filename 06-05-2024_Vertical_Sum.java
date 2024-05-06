class Solution {
    public List<Integer> verticalSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new TreeMap<>();
        verticalSumCal(root, sumMap, 0);
        return new ArrayList<>(sumMap.values());
    }

    private void verticalSumCal(TreeNode node, Map<Integer, Integer> sumMap, int val) {
        if (node == null) {
            return;
        }
        sumMap.put(val, sumMap.getOrDefault(val, 0) + node.val);
        verticalSumCal(node.left, sumMap, val - 1);
        verticalSumCal(node.right, sumMap, val + 1);
    }
}

