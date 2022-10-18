package dao;

import dto.DVD;

import java.util.Date;
import java.util.List;

public interface DVDLibraryDao {

    public DVD addDVD(DVD dvd);

    public DVD search(String title);

    public DVD removeDVD(String title);

    public DVD updateDVD(String title);

    public DVD searchInfo(String title);

    List<DVD> getLibrary();

}
