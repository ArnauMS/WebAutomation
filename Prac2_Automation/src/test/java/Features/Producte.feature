Feature: Producte
  Comprovar les diverses opcions que ofereixen els productes

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web
	
	@Automation @Producte @Producte_AccedirCategoria
  Scenario Outline: Accedir a una categoria
    Given el usuari accedeix al menu " Products"
    
    # Category (Women, Men, Kids)
    And el usuari clica a la opcio amb path <categoria>		
    
    # Subcategories que apareixen apretant a la icona (+)
    When el usuari clica a la opcio amb path <subcategoria>	
    Then es valida que apareixen productes de la categoria <titol>
    
		Examples:
			| 						categoria 						| 									subcategoria 									| 					titol				 		|
			| "//a[contains(@href, '#Women')]"  | "//a[contains(@href, '/category_products/2')]" 	| "WOMEN - TOPS PRODUCTS"		|
			| "//a[contains(@href, '#Men')]" 		| "//a[contains(@href, '/category_products/3')]" 	| "MEN - TSHIRTS PRODUCTS"	|
			| "//a[contains(@href, '#Kids')]"		| "//a[contains(@href, '/category_products/4')]"	| "KIDS - DRESS PRODUCTS"		|
	
	@Automation @Producte @Producte_AccedirMarca
  Scenario: Accedir a una marca 
  	Given el usuari accedeix al menu " Products"
  	
  	# Brands (Polo, H&M, Madame, ...)
    When el usuari accedeix a la marca <marca>		
    Then es valida que apareixen productes de la categoria <titol>
    
    Examples:
			| marca 	| 					titol					|
			| "Polo"	| "BRAND - POLO PRODUCTS"	|
		  | "H&M"		| "BRAND - H&M PRODUCTS"	|
		  | "Biba"	| "BRAND - BIBA PRODUCTS"	|   
    
	@Automation @Producte @Producte_Quantitat
  Scenario Outline: Modificar quantitat de un producte
  	Given el usuari accedeix al menu " Products"
  	
  	# Accedim a la informació del producte "View product"
    And el usuari accedeix a un producte
    
    # Escollim la quantitat d'elements del producte (fletxa amunt)
    When el usuari clica <quantitat> cops a la opcio amb id "quantity"
    Then es valida que la quantitat sigui <quantitatFinal> 
    
		Examples:
			| quantitat | quantitatFinal 	|
			|			1			|				2					|
		  |			2			|				3					|
		  |			3			|		  	4					|
		    
	@Automation @Producte @Producte_Comentari
	Scenario Outline: Review de un producte
		Given el usuari accedeix al submenu " Products"
		
		# Accedim a la informació del producte "View product"
		And el usuari accedeix a un producte
		And el usuari introdueix el valor <nom> al camp ID "name"
	  And el usuari introdueix el valor <email> al camp ID "email"
	  And el usuari introdueix el valor "Això és una prova d'automatització per a la pràctica de TQS" al camp ID "review" 
	  
	  # Botó "Submit" al accedir a un producte i afegir un comentari
	  When el usuari clica a la opcio amb id "button-review"	
	  Then es valida que el comentari està enviat correctament		
	  
	  Examples:
			| 	nom 	| 			email				|
			| "Arnau" | "arnau@gmail.com" |
		  | "Marc" 	| "marc@gmail.com" 	|
		  | "Joan" 	| "joan@gmail.com" 	|		  
		  