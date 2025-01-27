/**
 * A generic singly-linked list implementation.
 *
 * @param <T> the type of elements stored in this linked list
 */
public class LinkedList<T>{
  private Node<T> head;

  public boolean add(T element) {
    if (head == null) {
      head = new Node<>(element);
    } else {
      Node<T> tail = head;
      while (tail.next != null) {
        tail = tail.next;
      }
      tail.next = new Node<>(element);
    }
    return true;
  }

  public boolean add(int index, T element) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    if (index == 0) {
      head = new Node<>(element, head);
      return true;
    }
    Node<T> temp = head;
    int count = 0;
    while (temp != null && count < index - 1) {
      temp = temp.next;
      count++;
    }
    if (temp != null) {
      temp.next = new Node<>(element, temp.next);
      return true;
    }
    return false;
  }

  public T get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    Node<T> temp = head;
    int count = 0;
    while (temp != null) {
      if (count == index) {
        return temp.data;
      }
      temp = temp.next;
      count++;
    }
    return null; // This line won't be reached due to bounds check at start.
  }

  public T remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    if (index == 0) {
      T data = head.data;
      head = head.next;
      return data;
    }
    Node<T> temp = head;
    int count = 0;
    while (temp != null && count < index - 1) {
      temp = temp.next;
      count++;
    }
    if (temp != null && temp.next != null) {
      T data = temp.next.data;
      temp.next = temp.next.next;
      return data;
    }
    return null;
  }

  public int size() {
    int count = 0;
    Node<T> temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  public int indexOf(T element) {
    int index = 0;
    Node<T> current = head;
    while (current != null) {
      if ((element == null && current.data == null) || (element != null && element.equals(current.data))) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }


  public String toString() {
    String toRet = "[";
    Node<T> temp = head;
    while (temp != null) {
      toRet += temp.data;
      if (temp.next != null) {
        toRet += ", ";
      }
      temp = temp.next;
    }
    toRet += "]";
    return toRet;
  }
}
