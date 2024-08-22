Feature: Buscador
  Validar que el buscador funciona de forma correcte en cas de enviar un producte existent o no

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

	@Automation @Buscador @Buscador_ProdExistent
  Scenario Outline: Buscar producte existent
    Given el usuari accedeix al submenu " Products"
    
    # Barra de cerca per introduir un element a cercar
    And el usuari introdueix el valor <producte> al camp ID "search_product"	 
    
    # Botó "Lupa" per buscar els elements
    When el usuari clica a la opcio amb path "//button[@id='submit_search']/i" 
    Then es valida que la busqueda es un exit
    
		Examples:
			| 			producte				|
			| "Men Tshirt"					|
			| "Stylish Dress"				|
			| "Soft Stretch Jeans"	|
    
	@Automation @Buscador @Buscador_ProdInexistent
  Scenario Outline: Buscar producte inexistent
    Given el usuari accedeix al submenu " Products"
    
    # Barra de cerca per introduir un element a cercar
    And el usuari introdueix el valor <producte> al camp ID "search_product"   
    
    # Botó "Lupa" per buscar els elements
    When el usuari clica a la opcio amb path "//button[@id='submit_search']/i" 
    Then es valida que no apareix cap producte

		Examples:
			| producte	|
			| "UAB"			|
			| "formatge"|
			| "cavall"	|