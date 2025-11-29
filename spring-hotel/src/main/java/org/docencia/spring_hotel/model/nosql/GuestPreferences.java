package org.docencia.spring_hotel.model.nosql;

import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
/**
 * @author nexphernandez
 * @version 1.0.0
 */
@Document(collection = "guest_preferences")
public class GuestPreferences {

    @Id
    private String guestId ;

    private String preferredLanguage; 

    private boolean newsletterOptIn; 

    private List<String> tags;  

    private String favoriteRoomType ;  

    private String notes;    
    
    /**
     * Cosntructor vacio
     */
    public GuestPreferences() {
    }

    /**
     * Cosntructor con todos los atributos de la clase
     * @param guestId id del guest
     * @param preferredLanguage leguaje de preferecia del guest
     * @param newsletterOptIn si tiene preferencia a recibir el preiodico
     * @param tags etiquetas del guest
     * @param favoriteRoomType tipo de habitacion favorita del guest
     * @param notes notas del guest
     */
    public GuestPreferences(String guestId, String preferredLanguage, boolean newsletterOptIn, List<String> tags, String favoriteRoomType, String notes) {
        this.guestId = guestId;
        this.preferredLanguage = preferredLanguage;
        this.newsletterOptIn = newsletterOptIn;
        this.tags = tags;
        this.favoriteRoomType = favoriteRoomType;
        this.notes = notes;
    }

    /**
     * Constructor con el identificardor de la clase
     * @param guestId identificador del guest
     */
    public GuestPreferences(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestId() {
        return this.guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public boolean isNewsletterOptIn() {
        return this.newsletterOptIn;
    }

    public boolean getNewsletterOptIn() {
        return this.newsletterOptIn;
    }

    public void setNewsletterOptIn(boolean newsletterOptIn) {
        this.newsletterOptIn = newsletterOptIn;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getFavoriteRoomType() {
        return this.favoriteRoomType;
    }

    public void setFavoriteRoomType(String favoriteRoomType) {
        this.favoriteRoomType = favoriteRoomType;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestPreferences)) {
            return false;
        }
        GuestPreferences guestPreferences = (GuestPreferences) o;
        return Objects.equals(guestId, guestPreferences.guestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }

    @Override
    public String toString() {
        return "{" +
            " guestId='" + getGuestId() + "'" +
            ", preferredLanguage='" + getPreferredLanguage() + "'" +
            ", newsletterOptIn='" + isNewsletterOptIn() + "'" +
            ", tags='" + getTags() + "'" +
            ", favoriteRoomType='" + getFavoriteRoomType() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
    
}
