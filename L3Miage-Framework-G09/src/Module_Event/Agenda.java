package Module_Event;

import java.util.List;

/**
 * La classe Agenda permet d'initialiser une liste d'événements pour un utilisateur.
 * Dans cette classe, on peut aussi ajouter (@see {@link Agenda#ajouterEvent(Event)}) 
 * ou supprimer (@see {@link Agenda#supprimerEvent(Event)}) des événements 
 * à la liste des événements d'un utilisateur (@see {@link Agenda#events})
 * 
 * @version 1.0
 * @date 13/04/2017
 * @author Maxime RAMADANOSKI
 */
public class Agenda {
	/**
	 * La liste d'événements constituant un agenda.
	 * Cette liste est sujette à modifications.
	 * 
	 * @see Agenda#ajouterEvent(Event)
	 * @see Agenda#supprimerEvent(Event)
	 * @see Agenda#setEvents(List)
	 */
	private List<Event> events;
	/**
	 * Constructeur principal de l'Agenda.
	 *
	 */
	public Agenda(){
		
	}
	
	/**
	 * Constructeur secondaire de l'Agenda.
	 * @param events
	 */
	public Agenda(List <Event> events){
		this.events = events;
	}
	
	/**
	 * Retourne la liste des événements existants.
	 * @return events
	 */
	private List<Event> getEvents() {
		return events;
	}

	/**
	 * Met à jour la liste des événements existants.
	 * @param events
	 * 			Les nouveaux événements.
	 */
	private void setEvents(List<Event> events) {
		this.events = events;
	}
	
	/**
	 * Ajoute un événement à la liste des événements.
	 * @param e
	 * 			Le nouvel événement.
	 */
	private void ajouterEvent(Event e){
		events.add(e);
	}
	
	/**
	 * Supprime un événement de la liste des événements.
	 * @param e
	 * 			L'événement supprimé.
	 */
	private void supprimerEvent(Event e){
		events.remove(e);
	}
	
	
}
