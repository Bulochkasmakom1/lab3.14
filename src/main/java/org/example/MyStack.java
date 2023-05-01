package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {

    private Node<T> tail;

    private int size;


    @SafeVarargs
    public MyStack(T... objects) {
        for (T object : objects) {
            push(object);
        }
    }

    public MyStack(Collection<? extends T> collection) {
        collection.forEach(this::push);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size <= 0;
    }


    public T peek() {
        if (size <= 0)
            throw new NoSuchElementException("Stack is empty");
        return tail.element;
    }

    public void push(T newElem) {
        Node<T> newTail = new Node<>(newElem);
        if (tail != null) {
            tail.next = newTail;
            newTail.previous = tail;
        }
        tail = newTail;
        ++size;
    }

    public T pop() {
        if (size <= 0)
            throw new NoSuchElementException("Stack is empty");
        T retElement = tail.element;
        if (tail.previous != null) {
            tail.previous.next = null;
        }
        tail = tail.previous;
        --size;
        return retElement;
    }


    public void addAll(Collection<? extends T> collection) {
        collection.forEach(this::push);
    }


    public void addAll(T[] objects) {
        for (T object : objects) {
            push(object);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }


    private static class Node<T> {

        private final T element;
        private Node<T> previous;

        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private class StackIterator implements Iterator<T> {

        private int remaining = size();

        private Node<T> next = tail;


        @Override
        public boolean hasNext() {
            return remaining > 0;
        }


        @Override
        public T next() {
            if (remaining <= 0)
                throw new NoSuchElementException();
            T current = next.element;
            next = next.previous;
            --remaining;
            return current;
        }


        @Override
        public void remove() {

        }
    }
}
