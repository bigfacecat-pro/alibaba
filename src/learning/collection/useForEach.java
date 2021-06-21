package learning.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class useForEach {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);

        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer);
            }
        });


        myList.forEach((Integer t)->{
            System.out.print("lamda: "+t);
        });

        Map<Integer,Character> map=new HashMap<>();
        for(int i=0;i<10;++i)
            map.put(i,(char)(i+45));
        map.forEach((Integer x,Character c)->{
            System.out.print(c);
        });
    }
}
