import java.util.Scanner;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c = 0; c<cases; c++){
			int len = sc.nextInt();
			int arr[] = new int[len];
			for(int i=0; i<len; i++){
				arr[i] = sc.nextInt(); 
			}
			Arrays.sort(arr);
			
			int result = 0;
			int start = 0;
			while(start<len-1){
				int a = 0;
				a += arr[start];
				arr[start++] = 0;
				a += arr[start];
				arr[start++] = 0;
				result += a;
				
				for(int i=start; i<len; i++){
					if(arr[i]<a) {
						arr[i-1] = arr[i];
						continue;
					}
					else{
						arr[i-1] = a;
						break;
					}
				}
				if(arr[len-1]<a) arr[len-1] = a;
				
				start--;
				
			}
			System.out.println(result);
		}
	}
}
