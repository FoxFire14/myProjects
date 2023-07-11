package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {


        while (elementNum > 0) {


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (queue) {
                queue.poll();

                System.out.println(Thread.currentThread().getName() + ": Element removed");

                if(queue.getSize() == 0) {
                    System.out.println(Thread.currentThread().getName() + ": EMPTY");
                }
            }
            --elementNum;
        }


    }

}
