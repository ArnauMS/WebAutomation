Feature: Subscripcio
  Validar el funcionament de la subscripcio al newsletter

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

	@Automation @Subscripcio
  Scenario: Subscripcio a les novetats
  	Given el usuari accedeix al menu "Home"
  	
  	# Input que apareix al footer, per posar el mail
  	And el usuari introdueix el valor "test@gmail.com" al camp ID "susbscribe_email"
  	
  	# Apretem el botó per fer efectiva la subscripció (fletxa apuntant a la dreta)		
    When el usuari accepta la subscripcio
    Then es valida que el usuari estigui subscrit