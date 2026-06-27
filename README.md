# 🔧 KombiServis Pro

KombiServis Pro, kombi servis firmalarının müşteri, personel, arıza ve stok süreçlerini dijital ortamda yönetebilmesi için geliştirilmiş Java Swing tabanlı masaüstü otomasyon sistemidir.

Projede kullanıcı giriş sistemi, rol tabanlı yetkilendirme, müşteri kayıtları, arıza takip sistemi, stok yönetimi ve PDF raporlama gibi temel servis otomasyonu özellikleri bulunmaktadır.

---

# Özellikler

## Kullanıcı Yönetimi

- Kullanıcı giriş sistemi
- Admin ve Personel rol desteği
- Aktif/Pasif kullanıcı kontrolü
- Oturum (Session) yönetimi

---

## Müşteri Yönetimi

- Yeni müşteri ekleme
- Müşteri bilgilerini güncelleme
- Kombi bilgilerini kayıt altına alma
- Müşteri geçmişini görüntüleme

---

## Arıza Yönetimi

- Yeni arıza kaydı oluşturma
- Devam eden arızaları listeleme
- Arıza durumu güncelleme
- Çözüm önerileri ekleme
- Teknisyen atama

---

## Stok Yönetimi

- Yeni stok ekleme
- Parça yönetimi
- Minimum stok takibi
- Marka ve model bazlı filtreleme

---

## Raporlama

- PDF servis raporu oluşturma
- Hazırlanan raporları görüntüleme

---

# Kullanılan Teknolojiler

- Java
- Java Swing
- MySQL
- JDBC
- NetBeans
- DAO Pattern
- MVC yaklaşımı
- iText PDF (PDF oluşturma)

---

# Proje Yapısı

```
src
│
├── DAO
│   ├── arizaDAO.java
│   ├── kullaniciDAO.java
│   ├── musteriDAO.java
│   └── stoklarDAO.java
│
├── Model
│   ├── Ariza.java
│   ├── Kullanici.java
│   ├── Musteri.java
│   ├── Stok.java
│   └── StokHareket.java
│
├── UI
│   ├── Login
│   ├── Main
│   ├── Müşteri İşlemleri
│   ├── Personel İşlemleri
│   ├── Arıza İşlemleri
│   └── Stok İşlemleri
│
├── Util
│   ├── DBconnection.java
│   └── SessionManager.java
│
└── Design
```

---

# Veritabanı

Projede MySQL kullanılmaktadır.

Bağlantı ayarları:

```
Host: localhost
Database: mydb
```

DB bağlantısı `DBconnection.java` dosyası üzerinden yapılmaktadır.

---

# Kurulum

1. Repository'i klonlayın.

```
git clone https://github.com/KULLANICI_ADIN/KombiServisPro.git
```

2. MySQL üzerinde gerekli veritabanını oluşturun.

3. `DBconnection.java` içerisindeki;

- URL
- Kullanıcı adı
- Şifre

bilgilerini kendi sisteminize göre düzenleyin.

4. Projeyi NetBeans veya IntelliJ IDEA ile açın.

5. Gerekli JDBC Driver'ını ekleyin.

6. Çalıştırın.

---

# Ekranlar

- Giriş Ekranı
- Ana Menü
- Müşteri Kayıt
- Personel Kayıt
- Arıza Kayıt
- Devam Eden Arızalar
- Müşteri Geçmişi
- Stok Yönetimi

---

# Güvenlik

- Parametreli SQL sorguları (PreparedStatement)
- Rol tabanlı erişim kontrolü
- Session yönetimi

---

# Geliştirilebilecek Özellikler

- Şifrelerin BCrypt ile hashlenmesi
- Log sistemi
- Dashboard
- Grafiksel raporlar
- Bildirim sistemi
- E-posta entegrasyonu
- Çoklu kullanıcı desteği
- REST API desteği

---

# Lisans

Bu proje eğitim amacıyla geliştirilmiştir.

---

# Geliştirici

**Can Yılmaz**

Bilgisayar Programcılığı Öğrencisi

Java • Swing • MySQL • JDBC
