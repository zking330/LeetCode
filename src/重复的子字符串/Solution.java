package 重复的子字符串;

public class Solution {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("aba"));
    }

    /**
     *字符串枚举
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern1(String s) {
        int l = s.length();

        for (int i = 1; i * 2 <= l; i++) {
            if(l % i == 0) {
                boolean match = true;

                for (int j = i; j < l; j++) {
                    if(s.charAt(j) != s.charAt(j - i)) {
                         match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 字符串匹配
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
