package miles.sort.insert;

/**
 * 直接插入排序(稳定的、O(n^2))
 * ：需要两层循环，第一层遍历数组，假设现在处于i下标，那么第二层循环的作用就是依次在数组的
 * 下标（i-1~0）的元素中寻找array[i]按大小应该插入的位置，
 * 每向前对比一个则将其后移一位，直到找到正确的位置将其插入。
 */
public class DirectInsertionSort {

    public static void directInsertionSort(int[] array){
        if (array == null || array.length<=1)
            return;
        int temp = 0;
        //从数组的第二个元素开始
        for (int i=1;i<array.length;i++){
            temp = array[i];
            int j=i-1;  //从数组元素i前面哪个元素开始向前搜索
            for (;j>=0 && array[j]>temp;j--){
                array[j+1] = array[j];      //如果array[j]大于array[i]，则后移一位
            }
            array[j+1] = temp;      //找到合适的位置后，将其插入
        }
    }

    public static void main(String[] args) {
        int[] array = {5,2,0,1,3,1,4};
        directInsertionSort(array);
        for (int a:array)
            System.out.println(a);
    }

}
