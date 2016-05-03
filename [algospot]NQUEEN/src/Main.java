import java.util.Scanner;


public class Main {
	public static int result;
	public static int n;

	public static void QUEEN(int[][] table, int a, int b){
		for(int k=0; k<n; k++){
			table[a][k] = -1;
			table[k][b] = -1;
		}
		int x, y;
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) table[x++][y++] = -1;
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) table[x++][y--] = -1;
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) table[x--][y++] = -1;
		x = a;
		y = b;
		while(x>=0 && x<n && y>=0 && y<n) table[x--][y--] = -1;

		table[a][b] = 1;
	}

	// 1-1
	// 2-0
	// 3-0
	// 4-2
	// 5-8
	public static int NQUEEN(int[][] table, int s){
		int a=0;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(table[i][j] == 1) a++;
			}
		}

		if(a != s) return 0;

		if(a == n){
			result++;
			return 0;
		}

		int x = -1;
		int y = 0;
		for(int j=0; j<n; j++){
			if(table[s][j] == 0){
				x = s;
				y = j;
				break;
			}
		}
		
		if(x == -1) return 0;
		
		int[][] tablecp = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				tablecp[i][j] = table[i][j];
			}
		}

		QUEEN(table, x, y);
		NQUEEN(table, s+1);

		tablecp[x][y] = -1;
		NQUEEN(tablecp, s);
		return 0;
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

