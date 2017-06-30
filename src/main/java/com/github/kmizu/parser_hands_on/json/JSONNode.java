package com.github.kmizu.parser_hands_on.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONNode {
    public static class Pair<A, B> {
        public final A _1;
        public final B _2;
        public Pair(A _1, B _2) {
            this._1 = _1;
            this._2 = _2;
        }

        @Override
        public int hashCode() {
            return _1.hashCode() + _2.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Pair<?, ?>)) {
                return false;
            } else {
                Pair<A, B> that = (Pair<A, B>)obj;
                return _1.equals(that._1) && _2.equals(that._2);
            }
        }

        @Override
        public String toString() {
            return "(" + _1 + ", " + _2 + ")";
        }
    }

    public static class JSONString extends JSONNode {
        public final String value;
        public JSONString(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof JSONString)) {
                return false;
            } else {
                JSONString that = (JSONString)obj;
                return value.equals(that.value);
            }
        }

        @Override
        public String toString() {
            return "\"" + value.toString() + "\"";
        }
    }
    public static class JSONBoolean extends JSONNode {
        public final boolean value;
        public JSONBoolean(boolean value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof JSONBoolean)) {
                return false;
            } else {
                JSONBoolean that = (JSONBoolean)obj;
                return value == that.value;
            }
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
    public static class JSONNumber extends JSONNode {
        public final double value;
        public JSONNumber(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof JSONNumber)) {
                return false;
            } else {
                JSONNumber that = (JSONNumber)obj;
                return value == that.value;
            }
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
    public static class JSONNull extends JSONNode {
        /**
         * nullの構文木のインスタンスは一つだけでいい（位置情報を持ちたい場合は別）
         */
        private static final JSONNull instance = new JSONNull();
        private JSONNull() {}
        public static JSONNull getInstance() {
            return instance;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "null";
        }
    }
    public static class JSONObject extends JSONNode {
        public final Map<String, JSONNode> properties;
        public JSONObject(Map<String, JSONNode> properties) {
            this.properties = properties;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof JSONObject)) {
                return false;
            } else {
                JSONObject that = (JSONObject)obj;
                return properties.equals(that.properties);
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{\n");
            if(properties.size() != 0) {
                for(Map.Entry<String, JSONNode> p : properties.entrySet()) {
                    builder.append(p.getKey());
                    builder.append(" : ");
                    builder.append(p.getValue());
                }
            }
            builder.append("}\n");
            return new String(builder);
        }
    }
    public static class JSONArray extends JSONNode {
        public final List<? extends JSONNode> elements;
        public JSONArray(List<JSONNode> elements) {
            this.elements = elements;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof JSONArray)) {
                return false;
            } else {
                JSONArray that = (JSONArray) obj;
                return elements.equals(that.elements);
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            if(elements.size() != 0) {
                builder.append(elements.get(0).toString());
                for(JSONNode e : elements.subList(1, elements.size())) {
                    builder.append(", ");
                    builder.append(e.toString());
                }
            }
            builder.append("]");
            return new String(builder);
        }
    }

    public static JSONObject jobject(Pair<String, JSONNode>... pairs) {
        Map<String, JSONNode> properties = new HashMap<>();
        for(Pair<String, JSONNode> p:pairs) {
            properties.put(p._1, p._2);
        }
        return new JSONObject(properties);
    }

    public static JSONArray jarray(JSONNode... elements) {
        List<JSONNode> es = new ArrayList<>();
        for(JSONNode e:elements) {
            es.add(e);
        }
        return new JSONArray(es);
    }

    public static JSONNull jnull() {
        return JSONNull.getInstance();
    }

    public static JSONNumber jnumber(double value) {
        return new JSONNumber(value);
    }

    public static JSONBoolean jboolean(boolean value) {
        return new JSONBoolean(value);
    }

    public static JSONString jstring(String value) {
        return new JSONString(value);
    }

    public static Pair<String, JSONNode> property(String key, JSONNode value) {
        return new Pair<>(key ,value);
    }

    public static Pair<String, JSONNode> p(String key, JSONNode value) {
        return property(key, value);
    }
}

