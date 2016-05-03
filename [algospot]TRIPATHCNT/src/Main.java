import java.util.Scanner;


public class Main {
	public static int[][] tri = new int[100][100];
	public static int[][][] dynamic = new int[100][100][2];

	
	public static void init(){
		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				tri[i][j] = 0;
				dynamic[i][j][0] = 0;
				dynamic[i][j][1] = 0;
			}
		}
	}
	
	public static int[] TRIPATHCNT(int a, int b){
		if(dynamic[a][b][1] != 0) return dynamic[a][b];
		if(a == 0 && b == 0){
			dynamic[0][0][0] = tri[0][0];
			dynamic[0][0][1] = 1;
			return dynamic[0][0];
		}
		
		if(b == a) {
			dynamic[a][b][0] = TRIPATHCNT(a-1, b-1)[0] + tri[a][b];
			dynamic[a][b][1] = TRIPATHCNT(a-1, b-1)[1];
		}
		
		else if(b == 0){
			dynamic[a][b][0] = TRIPATHCNT(a-1, b)[0] + tri[a][b];
			dynamic[a][b][1] = TRIPATHCNT(a-1, b)[1];
		}
		else{
			if(TRIPATHCNT(a-1, b-1)[0]>TRIPATHCNT(a-1, b)[0]){
				dynamic[a][b][0] = TRIPATHCNT(a-1, b-1)[0] + tri[a][b];
				dynamic[a][b][1] = TRIPATHCNT(a-1, b-1)[1];
			}
			else if(TRIPATHCNT(a-1, b-1)[0]<TRIPATHCNT(a-1, b)[0]){
				dynamic[a][b][0] = TRIPATHCNT(a-1, b)[0] + tri[a][b];
				dynamic[a][b][1] = TRIPATHCNT(a-1, b)[1];
			}
			else{
				dynamic[a][b][0] = TRIPATHCNT(a-1, b-1)[0] + tri[a][b];
				dynamic[a][b][1] = TRIPATHCNT(a-1, b-1)[1] + TRIPATHCNT(a-1, b)[1];
			}
		}
		return dynamic[a][b];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int n = sc.nextInt();
			init();
			for(int i=0; i<n; i++){
				for(int j=0; j<=i; j++){
					tri[i][j] = sc.nextInt();
				}
			}
			int maxv = TRIPATHCNT(n-1, 0)[0];
			int maxcnt = TRIPATHCNT(n-1, 0)[1];
			for(int i=1; i<n; i++){
				if(TRIPATHCNT(n-1, i)[0] == maxv){
					maxcnt += TRIPATHCNT(n-1, i)[1];
				}
				else if(TRIPATHCNT(n-1, i)[0] > maxv){
					maxv = TRIPATHCNT(n-1, i)[0];
					maxcnt = TRIPATHCNT(n-1, i)[1];
				}
			}
			System.out.println(maxcnt);
		}
	}
}
