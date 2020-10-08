"""from random import randint
from tkinter import*
import sqlite3
conn=sqlite3.connect("test.db")
import tkinter.messagebox

class ATM:
    def __init__(self,master):
        self.master=master

        self.left = Frame(master, width=800, height=720, bg='gray')
        self.left.pack(side=LEFT)

        # labels for the window
        self.heading = Label(self.left, text="Account Details", font=('arial 25 italic'), fg='white',bg='gray')
        self.heading.place(x=120, y=40),

        # NAME
        self.name = Label(self.left, text="Name", font=('arial 18 italic'), fg='white', bg='gray')
        self.name.place(x=80, y=140)

        #AGE
        self.age=Label(self.left,text="Age",font=('arial 18 italic'),fg="white",bg="gray")
        self.age.place(x=80,y=180)

        #GENDER
        self.gender=Label(self.left,text="Gender",font=("arial 18 italic"),fg="white",bg="gray")
        self.gender.place(x=80,y=220)

        #ADDRESS
        self.address=Label(self.left,text="Address",font=("arial 18 italic"),fg="white",bg="gray")
        self.address.place(x=80,y=260)

        #AADHAR
        self.aadhar=Label(self.left,text="Aadhar",font=("arial 18 italic"),fg="white",bg="gray")
        self.aadhar.place(x=80,y=300)

        #PASSWORD
        self.password=Label(self.left,text="Password",font=("arial 18 italic"),fg="white",bg="gray")
        self.password.place(x=80,y=340)


        #for entering the value

        #NAME
        self.name_entry=Entry(self.left,width=25)
        self.name_entry.place(x=250,y=145)

        #AGE
        self.age_entry=Entry(self.left,width=25)
        self.age_entry.place(x=250,y=185)

        #GENDER
        self.gender_entry=Entry(self.left,width=25)
        self.gender_entry.place(x=250,y=225)

        #ADDRESS
        self.address_entry=Entry(self.left,width=25)
        self.address_entry.place(x=250,y=265)

        #AADHAR
        self.aadhar_entry=Entry(self.left,width=25)
        self.aadhar_entry.place(x=250,y=305)

        #BALANCE
        self.password_entry=Entry(self.left,width=25)
        self.password_entry.place(x=250,y=345)

        #SAVE BUTTON
        self.submit=Button(self.left,text="Save",font=("arial 13 italic"),fg="white",bg="steelblue",width=10,height=1,command=self.submission)
        self.submit.place(x=180,y=390)

    def submission(self):
        self.val1 = self.name_entry.get()
        self.val2 = self.age_entry.get()
        self.val3 = self.gender_entry.get()
        self.val4 = self.address_entry.get()
        self.val5 = self.aadhar_entry.get()
        self.val6 = self.password_entry.get()

        #GET VALUE FROM THE LABEL TO STORE IN THE DIFFERENT VARIABLE

        #INITIAL BALANCE
        init_balance=0
        self.val7=init_balance

        #RANDOM ACCOUNT GENERATE
        n=8
        start=10**(n-1)
        end=(10**n)-1
        user_id=randint(start,end)
        self.val8=user_id




        #NOW STORING THAT VALUE IN THE DATABASE USING SQL QUERY
        if self.val2=='' or self.val3=='' or self.val4=='' or self.val5=='' or self.val6=='' or self.val7=='':
            tkinter.messagebox.showinfo("Warning", "Please Fill Up All Boxes Correctly")
        else:
            tkinter.messagebox.showinfo("Warning", "Congratulation Your New Account ID" + str(+user_id) + "")
            conn.execute("INSERT INTO DETAILS VALUES(?,?,?,?,?,?,?)",(self.val8,self.val1,self.val2,self.val3,self.val4,self.val5,self.val7))
            conn.commit()
            conn.execute("INSERT INTO LOG VALUES(?,?)",(self.val8,self.val6))
            conn.commit()

root=Tk()
b=ATM(root)
root.title("ACCOUNT DETAILS")
root.geometry("480x480")
root.resizable(False,False)
root.mainloop()
"""
from tkinter import *
from tkinter import messagebox
import sqlite3
conn=sqlite3.connect("test.db")

