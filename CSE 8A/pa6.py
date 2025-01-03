from CSE8AImage import *

def blend(img1, img2):
    # TODO Write the body of the function here
    result = []
    for i in range(len(img1)):
        result.append([])
        for j in range(len(img1[i])):
            res = ((float(img1[i][j][0])+float(img2[i][j][0]))/2, (float(img1[i][j][1])+float(img2[i][j][1]))/2, (float(img1[i][j][2])+float(img2[i][j][2]))/2)
            result[i].append(res)
    #save_img(result, 'vintagecat')

    # TODO Return the modified image
    return result

def mirror(img):
    # TODO Write the body of the function here
    for i in range(len(img)):
        for j in range((len(img[i])//2)):
            holder = img[i][j]
            img[i][j] = img[i][len(img[i])-1-j]
            img[i][len(img[i])-1-j] = holder
   
    return img

        
    # TODO Return the modified image
    #return modified_image

def add_stamp(stamp_image, background_image):
    # TODO Write the body of the function here
    for i in range(len(stamp_image)):
        for j in range(len(stamp_image[i])):
            background_image[i][j] = stamp_image[i][j]
    # TODO Return the modified image
    return background_image


def find_waldo(img, topLeftrow, topLeftcol, width, height):
    # TODO Write the body of the function here
    res = []
    for i in range(height):
        res.append([])
        for j in range(width):
            res[i].append(img[topLeftrow+i][topLeftcol+j])
    # TODO Return the modified image
    return res
save_img(find_waldo(load_img("images/waldo.jpg"),486,450,70,100), "found_waldo.jpg")
