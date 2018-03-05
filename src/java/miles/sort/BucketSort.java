package miles.sort;

/**
 * 基数排序（桶排序）：O(n*d)，d为数组中最高位数组的位数、稳定
 */
public class BucketSort {

    public static void bucketSort(int[] array){
        boolean isMoreDigit = true;     //标志位，是否还有更高位
        int length = array.length;
        int[][] bucket = new int[10][length];
        int[] count = new int[10];      //用于记录每个桶中的元素个数
        int d = 1;
        //如果数组中的元素仍有更高位
        while (isMoreDigit){
            isMoreDigit = false;
            //将元素以相应位数大小放入二维数组：桶
            //过程需要判断，若n/d>0说明仍有高位，while循环仍需继续
            for (int n:array){
                //判断数组元素中是否仍有高位
                if (isMoreDigit || n/d>0)
                    isMoreDigit = true;
                int digit = (n/d)%10;
                bucket[digit][count[digit]++] = n;
            }
            //将依照某位放入桶中的数据取出覆盖原数组
            int k = 0;
            for (int i = 0;i<10;i++){
                for (int j = 0;j<count[i];j++){
                    array[k++] = bucket[i][j];
                }
                count[i] = 0;
            }
            //用于考察下一高位
            d *= 10;
        }

    }

    public static void main(String[] args) {
        int[] array = {3,0,1,2,5,1,4};
        bucketSort(array);
        for (int a:array)
            System.out.println(a);
    }

}