class frame1:

    def __init__(self, master):
        self.master = master
        self.frame = Frame(self.master)
        # creating frame in master
        self.left = Frame(master, width=480, height=360, bg="gray")
        self.left.pack(side=LEFT)
        # LABEL FOR WINDOW
        self.heading = Label(self.left, text="LOG IN", font=("arial 20 italic"), fg="white", bg="gray")
        self.heading.place(x=170, y=30)

        # USER ID
        self.userid = Label(self.left, text="USER ID", font=("arial 18 italic"), fg="white", bg="gray")
        self.userid.place(x=80, y=100)

        # PASSOWRD
        self.password = Label(self.left, text="PASSWORD", font=("arial 18 italic"), fg="white", bg="gray")
        self.password.place(x=80, y=150)

        # MAKING LABEL FOR BUTTON
        self.userid_ent = Entry(self.left, width=20)
        self.userid_ent.place(x=250, y=105)

        self.password_ent = Entry(self.left, width=20)
        self.password_ent.place(x=250, y=155)
        self.b1 = Button(self.master, text="Button1", font=("arial 10 italic"), fg="white", bg="steelblue", width=10,height=1, command=self.display)
        # self.b1.place(x=180,y=230)
        self.b2 = Button(self.master, text="Button2", font=("arial 10 italic"), fg="white", bg="steelblue", width=10,height=1, command=self.new_window)
        self.b2.place(x=180, y=230)
        # self.b1.pack()
        # self.b2.pack()
        self.frame.pack()

    def display(self):
        messagebox.showinfo("Title", "a Tk MessageBox")

    def new_window(self):
        # GETTING THE USERID AND PASSWORD FROM THE USER
        self.val1 = self.userid_ent.get()
        self.val2 = self.password_ent.get()

        self.val3 = 0
        self.val4 = 0

        # FETCHING THE USER ID AND PASSWORD FROM THE DATABASE
        cursor = conn.execute("SELECT ID FROM LOG WHERE PASSWORD=(?)", (self.val2,))
        for row in cursor:
            self.val3 = row[0]
        cursor = conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)", (self.val1,))
        for row in cursor:
            self.val4 = row[0]

        # VEIFYING FOR THE VALID ACCOUNT
        if (self.val1 == self.val3) and (self.val2 == self.val4):
            self.master.withdraw()
            self.newWindow = Toplevel(self.master)
            bb = Frames(self.newWindow)
        else:
            messagebox.showinfo("Title", "Invalid Username and Password"+str(self.val4)+"this")


class Frames:
    def __init__(self,master):
        self.master = master
        #self.newid=new_id
        self.frame = Frame(self.master)
        self.left = Frame(master, width=480, height=480, bg="gray")
        self.left.pack(side=LEFT)
        # MAKING OF ENTRY
        self.withdrawal_ent = Entry(self.left, width=20)
        self.withdrawal_ent.place(x=70, y=105)

        self.deposite_ent = Entry(self.left, width=20)
        self.deposite_ent.place(x=70, y=162)

        self.changepass_ent = Entry(self.left, width=20)
        self.changepass_ent.place(x=70, y=225)

        # MAKING LABEL
        self.with_sub = Button(self.left, text="WITHDRAWAL", font=("arial 10 bold"), fg="white", bg="steelblue",width=20, height=1,command=self.withdrawal_amount)
        self.with_sub.place(x=250, y=100)

        self.dep_sub = Button(self.left, text="DEPOSITE", font=("arial 10 bold"), fg="white", bg="steelblue", width=20,height=1,command=self.deposite_amount)
        self.dep_sub.place(x=250, y=160)

        self.pass_sub = Button(self.left, text="CHANGE PASSWORD", font=("arial 10 bold"), fg="white", bg="steelblue",width=20, height=1)
        self.pass_sub.place(x=250, y=220)

        self.exit_sub = Button(self.left, text="Exit", font=("arial 10 bold"), fg="white", bg="steelblue", width=10,height=1)
        self.exit_sub.place(x=180, y=280)

        #PERFORMING THE TRANSACTION OPERATION
        self.b3 = Button(self.master, text="Button3", font=("arial 10 bold"), fg="white", bg="steelblue", width=10,height=1, command=self.display3)
        self.b3.place(x=180, y=330)
        self.frame.pack()


    def withdrawal_amount(self):
        # FIRST PERFORMING THE WITHDRAWAL OPERATION
        self.with_amount = self.withdrawal_ent.get()
        self.new_with = 0
        cursor = conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)", (self.newid,))
        for row in cursor:
            self.new_with = row[0]
        if (self.with_amount > self.new_with):
            messagebox.showwarning("Warning", "INSUFFICIENT BALANCE")
        else:
            self.new_with = self.new_with - self.with_amount
            messagebox.showinfo("Warning","Your Availble Balance is +str(self.new_with)+")
            conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(self.new_with,self.newid))
            conn.commit()

    def deposite_amount(self):
        #SECOND PERFORMING THE DEPOSITE OPERATION
        self.dep_amount = self.deposite_ent.get()
        self.new_dep = 0
        cursor=conn.execute("SELECT BALANCE FROM DETAILS WHERE ID=(?)",(self.newid,))
        for row in cursor:
             self.new_dep=row[0]
        self.new_dep=self.new_dep+self.dep_amount
        messagebox.showinfo("Title","NOW YOUR AVAILABLE BALANCE IS +str(self.new_dep)+")
        conn.execute("UPDATE DETAILS SET BALANCE=(?) WHERE ID=(?)",(self.new_dep,self.newid))
        conn.commit()




    def display3(self):
        messagebox.showinfo("Title", "a Tk MessageBox")


if __name__ == '__main__':
    root = Tk()
    b = frame1(root)
    root.mainloop()