package day7;

public class BackTrack01nb {
	private static int[] p;//��Ʒ�ļ�ֵ����
	private static int[] w;//��Ʒ����������
	private static int c;//�������õ�����
	private static int count;//��Ʒ�ĸ���
	private static int cw;//��ǰ������
	private static int cp;//��ǰ�ļ�ֵ
	static int bestp;//Ŀǰ����װ�صļ�ֵ
	private static int r;//ʣ����Ʒ�ļ�ֵ
	
	private static int[] cx;//��ŵ�ǰ��
	private static int[] bestx;//������ս�
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
		if(cw+w[t]<=c) {//����������
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
	}//���������һ�����нڵ㣬�������������������������п��ܰ������Ž�,����������������
	public static void main(String[] args) {
	    //����
	    int[] w1 = {0,15,25,40,20,15,24};
	    int[] p1 = {0,10,5,20,2,14,23};
	    int c1 = 30;
	    Loading(w1,p1,c1);
	    System.out.println("����װ��Ϊ��" + bestp);
	    for(int i =1;i<=count;i++) {
	        System.out.print(bestx[i] + " ");
	    }           
	}
}
