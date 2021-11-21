package modernjavainaction.chap02;

import java.util.concurrent.*;

public class ServiceExecutorSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(ExecutorService());

        System.out.println(ExecutorServiceWithLambda());
    }

    private static String ExecutorService() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        executorService.shutdown();

        return threadName.get();

    }

    private static String ExecutorServiceWithLambda() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());

        executorService.shutdown();

        return threadName.get();
    }
}
