n,m = list(map(int,input().strip().split()))
design = ".|."
mesage = "WELCOME"
pos = n//2
for i in range(n):
    if i == pos:
        print(mesage.center(m,"-"))
    elif i<pos:
        print(design.center(m,"-"))
        design = design+".|..|."
    elif i>pos:
        design = design[:5:-1]
        print(design.center(m,"-"))