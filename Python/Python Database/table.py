import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database Successfully")
conn.execute("CREATE TABLE REGISTRATION(ID INT PRIMARY KEY NOT NULL,NAME TEXT NOT NULL,AGE INT NOT NULL,GENDER CHAR(10) NOT NULL,ADDRESS CHAR(50) NOT NULL);")
print("Table Created successfully")
conn.close()
