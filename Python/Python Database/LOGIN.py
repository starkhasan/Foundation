"""
import sqlite3
conn=sqlite3.connect('Data.db')
print("Opened Database Successfully")
conn.execute("CREATE TABLE LOGIN(ID INT PRIMARY KEY NOT NULL,PASSWORD INT NOT NULL);")
print("Table Created successfully")
conn.close()

"""
from tkinter import *
import tkinter.messagebox

class Buttons:
    def __init__(self, master):
        self.master = master
        self.frame = Frame(self.master)
        self.b1 = Button(self.master, text="Button1", command=self.display)
        self.b2 = Button(self.master, text="Button2", command=self.new_window)
        self.b1.pack()
        self.b2.pack()
        self.a=10
        self.frame.pack()

    def display(self):
        tkinter.messagebox.showinfo("Warning", "HELLO")

    def new_window(self):
        self.master.withdraw()
        self.newWindow = Toplevel(self.master)
        if self.a>0:
            bb = Buttons1(self.newWindow)
        else:
            tkinter.messagebox.showinfo("Warning", "retry")


class Buttons1():

    def __init__(self, master):
        self.master = master
        self.frame = Frame(self.master)
        self.b3 = Button(self.master, text="Button3", command=self.display3)
        self.b3.pack()
        self.frame.pack()

    def display3(self):
        tkinter.messagebox.showinfo("Warning", "i am second window")


if __name__ == '__main__':
    root = Tk()
    b = Buttons(root)
    root.mainloop()