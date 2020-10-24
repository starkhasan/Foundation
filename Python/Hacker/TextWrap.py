import textwrap

def wrap(string, max_width):
    isFirst = True
    resultStr = ""
    result = textwrap.wrap(string,max_width)
    for element in result:
        if isFirst:
            isFirst = False
            resultStr = element
        else:
            resultStr = resultStr +"\n"+element
    return resultStr

if __name__ == '__main__':
    string, max_width = input(), int(input())
    result = wrap(string, max_width)
    print(result)