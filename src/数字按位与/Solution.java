package 数字按位与;

public class Solution {

    public static void main(String[] args) {
        System.out.print(rangeBitwiseAnd(4, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int t = 0;

        while(m < n){
            m = m >> 1;
            n = n >> 1;
            t += 1;
        }

        return m << t;
    }
}
