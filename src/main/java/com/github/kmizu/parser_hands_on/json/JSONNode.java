package com.github.kmizu.parser_hands_on.json;

import java.util.List;
import java.util.Map;

public class JSONNode {
    public static class JSONString extends JSONNode {
        public final String value;
        public JSONString(String value) {
            this.value = value;
        }
    }
    public static class JSONBoolean extends JSONNode {
        public final boolean value;
        public JSONBoolean(boolean value) {
            this.value = value;
        }
    }
    public static class JSONNumber extends JSONNode {
        public final Double value;
        public JSONNumber(Double value) {
            this.value = value;
        }
    }
    public static class JSONNull extends JSONNode {
        /**
         * nullの構文木のインスタンスは一つだけでいい（位置情報を持ちたい場合は別）
         */
        private static final JSONNull instance = new JSONNull();
        private JSONNull() {}
        public JSONNull getInstance() {
            return instance;
        }
    }
    public static class JSONObject extends JSONNode {
        public final Map<String, JSONNode> properties;
        public JSONObject(Map<String, JSONNode> properties) {
            this.properties = properties;
        }
    }
    public static class JSONArray extends JSONNode {
        public final List<? extends JSONNode> elements;
        public JSONArray(List<JSONNode> elements) {
            this.elements = elements;
        }
    }
}
