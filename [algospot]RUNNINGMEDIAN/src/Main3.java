
public class Main3 {
	public static void main(String args[]){
		BST tree = new BST(1);
		System.out.println(tree.size);
		tree.insert(3);
		System.out.println(tree.size);
		tree.insert(5);
		System.out.println(tree.size);
		tree.insert(7);
		System.out.println(tree.size);
		tree.insert(9);
		System.out.println(tree.size);
		tree.insert(2);
		System.out.println(tree.size);
		tree.insert(4);
		System.out.println(tree.size);
		tree.insert(8);
		System.out.println(tree.size);
		tree.insert(6);
		System.out.println(tree.size);
		tree.insert(-2);
		System.out.println(tree.size);
		tree.insert(-1);
		System.out.println(tree.size);
		
		for(int i=0; i<11; i++){
			System.out.print(tree.dataat(i+1));
			System.out.print(" ");
			System.out.println(tree.median());
		}
		System.out.println(tree.size);
	}
}
