def count_substring(string, sub_string):
    lastIndex = len(string) - len(sub_string)
    count = 0
    for i in range(lastIndex+1):
        newStr = string[i:i+len(sub_string)]
        if newStr == sub_string:
            count+=1
    return count

if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()
    
    count = count_substring(string, sub_string)
    print(count)