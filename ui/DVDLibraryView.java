package ui;

import dto.DVD;

public class DVDLibraryView {

    private UserIO io = new UserIO();

    public String getMenu() {
        io.print("Main Menu");
        io.print("1. Get DVD Library");
        io.print("2. Create new DVD");
        io.print("3. Remove a DVD");
        io.print("4. Get DVD info");
        io.print("5. Delete a DVD");
        io.print("6. Exit");

        return io.nextLine("Choice: ");
    }

    public DVD createDVD() {
        DVD dvd = new DVD();
        io.print("Details of DVD");
        String title = io.nextLine("DVD Title: ");
        String releaseDate = io.nextLine("Release date: dd/MM/yyyy");
        String rating = io.nextLine("Rating");
        String directorName = io.nextLine("Director Name:");
        String studio = io.nextLine("Studio: ");
        String userNotes = io.nextLine("Notes: ");
        dvd.setTitle(title);
        dvd.setDate(releaseDate);
        dvd.setRating(rating);
        dvd.setDirectorName(directorName);
        dvd.setStudio(studio);
        dvd.setUserNotes(userNotes);
        return dvd;
    }
}
