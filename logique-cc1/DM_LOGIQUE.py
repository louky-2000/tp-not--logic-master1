import random , math
import matplotlib.pyplot as plt
from tp2Logic import *

class Graphe:
    def __init__(self,n):
        self.n = n #nombre de sommets
        self.m = 0 #nombre d'arêtes
        self.voisins = [ [] for i in range(n)]# les listes des voisins sont vides au début
        self.cloture = None
        
    def __str__(self):# affiche les listes des voisins
        chaine = ''
        for i in range(self.n):
            chaine +="voisins de "+str(i)+" : "
            for j in self.voisins[i]:
                chaine+=str(j)+' '
            chaine+='\n'
        return chaine
                
    def voisinage(self,i):# on retourne la liste des voisins de i
        return self.voisins[i]   

    def ajoute_une_arete(self,i,j):
        if j in self.voisins[i]:
            print("attention")
        self.voisins[i].append(j)
        self.voisins[j].append(i)
        self.m += 1

    def ajoute_plusieurs_aretes(self,m): # ajoute m arêtes avec le modèle GNM
        while self.m < m:
            i = random.randint(0,self.n-1)
            j = random.randint(0,self.n-1)
            if i != j and j not in self.voisinage(i):
                 self.ajoute_une_arete(i,j)

    def copie_graphe(self):
        G = Graphe(self.n)
        for i in range(self.n):
            for j in self.voisins[i]:
                if j not in G.voisinage(i):
                    G.ajoute_une_arete(i,j)
        return G        

    def phi1(self):
        for i in range(self.n):
           if len(self.voisinage(i)) == 0 or len(self.voisinage(i)) == self.n-1:
               return False
        return True

    def phi1bis(self):
        return all(len(self.voisinage(i)) != 0 and len(self.voisinage(i)) < self.n-1 for i in range(self.n))
 
    def phi2(self):
        for i in range(self.n):
            rep = False
            for j in self.voisinage(i):
                for k in self.voisinage(j):
                    if k in self.voisinage(i):
                        rep= True
            if rep == False:
                return False
        return True

    def phi2bis(self):   
        return all( any( any(k in self.voisinage(i) for k in self.voisinage(j)) for j in self.voisinage(i)) for i in range(self.n))

    def phi3(self):
        for i in range(self.n):
             for j in range(self.n):
                rep = False
                if i==j or j in self.voisinage(i):
                    rep = True
                for k in self.voisinage(i):
                    if k in self.voisinage(j):
                        rep = True
                if rep == False:
                    return False
        return True

    def phi3bis(self):
        return all( all( i == j or j in self.voisinage(i) or any(k in self.voisinage(i) for k in self.voisinage(j)) for j in range(self.n)) for i in range(self.n))
    
    def iteration(self):
        stop = True
        for i in range(n):
            for j in self.voisins[i]:
                for k in self.cloture.voisinage(j):
                    if k != i and k not in self.cloture.voisinage(i) and i not in self.cloture.voisinage(k):
                        stop = False
                        self.cloture.ajoute_une_arete(i,k)
        return stop

    def cloture_transitive(self):
        if self.cloture != None:
            return self.nombre_iterations
        self.cloture = self.copie_graphe()
        stop = False
        self.nombre_iterations = 0
        while not stop:
            stop = self.iteration()
            self.nombre_iterations +=1
            print(self.nombre_iterations)
    
    def est_connexe(self):
        if self.cloture == None:
            self.cloture_transitive()
        return all(len(self.cloture.voisinage(i))==self.n-1  for i in range(self.n))    
    
    # question 1
    def triangle(self):
        for i in range(self.n):
            for j in self.voisinage(i):
                for k in self.voisinage(j):
                    if i in self.voisinage(k):
                        return True
        return False
    
    # question 2
    def ajoute_arete(self):
        stop = False
        while not stop:
            i = random.randint(0,self.n-1)
            j = random.randint(0,self.n-1)
            if i != j and j not in self.voisinage(i):
                self.ajoute_une_arete(i,j)
                stop = True

    # question 4 
    def chemin2(self):
        for x in range(self.n): 
            tous_les_y = True  # on suppose que x est connecté par un chemin de longueur à avec tout les y
            for y in range(self.n):  
                if x != y:  
                    chemin2_trouve = False  
                    for z in self.voisinage(x): 
                        if z != x and z != y and y in self.voisinage(z):  
                            chemin2_trouve = True 
                            break  
                    if not chemin2_trouve:  
                        tous_les_y = False  
                        break  
            if tous_les_y:  
                return True  
        return False  


