package com.minerva.analytic.ds.ringbuffer;

public class RingBuffer<E> {

    private E []elements;
    private volatile int readSequence;
    private volatile int writeSequence;
    private int capacity;
    public RingBuffer(int capacity) {
        writeSequence = -1;
        readSequence = 0;
        elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public boolean offer(E element) {
        boolean isFull = (writeSequence-readSequence)+1 == capacity;
        if(!isFull) {
            int nextSequence = writeSequence+1;
            elements[nextSequence%capacity] = element;
            writeSequence++;
            return true;
        }
        return false;
    }

    public E poll() {
        boolean isEmpty = writeSequence < readSequence;
        if(!isEmpty) {
            E element = elements[readSequence%capacity];
            readSequence++;
            return element;
        }
        return null;
    }

}
