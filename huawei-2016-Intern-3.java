// 消灭终极BOSS
import java.util.Scanner;
public class Main{
	static int min=Integer.MAX_VALUE;
	public static void dfs(int hp1,int mp,int hp2,int cnt){
		if(hp1<=0){
			if(hp2<=0){
				if(min>(cnt-1))min=cnt-1;
			}
			return ;
		}
		if(hp2<=0){
			if(min>(cnt-1))min=cnt-1;
			return ;
		}
		
		if(mp>=10){
			int ans=mp/10;
			int ans1=hp2%60!=0?hp2/60+1:hp2/60;
			if(ans1<ans)ans=ans1;
			int tmp=hp2;
			for(int i=0;i<ans;i++){
				if(cnt%5==0)hp1-=30;
				else
					hp1-=10;
				cnt++;
				if(hp1<=0)break;
				tmp-=60;
			}
			dfs(hp1,mp-10*ans,tmp,cnt);
		}else{
			int hp=hp1;
			int ans=hp2/17;
			if(hp2%17!=0)ans++;
			int tmp=hp2;
			for(int i=0;i<ans;i++){
				if(cnt%5==0)hp1-=30;
				else
					hp1-=10;
				cnt++;
				if(hp1<=0)break;
				tmp-=17;
			}
			dfs(hp1,mp,tmp,cnt);
			hp1=hp;
			ans=(10-mp)/4;
			if((10-mp)%4!=0)ans++;
			for(int i=0;i<ans;i++){
				if(cnt%5==0)hp1-=30;
				else
					hp1-=10;
				cnt++;
				if(hp1<=0)break;
				mp+=4;
			}
			dfs(hp1,mp,hp2,cnt);
		}
	}
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		int hp1,mp,hp2;
		
		while(cin.hasNext()){
			hp1=cin.nextInt();
			mp=cin.nextInt();
			hp2=cin.nextInt();
			min=Integer.MAX_VALUE;
			dfs(hp1,mp,hp2,1);
			if(min==Integer.MAX_VALUE)System.out.println(-1);
			else
				System.out.println(min);
			
		}
	}
}
