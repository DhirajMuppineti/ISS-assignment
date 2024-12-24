package main;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    
    // AtomicInteger guarantees no two threads can increment simultaneously (Instance-level synchronization)
    private static AtomicInteger counter = new AtomicInteger(0);

    // Volatile flag ensures every thread can see the updated value once it's changed
    private static volatile boolean stopFlag = false;

    // Threshold value for counter to stop threads
    private static final int THRESHOLD = 5000;

    public static void main(String[] args) {
        // Using ThreadPoolExecutor to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 threads in the pool

        // Submit 5 tasks to the thread pool
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Task());
        }

        try {
        	Thread.sleep(1000); // Sleep for a short time to give threads a chance to increment
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final value should be the threshold
        logger.info("Final Counter Value: " + counter);

        // Shutdown the executor
        executorService.shutdown();
    }

    // Task class that increments the counter
    static class Task implements Runnable {
        @Override
        public void run() {
            while (!stopFlag) { // Threads check the stop flag to see if they should continue running
                synchronized (Main.class) { // Block-level synchronization
                    if (counter.get() >= THRESHOLD) { 
                        stopFlag = true; // Stop the threads if the threshold is reached
                        break;
                    }
                    incrementCounter(); 
                }
            }
        }

        // Method level synchronization
        private synchronized void incrementCounter() {
            // Increment the counter atomically using AtomicInteger
            counter.incrementAndGet(); // This is the shared resource
        }
    }
}
