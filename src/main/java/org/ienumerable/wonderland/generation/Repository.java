package org.ienumerable.wonderland.generation;

import java.util.HashMap;

public class Repository {

    private final static HashMap<Class<?>, Repository> repositories = new HashMap<>();

    private final HashMap<String, Object> entries = new HashMap<>();

    public static void addRepository(Class<?> type){
        repositories.put(type, new Repository());
    }

    public static void put(String namespace, String name, Object o){
        String key = "%s-%s".formatted(namespace, name);
        repositories.get(o.getClass()).entries.put(key, o);
    }

    public static Object get(String namespace, String name, Class<?> type){
        String key = "%s-%s".formatted(namespace, name);
        return repositories.get(type).entries.get(key);
    }

}
