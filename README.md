La société Akei est spécialisée dans la vente de meubles et de produits de la maison à prix attractif. Cette organisation possède de nombreux magasins en France et dans le monde entier. 

Les produits sont visibles dans la partie exposition du magasin et sont organisés par « pièce » de la maison : chambre,  cuisine,  séjour. Dans chaque magasin, les employés sont spécialisés par pièce.

Par exemple Jean Baptiste est toujours affecté à l’espace chambre (on parle aussi de rayon). Il doit connaître, ou du moins pouvoir renseigner au mieux les clients sur l’ensemble des produits de son espace :  nom, description technique, prix, dimensions, poids.

Lorsque les équipiers se déplacent dans le magasin, il arrive parfois que des clients interrogent un employé sur un domaine qu’il ne connaît pas. Il faudrait que l’employé puisse orienter le client vers un de ses collègues en charge du produit dont il est question.

Akei vend des produits parfois très volumineux. Les colis ne sont pas toujours transportables dans les véhicules des clients. 
Un service de location est disponible dans chaque magasin où le client peut louer des camions et des véhicules utilitaires. 
Chaque magasin a un parc de véhicules. Les clients peuvent choisir parmi ces véhicules celui qui leur semble le plus adapté.
Par exemple le Fiat Ducato de 20m3 a les dimensions intérieures suivantes : longueur : 2670mm, largeur : 1870mm, hauteur : 1662mm 
On enregistre aussi la plaque d’immatriculation, le type de carburant, et le nombre de km actuel.

L’application mobile (développée sous Android Studio en java) destinée aux employés d’Akei doit permettre de répondre facilement aux questions des clients sur les trois thèmes suivants: 
les produits et leurs caractéristiques
les camions disponibles à la locations
les employés et leurs spécialités

Les objectifs fixés dans ce contexte sont, dans un premier temps, la visualisation d’informations sur un téléphone mobile selon trois axes :
obtenir la liste des rayons et pour chacun d'entre eux les produits et leurs caractéristiques.
obtenir la liste complète des magasins Akei proposant des locations, puis les véhicules proposés ainsi que leurs caractéristiques
obtenir l'ensemble des rayons du magasin, et pour chacun d'entre eux, les employés spécialisés ainsi que leurs caractéristiques.

Pour ces trois axes, l’affichage devra être réalisé sur un même principe :
Affichage d’une liste principale, et, sur sélection d’un élément de la liste, affichage de la « sous liste ». 
Après avoir sélectionné un élément de la sous-liste l’application affiche en détail l’élément sélectionné. 

Un champ de recherche doit être disponible dans la 2ème interface pour permettre à l'utilisateur de filtrer les résultats selon le mot saisi. Le mot en question recherchera dans le nom du produit et dans ses caractéristiques.

Pour les autres axes, la fonctionnalité de recherche se basera sur les critères suivants : Véhicules (nom, marque, capacité) et Employés (nom, prenom, nom du magasin.)

Conseils techniques pour la mise au point de votre application
Deux approches sont possibles pour générer les listes sur les deux premiers écrans : 

1 - Approche par ListView : 

Le type ListView peut être utilisé pour lister les éléments, ce type d'objet est proche du Spinners dans son implémentation. Cependant quelques adaptations sont nécessaires.
La consultation d’une liste s’appuiera d’abord sur un simple Adapter, puis devra basculer vers un Adapter plus élaboré pour pouvoir visualiser de façon plus confortable les propriétés d’un objet métier, et arriver à la maquette dessinée. 
La consultation de la liste mineure sera mise au point en affichant d’abord l’item de liste majeure qui a été sélectionné. Puis la visualisation de la liste mineure pourra alors être mise au point. 

2 - Approche par LinearLayout : 

Il est possible de ne pas faire appel aux ListView et générer l'affichage à l'aide de layouts. Dans ce cas, aucun Adapter n'est nécessaire. Cependant cette solution demande potentiellement davantage de code.

