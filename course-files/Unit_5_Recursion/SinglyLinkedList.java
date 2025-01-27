public class SinglyLinkedList<T> {
  private Node<T> head;
  private Node<T> tail;

  public void add(T element){

    Node<T> nd = new Node<T>();
    nd.setValue(element);
    System.out.println("Adding: "+element);
    /**
     * check if the list is empty
     */
     if(head == null){
       //since there is only one element, both head and
       //tail points to the same object.
       head = nd;
       tail = nd;
     }
    else {
      //set current tail next link to new node
      tail.setNext(nd);
      //set tail as newly created node
      tail = nd;
    }
  }

  public void addAfter(T element, T after){

    Node<T> tmp = head;
    Node<T> refNode = null;
    System.out.println("Traversing to all nodes..");
    /**
     * Traverse till given element
     */
    while(true){
      if(tmp == null){
        break;
      }
      if(tmp.compareTo(after) == 0){
        //found the target node, add after this node
        refNode = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    if(refNode != null){
      //add element after the target node
      Node<T> nd = new Node<T>();
      nd.setValue(element);
      nd.setNext(tmp.getNext());
      if(tmp == tail){
        tail = nd;
      }
      tmp.setNext(nd);
    }
    else {
      System.out.println("Unable to find the given element...");
    }
  }

  public void deleteFront(){

    if(head == null){
      System.out.println("Underflow...");
    }
    Node<T> tmp = head;
    head = tmp.getNext();
    if(head == null){
      tail = null;
    }
    System.out.println("Deleted: "+tmp.getValue());
  }

  public void deleteAfter(T after){

    Node<T> tmp = head;
    Node<T> refNode = null;
    System.out.println("Traversing to all nodes..");
    /**
    * Traverse till given element
    */
    while(true){
      if(tmp == null){
        break;
      }
      if(tmp.compareTo(after) == 0){
        //found the target node, add after this node
        refNode = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    if(refNode != null){
      tmp = refNode.getNext();
      refNode.setNext(tmp.getNext());
      if(refNode.getNext() == null){
        tail = refNode;
      }
      System.out.println("Deleted: "+tmp.getValue());
    }
    else{
      System.out.println("Unable to find the given element...");
    }
  }

  public void traverse(){

    Node<T> tmp = head;
    while(true){
      if(tmp == null){
        break;
      }
      System.out.println(tmp.getValue());
      tmp = tmp.getNext();
    }
  }

  public String toString(){
    this.traverse();
    return "";
  }

  public static void main(String a[]){
    SinglyLinkedList<Job> sl = new SinglyLinkedList<Job>();
    sl.add(new Job(1, 100, 0));
    sl.add(new Job(2, 100, 40));
    sl.add(new Job(3, 300, 200));
    sl.add(new Job(4, 100, 80));
    // sl.addAfter(76, 54);
    sl.deleteFront();
    // sl.deleteAfter(76);
    System.out.println(sl);
  }
}

class Node<T> implements Comparable<T> {
  private T value;
  private Node<T> next;

  public T getValue() {
    return value;
  }
  public void setValue(T value) {
    this.value = value;
  }
  public Node<T> getNext() {
    return next;
  }
  public void setNext(Node<T> ref) {
    this.next = ref;
  }
  @Override
  public int compareTo(T arg) {
    if(arg == this.value){
      return 0;
    }
    else {
      return 1;
    }
  }
}
