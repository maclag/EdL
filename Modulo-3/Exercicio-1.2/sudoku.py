# Sudoku Solver using Backtracking

# Validando a posição dos números
def is_valid_move(grid, row, col, number):
    # Same row
    for x in range(9):
        if grid[row][x] == number:
            return False
    
    # Same column
    for x in range(9):
        if grid[x][col] == number:
            return False

    # 3x3 field
    corner_row = row - row % 3
    corner_col = col - col % 3
    for x in range(3):
        for y in range(3):
            if grid[corner_row + x][corner_col + y] == number:
                return False

    return True


def solve(grid, row, col):
    if col == 9: # Se já ultrapassou a qtd máx de colunas (9 colunas: 0-8),
        if row == 8: # e se já chegou à última linha,
            return True # então chegou ao final do sudoku => True
        row += 1 # se linha != 8, vai para a linha seguinte
        col = 0 # e vai para à primeira coluna da linha

    # Recursão
    if grid[row][col] > 0: # Se já temos um valor válido (n > 0),
        return solve(grid, row, col + 1) # passamos para a próxima coluna 

    for num in range(1, 10): # Tentando todas as possibilidades de número (1-9)
        if is_valid_move(grid, row, col, num): # se for uma posição de número válida,
            grid[row][col] = num # então o número assumirá essa posiçaõ

            # Recursão
            if solve(grid, row, col + 1): # se essa solução for válida, retornamos True
                return True
        
        grid[row][col] = 0 # se o número nessa posição não for válido e assim tenta um valor
    
    return False # Não há nenhuma solução
    

# 0 means no number
grid = [[0, 0, 0, 0, 0, 0, 6, 8, 0],
        [0, 0, 0, 0, 7, 3, 0, 0, 9],
        [3, 0, 9, 0, 0, 0, 0, 4, 5],
        [4, 9, 0, 0, 0, 0, 0, 0, 0],
        [8, 0, 3, 0, 5, 0, 9, 0, 2],
        [0, 0, 0, 0, 0, 0, 0, 3, 6],
        [9, 6, 0, 0, 0, 0, 3, 0, 8],
        [7, 0, 0, 6, 8, 0, 0, 0, 0],
        [0, 2, 8, 0, 0, 0, 0, 0, 0]]

if solve(grid, 0, 0):
    for i in range(9):
        for j in range(9):
            print(grid[i][j], end=" ")
        print()

else:
    print("No Solution For This Sudoku")

