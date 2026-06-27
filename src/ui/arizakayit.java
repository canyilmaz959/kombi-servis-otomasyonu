/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Musteri;
import model.Kullanici;
import model.Ariza;
import dao.musteriDAO;
import dao.kullaniciDAO;
import dao.arizaDAO;

public class arizakayit extends javax.swing.JPanel {

    private boolean yukleniyor = false;
    private List<Musteri> aktifMusteriler;
    private List<Kullanici> aktifTeknisyenler;
    
    
    public arizakayit() {
        initComponents();
        
        Design.Tasarim.arizaKayitDuzenle(this,
            markabox, modelbox, serinofield, tarihfield, teknisyenbox,
            musteriadibox, musterisoyadibox, musteritelnobox,
            txtsorun, txtcozum, jScrollPane1, jScrollPane2, kayitbuton
        );
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tarihfield.setText(dtf.format(LocalDate.now()));
        
        dbdenyukle();
        
        markabox.addActionListener(e -> markaDegisti());
        
        musteriadibox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doldur(1);
            }
        });

        musterisoyadibox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doldur(2);
            }
        });

        musteritelnobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doldur(3);
            }
        });
    }
    
    private void dbdenyukle() {
        yukleniyor = true;
        
        markabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz...", "Vaillant", "E.C.A.", "Buderus", "Demirdöküm" }));
        modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Önce Marka Seçin" }));
        
        musteriadibox.removeAllItems();
        musterisoyadibox.removeAllItems();
        musteritelnobox.removeAllItems();
        teknisyenbox.removeAllItems();

        musteriadibox.addItem("Seçiniz...");
        musterisoyadibox.addItem("Seçiniz...");
        musteritelnobox.addItem("Seçiniz...");
        teknisyenbox.addItem("Tekniker Seçin");

        try {
            musteriDAO mDao = new musteriDAO();
            aktifMusteriler = mDao.tumMusteriler(); 
            if (aktifMusteriler != null) {
                for (Musteri m : aktifMusteriler) {
                    musteriadibox.addItem(m.getAd());
                    musterisoyadibox.addItem(m.getSoyad());
                    musteritelnobox.addItem(m.getTelefon() != null ? m.getTelefon() : "---");
                }
            }
            
            kullaniciDAO kDao = new kullaniciDAO();
            aktifTeknisyenler = kDao.tumTeknisyenler();
            if (aktifTeknisyenler != null) {
                for (Kullanici k : aktifTeknisyenler) {
                    teknisyenbox.addItem(k.getAdSoyad());
                }
            }
            
        } catch (Exception e) {
            System.out.println("Arıza kayıt form verileri veritabanından çekilirken hata: " + e.getMessage());
        }
        
        yukleniyor = false;
    }
    
    private void doldur(int dolum) {
        if (yukleniyor) return;

        int seciliSira = 0;
        if (dolum == 1) seciliSira = musteriadibox.getSelectedIndex();
        else if (dolum == 2) seciliSira = musterisoyadibox.getSelectedIndex();
        else if (dolum == 3) seciliSira = musteritelnobox.getSelectedIndex();

        yukleniyor = true;
        musteriadibox.setSelectedIndex(seciliSira);
        musterisoyadibox.setSelectedIndex(seciliSira);
        musteritelnobox.setSelectedIndex(seciliSira);
        yukleniyor = false;
    }
    
    private void markaDegisti() {
        if (markabox.getSelectedIndex() <= 0) {
            modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Önce Marka Seçin" }));
            return;
        }
        
        String secilenMarka = markabox.getSelectedItem().toString();
        if (secilenMarka.equals("Vaillant")) {
            modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ecoTEC Pro", "ecoTEC Plus", "turbotec" }));
        } else if (secilenMarka.equals("E.C.A.")) {
            modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proteus Premix", "Calora Premix", "Confeo Premix" }));
        } else if (secilenMarka.equals("Buderus")) {
            modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Logamax plus GB022", "Logamax plus GB122i", "Logamax U072" }));
        } else if (secilenMarka.equals("Demirdöküm")) {
            modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nitromix", "Atromix", "Atron Condense" }));
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        teknisyenbox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tarihfield = new javax.swing.JTextField();
        kayitbuton = new javax.swing.JButton();
        serinofield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        markabox = new javax.swing.JComboBox<>();
        modelbox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        musteriadibox = new javax.swing.JComboBox<>();
        musterisoyadibox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        musteritelnobox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtsorun = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcozum = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("marka girin:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 52, 71, -1));

        jLabel2.setText("model girin:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        jLabel3.setText("sorunu yazın:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 129, -1));

        jLabel4.setText("tekniker ata:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 64, 133, -1));

        teknisyenbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        teknisyenbox.addActionListener(this::teknisyenboxActionPerformed);
        add(teknisyenbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 108, 140, 30));

        jLabel5.setText("çözüm önerisi(opsiyonel)");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 272, -1, -1));

        jLabel6.setText("tarih:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 513, 45, -1));

        tarihfield.setText("../../....");
        add(tarihfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 510, 100, 30));

        kayitbuton.setText("kayıt oluştur");
        kayitbuton.addActionListener(this::kayitbutonActionPerformed);
        add(kayitbuton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 135, 51));

        serinofield.addActionListener(this::serinofieldActionPerformed);
        add(serinofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 108, 88, -1));

        jLabel7.setText("seri no:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 111, 393, -1));

        jLabel8.setText("ARIZA KAYDI FORMU");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 20, 142, -1));

        markabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(markabox, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 49, 140, -1));

        modelbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(modelbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 77, 140, -1));

        jLabel10.setText("müşteri adı & soyadı:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 145, -1, -1));

        musteriadibox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(musteriadibox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 142, 110, -1));

        musterisoyadibox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(musterisoyadibox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 110, -1));

        jLabel11.setText("müşteri telefon numarası:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        musteritelnobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(musteritelnobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 110, -1));

        txtsorun.setColumns(20);
        txtsorun.setLineWrap(true);
        txtsorun.setRows(5);
        txtsorun.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtsorun);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 161));

        txtcozum.setColumns(20);
        txtcozum.setLineWrap(true);
        txtcozum.setRows(5);
        txtcozum.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtcozum);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, 161));
    }// </editor-fold>//GEN-END:initComponents

    private void serinofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serinofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serinofieldActionPerformed

    private void teknisyenboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teknisyenboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teknisyenboxActionPerformed

    private void kayitbutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayitbutonActionPerformed
        if (musteriadibox.getSelectedIndex() <= 0 || teknisyenbox.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Lütfen bir müşteri ve atama yapılacak bir görevli teknikeri seçin!", "Eksik Seçim", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String marka = markabox.getSelectedItem() != null ? markabox.getSelectedItem().toString() : "";
        String model = modelbox.getSelectedItem() != null ? modelbox.getSelectedItem().toString() : "";
        String seriNo = serinofield.getText().trim();
        String sorunMetni = txtsorun.getText().trim();
        String cozumMetni = txtcozum.getText().trim();

        if (marka.equals("Seçiniz...") || sorunMetni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen cihaz markasını seçin ve arıza sorununu açıkça yazın!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Musteri seciliMusteri = aktifMusteriler.get(musteriadibox.getSelectedIndex() - 1);
        Kullanici seciliTeknisyen = aktifTeknisyenler.get(teknisyenbox.getSelectedIndex() - 1);
        
        Ariza yeniAriza = new Ariza();
        yeniAriza.setMusteriId(seciliMusteri.getId()); 
        yeniAriza.setTeknisyenId(seciliTeknisyen.getId());
        
        yeniAriza.setKombiMarka(marka);
        yeniAriza.setKombiModel(model.equals("Önce Marka Seçin") ? "" : model);
        yeniAriza.setSeriNo(seriNo.isEmpty() ? null : seriNo);
        yeniAriza.setAciklama(sorunMetni); 
        yeniAriza.setCozumOnerisi(cozumMetni.isEmpty() ? null : cozumMetni);
        yeniAriza.setNotlar(""); 

        arizaDAO dao = new arizaDAO();
        if (dao.ekle(yeniAriza)){
            JOptionPane.showMessageDialog(this, "Arıza kaydı başarıyla oluşturuldu!\nMüşteri: " + seciliMusteri.getAd() + " " + seciliMusteri.getSoyad() + "\nAtanan Teknisyen: " + seciliTeknisyen.getAdSoyad());
            formuTemizle();
        } else {
            JOptionPane.showMessageDialog(this, "Arıza kaydı oluşturulurken veritabanı ilişkisel bütünlük hatası meydana geldi!", "Sistem Hatası", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_kayitbutonActionPerformed

    
    private void formuTemizle() {
        markabox.setSelectedIndex(0);
        modelbox.setSelectedIndex(0);
        serinofield.setText("");
        txtsorun.setText("");
        txtcozum.setText("");
        musteriadibox.setSelectedIndex(0);
        musterisoyadibox.setSelectedIndex(0);
        musteritelnobox.setSelectedIndex(0);
        teknisyenbox.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kayitbuton;
    private javax.swing.JComboBox<String> markabox;
    private javax.swing.JComboBox<String> modelbox;
    private javax.swing.JComboBox<String> musteriadibox;
    private javax.swing.JComboBox<String> musterisoyadibox;
    private javax.swing.JComboBox<String> musteritelnobox;
    private javax.swing.JTextField serinofield;
    private javax.swing.JTextField tarihfield;
    private javax.swing.JComboBox<String> teknisyenbox;
    private javax.swing.JTextArea txtcozum;
    private javax.swing.JTextArea txtsorun;
    // End of variables declaration//GEN-END:variables
}
