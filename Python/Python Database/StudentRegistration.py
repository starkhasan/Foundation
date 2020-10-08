"""
from tkinter import *
import sqlite3
conn=sqlite3.connect("test.db")
import tkinter.messagebox
root=Tk()
w=tkinter.Label(root,text="Ali hasan",font=("arial 18 bold"), fg="black", bg="lightgreen")
w1=tkinter.Button(root,text="Submit")
w.pack()
w1.pack()
root.resizable(True,True)
root.geometry("1200x720")
root.mainloop()
"""
"""
from tkinter import*
import sqlite3
conn=sqlite3.connect("test.db")
import tkinter.messagebox

ids = []
class Application:
    def __init__(self, master):
        self.master = master

        # creating the frames in the master
        self.left = Frame(master, width=800, height=720, bg='lightgreen')
        self.left.pack(side=LEFT)
        self.right = Frame(master, width=400, height=720, bg='steelblue')
        self.right.pack(side=RIGHT)

        # labels for the window
        self.heading = Label(self.left, text="Student Details", font=('arial 40 bold'), fg='black',bg='lightgreen')
        self.heading.place(x=0, y=0)

        # Student Roll number
        self.roll = Label(self.left, text="Roll Number", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.roll.place(x=0, y=100)

        # Student Name
        self.name = Label(self.left, text="Name", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.name.place(x=0, y=140)

        # Student Age
        self.age = Label(self.left, text="Age", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.age.place(x=0, y=180)

        # Student Gender
        self.gender = Label(self.left, text="Gender", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.gender.place(x=0, y=220)

        # Student Branch
        self.branch = Label(self.left, text="Branch", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.branch.place(x=0, y=260)

        # Student Semester
        self.semester = Label(self.left, text="Semester", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.semester.place(x=0, y=300)

        # Student Email
        self.email = Label(self.left, text="Email ID", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.email.place(x=0, y=340)

        # Student Phone Number
        self.phone = Label(self.left, text="Phone", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.phone.place(x=0, y=380)

        # Student Address
        self.address = Label(self.left, text="Address", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.address.place(x=0, y=420)


        # Entries for all labels============================================================
        self.roll_ent = Entry(self.left, width=30)
        self.roll_ent.place(x=250, y=100)

        self.name_ent = Entry(self.left, width=30)
        self.name_ent.place(x=250, y=140)

        self.age_ent = Entry(self.left, width=30)
        self.age_ent.place(x=250, y=180)

        self.gender_ent = Entry(self.left, width=30)
        self.gender_ent.place(x=250, y=220)

        self.branch_ent = Entry(self.left, width=30)
        self.branch_ent.place(x=250, y=260)

        self.sem_ent = Entry(self.left, width=30)
        self.sem_ent.place(x=250, y=300)

        self.mail_ent = Entry(self.left, width=30)
        self.mail_ent.place(x=250, y=340)

        self.phone_ent = Entry(self.left, width=30)
        self.phone_ent.place(x=250, y=380)

        self.address_ent = Entry(self.left, width=30)
        self.address_ent.place(x=250, y=420)



        # button to perform a command
        self.submit = Button(self.left, text="Add Appointment", width=15, height=1, font=('arial 18 bold'), bg='steelblue',command=self.add_appointment)
        self.submit.place(x=230, y=460)

        # funtion to call when the submit button is clicked
    def add_appointment(self):
            # getting the user inputs
            self.val1 = self.roll_ent.get()
            self.val2 = self.name_ent.get()
            self.val3 = self.age_ent.get()
            self.val4 = self.gender_ent.get()
            self.val5 = self.branch_ent.get()
            self.val6 = self.sem_ent.get()
            self.val7 = self.mail_ent.get()
            self.val8 = self.phone_ent.get()
            self.val9 = self.address_ent.get()

            # checking if the user input is empty
            if self.val1==''or self.val2 == '' or self.val3 == '' or self.val4 == '' or self.val5 == '' or self.val6=='' or self.val7=='' or self.val8=='' or self.val9=='':
                tkinter.messagebox.showinfo("Warning", "Please Fill Up All Boxes")
            else:
                # now we add to the database
                conn.execute("INSERT INTO STUINFO VALUES(?,?,?,?,?,?,?,?,?)",(self.val1,self.val2,self.val3,self.val4,self.val5,self.val6,self.val7,self.val8,self.val9))
                conn.commit()
                tkinter.messagebox.showinfo("Success", "Appointment for " + str(self.val1) + " has been created")
    # creating the object
root = Tk()
root.title("Student Registration")
b = Application(root)

# resolution of the window
root.geometry("720x560")

# preventing the resize feature
root.resizable(False, False)

# end the loop
root.mainloop()
"""
"""
#table for inserting student information
import sqlite3
conn=sqlite3.connect("test.db")
print("DataBase Opened Successfully")
conn.execute("CREATE TABLE STUINFO(ROLLNO INT PRIMARY KEY NOT NULL,NAME CHAR(15) NOT NULL,AGE INT NOT NULL,GENDER INT NOT NULL,BRANCH CHAR(10) NOT NULL,SEM INT NOT NULL,EMAIL CHAR(20) NOT NULL,PHONE INT NOT NULL,ADDRESS CHAR(20) NOT NULL)")
print("Table Created Successfully")
conn.close()
"""

