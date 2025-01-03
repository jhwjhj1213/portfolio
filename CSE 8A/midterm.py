def how_comfortable (temperature) :
    if temperature > 72 :
        return "The temperature is too hot!"
        
    elif temperature >= 68 and temperature <= 72 :
        return "The temperature is just right!"

    elif temperature < 68 :
        return "The temperature is too cold!"

def average_name_length(names) :
    i = 0
    sumname = 0
    
    while len(names) > 0 and i < len(names) :
        sumname += len(names[i])
        i += 1


    if len(names) > 0 :
        return sumname / len(names)

    else :
        return 0

def create_username (name) :
    fullname = name.lower().split(" ")
    first_name = fullname[0]
    surname = fullname [1]

    first_letter = first_name[0]
    four_letters = surname [0:4]

    username = first_letter + four_letters
    
    if len(username) < 5 :
        while len(username) < 5 :
            username += '0'
        return username

    else :
        return username
