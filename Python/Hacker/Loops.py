if __name__ == '__main__':
    multiplication = lambda x:x**2
    n = int(input())
    for i in range(n):
        temp = multiplication(i)
        print(temp)
