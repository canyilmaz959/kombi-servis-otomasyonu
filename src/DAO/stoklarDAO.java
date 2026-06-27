/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Stok;
import util.DBconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class stoklarDAO {

    public boolean ekle(Stok s) {
        String sql = "INSERT INTO stok (parca_kodu, parca_adi, marka, model, kategori, " +
                     "miktar, min_stok, seri_no, birim_fiyat, resim_yolu, tedarikci) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setString(1, s.getParcaKodu());
            ps.setString(2, s.getParcaAdi());
            ps.setString(3, s.getMarka());
            ps.setString(4, s.getModel());
            ps.setString(5, s.getKategori());
            ps.setInt(6, s.getMiktar());
            ps.setInt(7, s.getMinStok());
            ps.setString(8, s.getSeriNo());
            ps.setDouble(9, s.getBirimFiyat());
            ps.setString(10, s.getResimYolu());
            ps.setString(11, s.getTedarikci());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Stok ekle hatası: " + e.getMessage());
            return false;
        }
    }
    
    public boolean sil(int id) {
        String sql = "DELETE FROM stok WHERE id = ?";
        try {
            PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Stok silme hatası: " + e.getMessage());
            return false;
        }
    }

    public boolean StokGuncelle(int id, String kategori, String seriNo, String durum, int yeniMiktar) {
    String sql = "UPDATE stok SET kategori = ?, seri_no = ?, tedarikci = ?, miktar = ? WHERE id = ?";
    try {
        PreparedStatement ps = DBconnection.getConnection().prepareStatement(sql);
        ps.setString(1, kategori);
        ps.setString(2, seriNo.isEmpty() ? null : seriNo);
        ps.setString(3, durum); 
        ps.setInt(4, yeniMiktar);
        ps.setInt(5, id);
        
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Stok güncelleme DAO hatası: " + e.getMessage());
        return false;
    }
}

    public List<Stok> tumStok() {
        List<Stok> liste = new ArrayList<>();
        String sql = "SELECT * FROM stok ORDER BY parca_adi";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs));
        } catch (SQLException e) {
            System.out.println("Stok liste hatası: " + e.getMessage());
        }
        return liste;
    }

    public List<Stok> kritikStok() {
        List<Stok> liste = new ArrayList<>();
        String sql = "SELECT * FROM stok WHERE miktar <= min_stok";
        try {
            Statement st = DBconnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) liste.add(satirDonustur(rs));
        } catch (SQLException e) {
            System.out.println("Kritik stok hatası: " + e.getMessage());
        }
        return liste;
    }

    private Stok satirDonustur(ResultSet rs) throws SQLException {
        Stok s = new Stok();
        s.setId(rs.getInt("id"));
        s.setParcaKodu(rs.getString("parca_kodu"));
        s.setParcaAdi(rs.getString("parca_adi"));
        s.setMarka(rs.getString("marka"));
        s.setModel(rs.getString("model"));
        s.setKategori(rs.getString("kategori"));
        s.setMiktar(rs.getInt("miktar"));
        s.setMinStok(rs.getInt("min_stok"));
        s.setSeriNo(rs.getString("seri_no"));
        s.setBirimFiyat(rs.getDouble("birim_fiyat"));
        s.setResimYolu(rs.getString("resim_yolu"));
        s.setTedarikci(rs.getString("tedarikci"));
        return s;
    }

}
