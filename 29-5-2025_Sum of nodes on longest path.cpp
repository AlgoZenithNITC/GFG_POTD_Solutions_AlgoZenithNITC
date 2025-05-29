class Solution {
public:
    void rec(Node* root, int length, int sum, int& max_length, int& max_sum) {
        if (root == nullptr) {
            return;
        }
        sum += root->data;
        length++;

        if (length > max_length) {
            max_length = length;
            max_sum = sum;
        } else if (length == max_length) {
            if (sum > max_sum) {
                max_sum = sum;
            }
        }

        rec(root->left, length, sum, max_length, max_sum);
        rec(root->right, length, sum, max_length, max_sum);
    }

    int sumOfLongRootToLeafPath(Node* root) {
        int max_length = 0;
        int max_sum = 0;
        rec(root, 0, 0, max_length, max_sum);
        return max_sum;
    }
};