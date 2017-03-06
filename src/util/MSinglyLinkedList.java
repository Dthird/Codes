package util;


public class MSinglyLinkedList<T>{
	public SLLNode<T> head, tail;
	public MSinglyLinkedList(){
		this(null);
	}
	
	MSinglyLinkedList(SLLNode<T> n){
		head = n;
		tail = n;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void addToHead(T x){
		SLLNode<T> t = new SLLNode(x, head);
		head = t;
		if (tail == null){
			tail = head;
		}
	}
	
	public void addToTail(T x){
		SLLNode<T> t = new SLLNode(x);
		if (!isEmpty()){
			tail.next = t;
			tail = tail.next;
		} else {
			head = tail = t;
		}
	}
	
	public T deleteFromHead(){
		T e = head.info;
		if (head == tail){
			head = tail = null;
		} else{
			head = head.next;
		}
		return e;
	}
	
	public T deleteFromTail(){
		T e = tail.info;
		if (head == tail){
			head = tail = null;
		} else{
			SLLNode<T> tmp;
			for (tmp = head; tmp.next != tail ; tmp = tmp.next){
				;
			}
			tail = tmp;
			tail.next = null;
		}
		return e;
	}
	
	public void delete(T x){
		if (isExist(x) == false){
			return;
		}
		if (!isEmpty()){
			if (head == tail){
				head = tail = null;
			} else if(head.info == x){
				head = head.next;
			} else{
				SLLNode<T> tmp1;
				for(tmp1 = head; tmp1.info != x; tmp1 = tmp1.next){
					;
				}
				SLLNode<T> tmp2;
				for(tmp2 = head; tmp2.next != tmp1; tmp2 = tmp2.next){
					;
				}
				
				tmp2.next = tmp1.next;
				if (tmp1 == tail){
					tail = tmp2;
				}				
			}
		}
	}
	
	public boolean isExist(T x){
		SLLNode<T> tmp;
		for (tmp = head; tmp != null; tmp = tmp.next){
			if (tmp.info == x){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder("Singly Linked List: ");
		for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next){
			sBuilder.append(tmp.info + " -> ");
		}
		sBuilder.append("null");
		return sBuilder.toString();
	}
	
	public static void main(String[] args){
		MSinglyLinkedList<Integer> sList = new MSinglyLinkedList<>();
		sList.addToHead(1);
		sList.addToHead(2);
		sList.addToTail(3);
		System.out.println(sList);
		sList.delete(1);
		System.out.println(sList);
		sList.deleteFromHead();
		System.out.println(sList);
		System.out.println(sList.isExist(3));
		sList.deleteFromTail();
		System.out.println(sList);
	}
	
}

class SLLNode<T>{
	public T info;
	public SLLNode<T> next;
	
	public SLLNode(T x){
		this(x, null);
	}
	
	public SLLNode(T x, SLLNode<T> next){
		this.info = x;
		this.next = next;
	}
}
