/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import model.Kullanici;

/**
 *
 * @author muham
 */
public class sessionmanager {
    
    private static Kullanici aktifKullanici = null;

    // Giriş yapınca çağrılır
    public static void girisYap(Kullanici k) {
        aktifKullanici = k;
    }

    public static Kullanici getAktifKullanici() {
        return aktifKullanici;
    }

    // Admin mi kontrolü
    public static boolean isAdmin() {
        return aktifKullanici != null && 
               aktifKullanici.getRol().equals("admin");
    }

    // Çıkış yapınca çağrılır
    public static void cikisYap() {
        aktifKullanici = null;
    }
}

