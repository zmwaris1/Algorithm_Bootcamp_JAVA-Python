class BinaryExponentiation:

    def binPow(self, base, power):
        if power == 0:
            return 1
        res = self.binPow(base, power//2)

        if (power % 2):
            return res * res * base
        return res * res
    

binEx = BinaryExponentiation()
res = binEx.binPow(3, 13)
print("The result for 3 to the power of 13 is: ", res)