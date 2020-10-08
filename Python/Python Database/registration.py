import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database Successfully")
conn.close()
