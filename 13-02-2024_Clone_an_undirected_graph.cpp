class Solution {
public:
    Node* cloneGraph(Node* node) {
        map<int, Node*> nodeMap;
        return cloneHelper(node, nodeMap);
    }

    Node* cloneHelper(Node* node, map<int, Node*>& nodeMap) {
        if (node == nullptr)
            return nullptr;

        if (nodeMap.find(node->val) == nodeMap.end()) {
            nodeMap[node->val] = new Node(node->val);
            for (Node* neighbor : node->neighbors) {
                if (nodeMap.find(neighbor->val) == nodeMap.end()) {
                    nodeMap[node->val]->neighbors.push_back(cloneHelper(neighbor, nodeMap));
                } else {
                    nodeMap[node->val]->neighbors.push_back(nodeMap[neighbor->val]);
                }
            }
        }
        return nodeMap[node->val];
    }
};
