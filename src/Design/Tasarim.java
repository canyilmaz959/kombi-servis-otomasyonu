/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Design;

import javax.swing.*;
import java.awt.*;

public class Tasarim {
    // Ortak Boyut Tanımlamaları
    private static final Dimension FIELD_BOYUTU = new Dimension(180, 28);
    private static final Dimension AREA_BOYUTU = new Dimension(250, 110);
    private static final Insets IC_BOSLUK = new Insets(5, 8, 5, 8);

    /**
     * Arıza Güncelleme Panelinin Tasarım Kuralları
     */
    
    public static void arizaGuncelleDuzenle(JPanel panel, 
            JTextField marka, JTextField model, JTextField seriNo, JTextField tarih, JTextField teknisyen,
            JTextArea sorun, JTextArea cozum, JTextArea yapilan,
            JScrollPane sp1, JScrollPane sp2, JScrollPane sp3,
            JButton guncelleButon, JComboBox<String> ilerlemeBox) {
        
        // 1. Kutuların Boyutlarını Sabitle
        marka.setPreferredSize(FIELD_BOYUTU);
        model.setPreferredSize(FIELD_BOYUTU);
        seriNo.setPreferredSize(FIELD_BOYUTU);
        tarih.setPreferredSize(FIELD_BOYUTU);
        teknisyen.setPreferredSize(FIELD_BOYUTU);
        ilerlemeBox.setPreferredSize(FIELD_BOYUTU);

        // ScrollPane (JTextArea dış kutuları) Boyutları
        sp1.setPreferredSize(AREA_BOYUTU); sp1.setMinimumSize(AREA_BOYUTU);
        sp2.setPreferredSize(AREA_BOYUTU); sp2.setMinimumSize(AREA_BOYUTU);
        sp3.setPreferredSize(AREA_BOYUTU); sp3.setMinimumSize(AREA_BOYUTU);

        // 2. FlatLaf İç Boşlukları (Padding) Dağıt
        sorun.putClientProperty("JTextField.padding", IC_BOSLUK);
        cozum.putClientProperty("JTextField.padding", IC_BOSLUK);
        yapilan.putClientProperty("JTextField.padding", IC_BOSLUK);
        marka.putClientProperty("JTextField.padding", IC_BOSLUK);
        model.putClientProperty("JTextField.padding", IC_BOSLUK);
        seriNo.putClientProperty("JTextField.padding", IC_BOSLUK);
        tarih.putClientProperty("JTextField.padding", IC_BOSLUK);
        teknisyen.putClientProperty("JTextField.padding", IC_BOSLUK);

        // 3. Oval Köşe Şıklığı (Round Rect)
        guncelleButon.putClientProperty("JButton.buttonType", "roundRect");
        ilerlemeBox.putClientProperty("JComponent.roundRect", true);
    }
    
    public static void arizaKayitDuzenle(JPanel panel, 
            JComboBox<String> marka, JComboBox<String> model, JTextField seriNo, JTextField tarih, JComboBox<String> teknisyen,
            JComboBox<String> mAd, JComboBox<String> mSoyad, JComboBox<String> mTel,
            JTextArea sorun, JTextArea cozum, JScrollPane sp1, JScrollPane sp2, JButton kayitButon) {
        
        // Boyutları Kilitle
        marka.setPreferredSize(FIELD_BOYUTU);
        model.setPreferredSize(FIELD_BOYUTU);
        seriNo.setPreferredSize(FIELD_BOYUTU);
        tarih.setPreferredSize(FIELD_BOYUTU);
        teknisyen.setPreferredSize(FIELD_BOYUTU);
        mAd.setPreferredSize(FIELD_BOYUTU);
        mSoyad.setPreferredSize(FIELD_BOYUTU);
        mTel.setPreferredSize(FIELD_BOYUTU);
        
        sp1.setPreferredSize(AREA_BOYUTU); sp1.setMinimumSize(AREA_BOYUTU);
        sp2.setPreferredSize(AREA_BOYUTU); sp2.setMinimumSize(AREA_BOYUTU);

        // İç Boşluklar ve Oval Köşeler
        seriNo.putClientProperty("JTextField.padding", IC_BOSLUK);
        tarih.putClientProperty("JTextField.padding", IC_BOSLUK);
        sorun.putClientProperty("JTextField.padding", IC_BOSLUK);
        cozum.putClientProperty("JTextField.padding", IC_BOSLUK);

        marka.putClientProperty("JComponent.roundRect", true);
        model.putClientProperty("JComponent.roundRect", true);
        teknisyen.putClientProperty("JComponent.roundRect", true);
        mAd.putClientProperty("JComponent.roundRect", true);
        mSoyad.putClientProperty("JComponent.roundRect", true);
        mTel.putClientProperty("JComponent.roundRect", true);
        kayitButon.putClientProperty("JButton.buttonType", "roundRect");
    }
    
    public static void tabloDuzenle(JTable tablo) {
        tablo.setRowHeight(32);
        tablo.setShowGrid(true);
        tablo.putClientProperty("JTable.showHorizontalLines", true);
        tablo.putClientProperty("JTable.showVerticalLines", false);
    }
    
}
