#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
#include<string>
using namespace std;
int main(){
    long long x,k,y;
    while(cin>>x>>k){
        int tmp=1;
        while(x){
			// tmp=2^i，low为取k的低i位(低i位为二进制下标为0,1,2...(i-1))
            long long low=(tmp-1)&k;
            long long high=k-low;
            if(x&1){
				// 右移
                high<<=1;
            }
			// 插入
            k=high+low;
            tmp<<=1;
            x>>=1;
        }
        cout<<k<<endl;
    }
    return 0;
}