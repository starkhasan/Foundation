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
