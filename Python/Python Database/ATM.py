"""
#CREATE TABLE OF THE DETAILS OF THE
import sqlite3
conn=sqlite3.connect("test.db")
print("Database Opened successfully")
conn.execute("CREATE TABLE DETAILS(ID INT PRIMARY KEY NOT NULL,NAME CHAR(10) NOT NULL,AGE INT NOT NULL,GENDER CHAR(2) NOT NULL,ADDRESS CHAR(10) NOT NULL,AADHAR INT NOT NULL,BALANCE INT NOT NULL)")
print("Table Created Successfully")
conn.close()
"""
"""
#CREATE TABLE OF THE LOG
import sqlite3
conn=sqlite3.connect("test.db")
print("Opened Database Successfully")
conn.execute("CREATE TABLE LOG(ID INT PRIMARY KEY NOT NULL,PASSWORD INT NOT NULL)")
print("Table Created Successfully")
conn.close()
"""

"""
class Error(Exception):
    pass
class Passwordmismatch(Error):
    pass
import time
from random import randint
import sqlite3
conn=sqlite3.connect("test.db")
print("                 -------:Welcome To IronBank:-------")
print()
conf='Y'
time_set=5
print("Do you have any Account in Iron Bank Y/N")
conf1=input()
if(conf==conf1):
    id=int(input("Enter ID: "))
    password=int(input("Enter Password: "))
    id1=0
    pass1=0
    cursor=conn.execute("SELECT ID FROM LOG WHERE PASSWORD=(?)",(password,))
    for row in cursor:
        id1=row[0]
    cursor=conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(id,))
    for row in cursor:
        pass1=row[0]
    if(id==id1)and(password==pass1):
        print("\nWelcome")
        n=1
        while(n>0):
            print("What Would You Like to perform")
            print("1=>CHECK BALANCE")
            print("2=>WITHDRAWAL")
            print("3=>DEPOSITE")
            print("4=>CHANGE PASSWORD")
            print("5=>EXIT")
            print("Enter option: ")
            option=int(input())
            if(option==1):
                cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(id,))
                for row in cursor:
                    print("Balance => ",row[0])
                conf=input("Do u want to continue Y/N")
                if conf=='N':
                    print("Thank You For Visit")
                    break
            elif(option==2):
                amount1=0
                amount=int(input("Enter Amount: "))
                cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                if(amount>amount1):
                    print("Insufficient Balance: ")
                else:
                    amount1=amount1-amount
                    conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(amount1,id))
                    conn.commit()
                    cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(id,))
                    for row in cursor:
                        amount=row[0]
                    print("Now Your Available Balance: ",amount)
                conf=input("Do You Want to  Continue: ")
                if conf=='N':
                    print("Thank You For Visit: ")
                    break
            elif(option==3):
                amount1=0
                amount=int(input("Enter Amount: "))
                cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                amount=amount+amount1
                conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(amount,id))
                conn.commit()
                cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                print("Now Your Available Balance is : ",amount1)
                conf = input("Do You Want to  Continue: ")
                if conf == 'N':
                    print("Thank You For Visit: ")
                    break
            elif(option==4):
                old_pass1=0
                while True:
                    try:
                        old_pass = int(input("Please Enter Your Old Password :- "))
                        cursor = conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)", (id,))
                        for row in cursor:
                            old_pass1 = row[0]
                        if old_pass!=old_pass1:
                            raise Passwordmismatch
                        break
                    except Passwordmismatch:
                        print("Incorrect Password")
                while True:
                    try:
                        new_pass=int(input("Enter New Password :- "))
                        break
                    except ValueError:
                        print("Required Only Numeric")
                conn.execute("UPDATE LOG SET PASSWORD=(?) WHERE ID=(?)",(new_pass,id))
                conn.commit()
                cursor=conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(id,))
                for row in cursor:
                    print("New Password: ",row[0])
                conn.close()
                conf=input("Do You Want To Continue Y/N")
                if conf=='N':
                    print("Thank You For Visit: ")
                    break
            elif(option==5):
                print("Thank You For Visit")
                break
            else:
                print("Invalid Input")
                break
    else:
        print("Invalid Username Password")
else:
    n=8
    start=10**(n-1)
    end=(10**n)-1
    new_id=randint(start,end)
    int_balance=0
    print("Please Enter Your Details : ")
    while True:
        try:
            name = input("Name : ")
            age = int(input("Age : "))
            gender = input("Gender : ")
            address = input("Address : ")
            aadhar = int(input("Aadhar : "))
            password = int(input("Password : "))
            len_pass=len(str(password))
            if len_pass<=6:
                raise Passwordmismatch
            break
        except ValueError:
            print("Please Enter Correct Input")
        except Passwordmismatch:
            print("Password Should Be Greater Than Six digits")
    conn.execute("INSERT INTO DETAILS VALUES(?,?,?,?,?,?,?)",(new_id,name,age,gender,address,aadhar,int_balance))
    conn.commit()
    print("CONGRATULATION! YOUR NEW ACCOUNT ID : ",new_id)
    conn.execute("INSERT INTO LOG VALUES(?,?)",(new_id,password))
    conn.commit()
    n=int(input("Enter Your ACCOUNT ID to view Profile : "))
    cursor=conn.execute("SELECT ID,NAME,AGE,GENDER,ADDRESS,AADHAR,BALANCE FROM DETAILS WHERE ID=(?)",(n,))
    for row in cursor:
        print("ACCOUNT ID: ",row[0])
        print("NAME      : ",row[1])
        print("AGE       : ",row[2])
        print("GENDER    : ",row[3])
        print("ADDRESS   : ",row[4])
        print("AADHAR    : ",row[5])
        print("BALANCE   : ",row[6])
    conn.close()


"""
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
    print("\n     -------:: PLEASE ENTER YOUR DETAILS ::-------")
    n = 8
    start = 10 ** (n - 1)
    end = (10 ** n) - 1
    new_id = randint(start, end)
    int_balance = 0
    name=""
    age=0
    gender=""
    address=""
    aadhar=0
    password=0
    print()
    try:
        name = input("     Name     :  ")
        age = int(input("     Age      :  "))
        if(age<18):
            raise agevalidation
        gender = input("     Gender   :  ")
        address = input("     Address  :  ")
        aadhar = int(input("     Aadhar   :  "))
        adr_len=len(str(aadhar))
        if (adr_len<12) or (adr_len>12):
            raise aadharlength
        password = int(input("     Password :  "))
        pass_len=len(str(password))
        if (pass_len<6):
            raise Passwordlength
    except ValueError:
        print("\n     PLEASE ENTER VALID INPUT   ")
        create_account(a)
    except agevalidation:
        print("\n     YOUR AGE MUST BE GREATER THAN OR EQUAL TO 18 ")
        create_account(a)
    except Passwordlength:
        print("\n     LENGTH OF PASSWORD MUST BE MORE THAN 6 ")
        create_account(a)
    except aadharlength:
        print("\n     LENGTH OF AADHAR MUST BE EQUAL TO 12  ")
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
        print("\n     ACCOUNT  ALREDY EXIST ")
        create_account(a)

    #NOW INSERTING THE ACCOUNT DETAILS OF THE USER IN THE DATABASE

    conn.execute("INSERT INTO DETAILS VALUES(?,?,?,?,?,?,?)", (new_id, name, age, gender, address, aadhar, int_balance))
    conn.commit()
    print("\n     ------ :: CONGRATULATION! YOUR NEW ACCOUNT ID : ", new_id)
    conn.execute("INSERT INTO LOG VALUES(?,?)", (new_id, password))
    conn.commit()
    main()


