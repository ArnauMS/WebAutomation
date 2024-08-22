Feature: Pantalla Principal
  Validació de les diverses opcions que ofereix la pàgina principal

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

	@Automation @HomePage @HomePage_CarruselTest
  Scenario Outline: Accedir a Test Cases del carrusel inicial
    Given el usuari accedeix al menu "Home"
    And el usuari mou el carrusel "Inicial" cap a la <direccio>
    And el usuari espera 1 segons
    
    # Botó "Test Cases"
    When el usuari clica a la opcio amb CSS ".active .test_cases_list > .btn"
    Then es valida que el usuari ha accedit al menú "Test Cases" correctament
    
	  Examples:
	  	| direccio | 
	  	| "Dreta" |	
	  	| "Esquerra" | 
  	
  	
	@Automation @HomePage @HomePage_CarruselAPI
  Scenario Outline: Accedir a API List del carrusel inicial
    Given el usuari accedeix al menu "Home"
    And el usuari mou el carrusel "Inicial" cap a la <direccio>
    And el usuari espera 1 segons
    
    # Botó "APIs list for practice"
    When el usuari clica a la opcio amb CSS ".active .apis_list > .btn"		
    Then es valida que el usuari ha accedit al menú "API List" correctament
    
	  Examples:
	  	| direccio | 
	  	| "Dreta" |	
	  	| "Esquerra" | 
	    

	@Automation @HomePage @HomePage_Featured
	Scenario Outline: Afegir producte al cabas desde la HomePage
    Given el usuari accedeix al menu "Home"
    
    # Fem que aparegui l'animació del producte
    And el usuari posiciona el ratoli sobre el camp CSS <panell_producte>		
    
    # Cliquem al "Add to cart" que apareix sobre el fons taronja
    When el usuari clica a la opcio amb CSS <boto_afegir>			
    And el usuari espera 2 segons	
    Then es valida que el producte ha estat afegit correctament
  
	  Examples:
	  	| boto_afegir | | panell_producte |
	  	| ".col-sm-4:nth-child(5) .productinfo > .btn" | | ".col-sm-4:nth-child(5) .product-overlay .btn" |
	  	| ".col-sm-4:nth-child(6) .productinfo > .btn" | | ".col-sm-4:nth-child(6) .product-overlay .btn" |
	  	| ".col-sm-4:nth-child(9) .productinfo > .btn" | | ".col-sm-4:nth-child(9) .product-overlay .btn" |
		  	
    
	@Automation @HomePage @HomePage_Recommended
  Scenario Outline: Afegir items recomanats al cabas
    Given el usuari accedeix al menu "Home"
    
    # Títol "RECOMMENDED ITEMS" al final de la pàgina
    And el usuari posiciona el ratoli sobre el camp CSS ".recommended_items > .title"			
    And el usuari mou el carrusel "Items recomenats" cap a la <direccio>
    
    # Botó "Add to cart" de l'apartat
    When el usuari clica a la opcio amb CSS ".active > .col-sm-4:nth-child(1) .btn"		
   	And el usuari espera 2 segons
    Then es valida que el producte ha estat afegit correctament
    
	  Examples:
	  	| direccio | 
	  	| "Dreta" |  
	  	| "Esquerra" | 
    
