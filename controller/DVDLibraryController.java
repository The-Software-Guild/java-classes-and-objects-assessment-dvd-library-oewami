package controller;

import dao.DVDLibraryDaoImpl;
import dao.DVDLibraryDao;
import dto.DVD;
import ui.DVDLibraryView;

import java.io.IOException;
import java.util.List;


public class DVDLibraryController {

    private DVDLibraryDao dao = new DVDLibraryDaoImpl();
    private DVDLibraryView view = new DVDLibraryView();

    /**
     * Main method to run in the application*
     */
    public void run() throws IOException {
        boolean isContinuing = true;

        while(isContinuing) {
            String input = view.getMenu();
            switch(input) {
                case "1":
                    getLibrary();
                    break;
                case "2":
                    createDVD();
                    break;
                case "3":
                    removeDVD();
                    break;
                case "4":
                    editDVD();
                    break;
                case "5":
                    searchDVD();
                    break;
                case "6":
                    isContinuing = false;
                    break;
                default:
                    view.displayInvalidInput();
            }
        }
        view.closeScanner();
        dao.save();

    }

    private void createDVD() {
        String[] details = view.createDVD();
        dao.createDVD(details);
    }

    private void getLibrary() {
        List<DVD> library = dao.getLibrary();
        for(DVD dvd : library) {
            view.displayDVDInfo(dvd);
        }
    }

    private void editDVD() {
        boolean isValidInput = false;
        boolean isDVDExist = false;
        String title = "";
        DVD dvd;

        // continue prompting the user for a valid title name that exists in the library
        do {
            title = view.getSearchTitle();
            dvd = dao.search(title);
            if(dvd != null) {isDVDExist = true;}
            else {view.displayNotFound();}
        } while(!isDVDExist);

        while(!isValidInput) {
            String choice = view.getEditMenu();

            switch (choice) {
                case "1":
                    //title
                    updateTitle(title, view.getUpdatedTitle());
                    isValidInput = true;
                    break;
                case "2":
                    //release date
                    updateReleaseDate(title, view.getUpdatedReleaseDate());
                    isValidInput = true;
                    break;
                case "3":
                    //mpaa rating
                    updateRating(title, view.getUpdatedRating());
                    isValidInput = true;
                    break;
                case "4":
                    //director name
                    updateDirectorName(title, view.getUpdatedDirectorName());
                    isValidInput = true;
                    break;
                case "5":
                    //studio
                    updateStudio(title, view.getUpdatedStudio());
                    isValidInput = true;
                    break;
                case "6":
                    //user notes
                    updateUserNotes(title, view.getUpdatedUserNotes());
                    isValidInput = true;
                    break;
                default:
                    view.displayInvalidInput();

            }
        }

    }

    private DVD updateTitle(String originalTitle, String updatedTitle) {
        return dao.updateTitle(originalTitle, updatedTitle);
    }

    private DVD updateReleaseDate(String title, String updatedDate) {
        return dao.updateReleaseDate(title, updatedDate);
    }

    private DVD updateRating(String title, String updatedRating) {
        return dao.updateRating(title, updatedRating);
    }

    private DVD updateDirectorName(String title, String updatedDirectorName) {
        return dao.updateDirectorName(title, updatedDirectorName);
    }

    private DVD updateStudio(String title, String updatedStudio) {
        return dao.updateStudio(title, updatedStudio);
    }

    private DVD updateUserNotes(String title, String updatedUserNotes) {
        return dao.updateUserNotes(title, updatedUserNotes);
    }

    private void removeDVD() {
        String titleToRemove = view.getSearchTitle();
        if(!dao.removeDVD(titleToRemove)) view.displayNotFound();
    }

    private void searchDVD() {
        DVD dvd = dao.search(view.getSearchTitle());
        if(dvd != null) {
            view.displayDVDInfo(dvd);
        } else {
            view.displayNotFound();
        }
    }

}
