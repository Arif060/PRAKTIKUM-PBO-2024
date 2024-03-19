import java.util.ArrayList;
import java.util.Scanner;

class Game {
    private String nama;
    private int tahunTerbit;

    public Game(String nama, int tahunTerbit) {
        this.nama = nama;
        this.tahunTerbit = tahunTerbit;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Tahun Terbit: " + tahunTerbit;
    }
}

public class GameStore {
    private static ArrayList<Game> games = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Game");
            System.out.println("2. Tampilkan Semua Game");
            System.out.println("3. Update Game");
            System.out.println("4. Hapus Game");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahGame();
                    break;
                case 2:
                    tampilkanGame();
                    break;
                case 3:
                    updateGame();
                    break;
                case 4:
                    hapusGame();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tambahGame() {
        scanner.nextLine(); // clear buffer
        System.out.print("Masukkan nama game: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan tahun terbit: ");
        int tahunTerbit = scanner.nextInt();
        games.add(new Game(nama, tahunTerbit));
        System.out.println("Game berhasil ditambahkan.");
    }

    private static void tampilkanGame() {
        if (games.isEmpty()) {
            System.out.println("Belum ada game yang terdaftar.");
        } else {
            System.out.println("Daftar Game:");
            for (Game game : games) {
                System.out.println(game);
            }
        }
    }

    private static void updateGame() {
        if (games.isEmpty()) {
            System.out.println("Belum ada game yang terdaftar.");
        } else {
            System.out.print("Masukkan nama game yang akan diupdate: ");
            scanner.nextLine(); // clear buffer
            String nama = scanner.nextLine();
            boolean found = false;
            for (Game game : games) {
                if (game.getNama().equalsIgnoreCase(nama)) {
                    System.out.print("Masukkan tahun terbit baru: ");
                    int tahunTerbit = scanner.nextInt();
                    game.setTahunTerbit(tahunTerbit);
                    found = true;
                    System.out.println("Game berhasil diupdate.");
                    break;
                }
            }
            if (!found) {
                System.out.println("Game tidak ditemukan.");
            }
        }
    }

    private static void hapusGame() {
        if (games.isEmpty()) {
            System.out.println("Belum ada game yang terdaftar.");
        } else {
            System.out.print("Masukkan nama game yang akan dihapus: ");
            scanner.nextLine(); // clear buffer
            String nama = scanner.nextLine();
            boolean removed = false;
            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getNama().equalsIgnoreCase(nama)) {
                    games.remove(i);
                    removed = true;
                    System.out.println("Game berhasil dihapus.");
                    break;
                }
            }
            if (!removed) {
                System.out.println("Game tidak ditemukan.");
            }
        }
    }
}
