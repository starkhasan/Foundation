import random
class Error(Exception):
    pass
class ValueTooLargeError(Error):
    pass
class ValueTooSmallError(Error):
    pass
class NotInRangeError(Error):
    pass
def Game():
    chance = 2
    i = first = 0
    last = 10
    original_number = random.randint(0,last)
    while i<chance:
        try:
            i=i+1
            print("You have ",chance-i+1," Chance ")
            user_number = int(input("Guess a Number Between {0} - {1} = ".format(first,last)))
            if user_number < first or user_number > last:
                raise NotInRangeError
            elif user_number < original_number:
                raise ValueTooSmallError
            elif user_number > original_number:
                raise ValueTooLargeError
            break
        except NotInRangeError:
            i = i - 1
            print('Number not in range\n')
        except ValueTooSmallError:
            first = user_number + 1
            print("This value was too small, try again!\n")
        except ValueTooLargeError:
            last = user_number - 1
            print("This value was too large, try again!\n")
        except ValueError:
            i = i-1
            print("Wrong Input Please Enter Number\n")

    if user_number == original_number:
        print("Congratulations! You guessed it correctly.")
        choose_game()
    else:
        print("Sorry You Loose!")
        print("The Correct Number was ",original_number)
        choose_game()


def choose_game():
        user_chioce = input("\nDo you want to Play Game (Y/N) ")
        if user_chioce=="Y" or user_chioce=="y" or user_chioce=="yes" or user_chioce=="YES" or user_chioce=="Yes":
            print("\nWelcome to Luck by Chance Game\n")
            Game()
        elif user_chioce=="N" or user_chioce=="n" or user_chioce=="NO" or user_chioce=="No" or user_chioce=="no" or user_chioce == "nO":
            print("Thank you have a Nice Day !")
        else:
            print("Wrong Input Please Try Again!!")
            choose_game()


user_chioce = input("Do you want to Play Game (Y/N) ").lower()
if user_chioce == "y" or user_chioce=="yes" or user_chioce=="ya" :
    print("\nWelcome to Luck by Chance Game\n")
    Game()
elif user_chioce=="n" or user_chioce=="no" :
    print("Thank you have a Nice Day !")
else:
    print("Wrong Input Please Try Again!!")
    choose_game()
