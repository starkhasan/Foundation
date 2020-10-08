dec_num=int(input("Enter the number"))
bin_num=0
i=0
while(dec_num!=0):
    rem=dec_num%2
    bin_num=bin_num+(rem*(10**i))
    dec_num=int(dec_num/2)
    i+=1
print("The Binary equivalent : ",bin_num)
    
