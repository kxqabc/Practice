package miles.sort.change;

/**
 * 快速排序：O(nlongn)、不稳定
 */
public class QuickSort {

    public static void quickSort(int[] array,int head,int tail){
        if (array == null || array.length<=1)
            return;
        //递归的判断出口
        if (tail>head){
            int base = array[head];     //通常选取第一个为基准
            int headCopy = head;
            int tailCopy = tail;
            //遍历
            while (tail > head){
                //从尾部向前寻找符合基准base的下标
                while (tail>head && array[tail]>=base){
                    --tail;
                }
                //此时tail指向的元素不符合基准（小于基准），将head元素设置为tail指向的元素，而tail指向的值并不重要，是用来存放下一个不符合的head元素的
                if (tail > head){
                    array[head] = array[tail];
                    ++head;
                }

                //从头部向后寻找符合base的下标
                while (tail>head && array[head]<=base){
                    ++head;
                }
                //此时head指向的元素大于base需要移到后面，则将head的元素赋予tail指向的位置来存放
                if (tail > head){
                    array[tail] = array[head];
                    --tail;
                }
            }
            //基准base归位
            array[head] = base;
            //递归，对base分成的两部分分别用快速排序
            quickSort(array,headCopy,head-1);
            quickSort(array,head+1,tailCopy);
        }

    }

    public static void main(String[] args) {
        int[] array = {3,0,1,2,5,1,4};
        quickSort(array,0,array.length-1);
        for (int a:array)
            System.out.println(a);
    }

}