"""
#table for student marks
import sqlite3
conn=sqlite3.connect("test.db")
print("Database Opened Successfully")
conn.execute("CREATE TABLE STUMARKS(ROLLNO INT PRIMARY KEY NOT NULL,SEM1 INT NOT NULL,SEM2 INT NOT NULL,SEM3 INT NOT NULL,SEM4 INT NOT NULL,SEM5 INT NOT NULL,SEM6 INT NOT NULL,SEM7 INT NOT NULL,SEM8 INT NOT NULL)")
print("STUMARK table created successfully")
conn.close()
"""

"""
#Student marks

from tkinter import*
import sqlite3
conn=sqlite3.connect("test.db")
import tkinter.messagebox

ids = []
class Application:
    def __init__(self, master):
        self.master = master

        # creating the frames in the master
        self.left = Frame(master, width=800, height=720, bg='lightgreen')
        self.left.pack(side=LEFT)
        self.right = Frame(master, width=400, height=720, bg='steelblue')
        self.right.pack(side=RIGHT)

        # labels for the window
        self.heading = Label(self.left, text="Student Performance", font=('arial 30 bold'), fg='black',bg='lightgreen')
        self.heading.place(x=0, y=0)

        #Student Roll Number
        self.roll = Label(self.left, text="Roll Number", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.roll.place(x=0, y=100)

        # Student Roll number
        self.sem1 = Label(self.left, text="Semester 1", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem1.place(x=0, y=140)

        # Student Name
        self.sem2 = Label(self.left, text="Semester 2", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem2.place(x=0, y=180)

        # Student Age
        self.sem3 = Label(self.left, text="Semester 3", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem3.place(x=0, y=220)

        # Student Gender
        self.sem4 = Label(self.left, text="Semester 4", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem4.place(x=0, y=260)

        # Student Branch
        self.sem5 = Label(self.left, text="Semester 5", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem5.place(x=0, y=300)

        # Student Semester
        self.sem6 = Label(self.left, text="Semester 6", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem6.place(x=0, y=340)

        # Student Email
        self.sem7 = Label(self.left, text="Semester 7", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem7.place(x=0, y=380)

        # Student Phone Number
        self.sem8 = Label(self.left, text="Semester 8", font=('arial 18 bold'), fg='black', bg='lightgreen')
        self.sem8.place(x=0, y=420)


        # Entries for all labels============================================================
        self.roll_ent = Entry(self.left, width=30)
        self.roll_ent.place(x=250, y=100)

        self.sem1_ent = Entry(self.left, width=30)
        self.sem1_ent.place(x=250, y=140)

        self.sem2_ent = Entry(self.left, width=30)
        self.sem2_ent.place(x=250, y=180)

        self.sem3_ent = Entry(self.left, width=30)
        self.sem3_ent.place(x=250, y=220)

        self.sem4_ent = Entry(self.left, width=30)
        self.sem4_ent.place(x=250, y=260)

        self.sem5_ent = Entry(self.left, width=30)
        self.sem5_ent.place(x=250, y=300)

        self.sem6_ent = Entry(self.left, width=30)
        self.sem6_ent.place(x=250, y=340)

        self.sem7_ent = Entry(self.left, width=30)
        self.sem7_ent.place(x=250, y=380)

        self.sem8_ent = Entry(self.left, width=30)
        self.sem8_ent.place(x=250, y=420)




        # button to perform a command
        self.submit = Button(self.left, text="Add Appointment", width=15, height=1, font=('arial 18 bold'), bg='steelblue',command=self.add_appointment)
        self.submit.place(x=230, y=460)

        # funtion to call when the submit button is clicked
    def add_appointment(self):
            # getting the user inputs
            self.val1 = self.roll_ent.get()
            self.val2 = self.sem1_ent.get()
            self.val3 = self.sem2_ent.get()
            self.val4 = self.sem3_ent.get()
            self.val5 = self.sem4_ent.get()
            self.val6 = self.sem5_ent.get()
            self.val7 = self.sem6_ent.get()
            self.val8 = self.sem7_ent.get()
            self.val9 = self.sem8_ent.get()

            # checking if the user input is empty
            if self.val1==''or self.val2 == '' or self.val3 == '' or self.val4 == '' or self.val5 == '' or self.val6=='' or self.val7=='' or self.val8=='' or self.val9=='':
                tkinter.messagebox.showinfo("Warning", "Please Fill Up All Boxes")
            else:
                # now we add to the database
                conn.execute("INSERT INTO STUMARKS VALUES(?,?,?,?,?,?,?,?,?)",(self.val1,self.val2,self.val3,self.val4,self.val5,self.val6,self.val7,self.val8,self.val9))
                conn.commit()
                tkinter.messagebox.showinfo("Success", "Appointment for " + str(self.val1) + " has been created")
    # creating the object
root = Tk()
root.title("Student Registration")
b = Application(root)

# resolution of the window
root.geometry("720x560")

# preventing the resize feature
root.resizable(False, False)

# end the loop
root.mainloop()

"""

