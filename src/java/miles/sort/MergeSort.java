package miles.sort;

/**
 * 归并排序：O(nlogn)、稳定的
 * 将数组先递归均分拆分，直到拆成一个个，每个元素是有序的，然后再进行合并
 */
public class MergeSort {

    public static void mergeSort(int[] array,int left,int right){
        if (left < right){
            //center作为拆分点
            int center = (left + right)/2;
            //对center左边部分进行拆分、合并排序
            mergeSort(array,left,center);
            //对center右边部分进行拆分、合并排序
            mergeSort(array,center+1,right);
            //将左、右排序、合并好的部分合并、排序起来
            merge(array,left,center,right);
        }
    }

    /**
     * 合并
     * @param array
     * @param left：合并起始位置
     * @param center：合并的两部分数组的分界线
     * @param right：合并的结束位置
     */
    public static void merge(int[] array,int left,int center,int right){
        int[] tempArray = new int[array.length];
        //复制int变量
        int l = left;   //左边部分的起点
        int m = center+1;   //右边部分的起点
        int r = right;
        int i = left;   //临时数组的下标指针
        //逐个对比数组两部分大小，将其按顺序储存到临时数组中
        while (l <= center && m<=right){
            if (array[l]<=array[m]){
                tempArray[i] = array[l];
                ++l;
            }else {
                tempArray[i] = array[m];
                ++m;
            }
            ++i;
        }
        //如果剩余的全是右半部分数组
        while (m <= right){
            tempArray[i] = array[m];
            ++i;
            ++m;
        }
        //如果剩余的全是左半边数组
        while (l <= center){
            tempArray[i] = array[l];
            ++i;
            ++l;
        }
        //将临时数组的数据复制到原数组中
        System.arraycopy(tempArray,left,array,left,right-left+1);

    }

    public static void main(String[] args) {
        int[] array = {3,0,1,2,5,1,4};
        mergeSort(array,0,array.length-1);
        for (int a:array)
            System.out.println(a);
    }

}
