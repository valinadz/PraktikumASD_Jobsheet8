package Tugas;

public class Pasien22 {
    String nama;
    int noID;
    char jenisKelamin;
    int umur;
    
    public Pasien22(String nama, int noID, char jenisKelamin, int umur) {
        this.nama = nama;
        this.noID = noID;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
    }
    
    public String toString() {
        return "Nama: " + nama + ", Nomor ID: " + noID + ", Jenis Kelamin: " + jenisKelamin + ", Umur: " + umur;
    }
}