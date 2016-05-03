import java.util.Scanner;


public class Main {
	public static int s[][] = new int[101][101];
	
	public static int gets(int n, int first){
		if(s[n][first] > 0){
			return s[n][first];
		}
		
		if(n==first){
			return 1;
		}
		
		for(int second=1; second<=n-first; second++){
			s[n][first] += (gets(n-first, second)*(first+second-1))%10000000;
			s[n][first] %= 10000000;
		}
		
		return s[n][first];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		
		for(int i=0; i<c; i++){
			int n = sc.nextInt();
			int result = 0;
			for(int j=1; j<=n; j++){
				int a = gets(n,j);
				result += a;
				result %= 10000000;
			}
			System.out.println(result);
		}
	}
}
