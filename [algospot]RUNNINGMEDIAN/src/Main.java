import java.util.Scanner;

class BST {
	private int data;
	public int size;
	private BST left;
	private BST right;
	private BST parent;

	BST(int data){
		this.data = data;
		this.size = 1;
	}

	public BST insert(int n){
		if(data<n){
			if(right == null){
				right = new BST(n);
				right.parent = this;

				BST rt = this;
				while(true){
					rt.size++;
					if(rt.parent != null){
						rt = rt.parent;
						continue;
					}
					return rt;
				}
			}
			else{
				return right.insert(n);
			}
		}
		else{
			if(left == null){
				left = new BST(n);
				left.parent = this;

				BST rt = this;
				while(true){
					rt.size++;
					if(rt.parent != null){
						rt = rt.parent;
						continue;
					}
					return rt;
				}
			}
			else{
				return left.insert(n);
			}
		}
	}
	
	//return indexth data within sorted order
	public int dataat(int index){
		int left = 0;
		int right = 0;
		
		if(this.left != null) left = this.left.size;
		if(this.right != null) right = this.right.size;
		
		if(index<=left) return this.left.dataat(index);
		else if(index>left+1) return this.right.dataat(index-left-1);
		else return this.data;
		
	}
	
	public int median(){
		return dataat((this.size+1)/2);
	}
	
	
	
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int pre = 1983;
			int result = 0;
			
			BST tree = new BST(pre);
			int x = tree.median();
			result += x;
			result %= 20090711;
			
			for(int i=1; i<n; i++){
				int p = pre;
				for(int j=0; j<a-1; j++){
					pre += p;
					pre %= 20090711;
				}
				pre += b;
				pre %= 20090711;
				
				tree.insert(pre);
				x = tree.median();
				result += x;
				result %= 20090711;

			}

			System.out.println(result);			
		}
	}
}
