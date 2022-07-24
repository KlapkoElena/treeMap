package treeMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class TreeMap<K, V> implements Map<K, V> {
    public Tree<K, V> tree;
    public int sizeMap;
    private Object key;
    public Set<K> setKey = null;

    @Override
    public V put(K key, V value) {
        Tree<K, V> entry = tree, parent = null, newNode;
        int result = 0;
        if (entry != null) {
            do {
                parent = entry;
                result = ((Comparable<K>) entry.getKey()).compareTo(key);
                if (0 == result) {
                    entry.setValue(value);
                    return value;
                } else if (result > 0) {
                    entry = entry.getLeft();
                } else {
                    entry = entry.getRight();
                }
            } while (entry != null);
            newNode = new Tree<K, V>(key, value, parent);
        } else {
            newNode = new Tree<K, V>(key, value, parent);
        }

        if (parent == null) {
            tree = newNode;
        } else if (result > 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        sizeMap++;
        return value;
    }

    @Override
    public int size() {
        return sizeMap;
    }

    @Override
    public boolean containsKey(Object key) {
        if (getEntry((K) key) != null) return true;
        else return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean isEmpty() {
        return sizeMap != 0;
    }

    private Tree<K, V> getEntry(K key) {
        Tree<K, V> entry = tree;
        int result = 0;
        do {
            result = ((Comparable<K>) entry.getKey()).compareTo(key);
            if (result == 0) {
                return entry;
            } else if (result > 0) {
                entry = entry.getLeft();
            } else {
                entry = entry.getRight();
            }
        } while (entry != null);
        return null;
    }

    @Override
    public V remove(Object key) {
        this.key = key;
        Tree<K, V> entry = getEntry((K) key);
        return remove(entry);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        Set<Entry<K, V>> o = null;
        return o;
    }

    @Override
    public V get(Object key) {
        Tree<K, V> entry = getEntry((K) key);
        return entry != null ? entry.getValue() : null;
    }

    @Override
    public Set<K> keySet() {
        if (setKey == null) {
            setKey = new Set<K>() {

                @Override
                public void clear() {
                }

                @Override
                public boolean contains(Object o) {

                    return TreeMap.this.containsKey(o);
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    for (Object o : c) {
                        K key = (K) o;
                        if (TreeMap.this.containsKey(key)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends K> c) {
                    return false;
                }

                @Override
                public boolean isEmpty() {
                    return TreeMap.this.size() != 0;
                }

                @Override
                public Iterator<K> iterator() {
                    return null;
                }


                @Override
                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public int size() {
                    return TreeMap.this.size();
                }

                @Override
                public Object[] toArray() {
                    return null;
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean add(K k) {
                    return false;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }
            };
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private static class Tree<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        private Tree<K, V> left;
        private Tree<K, V> right;

        public Tree(K key, V value, Tree<K, V> parent) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {

            return this.value = value;
        }

        public Tree<K, V> getLeft() {
            return left;
        }

        public void setLeft(Tree<K, V> left) {
            this.left = left;
        }

        public Tree<K, V> getRight() {
            return right;
        }

        public void setRight(Tree<K, V> right) {
            this.right = right;
        }
    }
}
