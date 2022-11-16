
def hanoi(n,a,b,c):
    #n = 1时候直接a盘到c盘退出程序
    if n == 1:
        print("{}-->{}".format(a,c))
        return
    #把上面n-1个看做一个整体借助b盘。把n-1个从a盘移动到c盘
    hanoi(n-1,a,c,b)
    #然后把最后一个从a盘移动到c盘
    print("{}-->{}".format(a,c))
    #然后把b盘上剩余中的n-1借助c盘从b盘移动到a盘
    hanoi(n-1,b,a,c)


hanoi(3,"a","b","c")
    
    