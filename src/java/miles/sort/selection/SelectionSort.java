package miles.sort.selection;

/**
 * 简单选择排序：（O(n^2)，不稳定）
 * 每次从未排序的数组中选择一个最小值，放在已排序的后面
 */
public class SelectionSort {

    public static void selectionSort(int[] array){
        if (array == null || array.length<=1)
            return;
        int length = array.length;
        int minIndex = 0;   //未排序数组中最小值的下标
        for (int x=0;x<length;x++){
            int i=x+1;
            minIndex = x;
            //遍历找到最小值的下标
            for (;i<length;i++){
                if (array[i]<array[minIndex])
                    minIndex = i;
            }
            if (minIndex != x){
                //swap
                int temp = array[minIndex];
                array[minIndex] = array[x];
                array[x] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {5,2,0,1,3,1,4};
        selectionSort(array);
        for (int a:array)
            System.out.println(a);
    }

}
