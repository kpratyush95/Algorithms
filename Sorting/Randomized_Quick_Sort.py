import random
def randomized_quick_sort(A,p,r):
    if p < r:
        q=randomized_partition(A,p,r)
        randomized_quick_sort(A,p,q-1)
        randomized_quick_sort(A,q+1,r)
def randomized_partition(A,p,r):
    i = random.randrange(p,r)
    A[r],A[i]=A[i],A[r]
    return partition(A,p,r)
def partition(A,p,r):
    x = A[r]
    i = p-1
    for j in range(p,r):
        if A[j]<=x:
            i = i+1
            A[i],A[j] =  A[j],A[i]

    A[i+1], A[r] = A[r], A[i+1]
    return i+1

def main():
    #Array_sorting_required = [643,6547,234,2332,668,4324,6796,234423,97865,2322,54,2,96,8,7,564,64623]
    Array_sorting_required = [2, 8, 7, 1, 3, 5, 6, 4]
    start= 0
    end = len(Array_sorting_required)
    randomized_quick_sort(Array_sorting_required,start,end-1)
    print(Array_sorting_required)

main()