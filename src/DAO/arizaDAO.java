/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Ariza;
import util.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class arizaDAO {

    public boolean ekle(Ariza a) {
        String sql = "INSERT INTO ariza (musteri_id, teknisyen_id, kombi_marka, kombi_model, seri_no, aciklama, cozum_onerisi, durum) VALUES (?,?,?,?,?,?,?,'devam ediliyor...')";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, a.getMusteriId());
            ps.setInt(2, a.getTeknisyenId());
            ps.setString(3, a.getKombiMarka());
            ps.setString(4, a.getKombiModel());
            ps.setString(5, a.getSeriNo());
            ps.setString(6, a.getAciklama());
            ps.setString(7, a.getCozumOnerisi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Arıza ekleme hatası: " + e.getMessage());
            return false;
        }
    }

    public boolean guncelle(Ariza a) {
        String sql = "UPDATE ariza SET teknisyen_id=?, kombi_marka=?, kombi_model=?, " +
                     "seri_no=?, aciklama=?, cozum_onerisi=?, durum=?, notlar=?, " +
                     "guncel_tarih=NOW() WHERE id=?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, a.getTeknisyenId());
            ps.setString(2, a.getKombiMarka());
            ps.setString(3, a.getKombiModel());
            ps.setString(4, a.getSeriNo());
            ps.setString(5, a.getAciklama());
            ps.setString(6, a.getCozumOnerisi());
            ps.setString(7, a.getDurum()); 
            ps.setString(8, a.getNotlar());
            ps.setInt(9, a.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Arıza güncelle hatası: " + e.getMessage());
            return false;
        }
    }
    
    public Ariza arizaBul(int id) {
        String sql = "SELECT * FROM ariza WHERE id = ?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return satirDonustur(rs);
            }
        } catch (SQLException e) {
            System.out.println("Arıza bulma hatası (ID: " + id + "): " + e.getMessage());
        }
        return null;
    }

    public List<Ariza> tumArizalar() {
        return listele("SELECT * FROM ariza ORDER BY olusturma_tarihi DESC");
    }

    public List<Ariza> devamEdenler() {
        return listele("SELECT * FROM ariza WHERE durum != 'bitti' ORDER BY id DESC");
    }

    public List<Ariza> bekleyenler() {
        return listele("SELECT * FROM ariza WHERE durum = 'bekliyor' ORDER BY olusturma_tarihi DESC");
    }

    public List<Ariza> tamamlananlar() {
        return listele("SELECT * FROM ariza WHERE durum = 'tamamlandi' ORDER BY olusturma_tarihi DESC");
    }

    private List<Ariza> listele(String sql) {
        List<Ariza> liste = new ArrayList<>();
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                liste.add(satirDonustur(rs));
            }
        } catch (SQLException e) {
            System.out.println("Arıza liste hatası: " + e.getMessage());
        }
        return liste;
    }
    
    public List<Ariza> bitenarizalar() {
        List<Ariza> liste = new ArrayList<>();
        String sql = "SELECT a.*, m.ad, m.soyad FROM ariza a " +
                     "INNER JOIN musteri m ON a.musteri_id = m.id " +
                     "WHERE a.durum = 'bitti' ORDER BY a.id DESC";
        try {
            Statement st = util.DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Ariza a = satirDonustur(rs);
                String musteriAdSoyad = rs.getString("m.ad") + " " + rs.getString("m.soyad");
                a.setNotlar(musteriAdSoyad + "##" + (a.getNotlar() != null ? a.getNotlar() : "")); 
                liste.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Tamamlanan arızalar raporlanırken hata: " + e.getMessage());
        }
        return liste;
    }
    
    public boolean bitenarizasil(int id) {
        String sql = "DELETE FROM ariza WHERE id = ?";
        try {
            java.sql.PreparedStatement ps = util.DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (java.sql.SQLException e) {
            System.out.println("Raporlanan tekil arıza temizlenirken SQL hatası: " + e.getMessage());
            return false;
        }
    }

    private Ariza satirDonustur(ResultSet rs) throws SQLException {
        Ariza a = new Ariza();
        a.setId(rs.getInt("id"));
        a.setMusteriId(rs.getInt("musteri_id"));
        a.setTeknisyenId(rs.getInt("teknisyen_id"));
        a.setKombiMarka(rs.getString("kombi_marka"));
        a.setKombiModel(rs.getString("kombi_model"));
        a.setSeriNo(rs.getString("seri_no"));
        a.setAciklama(rs.getString("aciklama"));
        a.setCozumOnerisi(rs.getString("cozum_onerisi"));
        a.setDurum(rs.getString("durum"));
        a.setNotlar(rs.getString("notlar"));
        a.setOlusturmaTarihi(rs.getTimestamp("olusturma_tarihi"));
        a.setguncelTarih(rs.getTimestamp("guncel_tarih"));
        return a;
    }
}
