import java.util.ArrayList;
import java.util.List;

class Barang {
    String namaBarang;
    int hargaBarang;
    int jumlahBarang;

    public Barang(String namaBarang, int hargaBarang, int jumlahBarang) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

}

class Keranjang {
    List<Barang> daftarBarang;
    int kapasitas = 5;

    public Keranjang() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        if (daftarBarang.size() < kapasitas) {
            daftarBarang.add(barang);
            System.out.println("Berhasil memasukan " + barang.namaBarang+" ke keranjang");
        } else {
            System.out.println("Keranjang sudah penuh!!");
        }
    }

    public void printHasil() {
        System.out.println("\n===");
        System.out.println("Jumlah Barang Di Keranjang Saat Ini : " + daftarBarang.size());
        System.out.println("Barang Pada Keranjang:");
        int totalHarga = 0;
        for (Barang barang : daftarBarang) {
            System.out.println("# " + barang.namaBarang + ", jumlah : " + barang.jumlahBarang);
            totalHarga += barang.hargaBarang * barang.jumlahBarang;
        }
        System.out.println("Total Harga Yang Harus di Bayar: " + totalHarga);
    }
}

public class Main {
    public static void main(String[] args) {
        Barang barang1 = new Barang("Beras", 50000, 1);
        Barang barang2 = new Barang("Sabun", 10000, 2);
        Barang barang3 = new Barang("Sampo", 15000, 2);
        Barang barang4 = new Barang("Gula", 5000, 3);

        Keranjang keranjang1 = new Keranjang();
        keranjang1.tambahBarang(barang1);
        keranjang1.tambahBarang(barang2);
        keranjang1.tambahBarang(barang3);
        keranjang1.tambahBarang(barang4);

        System.out.println("\n===");

        keranjang1.printHasil();
    }
}
