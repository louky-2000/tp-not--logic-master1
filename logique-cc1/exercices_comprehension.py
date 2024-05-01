
L = [ -1, -2, 0, 1, 2, 6]

#somme des éléments de L
print(f"somme des éléments de L : {sum(L)}")

#plus petit élément de L
print(f"Plus petit élément de L : {min(L)}")

#plus grand élément de L
print(f"PLus grand élément de L : {max(L)}")

#sous-liste de L contenant les nombres positifs
L2 = [ el for el in L if el >= 0]
print(f"sous-liste de L contenant les nombres positifs : {L}")

#On construit une liste de booléens avec True si le nombre est pair et Faux sinon
L3 = [ el%2==0 for el in L]
print(f"Parité des éléments de L : {L3}")

#on renvoie True si toutes les valeurs de L sont paires
print(f"Tous les éléments de la liste L3 sont pairs : {all(L3)}")
#directement avec L
print(f"Tous les éléments de la liste L3 sont pairs : {all(el%2==0 for el in L)}")

#on renvoie True si une valeur au moins de L est paire
print(f"Au moins un éléments  de la liste L est pair : {any(L3)}")
#directement avec L
print(f"Au moins un éléments  de la liste L est pair : {any(el%2==0 for el in L)}")

#opérateur ternaire  m = valeur_vrai condition else valeur_faux
#on retourne la valeur absolu d'un nombre n
n = -12
m = n if n>=0 else -n
print(f"La valeur absolue de {n} est : {n if n>=0 else -n}")
n = 12
print(f"La valeur absolue de {n} est : {n if n>=0 else -n}")

#on retourne une liste avec les valeurs absolues des éléments de L
L4 = [ el if el>=0 else -el for el in L]
print(f"La liste des valeurs absolues de L est : {L4}")

M = range(-10,10)
#tous les éléments de L sont dans M
print(f"Tous les éléments de {L} sont dans {M} : {all(el in M for el in L)}")
#voir la fonction are_chars(chars, string) du TP1

def are_chars(chars, string):
    return all(char in string for char in chars)

#print(are_chars("tests","est"))
    
N = [0,1,2,3,4,5,6]
#tous les éléments de L ont leur valeur absolue dans N
print(f"Tous les éléments de {L} ont leur valeur absolue dans {N} :{all(el in N if el>=0 else -el in N for el in L)}")

#somme par composante de tous les éléments de deux listes L1 et L2
L1 = [1,2,3]
L2 = [5,8,1]
print(f"Somme par composante de {L1} et {L2} : {[el1+el2 for (el1,el2) in zip(L1,L2)]}")

#Produit cartésient de L1 et L2
print(f"Produit cartésient de {L1} et {L2} : {[(el1,el2) for el1 in L1 for el2 in L2]}")

print("Dictionnaires")
dico = {1:"un",2:"deux",3:"trois",4:"quatre"}
#On affiche la liste des valeurs d'un dictionnaire dont les clefs sont paires
print([dico[clef] for clef in dico if clef%2==0])
#autrement
print([valeur for (clef,valeur) in dico.items() if clef%2 == 0])

#utilisation de join pour concaténer des chaînes de caractères
liste_chaines = [dico[clef] for clef in dico]
print(liste_chaines)

print("Utilisation de join")
#nouvelle chaine avec les valeurs concaténées (sans séparateur)
chaine1 = "".join(liste_chaines)
#avec des espaces
chaine2 = " ".join(liste_chaines)
#avec le séparateur |
chaine3 = "|".join(liste_chaines)
#avec un séparateur char
char = ":"
chaine4 = char.join(liste_chaines)
print(f"{chaine1}\n{chaine2}\n{chaine3}\n{chaine4}")

#Liste de listes
L = [ [1,2,3], [4,5], [6,7,8,9] ]
print(f"Somme de tous les éléments des listes de {L} : {sum(sum(el) for el in L)}")

print(f"Toutes les listes de {L} contiennent des valeurs strictement inférieure à 10 : {all(all(a < 10 for a in b) for b in L)}")

print(f"Toutes les listes de {L} contiennent une valeur paire : {all(any(a%2 == 0 for a in b) for b in L)}")
