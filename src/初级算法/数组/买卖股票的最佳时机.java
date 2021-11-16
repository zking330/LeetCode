package 初级算法.数组;

/**
 * @author kai.zheng
 * @className 买卖股票的最佳时机
 * @date 2021/11/16 20:27
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        maxProfit(new int[] {7,1,5,3,6,4});
        System.out.println();
    }


    public static int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }

        int i = 0;
        int sum = 0;

        for (int j = 1; j < prices.length; j++) {
            if(prices[j] > prices[i]) {
                sum = sum + prices[j] - prices[i];
            }

            i++;
        }

        return sum;
    }



}
