totalPairs = 0
totalOverlap = 0

for x in open("input.txt").read().splitlines():
    clean = x.split(",")
    elves = []
    for group in clean:
        y = group.split("-")
        elves.append(y)


    firstElfInner = int(elves[0][0])
    firstElfOutter = int(elves[0][1])
    
    secondElfInner = int(elves[1][0])
    secondElfOutter = int(elves[1][1])

    # part 1
    if (secondElfInner>=firstElfInner and secondElfOutter<=firstElfOutter) or (secondElfInner<=firstElfInner and secondElfOutter>=firstElfOutter):
        totalPairs += 1



    # part 2
    if max(firstElfInner,secondElfInner) <= min(firstElfOutter,secondElfOutter):
        totalOverlap += 1
print(totalPairs)
print(totalOverlap)