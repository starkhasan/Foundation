from random import randint
import sqlite3
conn=sqlite3.connect("test.db")
class Error(Exception):
    pass
class Passwordlength(Error):
    pass
class aadharlength(Error):
    pass
class agevalidation(Error):
    pass
class verify_aadhar(Error):
    pass

#CREATING ACCOUNT
def create_account(a):
    print("\n     -------:: Please enter your details ::-------")
    n = 8
    start = 10 ** (n - 1)
    end = (10 ** n) - 1
    new_id = randint(start, end)
    name = gender = address = ""
    age = aadhar = password = int_balance = 0
    print()
    try:
        name = input("     Name     :  ")
        age = int(input("     Age      :  "))
        if(age<18):
            raise agevalidation
        gender = input("     Gender   :  ")
        address = input("     Address  :  ")
        aadhar = int(input("     Aadhar Number  :  "))
        adr_len=len(str(aadhar))
        if (adr_len<12) or (adr_len>12):
            raise aadharlength
        password = int(input("     Password :  "))
        pass_len=len(str(password))
        if (pass_len<6):
            raise Passwordlength
    except ValueError:
        print("\n     Please enter valid input   ")
        create_account(a)
    except agevalidation:
        print("\n     Your age must be greater than or equal to 18 ")
        create_account(a)
    except Passwordlength:
        print("\n     Length of password must be more than 6 ")
        create_account(a)
    except aadharlength:
        print("\n     Invalid Aadhar number, Length must be 12  ")
        create_account(a)

    #NOW VARIFICATION FOR THE EXISTING ACCOUNT
    ver_adr=0
    try:
        cursor = conn.execute("SELECT AADHAR FROM DETAILS WHERE NAME=(?)", (name,))
        for row in cursor:
            ver_adr = row[0]
        if (ver_adr==aadhar):
            raise verify_aadhar
    except verify_aadhar:
        print("\n     Sorry! Account already exist ")
        create_account(a)

    #NOW INSERTING THE ACCOUNT DETAILS OF THE USER IN THE DATABASE

    conn.execute("INSERT INTO DETAILS VALUES(?,?,?,?,?,?,?)", (new_id, name, age, gender, address, aadhar, int_balance))
    conn.commit()
    print("\n     ------ :: Account Successfully created your Account ID : ", new_id)
    conn.execute("INSERT INTO LOG VALUES(?,?)", (new_id, password))
    conn.commit()
    main()


def access_account(c):
    print("\n     -----------:: Choose your operation ::------------  \n")
    print("     1. Check Balance")
    print("     2. Withdrawal")
    print("     3. Deposite")
    print("     4. Change Password")
    print("     5. Exit")
    print()
    option = int(input("     Enter option  :: "))
    if(option==1):
        init_balance = 0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            init_balance = row[0]
        print("\n     Your current Balance :: ",init_balance)
        access_account(c)
    elif (option==2):
        amount_withdraw=int(input("\n     Enter Amount :: "))
        aval_balance=0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            aval_balance = row[0]
        if(amount_withdraw > aval_balance):
            print("\n     Insufficient Balance  ")
            access_account(c)
        else:
            aval_balance = aval_balance - amount_withdraw
            print("\n     Remaining Balance :: ",aval_balance)
            conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(aval_balance,c))
            conn.commit()
            access_account(c)
    elif (option==3):
        dep_amount = int(input("\n     Enter Amount :: "))
        aval_balance = 0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            aval_balance = row[0]
        aval_balance = aval_balance + dep_amount
        print("\n     Available Balance :: ",aval_balance)
        conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(aval_balance,c))
        conn.commit()
        access_account(c)
    elif (option==4):
        old_pass1 = int(input("\n     Enter old Password :: "))
        old_pass = 0
        cursor = conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(c,))
        for row in cursor:
            old_pass = row[0]
        if(old_pass!=old_pass1):
            print("\n     XXXX: Worng Password :XXXX")
            access_account(c)
        else:
            #TAKING NEW PASSSWORD FROM USER TO CHANGE
            new_pass = 0
            try:
                new_pass = int(input("\n     Enter new password :: "))
                if (len(str(new_pass))<6):
                    raise Passwordlength
            except Passwordlength:
                print("\n     Length of password must be greater then  6  ")
                access_account(c)
            except ValueError:
                print("\n     Enter valid password  ")
                access_account(c)
            conn.execute("UPDATE LOG SET PASSWORD=(?) WHERE ID=(?)",(new_pass,c))
            conn.commit()
            print("\n     Password successfully updated :: ")
            access_account(c)
    elif (option==5):
        print("\n\n\n                           ^^^^  Thank you for visit   ^^^^     \n\n")
        exit()
    else:
        print("\n      ::  Wrong Input  ::  ")
        main()



def having_account(b):
    print("\n     ------------:: Welcome ::-------------  ")
    id_1 = 0
    pass_1 = 0
    user_id = int(input("\n     Enter ID :: "))
    user_pass = int(input("\n     Enter Password :: "))
    cursor = conn.execute("SELECT ID FROM LOG WHERE PASSWORD=(?)",(user_pass,))
    for row in cursor:
        id_1 = row[0]

    cursor = conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(user_id,))
    for row in cursor:
        pass_1 = row[0]

    if(id_1==user_id)and(pass_1==user_pass):
        access_account(id_1)
    else:
        having_account(b)

#MAIN BODY

def main():
    print("\n     --------------------:: WELCOME TO IRON BANK OF INDIA ::-------------------  ")
    print("\n     1. New Account \n     2. Already have an Account \n     3. Exit")
    try:
        n = int(input("\n     Choose your option ::  "))
        if n==1:
            create_account(n)
        elif n==2:
            having_account(n)
        else:
            print("\n\n\n            /\/\/\/\/\ Thank for visit, Have a nice day. /\/\/\/\/\/\      \n\n")
            exit()
    except ValueError:
        print("\n\n     XXX  Invalid Input  XXX\n")
        main()

main()

# Account ID -> 52342246
# Password -> 12345678
