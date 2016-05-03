import java.util.Scanner;


public class Main {
	
	public static int[] len = new int[51];
	
	public static void init(){
		len[0] = 1;
		for(int i=1; i<=50; i++){
			len[i] = Math.min(2 * len[i-1] + 2, 1000000100);
		}
	}

	public static String dragon(String input, int gen, int p){
		if(gen == 0) return input.substring(p, p+1);
		else{
			for(int i=0; i<input.length(); i++){
				if(input.substring(i, i+1).equals("X"))	{
					if(p>=len[gen]) p -= len[gen];
					else return dragon("X+YF", gen-1, p);
				}
				else if(input.substring(i, i+1).equals("Y"))	{
					if(p>=len[gen]) p -= len[gen];
					else return dragon("FX-Y", gen-1, p);
				}
				else if(p==0) return input.substring(i, i+1);
				else p--;
			}
			return "#";
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int g = sc.nextInt();
			int p = sc.nextInt();
			int l = sc.nextInt();
			String rtn = "";
			for(int i=p; i<p+l; i++){
				rtn += dragon("FX", g, i-1);		
			}
			System.out.println(rtn);
		}
	}
}
