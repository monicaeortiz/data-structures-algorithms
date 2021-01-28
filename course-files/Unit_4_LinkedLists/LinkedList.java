class LinkedList{
  private ListNode list;

  void append(int value){
    ListNode toAdd = new ListNode();
    toAdd.data = value;
    toAdd.next = null;

    this.tail().next = toadd;
  }

  void prepend(int value){
    ListNode toAdd = new ListNode();
    toAdd.data = value;
    toAdd.next = this.head();

    this.list = toAdd;
  }

  int size(){
    int count = 0;
    ListNode temp = list;

    while(temp.next != null){
      count++;
      temp = temp.next;
    }
    return count;
  }

  ListNode head(){
    return list;
  }

  ListNode tail(){
    ListNode tail = list;
    for(int i=0; i < size(); i++){
      tail = tail.next;
    }
    return tail;
  }

  ListNode at(int index){
    ListNode temp = list;
    for(int i=0; i < index; i++){
      temp = temp.next;
    }
    return temp;
  }

  ListNode pop(){
    ListNode toRet = this.at(this.size()-1);
    toRet = new ListNode(toRet.data);
    this.removeAt(this.size()-1);
    return toRet;

  }

  boolean contains(int value){}

  int find(int value){}

  String toString(){
    String toRet = "";

  }

  boolean insertAt(int value, int index){
    ListNode temp = list;
    for(int i=0; i<index; i++){
      temp = temp.next;
      if (temp == null) {
        return false;
      }
    }
    //temp = what should be shifted over
    ListNode t = new ListNode(temp.data, temp.next);
    temp.data = data;
    temp.next = t;
    return true;

  }

  boolean removeAt(int index){
    if (index == 0) {
      list = list.next;
      return true;
    }
    ListNode temp = list;
    for(int i=0; i<index-1; i++){
      temp = temp.next;
      if (temp == null) {
        return false;
      }
    } //temp = one before what should be deleted

    if (index == size()-1){
      temp.next = null;
    } else if (temp.next != null) {
      temp.next = temp.next.next;
    }
    return true;
  }


  public static void main(Strng[] args){
    LinkedList list = new LinkedList();
    list.append(3);
    list.append(5);
    list.append(7);
    list.prepend(1);
    list.removeAt(1);

  }
}
