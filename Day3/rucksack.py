
total = 0
ctr = 0
group = []
for x in open("input.txt").read().splitlines():
    group.append(x)
    ctr += 1
    if ctr == 3:
        firstG = group.pop(0)
        for y in firstG:
            if(y in group[0] and y in group[1]):
                print(y)
                if(y.isupper()):
                    total += ord(y)-38
                    break
                else:
                    total += (ord(y)-96)
                    break
        ctr = 0
        group = []
all(y)
print(total)