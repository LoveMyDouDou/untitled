import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in

        );
        while(in.hasNext()){
            int n=in.nextInt();
            int s[]=new int[n+1];
            for(int i=0;i<n;i++){
                s[i]=in.nextInt();
            }
            int dp[][]=new int[n+1][n+1];
            System.out.println(dfs(n,0,n-1,s,dp));
        }
    }
    static int dfs(int n,int l,int r,int s[],int dp[][]){
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=0){
            return dp[l][r];
        }
        dp[l][r]=Math.max(s[l]*(n-r+l)+dfs(n,l+1,r,s,dp), s[r]*(n-r+l)+dfs(n,l,r-1,s,dp));
        return dp[l][r];
    }
}