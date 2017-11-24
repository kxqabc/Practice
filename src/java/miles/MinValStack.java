package miles;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinValStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty())
            minStack.push(node);
        else if (node<=minStack.peek())
            minStack.push(node);
    }

    public void pop() {
        int popVal;
        if (!stack.isEmpty()){
            popVal = stack.pop();
            if (!minStack.isEmpty())
                if (popVal==minStack.peek())
                    minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
