/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import java.util.List;
import model.Ariza;
import model.Musteri;
import model.Kullanici;
import dao.arizaDAO;
import dao.musteriDAO;
import dao.kullaniciDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class arizaguncelle extends javax.swing.JPanel {

    private int gelenArizaId;
    private Ariza mevcutAriza;
    private Musteri mevcutMusteri;
    
    public arizaguncelle() {
        initComponents();
    }
    
    public arizaguncelle(int arizaId) {
        initComponents();
        this.gelenArizaId = arizaId;
        
        Design.Tasarim.arizaGuncelleDuzenle(this, 
            guncellememarkafield, guncellememodelfield, guncellemeserinofield, gunceltarihfield, atananteknisyenfield,
            sorunarea, cozumarea, yapilanarea, jScrollPane1, jScrollPane2, jScrollPane3,
            guncellebuton, ilerlemedurumubox
        );
        
        gunceltarih();
        detaylariYukle();
    }
    
    private void gunceltarih() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        gunceltarihfield.setText(dtf.format(LocalDate.now()));
    }

    private void detaylariYukle() {
        try {
            arizaDAO aDao = new arizaDAO();
            mevcutAriza = aDao.arizaBul(this.gelenArizaId); 

            if (mevcutAriza != null) {
                sorunarea.setText(mevcutAriza.getAciklama() != null ? mevcutAriza.getAciklama() : "");
                cozumarea.setText(mevcutAriza.getCozumOnerisi() != null ? mevcutAriza.getCozumOnerisi() : "");
                yapilanarea.setText(mevcutAriza.getNotlar() != null ? mevcutAriza.getNotlar() : "");
                guncellememarkafield.setText(mevcutAriza.getKombiMarka() != null ? mevcutAriza.getKombiMarka() : ""); 
                guncellememodelfield.setText(mevcutAriza.getKombiModel() != null ? mevcutAriza.getKombiModel() : ""); 
                guncellemeserinofield.setText(mevcutAriza.getSeriNo() != null ? mevcutAriza.getSeriNo() : ""); 
                ilerlemedurumubox.setSelectedItem(mevcutAriza.getDurum()); //
                 
                musteriDAO mDao = new musteriDAO();
                mevcutMusteri = mDao.musteriBul(mevcutAriza.getMusteriId());
                if (mevcutMusteri != null) {
                    musteriadifield.setText(mevcutMusteri.getAd());
                    musterisoyadıfield.setText(mevcutMusteri.getSoyad());
                    musteritelnofield.setText(mevcutMusteri.getTelefon());
                }

                kullaniciDAO kDao = new kullaniciDAO();
                List<Kullanici> personeller = kDao.tumPersonel();
                if (personeller != null) {
                    for (Kullanici p : personeller) {
                        if (p.getId() == mevcutAriza.getTeknisyenId()) {
                            atananteknisyenfield.setText(p.getAdSoyad());
                            break;
                        }
                    }
                }
                
                musteriadifield.setEditable(false); 
                musterisoyadıfield.setEditable(false); 
                musteritelnofield.setEditable(false); 
              
                sorunarea.setEditable(false); 
                atananteknisyenfield.setEditable(false); 
                gunceltarihfield.setEditable(false); 
            }
        } catch (Exception e) {
            System.out.println("Arıza detayları yüklenirken hata: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        musteriadifield = new javax.swing.JTextField();
        musterisoyadıfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        musteritelnofield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ilerlemedurumubox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        atananteknisyenfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        guncellememarkafield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        guncellememodelfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        guncellemeserinofield = new javax.swing.JTextField();
        guncellebuton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        gunceltarihfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sorunarea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        cozumarea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        yapilanarea = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("sorun:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 46, 117, -1));

        jLabel2.setText("çözüm önerisi:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 46, -1, -1));

        jLabel3.setText("müşteri adı:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel4.setText("soyadı:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 284, -1, -1));
        add(musteriadifield, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 222, 93, 30));
        add(musterisoyadıfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 272, 93, 30));

        jLabel5.setText("müşteri telefon numarası:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 318, -1, -1));
        add(musteritelnofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 307, 120, 30));

        jLabel6.setText("yapılan işlemler:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 247, -1, -1));

        jLabel7.setText("ilerleme durumu:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        ilerlemedurumubox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "devam ediliyor...", "parça bekleniyor...", "bitti" }));
        add(ilerlemedurumubox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        jLabel8.setText("atanan tekniker:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 479, -1, -1));
        add(atananteknisyenfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 468, 119, 30));

        jLabel9.setText("marka:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 358, -1, -1));
        add(guncellememarkafield, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 355, 120, 30));

        jLabel10.setText("model:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 405, -1, -1));
        add(guncellememodelfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 110, 30));

        jLabel11.setText("seri no:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));
        add(guncellemeserinofield, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 120, 30));

        guncellebuton.setText("GÜNCELLE");
        guncellebuton.addActionListener(this::guncellebutonActionPerformed);
        add(guncellebuton, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 513, 128, 53));

        jLabel12.setText("arıza güncelleme");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 12, -1, -1));

        jLabel13.setText("tarih: ");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 547, 63, -1));
        add(gunceltarihfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 544, 108, 30));

        sorunarea.setColumns(20);
        sorunarea.setLineWrap(true);
        sorunarea.setRows(5);
        sorunarea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(sorunarea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 98, -1, -1));

        cozumarea.setColumns(20);
        cozumarea.setLineWrap(true);
        cozumarea.setRows(5);
        cozumarea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(cozumarea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 80, -1, 104));

        yapilanarea.setColumns(20);
        yapilanarea.setLineWrap(true);
        yapilanarea.setRows(5);
        yapilanarea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(yapilanarea);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 304, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void guncellebutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncellebutonActionPerformed
        if (mevcutAriza == null) {
            JOptionPane.showMessageDialog(this, "Güncellenecek arıza kaydı bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String yeniDurum = ilerlemedurumubox.getSelectedItem().toString(); 
        String yeniCozum = cozumarea.getText().trim(); 
        String yeniIslemler = yapilanarea.getText().trim(); 

        mevcutAriza.setDurum(yeniDurum); 
        mevcutAriza.setCozumOnerisi(yeniCozum.isEmpty() ? null : yeniCozum); 
        mevcutAriza.setNotlar(yeniIslemler.isEmpty() ? null : yeniIslemler); 

        arizaDAO dao = new arizaDAO();
        if (!dao.guncelle(mevcutAriza)) { 
            JOptionPane.showMessageDialog(this, "Veritabanı güncelleme hatası oluştu!", "Hata", JOptionPane.ERROR_MESSAGE); 
            return;
        }

        
        if (yeniDurum.equals("bitti")) {
            
            String anaDizinYolu = "C:\\Users\\muham\\OneDrive\\Belgeler\\NetBeansProjects\\kombi\\raporlar";
            java.io.File raporKlasor = new java.io.File(anaDizinYolu);
            
            if (!raporKlasor.exists()) {
                raporKlasor.mkdirs(); 
            }

            String mAd = mevcutMusteri != null ? mevcutMusteri.getAd().trim()
                    .replace(" ", "_").replace("ı","i").replace("ğ","g").replace("ü","u").replace("ş","s").replace("ö","o").replace("ç","c")
                    .replace("I","I").replace("Ğ","G").replace("Ü","U").replace("Ş","S").replace("Ö","O").replace("Ç","C") : "Bilinmeyen";
            String mSoyad = mevcutMusteri != null ? mevcutMusteri.getSoyad().trim()
                    .replace(" ", "_").replace("ı","i").replace("ğ","g").replace("ü","u").replace("ş","s").replace("ö","o").replace("ç","c")
                    .replace("I","I").replace("Ğ","G").replace("Ü","U").replace("Ş","S").replace("Ö","O").replace("Ç","C") : "Musteri";
            
            java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String benzersizPdfAdi = anaDizinYolu + "\\" + mAd + "_" + mSoyad + "_" + dtf.format(java.time.LocalDateTime.now()) + ".pdf";

            // iText PDF oluşturma
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            try {
                com.itextpdf.text.pdf.PdfWriter.getInstance(document, new java.io.FileOutputStream(benzersizPdfAdi));
                document.open();

                com.itextpdf.text.Font baslikFont = com.itextpdf.text.FontFactory.getFont(com.itextpdf.text.FontFactory.HELVETICA_BOLD, 16);
                com.itextpdf.text.Paragraph baslik = new com.itextpdf.text.Paragraph("TEKNIK SERVIS TESLIM RAPORU", baslikFont);
                baslik.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
                baslik.setSpacingAfter(20);
                document.add(baslik);

                document.add(new com.itextpdf.text.Paragraph("Servis Tarihi: " + gunceltarihfield.getText()));
                document.add(new com.itextpdf.text.Paragraph("Ariza Kayit No: " + mevcutAriza.getId() + "\n\n"));

                com.itextpdf.text.pdf.PdfPTable tablo = new com.itextpdf.text.pdf.PdfPTable(2);
                tablo.setWidthPercentage(100);
                tablo.setWidths(new float[]{3f, 7f});

                tablo.addCell("Musteri Adi Soyadi:");
                tablo.addCell(musteriadifield.getText() + " " + musterisoyadıfield.getText());
                
                tablo.addCell("Telefon Numarasi:");
                tablo.addCell(musteritelnofield.getText());

                tablo.addCell("Cihaz Marka / Model:");
                tablo.addCell(mevcutAriza.getKombiMarka() + " " + (mevcutAriza.getKombiModel() != null ? mevcutAriza.getKombiModel() : ""));

                tablo.addCell("Seri Numarasi:");
                tablo.addCell(mevcutAriza.getSeriNo() != null ? mevcutAriza.getSeriNo() : "-");

                tablo.addCell("Musteri Sikayeti:");
                tablo.addCell(mevcutAriza.getAciklama());

                tablo.addCell("Teknisyen Onerisi:");
                tablo.addCell(mevcutAriza.getCozumOnerisi() != null ? mevcutAriza.getCozumOnerisi() : "-");

                tablo.addCell("Yapilan Islemler:");
                tablo.addCell(mevcutAriza.getNotlar() != null ? mevcutAriza.getNotlar() : "-");

                tablo.addCell("Atanan Tekniker:");
                tablo.addCell(atananteknisyenfield.getText());

                document.add(tablo);
                document.close(); 

                
                if (dao.bitenarizasil(mevcutAriza.getId())) {
                    JOptionPane.showMessageDialog(this, 
                        "Arıza başarıyla tamamlandı!\n" + mAd + "_" + mSoyad + " adına servis raporu oluşturuldu ve kayıtlardan temizlendi.", 
                        "Servis Kapatıldı", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Listeyi tazeleyip arayüze dön
                    java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(this);
                    if (win instanceof main) {
                        main anaPencere = (main) win;
                        anaPencere.sayfaGoster(new devamedenarizalar());
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Rapor PDF dosyasına dönüştürülürken iText hatası oluştu: " + e.getMessage(), "PDF Hatası", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Arıza takip bilgileri başarıyla güncellendi.");
        }
    }//GEN-LAST:event_guncellebutonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField atananteknisyenfield;
    private javax.swing.JTextArea cozumarea;
    private javax.swing.JButton guncellebuton;
    private javax.swing.JTextField guncellememarkafield;
    private javax.swing.JTextField guncellememodelfield;
    private javax.swing.JTextField guncellemeserinofield;
    private javax.swing.JTextField gunceltarihfield;
    private javax.swing.JComboBox<String> ilerlemedurumubox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField musteriadifield;
    private javax.swing.JTextField musterisoyadıfield;
    private javax.swing.JTextField musteritelnofield;
    private javax.swing.JTextArea sorunarea;
    private javax.swing.JTextArea yapilanarea;
    // End of variables declaration//GEN-END:variables
}
