/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Musteri {
    private int id;
    private String ad;
    private String soyad;
    private String dogumTarihi;
    private String telefon;
    private String email;
    private String adres1;
    private String adres2;
    private String kombiMarka;
    private String kombiModel;
    private String seriNo;

    public Musteri() {}

    public Musteri(int id, String ad, String soyad, String dogumTarihi, String telefon, 
                   String email, String adres1, String adres2, String kombiMarka, String kombiModel, String seriNo) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
        this.telefon = telefon;
        this.email = email;
        this.adres1 = adres1;
        this.adres2 = adres2;
        this.kombiMarka = kombiMarka;
        this.kombiModel = kombiModel;
        this.seriNo = seriNo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getDogumTarihi() { return dogumTarihi; }
    public void setDogumTarihi(String dogumTarihi) { this.dogumTarihi = dogumTarihi; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAdres1() { return adres1; }
    public void setAdres1(String adres1) { this.adres1 = adres1; }

    public String getAdres2() { return adres2; }
    public void setAdres2(String adres2) { this.adres2 = adres2; }

    public String getKombiMarka() { return kombiMarka; }
    public void setKombiMarka(String kombiMarka) { this.kombiMarka = kombiMarka; }

    public String getKombiModel() { return kombiModel; }
    public void setKombiModel(String kombiModel) { this.kombiModel = kombiModel; }

    public String getSeriNo() { return seriNo; }
    public void setSeriNo(String seriNo) { this.seriNo = seriNo; }
    
    // Arayüzlerde kolaylık olması için ad soyad birleştirme metodu
    public String getAdSoyad() { return ad + " " + soyad; }
    
    @Override
    public String toString() {
        return this.ad + " " + this.soyad + " (" + this.telefon + ")";
}
}