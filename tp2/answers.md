# 1.1

-- Quelle différence cela ferait-il si la classe Node n’etait pas déclarée static ? Consulter la doc
java.

- Si la classe Node n'était pas déclarée static, on ne pourrait la déclarer que dans la classe qui contient elle-même cette dernière (ici SinglyListClass) , on a donc pas beosin d'instancier une SinglyList pour instancier un Node.

# 1.2

-- Proposer et implémenter un algorithme pour trouver l’avant-dernier nœud dans une liste sim-
plement chaînée où le dernier élément est repéré par sa référence nulle au suivant.

- Tout d'abord pour créer cet algorithme il faut vérifier la taille de la liste : si elle est inférieure à 3, il y a seulement à renvoyer le header.
- il faut ensuite créer un noeud node pointant vers l'header, qu'on va envoyer dans une boucle qui s'arrêtera quand le noeud suivant le noeud qui suit node (c'est à dire node.getNext().getNext()) vaudra nul et node pointera au noeud le suivant à chaque passage.

-- Décrire, puis implémenter un algorithme pour inverser les éléments d’une liste simplement
chaînée, en utilisant seulement une quantité constante d’espace supplémentaire, et sans utiliser
de récursivité.

- Pour créer cet algorithmes sans quantité supplémentaire de données, il faudra créer des noeuds pointant vers la liste au lieu de créer une nouvelle liste.
- On crée 3 noeuds : previous, current et next, le premier vaut null au départ, le second pointe vers header
- le dernier est initialisé à chaque passage de boucle et vaut le second noeud de current
- on modifie le second noeud pour lui mettre previous (au depart on le rendra nul)
- On fait pointer previous vers current qui sera le noeud contenant la construction de la liste inversée
- On fait pointer current vers next
- On aura donc current qui aura par exemple 2 3 4 5 dans le second passage à qui on enleve le seoond noeud
- Ce qui fera 2 1, qu'on fera ensuite pointer vers previous et ainsi de suite
- On fait enfin pointer header vers previous pour récupérer la liste inversée.

-- Décrire en détail, puis implémenter comment échanger 2 nœuds x et y (et pas seulement
  leurs contenus) dans une liste simplement chaînée, étant données les références vers x et y, et
  seulement ces références.

- Pour pouvoir échanger 2 noeuds x et y dans une liste simplement chaînée
sans bouger tout le reste, il va falloir créer 4 autres noeuds :
-PredX et PredY qui sont donc les prédécesseurs de x et y (avec possibilité qu'un des 2 soit nul)
-SuccX et SuccY qui sont donc à l'inverse les successeurs de x et y (avec aussi possibilité qu'un des 2 soit nul)
- Le but est de tout d'abord vérifier si un des 2 noeuds est nul pour donc mettre le prédécesseur du noeud en question à nul, sinon on va parcourir la liste depuis le header pour assigner la bonne valeur aux 2 prédecesseurs.
- Il faut ensuite assigner la valeur aux successeurs de x et y, ce qui est moins compliqué car nous avons directement le getter getNext() de notre classe Node.
- Ensuite il y a à vérifier chaque cas spéciaux comme "Les deux noeuds se suivent" ou encore "1 des 2 est le header", ce qui donne beaucoup d'application par cas.
- Pour le cas le plus simple il y a seulement à faire pointer le noeud suivant le prédecesseur de x (predX) à y et à aussi à faire pointer le noeud suivant y (avec setNext()) au successeur de x (succX), et il faut faire exactement pareil avec x.
- Pour le cas si 1 des 2 est le header, il n'y aura pas à utiliser son prédecesseur (vu qu'il est nul) mais directement à faire pointer l'autre noeud n'étant pas le header vers le header puis faire le cas plus simple pour l'autre.
- Pour le cas ou les 2 noeuds se suivent, immaginons x puis y se suivent, le successeur de x étant y, succX est inutile, on aura seulement à donner comme noeud suivant le prédecesseur de x y, et x comme noeud suivant y (et comme d'habitude ensuite on attache succY à x)