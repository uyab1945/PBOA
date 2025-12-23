package pbop11;

import java.util.Scanner;

abstract class Penumpang {
    protected String nama;
    protected String noTiket;

    public Penumpang(String nama, String noTiket) {
        this.nama = nama;
        this.noTiket = noTiket;
    }

    // Abstract method yang harus di-override oleh subclass
    public abstract double hitungHargaTiket();

    public void tampilkanData() {
        System.out.println("Nama: " + nama);
        System.out.println("No Tiket: " + noTiket);
        System.out.println("Harga Tiket: Rp" + hitungHargaTiket());
    }
    
    // Overloading pada method tampilkanData()
    public void tampilkanData(String pesanTambahan) {
        tampilkanData();
        System.out.println("Catatan: " + pesanTambahan);
    }
}

class PenumpangReguler extends Penumpang {
    public PenumpangReguler(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // Overriding hitungHargaTiket untuk Reguler
    @Override
    public double hitungHargaTiket() {
        return 500000; // Harga flat untuk reguler
    }
}

class PenumpangVIP extends Penumpang {
    public PenumpangVIP(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // Overriding hitungHargaTiket untuk VIP
    @Override
    public double hitungHargaTiket() {
        return 1000000; // Harga lebih mahal untuk VIP
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Input Data Penumpang ---");
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan No Tiket: ");
        String noTiket = input.nextLine();
        
        System.out.println("Pilih Jenis Penumpang:");
        System.out.println("1. Reguler");
        System.out.println("2. VIP");
        System.out.print("Pilihan (1/2): ");
        int pilihan = input.nextInt();

        Penumpang penumpang; // Polimorfisme: Variabel referensi tipe superclass

        if (pilihan == 1) {
            penumpang = new PenumpangReguler(nama, noTiket);
        } else {
            penumpang = new PenumpangVIP(nama, noTiket);
        }

        System.out.println("\n--- Detail Informasi Penumpang ---");
        // Memanggil method yang di-overload jika VIP
        if (penumpang instanceof PenumpangVIP) {
            penumpang.tampilkanData("Mendapatkan akses Lounge Bandara.");
        } else {
            penumpang.tampilkanData();
        }
        
        input.close();
    }
}
