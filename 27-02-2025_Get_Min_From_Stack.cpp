// C++ program to implement a stack that supports
// all operations in O(1) time and O(n) extra space.

#include <iostream>
#include <stack>
using namespace std;

// A user defined stack that supports getMin() in
// addition to push(), pop() and peek()
class SpecialStack {
private:
    stack<pair<int, int> > s;

public:
    SpecialStack() {
        
    }
    
    // Add an element to the top of Stack
    void push(int x) {
        int newMin = s.empty() ? x : min(x, s.top().second);

        // we push the pair of given element and newMin into stack
        s.push({ x, newMin });
    }
    
    // Remove the top element from the Stack
    void pop() {
        if (!s.empty()) {
            s.pop();
        }
    }
    
    // Returns top element of the Stack
    int peek() {
        if (s.empty()) {
            return -1;
        }

        int top = s.top().first;
        return top;
    }
    
    // Finds minimum element of Stack
    int getMin() {
        if (s.empty()) {
            return -1;
        }
        
        int mn = s.top().second;
        return mn;
    }
};

int main() {
    SpecialStack ss;
    
    // Function calls
    ss.push(2);
    ss.push(3);
    cout << ss.peek() << " ";
    ss.pop();
    cout << ss.getMin() << " ";
    ss.push(1);
    cout << ss.getMin() << " ";
}