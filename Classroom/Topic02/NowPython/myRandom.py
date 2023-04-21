class Random:
    def __init__(self, seed = None) -> None:
        self.m = 843314861
        self.a = 453816693
        self.p = 2147483648

        if seed == None:
            self.xi = 1025
        else:
            self.xi = seed


    def getRand(self):
        return (self.a + self.m * self.xi ) % self.p

    def getIntRand(self):
        pass