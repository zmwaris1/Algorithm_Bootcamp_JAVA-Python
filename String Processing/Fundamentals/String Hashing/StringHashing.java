public class StringHashing {
    private int p = 31;
    final double m = 1e9+9;
    public long stringHashing (String s) {
        long hashValue = 0;
        long p_pow = 1;
        final char[] S = s.toCharArray();
        for (char c : S) {
            hashValue = (long)((hashValue + (c - 'a' +1)*p_pow)%m);
            p_pow = (long)((p_pow * p) % m);
        }
        return hashValue;
    }
    public static void main(String[] args) {
        StringHashing var = new StringHashing();
        String s = "A cat ate a rat";
        long ans = var.stringHashing(s);
        System.out.println(ans);
    }
}