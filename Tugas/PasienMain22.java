package Tugas;

import java.util.Scanner;

public class PasienMain22 {
    Pasien22[] antrian;
    int front;
    int rear;
    int size;
    int max;

    public PasienMain22(int n) {
        max = n;
        size = 0;
        front = 0;
        rear = -1;
        antrian = new Pasien22[max];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pasien22 antri) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            antrian[rear] = antri;
            size++;
        } else {
            System.out.println("Antrian sudah penuh.");
        }
    }

    public Pasien22 dequeue() {
        if (!isEmpty()) {
            Pasien22 antri = antrian[front];
            front = (front + 1) % max;
            size--;
            return antri;
        } else {
            System.out.println("Antrian sudah kosong.");
            return null;
        }
    }

    public void print() {
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.println(antrian[i].toString());
            i = (i + 1) % max;
            count++;
        }
    }

    public Pasien22 peek() {
        if (!isEmpty()) {
            return antrian[front];
        } else {
            System.out.println("Antrian kosong.");
            return null;
        }
    }

    public Pasien22 peekRear() {
        if (!isEmpty()) {
            return antrian[rear];
        } else {
            System.out.println("Antrian kosong.");
            return null;
        }
    }

    public void peekPosition(String nama) {
        int count = 0;
        int i = front;
        while (count < size) {
            if (antrian[i].nama.equals(nama)) {
                System.out.println(nama + " berada di posisi antrian ke-" + (count + 1));
                return;
            }
            i = (i + 1) % max;
            count++;
        }
        System.out.println("Pasien dengan nama " + nama + " tidak ditemukan dalam antrian.");
    }

    public void daftarPasien() {
        System.out.println("Daftar Pasien:");
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.println((count + 1) + ". " + antrian[i].toString());
            i = (i + 1) % max;
            count++;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PasienMain22 antrianKlinik = new PasienMain22(10);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Tambah Pasien");
                System.out.println("2. Hapus Pasien");
                System.out.println("3. Lihat Pasien Paling Depan");
                System.out.println("4. Lihat Pasien Paling Belakang");
                System.out.println("5. Cari Pasien");
                System.out.println("6. Lihat Daftar Pasien");
                System.out.println("0. Keluar");
                System.out.print("Pilih menu: ");
                int menu = scanner.nextInt();

                switch (menu) {
                    case 0:
                        System.out.println("Program selesai.");
                        System.exit(0);
                    case 1:
                        scanner.nextLine(); // membersihkan newline
                        System.out.print("Nama: ");
                        String nama = scanner.nextLine();
                        System.out.print("Nomor ID: ");
                        int noID = scanner.nextInt();
                        System.out.print("Jenis Kelamin (L/P): ");
                        char jenisKelamin = scanner.next().charAt(0);
                        System.out.print("Umur: ");
                        int umur = scanner.nextInt();
                        Pasien22 pasienBaru = new Pasien22(nama, noID, jenisKelamin, umur);
                        antrianKlinik.enqueue(pasienBaru);
                        System.out.println("Pasien " + nama + " telah ditambahkan ke dalam antrian.");
                        break;
                    case 2:
                        Pasien22 pasienDihapus = antrianKlinik.dequeue();
                        if (pasienDihapus != null) {
                            System.out.println("Pasien yang dihapus dari antrian: " + pasienDihapus.toString());
                        }
                        break;
                    case 3:
                        Pasien22 pasienDepan = antrianKlinik.peek();
                        if (pasienDepan != null) {
                            System.out.println("Pasien paling depan: " + pasienDepan.toString());
                        }
                        break;
                    case 4:
                        Pasien22 pasienBelakang = antrianKlinik.peekRear();
                        if (pasienBelakang != null) {
                            System.out.println("Pasien paling belakang: " + pasienBelakang.toString());
                        }
                        break;
                    case 5:
                        scanner.nextLine(); // membersihkan newline
                        System.out.print("Nama Pasien yang dicari: ");
                        String namaCari = scanner.nextLine();
                        antrianKlinik.peekPosition(namaCari);
                        break;
                    case 6:
                        antrianKlinik.daftarPasien();
                        break;
                    default:
                        System.out.println("Menu tidak valid.");
                        break;
                }
                System.out.println();
            }
        }
    }
}
