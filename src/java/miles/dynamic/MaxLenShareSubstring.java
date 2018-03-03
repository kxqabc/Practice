package miles.dynamic;

/**
 * 求两个字符串的最大公共子串（连续）的长度：
 * 假设len[i][j]表示以字符串a、b中a[i]、b[j]为结尾的子串的最大长度，则：
 * 1.当a[i]==b[j]，len[i][j]=len[i-1][j-1]+1;
 * 2.当a[i]!=b[j]，len[i][j]=0；
 * 3.因为当i==0或者j==0时，tam没有前驱，所以不能使用“len[i][j]=len[i-1][j-1]+1”，
 *   只能在第一列或第一行赋值‘1’或‘0’。
 * @param <T>
 */
public class MaxLenShareSubstring<T> {

    public int maxLenShareSubstring(T[] array1,T[] array2){
        int maxShareLen = 0;
        int[][] lenMatrix = new int[array1.length][array2.length];

        for (int i=0;i<array1.length;i++){
            for (int j=0;j<array2.length;j++){
                //如果两个结尾相等
                if (array1[i]==array2[j] || array1[i].equals(array2[j])){
                    // 不在第一列或第一行，存在前驱元素，可以用公式
                    if (i>0 && j>0){
                        lenMatrix[i][j] = lenMatrix[i-1][i-1] + 1;
                    }else {
                        // 处于第一行或第一列，只能赋值0或1
                        lenMatrix[i][j] = 1;
                    }
                    //更新最长公共长度
                    if (lenMatrix[i][j] > maxShareLen)
                        maxShareLen = lenMatrix[i][j];
                }else
                    lenMatrix[i][j] = 0;
            }
        }
        return maxShareLen;
    }

    public static void main(String[] args) {
        Character[] string1 = {'a','b','c','d'};
        Character[] string2 = {'d','b','c','a'};
        MaxLenShareSubstring maxLenShareSubstring = new MaxLenShareSubstring();
        int maxLen = maxLenShareSubstring.maxLenShareSubstring(string1,string2);
        System.out.println("maxShareLen:"+maxLen);
    }

}
