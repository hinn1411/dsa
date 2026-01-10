package linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {
  private static class Node {
    Node prev, next;
    int key, val;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> map;
  private final Node head;
  private final Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }


  public int get(int key) {
    Node node = map.get(key);
    if (Objects.isNull(node)) {
      return -1;
    }

    moveToFront(node);
    return node.val;
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (Objects.nonNull(node)) {
      node.val = value;
      moveToFront(node);
      return;
    }

    Node newNode = new Node(key, value);
    map.put(key, newNode);
    addFirst(newNode);
    if (map.size() > capacity) {
      map.remove(tail.prev.key);
      remove(tail.prev);
    }
  }

  private void moveToFront(Node curNode) {
    remove(curNode);
    addFirst(curNode);
  }

  private void addFirst(Node newNode) {
    Node nextNode = head.next;
    newNode.prev = head;
    newNode.next = nextNode;
    head.next = newNode;
    nextNode.prev = newNode;
  }

  private void remove(Node curNode) {
    Node prevNode = curNode.prev;
    Node nextNode = curNode.next;

    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    curNode.next = null;
    curNode.prev = null;
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4

  }
}
