package com.okravtsiv.authservice.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMapper {
    public static String collectionToString(Collection<String> collection) {
        return Arrays.toString(collection.toArray());
    }

    public static List<String> stringToList(String stringCollection) {
        String array = stringCollection.replace("[", "").replace("]", "");
        if(array.isEmpty()) {
            return new ArrayList<>();
        }
        return Stream.of(array.split(",")).map(String::trim).collect(Collectors.toList());
    }

    public static Set<String> stringToSet(String stringCollection) {
        String array = stringCollection.replace("[", "").replace("]", "");
        if(array.isEmpty()) {
            return new HashSet<>();
        }
        return Stream.of(array.split(",")).map(String::trim).collect(Collectors.toSet());
    }
}
