package miles;

public class VerifySquenceOfBST {
    //后序遍历得到的数组可以肯定的一件事就是：最后一个元素一定是根节点；
    // 如果这棵树是二叉搜索树的话，因为后序遍历中，子树的根节点一定在左右孩子输出后才会被输出，
    // 所以得到的数组可以以根节点（数组中最后一个元素）为分界线讲数组划分为两端，左边的元素全都小于根节点，右边的都大于根节点；
    // 并且这个规律在子树（子数组）中依然适用。
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null)
            return false;
        int length = sequence.length;
        if (length == 1)
            return true;
        return isBST(sequence,0,length-1);
    }

    public boolean isBST(int[] array,int start,int end){
        if (start>=end)
            return true;
        int root = array[end];  //根节点（整棵树或子树）
        int split;  //分界点，最终指向大于root的第一个数
        //找到root节点在数组中的左、右子树的分界点
        for (split=start;split<end;split++){
            if (array[split]>root)
                break;
        }
        //验证右子树中是否含有大于root的元素，若存在则不符合后序遍历二叉搜索树的特性
        for (int j=split;j<end;j++){
            if (array[j]<root)
                return false;
        }
        //递归遍历左右子树
        return isBST(array,start,split-1)&&isBST(array,split,end-1);
    }
}
