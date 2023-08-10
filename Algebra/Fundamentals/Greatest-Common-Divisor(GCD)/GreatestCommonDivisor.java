public class GreatestCommonDivisor {
    public static void swap(int a, int b){
        a = a - b;
        b = a + b;
        a = b - a;
    }

    public int gcd(int a, int b) {
        while (b > 0){
            a %= b;
            swap(a, b);
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 8;
        GreatestCommonDivisor var = new GreatestCommonDivisor();
        int res = var.gcd(a, b);
        System.out.println("The required GCD for the given numer is: " + res);
    }
}
