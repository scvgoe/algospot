import java.util.Scanner;


public class Main2 {
	public static String quadtree(String s, int index){
		if(s.charAt(index) == 'w' || s.charAt(index) == 'b'){
			return s.substring(index, index+1);
		}
		else{
			int one = index + 1;
			String str1 = quadtree(s, one);
			int two = one + str1.length();
			String str2 = quadtree(s, two);
			int three = two + str2.length();
			String str3 = quadtree(s, three);
			int four = three + str3.length();
			String str4 = quadtree(s, four);
			
			return "x" + str3 + str4 + str1 + str2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		sc.nextLine();
		for(int c = 0; c<cases; c++){
			String s = sc.nextLine();
			System.out.println(quadtree(s, 0));
		}
	}

}
