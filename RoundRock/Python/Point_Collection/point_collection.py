from collections import deque


class Point:
    row = 0
    col = 0

    def __init__(self, row, col):
        self.row = row
        self.col = col


class Collector:
    moves = 0
    pos = Point(0, 0)
    points = 0
    visited = []

    def __init__(self, moves, pos, points, visited):
        self.moves = moves
        self.pos = pos
        self.points = points
        self.visited = visited


with open('point_collection.dat') as dat:
    lines = dat.readlines()
    for j in range(0, len(lines) - 1, 8):
        moves = int(lines[j])
        grid = []
        start = Point(0, 0)
        for k in range(j + 1, j + 9):
            grid.append(lines[k].strip())
            for i in range(len(grid[k - 1])):
                if grid[k - 1][i] == "S":
                    start = Point(k - 1, i)
        # depth first search
        queue = deque()
        queue.append(Collector(moves, start, 0, [[False for i in range(8)] for j in range(8)]))
        highest_points = 0
        rowV = [1, -1, 0, 0]
        colV = [0, 0, 1, -1]
        while queue:
            cur = queue.popleft()
            cur.visited[cur.pos.row][cur.pos.col] = True
            if cur.moves == 0:
                if cur.points > highest_points:
                    highest_points = cur.points
                continue
            for i in range(4):
                row = cur.pos.row + rowV[i]
                col = cur.pos.col + colV[i]
                if 0 <= row < 8 and 0 <= col < 8 and grid[row][col] != "W":
                    points = 0
                    if cur.visited[row][col]:
                        points = 0
                    else:
                        points = 0 if grid[row][col] == "-" or grid[row][col] == "S" else int(grid[row][col])
                    queue.append(Collector(cur.moves - 1, Point(row, col), cur.points + points, cur.visited))
        print(highest_points)


