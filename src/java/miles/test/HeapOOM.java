package miles.test;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject{
    }

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2*1024*1024];
        allocation2 = new byte[2*1024*1024];
        allocation3 = new byte[2*1024*1024];
        allocation4 = new byte[4*1024*1024];
    }

    public static void main(String[] args) throws InterruptedException {
        testAllocation();
//        Thread.sleep(500);
    }

}
