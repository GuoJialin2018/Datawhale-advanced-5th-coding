package day6;

public class leetcode36 {
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]=='.')continue;
				for(int k=j+1;k<9;k++)
					if(board[i][j]==board[i][k])
						return false;
				for(int k=i+1;k<9;k++)
					if(board[i][j]==board[k][j])
						return false;
				for(int k=i+1;k%3!=0;k++) {
					for(int h=j/3*3;j<j/3*3+3;h++) {
						if(board[i][j]==board[k][h])
							return false;
					}
				}
			}
		}
		return true;
	}

}
