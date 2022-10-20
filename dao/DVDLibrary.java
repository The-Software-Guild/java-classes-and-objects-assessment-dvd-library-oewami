package dao;

import dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibrary implements DVDLibraryDao {

    private final String DVD_FILE;
    private final String DELIMITER = "::";
    private List<DVD> library = new ArrayList<>();

    private final int TITLE = 0;
    private final int RELEASE_DATE = 1;
    private final int RATING = 2;
    private final int DIRECTOR_NAME = 3;
    private final int STUDIO = 4;
    private final int USER_NOTES = 5;


    public DVDLibrary()  {
        this.DVD_FILE = "test.txt";
    }

    public DVDLibrary(String file) {
        this.DVD_FILE = file;
    }

    public String DVDtoFileString(DVD dvd) {
        String formattedString = dvd.getTitle() + DELIMITER
                + dvd.getReleaseDate() + DELIMITER
                + dvd.getRating() + DELIMITER
                + dvd.getDirectorName() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getUserNotes() + "\n";
        return formattedString;
    }

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

    public List<DVD> convertFileToLibrary() throws IOException {
        if(library.isEmpty()) {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(DVD_FILE));
            while ((line = reader.readLine()) != null) {
                library.add(stringToDVD(line));
            }
            reader.close();
        }
        return library;
    }


    public void replace(DVD dvd, String oldText, String replacement, int section) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DVD_FILE));
        String line;
        StringBuffer builder = new StringBuffer();
        boolean isFound = false;

        while((line = reader.readLine()) != null) {

            if(DVDtoFileString(dvd).split(DELIMITER)[section].equals(oldText)) {
                String[] details = line.split(DELIMITER);
                isFound = true;
                details[section] = replacement;
                StringBuilder lineBuilder = new StringBuilder();

                for(int i = 0; i < details.length; i++) {
                    String detail = details[i];
                    lineBuilder.append(detail);
                    if(i < details.length - 1) {
                        lineBuilder.append(DELIMITER);
                    }
                }
                line = lineBuilder.toString();
            }
            builder.append(line);
            builder.append(System.lineSeparator());
        }

        if(isFound) {
            FileWriter writer = new FileWriter(DVD_FILE);
            writer.append(builder.toString());
            writer.flush();
            writer.close();
        }
        reader.close();
    }

    /**
     * Adds a DVD to the library.
     *
     * @return The DVD that was added to the library.
     */
    @Override
    public DVD createDVD(String[] details) throws IOException {
        DVD dvd = new DVD(details[TITLE], details[RELEASE_DATE], details[RATING], details[DIRECTOR_NAME], details[STUDIO], details[USER_NOTES]);
        library.add(dvd);
        BufferedWriter writer = new BufferedWriter(new FileWriter(DVD_FILE, true));
        writer.write(DVDtoFileString(dvd));
        writer.close();
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
    public DVD removeDVD(String title) throws IOException {
        DVD dvd = search(title);
        BufferedWriter writer = new BufferedWriter(new FileWriter(DVD_FILE, true));
        writer.write(DVDtoFileString(dvd));
        writer.close();
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
    public DVD updateTitle(String originalTitle, String updatedTitle) throws IOException {
        DVD dvd = search(originalTitle);
        if(dvd != null) {
            dvd.setTitle(updatedTitle);
            replace(dvd, originalTitle, updatedTitle, TITLE);
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
    public DVD updateReleaseDate(String title, String updatedDate) throws IOException {
        DVD dvd = search(title);
        if(dvd != null) {
            replace(dvd, dvd.getReleaseDate(), updatedDate, RELEASE_DATE);
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
    public DVD updateRating(String title, String updatedRating) throws IOException {
        DVD dvd = search(title);
        if(dvd != null) {
            replace(dvd, dvd.getRating(), updatedRating, RATING);
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
    public DVD updateDirectorName(String title, String updatedDirectorName) throws IOException {
        DVD dvd = search(title);
        if(dvd != null) {
            replace(dvd, dvd.getDirectorName(), updatedDirectorName, DIRECTOR_NAME);
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
    public DVD updateStudio(String title, String updatedStudio) throws IOException {
        DVD dvd = search(title);
        if(dvd != null) {
            replace(dvd, dvd.getStudio(), updatedStudio, STUDIO);
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
    public DVD updateUserNotes(String title, String updatedUserNotes) throws IOException {
        DVD dvd = search(title);
        if(dvd != null) {
            replace(dvd, dvd.getUserNotes(), updatedUserNotes, USER_NOTES);
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
    public List<DVD> getLibrary() throws IOException {
        convertFileToLibrary();
        return library;
    }

}