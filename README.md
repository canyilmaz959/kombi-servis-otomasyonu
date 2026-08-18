# 🔧 KombiServis Pro

KombiServis Pro, kombi teknik servis firmalarının müşteri, personel, arıza, stok ve raporlama süreçlerini dijital ortamda merkezi olarak yönetebilmesi amacıyla geliştirilmiş **Java Swing** tabanlı bir masaüstü otomasyon sistemidir.

Rol tabanlı yetkilendirme mimarisi, parametreli veri güvenliği, dinamik stok ve arıza takibi ile otomatik PDF servis raporu üretimi gibi servis operasyonlarının tüm aşamalarını kapsar.

---

## 📸 Ekran Görüntüleri

### 1. Giriş & Yetkilendirme
Personel ve admin kullanıcılar için güvenli giriş ekranı.

![Personel Giriş Ekranı](screenshots/login.png)

---

### 2. Müşteri Yönetimi
Yeni müşteri kaydı ekleme, mevcut bilgileri güncelleme ve silme işlemleri.

| Müşteri Kayıt & Düzenleme | Müşteri Silme İşlemi |
| :---: | :---: |
| ![Müşteri Ekleme](screenshots/musteri-ekle.png) | ![Müşteri Silme](screenshots/musteri-sil.png) |

---

### 3. Personel Yönetimi
Teknisyen ve personel bilgilerinin kaydedilmesi ve otomatik kullanıcı oluşturma.

![Personel Kaydı](screenshots/personel-kayit.png)

---

### 4. Arıza Takip & Yönetim
Yeni arıza formu doldurma, teknisyen atama, arıza durum takibi ve servis tamamlama süreçleri.

| Yeni Arıza Kaydı Oluşturma | Devam Eden Arızalar Listesi |
| :---: | :---: |
| ![Arıza Kaydı](screenshots/ariza-kayit.png) | ![Arıza Listesi](screenshots/ariza-listesi.png) |

| Arıza Durum Güncelleme & Çözüm |
| :---: |
| ![Arıza Güncelleme](screenshots/ariza-guncelle.png) |

---

### 5. Stok Yönetimi
Kombi ve yedek parça stoklarının durum (sıfır/2. el/arızalı), marka, model ve seri no bazlı takibi.

![Stok Yönetimi](screenshots/stok-yonetimi.png)

---

### 6. Silinen Kayıtlar & Geri Yükleme
Silinen müşteri ve personel verilerini arşivleme ve gerektiğinde sisteme geri yükleme (Soft-delete).

![Silinenler ve Müşteri Geçmişi](screenshots/musteri-gecmisi.png)

---

### 7. PDF Raporlama Sistemi
Tamamlanan arıza kayıtları için iText PDF kütüphanesi ile otomatik servis teslim raporu üretimi.

![PDF Servis Raporu](screenshots/servis-raporu.png)

---

## ✨ Özellikler

* **Kullanıcı Yönetimi**
  * Admin ve Personel rol tabanlı yetkilendirme
  * Oturum (Session) ve durum kontrolü
* **Müşteri Yönetimi**
  * Yeni müşteri ve kombi bilgileri kaydı
  * Bilgi güncelleme, arama ve geçmiş takibi
* **Arıza Yönetimi**
  * Detaylı arıza formu oluşturma ve teknisyen atama
  * Devam eden arızaların durum filtrelemesi
  * Yapılan işlemler ve çözüm önerileri kaydı
* **Stok Yönetimi**
  * Parça ve kombi bazında stok giriş/çıkışı
  * 2. El / Sıfır / Arızalı durum kontrolü
  * Marka ve model bazlı filtreleme
* **Raporlama & Çıktı**
  * Tamamlanan servisler için iText PDF destekli otomatik teknik servis teslim raporu

---

## 🛠️ Kullanılan Teknolojiler

* **Programlama Dili:** Java
* **Arayüz (GUI):** Java Swing
* **Veritabanı:** MySQL
* **Veri Erişimi:** JDBC (PreparedStatement)
* **Konteynerizasyon:** Docker (MySQL Container)
* **Raporlama Kütüphanesi:** iText PDF
* **Mimari / Tasarım:** MVC<img width="1653" height="766" alt="image7" src="https://github.com/user-attachments/assets/f2cb3518-bd6a-4920-a007-30f7d95a143f" />
<img width="490" height="392" alt="imagec" src="https://github.com/user-attachments/assets/4e2deb66-563a-48f3-ac92-b31bf6ddef66" />
<img width="490" height="392" alt="imagec" src="https://github.com/user-attachments/assets/7848a7ac-642a-49bd-8a13-bcf6f1c2aeae" />
 & DAO (Data Access Object) Pattern
* **Geliştirme Ortamı:** NetBeans / IntelliJ IDEA

---

## 📁 Proje Mimarisi

```text
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
└── Design<img width="490" height="392" alt="imagec" src="https://github.com/user-attachments/assets/e6014daf-ef7e-45ba-ab7e-501a8d015446" />
<img width="490" height="392" alt="imagec" src="https://github.com/user-attachments/assets/838dcb3f-f317-4989-82b8-408dd599cef2" />
