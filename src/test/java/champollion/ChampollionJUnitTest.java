package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	
        //heuresPrevues
	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
        //ajouterEnseignement
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	//heuresPrevues
        @Test
        public void testHeuresPrevues () {
            untel.ajouteEnseignement(uml, 0, 1, 4);
            untel.ajouteEnseignement(java,  2, 1, 0);
            assertEquals(8, untel.heuresPrevues(),
                        "Cet enseignant doit avoir 8 heures prévues");
        }
        
        //enSousService
        @Test
        public void testSousService () {
            untel.ajouteEnseignement(uml, 0, 1, 4);
            untel.ajouteEnseignement(java,  2, 1, 0);
            assertEquals(true, untel.enSousService(),
                        "Cet enseignant est en sous service");
        }
        //Nn enSousService
        @Test
        public void testNonSousService () {
            untel.ajouteEnseignement(java,  0, 192, 0);
            assertEquals(false, untel.enSousService(),
                        "Cet enseignant n'est pas en sous service");
        }
        
        //resteAPlanifier -> ajouterIntervention
        @Test
        public void testResteAPlanifier () {
            Date date = new Date();
            untel.ajouterIntervention(new Intervention(date, 2, 1, uml, TypeIntervention.TD));
            untel.ajouteEnseignement(uml, 2, 4, 4);
            
            assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.TD),
                        "Il retse 2 heures à effectuer");
            
            assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.CM),
                        "Il retse 2 heures à effectuer");
            
            assertEquals(4, untel.resteAPlanifier(uml, TypeIntervention.TP),
                        "Il retse 2 heures à effectuer");
        }
}
