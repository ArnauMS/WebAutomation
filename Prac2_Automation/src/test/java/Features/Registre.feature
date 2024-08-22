Feature: Registre
  Comprova el registre de nous usuaris i la eliminacio de les comptes

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web

	@Automation @Registre @Registre_CrearCompte
	Scenario: Crear un nou compte
		Given el usuari clica a la opcio amb text "Signup / Login"
	  And el usuari introdueix el valor "testing_tqs" al camp "name"
	  
	  # Introduir el correu a 
	  And el usuari introdueix el valor "testing@auto.com" al camp CSS ".signup-form input:nth-child(3)"
	  
	  # Botó "Signup" a l'apartat de New User Signup!
	  And el usuari clica a la opcio amb CSS ".btn:nth-child(5)"

	  # Selecciona genere
	  And el usuari clica a la opcio amb id "id_gender1"
	  And el usuari introdueix el valor "testeig123" al camp ID "password"
	  And el usuari selecciona data de naixement
	  
	  # Selecciona l'opció "Sign up for our newsletter!"
	  And el usuari clica a la opcio amb id "newsletter"
	  
	  # Selecciona l'opció "Receive special offers from our partners!"
	  And el usuari clica a la opcio amb id "optin"
	  
	  # Diversos camps
	  And el usuari introdueix el valor "Test" al camp ID "first_name"
	  And el usuari introdueix el valor "Lopez" al camp ID "last_name"
	  And el usuari introdueix el valor "UAB" al camp ID "company"
	  And el usuari introdueix el valor "Plaça Civica 1" al camp ID "address1"
	  And el usuari introdueix el valor "Plaça Civica 2" al camp ID "address2"
	  And el usuari selecciona el pais
	  And el usuari introdueix el valor "Spain" al camp ID "state"
	  And el usuari introdueix el valor "Barcelona" al camp ID "city"
	  And el usuari introdueix el valor "08923" al camp ID "zipcode"
	  And el usuari introdueix el valor "mobile_number" al camp ID "mobile_number" 
	  
	  # Clica al botó de "Create Account" per crear un nou compte
	  When el usuari clica a la opcio amb path "//button[@type='submit']"  
	  Then es valida que el compte ha sigut creat correctament
   		
	@Automation @Registre @Registre_EsborrarCompte
  Scenario: Esborrar compte
		Given el usuari inicia sessio amb correu "testing@auto.com" i password "testeig123"
	  When el usuari accedeix al menu "Delete Account"
	  Then es valida que el compte ha sigut eliminat correctament