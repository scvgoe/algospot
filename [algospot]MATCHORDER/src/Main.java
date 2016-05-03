import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static int win(int[] t1, int[] t2){
		int result = 0;
		int n = t1.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(t1[i]<=t2[j]){
					t2[j] = 0;
					result++;
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int n = sc.nextInt();
			int[] t1 = new int[n];
			int[] t2 = new int[n];
			for(int i=0; i<n; i++) t1[i] = sc.nextInt();
			for(int i=0; i<n; i++) t2[i] = sc.nextInt();
			Arrays.sort(t1);
			Arrays.sort(t2);
			System.out.println(win(t1,t2));
		}
	}
}
