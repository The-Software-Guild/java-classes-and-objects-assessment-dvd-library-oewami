package controller;

import dao.DVDLibrary;
import dao.DVDLibraryDao;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;

import java.text.ParseException;
import java.util.Date;

public class DVDLibraryController {

    private DVDLibraryDao dao = new DVDLibrary();
    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIO();

    public void run() throws ParseException {
        boolean isContinuing = true;
        String input = view.getMenu();

        while(isContinuing) {
            switch(input) {
                case "1":
                    io.print("Get DVD Library");
                    break;
                case "2":
                    io.print("2. Create new DVD");
                    createDVD();
                    break;
                case "3":
                    io.print("3. Remove a DVD");
                    break;
                case "4":
                    io.print("4. Get DVD info");
                    break;
                case "5":
                    io.print("5. Delete a DVD");
                    break;
                case "6":
                    io.print("6. Exit");
                    isContinuing = false;
                    break;
                default:
                    io.print("Invalid input");
            }
        }
        io.print("Closing Library");
    }

    private void createDVD() throws ParseException {
        DVD dvd = view.createDVD();
        dao.addDVD(dvd);
        io.print("Created DVD");
    }
}
