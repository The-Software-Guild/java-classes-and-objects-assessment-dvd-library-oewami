package dto;

import java.util.Date;

public class DVD {
    /**
     * Title
     * Release date
     * MPAA rating
     * Director's name
     * Studio
     * User rating or note (allows the user to enter additional information, e.g., "Good family movie")
     */
    private String title;
    private Date date;
    private String rating;
    private String directorName;
    private String studio;
    private String userNotes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
}