def access_account(c):
    print("\n     -----------:: WHAT WOULD YOU U LIKE TO PERFORM ::------------  \n")
    print("     1=>CHECK BALANCE")
    print("     2=>WITHDRAWAL")
    print("     3=>DEPOSITE")
    print("     4=>CHANGE PASSWORD")
    print("     5=>EXIT")
    print()
    option = int(input("     Enter option  :: "))


    if(option==1):
        init_balance=0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            init_balance=row[0]
        print("\n     YOUR CURRENT BALANCE :: ",init_balance)
        access_account(c)
    elif (option==2):
        amount_withdraw=int(input("\n     HOW MUCH AMOUNT DO YOU LIKE TO WITHDRAW :: "))
        aval_balance=0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            aval_balance=row[0]
        if(amount_withdraw>aval_balance):
            print("\n     INSUFFICIENT BALANCE  ")
            access_account(c)
        else:
            aval_balance=aval_balance-amount_withdraw
            print("\n     YOUR REMAINIG BALANCE :: ",aval_balance)
            conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(aval_balance,c))
            conn.commit()
            access_account(c)
    elif (option==3):
        dep_amount=int(input("\n     HOW MUCH AMOUNT DO YOU LIKE TO DEPOSITE :: "))
        aval_balance=0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(c,))
        for row in cursor:
            aval_balance=row[0]
        aval_balance=aval_balance+dep_amount
        print("\n     YOUR AVAILABLE BALANCE :: ",aval_balance)
        conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(aval_balance,c))
        conn.commit()
        access_account(c)
    elif (option==4):
        old_pass1=int(input("\n     ENTER YOUR OLD PASSWORD :: "))
        old_pass=0
        cursor=conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(c,))
        for row in cursor:
            old_pass=row[0]
        if(old_pass!=old_pass1):
            print("\n     XXXX: WORNG PASSWORD :XXXX")
            access_account(c)
        else:
            #TAKING NEW PASSSWORD FROM USER TO CHANGE
            new_pass=0
            try:
                new_pass = int(input("\n     ENTER THE NEW PASSWORD :: "))
                if (len(str(new_pass))<6):
                    raise Passwordlength
            except Passwordlength:
                print("\n     LENGTH OF PASSWORD MUST BE GREATER THAN  6  ")
                access_account(c)
            except ValueError:
                print("\n     PLEASE ENTER VALID PASSWORD  ")
                access_account(c)
            conn.execute("UPDATE LOG SET PASSWORD=(?) WHERE ID=(?)",(new_pass,c))
            conn.commit()
            print("\n  YOU HAVE SUCCESSFULLY CHANGED YOUR PASSWORD :: ")
            access_account(c)
    elif (option==5):
        print("\n\n\n                           ^^^^  THANK YOU FOR VISIT   ^^^^     \n\n")
        exit()
    else:
        print("\n      ::  WORNG INPUT  ::  ")
        main()



