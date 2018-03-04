package com.javarush.task.task37.task3701;

import java.util.*;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        int cursor;
        Iterator<T> itr = Solution.super.iterator();

        @Override
        public boolean hasNext() {
            if (size() > 0) return true;
            return false;
        }

        @Override
        public T next() {
            if (size() == 0) throw new NoSuchElementException();
            if (itr.hasNext()) {
                cursor++;
                return itr.next();
            }
            cursor = 0;
            itr = Solution.super.iterator();
            cursor++;
            return itr.next();
        }

        @Override
        public void remove() {
            itr.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> consumer) {
            itr.forEachRemaining(consumer);
        }
    }
}
