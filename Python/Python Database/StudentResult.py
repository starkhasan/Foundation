class Error(Exception):
    pass
class Resultmismatch(Error):
    pass
import tkinter as tk
import sqlite3
conn=sqlite3.connect("test.db")
root=tk.Tk()
root.title("Student Result")
list1=[]
list2=[1,2,3,4,5,6,7,8]
def print_data(roll_number):
    try:
        cursor=conn.execute("SELECT SEM1,SEM2,SEM3,SEM4,SEM5,SEM6,SEM7,SEM8 FROM STUMARKS WHERE ROLLNO=(?)",(roll_number))
        list1(cursor.fetchall())
        raise Resultmismatch
    except Resultmismatch:
        tkinter.messagebox.showinfo("Invalid Roll Number")



