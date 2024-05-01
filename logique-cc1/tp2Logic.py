
# Question 1
def enumeration2(poids):
    return [(i, poids - i) for i in range(poids + 1)]

# Question 2
def enumerationN2():
    poids = 0
    r  = 0
    while True:
        for i in range(poids + 1):
            yield (r,i, poids - i)
            r += 1
        poids += 1

# question 4
def R2(i,j):
    if i == 0 and j == 0:
        return 0
    return R2(i + j - 1, 0) + i + 1

# question 5
def enumerationk(k,poids):
    if k == 1:
        return [(poids,)]
    else:
        enumK = []
        for poids2 in range(poids + 1):
            for el in enumerationk(k - 1, poids2):
                enumK.append(el + (poids - poids2,))
        return enumK

# question 6
def enumerationNk(k):
    rang = 0
    poids = 0
    while True:
        for el in enumerationk(k, poids):
            yield (rang,) + el
            rang += 1
        poids += 1

# question 7
def construction_liste_termes(m):
    termes = ['x', 'y']  
    gen = enumerationN2()  
    while len(termes) < m:
        _, i, j = next(gen) 
        termes.append(f'f({termes[i]},{termes[j]})')
    return termes


# question 8
def construction_liste_formules(m):
    termes = construction_liste_termes(m)  
    formules = []
    gen = enumerationNk(4)
    while len(formules) < m:
        _, x, y, z, t = next(gen)
        # if x < len(termes) and y < len(termes) and z < len(termes) and t < len(termes):
        #     formule = f'f({termes[x]},{termes[y]}) = f({termes[z]},{termes[t]})'
        #     formules.append(formule)
        formules.append(f'f({termes[x]},{termes[y]}) = f({termes[z]},{termes[t]})')
    return formules


if __name__ == "__main__":
    # Question 1
    #print(enumeration2(4))

    #gen = enumerationN2()

    # Question 2
    # for i in range(11):
    #     print(next(gen))

    # Question 4
    # print(all([rang == R2(i,j) for k in range(11) for rang,i,j in [next(gen)] ]))

    # question 5
    # print(enumerationk(4,4))

    # question 6
    # gen = enumerationNk(4)
    # for i in range(20):
    #     print(next(gen))

    # question 7
    print(construction_liste_termes(20))

    # question 8
    # print(construction_liste_formules(20))
