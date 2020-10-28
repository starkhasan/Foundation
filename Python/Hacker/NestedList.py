if __name__ == '__main__':
    nameList = []
    scoreList = []
    newScore = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        nameList.append(name)
        scoreList.append(score)
        if score not in newScore:
            newScore.append(score)
    newScore.sort()
    second = newScore[1]
    newScore.clear()
    for i in range(len(scoreList)):
        if scoreList[i] == second:
            newScore.append(nameList[i])
    for i in sorted(newScore):
        print(i)


'''
if __name__ == '__main__':
    nameList = []
    scoreList = []
    def secondLowest(myList):
        isFirst = True
        first_max = min(myList)
        sec_max = 0.0
        for i in range(len(myList)):
            if myList[i]== float(first_max):
                continue
            else:
                if isFirst:
                    isFirst = False
                    sec_max = float(myList[i])
                elif sec_max > float(myList[i]):
                    sec_max = float(myList[i])
        return sec_max

    for _ in range(int(input())):
        name = input()
        score = float(input())
        nameList.append(name)
        scoreList.append(score)

    
    sec_min = secondLowest(scoreList)
    newName = []
    for i in range(len(scoreList)):
        if sec_min == scoreList[i]:
            newName.append(nameList[i])
        
    for j in sorted(newName):
        print(j)

'''