/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package model;

public class Kullanici {
    private int id;
    private String adSoyad;
    private String kullaniciAdi;
    private String sifre;
    private String rol; 
    private String dogumTarihi;
    private String tcNo;
    private String mezuniyet;
    private String mezunKurum;

    public Kullanici() {}

    public Kullanici(int id, String adSoyad, String kullaniciAdi, String sifre, String rol, 
                     String dogumTarihi, String tcNo, String mezuniyet, String mezunKurum) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
        this.dogumTarihi = dogumTarihi;
        this.tcNo = tcNo;
        this.mezuniyet = mezuniyet;
        this.mezunKurum = mezunKurum;
    }

    public Kullanici(String adSoyad, String kullaniciAdi, String sifre, String rol, 
                     String dogumTarihi, String tcNo, String mezuniyet, String mezunKurum) {
        this.adSoyad = adSoyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
        this.dogumTarihi = dogumTarihi;
        this.tcNo = tcNo;
        this.mezuniyet = mezuniyet;
        this.mezunKurum = mezunKurum;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAdSoyad() { return adSoyad; }
    public void setAdSoyad(String adSoyad) { this.adSoyad = adSoyad; }

    public String getKullaniciAdi() { return kullaniciAdi; }
    public void setKullaniciAdi(String kullaniciAdi) { this.kullaniciAdi = kullaniciAdi; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getDogumTarihi() { return dogumTarihi; }
    public void setDogumTarihi(String dogumTarihi) { this.dogumTarihi = dogumTarihi; }

    public String getTcNo() { return tcNo; }
    public void setTcNo(String tcNo) { this.tcNo = tcNo; }

    public String getMezuniyet() { return mezuniyet; }
    public void setMezuniyet(String mezuniyet) { this.mezuniyet = mezuniyet; }

    public String getMezunKurum() { return mezunKurum; }
    public void setMezunKurum(String mezunKurum) { this.mezunKurum = mezunKurum; }
    
    @Override
    public String toString() {
        return this.adSoyad + " [" + this.rol + "]";
}
}
