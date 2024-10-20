class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char> st1;
        stack<char> st2;
        for(auto exp: expression){
            if(exp=='&'||exp=='|'||exp=='!')
                st1.push(exp);
            else if(exp=='t'||exp=='f'||exp=='(')
                st2.push(exp);
            else if(exp==')'){
                char op = st1.top(); st1.pop();
                char operand1 = st2.top(); st2.pop();
                if(op=='!')
                    operand1 = (operand1=='t') ? 'f':'t';
                char operand2;
                while((operand2 = st2.top())!='('){
                    st2.pop();
                    if(op=='&')
                        operand1 = (operand1=='t' && operand2=='t') ? 't':'f';
                    else if(op=='|')
                        operand1 = (operand1=='f' && operand2=='f') ? 'f':'t';
                }
                st2.pop();
                st2.push(operand1);
            }
        }
        bool result = (st2.top()=='t') ? 1:0;
        return result;
    }
};
