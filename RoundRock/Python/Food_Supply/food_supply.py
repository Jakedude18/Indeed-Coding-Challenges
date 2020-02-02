import sys

# TODO this algorithm is not done


def recur(cal: int, barrels_left: list):
        if len(barrels_left) == 1:
            return barrels_left[0]
        closet = sys.maxsize
        for barrel in barrels_left:
            if barrel == cal:
                return barrel
            val = recur(cal - barrel, barrels_left[1:])
            if abs(val - cal) < closet:
                closet = val
        return val


with open('food_supply.dat') as dat:
    for line in dat.readlines():
        barrels = [int(count) for count in line.strip().split(',')]
        diet = int(barrels.pop(0))
        print(recur(diet, barrels))
