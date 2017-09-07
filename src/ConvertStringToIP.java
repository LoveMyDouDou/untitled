/**
 * Created by YangGang on 2017/9/6.
 */
public class ConvertStringToIP {

    public static int convertNum1(String str){
        //IP地址包括的数字个数范围在4~12
        if(str==null||str.length()<4||str.length()>12){
            return 0;
        }
        char [] chars=str.toCharArray();
        return process(chars,0,0);
    }

    public static int process(char [] chars,int i,int parts){
        //终止条件，一个是遍历结束，另一个是划分大于4部分，而IP只有4部分排除
        if(i>chars.length||parts>4){
            return  0;
        }
        //终止条件：已经到了结尾，看看是否正好分成4部分，若正好分成4部分则成功，否则失败
        if(i==chars.length){
            return parts==4?1:0;
        }
        //如果把自己作为一个部分，合法的个数
        int res=process(chars,i+1,parts+1);
        //如果当前字符是0，只能够把当前自己作为一段，因为IP中不可能出现012这种情况
        if(chars[i]=='0'){
            return res;
        }
        //如果当前字符不是0，则有可能是当前字符和下一字符一起构成一个部分。
        res+=process(chars,i+2,parts+1);
        //当前字符不是0，和下两个字符一起构成一部分,注意IP一个段只能是0-255
        if(i+2<chars.length){
            int sum=(chars[i]-'0')*100+(chars[i+1]-'0')*10+(chars[i+2]-'0');
            if(sum<255)
            {
                return res+process(chars,i+3,parts+1);
            }
            else {
                return res;
            }
        }
        else {
            return res;
        }
    }

    public static int convertNum2(String str){
        if(str==null||str.length()<4||str.length()>12){
            return 0;
        }
        char [] chars=str.toCharArray();
        int size=chars.length;
        int [][]dp=new int [size+3][5];
        //初始值
        dp[size][4]=1;
        for(int parts=3;parts>=0;parts--){
            //因为IP每个段最多3位（i=Math.min(size-1,parts*3)）
            for(int i=Math.min(size-1,parts*3);i>=parts;i=Math.min(i-1,parts*3)){
                dp[i][parts]=dp[i+1][parts+1];
                if(chars[i]!=0){
                    dp[i][parts]+=dp[i+2][parts+1];
                    if(i+2<chars.length){
                        int sum=(chars[i]-'0')*100+(chars[i+1]-'0')*10+(chars[i+2]-'0');
                        if(sum<256){
                            dp[i][parts]+=dp[i+3][parts+1];
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }









}
