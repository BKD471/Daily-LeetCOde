package stacks;

import java.util.Stack;

public class EvalPostFix {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> st=new Stack<>();
        if(n==0) return 0;

        for(int i=0;i<n;i++){
            String temp=tokens[i];
            if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")){
                int a=0,b=0;
                if(!st.isEmpty()) a=st.pop();
                if(!st.isEmpty()) b=st.pop();
                if(a==0 && temp.equals("/")) return -9999;
                int res=0;
                switch(temp){
                    case "+": res=a+b;
                        break;
                    case "-": res=b-a;
                        break;
                    case "/": res=b/a;
                        break;
                    case "*": res=a*b;
                }
                st.push(res);
            }else{
                int v=Integer.parseInt(temp);
                st.push(v);
            }
        }
        return st.pop();
    }
}
