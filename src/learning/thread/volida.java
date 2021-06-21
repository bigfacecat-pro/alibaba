package learning.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class volida {
    public static AtomicInteger count=new AtomicInteger(0);

    public static void  increase(){
        count.incrementAndGet();
        System.out.println(count);
    }
    public static void main(String[] args) {
        Thread[] threads=new Thread[20];
        for(int i=0;i<10;++i){
            threads[i]=new Thread(()->{
                for(int s=0;s<10;s++)
                    increase();
            });
            threads[i].start();
        }
    }
    public static void noting(){

    }
}
