import java.util.*;

class BitsPrinter{
    public static void fullBinaryPrinter(int x){
        String s = "";
        for(int i = 0;i<32;i++){
            if( (x & (1<<i)) != 0) s = "1" + s;
            else s = "0" + s;
        }
        System.out.println(s);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // for(int i = 0;i<n;i++){
        //     int x = scn.nextInt();
        //     fullBinaryPrinter(x);
        // }
        fullBinaryPrinter(Integer.MAX_VALUE + 1);
        fullBinaryPrinter(Integer.MIN_VALUE);
        fullBinaryPrinter(-1);
        fullBinaryPrinter(0);

    }
}