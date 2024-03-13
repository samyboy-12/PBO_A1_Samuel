import java.util.Scanner;

public class MovieTicketBooking {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();

        Film avenger = new Film("Avengers: Endgame", "Action", 180, 50);
        Film joker = new Film("Joker", "Drama", 122, 60);

        movieApp.addFilm(avenger);
        movieApp.addFilm(joker);

        movieApp.displayAllFilms();

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Mencari film:");
        System.out.print("Masukkan judul film yang ingin dicari: ");
        String searchTitle = scanner.nextLine();
        movieApp.searchFilm(searchTitle);

        System.out.println();
        System.out.println("Membuat pesanan:");
        System.out.print("Masukkan judul film yang ingin dipesan: ");
        String bookTitle = scanner.nextLine();
        Film filmToBook = null;
        for (Film film : movieApp.films) {
            if (film.getTitle().equalsIgnoreCase(bookTitle)) {
                filmToBook = film;
                break;
            }
        }
        if (filmToBook != null) {
            movieApp.bookFilm(filmToBook);
        } else {
            System.out.println("Film tidak ditemukan.");
        }

        System.out.println();
        System.out.println("Menampilkan list film setelah pemesanan:");
        movieApp.displayAllFilms();

        System.out.println();
        System.out.println("Mencari pesanan berdasarkan Booking ID:");
        System.out.print("Masukkan Booking ID: ");
        int searchBookingId = scanner.nextInt();
        movieApp.searchBooking(searchBookingId);

        movieApp.closeScanner();
    }
}
