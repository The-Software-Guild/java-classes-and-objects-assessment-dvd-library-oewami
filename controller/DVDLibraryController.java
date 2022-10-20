package controller;

import dao.DVDLibrary;
import dao.DVDLibraryDao;
import dto.DVD;
import ui.DVDLibraryView;

import java.io.IOException;
import java.util.List;


public class DVDLibraryController {

    private DVDLibraryDao dao = new DVDLibrary();
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
                    System.out.println("Invalid input");
            }
        }
        view.closeScanner();

    }

    private void createDVD() throws IOException {
        String[] details = view.createDVD();
        dao.createDVD(details);
    }

    private void getLibrary() throws IOException {
        List<DVD> library = dao.getLibrary();
        for(DVD dvd : library) {
            view.getDVDInfo(dvd);
        }
    }

    private void editDVD() throws IOException {
        boolean isValidInput = false;

        while(!isValidInput) {
            String choice = view.getEditMenu();
            String title = view.search();

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
                    System.out.println("Invalid input");

            }
        }

    }

    private DVD updateTitle(String originalTitle, String updatedTitle) throws IOException{
        return dao.updateTitle(originalTitle, updatedTitle);
    }

    private DVD updateReleaseDate(String title, String updatedDate)  throws IOException{
        return dao.updateReleaseDate(title, updatedDate);
    }

    private DVD updateRating(String title, String updatedRating) throws IOException {
        return dao.updateRating(title, updatedRating);
    }

    private DVD updateDirectorName(String title, String updatedDirectorName) throws IOException {
        return dao.updateDirectorName(title, updatedDirectorName);
    }

    private DVD updateStudio(String title, String updatedStudio) throws IOException {
        return dao.updateStudio(title, updatedStudio);
    }

    private DVD updateUserNotes(String title, String updatedUserNotes) throws IOException {
        return dao.updateUserNotes(title, updatedUserNotes);
    }

    private void removeDVD() throws IOException {
        String titleToRemove = view.search();
        dao.removeDVD(titleToRemove);
    }

    private void searchDVD() throws IOException {
        DVD dvd = dao.search(view.search());
        view.getDVDInfo(dvd);
    }

}
