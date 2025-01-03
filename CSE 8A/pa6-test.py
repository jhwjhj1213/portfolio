from CSE8AImage import *
from pa6 import *

"""
RGB codes for common colors. You can add on to this
if you want to experiment with different colors.
"""
black   = (0,0,0)
white   = (255,255,255)
red     = (255,0,0)
green   = (0,255,0)
blue    = (0,0,255)
yellow  = (255,255,0)
magenta = (255,0,255)
gray    = (128,128,128)
purple  = (128,0,128)
    
def test_mirror():
    # TEST CASE:
    test_img1 = load_img("images/cat.jpg")
    # Call your mirror function here
    mirrored_image = mirror(test_img1)
    # Visualize the result by saving the image
    save_img(mirrored_image, "reversed_cat.jpg")


    


def test_add_stamp():
    # TEST CASE:
    test_img1 = load_img("images/classified.jpg")
    test_img2 = load_img("images/classified_doc.jpg")
    # Call your add_stamp function here
    stamped_result = add_stamp(test_img1,test_img2)
    # Visualize the result by saving the image
    save_img(stamped_result, "stamped_document.jpg")


"""
OPTIONAL:
You can similarly create test functions for the other functions in pa6.
"""



"""
Calling the Test functions one after the other.
You may want to uncomment one test at a time.
"""

test_mirror()
test_add_stamp()
