Feature: Contacte
  Comprovar que es pot contactar correctament amb la empresa

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web
	
	@Automation @Contacte @Contacte_EnviarMissatge
  Scenario Outline: Enviar missatge al suport
  	Given el usuari accedeix al menu "Contact us"
    And el usuari introdueix el valor <nom> al camp "name"
    And el usuari introdueix el valor <email> al camp "email"
    And el usuari introdueix el valor <subject> al camp "subject"
    And el usuari introdueix el valor "Això és una prova d'automatització per a la pràctica de TQS" al camp "message"
    
    # Botó per enviar el missatge al suport
    And el usuari clica a la opcio amb nom "submit"	
    When el usuari confirma el enviament
    Then es valida que el missatge esta enviat correctament
		    
		Examples:
			| 	nom 	| 			email				| subject		|
			| "Arnau" | "arnau@gmail.com" | "Prova1"	| 
			| "Marc" 	| "marc@gmail.com" 	| "Prova2"	| 
			| "Joan" 	| "joan@gmail.com" 	| "Prova2"	| 