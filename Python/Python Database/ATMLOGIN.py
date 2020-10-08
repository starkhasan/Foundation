import sqlite3
conn=sqlite3.connect("test.db")
from tkinter import*
import tkinter.messagebox

class ATMLOGIN:
    def __init__(self,master):
        self.master=master

        #FRAME MAKING

        self.left = Frame(master, width=800, height=720, bg='gray')
        self.left.pack(side=LEFT)

        # LABEL FOR WINDOW
        self.heading = Label(self.left, text="LOG IN", font=('arial 20 italic'), fg='white', bg='gray')
        self.heading.place(x=170, y=30)

        #USER ID
        self.userid=Label(self.left,text="User ID",font=("arial 18 italic"),fg="white",bg="gray")
        self.userid.place(x=80,y=100)

        #PASSWORD
        self.password=Label(self.left,text="Password",font=("arial 18 italic"),fg="white",bg="gray")
        self.password.place(x=80,y=150)


        #ENTRY FOR THE USER-ID AND PASSWORD

        #ENTRY FOR THE USER ID
        self.userid_ent=Entry(self.left,width=20)
        self.userid_ent.place(x=250,y=105)

        #ENTRY FOR THE PASSWORD
        self.password_ent=Entry(self.left,width=20)
        self.password_ent.place(x=250,y=155)

        #MAKING OF THE BUTTON
        self.submitt=Button(self.left,text="LOG IN",font=("arial 10 italic"),fg="white",bg="steelblue",width=10,height=1,command=self.new_window)
        self.submitt.place(x=180,y=230)

    """def log(self):
        self.val1=self.userid_ent.get()
        self.val2=self.password_ent.get()

        #FETCHING THE ID AND PASSWORD FROM THE DATABASE
        new_pass=0
        new_id=0
        cursor=conn.execute("SELECT ID FROM LOGIN WHERE PASSWORD=(?)",(self.val2,))
        for row in cursor:
            new_id=row[0]
        cursor=conn.execute("SELECT PASSWORD FROM LOGIN WHERE ID=(?)",(self.val1,))
        for row in cursor:
            new_pass=row[0]

        #MATCHING THE PASSWORD AND ID FROM THE EXISTING ID AND PASSWORD
        if (self.val1 == new_id) and (self.val2 == new_pass):
            pass
            #NEED TO CALL A FUNCTION TO REERE THE CONTROL FOR THE FURTHER OPERATION OF TRANSACTION
        else:
            tkinter.messagebox.showinfo("Warning","INVALID USER-ID AND PASSWORD")
        """

    def new_window(self):
        self.master.withdraw()
        self.newWindow = Toplevel(self.master)
        self.val1 = self.userid_ent.get()
        self.val2 = self.password_ent.get()
        tkinter.messagebox.showinfo("Warning", "USER-ID"+str(self.val1)+" AND PASSWORD")
        # FETCHING THE ID AND PASSWORD FROM THE DATABASE
        self.new_pass = 0
        self.new_id = 0
        cursor = conn.execute("SELECT ID FROM LOG WHERE PASSWORD=(?)", (self.val2,))
        for row in cursor:
            self.new_id = row[0]
        cursor = conn.execute("SELECT PASSWORD FROM LOG WHERE ID=(?)", (self.val1,))
        for row in cursor:
            self.new_pass = row[0]
        tkinter.messagebox.showinfo("Warning", "USER-ID" + str(self.new_id) + " AND PASSWORD")
        # MATCHING THE PASSWORD AND ID FROM THE EXISTING ID AND PASSWORD
        if (self.val1 == self.new_id) and (self.val2 == self.new_pass):
            bb = ATMOPERATION(self.newWindow)
            # NEED TO CALL A FUNCTION TO REERE THE CONTROL FOR THE FURTHER OPERATION OF TRANSACTION
        else:
            tkinter.messagebox.showinfo("Warning", "INVALID USER-ID AND PASSWORD")

class ATMOPERATION:
    def __init__(self,master):
        self.master = master
        self.frame = Frame(self.master)
        self.left = Frame(master, width=800, height=720, bg='gray')
        self.left.pack(side=LEFT)

        self.exit_sub.place(x=150,y=280)
    def display(self):
        # MAKING OF ENTRY
        self.withdrawal_ent = Entry(self.left, width=20)
        self.withdrawal_ent.place(x=70, y=105)

        self.deposit_ent = Entry(self.left, width=20)
        self.deposit_ent.place(x=70, y=162)

        self.changepass_ent = Entry(self.left, width=20)
        self.changepass_ent.place(x=70, y=225)

        # MAKING BUTTON FOR THE WITHDRAWAL DEPOSITE  CHANGEPASSWORD AND EXIT
        self.with_sub = Button(self.left, text="WITHDRAWAL", font=("arial 10 bold"), fg="white", bg="steelblue",
                               width=20, height=1, command=self.withdrawal)
        self.with_sub.place(x=250, y=100)

        self.dep_sub = Button(self.left, text="DEPOSIT", font=("arial 10 bold"), fg="white", bg="steelblue", width=20,
                              height=1)
        self.dep_sub.place(x=250, y=160)

        self.pass_sub = Button(self.left, text="CHANGE PASSWORD", font=("arial 10 bold"), fg="white", bg="steelblue",
                               width=20, height=1)
        self.pass_sub.place(x=250, y=220)

        self.exit_sub = Button(self.left, text="EXIT", font=("arial 10 bold"), fg="white", bg="steelblue", width=20,
                               height=1)
        self.exit_sub.place(x=150, y=280)
        self.b3 = Button(self.master, text="Button3", command=self.display3)
        self.b3.pack()
        self.frame.pack()
        self.master = master

        self.left = Frame(master, width=800, height=720, bg='gray')
        self.left.pack(side=LEFT)

        # MAKING OF ENTRY
        self.withdrawal_ent = Entry(self.left, width=20)
        self.withdrawal_ent.place(x=70, y=105)

        self.deposit_ent = Entry(self.left, width=20)
        self.deposit_ent.place(x=70, y=162)

        self.changepass_ent = Entry(self.left, width=20)
        self.changepass_ent.place(x=70, y=225)

        # MAKING BUTTON FOR THE WITHDRAWAL DEPOSITE  CHANGEPASSWORD AND EXIT
        self.with_sub = Button(self.left, text="WITHDRAWAL", font=("arial 10 bold"), fg="white", bg="steelblue",
                               width=20, height=1, command=self.withdrawal)
        self.with_sub.place(x=250, y=100)

        self.dep_sub = Button(self.left, text="DEPOSIT", font=("arial 10 bold"), fg="white", bg="steelblue", width=20,
                              height=1)
        self.dep_sub.place(x=250, y=160)

        self.pass_sub = Button(self.left, text="CHANGE PASSWORD", font=("arial 10 bold"), fg="white", bg="steelblue",
                               width=20, height=1)
        self.pass_sub.place(x=250, y=220)

        self.exit_sub = Button(self.left, text="EXIT", font=("arial 10 bold"), fg="white", bg="steelblue", width=20,
                               height=1)


root=Tk()
b=ATMLOGIN(root)
root.title("LOG IN")
root.resizable(False,False)
root.geometry("480x360")
root.mainloop()