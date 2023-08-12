import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;
import javafx.util.Pair;

public class FibonacciNumbers {
    public int fiboNaive(int n) {
        if (n <= 0) {
            return 0;
        }
        else if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return fiboNaive(n-1) + fiboNaive(n-2);
        }
    }

    List<Long> fibList = new ArrayList<>(Arrays.asList(0L, 1L));

    public long fiboDP(int n) {
        if (n < 0) return -1;
        
        if (n < this.fibList.size()) {
            return this.fibList.get(n);
        }
        long e = (this.fiboDP(n-1)+this.fiboDP(n-2));
        this.fibList.add(e);
        return this.fibList.get(n);
    }

    public long fiboDPOptimized(int n) {
        long fn = 0;
        long fm = 1;

        if (n < 0) return -1;
        else if (n == 0) return fn;
        else if (n == 1) return fm;
        else {
            for(int i = 1; i < n; i++){
                long temp = fn;
                fn = fm;
                fm = fm + temp;
            }
        return fm;
        }
    } 

    private HashMap<Integer, Long> cache = new HashMap<>();

    public long fiboCache(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;
        else if (cache.containsKey(n)) {
            return cache.get(n);
        }
        else {
            long result = this.fiboCache(n-1) + fiboCache(n-2);
            cache.put(n, result);
            return result;
        }

    }
    

    public long fiboCF(int n) {
        if (n < 0) return -1;
        long first_term = (long) Math.pow(((1 + Math.sqrt(5)) / 2), n);
        long second_term = (long) Math.pow(((1 - Math.sqrt(5)) / 2), n);
        long res = (long) ((first_term-second_term) / Math.sqrt(5));
        return res;
    }

    private Pair<Long, Long> fiboFDM(int n) {
        if (n < 0) return {-1L, 0L};
        if (n == 0) return (0L, 1L);
        else {
            auto p = this.fiboFDM(n >> 1);
            long c = p.first * (2 * p.first - p.second);
            long d = p.first * p.first + p.second * p.second;
            if (n & 1 == true) {
                return (d, c+d);
            }
            else {
                return (c, d);
            }
        }
    }

    public long fiboFDMA(int n) {
        return fiboFDM(n)[0];
    }

    public static void main(String[] args) {
        FibonacciNumbers var = new FibonacciNumbers();
        long ans = var.fiboDP(55);
        System.out.println(ans);
        long ans2 = var.fiboDPOptimized(55);
        System.out.println(ans2);
        long ans3 = var.fiboCache(55);
        System.out.println(ans3);
        long ans4 = var.fiboCF(55);
        System.out.println(ans4);
        long ans5 = var.fiboFDMA(55);
        System.out.println(ans5);
        
    }
}
