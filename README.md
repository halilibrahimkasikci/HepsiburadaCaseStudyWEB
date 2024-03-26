# Hepsiburada Test Otomasyonu

Bu proje, Hepsiburada.com web sitesi için test senaryolarının otomasyonunu sağlar.

## Senaryolar

### Senaryo 1: En Yeni Değerlendirme Oylama

1. hepsiburada.com sitesi ziyaret edilir.
2. Arama işlemi gerçekleştirilir.
3. Arama sonucunda gelen ürün listesinden rastgele bir ürün seçilir ve ürün detay sayfasına gidilir.
4. Değerlendirmeler tab'ine geçiş yapılır ve "En Yeni Değerlendirme" seçeneği seçilir.
5. Gelen değerlendirmelerden biri seçilerek thumbsUp seçeneği işaretlenir.
6. Teşekkür Ederiz yazısının geldiği kontrol edilir.
7. Eğer Değerlendirmeler tab'ında hiç yorum yoksa herhangi bir işlem yapılmaz.

### Senaryo 2: Ürün Beğenme

1. hepsiburada.com sitesi ziyaret edilir.
2. Giriş Yap butonu tıklanarak üye girişi gerçekleştirilir.
3. Arama işlemi gerçekleştirilir.
4. Arama sonucunda gelen ürün listesinden rastgele bir ürün seçilir ve ürün detay sayfasına gidilir.
5. Seçilen ürün sayfasında Beğen butonuna basılır.
6. Süreç kontrolü sağlanır.

### Senaryo 3: Ürün Detayı ve Sepet Fiyatı Kontrolü

1. hepsiburada.com sitesi ziyaret edilir.
2. Arama işlemi gerçekleştirilir.
3. Arama sonucunda gelen ürün listesinden rastgele bir ürün seçilir ve ürün detay sayfasına gidilir.
4. Seçilen ürün sayfasında ürün fiyat bilgisi alınır.
5. Ürün sepete eklenir.
6. Ürün sayfası ile sepet fiyatının eşit olduğu kontrol edilir.

## Kurulum

Projenin çalıştırılması için aşağıdaki adımları izleyin:

1. Projeyi bilgisayarınıza klonlayın.
2. Projeyi açın ve gerekli bağımlılıkları yüklemek için `pom.xml` dosyasını kullanarak Maven bağımlılıklarını yükleyin.
3. Proje OpenJDK 22 sürümü ile uyumludur ve çalışması için bu sürümün yüklü olması gerekmektedir.

## Geliştirme Ortamı

- Java
- Selenium WebDriver
- TestNG
- Maven
