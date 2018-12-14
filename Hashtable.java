/**
 * Hashtable 
 * @author Marko Crnkovic
 */
  public class Hashtable {

    private int DEFAULT_SIZE = 250000;
    private Hashnode[] buckets;
    private int size;

    public Hashtable() {
       buckets = new Hashnode[DEFAULT_SIZE];
       size = 0;
    }

    public Hashtable(int size) {
       buckets = new Hashnode[size];
    }


   public boolean containsKey(String key) {
        
      int bucket = getBucket(key); 
      Hashnode nl = buckets[bucket]; 
      while (nl != null) {

       if (nl.key.equals(key)){
          return true;
       }
         nl = nl.next;
      } 
      return false;
  }
  
    public void put(String key, String value) {
       int bucket = getBucket(key);
       Hashnode nl = buckets[bucket]; // list of nodes

       while (nl != null) {
        if (nl.key.equals(key)){
            break; // found key
        }
          nl = nl.next;
       }
       if (nl != null) {
          nl.value = value;
       }
       else {
          if (size >= buckets.length) {
             growArray();
          }
          Hashnode newNode = new Hashnode();
          newNode.key = key;
          newNode.value = value;
          newNode.next = buckets[bucket];
          buckets[bucket] = newNode;
          size++; 
       }
    }

    public String get(String key) {
        
       int bucket = getBucket(key);  
       Hashnode nl = buckets[bucket]; 
       while (nl != null) {
             
          if (nl.key.equals(key))
             return nl.value;
          nl = nl.next; 
       }
       
       return null;  
    }

    public String remove(String key) {  
        String removingNode = get(key);   
        int bucket = getBucket(key); 
        if (buckets[bucket] == null) {
            
            return removingNode;
        }

        if (buckets[bucket].key.equals(key)) {
            
            buckets[bucket] = buckets[bucket].next;
            size--; 
            return removingNode;
        }

        Hashnode pNode = buckets[bucket]; 

        Hashnode currentNode = pNode.next; 

        while (currentNode != null && ! currentNode.key.equals(key)) {
            currentNode = currentNode.next;
            pNode = currentNode;
        }

        if (currentNode != null) {
            pNode.next = currentNode.next;
            size--; 
        }
        return removingNode;
    }

    public void growArray() {
         
       Hashnode[] newBuckets = new Hashnode[buckets.length * 2];

       for (int i = 0; i < buckets.length; i++) {
          Hashnode nodeList = buckets[i]; 
          while (nodeList != null) { // iteratet through nodeList

            Hashnode next = nodeList.next;  
            int hashCode = nodeList.key.hashCode();
            int hash = Math.abs((hashCode % buckets.length));
            nodeList.next = newBuckets[hash];
            newBuckets[hash] = nodeList;
            nodeList = next;  
            
          }
       }
       buckets = newBuckets; 
    } 

    private int getBucket(String key) {
      int hashCode = key.hashCode();
      return Math.abs((hashCode % buckets.length));
    }


    public int size() {
        return size;
    }

 }


