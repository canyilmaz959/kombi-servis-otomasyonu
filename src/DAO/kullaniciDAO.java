/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Kullanici;
import util.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class kullaniciDAO {

    public Kullanici girisKontrol(String kullaniciAdi, String sifre) {
        String sql = "SELECT * FROM kullanici WHERE kullanici_adi = ? AND sifre = ? AND durum = 'Aktif'";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setString(1, kullaniciAdi);
            ps.setString(2, sifre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return satirDonustur(rs);
        } catch (SQLException e) {
            System.out.println("Giriş hatası: " + e.getMessage());
        }
        return null;
    }

    public boolean ekle(Kullanici k) {
        String sql = "INSERT INTO kullanici (ad_soyad, kullanici_adi, sifre, rol, " +
                     "dogum_tarihi, tc_no, mezuniyet, mezun_kurum, durum) VALUES (?,?,?,?,?,?,?,?,'Aktif')";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setString(1, k.getAdSoyad());
            ps.setString(2, k.getKullaniciAdi());
            ps.setString(3, k.getSifre());
            ps.setString(4, k.getRol());
            ps.setString(5, k.getDogumTarihi());
            ps.setString(6, k.getTcNo());
            ps.setString(7, k.getMezuniyet());
            ps.setString(8, k.getMezunKurum());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Personel ekle hatası: " + e.getMessage());
            return false;
        }
    }

    public boolean guncelle(Kullanici k) {
        String sql = "UPDATE kullanici SET ad_soyad=?, rol=?, dogum_tarihi=?, " +
                     "tc_no=?, mezuniyet=?, mezun_kurum=?, sifre=? WHERE id=?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setString(1, k.getAdSoyad());
            ps.setString(2, k.getRol());
            ps.setString(3, k.getDogumTarihi());
            ps.setString(4, k.getTcNo());
            ps.setString(5, k.getMezuniyet());
            ps.setString(6, k.getMezunKurum());
            ps.setString(7, k.getSifre());
            ps.setInt(8, k.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Personel güncelle hatası: " + e.getMessage());
            return false;
        }
    }

    public boolean sil(int id) {
        String sql = "UPDATE kullanici SET durum = 'Silindi' WHERE id = ?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Personel soft-delete hatası: " + e.getMessage());
            return false;
        }
    }
    
    public boolean kaliciSil(int id) {
    String arizaGuncelleSql = "UPDATE ariza SET teknisyen_id = NULL WHERE teknisyen_id = ?";
    String kullaniciSilSql = "DELETE FROM kullanici WHERE id = ?";
    
    try {
        Connection conn = DBconnection.getConnection();
        PreparedStatement ps1 = conn.prepareStatement(arizaGuncelleSql);
        ps1.setInt(1, id);
        ps1.executeUpdate();
        
        PreparedStatement ps2 = conn.prepareStatement(kullaniciSilSql);
        ps2.setInt(1, id);
        return ps2.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Personel kalıcı silme hatası: " + e.getMessage());
        return false;
    }
}

    public List<Kullanici> tumPersonel() {
        List<Kullanici> liste = new ArrayList<>();
        String sql = "SELECT * FROM kullanici WHERE durum = 'Aktif' ORDER BY ad_soyad";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs));
        } catch (SQLException e) {
            System.out.println("Personel liste hatası: " + e.getMessage());
        }
        return liste;
    }

    public List<Kullanici> tumTeknisyenler() {
        List<Kullanici> liste = new ArrayList<>();
        String sql = "SELECT * FROM kullanici WHERE (rol = 'teknisyen' OR rol = 'tekniker') AND durum = 'Aktif' ORDER BY ad_soyad";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs));
        } catch (SQLException e) {
            System.out.println("Teknisyen liste hatası: " + e.getMessage());
        }
        return liste;
    }
    
    public List<Kullanici> silinmisPersoneller() {
        List<Kullanici> liste = new ArrayList<>();
        String sql = "SELECT * FROM kullanici WHERE durum = 'Silindi' ORDER BY ad_soyad";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs));
        } catch (SQLException e) {
            System.out.println("Silinmiş personel liste hatası: " + e.getMessage());
        }
        return liste;
    }
    
    public void logKaydet(model.Kullanici k) {
    String sql = "INSERT INTO giris_gecmisi (kullanici_id, kullanici_adi) VALUES (?, ?)";
    try {
        java.sql.PreparedStatement ps = util.DBconnection.getConnection().prepareStatement(sql);
        ps.setInt(1, k.getId());
        ps.setString(2, k.getKullaniciAdi());
        ps.executeUpdate();
    } catch (java.sql.SQLException e) {
        System.out.println("Giriş geçmişi kaydedilirken SQL hatası: " + e.getMessage());
    }
   }

    private Kullanici satirDonustur(ResultSet rs) throws SQLException {
        Kullanici k = new Kullanici();
        k.setId(rs.getInt("id"));
        k.setAdSoyad(rs.getString("ad_soyad"));
        k.setKullaniciAdi(rs.getString("kullanici_adi"));
        k.setSifre(rs.getString("sifre"));
        k.setRol(rs.getString("rol"));
        k.setDogumTarihi(rs.getString("dogum_tarihi"));
        k.setTcNo(rs.getString("tc_no"));
        k.setMezuniyet(rs.getString("mezuniyet"));
        k.setMezunKurum(rs.getString("mezun_kurum"));
        return k;
    }
}