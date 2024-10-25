package basicJava;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dictionary implements Map<String, String> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String get(Object key) {
        return "";
    }

    @Override
    public String put(String key, String value) {
        return "";
    }

    @Override
    public String remove(Object key) {
        return "";
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return Set.of();
    }

    @Override
    public Collection<String> values() {
        return List.of();
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return Set.of();
    }
}
