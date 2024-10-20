class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (char exp : expression.toCharArray()) {
            if (exp == '&' || exp == '|' || exp == '!')
                st1.push(exp);
            else if (exp == 't' || exp == 'f' || exp == '(')
                st2.push(exp);
            else if (exp == ')') {
                char op = st1.pop();
                char operand1 = st2.pop();
                if (op == '!')
                    operand1 = (operand1 == 't') ? 'f' : 't';
                char operand2;
                while ((operand2 = st2.pop()) != '(') {
                    if (op == '&')
                        operand1 = (operand1 == 't' && operand2 == 't') ? 't' : 'f';
                    else if (op == '|')
                        operand1 = (operand1 == 'f' && operand2 == 'f') ? 'f' : 't';
                }
                st2.push(operand1);
            }
        }
        return st2.pop() == 't';
    }
}
