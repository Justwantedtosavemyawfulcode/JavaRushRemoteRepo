package com.javarush.task.task20.task2028;

/*
Построй дерево(1)
*/

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    LinkedList<Entry<String>> tree = new LinkedList<>();

    public CustomTree() {
        root = new Entry<>("root");
        tree.add(root);
    }

    @Override
    public boolean add(String s) {
        for (Entry<String> entry : tree) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    Entry<String> newEntry = new Entry<>(s);
                    newEntry.parent = entry;
                    entry.leftChild = newEntry;
                    entry.availableToAddLeftChildren = false;
                    tree.add(newEntry);
                    return true;
                }
                if (entry.availableToAddRightChildren) {
                    Entry<String> newEntry = new Entry<>(s);
                    newEntry.parent = entry;
                    entry.rightChild = newEntry;
                    entry.availableToAddRightChildren = false;
                    tree.add(newEntry);
                    return true;
                }
            }
        }
        return false;
    }

    public String getParent(String s) {
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(s)) {
                return entry.parent.elementName;
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }


    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
