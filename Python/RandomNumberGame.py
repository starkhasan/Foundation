import random
class Error(Exception):
    pass
class ValueTooLargeError(Error):
    pass
class ValueTooSmallError(Error):
    pass
def Game():
    number=random.randint(0,10)
    i=0
    chance = 2
    first = 0
    last = 10
    while i<chance:
        
        try:
            i=i+1
            print("You have ",chance-i+1," Chance ")
            user_choice = int(input("Guess a Number Between {0} - {1} = ".format(first,last)))
            if user_choice < number:
                raise ValueTooSmallError
            elif user_choice > number:
                raise ValueTooLargeError
            break
        except ValueTooSmallError:
            print("This value was too small, try again!")
            first = user_choice + 1
            print()
        except ValueTooLargeError:
            print("This value was too large, try again!")
            last = user_choice - 1
            print()
        except ValueError:
            print("Wrong Input Please Enter Number")
            i=i-1
            print()
        
    if user_choice==number:
        print("Congratulations! You guessed it correctly.")
        choose_game()
    else:
        print("Sorry You Loose!")
        print("The Correct Number was ",number)
        choose_game()


def choose_game():
        user_chioce=input("\nDo you want to Play Again (Y/N) ")
        if user_chioce=="Y" or user_chioce=="y" or user_chioce=="yes" or user_chioce=="YES" or user_chioce=="Yes":
            print("\nWelcome Back to Luck by Chance Game")
            Game()
        else:
            print("Thank you have a Nice Day !")


user_chioce=input("Do you want to Play Game (Y/N) ")
if user_chioce=="Y" or user_chioce=="y" or user_chioce=="yes" or user_chioce=="YES" or user_chioce=="Yes":
    print("\nWelcome to Luck by Chance Game\n")
    Game()
else:
    print("Thank you have a Nice Day !")