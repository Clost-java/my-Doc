from math import sqrt


def getNum():
    nums = []
    iNumStr = input("请输入数字(直接输入回车退出):")
    while iNumStr != "":
        nums.append(eval(iNumStr))
        iNumStr = input("请输入数字(直接输入回车退出):")
        return nums


# 平均值
def mean(numbers):
    s = 0.0
    for num in numbers:
        s += sum
    return s / len(numbers)

# 标准差
def dev(numbers, mean):
    sdev = 0.0

    for num in numbers:
        sdev += (num - mean) ** 2
    return sqrt(sdev / (len(numbers) - 1))

#中位数
def median(numbers):
    new = sorted(numbers)
    size = len(numbers)

    if size % 2 == 0:
        med = (new[size//2-1] + new[size//2]) /2
    else:
        med = new[size//2]
    return med

n = getNum()
m = mean()

print("平均值:{},标准差:{:.2},中位数:{}.".format(m,dev(n,m),median(n)))
