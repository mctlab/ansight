package com.github.mctlab.ansight.common.json;

import com.github.mctlab.ansight.common.exception.JsonException;
import com.github.mctlab.ansight.common.util.L;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class JsonMapper {

    public static <T extends IJsonable> T parseJsonObject(JSONObject json, Class<T> clazz) throws JsonException {
        return parseJsonObject(json.toString(), clazz);
    }

    public static <T extends IJsonable> T parseJsonObject(String json, Class<T> clazz) throws JsonException {
        try {
            return getDeserializer().fromJson(json, clazz);
        } catch (Throwable e) {
            throw new JsonException("json=" + json, e);
        }
    }

    public static <T extends IJsonable> T parseJsonObject(JsonElement json, Class<T> clazz) throws JsonException {
        try {
            return getDeserializer().fromJson(json, clazz);
        } catch (Throwable e) {
            throw new JsonException("json=" + json, e);
        }
    }

    public static <T extends IJsonable> String toJson(T obj) {
        return getSerializer().toJson(obj);
    }

    public static <T> String arrayToJson(T[] array) {
        return getSerializer().toJson(array);
    }

    public static <T> T jsonToArray(String json, Class<T> arrayClazz) {
        try {
            return getDeserializer().fromJson(json, arrayClazz);
        } catch (Exception e) {
            L.e(JsonMapper.class, e);
            return null;
        }
    }

    public static <T> String listToJson(List<T> list) {
        return getSerializer().toJson(list);
    }

    public static <T> List<T> jsonToList(String json, TypeToken<List<T>> type) {
        try {
            return getDeserializer().fromJson(json, type.getType());
        } catch (Exception e) {
            L.e(JsonMapper.class, e);
            return null;
        }
    }

    public static <K, V> String mapToJson(Map<K, V> map) {
        return getSerializer().toJson(map);
    }

    public static <K, V> Map<K, V> jsonToMap(String json, TypeToken<Map<K, V>> type) {
        return getDeserializer().fromJson(json, type.getType());
    }

    /**
     * Sometimes we need a generalized interface for processing json, and this is the very one that
     * can convert every object to json.
     *
     * @param o object need to be serialized
     * @return json string
     * @see Gson
     */
    public static String writeValue(Object o) {
        return getSerializer().toJson(o);
    }

    /**
     * Sometimes we need a generalized interface for processing json, and this is the very one that
     * can parse json back to object with specified type.
     *
     * @param json  json string
     * @param clazz object type
     * @return parsed data
     * @see Gson
     */
    public static <T> T readValue(String json, Class<T> clazz) {
        return getDeserializer().fromJson(json, clazz);
    }

    private static final GsonBuilder DESERIALIZER_BUILDER = new GsonBuilder();
    private static Gson deserializer;

    public static Gson getDeserializer() {
        if (deserializer != null) {
            return deserializer;
        }
        synchronized (JsonMapper.class) {
            if (deserializer == null) {
                deserializer = DESERIALIZER_BUILDER.create();
            }
        }
        return deserializer;
    }

    public static <T> void registerDeserializer(Class<T> clazz, JsonDeserializer<T> d) {
        synchronized (JsonMapper.class) {
            DESERIALIZER_BUILDER.registerTypeAdapter(clazz, d);
            deserializer = DESERIALIZER_BUILDER.create();
        }
    }

    private static final GsonBuilder SERIALIZER_BUILDER = new GsonBuilder();
    private static Gson serializer;

    public static Gson getSerializer() {
        if (serializer != null) {
            return serializer;
        }
        synchronized (JsonMapper.class) {
            if (serializer == null) {
                serializer = SERIALIZER_BUILDER.create();
            }
        }
        return serializer;
    }

}
