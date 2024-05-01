import random

class Graphe:
    def __init__(self,n):
        self.n = n #nombre de sommets
        self.m = 0 #nombre d'arêtes
        self.voisins = [ [] for i in range(n)]# les listes des voisins sont vides au début
        self.cloture = None #cloture transitive du graphe
        
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
        for x in range(self.n):
            voisin = self.voisinage(x)
            if len(voisin) == 0 or len(voisin) >= self.n -1:
                return False
        return True
        # return all([len(self.voisinage(x)) != 0 and len(self.voisinage(x) < n-1 for x in range(self.n))])
    def phi2(self):
        for x in range(self.n):
            ok = False
            for y in self.voisinage(x):
                for z in self.voisinage(y):
                    if z in self.voisinage(x):
                        ok = True
                    if ok == True : break
                if ok == True : break
            if ok == False:
                return False
        return True

    def phi3(self):
        for x in range(self.n):
            for y in range(self.n):
                ok = False
                ok1 = False
                if x != y:
                    if x in self.voisinage(y):
                        ok = True
                        break
                    else:
                        ok1 = True
                    for z in range(self.n):
                        if (z in self.voisinage(y)) and (z in self.voisinage(x)):
                            ok = True
                            break
                if ok1 and ok: return True
        return False

    def iteration(self):
        pass

    def cloture_transitive(self):
        if self.cloture != None: #pour construire la cloture transitive
            return self.nombre_iterations
        self.cloture = self.copie_graphe()
        stop = False
        self.nombre_iterations = 0#self.iterations contient le nombre d'appels de la méthode iteration 
        while not stop:
            stop = self.iteration()
            self.nombre_iterations +=1
    
    def est_connexe(self):
        if self.cloture == None:#on construit la cloture transitive si cela n'a pas encore été fait
            self.cloture_transitive()
        #à compléter
            
             
if __name__ == "__main__":
    n = 50
    G = Graphe(n)
    G.ajoute_plusieurs_aretes(n)
    print(f"phi1 : {G.phi1()}")

    #G.ajoute_plusieurs_aretes(n*(n -1 )//2)
    print(f"phi2 : {G.phi2()}")
