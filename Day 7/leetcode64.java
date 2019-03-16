package day7;

public class leetcode64 {
    public int minPathSum(int[][] grid) {
    	int row=grid.length;
        int col=grid[0].length;
        int[][] score=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i>=1&&j>=1){
                    score[i][j]=Math.min(score[i-1][j],score[i][j-1])+grid[i][j];
                }
                else if(i>=1){
                    score[i][j]=score[i-1][j]+grid[i][j];
                }
                else if(j>=1){
                    score[i][j]=score[i][j-1]+grid[i][j];
                }else{
                    score[i][j]=grid[i][j];
                }
            }
            
        }
        return score[row-1][col-1];
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
