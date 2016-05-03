import java.util.Scanner;


public class Main2 {
	public static int result;
	public static int n;
	
	public static void NQUEEN(int[][] table, int s){
		int a = 0;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(table[i][j] == 1) a++;
			}
		}
		
		if(a != s) return;
		
		if(a == n) {
			result++;
			return;
		}
	
		
		for(int i=0; i<n; i++){
			if(QUEEN(table, s, i)){
				NQUEEN(table, s+1);
			}
			table[s][i] = 0;
		}
	}
	
	public static boolean QUEEN(int[][] table, int a, int b){
		for(int k=0; k<n; k++){
			if(table[a][k] == 1) return false;
			if(table[k][b] == 1) return false;
		}
		
		int x, y;
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) {
			if(table[x++][y++] == 1) return false;
		}
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) {
			if(table[x++][y--] == 1) return false;
		}
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) {
			if(table[x--][y++] == 1) return false;
		}
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) { 
			if(table[x--][y--] == 1) return false;
		}
		table[a][b] = 1;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			result = 0;
			n = sc.nextInt();
			int[][] table = new int[n][n];
			NQUEEN(table, 0);
			System.out.println(result);
		}
	}

}
