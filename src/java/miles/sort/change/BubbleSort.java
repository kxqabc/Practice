package miles.sort.change;

/**
 * 冒牌排序：O(n^2)、稳定
 * 每次循环时对比当前元素和下一个元素，如果当前元素大于下一元素则两者交换，
 * 这样的话每次都能将未排好序中的最大者“下沉”到尾部。
 */
public class BubbleSort {

    public static void bubbleSort(int[] array){
        if (array == null || array.length<=1)
            return;
        int length = array.length;
        //每次下沉一个最大元素在未排序数组末尾
        for (int i=0;i<length;i++){
            //末尾排好序的最大元素们不需要再交换
            for (int j = 0;j<length-i-1;j++){
                if (array[j]>array[j+1]){
                    //swap
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,2,0,1,3,1,4};
        bubbleSort(array);
        for (int a:array)
            System.out.println(a);
    }
}
