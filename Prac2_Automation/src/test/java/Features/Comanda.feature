Feature: Comanda
	Comprovació del funcionament de la comanda al fer-ne una

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

 	@Automation @Comanda @Comanda_FerComanda
  Scenario: Fer una comanda
    Given el usuari inicia sessio amb correu "malfonso621@gmail.com" i password "2ww9uwcRb3F6TN8"
    And el cabas conte productes
    And el usuari clica a la opcio amb text "Proceed To Checkout" 
    And el usuari clica a la opcio amb text "Place Order" 
    And el usuari introdueix el valor "Test Lopez" al camp "name_on_card"
    And el usuari introdueix el valor "1111222233334444" al camp "card_number"
    And el usuari introdueix el valor "999" al camp "cvc"
    And el usuari introdueix el valor "10" al camp "expiry_month"
    And el usuari introdueix el valor "1900" al camp "expiry_year"
    
    # Botó de Payment and Confirm, un cop hem omplert les dades de facturació
    When el usuari clica a la opcio amb id "submit"		
    Then es valida que la comanda ha estat realitzada correctament