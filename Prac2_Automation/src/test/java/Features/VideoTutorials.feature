Feature: Video Tutorials
	Validar el funcionament del menú de Video Tutorials

	Background:
		Given el usuari accedeix al navegador "Chrome"
		
	@Automation @VideoTutorials @VideoTutorials_Acces
  Scenario: Accedir al menú de Video Tutorials
  	Given el usuari accedeix a la pagina web
  	
  	# Accedim al canal de YT
  	When el usuari accedeix al menu "Video Tutorials"
    Then es valida que el usuari ha accedit al menú "Video Tutorials" correctament