import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KthSmallestElementinaBST {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n;
		while (cin.hasNext()) {
			n = cin.nextInt();
			String[] str = new String[n];
			Element[] e = new Element[10];
			for (int i = 0; i < 10; i++)
				e[i] = new Element();
			for (int i = 0; i < n; i++) {
				str[i] = cin.next();
				int l = str[i].length();
				long base = 1;
				for (int j = l - 1; j >= 0; j--, base *= 10) {
					int idx = str[i].charAt(j) - 'A';
					// 标记该字符不能为0
					if (j == 0)
						e[idx].flag = 1;
					e[idx].w += base;
				}
			}
			Arrays.sort(e, new Comparator<Element>() {

				@Override
				public int compare(Element o1, Element o2) {
					// if(o1.flag!=o2.flag)return o1.flag-o2.flag;
					return o1.w > o2.w ? 1 : (o1.w == o2.w ? 0 : -1);
				}

			});
			long s = 0;
			// 权值最低且不能为0的情况
			if (e[0].flag == 1) {
				int k = 0;
				for (; k < 10; k++)
					if (e[k].flag == 0)
						break;
				Element tmp = e[k];
				for (; k > 0; k--)
					e[k] = e[k - 1];
				e[0] = tmp;
			}
			// 权值越大映射的值越大
			for (int i = 9; i >= 0; i--) {
				s += e[i].w * i;
				// System.out.println(e[i].flag+" "+e[i].w);
			}

			System.out.println(s);

		}
	}
}

// 记录字符的权重和标识符，flag=0，表示该字符可以为0，反之，说明该字符不能为0.
class Element {
	long w;
	int flag;
}