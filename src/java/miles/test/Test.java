package miles.test;

import java.util.*;

public class Test {

    public String test(int n){
        if(n<=0)
            return null;
        if(n==2)
            return "2";
        if(n==1)
            return "1";

        Stack<String> strings = new Stack<>();
        while(n>=1){
            if(n%2 == 0){
                n = (n-2)/2;
                strings.push("2");
            }else{
                n = (n-1)/2;
                strings.push("1");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!strings.empty()){
            stringBuilder.append(strings.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        System.out.println(test.test(10));
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test-value");
        String str = threadLocal.get();
        System.out.println(str);
        String s = "AABB";
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.size();
        Scanner in = new Scanner(System.in);
        in.next();
    }

}
