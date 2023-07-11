package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int length = 0;
    private T t;

    public LinkedList() {
        this.head = new Node(null);
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {


        if (index >= length || head.getNext() == null) {
            return null;
        }
        Node iterator = head.getNext();
        int indexNumber = 0;

        while (indexNumber < index){

            iterator = iterator.getNext();
            indexNumber ++;

        }
        return (T)iterator.getData();

    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {
        int counter = 0;
        Node iterator = head;

        if(length <= 0) {
            return -1;
        }
        while (counter < length) {
            iterator = iterator.getNext();
            if (iterator.getData() == data) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {
        if (head.getNext() == null){
            return false;
        }

        Node iterator = head;
        Node prevIterator = null;


        while (iterator.getNext() != null){
            prevIterator = iterator;
            iterator = iterator.getNext();
            if (iterator.getData() == data){
                prevIterator.setNext(iterator.getNext());
                length--;
                return true;
            }


        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this);
    }



    // NODESSSSSSSSSSS //
    private class Node<T>{

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }


    // ITERATOR //

    private class LinkedListIterator<T> implements Iterator<T>{

        private Node<T> current;

        public LinkedListIterator(LinkedList<T> list){ // receives a list to iterate:
        current = list.getHead().getNext(); // needs getNext to not print null
        }


        @Override
        public boolean hasNext() {
            return current != null; // while current not null, it has next Node;
        }

        @Override
        public T next() {
            T data = (T) current.getData();
            current = current.getNext();
            return data;
        }
    }

}
