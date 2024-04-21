
def display_board(board):
    count = 0
    for index in range(1, len(board)):
        if count < 2:
            count+=1
            print(board[index], end='|')
        else:
            print(board[index])
            count = 0
            

#Step 1
test_board = ['#','X','O','X','O','X','O','X','O','X']
display_board(test_board)


#Step 2
def player_input():
    # marker = ''
    # while not (marker == 'X' and marker == 'O'):
    #     marker = input("Player: choose X or O:").upper()
    marker = input("Player: choose X or O:").upper()
    if marker == 'X':
        return ('X','O')
    else:
        return ('O','X')

#Step 3
def place_marker(board, marker, position):
    board[position] = marker


#Step 4
def win_check(board, marker):
    #WIN TIC TAC TOE

    return  ((board[7] == marker and board[8] == marker and board[9] == marker) or
             (board[4] == marker and board[5] == marker and board[6] == marker) or
             (board[1] == marker and board[2] == marker and board[3] == marker) or
             (board[7] == marker and board[4] == marker and board[1] == marker) or
             (board[8] == marker and board[5] == marker and board[2] == marker) or 
             (board[9] == marker and board[6] == marker and board[3] == marker) or
             (board[7] == marker and board[5] == marker and board[3] == marker) or
             (board[9] == marker and board[5] == marker and board[1] == marker))


#Step 5
import random

def choose_first():
    flip = random.randint(0,1)
    if flip == 0:
        return 'Player 1'
    else:
        return 'Player 2'
    

#Step 6
def space_check(board, position):
    return board[position] == ''


#Step 7
def full_board_check(board):
    for i in range(1, 10):
        if space_check(board, i):
            return False
    return True


#Step 8
def player_choice(board):
    position = 0
    print(space_check(board, position))
    while position not in [1,2,3,4,5,6,7,8,9] or not space_check(board, position):
        position = int(input('Choose a position: (1-9) '))
    return position

#Step 9
def replay():
    choice = input('Play again? yes or no')
    return choice =='Yes'


#Step 10
print('Welcome to TIC TAC TOE')

while True:
    the_board = [' ']*10
    player1_marker, player2_marker = player_input()

    turn = choose_first()

    print(turn + ' will go first')

    play_game = input('Ready to play? Yes or No')

    if play_game == 'YES':
        game_on  = True
    else:
        game_on = False

    while game_on:

        if turn == 'Player1':
            #show board
            display_board(the_board)
            #choose a position
            position = player_choice(the_board)
            #Place the marker on the position
            place_marker(the_board, player1_marker, position)
            #check if they won
            if win_check(the_board, player1_marker):
                display_board(the_board)
                print('Player1 won')
                game_on = False
            elif full_board_check(the_board):
                    display_board(the_board)
                    print('Game TIE')
                    game_on = False
            else:
                turn = 'Player 2'
        else:
            #show board
            display_board(the_board)
            #choose a position
            position = player_choice(the_board)
            #Place the marker on the position
            place_marker(the_board, player2_marker, position)
            #check if they won
            if win_check(the_board, player2_marker):
                display_board(the_board)
                print('Player2 won')
                game_on = False
            elif full_board_check(the_board):
                    display_board(the_board)
                    print('Game TIE')
                    game_on = False
            else:
                turn = 'Player 1'
    if not replay():
        break

            