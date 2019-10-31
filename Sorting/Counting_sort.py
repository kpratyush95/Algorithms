def counting_sort(A,B,k):

    C = []
    for i in range(0,k):
        C.append(0)
    for j in range(0,len(A)):
        B.append(0)
        C[A[j]]= C[A[j]]+1
    for i in range(0,k):
        C[i]= C[i]+ C[i-1]

    for j in range(len(A)-1,-1,-1):
        B[C[A[j]]-1] =  A[j]
        C[A[j]] = C[A[j]]-1



def main():
    Arr = [2,5,3,0,2,3,0,3]
    Arr1 = []
    length = 7
    counting_sort(Arr,Arr1,length)
    print(Arr1)

main()