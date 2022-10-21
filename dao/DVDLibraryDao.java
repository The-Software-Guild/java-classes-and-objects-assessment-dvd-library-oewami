package dao;

import dto.DVD;

import java.io.IOException;
import java.util.List;

public interface DVDLibraryDao {

    public DVD createDVD(String[] details) throws IOException;

    public DVD search(String title) throws IOException;

    public boolean removeDVD(String title) throws IOException;

    public DVD updateTitle(String originalTitle, String updatedTitle) throws IOException;

    public DVD updateReleaseDate(String title, String updatedDate) throws IOException;

    public DVD updateRating(String title, String updatedRating) throws IOException;

    public DVD updateDirectorName(String title, String updatedDirectorName) throws IOException;

    public DVD updateStudio(String title, String updatedStudio) throws IOException;

    public DVD updateUserNotes(String title, String updatedUserNotes) throws IOException;

//    public DVD searchInfo(String title);

    List<DVD> getLibrary() throws IOException;

}