# question 2  suite  
def construction_triangle(n):
    g = Graphe(n)
    while not g.triangle():
        g.ajoute_arete()
    return g.m

# question 3
def histogrammeValeurs(population,nombreGroupes):
    plt.hist(population,bins=nombreGroupes)
    plt.show()

# question 5    
def construction_chemin(n):
    g = Graphe(n)
    while not g.chemin2():
        g.ajoute_arete()
    return g.m

# fonction intermédiare
def contruction(func,n,nbGroup):
    population = []
    for i in range(n):
        population.append(func(n))
    histogrammeValeurs(population=population,nombreGroupes=nbGroup)

#------------------------------ Exo 2 -------------------------------------
#Question 8

# Définition de la fonction R1(i)
def R1(i):
    return ((i + 1) * (i + 2)) // 2 - 1

# Définition de la fonction S1(k)
def S1(k):
    return math.floor(math.sqrt(2 * k + 2)) - 1

# Définition de la fonction S2(k)
def S2(k):
    if k == 0:
        return (0, 0)
    p = S1(k)
    i = k - R1(p - 1) - 1
    if p - i >= 0:
        j = p - i
    else:
        i = k - R1(p) - 1
        j = p + 1 - i
    return (i, j)

# question 9
def generation_terme(k):
    if k == 1:
        return 'x'
    elif k == 2:
        return 'y'
    else:
        i, j = S2(k - 3)  
        return f'f({generation_terme(i+1)},{generation_terme(j+1)})' 




if __name__ == '__main__':
    print("====================== TEST QUESTION 1 =======================\n")
    n = 4
    g = Graphe(n)
    g.ajoute_une_arete(0,1)
    g.ajoute_une_arete(1,2)
    g.ajoute_une_arete(1,3)
    print(f"Le graphe est-il TRIANGLE ? {g.triangle()}")
    g.ajoute_une_arete(2,3) # pour avoir un triangle
    print(f"Le graphe est-il TRIANGLE ? {g.triangle()}")

    n = 100
    print("\n====================== TEST QUESTION 2 =======================\n")
    print(f"Nombre d'arête dans le graphe de {n} sommets est : {construction_triangle(n)}")

    print("\n====================== TEST QUESTION 3 =======================\n")
    #contruction(construction_triangle,n,10)
    print("Il faut décommenter cette question pour voir l'histogramme")

    print("\n====================== TEST QUESTION 4 =======================\n")
    s = 4
    g = Graphe(s)
    g.ajoute_une_arete(0,1)
    g.ajoute_une_arete(0,2)
    g.ajoute_une_arete(1,2)
    g.ajoute_une_arete(1,3)
    print(f"Le graphe est-il CHEMIN2 ? {g.chemin2()}")

    print("\n====================== TEST QUESTION 6 =======================\n")
    #contruction(construction_chemin,n,10)
    print("Il faut décommenter cette question pour voir l'histogramme")

    print("\n====================== TEST QUESTION 7 =======================\n")
    premiers_termes_S1 = [S1(k) for k in range(10)]
    premiers_termes_S2 = [S2(k) for k in range(10)]

    print(f"premiers_termes_S1 = {premiers_termes_S1}")
    print(f"premiers_termes_S2 = {premiers_termes_S2}")

    print("\n====================== TEST QUESTION 9 =======================\n")
    ## construction_liste_termes(20)
    ## print([f'{i} => {generation_terme(i)}' for i in range(1,21) ])
    print("La fonction generation_terme(k) fonctionne t-elle comme construction_liste_termes(m) ? ",end=" ")
    print(all([generation_terme(i) == construction_liste_termes(20)[i-1] for i in range(1,21) ]))
 