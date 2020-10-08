import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database Successfully")
conn.execute("""INSERT INTO LOGIN (ID,PASSWORD) \
             VALUES(1,12345)""");
conn.execute("""INSERT INTO LOGIN (ID,PASSWORD) \
             VALUES(2,13245)""");
conn.execute("""INSERT INTO LOGIN (ID,PASSWORD) \
             VALUES(3,15274)""");
conn.commit()
print("Inserted Successfully")
conn.close()