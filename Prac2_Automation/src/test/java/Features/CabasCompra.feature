Feature: Cabàs de la compra
  Comprovar que totes les opcions del cabas de compra funcionen correctament

	Background:
		Given el usuari accedeix al navegador "Chrome" 
	
	@Automation @CabasCompra @CabasCompra_CabasBuit
  Scenario: Accedir al cabas buit
    Given el usuari accedeix a la pagina web
    
    # Accedim al cabàs de compra
    When el usuari accedeix al menu "Cart" 
    Then es valida que el carrito inicialment està buit
    
	@Automation @CabasCompra @CabasCompra_AfegirElements
  Scenario Outline: Afegir elements al cabas
  	Given el usuari accedeix a la pagina web
    And el usuari accedeix al producte <producte>
    
    # Botó "Add to cart" al accedir a un producte en concret
    When el usuari clica a la opcio amb CSS ".cart"		
    Then es valida que apareix el missatge			
    And el usuari espera 1 segons
    
    # Text "View Cart" que apareix al clicar "Add to cart"
    And el usuari clica a la opcio amb path "//u[contains(.,'View Cart')]" 	
    And es valida que apareix el producte <nomProducte> al cabas
     
    # producte -> path per accedir a diferents productes
		Examples: 
			| 									producte									|				nomProducte				|
			| "(//a[contains(text(),'View Product')])[2]"	|	"Men Tshirt"						|
			| "(//a[contains(text(),'View Product')])[5]"	| "Winter Top"						|
			| "(//a[contains(text(),'View Product')])[7]"	| "Madame Top For Women"	|
			      
 	@Automation @CabasCompra @CabasCompra_EliminarElements
  Scenario: Eliminar elements del cabas
  	Given el usuari accedeix a la pagina web
    And el cabas conte productes
    
    # Botó eliminar del primer producte
    When el usuari clica a la opcio amb path "//tr[@id='product-1']/td[6]/a/i"	
    Then es valida que no apareix el producte
    