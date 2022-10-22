package dao;

import dto.DVD;

import java.io.IOException;
import java.util.List;

public interface DVDLibraryDao {

    public DVD createDVD(String[] details);

    public DVD search(String title);

    public boolean removeDVD(String title);

    public DVD updateTitle(String originalTitle, String updatedTitle);

    public DVD updateReleaseDate(String title, String updatedDate);

    public DVD updateRating(String title, String updatedRating);

    public DVD updateDirectorName(String title, String updatedDirectorName);

    public DVD updateStudio(String title, String updatedStudio);

    public DVD updateUserNotes(String title, String updatedUserNotes);

    List<DVD> getLibrary();

    void save() throws IOException;
}
