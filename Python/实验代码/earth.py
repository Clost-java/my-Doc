import math
# （1）计算地球表面积（表面积公式S = 4πR2）
# （2）计算地球体积（体积公式是V = 4πR3/3）
# （3）计算地球赤道的周长（圆周长公式是L = 2πR）
# （4）假设有一根绳子正好可以紧贴地球绕赤道一周，紧密的捆绑住地球。现在将绳子延长1米，
# 仍围绕地球赤道一周，假设绳子与地球表面间空隙均匀，计算绳子与地球之间的空隙大小。
# 判断一只正常大小的老鼠能否从这个空隙穿过？
# 提示：
# 可假设老鼠身体截面为圆柱，且圆柱最粗处直径为10cm，
# 若空隙大小10cm，输出：“老鼠可以从空隙中钻过”，
# 否则输出：“老鼠无法通过空隙”。根据判定结果进行输出时，
# 可以用if条件表达式进行判定，满足条件时的输出放在if分支下的缩进语句块中；
# 不满足条件的输出放在与if对
radius = 6371 * 1000
Pi = math.pi 

#表面积
def area(r):
    return 4 * Pi * r * r

#体积
def volume(r):
    return 4 * Pi * pow(r,3) / 3

#周长
def perimeter(r):
    return 2 * Pi * r

#
def mouse(r):
    if (r - (perimeter(r) + 1) / 2 / Pi) > 0.1:
        res = "老鼠能穿过"
    else:
        res = "老鼠不能穿过"
    return  res

print("地球表面积为{}平方米".format(area(radius)))
print("地球体积为{}立方米".format(volume(radius)))
print("地球赤道周长为{}米".format(perimeter(radius)))
print(mouse(radius))