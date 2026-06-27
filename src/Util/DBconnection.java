/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "81726345";

    private static Connection connection = null;

    public static Connection getConnection() {
            try {
               if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Veritabanı bağlantısı başarılı!");
                tabloOlustur();
               }
            } catch (SQLException e) {
                System.out.println("Bağlantı hatası: " + e.getMessage());
            }
        
        return connection;
    }

    private static void tabloOlustur() {
        try (Statement stmt = connection.createStatement()) {

            // Kullanıcılar / Personel
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS kullanici (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ad_soyad VARCHAR(100) NOT NULL," +
                "kullanici_adi VARCHAR(50) UNIQUE NOT NULL," +
                "sifre VARCHAR(255) NOT NULL," +
                "rol VARCHAR(20) NOT NULL," +       
                "dogum_tarihi VARCHAR(20)," +        
                "tc_no VARCHAR(11)," +              
                "mezuniyet VARCHAR(100)," +          
                "mezun_kurum VARCHAR(100)" +        
                ")"
            );

            // Müşteriler
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS musteri (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "ad VARCHAR(50) NOT NULL," +          
                "soyad VARCHAR(50) NOT NULL," +      
                "dogum_tarihi VARCHAR(20)," +          
                "telefon VARCHAR(20)," +               
                "email VARCHAR(100)," +                
                "adres1 TEXT," +                      
                "adres2 TEXT," +                       
                "kombi_marka VARCHAR(50)," +           
                "kombi_model VARCHAR(50)," +
                "seri_no VARCHAR(50)," +
                "durum VARCHAR(20) DEFAULT 'Aktif'" +  
                ")"
            );

            // Stok
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS stok (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "parca_kodu VARCHAR(50) UNIQUE," +
                "parca_adi VARCHAR(100) NOT NULL," +  
                "marka VARCHAR(50)," +                 
                "model VARCHAR(50)," +                 
                "kategori VARCHAR(20)," +              
                "miktar INT DEFAULT 0," +              
                "min_stok INT DEFAULT 5," +
                "seri_no VARCHAR(50)," +               
                "birim_fiyat DECIMAL(10,2)," +
                "resim_yolu VARCHAR(255)," +
                "tedarikci VARCHAR(100)" +
                ")"
            );

            // Arızalar
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS ariza (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "musteri_id INT," +
                "teknisyen_id INT," +
                "kombi_marka VARCHAR(50)," +           
                "kombi_model VARCHAR(50)," +           
                "seri_no VARCHAR(50)," +               
                "aciklama TEXT," +                     
                "cozum_onerisi TEXT," +                
                "durum VARCHAR(20) DEFAULT 'bekliyor'," +
                "olusturma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "guncel_tarih DATETIME," +
                "notlar TEXT," +
                "FOREIGN KEY (musteri_id) REFERENCES musteri(id)," +
                "FOREIGN KEY (teknisyen_id) REFERENCES kullanici(id)" +
                ")"
            );

            // Stok hareketleri
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS stok_hareket (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "stok_id INT," +
                "ariza_id INT," +
                "kullanici_id INT," +
                "islem VARCHAR(10)," +
                "miktar INT," +
                "tarih DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "aciklama TEXT," +
                "FOREIGN KEY (stok_id) REFERENCES stok(id)," +
                "FOREIGN KEY (kullanici_id) REFERENCES kullanici(id)" +
                ")"
            );
            
            // Giriş / Çıkış Geçmişi Log Tablosu
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS giris_gecmisi (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "kullanici_id INT," +
                "kullanici_adi VARCHAR(50)," +
                "giris_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (kullanici_id) REFERENCES kullanici(id) ON DELETE CASCADE" +
                ")"
            );

            System.out.println("Tablolar hazır!");

        } catch (SQLException e) {
            System.out.println("Tablo oluşturma hatası: " + e.getMessage());
        }
    }
}