package day7;

public class BackTrack01nb {
	private static int[] p;//物品的价值数组
	private static int[] w;//物品的重量数组
	private static int c;//最大可以拿的重量
	private static int count;//物品的个数
	private static int cw;//当前的重量
	private static int cp;//当前的价值
	static int bestp;//目前最优装载的价值
	private static int r;//剩余物品的价值
	
	private static int[] cx;//存放当前解
	private static int[] bestx;//存放最终解
	public static int Loading(int[] ww,int[]pp,int cc) {
		count=ww.length-1;
		w=ww;
		p=pp;
		c=cc;
		cw=0;
		bestp=0;
		cx=new int[count+1];
		bestx=new int[count+1];
		for(int i=1;i<=count;i++) {
			r+=p[i];
		}
		BackTrack(1);
		return bestp;
	}
	public static void BackTrack(int t) {
		if(t>count) {
			if(cp>bestp) {
				for(int i=1;i<=count;i++) {
					bestx[i]=cx[i];
				}
				bestp=cp;
			}
			return;
		}
		r-=p[t];
		if(cw+w[t]<=c) {//搜索左子树
			cx[t]=1;
			cp+=p[t];
			cw+=w[t];
			BackTrack(t+1);
			cp-=p[t];
			cw-=w[t];
		}
		if(cp+r>bestp) {
			cx[t]=0;
			BackTrack(t+1);
		}
		r+=p[t];
	}//当左儿子是一个可行节点，搜索进入左子树，当右子树有可能包含最优解,则搜索进入右子树
	public static void main(String[] args) {
	    //测试
	    int[] w1 = {0,15,25,40,20,15,24};
	    int[] p1 = {0,10,5,20,2,14,23};
	    int c1 = 30;
	    Loading(w1,p1,c1);
	    System.out.println("最优装载为：" + bestp);
	    for(int i =1;i<=count;i++) {
	        System.out.print(bestx[i] + " ");
	    }           
	}
}
