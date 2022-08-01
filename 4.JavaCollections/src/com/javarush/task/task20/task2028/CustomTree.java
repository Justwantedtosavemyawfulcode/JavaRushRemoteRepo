package com.javarush.task.task20.task2028;

/*
Построй дерево(1)
*/

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry<String>> tree = new ArrayList<>();

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
//        String parent = tree.get(tree.size() - 1).parent.elementName;
//        for (int i = tree.size() - 1; i > 0; i--) {
//            if (tree.get(i).parent.elementName.equals(parent)) {
//                tree.get(i).availableToAddLeftChildren = true;
//                tree.get(i).availableToAddRightChildren = true;
//            }
//        }
//        return add(s);
    }

    public String getParent(String s) {
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(s)) {
                return entry.parent.elementName;
            }
        }
        return null;
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        String stringName = (String) o;
        Entry<String> entry = null;
        for (Entry<String> e : tree) {
            if (e.elementName.equals(stringName)) {
                entry = e;
                break;
            }
        }
        if (entry == null) throw new UnsupportedOperationException();

        if (entry.rightChild != null) {
            remove(entry.rightChild.elementName);
        }
        if (entry.leftChild != null) {
            remove(entry.leftChild.elementName);
        }
        if (!entry.parent.isAvailableToAddChildren()) {
            if (entry.parent.rightChild.equals(entry)) {
                entry.parent.availableToAddRightChildren = true;
            }
            if (entry.parent.leftChild.equals(entry)) {
                entry.parent.availableToAddLeftChildren = true;
            }
        }
        tree.remove(entry);
        return true;
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
