"""
import sqlite3
conn = sqlite3.connect('test.db')
print("Opened database successfully")
cursor = conn.execute("SELECT id, name,age, address, salary from COMPANY")
print(type(cursor))
for row in cursor:
   print("ID = ", row[0])
   print("NAME = ", row[1])
   print("AGE = ",row[2])
   print("ADDRESS = ", row[3])
   print("SALARY = ", row[4], "\n")
print("Operation done successfully")
conn.close()

Following Python program shows how to fetch and display records from the COMPANY table created in the above example.
"""
import sqlite3
conn=sqlite3.connect("test.db")
print("Opened Database successfully")
age=32
cursor=conn.execute("SELECT AGE FROM COMPANY WHERE ID=(?)",(age,))
for row in cursor:
    print(row[0])
conn.commit()
print("Operation perform Successfully")
conn.close()
