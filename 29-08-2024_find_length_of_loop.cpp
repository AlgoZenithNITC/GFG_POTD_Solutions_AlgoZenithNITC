#include <unordered_set>

class Solution {
public:
    int findLoopLength(Node* start) {
        Node* currentNode = start;
        std::unordered_set<Node*> visitedNodes;

        while (currentNode != nullptr) {
            if (visitedNodes.find(currentNode) != visitedNodes.end()) {
                int loopLength = 1;
                Node* tempNode = currentNode->next;
                while (tempNode != currentNode) {
                    loopLength++;
                    tempNode = tempNode->next;
                }
                return loopLength;
            }
            visitedNodes.insert(currentNode);
            currentNode = currentNode->next;
        }
        return 0;
    }
};
