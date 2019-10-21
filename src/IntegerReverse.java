public class IntegerReverse {
        public int reverse(int x) {
            long res = 0;
            while (x != 0) {
                System.out.println("余数是 "+x%10);
                System.out.println("商是 "+ x/10);
                res = res * 10 + x % 10;
                x /= 10;
                if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            }
            return (int)res;
        }
}
