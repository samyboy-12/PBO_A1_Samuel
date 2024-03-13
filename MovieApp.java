import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class MovieApp {
    public List<Film> films;
    public List<Integer> bookingIds;
    public Scanner scanner;

    public MovieApp() {
        films = new ArrayList<>();
        bookingIds = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film);
        }
    }

    public void searchFilm(String title) {
        boolean found = false;
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Film Tersedia");
                System.out.println(film);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Film Tidak Tersedia");
        }
    }

    public void bookFilm(Film film) {
        System.out.print("Masukkan jumlah tiket yang ingin dipesan untuk film " + film.getTitle() + ": ");
        int numberOfTickets = scanner.nextInt();

        if (film.getAvailableSeats() >= numberOfTickets) {
            int bookingId = generateBookingId();
            film.decreaseAvailableSeats(numberOfTickets);
            bookingIds.add(bookingId);
            System.out.println("Pesanan berhasil dengan detail pesanan:");
            System.out.println("Film: " + film.getTitle());
            System.out.println("Jumlah Tiket: " + numberOfTickets);
            System.out.println("Booking ID: " + bookingId);
        } else {
            System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
        }
    }

    private int generateBookingId() {
        Random random = new Random();
        int id;
        do {
            id = random.nextInt(1000); // Random ID between 0 and 999
        } while (bookingIds.contains(id));
        return id;
    }

    public void searchBooking(int bookingId) {
        if (bookingIds.contains(bookingId)) {
            System.out.println("Pesanan Ditemukan dengan ID: " + bookingId);
        } else {
            System.out.println("Pesanan Tidak Ditemukan");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
