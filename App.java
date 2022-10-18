import controller.DVDLibraryController;
import ui.UserIO;

import java.text.ParseException;

public class App {

    public static void main(String[] args) throws ParseException {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();

    }
}
