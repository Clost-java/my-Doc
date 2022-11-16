import imp
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


nums = np.arange(1,101)
fig,axes = plt.subplots(2,2)
ax1 = axes[0,0]
ax2 = axes[0,1]
ax3 = axes[1,0]
ax4 = axes[1,1]
ax1.plot(nums,nums)
ax2.plot(nums,-nums)
ax3.plot(nums,nums**2)
ax4.plot(nums,np.log(nums))

plt.savefig('outPutFile/pandas01.png')