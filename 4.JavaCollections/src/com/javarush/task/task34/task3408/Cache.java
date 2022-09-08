package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
       if (!cache.containsKey(key)) {
           Constructor<V> constructor = clazz.getConstructor(key.getClass());
           V v = constructor.newInstance(key);
           cache.put(key, v);
       }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method[] methods = obj.getClass().getDeclaredMethods();
        Method getMethod = null;
        for (Method method : methods) {
            if (method.getName().equals("getKey")) {
                getMethod = method;
                getMethod.setAccessible(true);
                try {
                    K key = (K) getMethod.invoke(obj);
                    cache.put(key, obj);
                    return true;
                }
                catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}
