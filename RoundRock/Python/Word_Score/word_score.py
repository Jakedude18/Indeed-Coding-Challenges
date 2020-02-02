
vowels = set('aeiou')
with open('word_score.dat') as dat:
    for line in dat.readlines():
        highScore = 0
        for word in line.strip().split(" "):
            score = len(word) // 2
            for char in list(word.lower()):
                if char in vowels:
                    score += 1
                if char is 'z':
                    score += 2
                if char is 'x' or char is 'q':
                    score += 3
            if score > highScore:
                highScore = score
        print(highScore)
