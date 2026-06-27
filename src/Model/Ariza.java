/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class Ariza {
    private int id;
    private int musteriId;
    private int teknisyenId;
    private String kombiMarka;
    private String kombiModel;
    private String seriNo;
    private String aciklama;
    private String cozumOnerisi;
    private String durum; 
    private Timestamp olusturmaTarihi;
    private Timestamp guncelTarih;
    private String notlar;

    public Ariza() {}

    public Ariza(int id, int musteriId, int teknisyenId, String kombiMarka, String kombiModel, String seriNo, 
                 String aciklama, String cozumOnerisi, String durum, 
                 Timestamp olusturmaTarihi, Timestamp guncelTarih, String notlar) {
        this.id = id;
        this.musteriId = musteriId;
        this.teknisyenId = teknisyenId;
        this.kombiMarka = kombiMarka;
        this.kombiModel = kombiModel;
        this.seriNo = seriNo;
        this.aciklama = aciklama;
        this.cozumOnerisi = cozumOnerisi;
        this.durum = durum;
        this.olusturmaTarihi = olusturmaTarihi;
        this.guncelTarih = guncelTarih;
        this.notlar = notlar;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMusteriId() { return musteriId; }
    public void setMusteriId(int musteriId) { this.musteriId = musteriId; }

    public int getTeknisyenId() { return teknisyenId; }
    public void setTeknisyenId(int teknisyenId) { this.teknisyenId = teknisyenId; }

    public String getKombiMarka() { return kombiMarka; }
    public void setKombiMarka(String kombiMarka) { this.kombiMarka = kombiMarka; }

    public String getKombiModel() { return kombiModel; }
    public void setKombiModel(String kombiModel) { this.kombiModel = kombiModel; }

    public String getSeriNo() { return seriNo; }
    public void setSeriNo(String seriNo) { this.seriNo = seriNo; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }

    public String getCozumOnerisi() { return cozumOnerisi; }
    public void setCozumOnerisi(String cozumOnerisi) { this.cozumOnerisi = cozumOnerisi; }

    public String getDurum() { return durum; }
    public void setDurum(String durum) { this.durum = durum; }

    public Timestamp getOlusturmaTarihi() { return olusturmaTarihi; }
    public void setOlusturmaTarihi(Timestamp olusturmaTarihi) { this.olusturmaTarihi = olusturmaTarihi; }

    public Timestamp getguncelTarih() { return guncelTarih; }
    public void setguncelTarih(Timestamp guncelTarih) { this.guncelTarih = guncelTarih; }

    public String getNotlar() { return notlar; }
    public void setNotlar(String notlar) { this.notlar = notlar; }
}