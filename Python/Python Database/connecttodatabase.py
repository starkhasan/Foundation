import sqlite3
conn = sqlite3.connect('test.db')
print("Opened database successfully")
"""
Following Python code shows how to connect to an existing database. If the database does not exist,
then it will be created and finally a database object will be returned.
"""