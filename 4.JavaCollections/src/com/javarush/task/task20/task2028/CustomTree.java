package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 130; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    Entry<String> root = new Entry<>("0");
    {
        root.lineNumber = 0;
    }

    private boolean add2(Entry<String> entry, int line, String s) {
        if (entry.lineNumber != line) {
            boolean f = false;
            if (entry.leftChild != null)
                f = add2(entry.leftChild, line, s);
            if (!f && entry.rightChild != null)
                return add2(entry.rightChild, line, s);
            return f;
        }
        if (entry.isAvailableToAddChildren()) {
            if (entry.availableToAddLeftChildren) {
                entry.leftChild = new Entry<String>(s);
                entry.leftChild.parent = entry;
                entry.checkChildren();
                entry.leftChild.lineNumber = entry.lineNumber + 1;
                return true;
            }
            if (entry.availableToAddRightChildren) {
                entry.rightChild = new Entry<String>(s);
                entry.rightChild.parent = entry;
                entry.checkChildren();
                entry.rightChild.lineNumber = entry.lineNumber + 1;
                return true;
            }
        }
        return false;
    }

    public int maxLine(Entry<String> entry) {
        int line = entry.lineNumber;
        int l = 0;
        if (entry.leftChild != null) l = maxLine(entry.leftChild);
        line = line < l ? l : line;
        if (entry.rightChild != null) l = maxLine(entry.rightChild);
        line = line < l ? l : line;
        return line;
    }

    @Override
    public boolean add(String s) {
        int line = maxLine(root);

        if (line > 0)
            if (!add2(root, line - 1, s))
                return add2(root, line, s);
            else return true;
        else return add2(root, line, s);
    }

    public boolean remove2(Entry<String> entry, Object o) {
        if (entry.elementName.equals(o)) {
            if (entry.parent.leftChild != null && entry.parent.leftChild.equals(entry))
                entry.parent.leftChild = null;
            else entry.parent.rightChild = null;
            return true;
        }
        else {
            boolean f = false;
            if (entry.leftChild != null)
                f = remove2(entry.leftChild, o);
            if (!f && entry.rightChild != null)
                return remove2(entry.rightChild, o);
            return f;
        }
    }

    @Override
    public boolean remove(Object o) {
        return remove2(root, o);
    }

    public Entry<String> getParent2(Entry<String> entry, String s) {
        if (entry.elementName.equals(s)) {
            return entry.parent;
        }
        else {
            Entry<String> f = null;
            if (entry.leftChild != null)
                f = getParent2(entry.leftChild, s);
            if (f == null && entry.rightChild != null)
                return getParent2(entry.rightChild, s);
            return f;
        }
    }

    public String getParent(String s) {
        Entry<String> res = getParent2(root, s);
        if (res != null) return res.elementName;
        return null;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
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
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public int size2(Entry<String> entry) {
        int s = 1;
        if (entry.leftChild != null) s += size2(entry.leftChild);
        if (entry.rightChild != null) s += size2(entry.rightChild);
        return s;
    }

    @Override
    public int size() {
        return size2(root) - 1;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
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

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
