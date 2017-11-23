package miles;

import java.util.Stack;

public class CheckPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||pushA.length==0||popA==null||popA.length==0)
            return true;
        //创建一个堆栈，重新模拟popA所表示的压入、推出的过程，若通过popA的结果模拟成功的话，则说明是可以的
        Stack<Integer> stack = new Stack<>();
        int popIndex=0;     //模拟时popA的操作数的坐标
        int pushIndex=0;    //模拟时pushA的操作数的坐标

        //当popIndex>=数组长度时退出，若能顺利退出则表示模拟完成
        while (popIndex<pushA.length){
            //方便调试
            System.out.println("popIndex:"+popIndex+" pushIndex:"+pushIndex);
            System.out.println("stack.length:"+stack.size());
            Object[] array = new Object[10];
            stack.copyInto(array);
            printArray(array);
            //如果堆栈中包含将要模拟推出的元素，则说明堆栈中的栈顶元素一定是popIndex指向的popA数组中的元素；
            // pushIndex>pushA.length-1表示元素已经全部放入堆栈
            if (stack.contains(popA[popIndex])||pushIndex>pushA.length-1){
                int popNum = stack.pop();   //栈顶元素
                if (popNum!=popA[popIndex])     //不相等，则模拟失败
                    return false;
                else {      //相等，则继续考察（模拟）popA数组中的下一个元素
                    popIndex++;
                }
            }else {
                //将popIndex指向的popA数组中的元素作为考察对象，查找该元素在pushA中的位置，并将pushA中该元素之前的元素依次压入堆栈，模拟压入过程
                while (pushIndex<pushA.length){
                    //压入堆栈，pushIndex加1
                    stack.push(pushA[pushIndex]);
                    ++pushIndex;
                    //找到pushA中popA[popIndex]元素的位置，退出循环（此时已将找到的元素也压入了堆栈）
                    if (pushA[pushIndex-1]==popA[popIndex]) {
                        break;
                    }
                }
            }
        }
        return true;
    }

    public void printArray(Object[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\r\n"+"-----------------------------------");
    }

    public static void main(String[] args) {
        int[] pushA = {1};
        int[] popA = {2};
        CheckPopOrder checkPopOrder = new CheckPopOrder();
        boolean result = checkPopOrder.IsPopOrder(pushA,popA);
        System.out.println("result:"+result);
    }
}
