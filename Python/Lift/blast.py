class Item:
    weight = 0
    val = 0

    def __init__(self, weight, val):
        self.weight = weight
        self.val = val


with open("lift.dat") as dat:
    lines = [line for line in dat.readlines()]
    for j in range(int(lines[0])):
        count = int(lines[j * 3 + 1])
        weights = [int(k) for k in lines[j * 3 + 2].strip().split(" ")]
        vals = [int(k) for k in lines[j * 3 + 3].strip().split(" ")]
        items = []
        for i in range(count):
            items.append(Item(weights[i], vals[i]))
        for item in sorted(items, key=lambda x: x.val/x.weight, reverse=True):
            print("weight: {} value: {}".format(item.weight, item.val)) 


