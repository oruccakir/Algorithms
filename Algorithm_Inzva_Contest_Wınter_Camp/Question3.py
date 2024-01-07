# Practice makes it perfect
# inzva community built algoleague for every algorithm enthusiast hungry 
# for self-improvement and friendly competition. Have fun and good luck!
def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

def persuasion_process(ages, m):
    sura_group = ages[:]
    berat_group = []

    for k in range(m):
        for i in range(len(sura_group)):
            if sura_group[i] is not None:
                sura_group[i] += 1
                if is_prime(sura_group[i]):
                    berat_group.append(sura_group[i])
                    sura_group[i] = None

    berat_count = len(berat_group)
    sura_count = sum(1 for age in sura_group if age is not None)
    
    if berat_count > sura_count:
        return "Berat",berat_count
    else:
        return "Sura",sura_count



n = int(input())
m = int(input())
sura = [int(input()) for k in range(n)]

# Calculate the result
winner, supporter_count = persuasion_process(sura, m)

# Print the result
print(winner)
print(supporter_count)
