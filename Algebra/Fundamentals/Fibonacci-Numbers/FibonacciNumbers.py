## In this code there are multiple implementations of Fibonacci Sequence, please read carefully to understand the implementations.

## 1. Recursion method. This method uses recursion tree and uses memory to store the results. So it is slower with time complexity O(2^(n)) and space comlexity O(n).


def fibo(n):
    if n < 0:
        return "Inuput positive number"
    if n == 0:
        return 0
    elif n == 1 or n == 2:
        return 1
    else:
        return fibo(n - 1) + fibo(n - 2)


print(fibo(9))

## 2. Using DP. This method is more fast than the previous one as this uses an array to results of the previous calculation with O(n) time and space complexity.


class FiboDP:
    fibList = [0, 1]

    def fibo(self, n):
        if n < 0:
            return "n should be positive."
        elif n < len(self.fibList):
            return self.fibList[n]
        else:
            self.fibList.append(self.fibo(n - 1) + self.fibo(n - 2))
            # for i in range(len(self.fibList)):
            #     print(self.fibList[i])
            return self.fibList[n]


f = FiboDP()
ans = f.fibo(55)
print(ans)


## 3. This method uses DP too but the space complexity is reduced since the list has been removed. Time Complexity O(n) Space Complexity O(1).
class fiboDPOptimized:
    def fibo(self, n):
        fn = 0
        fm = 1

        if n < 0:
            return "Enter positive values."
        elif n == 0:
            return fn
        elif n == 1:
            return fm
        else:
            for _ in range(1, n):
                fn, fm = fm, fn + fm
            return fm


fO = fiboDPOptimized()
ans = fO.fibo(55)
print(ans)

## 4. Using Caching. Time Complexity O(n), Space Complexity O(n)


class fiboCache:
    from functools import lru_cache

    @lru_cache(None)
    def fibo(self, n):
        if n < 0:
            return "Positive numbers only."
        if n <= 1:
            return n
        return self.fibo(n - 1) + self.fibo(n - 2)


fc = fiboCache()
ans = fc.fibo(55)
print(ans)

## 5. Fibonacci sequence using Backtracking. Time Complexity O(n), Space Complexity O(n)


class fiboBT:
    def fibo(self, n, dic={0: 0, 1: 1}):
        if n < 0:
            return "Wrong Input. Positive numbers only."
        elif n in dic:
            return dic[n]
        else:
            dic[n] = self.fibo(n - 1) + self.fibo(n - 2)
        return dic[n]


fb = fiboBT()
ans = fb.fibo(55)
print(ans)

## More Faster way to calculate Fibonacci numbers

##6. Closed form epression


class fiboCF:
    import math

    def fibo(self, n):
        first_term = self.math.pow(((1 + self.math.sqrt(5)) / 2), n)
        second_term = self.math.pow(((1 - self.math.sqrt(5)) / 2), n)
        res = (first_term - second_term) / self.math.sqrt(5)
        return int(res)


fCF = fiboCF()
ans = fCF.fibo(55)
print(ans)

## 7. Fast Doubling Method. Time Complexity = O(logn), Space Complexity = O(n).
## Fastest and accurate method.

class fiboFDM:
    def __fibo(self, n):
        if n < 0:
            return "Positive numbers only."
        if n == 0:
            return (0, 1)
        else:
            a, b = self.__fibo(n >> 1)
            c = a * (2 * b - a)
            d = a * a + b * b
            if n & 1:
                return (d, c + d)
            return (c, d)

    def fibo(self, n):
        return self.__fibo(n)[0]

fFDM = fiboFDM()
ans = fFDM.fibo(55)
print(ans)