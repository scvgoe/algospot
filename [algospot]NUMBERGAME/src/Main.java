import java.util.Scanner;

public class Main {
/*
	public static void choice(ArrayList<Integer> board, int[] sum, int turn){
		if(board.size() == 1){
			do_choice(board, sum, turn, 0);
			return;
		}

		else if(board.size() == 2){
			//case 1 - pick left number
			int a1 = board.get(0) - board.get(1);
			
			//case 2 - remove two number
			int b1 = 0;
			
			//case 3 - pick right number
			int c1 = board.get(1) - board.get(0);
			
			int max = a1;
			int choice_num = 0;
			
			if(max<b1){
				max = b1;
				choice_num = 1;
				
				if(max<c1){
					max = c1;
					choice_num = 2;
				}
			}
			
			do_choice(board, sum, turn, choice_num);
			return;
		}
		
		else if(board.size() == 3){
			//case 1 - pick left one
			int a1 = board.get(0) - board.get(1);
			int a2 = board.get(0) - board.get(board.size()-1);
			int a3 = board.get(0);

			//case 2 - remove left 2 ones
			int b1 = -board.get(2);

			//case 3 - pick right one
			int c1 = board.get(board.size()-1) - board.get(0);
			int c2 = board.get(board.size()-1) - board.get(board.size()-2);
			int c3 = board.get(board.size()-1);

			//case 4 - remove right 2 ones
			int d1 = -board.get(0);
			
			int[] choice_nums = new int[4];
			choice_nums[0] = Integer.min(Integer.min(a1, a2), a3);
			choice_nums[1] = b1;
			choice_nums[2] = Integer.min(Integer.min(c1, c2), c3);
			choice_nums[3] = d1;

			int max = choice_nums[0];
			int choice_num = 0;
			for(int i=1; i<4; i++){
				if(max < choice_nums[i]){
					max = choice_nums[i];
					choice_num = i;
				}
			}
			do_choice(board, sum, turn, choice_num);
			return;
		}

		else{
			//case 1 - pick left one
			int a1 = board.get(0) - board.get(1);
			int a2 = board.get(0) - board.get(board.size()-1);
			int a3 = board.get(0);

			//case 2 - remove left 2 ones
			int b1 = -board.get(2);
			int b2 = -board.get(board.size()-1);
			int b3 = 0;

			//case 3 - pick right one
			int c1 = board.get(board.size()-1) - board.get(0);
			int c2 = board.get(board.size()-1) - board.get(board.size()-2);
			int c3 = board.get(board.size()-1);

			//case 4 - remove right 2 ones
			int d1 = -board.get(0);
			int d2 = -board.get(board.size()-3);
			int d3 = 0;

			int[] choice_nums = new int[4];
			choice_nums[0] = Integer.min(Integer.min(a1, a2), a3);
			choice_nums[1] = Integer.min(Integer.min(b1, b2), b3);
			choice_nums[2] = Integer.min(Integer.min(c1, c2), c3);
			choice_nums[3] = Integer.min(Integer.min(d1, d2), d3);

			int max = choice_nums[0];
			int choice_num = 0;
			for(int i=1; i<4; i++){
				if(max < choice_nums[i]){
					max = choice_nums[i];
					choice_num = i;
				}
			}
			do_choice(board, sum, turn, choice_num);
			return;
		}
	}

	public static void do_choice(ArrayList<Integer> board, int[] sum, int turn, int choice){
		switch(choice){
		case 0:
			sum[turn%2] += board.remove(0);
			break;
		case 1:
			board.remove(0);
			board.remove(0);
			break;
		case 2:
			sum[turn%2] += board.remove(board.size()-1);
			break;
		case 3:
			board.remove(board.size()-1);
			board.remove(board.size()-1);
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int len = sc.nextInt();
			ArrayList<Integer> board = new ArrayList<Integer>();
			for(int l=0; l<len; l++){
				board.add(sc.nextInt());
			}
			int[] sum = new int[2];
			int turn = 0;
			while(board.size()!=0){
				choice(board, sum, turn);
				turn++;
			}
			System.out.println(sum[0]-sum[1]);
		}
	}
*/
	public static int[] board = new int[50];
	public static int[][] dynamic = new int[50][50];
	
	public static int play(int l, int r){
		if(l>r){
			return 0;
		}
		
		if(dynamic[l][r] != Integer.MIN_VALUE){
			return dynamic[l][r];
		}
		
		dynamic[l][r] = Integer.max(board[l] - play(l+1, r), board[r] - play(l, r-1));
		
		if(r-l+1 >= 2){
			dynamic[l][r] = Integer.max(dynamic[l][r],
					Integer.max(-play(l+2, r), -play(l, r-2)));
		}
		
		return dynamic[l][r];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int c=0; c<cases; c++){
			int len = sc.nextInt();
			for(int l=0; l<len; l++) board[l] = sc.nextInt();
			for(int i=0; i<50; i++){
				for(int j=0; j<50; j++){
					dynamic[i][j] = Integer.MIN_VALUE;
				}
			}
			System.out.println(play(0, len-1));
		}
	}
}
