def make_board (non_perishable_food, fruits, vegetables) :
    new_list = []
    for i in non_perishable_food :
        for j in fruits:
            for k in vegetables:
                new_list.append(i + "," + j + "," + k)
    return new_list

def is_legitimate_pool (pool) :
    row, column = len(pool), len(pool[0])

    if 1 in pool[0][0:column] :
        return "Illegitimate"
    elif 1 in pool[0:row][0] :
        return "Illegitimate"
    elif 1 in pool[row-1][0:column] :
        return "Illegitimate"
    elif 1 in pool[0:row][column-1] :
        return "Illegitimate"
    else :
        return "Legitimate"

def negative (img) :
    negative1 = []
    for i in range(len(img)) :
        row = []
        for j in range(len(img[i])) :
            pixel = img[i][j]
            pixel = (255 - pixel[0], 255 - pixel[1], 255 - pixel[2])
            row.append(pixel)
        negative1.append(row)
    return negative1

def complement (img) :
    complement1 = []
    for i in range(len(img)) :
        row = []
        for j in range(len(img[i])) :
            pixel = img[i][j]
            pixel = (pixel[2], pixel[1], pixel[0])
            row.append(pixel)
        complement1.append(row)
    return complement1
