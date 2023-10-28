package com.oopbank;


/*
* NYP ihtiyaç duyulan programı küçük parçalara ayırarak, yönetilebilir ve yeniden kullanılabilir program geliştirme yöntemidir.
* her küçük parçanın kendine ait nitelikleri ve iletişim yöntemi kendine özeldir.
*
* Kod yazarken, gerçek hayat problemlerini bilgisayarın anlayacağı şekilde modellere çeviriyoruz bu modellere nesne deniyor.
*
* Nesne(Object) nedir?
*
* Belli bir ağırlığı ve hacmi, rengi olan her türlü cansız varlık, şey, obje.
*
* örneğin araba, uçak, kitap, kalem, kolye, ...
*
* Sınıf(Class) nedir
*
* Gerçek hayat nesnelerinin yazılımdaki eşdeğeri classlardır
*
*/

/*
* Encapsulation
*
* Sarmalama ilkesi, bir sınıfa ait değişkenlerin veya niteliklerin ancak o sınıfa ait metotlar tarafından değiştirilebilmesi
* ve okunabilmesi ilkesidir.(Getter ve Setter methodlar)
* bu şekilde veriye doğrudan erişim ve düzeltme yapılamaz bu sayede veri bütünlüğü ve güvenliği sağlanır.
*/

/*
* Inheritance
*   Kalıtım, Bir sınıfın başka bir sınıftan nitelik ve davranışlarını kendisine alması demektir.
*   Kalıtımı yapan sınıfal alt sınıf(sub cass), kendisinden kalıtım yapılan sınıfa ata sınıf(super class) dersek,
*   ata sınıfta tanımlı olan her şeyin alt sınıf için de tanımlı olduğunu söyleyebiliriz.
*/

/*
* Polymorphism
*  NYP'de programlama dilinin farklı tip verileri ve sınıfları farklı şekilde işleme yeteneğini belirten özelliğidir.
*  Bu sayede alt sınıf ata sınıfından gelen davranışı kendine göre şekillendirebilir.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}