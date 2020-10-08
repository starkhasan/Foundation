'''
s='SPAM'
q='Q'
n=''
for i in range(0,len(s)):
    if i<=len(s)-2:
        n+=(s[i:i+1]+q)
    else:
        n+=s[i:i+1]
print(n)
'''
'''
s='SPAM'
q='Q'
n=''
r=''
r=s[::-1]
for i in range(0,len(s)):
    if i<=len(s)-2:
        n+=(q+r[i:i+1])
    else:
        n+=(r[i:i+1])
print(n[::-1])
'''
'''
s='SPAM'
q='Q'
n=''
for i in range(len(s)-1,-1,-1):
    if i>=1:
        n+=q+s[i:i+1]
    else:
        n+=s[i:i+1]
print(n[::-1])
'''