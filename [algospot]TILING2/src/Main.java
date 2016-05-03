import java.util.Scanner;


public class Main {
	public static int[] s = new int[101];
	
	public static int tiling(int n){
		if(s[n]>0){
			return s[n];
		}
		
		if(n==1)	
			s[n] = 1;
		else if(n==2)
			s[n] = 2;
		else{
			s[n] = (tiling(n-1) + tiling(n-2))%1000000007;
		}
		
		return s[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		for(int i=0; i<cases; i++){
			int n = sc.nextInt();
			System.out.println(tiling(n));
		}
	}

}
