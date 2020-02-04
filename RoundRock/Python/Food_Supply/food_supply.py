def remove_list(base, comp):
    for i in base:
        if i in comp:
            base.remove(i)
            comp.remove(i)


def test():
    with open('food_supply.dat') as dat:
        for line in dat.readlines():
            barrels = [int(count) for count in line.strip().split(',')]
            diet = int(barrels.pop(0))
            days = 0
            while barrels:
                used_barrels = []
                for left_over in sorted(barrels):
                    used_barrels.append(left_over)
                    if sum(used_barrels) == diet:
                        days = days + 1
                        break
                    if sum(used_barrels) > diet:
                        for used_barrel in used_barrels:
                            if sum(used_barrels) - used_barrel <= diet:
                                days += 1
                                break
                            used_barrels.remove(used_barrel)
                        break
                remove_list(barrels, used_barrels)
            print(days)

