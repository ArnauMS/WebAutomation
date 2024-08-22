Feature: LogIn
  Validar el inici i tancat de sessió per part del usuari

	Background:
		Given el usuari accedeix al navegador "Chrome"
		And el usuari accedeix a la pagina web
	
	@Automation @LogIn @LogIn_OK
  Scenario: Inici de sessió correcte
  	Given el usuari accedeix al menu "Signup / Login"
    And el usuari introdueix el valor "malfonso621@gmail.com" al camp "email"
    And el usuari introdueix el valor "2ww9uwcRb3F6TN8" al camp "password"
    
    # Botó "Login"
    When el usuari clica a la opcio amb CSS ".login-form .btn"		
    Then es valida que ha fet login correctament
    

	@Automation @LogIn @LogIn_ErrorMail
	Scenario Outline: Inici de sessió amb mail incorrecte
		Given el usuari accedeix al menu "Signup / Login"
	  And el usuari introdueix el valor <email> al camp "email"
	  And el usuari introdueix el valor <password> al camp "password"
	  
	  # Botó "Login"
	  When el usuari clica a la opcio amb CSS ".login-form .btn"
	  Then es valida que apareix un error de login
    
		Examples:
   		| email | 					| password | 				            
   		| "test@test.com" | | "2ww9uwcRb3F6TN8" | 
   		| "malfo@gmail.com" | | "2ww9uwcRb3F6TN8" |
   		| "hola1234@test.com" | | "2ww9uwcRb3F6TN8" | 


	@Automation @LogIn @LogIn_ErrorPwd
	Scenario Outline: Inici de sessió amb password incorrecte
		Given el usuari accedeix al menu "Signup / Login"
	  And el usuari introdueix el valor <email> al camp "email"
	  And el usuari introdueix el valor <password> al camp "password"
	  
	  # Botó de "Login"
	  When el usuari clica a la opcio amb CSS ".login-form .btn"
	  Then es valida que apareix un error de login
    
		Examples:
   		| email                   | | password | 				            
   		| "malfonso621@gmail.com" | | "hola" | 
   		| "malfonso621@gmail.com" | | "1234" |
   		| "malfonso621@gmail.com" | | "testing_auto" | 
   		
   		
	@Automation @LogIn @LogIn_Sortir
  Scenario: LogOut de la sessió
  	Given el usuari inicia sessio amb correu "malfonso621@gmail.com" i password "2ww9uwcRb3F6TN8"
    When el usuari accedeix al menu "Logout" 
    Then es valida que ha tancat la sessio