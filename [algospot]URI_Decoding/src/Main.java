import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<c; i++){
			String input = sc.nextLine();
			char[] inputarr = input.toCharArray();
			
			int len = inputarr.length;
			String returnstr = "";
			
			for(int j=0; j<len; j++){
				if(inputarr[j] != '%'){
					returnstr = returnstr + inputarr[j];
				}
				else{
					String addchar = "" + inputarr[j+1];
					addchar = addchar + inputarr[j+2];
					returnstr = returnstr + (char) Long.parseLong(addchar, 16);
					j += 2;
				}
			}
			System.out.println(returnstr);
		}
	}

}
