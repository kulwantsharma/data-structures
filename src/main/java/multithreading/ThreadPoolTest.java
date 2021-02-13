package multithreading;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    volatile static boolean EOF = false;

    public static void main(String[] args) throws FileNotFoundException {

        BlockingQueue<String> recordQueue = new ArrayBlockingQueue<String>(100);
//        ExecutorService service = Executors.newFixedThreadPool(3);
//
//        service.submit(new RecordParser(recordQueue));
//        service.submit(new RecordParser(recordQueue));
//        service.submit(new RecordParser(recordQueue));
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());
//        service.submit(new MyRunnable());


//        service.shutdown();

        new Thread(new CSVReader(recordQueue)).start();
        new Thread(new RecordParser(recordQueue)).start();
    }

    static class RecordParser implements Runnable {

        private BlockingQueue<String> recordQueue;

        RecordParser(BlockingQueue<String> recordQueue) {
            this.recordQueue = recordQueue;
        }

        @Override
        public void run() {

            int totalPolled = 0;
            while (true) {
                try {
//                    String take = recordQueue.take();
                    String take = recordQueue.poll(5, TimeUnit.SECONDS);
                    if (take != null) {
                        System.out.println("Consumer Thread::" + take);
                        ++totalPolled;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (EOF && recordQueue.isEmpty()){
                    break;
                }
            }

            System.out.println("Consumer Terminated, Total Polled:" + totalPolled);
        }
    }

    static class CSVReader implements Runnable {

        BufferedReader reader = null;
        File file = new File("C:\\Users\\H359968\\Documents\\MyPersonal\\GitTest\\learning-project\\src\\main\\java\\multithreading\\configured_19000.csv");
        private BlockingQueue<String> recordQueue;

        CSVReader(BlockingQueue<String> recordQueue) throws FileNotFoundException {
            this.recordQueue = recordQueue;
            reader = new BufferedReader(new FileReader(file));
        }


        @Override
        public void run() {

            String line = "";
            int maxQueueSize = Integer.MIN_VALUE;

            do {
                try {
                    line = reader.readLine();
                    if (line != null) {
                        System.out.println("Producer Thread::" + line);
                        recordQueue.put(line);
                        if(maxQueueSize < recordQueue.size()){
                            maxQueueSize = recordQueue.size();
                        }
                    } else {
                        EOF = true;
                    }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (line != null);

            System.out.println("Producer terminated");
            System.out.println("Max Queuesize:"+maxQueueSize);
        }
    }
}
