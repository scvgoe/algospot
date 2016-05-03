import java.util.Scanner;


public class Main3 {
	public static int result;
	public static int n;
	
	public static void NQUEEN(int[] horse, int s){
		if(s == n) {
			result++;
			return;
		}
		
		for(int i=0; i<n; i++){
			horse[s] = i+1;
			if(QUEEN(horse, s)) NQUEEN(horse, s+1);
		}
	}
	
	public static boolean QUEEN(int [] horse, int s){
		for(int i=0; i<s; i++){
			if(horse[i] == horse[s]) return false;
			if(horse[i]+i == horse[s]+s) return false;
			if(horse[i]-i == horse[s]-s) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			result = 0;
			n = sc.nextInt();
			int[] horse = new int[n];
			NQUEEN(horse, 0);
			System.out.println(result);
		}
	}

}
