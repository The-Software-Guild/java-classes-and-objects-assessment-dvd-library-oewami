package dao;

import dto.DVD;

import java.util.*;

public class DVDLibrary implements DVDLibraryDao {

    /**
     * Adds a DVD to the library.
     *
     * @param dvdTitle title of the dvd
     * @param releaseDate the release date of the dvd
     * @param rating the MPAA rating of the dvd (R for mature, G for general, etc
     * @param directorName the name of the director of the dvd
     * @param studio the name of the studio that created the dvd
     * @param userNotes additional information that the user has for the dvd
     * @return
     */
    private List<DVD> library = new ArrayList<>();

    @Override
    public DVD addDVD(String dvdTitle, Date releaseDate, String Rating, String directorName, String studio, String userNotes) {
        // TODO
        return new DVD();
    }

    @Override
    public DVD search(String title) {
        // TODO
        return null;
    }

    /**
     * Removes the DVD associated with the given title from the library.
     * Returns the DVD object that is being removed
     *
     * @param title title of the DVD to be removed
     * @return DVD object that was removed
     */
    @Override
    public DVD removeDVD(String title) {
        // TODO
        return null;
    }

    /**
     * Searches for the DVD with the given title from the library.
     *
     * @param title title of the DVD to be updated
     * @return DVD object with the updates
     */
    @Override
    public DVD updateDVD(String title) {
        // TODO
        return null;
    }

    /**
     * Returns the DVD object associated with the given title.
     *
     * @param title title of the DVD to retrieve
     * @return the DVD object associated with the given title
     */
    @Override
    public DVD getDVDInfo(String title) {
        // TODO
        return null;
    }

    /**
     * Returns a List of all the DVDs in the library
     *
     * @return List containing all the DVDs in the library
     */
    @Override
    public List<DVD> getLibrary() {
        // TODO
        return new ArrayList<>();
    }

}