# Função map usando loop

def fmap (f):
    global l
    original = l
    l = []
    for elem in original:
        l.append(f(elem))
    return l

# Exemplo de teste:
def square (x):
    return x ** 2

l = [2, 4, 6, 8, 10]
fmap(square)
print(l) # saída: [4, 16, 36, 64, 100]
