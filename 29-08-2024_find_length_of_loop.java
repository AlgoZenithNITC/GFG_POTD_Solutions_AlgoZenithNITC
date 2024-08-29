import java.util.HashSet;

class Solution {
    public int findLoopLength(Node start) {
        Node currentNode = start;
        HashSet<Node> visitedNodes = new HashSet<>();

        while (currentNode != null) {
            if (visitedNodes.contains(currentNode)) {
                int loopLength = 1;
                Node tempNode = currentNode.next;
                while (tempNode != currentNode) {
                    loopLength++;
                    tempNode = tempNode.next;
                }
                return loopLength;
            }
            visitedNodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return 0;
    }
}
