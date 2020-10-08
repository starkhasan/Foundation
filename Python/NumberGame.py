import random as rand

original_list = []
user_list=[]
isCorrect = True
size = int(input('Enter the Size of List  '))
for i in range(size):
    original_list.append(rand.randint(1,10))

def user_list_fun():
    new_user_list=[]
    for i in range(size):
        new_user_list.append(int(input()))
    
    for i in new_user_list:
        if i in original_list:
            isCorrect=True
        else:
            isCorrect=False
            break
    
    if isCorrect:
        return new_user_list
    else:
        print('Please Enter Correct List : ')
        user_list_fun()

    
print('\nChoose List Number From this List ',original_list)
machine_number = rand.sample(original_list,len(original_list))
print('Enter your List : ')
user_list = user_list_fun()

if user_list == machine_number:
    print('You Won')
else:
    print('You Loss')

print('Game List ',machine_number)