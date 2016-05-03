import java.util.Scanner;

//array에 input이 들어올때마다 insert sort와 같은 방식으로 진행하여 sort!
public class Main2 {
	public static int[] seqs = new int[200000];

	// len 은 input을 추가하기 전의 seqs의 길
	public static int median(int input, int len){
		if(len==0) seqs[0]=input;

		for(int i=0; i<len; i++){
			if(i == len-1) seqs[len] = input;
			if(input>seqs[i]) continue;
			else{
				for(int j=len; j>i; j--){
					seqs[j] = seqs[j-1];
				}
				seqs[i] = input;
				break;
			}
		}

		int result;
		if(len==0) result = seqs[0];
		else result = seqs[(len)/2];


		return result;
	}

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
			
			for(int i=0; i<n; i++){
				
				int x = median(pre, i)% 20090711;

				System.out.print(" ");
				System.out.print(x);
				result += x;
				result %= 20090711;

				int p = pre;
				for(int j=0; j<a-1; j++){
					pre += p;
					pre %= 20090711;
				}
				pre += b;
				pre %= 20090711;
				
			}
			System.out.println();
			System.out.println(result);	
		}
	}
}
