package 机器人能否回到原点;


public class Solution {
   public boolean judgeCircle(String moves) {
      int length = moves.length();
      int l = 0;
      int r = 0;
      int u = 0;
      int d = 0;

      for(int i = 0; i < length; i++) {
         char val = moves.charAt(i);

         if('L' == val){
            l++;
         }
         else if('R' == val){
            r++;
         }
         else if('U' == val){
            u++;
         }
         else if('D' == val){
            d++;
         }
      }

      return l == r && u == d;
   }
}
