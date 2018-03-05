package miles.sort.insert;

/**
 * 希尔排序：（O(n^1.3)，不稳定）
 * 是直接插入排序的改进：直接插入排序有一个很大的缺点就是：每插入一个元素时，都必须移动大量的元素，如果我们选取增量，这样我们每插入一个数据所
 * 移动的次数将会大大减小，约为直接插入排序的1/d，d为增量。
 */
public class ShellSort {

    public static void shellSort(int[] array){
        if (array == null || array.length<=1)
            return;
        int length = array.length;
        //d是增量，初始量为数组长度的一半，以后每次减半
        for (int d = length/2;d>0;d /= 2){
            //进行分组：(1).0,d,2d,3d.. (2).1,d+1,2d+1..
            for (int x = 0;x < d;x++){
                //下面为直接插入排序，但是元素之间的下标间隔为d
                for (int i = x + d;i < length;i += d){
                    int temp = array[i];
                    int j = i - d;
                    for (;j >= 0 && array[j] > temp;j -= d){
                        array[j+d] = array[j];
                    }
                    array[j+d] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {5,2,0,1,3,1,4};
        shellSort(array);
        for (int a:array)
            System.out.println(a);
    }
}
