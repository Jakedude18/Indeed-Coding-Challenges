
vowels = set('aeiou')
with open('word_score.dat') as dat:
    for line in dat.readlines():
        score = len(line.strip()) // 2
        for char in list(line.lower()):
            if char in vowels:
                score += 1
            elif char is 'z':
                score += 2
            elif char is 'q':
                score += 4
        print(score)
