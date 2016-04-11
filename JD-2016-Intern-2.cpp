#include<iostream>
#include<stdio.h>
using namespace std;
char a[3][3];
// 返回0，无法获胜；返回1，获胜；返回-1，棋局不合法
int valid(char c){
    // 水平
    int flag=0;
    for(int i=0;i<3;i++){
        int j=0;
        for(;j<3;j++)
            if(a[i][j]!=c)break;
        if(j==3)flag++;
    }
    // 垂直
    for(int i=0;i<3;i++){
        int j=0;
        for(;j<3;j++)
            if(a[j][i]!=c)break;
        if(j==3)flag++;
    }
    // 对角
    int i=0;
    for(;i<3;i++)
        if(a[i][i]!=c)break;
    if(i==3)flag++;
    for(i=0;i<3;i++)
        if(a[i][2-i]!=c)break;
    if(i==3)flag++;
    if(flag==0||flag==1)return flag;
    return -1;
}
int main(){

    while(scanf("%s",a[0])!=EOF){
        //getchar();
        for(int i=1;i<=2;i++){
            scanf("%*c%s",a[i]);
            //getchar();
        }
        //for(int i=0;i<3;i++){
        //  for(int j=0;j<3;j++)
        //      cout<<a[i][j];
        //  cout<<endl;
        //}
        int x=0;
        int o=0;
        int d=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                if(a[i][j]=='X')x++;
                else
                    if(a[i][j]=='0')o++;
                    else
                        if(a[i][j]=='.')d++;
        }
        if((x+o+d)!=9||abs(x-o)>1||o>x){
            cout<<"x"<<endl;
            continue;
        }
        int vx=valid('X');
        int vo=valid('0');
        if(vx==-1||vo==-1||vx&&vo){
            cout<<"x"<<endl;
            continue;
        }
        if(vx){
            cout<<"1 won"<<endl;
            continue;
        }
        if(vo){
            cout<<"2 won"<<endl;
            continue;
        }
        if(d==0){
            cout<<"draw"<<endl;
            continue;
        }
        if(x==o){
            cout<<"1"<<endl;
        }else{
            cout<<"2"<<endl;
        }
    }
}