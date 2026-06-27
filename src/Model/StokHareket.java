/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class StokHareket {
    private int id;
    private int stokId;
    private int arizaId;      
    private int kullaniciId; 
    private String islem;     
    private int miktar;
    private Timestamp tarih;
    private String aciklama;

    public StokHareket() {}

    public StokHareket(int id, int stokId, int arizaId, int kullaniciId, String islem, int miktar, Timestamp tarih, String aciklama) {
        this.id = id;
        this.stokId = stokId;
        this.arizaId = arizaId;
        this.kullaniciId = kullaniciId;
        this.islem = islem;
        this.miktar = miktar;
        this.tarih = tarih;
        this.aciklama = aciklama;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStokId() { return stokId; }
    public void setStokId(int stokId) { this.stokId = stokId; }

    public int getArizaId() { return arizaId; }
    public void setArizaId(int arizaId) { this.arizaId = arizaId; }

    public int getKullaniciId() { return kullaniciId; }
    public void setKullaniciId(int kullaniciId) { this.kullaniciId = kullaniciId; }

    public String getIslem() { return islem; }
    public void setIslem(String islem) { this.islem = islem; }

    public int getMiktar() { return miktar; }
    public void setMiktar(int miktar) { this.miktar = miktar; }

    public Timestamp getTarih() { return tarih; }
    public void setTarih(Timestamp tarih) { this.tarih = tarih; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }
}
