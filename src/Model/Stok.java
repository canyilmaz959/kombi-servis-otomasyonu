/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Stok {
    private int id;
    private String parcaKodu;
    private String parcaAdi;
    private String marka;
    private String model;
    private String kategori; // 'parca' veya 'kombi'
    private int miktar;
    private int minStok;
    private String seriNo;
    private double birimFiyat;
    private String resimYolu;
    private String tedarikci;

    public Stok() {}

    public Stok(int id, String parcaKodu, String parcaAdi, String marka, String model, 
                String kategori, int miktar, int minStok, String seriNo, double birimFiyat, String resimYolu, String tedarikci) {
        this.id = id;
        this.parcaKodu = parcaKodu;
        this.parcaAdi = parcaAdi;
        this.marka = marka;
        this.model = model;
        this.kategori = kategori;
        this.miktar = miktar;
        this.minStok = minStok;
        this.seriNo = seriNo;
        this.birimFiyat = birimFiyat;
        this.resimYolu = resimYolu;
        this.tedarikci = tedarikci;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getParcaKodu() { return parcaKodu; }
    public void setParcaKodu(String parcaKodu) { this.parcaKodu = parcaKodu; }

    public String getParcaAdi() { return parcaAdi; }
    public void setParcaAdi(String parcaAdi) { this.parcaAdi = parcaAdi; }

    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public int getMiktar() { return miktar; }
    public void setMiktar(int miktar) { this.miktar = miktar; }

    public int getMinStok() { return minStok; }
    public void setMinStok(int minStok) { this.minStok = minStok; }

    public String getSeriNo() { return seriNo; }
    public void setSeriNo(String seriNo) { this.seriNo = seriNo; }

    public double getBirimFiyat() { return birimFiyat; }
    public void setBirimFiyat(double birimFiyat) { this.birimFiyat = birimFiyat; }

    public String getResimYolu() { return resimYolu; }
    public void setResimYolu(String resimYolu) { this.resimYolu = resimYolu; }

    public String getTedarikci() { return tedarikci; }
    public void setTedarikci(String tedarikci) { this.tedarikci = tedarikci; }
}