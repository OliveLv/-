// 计算重复字符个数
import java.util.Scanner;
 public class Main{
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		String s;
		while(cin.hasNext()){
			s=cin.nextLine();
			int n=s.length();
			char pre=s.charAt(0);
			int ans=1;
			String res="";
			for(int i=1;i<n;i++){
				char cur=s.charAt(i);
				if(!((cur>='A'&&cur<='Z')||(cur>='a'&&cur<='z')))continue;
				//System.out.println();
				if(pre!=cur){
					
						res+=pre;
						res+=ans;
						
					
					pre=cur;
					ans=1;
				}else
					ans++;
				
			}
			res+=pre;
			res+=ans;
			System.out.println(res);
		}
	}
}