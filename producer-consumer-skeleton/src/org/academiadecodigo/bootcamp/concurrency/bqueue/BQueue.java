package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    private final int limit;
    private Queue<T> queue;

    public BQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;


    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public void offer(T data) {

        synchronized (this) {
            while (getSize() == limit) {
                try {
                   // System.out.println(Thread.currentThread().getName() + ": The list is full, im waiting.");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(data);
            notifyAll();
             // System.out.println("added");
        }
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public T poll() {

        synchronized (this) {

            T toReturn = null;

            while (getSize() == 0) {

                try {
                    //System.out.println(Thread.currentThread().getName() + ": THE LIST IS EMPTY, WAITING");
                    wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            toReturn = queue.poll();
            //System.out.println("removed");
            notifyAll();
            return toReturn;

        }

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public synchronized int getSize() {
        return queue.size();


    }


    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;

    }

}
