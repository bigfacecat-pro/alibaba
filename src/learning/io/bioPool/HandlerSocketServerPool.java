package learning.io.bioPool;

import java.util.concurrent.*;

public class HandlerSocketServerPool {
    private ExecutorService executorService;
    public  HandlerSocketServerPool(int maxThreadNumber,int queueSize){
        executorService=new ThreadPoolExecutor(3,maxThreadNumber,
                120,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable target){
        executorService.execute(target);
    }
}
