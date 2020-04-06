package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create a timebased key-value store class TimeMap, that supports two operations.
 *
 * 1. set(string key, string value, int timestamp)
 *
 * Stores the key and value, along with the given timestamp. 2. get(string key, int timestamp)
 *
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp. If
 * there are multiple such values, it returns the one with the largest timestamp_prev. If there are no values, it
 * returns the empty string ("").
 */
public class TimeBasedKeyValueStore {

    Map<String, List<Node>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {

    }

    public void set(String key, String value, int timestamp) {
        List<Node> node = map.get(key);
        if (node == null) {
            List<Node> list = new ArrayList<>();
            list.add(new Node(key, value, timestamp));
            map.put(key, list);
        } else {
            int index = getFirstBiggerOrEqual(timestamp, node);
            node.add(index, new Node(key, value, timestamp));
        }

    }

    /**
     * 查找第一个大于或者等于目标值的数
     * @param timestamp
     * @param nodes
     * @return
     */
    int getFirstBiggerOrEqual(int timestamp, List<Node> nodes) {
        int left = 0, right = nodes.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (nodes.get(mid).timestamp < timestamp)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    /**
     * 查找最后一个小于等于目标值的数（最新值）
     *
     * @param timestamp
     * @param nodes
     * @return
     */
    int getLastLessOrEqual(int timestamp, List<Node> nodes) {
        int left = 0, right = nodes.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (nodes.get(mid).timestamp <= timestamp)
                left = mid + 1;
            else
                right = mid;
        }
        return right - 1;
    }

    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null)
            return "";
        int res = getLastLessOrEqual(timestamp, nodes);
        if (res < 0)
            return "";
        return nodes.get(res).value;
    }

    class Node {

        String key;

        String value;

        int timestamp;

        public Node(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
