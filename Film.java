class Film {
    public String title;
    public String genre;
    public int duration;
    public int availableSeats;

    public Film(String title, String genre, int duration, int availableSeats) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decreaseAvailableSeats(int numTickets) {
        availableSeats -= numTickets;
    }

    @Override
    public String toString() {
        return title + " - " + genre + " - Duration: " + duration + " mins - Available Seats: " + availableSeats;
    }
}
