Feature: API Testing
	Validar el funcionament del menú de API Testing

	Background:
		Given el usuari accedeix al navegador "Chrome"
	
	@Automation @APITesting @APITesting_AccesAPI
  Scenario: Accedir al menú de API Testing
  	Given el usuari accedeix a la pagina web
  	When el usuari accedeix al menu "API Testing"
    Then es valida que el usuari ha accedit al menú "API Testing" correctament
	   
	@Automation @APITesting @APITesting_SelectAPI
  Scenario Outline: Seleccionar APIs
 		Given el usuari accedeix a la pagina web
  	And el usuari accedeix al menu "API Testing"
  	
  	# Diferents APIs disponibles (1,2,3,...,14)
  	When el usuari accedeix a la API <api_num> 
  	And el usuari espera 2 segons
    Then es valida que es mostra la API <api_num> correctament
    
		Examples:
	 		| api_num |
	 		| "1" |
	 		| "2" |
	 		| "5" |
	 		| "9" | 
	 		| "14" |