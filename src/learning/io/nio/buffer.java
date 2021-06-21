package learning.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class buffer {
    @Test
    public void test(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//0
        System.out.println(buffer.capacity());//10
        String name="it";
        buffer.put(name.getBytes());
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//2
        System.out.println(buffer.capacity());//10
        //将缓冲区界限者只为当前位置，并将position置零
        buffer.flip();
        System.out.println("-------------------------");
        System.out.println(buffer.limit());//2
        System.out.println(buffer.position());//0
        System.out.println(buffer.capacity());//10

        char c=(char)buffer.get();
        System.out.println("-------------------------");
        System.out.println(c);//i
        System.out.println(buffer.limit());//2
        System.out.println(buffer.position());//1
        System.out.println(buffer.capacity());//10
    }
    @Test
    public void test2(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//0
        System.out.println(buffer.capacity());//10
        String name="itwasyour";
        buffer.put(name.getBytes());
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//10
        //将缓冲区界限者只为当前位置，并将position置零
        buffer.clear();
        System.out.println("-------------------------");
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//0
        byte[] da=new byte[2];
        buffer.get(da);
        System.out.println("-------------------------");
        System.out.println(new String(da));
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//2

        buffer.get(da);
        System.out.println("-------------------------");
        System.out.println(new String(da));
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//4

        buffer.mark();
        //重置位置到刚才标记的地方，没有标记会报错
        buffer.reset();
        System.out.println("-------------------------");
        System.out.println(buffer.limit());//10
        System.out.println(buffer.position());//4
    }
    @Test
    public void test3(){
        ByteBuffer buffer= ByteBuffer.allocate(1024);

    }
}
