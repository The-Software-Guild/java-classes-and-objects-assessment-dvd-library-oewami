package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoImpl implements DVDLibraryDao {

    private final String DVD_FILE;
    private final String DELIMITER = "::";
    private List<DVD> library = new ArrayList<>();

    private final int TITLE = 0;
    private final int RELEASE_DATE = 1;
    private final int RATING = 2;
    private final int DIRECTOR_NAME = 3;
    private final int STUDIO = 4;
    private final int USER_NOTES = 5;


    public DVDLibraryDaoImpl()  {
        this.DVD_FILE = "test.txt";
        convertFileToLibrary();
    }

    public DVDLibraryDaoImpl(String file) {
        this.DVD_FILE = file;
        convertFileToLibrary();
    }

    /**
     * Converts the DVD object into a formatted string to be stored in
     * a file
     * @param dvd the DVD object
     * @return DVD as string with delimiter
     */
    public String DVDtoFileString(DVD dvd) {
        String formattedString = dvd.getTitle() + DELIMITER
                + dvd.getReleaseDate() + DELIMITER
                + dvd.getRating() + DELIMITER
                + dvd.getDirectorName() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getUserNotes() + "\n";
        return formattedString;
    }

    /**
     * Converts text into a DVD object.
     * @param line The information of a DVD as a string
     * @return The DVD object
     */
    public DVD stringToDVD(String line) {
        String[] details = line.split(DELIMITER);
        DVD dvd = new DVD();
        dvd.setTitle(details[TITLE]);
        dvd.setReleaseDate(details[RELEASE_DATE]);
        dvd.setRating(details[RATING]);
        dvd.setDirectorName(details[DIRECTOR_NAME]);
        dvd.setStudio(details[STUDIO]);
        dvd.setUserNotes(details[USER_NOTES]);
        return dvd;
    }

    /**
     * Helper function for getLibrary. Takes the DVD_FILE and converts
     * the contents into DVD objects. Objects are then added to the
     * library.
     *
     * @return a List containing DVD objects
     */
    public List<DVD> convertFileToLibrary() {
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(DVD_FILE));
                while ((line = reader.readLine()) != null) {
                    library.add(stringToDVD(line));
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("FILE NOT FOUND");
            }
        return library;
    }

    /**
     * Adds a DVD to the library.
     *
     * @param details An array of information about the DVD
     * @return The DVD that was added to the library.
     */
    @Override
    public DVD createDVD(String[] details) {
        DVD dvd = new DVD(details[TITLE], details[RELEASE_DATE], details[RATING], details[DIRECTOR_NAME], details[STUDIO], details[USER_NOTES]);
        library.add(dvd);
        return dvd;
    }

    /**
     * Removes the DVD associated with the given title from the library.
     * true if the object was removed from the library. false if
     * the item does not exist.
     *
     * @param title title of the DVD to be removed
     * @return
     */
    @Override
    public boolean removeDVD(String title) {
        DVD dvd = search(title);
        if(dvd != null) {
            library.remove(dvd);
            return true;
        }
        return false;
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
        return library;
    }

    /**
     * Saves the DVD library from the program to the DVD_FILE.
     * Used when closing the application.
     *
     * @throws IOException
     */
    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(DVD_FILE));
        StringBuilder builder = new StringBuilder();
        String line;
        for(DVD dvd : library) {
            line = DVDtoFileString(dvd);
            builder.append(line);
        }
        writer.write(builder.toString());
        writer.close();
    }

}