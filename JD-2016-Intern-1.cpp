// я║╬ысно╥
#include<iostream>
using namespace std;
int main(){
    int n;
    int a[105];
    while(cin>>n){
          int max=0;
          int maxi=0;
        for(int i=0;i<n;i++){
              cin>>a[i];
              if(max<=a[i]){
                    max=a[i];
                    maxi=i;
              }
        }
          int ans=0;
          while(maxi!=0){
            a[0]++;
            a[maxi]--;
            ans++;
            max=0;
            maxi=0;
            for(int i=0;i<n;i++)
                      if(max<=a[i]){
                        max=a[i];
                        maxi=i;
                      }
          }
          cout<<ans<<endl;
    }
      return 0;
}