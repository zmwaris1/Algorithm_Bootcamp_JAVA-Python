package SieveOfEratosthenes;
import java.util.ArrayList;

public class SieveOfEratosthenes {

    public ArrayList<Integer> sieveOfEratosthenes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] prime = new boolean[n+1];
        for(int i=0; i<=n; i++){
            prime[i] = true;
        }
        for (int p = 2; p*p<=n; p++){
            if (prime[p]) {
                for(int i=p*p; i<=n; i+=p){
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]){
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes var = new SieveOfEratosthenes();
        int n = 50;
        ArrayList<Integer> ans;
        ans = var.sieveOfEratosthenes(n);
        System.out.println(ans);
    }
}