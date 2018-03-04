package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V obj = cache.get(key);
        if (obj == null) {
            for (Constructor constructor : clazz.getConstructors()) {
                try {
                    if (put((V) constructor.newInstance(key)))
                        break;
                } catch (Exception ignored) {}
            }
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        for (Method method : obj.getClass().getDeclaredMethods()) {
            try {
                if (!method.getName().equals("getKey")) continue;
                method.setAccessible(true);
                K key = (K) method.invoke(obj, method.getParameterTypes());
                cache.put(key, obj);
                return true;
            } catch (IllegalAccessException | InvocationTargetException ignored) {
            }
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
