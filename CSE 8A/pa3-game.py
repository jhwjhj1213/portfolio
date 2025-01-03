import random
secret_number = random.randint(1,100)
guess = 0
attempt = int(input("Enter the number of attempt(s) you wish to have. : "))
used_attempt = 0

while guess != secret_number and attempt - used_attempt != 0 :
    guess=int(input("Take a guess : "))
    used_attempt += 1

    if guess > secret_number :
        print("Your guess is too high. You have "+str(attempt-used_attempt)+"attept(s).")

    elif guess < secret_number :
        print("Your guess is too low. You have "+str(attempt-used_attempt)+"attempt(s).")

    else :
        print("Congratulations!")

print ("You have now used all the attempt(s). The answer is  " + str(secret_number))
