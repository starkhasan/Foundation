def is_leap(year):
    leap = False
    
    # Write your logic here
    if (year%400==0):
      leap=True
      return leap
    elif (year%100==0):
      return leap
    elif (year%4==0):
      leap=True
      return leap
    elif (year==1800)and(year==1900)and(year==2100)and(year==2200)and(year==2300)and(year==2500):
      return leap
    else:
      return leap
	  
year = int(raw_input())
print is_leap(year)