import math
factor = 0.01
def dayup(factor):
    basic = 1.0
    for i in range(365):
        if(i % 7 in [6,0] ):
            basic *= 1 - factor
        else:
            basic *= 1 + factor
    return basic
while (dayup(factor) < math.pow(1.01,365)):
        factor += 0.01
print(factor)





