while True:
    try:
        n = int(input("Enter number of elements: "))
        break
    except ValueError:
        print("Invalid entry! Try again.")

i = 0; sum = 0; totalNumbers = []
for i in range(n):
    totalNumbers.append(int(input(f"Enter element[{i}]: ")))
    sum += totalNumbers[i];

print(f"Sum = {sum}")
