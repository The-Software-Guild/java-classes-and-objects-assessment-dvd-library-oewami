package dao;

import dto.DVD;

import java.util.*;

public class DVDLibrary implements DVDLibraryDao {

    private List<DVD> library = new ArrayList<>();
    /**
     * Adds a DVD to the library.
     *
     * @return The DVD that was added to the library.
     */
    @Override
    public DVD addDVD(DVD dvd) {
        library.add(dvd);
        return dvd;
    }

    /**
     * Searches for a DVD with the given title from the library.
     *
     * @param title
     * @return The DVD that was found in the library. Null if
     * title does not exist
     */
    @Override
    public DVD search(String title) {
        for(DVD dvd : library) {
            if(dvd.getTitle().equals(title)) {
                return dvd;
            }
        }
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
        DVD dvd = search(title);
        library.remove(dvd);
        return dvd;
    }

    /**
     * Updates the DVD Title associated with the given title from the library.
     *
     * @param originalTitle original DVD title to search in the library
     * @param updatedTitle new title of the DVD
     * @return DVD object with updated title.
     */
    @Override
    public DVD updateTitle(String originalTitle, String updatedTitle) {
        DVD dvd = search(originalTitle);
        if(dvd != null) {
            dvd.setTitle(updatedTitle);
            return dvd;
        }
        return null;
    }

    /**
     * Updates the DVD release date associated with the given
     * title from the library.
     *
     * @param title DVD title to search in the library
     * @param updatedDate new title of the DVD
     * @return DVD object with updated title.
     */
    @Override
    public DVD updateReleaseDate(String title, String updatedDate) {
        DVD dvd = search(title);
        if(dvd != null) {
            dvd.setReleaseDate(updatedDate);
        }
        return null;
    }

    /**
     * Updates the DVD rating associated with the given title from the library.
     *
     * @param title DVD title to search in the library
     * @param updatedRating
     * @return DVD object with the updated rating
     */
    @Override
    public DVD updateRating(String title, String updatedRating) {
        DVD dvd = search(title);
        if(dvd != null) {
            dvd.setRating(updatedRating);
        }
        return null;
    }

    /**
     * Updates the DVD's director name associated with the
     * given title from the library.
     *
     * @param title DVD title to search in the library
     * @param updatedDirectorName
     * @return DVD object with the updated director name
     */
    @Override
    public DVD updateDirectorName(String title, String updatedDirectorName) {
        DVD dvd = search(title);
        if(dvd != null) {
            dvd.setDirectorName(updatedDirectorName);
        }
        return null;
    }

    /**
     * Updates the DVD studio associated with the given title from the library.
     *
     * @param title DVD title to search in the library
     * @param updatedStudio
     * @return DVD object with the updated studio
     */
    @Override
    public DVD updateStudio(String title, String updatedStudio) {
        DVD dvd = search(title);
        if(dvd != null) {
            dvd.setStudio(updatedStudio);
        }
        return null;
    }

    /**
     * Updates the DVD's user notes associated with the
     * given title from the library.
     *
     * @param title DVD title to search in the library
     * @param updatedUserNotes new user notes to be added to the DVD
     * @return DVD object with the updated user notes
     */
    @Override
    public DVD updateUserNotes(String title, String updatedUserNotes) {
        DVD dvd = search(title);
        if(dvd != null) {
            dvd.setUserNotes(updatedUserNotes);
        }
        return null;
    }


    /**
     * Returns a List of all the DVDs in the library
     *
     * @return List containing all the DVDs in the library
     */
    @Override
    public List<DVD> getLibrary() {
        return this.library;
    }

}