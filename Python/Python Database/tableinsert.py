import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database Successfully")
conn.execute("""INSERT INTO REGISTRATION (ID,NAME,AGE,GENDER,ADDRESS) \
             VALUES(1,'ALI',22,'M','NOIDA')""");
conn.execute("""INSERT INTO REGISTRATION (ID,NAME,AGE,GENDER,ADDRESS) \
             VALUES(2,'RAJAT',23,'M','NOIDA')""");
conn.execute("""INSERT INTO REGISTRATION (ID,NAME,AGE,GENDER,ADDRESS) \
             VALUES(3,'SACHIN',22,'M','NOIDA')""");
conn.commit()
print("Inserted Successfully")
conn.close()
