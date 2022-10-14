package dao;

import dto.DVD;

import java.util.Date;
import java.util.List;

public interface DVDLibraryDao {

    public DVD addDVD(String dvdTitle, Date releaseDate, String rating, String directorName, String studio, String userNotes);

    public DVD search(String title);

    public DVD removeDVD(String title);

    public DVD updateDVD(String title);

    public DVD getDVDInfo(String title);

    List<DVD> getLibrary();

}
