if __name__ == '__main__':
    n = int(input())
    arr = map(int,input().split())
    maxnumber = max(arr)
    result = 0
    isFirst = True
    for i in arr:
        if(i != maxnumber):
            if isFirst:
                isFirst = False
                result = i
            elif result < i:
                result = i
    print(result)