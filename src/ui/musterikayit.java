/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import java.util.List;
import model.Musteri;
import dao.musteriDAO;

public class musterikayit extends javax.swing.JPanel {
    
    private boolean yukleniyor = false;
    /**
     * Creates new form musterikayit
     */
    public musterikayit() {
        initComponents();
        
        musterileridoldur();
        
        isimbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isimboxActionPerformed(evt);
            }
        });
        
        soyisimbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soyisimboxActionPerformed(evt);
            }
        });
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
    }
    
    public void musterileridoldur() {
        yukleniyor = true;
        isimbox.removeAllItems();
        soyisimbox.removeAllItems();
        jComboBox1.removeAllItems();

        isimbox.addItem("Seçiniz...");
        soyisimbox.addItem("Seçiniz...");
        jComboBox1.addItem("Seçiniz...");

        try {
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();

            if (liste != null) {
                for (Musteri m : liste) {
                    isimbox.addItem(m.getAd());
                    soyisimbox.addItem(m.getSoyad());
                    jComboBox1.addItem(m.getTelefon());
                }
            }
        } catch (Exception e) {
            System.out.println("Müşteri kutuları doldurulurken hata: " + e.getMessage());
        }
        yukleniyor = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        isimfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        soyisimfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dtarihifield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telnofield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        adres1field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        adres2field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        isimbox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        soyisimbox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        gunceladres1field = new javax.swing.JTextField();
        gunceladres2field = new javax.swing.JTextField();
        guncelemailfield = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        gunceltelnofield = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("İsim:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 87, 91, -1));
        add(isimfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 84, 98, -1));

        jLabel2.setText("soyisim:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 115, 91, -1));
        add(soyisimfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 112, 98, -1));

        jLabel3.setText("doğum tarihi:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 166, 91, -1));
        add(dtarihifield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 163, 106, -1));

        jLabel4.setText("telefon numarası:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 216, -1, -1));
        add(telnofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 213, 106, -1));

        jLabel5.setText("email adresi:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 323, 69, -1));
        add(emailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 128, -1));

        jLabel6.setText("adres1");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 378, 47, -1));
        add(adres1field, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 375, 218, -1));

        jLabel7.setText("adres2");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 418, 47, -1));
        add(adres2field, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 415, 218, -1));

        jLabel8.setText("müşteri seç");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 59, 147, -1));

        jLabel9.setText("isim:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 344, 33, -1));

        isimbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(isimbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 341, -1, -1));

        jLabel10.setText("soyisim:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 408, 51, -1));

        soyisimbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(soyisimbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 405, -1, -1));

        jLabel11.setText("telefon numarası:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 469, 100, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 466, -1, -1));

        jButton1.setText("MÜŞTERİ EKLE");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 504, 142, 50));

        jButton2.setText("MÜŞTERİ SİL");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 141, 53));

        jLabel12.setText("MÜŞTERİ EKLE || SİL");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 15, 175, 26));
        add(gunceladres1field, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 213, 147, -1));
        add(gunceladres2field, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 263, 147, -1));
        add(guncelemailfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 163, 147, -1));

        jButton3.setText("MÜŞTERİ GÜNCELLE");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, -1, 53));

        jLabel13.setText("email adresi:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 166, 92, -1));

        jLabel15.setText("adres1");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 216, -1, -1));

        jLabel16.setText("adres2");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 266, -1, -1));
        add(gunceltelnofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 147, -1));

        jLabel14.setText("telefon numarası:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 115, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ad = isimfield.getText().trim();
        String soyad = soyisimfield.getText().trim();
        String d_tarihi = dtarihifield.getText().trim();
        String tel = telnofield.getText().trim();
        String email = emailfield.getText().trim();
        String adres1 = adres1field.getText().trim();
        String adres2 = adres2field.getText().trim();

        if (ad.isEmpty() || soyad.isEmpty() || tel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ad, Soyad ve Telefon alanları zorunludur!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Musteri m = new Musteri();
        m.setAd(ad);
        m.setSoyad(soyad);
        m.setDogumTarihi(d_tarihi.isEmpty() ? null : d_tarihi);
        m.setTelefon(tel);
        m.setEmail(email.isEmpty() ? null : email);
        m.setAdres1(adres1.isEmpty() ? null : adres1);
        m.setAdres2(adres2.isEmpty() ? null : adres2);
        m.setKombiMarka("");
        m.setKombiModel("");
        m.setSeriNo("");

        musteriDAO dao = new musteriDAO();
        if (dao.ekle(m)) {
            JOptionPane.showMessageDialog(this, "Müşteri kaydı veritabanına başarıyla eklendi.");
            formuTemizle();
            musterileridoldur(); 
        } else {
            JOptionPane.showMessageDialog(this, "Ekleme başarısız! DAO hatasını kontrol et.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (isimbox.getSelectedIndex() <= 0 || isimbox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz müşteriyi sağdaki kutudan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int seciliSira = isimbox.getSelectedIndex() - 1;
        
        try {
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();
            Musteri silinecekMusteri = liste.get(seciliSira);

            int onay = JOptionPane.showConfirmDialog(this, 
                silinecekMusteri.getAdSoyad() + " isimli müşteriyi tamamen silmek istiyor musunuz?", 
                "Silme Onayı", JOptionPane.YES_NO_OPTION);
                
            if (onay == JOptionPane.YES_OPTION) {
                if (dao.sil(silinecekMusteri.getId())) {
                    JOptionPane.showMessageDialog(this, "Müşteri sistemden tamamen kaldırıldı.");
                    guncellemetemizle();
                    musterileridoldur();
                    formuTemizle();
                } else {
                    JOptionPane.showMessageDialog(this, "Silme başarısız! Bu müşteriye bağlı aktif bir arıza kaydı olabilir.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Müşteri seçilirken hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if (isimbox.getSelectedIndex() <= 0 || isimbox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz müşteriyi sağdaki kutudan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int seciliSira = isimbox.getSelectedIndex() - 1;

        try {
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();
            Musteri guncellenecekMusteri = liste.get(seciliSira);
            String yeniTel = gunceltelnofield.getText().trim();
            String yeniEmail = guncelemailfield.getText().trim();
            String yeniAdres1 = gunceladres1field.getText().trim();
            String yeniAdres2 = gunceladres2field.getText().trim();

            if (yeniTel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Telefon numarası alanı boş bırakılamaz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }

            guncellenecekMusteri.setTelefon(yeniTel);
            guncellenecekMusteri.setEmail(yeniEmail.isEmpty() ? null : yeniEmail);
            guncellenecekMusteri.setAdres1(yeniAdres1.isEmpty() ? null : yeniAdres1);
            guncellenecekMusteri.setAdres2(yeniAdres2.isEmpty() ? null : yeniAdres2);

            if (dao.guncelle(guncellenecekMusteri)) {
                JOptionPane.showMessageDialog(this, "Müşteri bilgileri başarıyla güncellendi.");
                guncellemetemizle();
                musterileridoldur(); 
            } else {
                JOptionPane.showMessageDialog(this, "Güncelleme başarısız oldu!", "Hata", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Güncelleme sırasında hata: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void isimboxActionPerformed(java.awt.event.ActionEvent evt) {
        if (yukleniyor || isimbox.getSelectedIndex() <= 0) return;
        
        int seciliSira = isimbox.getSelectedIndex();
        yukleniyor = true;
        soyisimbox.setSelectedIndex(seciliSira);
        jComboBox1.setSelectedIndex(seciliSira);
        yukleniyor = false;
        
        try{
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();
            
            if (liste != null && (seciliSira - 1) < liste.size()){
                Musteri seciliMusteri = liste.get(seciliSira - 1);
                
                gunceltelnofield.setText(seciliMusteri.getTelefon() != null ? seciliMusteri.getTelefon() : ""); 
                guncelemailfield.setText(seciliMusteri.getEmail() != null ? seciliMusteri.getEmail() : ""); 
                gunceladres1field.setText(seciliMusteri.getAdres1() != null ? seciliMusteri.getAdres1() : ""); 
                gunceladres2field.setText(seciliMusteri.getAdres2() != null ? seciliMusteri.getAdres2() : ""); 
            }
        } catch (Exception e) {
            System.out.println("Güncelleme kutuları doldurulurken hata oluştu: " + e.getMessage());
        }
    }
    
    
    private void soyisimboxActionPerformed(java.awt.event.ActionEvent evt) {
        if (yukleniyor || soyisimbox.getSelectedIndex() <= 0) return;
        
        int seciliSira = soyisimbox.getSelectedIndex();
        yukleniyor = true;
        isimbox.setSelectedIndex(seciliSira);
        jComboBox1.setSelectedIndex(seciliSira);
        yukleniyor = false;
        
        try{
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();
            
            if (liste != null && (seciliSira - 1) < liste.size()){
                Musteri seciliMusteri = liste.get(seciliSira - 1);
                
                gunceltelnofield.setText(seciliMusteri.getTelefon() != null ? seciliMusteri.getTelefon() : ""); 
                guncelemailfield.setText(seciliMusteri.getEmail() != null ? seciliMusteri.getEmail() : ""); 
                gunceladres1field.setText(seciliMusteri.getAdres1() != null ? seciliMusteri.getAdres1() : ""); 
                gunceladres2field.setText(seciliMusteri.getAdres2() != null ? seciliMusteri.getAdres2() : ""); 
            }
        } catch (Exception e) {
            System.out.println("Güncelleme kutuları doldurulurken hata oluştu: " + e.getMessage());
        }
    }
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (yukleniyor || jComboBox1.getSelectedIndex() <= 0) return;
        
        int seciliSira = jComboBox1.getSelectedIndex();
        yukleniyor = true;
        isimbox.setSelectedIndex(seciliSira);
        soyisimbox.setSelectedIndex(seciliSira);
        yukleniyor = false;
        
        try{
            musteriDAO dao = new musteriDAO();
            List<Musteri> liste = dao.tumMusteriler();
            
            if (liste != null && (seciliSira - 1) < liste.size()){
                Musteri seciliMusteri = liste.get(seciliSira - 1);
                
                gunceltelnofield.setText(seciliMusteri.getTelefon() != null ? seciliMusteri.getTelefon() : ""); 
                guncelemailfield.setText(seciliMusteri.getEmail() != null ? seciliMusteri.getEmail() : ""); 
                gunceladres1field.setText(seciliMusteri.getAdres1() != null ? seciliMusteri.getAdres1() : ""); 
                gunceladres2field.setText(seciliMusteri.getAdres2() != null ? seciliMusteri.getAdres2() : ""); 
            }
        } catch (Exception e) {
            System.out.println("Güncelleme kutuları doldurulurken hata oluştu: " + e.getMessage());
        }
    }
    
    private void formuTemizle() {
        isimfield.setText("");
        soyisimfield.setText("");
        dtarihifield.setText("");
        telnofield.setText("");
        emailfield.setText("");
        adres1field.setText("");
        adres2field.setText("");
    }

    private void guncellemetemizle() {
        gunceltelnofield.setText("");
        guncelemailfield.setText("");
        gunceladres1field.setText("");
        gunceladres2field.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adres1field;
    private javax.swing.JTextField adres2field;
    private javax.swing.JTextField dtarihifield;
    private javax.swing.JTextField emailfield;
    private javax.swing.JTextField gunceladres1field;
    private javax.swing.JTextField gunceladres2field;
    private javax.swing.JTextField guncelemailfield;
    private javax.swing.JTextField gunceltelnofield;
    private javax.swing.JComboBox<String> isimbox;
    private javax.swing.JTextField isimfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> soyisimbox;
    private javax.swing.JTextField soyisimfield;
    private javax.swing.JTextField telnofield;
    // End of variables declaration//GEN-END:variables
}
