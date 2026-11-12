package Lab_Challenge;

class ThreadLifecycleDemo {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread 1 is Running");

                Thread.sleep(2000);

                System.out.println("Thread 1 resumed after sleep()");

                Thread.yield();
                System.out.println("Thread 1 executed yield()");

            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 is Running");

                Thread.sleep(3000);

                System.out.println("Thread 2 completed");
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrupted!");
            }
        });

        System.out.println("T1 State: " + t1.getState());
        System.out.println("T2 State: " + t2.getState());


        t1.start();
        t2.start();

        try {
  
            Thread.sleep(500);

            System.out.println("T1 State: " + t1.getState());
            System.out.println("T2 State: " + t2.getState());

            t2.interrupt();

            t1.join();

            System.out.println("T1 State after completion: "
                               + t1.getState());

            t2.join();

            System.out.println("T2 State after completion: "
                               + t2.getState());

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread completed");
    }
}


