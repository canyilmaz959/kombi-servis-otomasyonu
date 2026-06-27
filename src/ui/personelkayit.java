/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import java.util.List;
import model.Kullanici;
import dao.kullaniciDAO;

public class personelkayit extends javax.swing.JPanel {

    private boolean yukleniyor = false;
    
    public personelkayit() {
        initComponents();
        
        personeldoldur();
        
        personelisimbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelisimboxActionPerformed(evt);
            }
        });
        
        personelsoyisimbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelsoyisimboxActionPerformed(evt);
            }
        });
        
        personeltcbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personeltcboxActionPerformed(evt);
            }
        });
    }
    
    public void personeldoldur() {
        yukleniyor = true;
        personelisimbox.removeAllItems();
        personelsoyisimbox.removeAllItems();
        personeltcbox.removeAllItems();

        personelisimbox.addItem("Seçiniz...");
        personelsoyisimbox.addItem("Seçiniz...");
        personeltcbox.addItem("Seçiniz...");

        try {
            kullaniciDAO dao = new kullaniciDAO();
            List<Kullanici> liste = dao.tumPersonel(); 

            if (liste != null) {
                for (Kullanici k : liste) {
                    String[] parcalar = k.getAdSoyad().split(" ", 2);
                    String ad = parcalar[0];
                    String soyad = parcalar.length > 1 ? parcalar[1] : "";

                    personelisimbox.addItem(ad);
                    personelsoyisimbox.addItem(soyad);
                    personeltcbox.addItem(k.getTcNo() != null ? k.getTcNo() : "---");
                }
            }
        } catch (Exception e) {
            System.out.println("Personel veri hatası: " + e.getMessage());
        }
        yukleniyor = false;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        personelisimfield = new javax.swing.JTextField();
        personelsoyisimfield = new javax.swing.JTextField();
        personeldtarihifield = new javax.swing.JTextField();
        personeltcfield = new javax.swing.JTextField();
        personelmezunfield = new javax.swing.JTextField();
        personelkurumfield = new javax.swing.JTextField();
        personelunvanbox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        personeldtarihifield1 = new javax.swing.JTextField();
        personelmezunfield1 = new javax.swing.JTextField();
        personelkurumfield1 = new javax.swing.JTextField();
        personelunvanbox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        personelisimbox = new javax.swing.JComboBox<>();
        personelsoyisimbox = new javax.swing.JComboBox<>();
        personeltcbox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        atanansifrefiled = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("isim:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 59, -1, -1));

        jLabel2.setText("soyisim:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 121, -1, -1));

        jLabel3.setText("doğum tarihi:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 181, -1, -1));

        jLabel4.setText("T.C no:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 242, -1, -1));

        jLabel5.setText("mezuniyet durumu:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 312, -1, -1));

        jLabel6.setText("mezun olduğu kurum:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 386, -1, -1));

        jLabel7.setText("ünvan:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 453, -1, -1));
        add(personelisimfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 56, 92, -1));
        add(personelsoyisimfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 118, 92, -1));
        add(personeldtarihifield, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 178, 92, -1));
        add(personeltcfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 239, 123, -1));
        add(personelmezunfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 309, 92, -1));
        add(personelkurumfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 383, 92, -1));

        personelunvanbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tekniker", "temizlik personeli", "stajyer", "yönetici", "teknisyen" }));
        add(personelunvanbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 450, 87, -1));

        jLabel8.setText("personel ekle");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 22, -1, -1));

        jLabel9.setText("doğum tarihi:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 252, -1, -1));

        jLabel11.setText("mezuniyet durumu:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 312, -1, -1));

        jLabel12.setText("mezun olduğu kurum:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 386, -1, -1));

        jLabel13.setText("ünvan:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 453, -1, -1));
        add(personeldtarihifield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 249, 92, -1));
        add(personelmezunfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 309, 92, -1));
        add(personelkurumfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 383, 92, -1));

        personelunvanbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tekniker", "temizlik personeli", "stajyer", "yönetici", "teknisyen" }));
        add(personelunvanbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 450, 87, -1));

        jLabel10.setText("isim:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 59, -1, -1));

        jLabel14.setText("soyisim:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 121, -1, -1));

        jLabel15.setText("T.C no:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 181, -1, -1));

        personelisimbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        personelisimbox.addActionListener(this::personelisimboxActionPerformed);
        add(personelisimbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 56, -1, -1));

        personelsoyisimbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(personelsoyisimbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 118, -1, -1));

        personeltcbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(personeltcbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 178, -1, -1));

        jButton1.setText("personel ekle");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 536, 149, 56));

        jButton2.setText("güncelle");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 536, 121, 56));

        jButton3.setText("sil");
        jButton3.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton3.addActionListener(this::jButton3ActionPerformed);
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 540, 120, 60));

        jLabel16.setText("personel güncelle");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 14, -1, -1));

        jLabel17.setText("şifre: ");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 493, 34, -1));
        add(atanansifrefiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 490, 99, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ad = personelisimfield.getText().trim();
        String soyad = personelsoyisimfield.getText().trim();
        String d_tarihi = personeldtarihifield.getText().trim();
        String tc = personeltcfield.getText().trim();
        String mezuniyet = personelmezunfield.getText().trim();
        String kurum = personelkurumfield.getText().trim();
        String unvan = personelunvanbox.getSelectedItem().toString();
        String sifre = atanansifrefiled.getText().trim();

        if (ad.isEmpty() || soyad.isEmpty() || tc.isEmpty() || sifre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "İsim, Soyisim, TC No ve Şifre alanları boş bırakılamaz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String temizAd = ad.toLowerCase().replace("ı", "i").replace("ğ", "g").replace("ü", "u").replace("ş", "s").replace("ö", "o").replace("ç", "c");
        String temizSoyad = soyad.toLowerCase().replace("ı", "i").replace("ğ", "g").replace("ü", "u").replace("ş", "s").replace("ö", "o").replace("ç", "c");
        String otomatikKullaniciAdi = temizAd + "." + temizSoyad;

        Kullanici k = new Kullanici();
        k.setAdSoyad(ad + " " + soyad);
        k.setKullaniciAdi(otomatikKullaniciAdi);
        k.setSifre(sifre);
        k.setRol(unvan.equals("yönetici") ? "admin" : unvan);
        k.setDogumTarihi(d_tarihi);
        k.setTcNo(tc);
        k.setMezuniyet(mezuniyet);
        k.setMezunKurum(kurum);

        kullaniciDAO dao = new kullaniciDAO();
        if (dao.ekle(k)) {
            JOptionPane.showMessageDialog(this, ad + " " + soyad + " başarıyla sisteme kaydedildi.\nkullanıcı adı: " + otomatikKullaniciAdi + "\nşifre: " + sifre);
            formuTemizle();
            personeldoldur();
        } else {
            JOptionPane.showMessageDialog(this, "Personel eklenemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (personelisimbox.getSelectedIndex() <= 0 || personelisimbox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen güncellenecek personeli sağ taraftaki kutudan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int seciliSira = personelisimbox.getSelectedIndex() - 1;

        try {
            kullaniciDAO dao = new kullaniciDAO();
            List<Kullanici> liste = dao.tumPersonel();
            Kullanici guncellenecekK = liste.get(seciliSira);

            String yeniDTarihi = personeldtarihifield1.getText().trim();
            String yeniMezuniyet = personelmezunfield1.getText().trim();
            String yeniKurum = personelkurumfield1.getText().trim();
            String yeniUnvan = personelunvanbox1.getSelectedItem().toString();
            String yeniSifre = atanansifrefiled.getText().trim();

            if (yeniSifre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Şifre alanı boş bırakılamaz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }

            guncellenecekK.setDogumTarihi(yeniDTarihi);
            guncellenecekK.setMezuniyet(yeniMezuniyet);
            guncellenecekK.setMezunKurum(yeniKurum);
            guncellenecekK.setRol(yeniUnvan.equals("yönetici") ? "admin" : yeniUnvan);
            guncellenecekK.setSifre(yeniSifre);

            if (dao.guncelle(guncellenecekK)) {
                JOptionPane.showMessageDialog(this, "Personel özlük bilgileri ve şifre başarıyla güncellendi.");
                guncellemeAlanlariniTemizle();
                personeldoldur();
            } else {
                JOptionPane.showMessageDialog(this, "Güncelleme başarısız!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Güncelleme hatası: " + e.getMessage());
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (personelisimbox.getSelectedIndex() <= 0 || personelisimbox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Lütfen silinecek personeli sağdaki kutudan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int seciliSira = personelisimbox.getSelectedIndex() - 1;

        try {
            kullaniciDAO dao = new kullaniciDAO();
            List<Kullanici> liste = dao.tumPersonel();
            Kullanici silinecekK = liste.get(seciliSira);

            int onay = JOptionPane.showConfirmDialog(this, 
                silinecekK.getAdSoyad() + " isimli personeli silmek istediğinize emin misiniz?", 
                "Soft Silme Onayı", JOptionPane.YES_NO_OPTION);

            if (onay == JOptionPane.YES_OPTION) {
                if (dao.sil(silinecekK.getId())) {
                    JOptionPane.showMessageDialog(this, "Personel kaydı geçmişe taşındı ve giriş yetkisi kapatıldı.");
                    formuTemizle();
                    guncellemeAlanlariniTemizle();
                    personeldoldur();
                } else {
                    JOptionPane.showMessageDialog(this, "Silme hatası oluştu!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Silme hatası: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ortakDoldur(int seciliSira) {
        try {
            kullaniciDAO dao = new kullaniciDAO();
            List<Kullanici> liste = dao.tumPersonel(); 
            
            if (liste != null && (seciliSira - 1) < liste.size()) {
                Kullanici seciliK = liste.get(seciliSira - 1);

                personeldtarihifield1.setText(seciliK.getDogumTarihi() != null ? seciliK.getDogumTarihi() : "");
                personelmezunfield1.setText(seciliK.getMezuniyet() != null ? seciliK.getMezuniyet() : "");
                personelkurumfield1.setText(seciliK.getMezunKurum() != null ? seciliK.getMezunKurum() : "");
                atanansifrefiled.setText(seciliK.getSifre() != null ? seciliK.getSifre() : "");

                String unvan = seciliK.getRol().equals("admin") ? "yönetici" : seciliK.getRol();
                personelunvanbox1.setSelectedItem(unvan);
            }
        } catch (Exception e) {
            System.out.println("Bilgiler doldurulurken hata: " + e.getMessage());
        }
    }
    
    private void personelisimboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personelisimboxActionPerformed
        if (yukleniyor || personelisimbox.getSelectedIndex() <= 0) {
            guncellemeAlanlariniTemizle();
            return;
        }

        int seciliSira = personelisimbox.getSelectedIndex();
        
        yukleniyor = true;
        personelsoyisimbox.setSelectedIndex(seciliSira);
        personeltcbox.setSelectedIndex(seciliSira);
        yukleniyor = false;

        try {
            kullaniciDAO dao = new kullaniciDAO();
            List<Kullanici> liste = dao.tumPersonel(); 
            
            if (liste != null && (seciliSira - 1) < liste.size()) {
                Kullanici seciliK = liste.get(seciliSira - 1);

                personeldtarihifield1.setText(seciliK.getDogumTarihi() != null ? seciliK.getDogumTarihi() : "");
                personelmezunfield1.setText(seciliK.getMezuniyet() != null ? seciliK.getMezuniyet() : "");
                personelkurumfield1.setText(seciliK.getMezunKurum() != null ? seciliK.getMezunKurum() : "");
                atanansifrefiled.setText(seciliK.getSifre() != null ? seciliK.getSifre() : "");

                String unvan = seciliK.getRol().equals("admin") ? "yönetici" : seciliK.getRol();
                personelunvanbox1.setSelectedItem(unvan);
            }
        } catch (Exception e) {
            System.out.println("Bilgiler doldurulurken hata: " + e.getMessage());
        }
    }//GEN-LAST:event_personelisimboxActionPerformed

    

    private void personelsoyisimboxActionPerformed(java.awt.event.ActionEvent evt) {
        if (yukleniyor || personelsoyisimbox.getSelectedIndex() <= 0) {
            if (!yukleniyor) guncellemeAlanlariniTemizle();
            return;
        }

        int seciliSira = personelsoyisimbox.getSelectedIndex();
        
        yukleniyor = true;
        personelisimbox.setSelectedIndex(seciliSira);
        personeltcbox.setSelectedIndex(seciliSira);
        yukleniyor = false;

        ortakDoldur(seciliSira);
    }

    private void personeltcboxActionPerformed(java.awt.event.ActionEvent evt) {
        if (yukleniyor || personeltcbox.getSelectedIndex() <= 0) {
            if (!yukleniyor) guncellemeAlanlariniTemizle();
            return;
        }

        int seciliSira = personeltcbox.getSelectedIndex();
        
        yukleniyor = true;
        personelisimbox.setSelectedIndex(seciliSira);
        personelsoyisimbox.setSelectedIndex(seciliSira);
        yukleniyor = false;

        ortakDoldur(seciliSira);
    }
    
    
    private void formuTemizle() {
        personelisimfield.setText("");
        personelsoyisimfield.setText("");
        personeldtarihifield.setText("");
        personeltcfield.setText("");
        personelmezunfield.setText("");
        personelkurumfield.setText("");
        personelunvanbox.setSelectedIndex(0);
        atanansifrefiled.setText("");
    }
    
    private void guncellemeAlanlariniTemizle() {
        personeldtarihifield1.setText("");
        personelmezunfield1.setText("");
        personelkurumfield1.setText("");
        atanansifrefiled.setText("");
        personelunvanbox1.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField atanansifrefiled;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField personeldtarihifield;
    private javax.swing.JTextField personeldtarihifield1;
    private javax.swing.JComboBox<String> personelisimbox;
    private javax.swing.JTextField personelisimfield;
    private javax.swing.JTextField personelkurumfield;
    private javax.swing.JTextField personelkurumfield1;
    private javax.swing.JTextField personelmezunfield;
    private javax.swing.JTextField personelmezunfield1;
    private javax.swing.JComboBox<String> personelsoyisimbox;
    private javax.swing.JTextField personelsoyisimfield;
    private javax.swing.JComboBox<String> personeltcbox;
    private javax.swing.JTextField personeltcfield;
    private javax.swing.JComboBox<String> personelunvanbox;
    private javax.swing.JComboBox<String> personelunvanbox1;
    // End of variables declaration//GEN-END:variables
}
