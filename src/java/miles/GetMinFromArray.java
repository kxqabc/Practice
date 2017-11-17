package miles;

public class GetMinFromArray {

    public int minNumberInRotateArray(int [] array) {
        if (array==null || array.length==0){
            System.out.println("array is empty!");
            return 0;
        }
        if (array.length == 1)
            return array[0];

        int head = 0;
        int tail = array.length - 1;
        int middle;
        while (head<tail){
            middle = (head + tail)/2;
            if (array[head] == array[tail]){	//如果头尾指针指向的元素相等，则各前进一步
                head++;
                tail--;
            }else if (array[head]<array[tail]){		//如果头指针小于尾指针，则说明头指针指向最小值
                System.out.println("head:"+head+" tail:"+tail);
                return array[head];
            }
            else {	//这下面是重点
                if (array[middle]<=array[tail])	//如果成立，则能肯定middle要么就是最小值，要么就是在最小值的右边（不一定紧挨）；
                    //所以这里如果写tail = middle -1;的话如果middle就在最小值处则会错过
                    tail = middle;
                else if (array[middle]>array[tail])	//如果成立，可以判定middle处于最小值的左边，可以将head设为middle后一个，即使middle+1指向最小值也不会错过。
                    head = middle + 1;
            }
        }
        System.out.println("head:"+head+" tail:"+tail);
        return array[head];
    }

    public static void main(String[] args) {
        int[] array = {2,3,0,1,2};
        GetMinFromArray getMinFromArray = new GetMinFromArray();
        int result = getMinFromArray.minNumberInRotateArray(array);
        System.out.println("result:"+result);
    }
}
