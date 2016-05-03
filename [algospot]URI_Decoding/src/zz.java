
public class zz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[10];
		int b[][] = new int[100][];
		
		if(b[0]==null)
			System.out.println(b[0]);
		
		for(int i=0; i<10; i++){
			b[i] = new int[10];
			System.out.println(b[i][0]);
		}
	}

}
