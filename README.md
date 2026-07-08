#  Java Spring REST API

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Fruits & Vegetables Rest Api

 ### Başlangıç
 * Var olan spring projeniz içerisine aşağıdaki dependencyleri ekleyiniz. Var olan dependencyleri sakın çıkarmayın.
 * İçerisinde ```Spring Web, Spring Data JPA, Lombok, Postgresql driver``` dependencyler eklenmeli.
 * Maven dependency management sistemini kullanarak tüm dependencyleri install edin.
 * Tüm tablolarınızı fsweb şeması altında oluşturunuz
 * Uygulamanızı  ```8080``` portundan ayağa kaldırın.
 * Meyve ve sebzeler için bir rest Api oluşturacağız.
 
 ### Görev 1
 * ana paketiniz altında ```controller```, ```services```, ```dao```, ```entity```, ```exceptions``` isminde 5 adet daha paket oluşturunuz. .
 * ```entity``` paketinin altına ```Fruit``` ve ```Vegetable``` isimli iki tane sınıf oluşturunuz.
 * ```Fruit``` sınıfı ```id, name, price, FruitType``` isimli 4 fielda sahip olmalı. FruitType enum olmalı(SWEET, SOUR değerlerini alabilir.)
 * ```Vegetable``` sınıfı ```id, name, price, isGrownOnTree``` isimli 4 fielda sahip olmalı.
 * ```Fruit``` ve ```Vegetable``` sınıfları project lombok ve Jpa annotationlarını kullanmalıdır.

### Görev 2
 * dao paketi altına ```FruitRepository``` ve ```VegetableRepository``` interfacelerini oluşturmalısınız.
 * Bu sınıflarda tüm crud işlemleri yapılabilmeli.
 * Bunların dışında hem FruitRepository için hem VegetableRepository için "ücrete göre azalan sırada" tüm fruit ve vegatables sıralayan bir method yazmalısınız.
 * Hem FruitRepository için hem VegetableRepository için "ücrete göre artan sırada" tüm fruit ve vegatables sıralayan bir method yazmalısınız.
 * Hem FruitRepository için hem VegetableRepository yollanan bir parametre name içerisinde geçiyorsa geçtiği tüm kayıtları dönen bir metod yazmalısınız.

### Görev 3
 * service paketi altına ```FruitService``` ve ```FruitServiceImpl``` sınıflarını oluşturmalısınız.
 * service paketi altına ```VegetableService``` ve ```VegetableServiceImpl``` sınıflarını oluşturmalısınız.
 * Dao sınıfları ile arasında  ```Dependency Injection``` ilişkisini kurmalısınız.
 * Tüm dao methodları Override edilmeli.

 ### Görev 3
 * ```FruitController``` ve ```VegetableController``` isimli 2 tane controller yazmalısınız.
 * Amacımız CRUD işlemlerini tanımlayan endpointler yazmak. 
 * [GET]/workintech/fruits => tüm fruits kayıtlarını price göre artan sırada dönmeli.
 * [GET]/workintech/fruits/{id} => İlgili id deki fruit objesini dönmeli.
 * [GET]/workintech/fruits/desc => tüm fruit kayıtlarını price göre azalan sırada dönmeli.
 * [POST]/workintech/fruits => Bir adet fruit objesini id değerine göre ya veri tabanına ekler. Ya da var olan değeri update eder.
 * [POST]/workintech/fruits/{name} => Bir adet name değişkeni alır ve fruit tablosu içerisinde geçen tüm fruitleri döner
 * [DELETE]/workintech/fruits/{id} => İlgili id değerindeki fruit objesini listeden siler.
 * ```VegetableController``` 
* [GET]/workintech/vegetables => tüm vegetables kayıtlarını price göre artan sırada dönmeli.
* [GET]/workintech/vegetables/{id} => İlgili id deki vegetable objesini dönmeli.
* [GET]/workintech/vegetables/desc => tüm vegetables kayıtlarını price göre azalan sırada dönmeli.
* [POST]/workintech/vegetables => Bir adet vegetables objesini id değerine göre ya veri tabanına ekler. Ya da var olan değeri update eder.
* [POST]/workintech/vegetables/{name} => Bir adet name değişkeni alır ve vegetable tablosu içerisinde geçen tüm vegetable değerlerini döner
* [DELETE]/workintech/vegetables/{id} => İlgili id değerindeki vegetable objesini listeden siler.

 ### Görev 3
 * PathVarible olarak id değeri 0'dan küçük yollanırsa api hata döndürmelidir.
 * PathVarible olarak id değeri veritabanında yoksa api hata döndürmelidir.
 * Insert/Update işlemlerinde eksik data yollanırsa api hata döndürmelidir.
 * Bunların dışında beklenmeyen bir hata olduğunda tüm hataları handle edebilecek global bir hata yakalama sistemi de olmalı.
 * Error Handling Global bir merkezden yönetilmeli. Controller sınıflarının altında olmamalı.
 * ```@Slf4j``` hata olduğunda servera log düşürülmelidir.
 * Bu kontrolleri yapan sınıflar ```exceptions``` ve ```validations``` paketleri altına eklenebilir.

### Görev 4
 * Bir tane apinizin dönüş değerinde işlem başarılıysa hem objenin kendisini hem de işlemin başarılı olduğuna dair bir mesaj ekleyiniz.



### ⚠️ Skorun NextGen'e Kaydedilmediyse

Eğer testleri çalıştırdığın halde skorun NextGen'e kaydedilmediyse, önce fork'unun güncel olup olmadığını kontrol et:

1. GitHub reponu aç.
2. Repo **X commit ahead** ve **X commits behind** şeklinde bir uyarı gösteriyorsa, branch'in güncel değildir.
3. **Sync fork → Update branch** adımlarını uygula.
4. Ardından localinde şu komutu çalıştır:

```bash
   git pull
```

5. Testleri tekrar çalıştır. Bu adımdan sonra skorun güncellenmiş olacaktır.

> **Not:** Bu kontrolü yapmadan tekrar tekrar test çalıştırmak sorunu çözmez; sorunun kaynağı genellikle fork'un upstream repository ile senkron olmamasıdır. 
