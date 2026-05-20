package Part12.TypeParameter.HashMap;
import java.util.*;
 class Pair<K,V>{
   private K key;
   private V value;
   public Pair(K key,V value){
      this.key=key;
      this.value=value;
   }
   public K getKey() {
      return key;
   }

   public V getValue() {
      return value;
   }

   public void setValue(V value) {
      this.value = value;
   }
}
public class MyHashMap<K,V> {
   private List<Pair<K,V>>[] buckets;
   private int capacity;
   public MyHashMap(){
      this.capacity=16;
      //this.bucket=new List<Pair<K,V>>[capacity]; gives generic error
      this.buckets=(List<Pair<K,V>>[]) new List[capacity];
      for (int i = 0; i < capacity; i++) {
         buckets[i] = new ArrayList<>(); //filling the empty array
      }
   }
   private int hash(K key){
      int index = Math.abs(key.hashCode()) % capacity;
      return index;
   }
   public void put(K key, V value){
      int index = hash(key);
      Pair<K,V>newPair = new Pair<K,V>(key,value);
      for(Pair<K,V>i:buckets[index]){
         if(i.getKey().equals(key)) {
            i.setValue(value);
            return;
         }
      }
      buckets[index].add(newPair);
   }
   public V get(K key){
      V value=null;
      int index = hash(key);
      for(Pair<K,V>i:buckets[index]){
         if(i.getKey().equals(key)) {
            value = i.getValue();
            return value;
         }
      }
      return null;
   }
   public void remove(K key) {
      int index = hash(key);
      for (Pair<K,V> i : buckets[index]) {
         if (i.getKey().equals(key)) {
            buckets[index].remove(i);
            return;
         }
      }
   }
   public List<K> getKeys() {
      List<K> keys=new ArrayList<>();
      for (List<Pair<K,V>> i : buckets) {
         for(Pair<K,V>j:i){
               keys.add(j.getKey());
         }
      }
      return keys;
   }
   public List<V> getValues() {
      List<V> values=new ArrayList<>();
      for (List<Pair<K,V>> i : buckets) {
         for(Pair<K,V>j:i){
            values.add(j.getValue());
         }
      }
      return values;
   }

   public static void main(String[] args) {
      MyHashMap<String, Integer> map = new MyHashMap<>();
      map.put("age", 25);
      map.put("year", 2024);
      map.put("age", 30);  // should update, not duplicate

      System.out.println(map.get("age"));   // 30
      System.out.println(map.get("year"));  // 2024
      System.out.println(map.getKeys());    // [age, year]
      map.remove("age");
      System.out.println(map.getKeys());    // [year]
   }
}
