class Item:
    weight = 0
    val = 0

    def __init__(self, weight, val):
        self.weight = weight
        self.val = val


with open('lift.dat') as dat:
    lines = dat.readlines()
    count = int(lines[0])
    for j in range(count):
        itemCnt = int(lines[j * 3 + 1])
        weights = [int(k) for k in lines[j * 3 + 2].strip().split(" ")]
        vals = [int(k) for k in lines[j * 3 + 3].strip().split(" ")]
        cap = int(lines[4])
        items = []
        total = 0
        for k in range(itemCnt):
            items.append(Item(weights[k], vals[k]))
        for item in sorted(items, key=lambda x: x.val/x.weight, reverse=True):
            weight = item.weight if item.weight < cap else cap
            cap -= weight
            total += weight/item.weight * item.val
        print("${:,.2f}".format(total))

