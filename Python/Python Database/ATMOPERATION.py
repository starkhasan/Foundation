import sqlite3
conn=sqlite3.connect("test.db")
from tkinter import *

class ATMOPERATION:
    def __init__(self,master):
        self.master=master

        self.left = Frame(master, width=800, height=720, bg='gray')
        self.left.pack(side=LEFT)

        #MAKING OF ENTRY
        self.withdrawal_ent=Entry(self.left,width=20)
        self.withdrawal_ent.place(x=70,y=105)

        self.deposit_ent=Entry(self.left,width=20)
        self.deposit_ent.place(x=70,y=162)

        self.changepass_ent=Entry(self.left,width=20)
        self.changepass_ent.place(x=70,y=225)


        #MAKING BUTTON FOR THE WITHDRAWAL DEPOSITE  CHANGEPASSWORD AND EXIT
        self.with_sub=Button(self.left,text="WITHDRAWAL",font=("arial 10 bold"),fg="white",bg="steelblue",width=20,height=1,command=self.withdrawal)
        self.with_sub.place(x=250,y=100)

        self.dep_sub=Button(self.left,text="DEPOSIT",font=("arial 10 bold"),fg="white",bg="steelblue",width=20,height=1)
        self.dep_sub.place(x=250,y=160)

        self.pass_sub=Button(self.left,text="CHANGE PASSWORD",font=("arial 10 bold"),fg="white",bg="steelblue",width=20,height=1)
        self.pass_sub.place(x=250,y=220)

        self.exit_sub=Button(self.left,text="EXIT",font=("arial 10 bold"),fg="white",bg="steelblue",width=20,height=1)
        self.exit_sub.place(x=150,y=280)

    def withdrawal(self):
        self.val1=self.withdrawal_ent.get()
root=Tk()
b=ATMOPERATION(root)
root.title("TRANSACTION OPERATION")
root.resizable(False,False)
root.geometry("480x360")
root.mainloop()
