package com.mycompany.tugas.model;

public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private String tahun;

    public int getId() {
        return id;
    }

    public void setId(int Id_buku) {
        this.id = Id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
