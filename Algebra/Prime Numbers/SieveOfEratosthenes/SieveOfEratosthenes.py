class SieveOfEratosthenes:
    def __init__(self):
        self.primes = []
        self.prime = []

    def sieveOfEratosthenes(self, n):
        self.prime = [True for i in range(n + 1)]

        p = 2
        while p * p <= n:
            if self.prime[p] == True:
                for i in range(p * p, n + 1, p):
                    self.prime[i] = False

            p += 1

        for p in range(2, n + 1):
            if self.prime[p]:
                self.primes.append(p)
        print(self.prime)
        return self.primes


var = SieveOfEratosthenes()
ans = var.sieveOfEratosthenes(50)
print(ans)
