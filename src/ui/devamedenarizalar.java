/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.Ariza;
import dao.musteriDAO;
import javax.swing.table.TableRowSorter;

public class devamedenarizalar extends javax.swing.JPanel {

    private javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> sorter;
    
    public devamedenarizalar() {
        initComponents();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { 
                    tabloCiftTiklandi();
                }
            }
        });
        
        
        tabloyuDoldur();
    }
    
    public void tabloyuDoldur() {
        String[] kolonlar = {"Tarih", "Müşteri Adı Soyadı", "Cihaz / Model", "Durum", "id"};
        DefaultTableModel model = new DefaultTableModel(kolonlar, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        try {
            dao.arizaDAO dao = new dao.arizaDAO();
            dao.musteriDAO mDao = new musteriDAO();
            List<Ariza> aktifArizalar = dao.devamEdenler();
            
            if (aktifArizalar != null) {
                for (Ariza a : aktifArizalar) {
                    model.Musteri m = mDao.musteriBul(a.getMusteriId());
                    String musteriGosterim = "Bilinmeyen Müşteri";
                    if (m != null){
                        musteriGosterim = m.getAd() + " " + m.getSoyad();
                    }
                    Object[] satir = {
                        a.getOlusturmaTarihi(),
                        musteriGosterim,
                        a.getKombiMarka() + " " + a.getKombiModel(),
                        a.getDurum(),
                        a.getId()
                    };
                    model.addRow(satir);
                }
            }
        } catch (Exception e) {
            System.out.println("Tablo yükleme hatası: " + e.getMessage());
        }
        
        jTable1.setModel(model);
        
        this.sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(this.sorter);
        
        jTable1.getColumnModel().getColumn(4).setMinWidth(0);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(0);
    
        Design.Tasarim.tabloDuzenle(jTable1);
    }
    
    private void tabloCiftTiklandi() {
        int seciliSatir = jTable1.getSelectedRow();
        if (seciliSatir != -1) {
            int modelSatir = jTable1.convertRowIndexToModel(seciliSatir);
            int arizaId = Integer.parseInt(jTable1.getModel().getValueAt(modelSatir, 4).toString());
            
            java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (win instanceof main) {
                main anaPencere = (main) win;
                anaPencere.sayfaGoster(new arizaguncelle(arizaId));
            }
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aramafield = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        aramafield.setText("filtrele...");
        aramafield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramafieldKeyReleased(evt);
            }
        });
        add(aramafield, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void aramafieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramafieldKeyReleased
        String arananMetin = aramafield.getText().trim();
    
    if (arananMetin.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
          sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + arananMetin));
    }
    }//GEN-LAST:event_aramafieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramafield;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
