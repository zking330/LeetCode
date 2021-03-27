package NO17电话号码的数字组合;

import java.util.*;

public class Solution {
   public static void main(String[] args) {
      letterCombinations("24");
      System.out.println("aaa");
   }

   public static List<String> letterCombinations(String digits) {
      List<String> resList = new ArrayList<>();
      HashMap map = new HashMap(){{
         put('2', "abc");
         put('3', "def");
         put('4', "ghi");
         put('5', "jkl");
         put('6', "mno");
         put('7', "pqrs");
         put('8', "tuv");
         put('9', "wxyz");
      }};

      backtrack(resList, map, digits, 0, new StringBuffer());
      return resList;
   }

   //递归函数
   public static void backtrack(List<String> resList, Map<Character, String> map,
                         String digits, int index, StringBuffer combination) {
      if(index == digits.length()) {
         resList.add(combination.toString());
      }
      else {
         char digit = digits.charAt(index);
         String letters = map.get(digit);
         int lettersCount = letters.length();

         for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(resList, map, digits, index + 1, combination);
            combination.deleteCharAt(index);
         }
      }
   }

}
