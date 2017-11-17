package miles;

import java.util.Stack;

public class Stack2Queue {
    Stack<Integer> stack1 = new Stack<Integer>();   //push
    Stack<Integer> stack2 = new Stack<Integer>();   //pop

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
        if (stack1.isEmpty()){
            //如果stack1为空，则将stack2中的数据依次压入stack1中
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        if (!stack1.isEmpty())
            return stack1.pop();
        else
            return -1;  //从stack2中取不出数据（即stack1、stack2中都为空）
    }
}
