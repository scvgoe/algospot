import java.util.Scanner;

public class Main {
	public static int count (int[][] board, int h, int w) {
		int topH = -1, topW = -1, result = 0;
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (board[i][j] == 0) {
					topH = i;
					topW = j;
					break;
				}
			}
			if (topH != -1) break;
		}

		//0th case
		if (topH == -1 && topW == -1) {
			return 1;
		}

		//1st case
		if (topH+1 < h && topW+1 < w) {
			if (board[topH][topW+1] == 0 && board[topH+1][topW+1] == 0) {
				board[topH][topW] = 1;
				board[topH][topW+1] = 1;
				board[topH+1][topW+1] = 1;
				result += count (board, h, w);
				board[topH][topW] = 0;
				board[topH][topW+1] = 0;
				board[topH+1][topW+1] = 0;
			}
		}

		//2nd case
		if (topH+1 < h && topW+1 < w) {
			if (board[topH][topW+1] == 0 && board[topH+1][topW] == 0) {
				board[topH][topW] = 1;
				board[topH][topW+1] = 1;
				board[topH+1][topW] = 1;
				result += count (board, h, w);
				board[topH][topW] = 0;
				board[topH][topW+1] = 0;
				board[topH+1][topW] = 0;
			}
		}

		//3rd case
		if (topH+1 < h && topW+1 < w) {
			if (board[topH+1][topW] == 0 && board[topH+1][topW+1] == 0) {
				board[topH][topW] = 1;
				board[topH+1][topW] = 1;
				board[topH+1][topW+1] = 1;
				result += count (board, h, w);
				board[topH][topW] = 0;
				board[topH+1][topW] = 0;
				board[topH+1][topW+1] = 0;
			}
		}

		//4th case
		if (topH+1 < h && topW > 0) {
			if (board[topH+1][topW] == 0 && board[topH+1][topW-1] == 0) {
				board[topH][topW] = 1;
				board[topH+1][topW] = 1;
				board[topH+1][topW-1] = 1;
				result += count (board, h, w);
				board[topH][topW] = 0;
				board[topH+1][topW] = 0;
				board[topH+1][topW-1] = 0;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0; i<t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			sc.nextLine();
			int board[][] = new int[h][w];
			for (int j=0; j<h; j++) {
				String temp = sc.nextLine();
				for (int k=0; k<w; k++) {
					board[j][k] = (temp.charAt(k) == '#') ? 1 : 0;
				}
			}
			System.out.println(count(board, h, w));
		}
	}

}
