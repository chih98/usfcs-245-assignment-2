/**
 * Hash Node Object for Hash Table
 * @author Marko Crnkovic
 */

public class Hashnode {
 
  public String key;
  public String value;
  public Hashnode next;
   
  public Hashnode(String k, String v, Hashnode, n) {
    this.key = k;
    this.value = v;
    this.next = n;
  }

  public Hashnode(String k, String v) {
    this.key = k;
    this.value = v;
    this.next = null;
  }

  public Hashnode(){
    this.key = null;
    this.value = null;
    this.next = null;
  }
    
}