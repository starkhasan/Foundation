import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database successfully")
cursor=conn.execute("SELECT NAME,AGE,GENDER,ADDRESS,PASSWORD FROM REGISTRATION R,LOGIN L WHERE R.ID=L.ID")
for row in cursor:
    print("Name = ",row[0])
    print("AGE = ", row[1])
    print("GENDER = ", row[2])
    print("ADDRESS = ", row[3])
    print("PSSWORD = ",row[4])
print("Operation Done Successfully")
conn.close()

