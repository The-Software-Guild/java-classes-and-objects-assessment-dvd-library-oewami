package ui;

import dto.DVD;

public class DVDLibraryView {

    private UserIO io = new UserIO();

    public String getMenu() {
        io.print("Main Menu");
        io.print("1. Get DVD Library");
        io.print("2. Create new DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Get DVD info");
        io.print("6. Exit");

        return io.nextLine("Choice: ");
    }

    public String getEditMenu() {
        io.print("***Edit Menu***");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA rating");
        io.print("4. Director Name");
        io.print("5. Studio");
        io.print("6. User Notes");
//        io.print("5. 1-2 lunch, code review after 2");

        return io.nextLine("Choice:");
    }

    public String[] createDVD() {
        DVD dvd = new DVD();
        io.print("Please enter the details of DVD");
        String title = io.nextLine("DVD Title: ");
        String releaseDate = io.nextLine("Release date: dd/MM/yyyy");
        String rating = io.nextLine("Rating");
        String directorName = io.nextLine("Director Name:");
        String studio = io.nextLine("Studio: ");
        String userNotes = io.nextLine("Notes: ");
        String[] details = {title, releaseDate, rating, directorName, studio, userNotes};
        return details;
    }

    public void getDVDInfo(DVD dvd) {
        io.print(dvd.toString());
    }

    public String search() {
        String lookingFor = io.nextLine("Name of DVD you are looking for");
        return lookingFor;
    }

    public String getUpdatedTitle() {
        return io.nextLine("New Title");
    }

    public String getUpdatedReleaseDate() {
        return io.nextLine("New Release Date");
    }

    public String getUpdatedRating() {
        return io.nextLine("New MPAA Rating");
    }

    public String getUpdatedDirectorName() {
        return io.nextLine("New Director Name");
    }

    public String getUpdatedStudio() {
        return io.nextLine("New Studio");
    }

    public String getUpdatedUserNotes() {
        return io.nextLine("New User Notes");
    }

    public void closeScanner() {
        io.print("Closing Library");
        io.closeScanner();
    }
}
