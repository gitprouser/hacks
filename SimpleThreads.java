public class SimpleThreads {
    // Display a message, preceded by 
    // the name of current thread
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s : %s%n", threadName, message);  
    }

    private static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = {
                "Om Bhuur-Bhuvah Svah",
                "Tat-Savitur-Varennyam!",
                "Bhargo Devasya Dhiimahi",
                "Dhiyo Yo Nah Pracodayaat!!"
            };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I am not DONE!!!");
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        // Delay, in milliseconds before we interrupt MessageLoop
        // thread (default one hour). 
        long patience = 1000 * 60 * 60;

        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while (t.isAlive()) {
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) 
                && t.isAlive()) {
                    threadMessage("Tired of waiting!");
                    t.interrupt();
                    t.join();
                }
        }
        threadMessage("Finally!");
    }
}
