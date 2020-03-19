
public class BinaryTreeTest {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(10);
		
		for (int i = 0; i < 10; i++) {
			tree.add((char)('A'+i));
		}
		
		tree.searchInOrder();
		System.out.println("In");
		tree.searchPostOrder();
		System.out.println("Post");
		tree.searchPreOrder();		
		System.out.println("Pre");
		tree.searchBFS();
		System.out.println("BFS");
		
		System.out.println("넓이 별 BFS");
		tree.searchBFS2();

	}

}
