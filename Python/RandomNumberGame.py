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
    num=2
    while i<num:
        try:
            i=i+1
            print("You have ",num-i+1," Chance ")
            i_num = int(input("Guess a Number Between 0 -10 = "))
            if i_num < number:
                raise ValueTooSmallError
            elif i_num > number:
                raise ValueTooLargeError
            break
        except ValueTooSmallError:
            print("This value is too small, try again!")
            print()
        except ValueTooLargeError:
            print("This value is too large, try again!")
            print()
        except ValueError:
            print("Wrong Input Please Enter Number")
            i=i-1
            print()
        
    if i_num==number:
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