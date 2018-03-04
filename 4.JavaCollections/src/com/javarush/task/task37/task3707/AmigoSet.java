package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>((int) Math.max(Math.ceil(collection.size()/0.75f), 16));
        this.addAll(collection);
    }

    public boolean add(E e) {
        int s = map.size();
        map.put(e, PRESENT);
        return map.size() != s;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Spliterator<E> spliterator() {
        return map.keySet().spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return map.keySet().removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return map.keySet().stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return map.keySet().parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        map.keySet().forEach(action);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() throws InternalError {
        try {
            HashMap<E,Object> map2 = (HashMap<E, Object>) map.clone();
            AmigoSet<E> as = new AmigoSet<>(map2.keySet());
            return as;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        float loadfactory = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        oos.writeFloat(loadfactory);
        oos.writeInt(capacity);
        oos.writeInt(map.size());
        for (E e : map.keySet()) {
            oos.writeObject(e);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        float loadfactor = ois.readFloat();
        int capacity = ois.readInt();
        int size = ois.readInt();
        map = new HashMap<>(capacity, loadfactor);
        for (int i = 0; i < size; i++) {
            map.put((E) ois.readObject(), PRESENT);
        }
    }
}
