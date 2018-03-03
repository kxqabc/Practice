package miles.dynamic;

/**
 * 最大连续乘积子串：
 * 输入一个数组，数组中可能包含正负数和零值，求数组中的连续子串使之乘积最大
 */
public class MaxMultiSubstring {

    public static int maxMultiSubstring(int[] array){
        if (array==null||array.length<=0)
            return 0;
        if (array.length==1)
            return array[0];
        int length = array.length;
        //假设进行到i下标，maxEnd表示一直到i之前的子串的最大乘积；
        //这里也包含了最小乘积，因为最小乘积可能是负数，不能因为它是负数就放弃，因为负负得正，如果再遇到一个负数反而可能会使之乘积更大
        int maxEnd = array[0];
        int minEnd = array[0];
        int maxResult = array[0];   //最终结果
        for (int i=1;i<length;i++){
            // end1、end2会和array[i]相比，表示子串加上i后是变大了还是减小了，如果是变大了，
            // 则把array[i]加入到子串中，如果变小了，则以array[i]为新的子串开头并舍弃之前的maxEnd子串结果
            int end1 = maxEnd*array[i], end2 = minEnd*array[i];
            maxEnd = max(max(end1,end2),array[i]);
            minEnd = min(min(end1,end2),array[i]);
            maxResult = max(maxEnd,maxResult);
        }
        return maxResult;
    }

    public static int max(int a1,int a2){
        return a1>a2?a1:a2;
    }

    public static int min(int a1,int a2){
        return a1>a2?a2:a1;
    }

    public static void main(String[] args) {
        int[] array = {-2,4,0,3,2,8,-1};
        int result = maxMultiSubstring(array);
        System.out.println("maxMultiRes:"+result);
    }
}
