# MyHashMap

A generic HashMap implemented from scratch in Java.

## Features
- Generic key-value storage `<K, V>`
- Hash-based O(1) average lookup
- Collision handling via chaining
- put, get, remove, getKeys, getValues

## Implementation
- Backing structure: array of ArrayLists
- Hash function: Java's built-in hashCode() % capacity
- Initial capacity: 16 buckets

## Usage
MyHashMap<String, Integer> map = new MyHashMap<>();
map.put("age", 25);
map.get("age");     // 25
map.remove("age");
map.getKeys();      // [...]
