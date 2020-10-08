"""
import sqlite3
conn=sqlite3.connect("Data.db")
print("Opened DataBase Successfully")
conn.close()
"""
"""
import sqlite3
conn=sqlite3.connect("Data.db")
print("Opened DataBase Successfully")
conn.execute("CREATE TABLE EMP(EMPID INT,EMPNAME CHAR(50),EMPSLARY INT)")
conn.close()
"""
"""
import sqlite3
conn=sqlite3.connect("Data.db")
print("Opened Database Successfully")
user_id=int(input("Enter ID"))
user_name=input("Enter Name")
user_salary=int(input("Enter Salary"))
conn.execute("INSERT INTO EMP VALUES(?,?,?)",(user_id,user_name,user_salary))
conn.commit()
print("Data Inserted Successfully")
conn.close()
"""
"""
import  sqlite3
conn=sqlite3.connect("Data.db")
print("Opened DataBasae Successfully")
cursor=conn.execute("SELECT EMPID,EMPNAME,EMPSLARY FROM EMP")
for i in cursor:
    print("ID: ",i[0])
    print("NAME: ",i[1])
    print("SALARY: ",i[2])
    print()
conn.commit()
print("Operation Performedd Successfully")
conn.close()
"""

import sqlite3
conn=sqlite3.connect("Data.db")
print("-------:Welcome To IronBank:-------")
conf='Y'
print("Do you have any Account in Iron Bank Y/N\n")
conf1=input()
if(conf==conf1):
    id=int(input("Enter ID: "))
    password=int(input("Enter Password: "))
    aadhar=int(input("Enter Aadhar: "))
    id1=0
    pass1=0
    cursor=conn.execute("SELECT ID FROM BANK WHERE AADHAR=(?)",(aadhar,))
    for row in cursor:
        id1=row[0]
    cursor=conn.execute("SELECT PASSWORD FROM BANK WHERE AADHAR=(?)",(aadhar,))
    for row in cursor:
        pass1=row[0]
    if(id==id1)and(password==pass1):
        print("Welcome")
        n=1
        while(n>0):
            print("What Would You Like to perform")
            print("1=>Enquiery")
            print("2=>Withdrawal")
            print("3=>Dposite")
            print("4=>Update Phone Number")
            print("Enter option: ")
            option=int(input())
            if(option==1):
                cursor=conn.execute("SELECT BALANCE FROM BANK WHERE ID=(?)",(id,))
                for row in cursor:
                    print("Balance => ",row[0])
                conf=input("Do u want to continue Y/N")
                if conf=='N':
                    print("Thank You For Visit")
                    break
            elif(option==2):
                amount=int(input("Enter Amount: "))
                cursor=conn.execute("SELECT BALANCE FROM BANK WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                if(amount>amount1):
                    print("Insufficient Balance: ")
                else:
                    amount1=amount1-amount
                    conn.execute("UPDATE BANK SET BALANCE=(?) WHERE ID=(?)",(amount1,id))
                    conn.commit()
                    print("Available Balance: ")
                    cursor=conn.execute("SELECT BALANCE FROM BANK WHERE ID=(?)",(id,))
                    for row in cursor:
                        amount=row[0]
                    print(amount)
                conf=input("Do You Want to  Continue: ")
                if conf=='N':
                    print("Thank You For Visit: ")
                    break
            elif(option==3):
                amount=int(input("Enter Amount: "))
                cursor=conn.execute("SELECT BALANCE FROM BANK WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                amount1=amount1+amount
                conn.execute("UPDATE BANK SET BALANCE=(?) WHERE ID=(?)",(amount1,id))
                conn.commit()
                cursor=conn.execute("SELECT BALANCE FROM BANK WHERE ID=(?)",(id,))
                for row in cursor:
                    amount1=row[0]
                print("Balance: ",amount1)
                conf = input("Do You Want to  Continue: ")
                if conf == 'N':
                    print("Thank You For Visit: ")
                    break
            elif(option==4):
                mob=int(input("Enter your new Phone Number"))
                conn.execute("UPDATE BANK SET PHONE=(?) WHERE ID=(?)",(mob,id))
                conn.commit()
                cursor=conn.execute("SELECT PHONE FROM BANK WHERE ID=(?)",(id,))
                for row in cursor:
                    print("New Number: ",row[0])
                conn.close()
                conf=input("Do You Want To Continue Y/N")
                if conf=='N':
                    print("Thank You For Visit: ")
                    break
            else:
                print("Invalid Input")
                break
    else:
        print("Invalid Username Password")
else:
    print("Enter Your Details:")
    id=int(input("Enter ID: "))
    name=input("Enter Name: ")
    phone=int(input("Enter Phone Number: "))
    aadhar=int(input("Enter Aadhar ID: "))
    password=int(input("Enter Password: "))
    balance=int(input("Enter Balance: "))
    conn.execute("INSERT INTO BANK VALUES(?,?,?,?,?,?)",(id,name,phone,aadhar,password,balance))
    conn.commit()
    print("Data has been Saved Successfully")
    n=int(input("Enter Your ID: "))
    cursor=conn.execute("SELECT ID,NAME,PHONE,AADHAR,PASSWORD,BALANCE FROM BANK WHERE ID=(?)",(n,))
    for row in cursor:
        print("ID: ",row[0])
        print("NAME: ",row[1])
        print("PHONE: ",row[2])
        print("AADHAR: ",row[3])
        print("PASSWORD: ",row[4])
        print("BALANCE: ",row[5])
    conn.close()

















"""


import sqlite3
conn=sqlite3.connect("Data.db")
print("Opened Database successfully")
conn.execute("CREATE TABLE BANK(ID INT,NAME CHAR(25),PHONE INT,AADHAR INT,PASSWORD INT,BALANCE INT)")
print("Table Creates Successfully")
conn.close()
"""




