class GreatestCommonDivisor:
    def gcd(self, a, b):
        while b:
            a %= b
            a, b = b, a
        return a


ans = GreatestCommonDivisor()
res = ans.gcd(10, 8)
print("The gcd for given number is: ", res)
