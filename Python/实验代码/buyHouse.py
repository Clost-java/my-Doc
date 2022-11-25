

import math
#房子总价，首付占比，当前存款，年薪，月供占工资百分比
total_cost = float(input("请输入房子的总价"))
portion_down_payment = 0.3
current_savings = 0
annual_salary = float(input("请输入你的年薪"))
portion_saved = float(input("请输入你每月拿出工资的百分比")) /100

print('首付',round(total_cost * portion_down_payment,2))
print('月存款',round(annual_salary / 12 * portion_saved,2))

number_of_months = math.ceil(total_cost * portion_down_payment / (annual_salary / 12 * portion_saved))
print(f'需要{number_of_months}个月可以存够首付')
