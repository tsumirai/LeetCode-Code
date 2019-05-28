import javax.rmi.ssl.SslRMIClientSocketFactory;

public class LongestPalindromicSubstring {
    //把每个字符串不管是奇字符串还是偶字符串，都在字符左右加标识符（任意在这里用 # ）
    //比如 1 2 1  就变成 # 1 # 2 # 1 #  这样处理不管奇数偶数都变成偶数长度的数组
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[2 * str.length() + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static String maxLcpsLength(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }

        char[] charArr = manacherString(str);
        //存储i位置的最大回文半径
        int[] pArr = new int[charArr.length];
        int max = Integer.MIN_VALUE;
        int r = -1;
        int mid = -1;
        for (int i = 0; i < charArr.length; i++) {
            //给i位置的回文半径赋一个初始值,判断i的位置是在r的左侧还是右侧
            pArr[i] = r > i ? Math.min(r - i, pArr[2 * mid - i]) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] >= 0) {
                //如果i在r之外还有回文数字，扩展的位置相等回文扩大
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > r) {
                r = i + pArr[i];
                mid = i;
            }
            max = Math.max(max, pArr[i]);
        }
        //因为最开始回文半径赋值为1，所以多了1 得减去
        int longest = max - 1;
        int start = (mid-1)/2-(longest-1)/2;
        return str.substring(start,start+longest);
    }
}

