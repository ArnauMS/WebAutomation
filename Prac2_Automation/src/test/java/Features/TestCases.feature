Feature: Tests Cases
	Validar el funcionament del menú de Test Cases

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

	@Automation @TestCases @TestCases_Acces
  Scenario: Accedir al menú de Test Cases
  	Given el usuari accedeix al menu "Test Cases"
  	
  	# Despleguem el menú d'alguns tests (1,2,3,...,26)
  	When el usuari selecciona diversos tests cases
    Then es valida que el usuari ha accedit al menú "Test Cases" correctament
    