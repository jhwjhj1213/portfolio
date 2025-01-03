units=float(input())

if units <= 5 :
        cost = 0.5
elif units > 5 :
        cost = 0.75
elif units < 50 :
        cost = 0.75
if units >= 50 :
        cost = 1
        
def bill_calculator (units, cost):
    if units >= 0 :
        return units * cost
    else :
        return "invalid"

print (bill_calculator (units, cost))

sandwich=["Wheat  bread","Ham","Cheese","Wheat bread"]

def get_bread_list (sandwich):
    return sandwich[0]+sandwich[-1]
def get_filling_list (sandwich):
    return sandwich[1:len(sandwich)-1]

print(get_bread_list (sandwich))
print(get_filling_list (sandwich))