#Fetching marks of the student

# update the appointments
from tkinter import *
import tkinter.messagebox
import sqlite3

conn = sqlite3.connect('database.db')
c = conn.cursor()

class Application:
    def __init__(self, master):
        self.master = master
        # heading label
        self.heading = Label(master, text="Log In",  fg='steelblue', font=('arial 40 bold'))
        self.heading.place(x=150, y=0)

        # search criteria -->name
        self.roll = Label(master, text="Roll Number", font=('arial 18 bold'))
        self.roll.place(x=0, y=70)

        self.name = Label(master, text="Name", font=('arial 18 bold'))
        self.name.place(x=0, y=100)
        # entry for  the name
        self.rollnet = Entry(master, width=30)
        self.rollnet.place(x=280, y=80)

        self.namenet = Entry(master,width=30)
        self.namenet.place(x=280, y=110)

        # search button
        self.search = Button(master, text="Search", width=12, height=1, bg='steelblue', command=self.search_db)
        self.search.place(x=180, y=150)
    # function to search
    def search_db(self):
        self.input = self.namenet.get()
        # execute sql

        sql = "SELECT * FROM appointments WHERE name LIKE ?"
        self.res = c.execute(sql, (self.input,))
        for self.row in self.res:
            self.name1 = self.row[1]
            self.age = self.row[2]
            self.gender = self.row[3]
            self.location = self.row[4]
            self.time = self.row[6]
            self.phone = self.row[5]
        # creating the update form
        self.uname = Label(self.master, text="Patient's Name", font=('arial 18 bold'))
        self.uname.place(x=0, y=140)

        self.uage = Label(self.master, text="Age", font=('arial 18 bold'))
        self.uage.place(x=0, y=180)

        self.ugender = Label(self.master, text="Gender", font=('arial 18 bold'))
        self.ugender.place(x=0, y=220)

        self.ulocation = Label(self.master, text="Location", font=('arial 18 bold'))
        self.ulocation.place(x=0, y=260)

        self.utime = Label(self.master, text="Appointment Time", font=('arial 18 bold'))
        self.utime.place(x=0, y=300)

        self.uphone = Label(self.master, text="Phone Number", font=('arial 18 bold'))
        self.uphone.place(x=0, y=340)

        # entries for each labels==========================================================
        # ===================filling the search result in the entry box to update
        self.ent1 = Entry(self.master, width=30)
        self.ent1.place(x=300, y=140)
        self.ent1.insert(END, str(self.name1))

        self.ent2 = Entry(self.master, width=30)
        self.ent2.place(x=300, y=180)
        self.ent2.insert(END, str(self.age))

        self.ent3 = Entry(self.master, width=30)
        self.ent3.place(x=300, y=220)
        self.ent3.insert(END, str(self.gender))

        self.ent4 = Entry(self.master, width=30)
        self.ent4.place(x=300, y=260)
        self.ent4.insert(END, str(self.location))

        self.ent5 = Entry(self.master, width=30)
        self.ent5.place(x=300, y=300)
        self.ent5.insert(END, str(self.time))

        self.ent6 = Entry(self.master, width=30)
        self.ent6.place(x=300, y=340)
        self.ent6.insert(END, str(self.phone))

        # button to execute update
        self.update = Button(self.master, text="Update", width=20, height=2, bg='lightblue', command=self.update_db)
        self.update.place(x=400, y=380)

        # button to delete
        self.delete = Button(self.master, text="Delete", width=20, height=2, bg='red', command=self.delete_db)
        self.delete.place(x=150, y=380)
    def update_db(self):
        # declaring the variables to update
        self.var1 = self.ent1.get() #updated name
        self.var2 = self.ent2.get() #updated age
        self.var3 = self.ent3.get() #updated gender
        self.var4 = self.ent4.get() #updated location
        self.var5 = self.ent5.get() #updated phone
        self.var6 = self.ent6.get() #updated time

        query = "UPDATE appointments SET name=?, age=?, gender=?, location=?, phone=?, scheduled_time=? WHERE name LIKE ?"
        c.execute(query, (self.var1, self.var2, self.var3, self.var4, self.var5, self.var6, self.namenet.get(),))
        conn.commit()
        tkinter.messagebox.showinfo("Updated", "Successfully Updated.")
    def delete_db(self):
        # delete the appointment
        sql2 = "DELETE FROM appointments WHERE name LIKE ?"
        c.execute(sql2, (self.namenet.get(),))
        conn.commit()
        tkinter.messagebox.showinfo("Success", "Deleted Successfully")
        self.ent1.destroy()
        self.ent2.destroy()
        self.ent3.destroy()
        self.ent4.destroy()
        self.ent5.destroy()
        self.ent6.destroy()
# creating the object
root = Tk()
b = Application(root)
root.geometry("480x200+0+0")
root.resizable(True, True)
root.mainloop()