def extended_bottom_up_cut(p,n):
    r =[0]*n
    s =[0]*n
    for j in range(n):
        q = -500000
        for i in range(j):
            if q < (p[i]+r[j-i]):
                q=(p[i]+r[j-i])
                s[j]=i
        r[j]=q
    return r, s    

p = (1,5,8,9,10,17,17,20,24,30)
n = len(p);
a=[]
b=[]
a,b=extended_bottom_up_cut(p,n)
print(a)
print(b)