def having_account(b):
    print("\n     ------------:: PLEASE ENTER YOU ID AND PASSWORD ::-------------  ")
    id_1=0
    pass_1=0
    user_id=int(input("\n     ENTER ID ::"))
    user_pass=int(input("\n     ENTER PASSWORD ::"))
    cursor=conn.execute("SELECT ID FROM LOG WHERE PASSWORD=(?)",(user_pass,))
    for row in cursor:
        id_1=row[0]

    cursor=conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)",(user_id,))
    for row in cursor:
        pass_1=row[0]

    if(id_1==user_id)and(pass_1==user_pass):
        access_account(id_1)
    else:
        having_account(b)

#MAIN BODY

def main():
    print("\n     --------------------:: WELCOME TO IRON BANK OF INDIA ::-------------------  ")
    print("\n     1. CREATE A NEW ACCOUNT \n     2. ALREADY HAVE AN ACCOUNT \n     3. EXIT")
    try:
        n=int(input("\n     CHOOSE WHAT WOULD YOU YOU LIKE TO PERFORM ::  "))
        if n==1:
            create_account(n)
        elif n==2:
            having_account(n)
        else:
            print("\n\n\n            /\/\/\/\/\ THANK YOU FOR VISIT HAVE A NICE DAY /\/\/\/\/\/\      \n\n")
            exit()
    except ValueError:
        print("\n\n     XXX  PLEASE ENTER VALID INPUT  XXX\n")
        main()

main()


