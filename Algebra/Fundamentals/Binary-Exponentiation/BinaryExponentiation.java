public class BinaryExponentiation{
    public long binpow(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long res = binpow(a, n/2);
        if  (n%2 == 1) {
            return res * res * a;
        }
        else {
            return res * res;
        }
    }

    public static void main(String[] args) {
        long a = 3;
        long n = 13;
        BinaryExponentiation res = new BinaryExponentiation();
        long ans = res.binpow(a, n);
        System.out.println("Answer for 3 to the power of 13 is: " + ans);
    }
}