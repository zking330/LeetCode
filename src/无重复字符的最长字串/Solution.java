package 无重复字符的最长字串;

import java.util.*;

public class Solution {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring(" ewdsfdsagegr"));
   }

   public static int lengthOfLongestSubstring(String s) {
      HashSet set = new HashSet();
      String result = "";
      StringBuilder strs = new StringBuilder();

      while(s.length() >= 1) {
         strs.delete(0, strs.length());
         set.clear();

         for(int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);

            if(!set.contains(str)) {
               set.add(str);
               strs.append(str);
            }
            else{
               break;
            }
         }

         result = result.length() > strs.toString().length() ? result : strs.toString();
         s = s.substring(1);
      }

      return result.length();
   }
}
