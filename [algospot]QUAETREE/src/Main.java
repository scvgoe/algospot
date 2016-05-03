import java.util.Scanner;


public class Main {
	public static String quadtree(String s){
		if(s.equals("b") || s.equals("w")) return s;
		
		int two = 0;
		int three = 0;
		int four = 0;
		int cnt = 0;
		
		for(int i=1; i<s.length(); i++){
			if(cnt == 4){ 
				break;
			}
			
			if(s.charAt(i) == 'b' || s.charAt(i) == 'w'){
				cnt++;
				if(cnt == 2) two = i;
				else if(cnt == 3) three = i;
				else if(cnt == 4) four = i;
			}
			else{
				cnt++;
				if(cnt == 2) two = i;
				else if(cnt == 3) three = i;
				else if(cnt == 4) four = i;
				int c = cutter(s, i) - 1;
				i += c;
			}
		}
		
		return "x" + quadtree(s.substring(three, four)) + 
				quadtree(s.substring(four, s.length())) +
				quadtree(s.substring(1, two)) +
				quadtree(s.substring(two, three)); 
	}
	
	//String s의 index에 있는 "x"로 시작하는 한 덩어리의 길이를 return
	public static int cutter(String s, int index){
		int cnt = 0;
		int result = 1;
		
		for(int i=index+1; i<s.length(); i++){
			if(cnt == 4){
				return result;
			}
			
			if(s.charAt(i) == 'b' || s.charAt(i) == 'w'){
				cnt++;
				result++;
			}
			else{
				cnt++;
				int c = cutter(s, i);
				result += c;
				i += c;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		for(int c=0; c<cases; c++){
			String s = sc.nextLine();
			System.out.println(quadtree(s));
		}
	}

}
