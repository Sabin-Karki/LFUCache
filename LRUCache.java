import java.util.HashMap;

public class LRUCache<K,V>{
    private int capacity; // how many cache 
    private final HashMap<K,Node<K,V>> map;
    private final Node<K,V> head ;
    private final Node<K,V> tail ; 

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node<>(null,null);
        this.tail=new Node<>(null,null);
        head.next=tail;
        tail.prev=head;
    }
// the constructor when intializing lrucahce,it creates an empty hashmap and two dummy node head and tail 
    private void moveToHead(Node<K,V> node){
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node<K,V> node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(Node<K,V> node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public V get(K key){
        Node<K,V> node = map.get(key);
        if(node==null) return null;
        moveToHead(node);
        return node.value;
    }

    public void put(K key,V value){
        Node<K,V> node = map.get(key);
        if(node!=null){
            node.value=value;
            moveToHead(node);
        }else{
            if(map.size()>=capacity){
                Node<K,V> lru = tail.prev;
                map.remove(lru.key);
                removeNode(lru);
            }
            Node<K,V> newNode = new Node<>(key,value);
            map.put(key,newNode);
            addNode(newNode);
        }
    }
}