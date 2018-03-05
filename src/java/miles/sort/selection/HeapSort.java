package miles.sort.selection;

import java.util.Comparator;

/**
 * 堆排序：O(nlog2n)、不稳定
 */
public class HeapSort {

    public <T> void buildMaxHeap(T[] datas,Comparator<? super T> comparator){
        for (int i = datas.length/2+1;i>=0;i--){
            maxHeap(datas,i,datas.length,comparator);
        }
    }

    public <T> void maxHeap(T[] datas, int index, int length, Comparator<? super T> comparator){
        int lIndex = leftChildIndex(index);
        int rIndex = rightChildIndex(index);
        int maxIndex = index;
        //use maxIndex record the maxium in datas[parent] and her children
        if (lIndex<length && comparator.compare(datas[index],datas[lIndex])<0)
            maxIndex = lIndex;
        if (rIndex<length && comparator.compare(datas[maxIndex],datas[rIndex])<0)
            maxIndex = rIndex;
        //swap index and maxIndex value
        if (maxIndex != index){
            T temp = datas[index];
            datas[index] = datas[maxIndex];
            datas[maxIndex] = temp;

            maxHeap(datas,maxIndex,length,comparator);
        }
    }

    public int leftChildIndex(int parentIndex){
        return parentIndex*2+1;
    }

    public int rightChildIndex(int parentIndex){
        return parentIndex*2+2;
    }

    public static void main(String[] args) {
        Integer[] array = {3,2,4,6,7,0};
        HeapSort heapSort = new HeapSort();
        heapSort.buildMaxHeap(array,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1<o2)
                    return -1;
                else if (o1==o2)
                    return 0;
                else
                    return 1;
            }
        });
//        heapSort.maxHeap(array, 0,array.length, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1<o2)
//                    return -1;
//                else if (o1==o2)
//                    return 0;
//                else
//                    return 1;
//            }
//        });
        System.out.println();
        for (int i:array){
            System.out.print(" "+i);
        }
    }
}
