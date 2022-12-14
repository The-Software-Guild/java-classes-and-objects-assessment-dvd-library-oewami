package dto;


public class DVD {

    private String title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String userNotes;

    public DVD() {}

    public DVD(String title, String releaseDate, String rating, String directorName, String studio, String userNotes) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNotes = userNotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)  {this.releaseDate = releaseDate; }

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

    @Override
    public String toString() {
        String builder = "Title: " + this.title + ", " +
                "Release Date: " + this.releaseDate + ", " +
                "MPAA Rating: " + this.rating + ", " +
                "Director's Name: " + this.directorName + ", " +
                "Studio: " + this.studio + ", " +
                "User Notes: " + this.userNotes;
        return builder;
    }
}
