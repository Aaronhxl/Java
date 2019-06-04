package com.hellobike.domain;

import java.util.Objects;

/**
 * json数据的节点
 */
public class Node {
    private String key;
    private String value;

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(key, node.key) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
