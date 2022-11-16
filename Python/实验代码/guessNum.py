from random import *

def guess():
    guessNum = randint(0,100)
    #10次猜的机会
    guessCounter = 0
    
    while True:

        if guessCounter >= 3:
            print("很遗憾，次数用尽,正确答案是{}".format(guessNum))
            break

        guessCounter += 1

        try:
            inputNum = int(input("请输入你要猜的数"))
        except :
            print("ERROR!!!!输入的不是整数")
            return

        if inputNum > guessNum:
            print("猜大了")
        elif inputNum < guessNum:
            print("猜小了")
        else:
            print("恭喜你经过{}次猜对了".format(guessCounter))
            break
        
        
        
    
guess()


    