// Tom的生日礼物
import java.util.Scanner;
import java.util.Stack;
public class Test {
	public static void main(String []args){
		Scanner cin=new Scanner(System.in);
		String s;
		
		while(cin.hasNext()){
			s=cin.nextLine();
			int n=s.length();
			int cnt=0;
			Stack<String>stk=new Stack<String>();
			for(int i=0;i<n;i++){
				char tmp=s.charAt(i);
				if(tmp==')')stk.pop();
				else
					if(tmp=='(')stk.push("(");
					else
						if(tmp=='A')break;
				if(s.charAt(i)=='('&&s.charAt(i+1)!=')')cnt++;
				else
					if(s.charAt(i)=='A')break;
			}
			System.out.println(stk.size());
			
		}
	}
}