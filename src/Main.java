import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String str = input.next();
            int max = 0;
            String maxStr = null;
            ArrayList<String> list = null;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int j = i + 1;
                    while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                        j++;
                    }
                    if(j - i > max) {
                        list = new ArrayList<>();
                        list.add(str.substring(i, j));
                        max = j - i;
                    }else if(j - i == max) {
                        list.add(str.substring(i, j));
                    }
                    i = j;
                }
            }
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            System.out.println( max);
        }
    }
}