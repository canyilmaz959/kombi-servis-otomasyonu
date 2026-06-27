/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Musteri;
import util.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class musteriDAO {

    public boolean ekle(Musteri m) {
        String sql = "INSERT INTO musteri (ad, soyad, dogum_tarihi, telefon, email, " +
                     "adres1, adres2, kombi_marka, kombi_model, seri_no) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setString(1, m.getAd());
            ps.setString(2, m.getSoyad());
            ps.setString(3, m.getDogumTarihi());
            ps.setString(4, m.getTelefon());
            ps.setString(5, m.getEmail());
            ps.setString(6, m.getAdres1());
            ps.setString(7, m.getAdres2());
            ps.setString(8, m.getKombiMarka());
            ps.setString(9, m.getKombiModel());
            ps.setString(10, m.getSeriNo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Müşteri ekle hatası: " + e.getMessage());
            return false;
        }
    }
    
    public List<model.Musteri> aktifMusteriListesi() {
    List<model.Musteri> liste = new ArrayList<>();
    String sql = "SELECT * FROM musteri WHERE durum = 'Aktif' ORDER BY ad ASC";
    try {
        Statement st = util.DBconnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            model.Musteri m = new model.Musteri();
            m.setId(rs.getInt("id"));
            m.setAd(rs.getString("ad"));
            m.setSoyad(rs.getString("soyad"));
            m.setTelefon(rs.getString("telefon"));
            liste.add(m);
        }
    } catch (SQLException e) {
        System.out.println("Aktif müşteri listesi çekilirken hata: " + e.getMessage());
    }
    return liste;
}

    public boolean sil(int id) {
        String sql = "UPDATE musteri SET durum = 'Silindi' WHERE id = ?"; 
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id); 
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Müşteri soft-delete hatası: " + e.getMessage());
            return false;
        }
    }
    
    public boolean geriYukle(int id) {
        String sql = "UPDATE musteri SET durum = 'Aktif' WHERE id = ?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Müşteri geri yükleme hatası: " + e.getMessage());
            return false;
        }
    }
    
    public boolean guncelle(Musteri m) {
    String sql = "UPDATE musteri SET ad=?, soyad=?, dogum_tarihi=?, telefon=?, email=?, " +
                 "adres1=?, adres2=? WHERE id=?";
    try {
        PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
        ps.setString(1, m.getAd());
        ps.setString(2, m.getSoyad());
        ps.setString(3, m.getDogumTarihi());
        ps.setString(4, m.getTelefon());
        ps.setString(5, m.getEmail());
        ps.setString(6, m.getAdres1());
        ps.setString(7, m.getAdres2());
        ps.setInt(8, m.getId());
        
        int sonuc = ps.executeUpdate();
        return sonuc > 0;
    } catch (SQLException e) {
        System.out.println("Müşteri güncelleme hatası: " + e.getMessage());
        return false;
    }
}

    public List<Musteri> tumMusteriler() {
        List<Musteri> liste = new ArrayList<>();
        String sql = "SELECT * FROM musteri WHERE durum = 'Aktif' ORDER BY soyad"; 
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs)); 
        } catch (SQLException e) {
            System.out.println("Müşteri liste hatası: " + e.getMessage());
        }
        return liste;
    }
    
    public List<Musteri> silinmisMusteriler() {
        List<Musteri> liste = new ArrayList<>();
        String sql = "SELECT * FROM musteri WHERE durum = 'Silindi' ORDER BY soyad";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs)); 
        } catch (SQLException e) {
            System.out.println("Silinmiş müşteri liste hatası: " + e.getMessage());
        }
        return liste;
    }
    
    public boolean kaliciSil(int id) {
    String arizaSilSql = "DELETE FROM ariza WHERE musteri_id = ?";
    String musteriSilSql = "DELETE FROM musteri WHERE id = ?";
    
    try {
        Connection conn = DBconnection.getConnection();
        
        PreparedStatement ps1 = conn.prepareStatement(arizaSilSql);
        ps1.setInt(1, id);
        ps1.executeUpdate();
        
        PreparedStatement ps2 = conn.prepareStatement(musteriSilSql);
        ps2.setInt(1, id);
        int sonuc = ps2.executeUpdate();
        
        return sonuc > 0;
    } catch (SQLException e) {
        System.out.println("Müşteri kalıcı silme hatası: " + e.getMessage());
        return false;
    }
}
    
    public model.Musteri musteriBul(int id) {
    String sql = "SELECT * FROM musteri WHERE id = ?";
    try {
        PreparedStatement ps = util.DBconnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            model.Musteri m = new model.Musteri();
            m.setId(rs.getInt("id"));
            m.setAd(rs.getString("ad"));
            m.setSoyad(rs.getString("soyad"));
            m.setTelefon(rs.getString("telefon"));
            m.setEmail(rs.getString("email"));
            m.setAdres1(rs.getString("adres1"));
            m.setAdres2(rs.getString("adres2"));
            return m;
        }
    } catch (SQLException e) {
        System.out.println("Müşteri bulma hatası: " + e.getMessage());
    }
    return null;
}

    public Musteri idileGetir(int id) {
        String sql = "SELECT * FROM musteri WHERE id = ?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return satirDonustur(rs);
        } catch (SQLException e) {
            System.out.println("Müşteri getir hatası: " + e.getMessage());
        }
        return null;
    }

    private Musteri satirDonustur(ResultSet rs) throws SQLException {
        Musteri m = new Musteri();
        m.setId(rs.getInt("id"));
        m.setAd(rs.getString("ad"));
        m.setSoyad(rs.getString("soyad"));
        m.setDogumTarihi(rs.getString("dogum_tarihi"));
        m.setTelefon(rs.getString("telefon"));
        m.setEmail(rs.getString("email"));
        m.setAdres1(rs.getString("adres1"));
        m.setAdres2(rs.getString("adres2"));
        m.setKombiMarka(rs.getString("kombi_marka"));
        m.setKombiModel(rs.getString("kombi_model"));
        m.setSeriNo(rs.getString("seri_no"));
        return m;
    }
}
