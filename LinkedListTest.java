
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleLinkedList list = new SimpleLinkedList();
		
		// 맨 앞에 추가하는 메소드
		list.addFirstNode("진민호");
		list.printNode();
		list.addFirstNode("김대우");
		list.printNode();
		list.addFirstNode("박진원");
		list.printNode();
		
		System.out.println(list.getNode("진민호"));
		System.out.println(list.getNode("김대우"));
	}

}
