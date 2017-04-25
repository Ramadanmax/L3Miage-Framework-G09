package Module_Securite;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import FrameworkExceptions.FrameworkException;
/**
 * La classe Authentification récupère un login, un mot de passe et un fichier XML. 
 * Le fichier XML énumère l'ensemble des utilisateurs, suivant un XMLSchema bien définit.
 * 
 * @version 1.0
 * @date 25/04/2017
 * @author Yannick Falco && Maxime Vanbossel
 *
 */
public class Authentification {
	
			private String login;
	        private String pwd;
			private File XMLName;			
            private boolean valide;
            
            /**
             * Le constructeur Authentification de cette classe réalise une authentification à partir du login, du mot de passe et du fichier XML fournit.
             * 
             * @param login
             * @param pwd
             * @param XMLName
             */
            
            public Authentification(String login, String pwd, File XMLName){
            	valide = false;            	
            	this.login = login;
	            this.pwd = pwd;
	            this.XMLName = XMLName;            	
            }
	    
            /**
             * La méthode reconnaissance vérifie si la combinaison login/Mot de passe 
             * existe dans le fichier XML. Dans le cas où celle-ci existe, la variable valide,
             * initialisée à false, prend la valeur true.
             * Dans le cas contraire, cette méthode renvoie une FrameworkException.
             * 
             * @return valide
             * @throws FrameworkException
             */
		    boolean reconnaissance() throws FrameworkException {
		    			    	
		        try {
		        	
		            // analyse du document
		            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		            DocumentBuilder p = dbFactory.newDocumentBuilder();
		            
		            // récupération de la structure objet du document
		            Document doc = p.parse(XMLName);
		            
		            for(int i=0; i<doc.getElementsByTagName("login").getLength();i++){
		            	if(login.equals(doc.getElementsByTagName("login").item(i).getTextContent()) && pwd.equals(doc.getElementsByTagName("pwd").item(i).getTextContent())){
		            		valide = true;
		            	}
		            	
		            }
		            if(!valide){
		            	throw new FrameworkException("Les identifiants fournis sont invalides.");
		            }
		            
		        } catch (Exception e) {
		        	System.out.println(e);
		        }
				return valide;
		    }


			/**
			 * La méthode getLogin retourne le login
			 * @return the login
			 */
			public String getLogin() {
				return login;
			}


			/**
			 * La méthode setLogin met à jour le login
			 * @param login the login to set
			 */
			public void setLogin(String login) {
				this.login = login;
			}

			/**
			 * La méthode setPwd met à jour le mot de passe
			 * @param pwd the pwd to set
			 */
			public void setPwd(String pwd) {
				this.pwd = pwd;
			}


			/**
			 * La méthode getXMLName retourne le fichier XML
			 * @return the xMLName
			 */
			public File getXMLName() {
				return XMLName;
			}


			/**
			 * La méthode setXMLName met à jour le fichier XML
			 * @param xMLName the xMLName to set
			 */
			public void setXMLName(File xMLName) {
				XMLName = xMLName;
			}
}