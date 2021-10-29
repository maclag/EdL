# Função filter usando recursão

def ffilter (f, l, i = 0):
    global newList
    if (i == 0): newList = []
    if (i == len(l)): return newList

    if (f(l[i])):
        newList.append(l[i])
    return ffilter(f, l, i+1)
    
# Exemplo de teste:
def filter_vowels (letter):
    vowels = ['a', 'e', 'i', 'o', 'u']
    return True if letter in vowels else False

l = ['a', 'k', 'l', 'u', 'e', 'i', 'j', 'o', 'a', 'o', 'm', 'b', 'i', 'i']
vowels_l = ffilter(filter_vowels, l)
print(vowels_l) # saída: ['a', 'u', 'e', 'i', 'o', 'a', 'o', 'i', 'i']