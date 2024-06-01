# DonerciOtomasyonuJavaFX
Java FX ile Döner Satan bir işletmede kullanılabilecek program

Repo indirildikten sonra program,
bilgisayarınızda java(daha doğrusu jre) ve sqlite yüklü ise 
içerisindeki jar dosyasına tıklanarak çalıştırılabilir.
Program çalıştırıldığında kendi database'ini kendisi oluşturur.
Ancak programı çalıştırırken jar dosyasını masaüstünde çevresi 
çepeçevre bomboş olan bir alana koymaya özen gösterin.
çünkü kendi database'ini aynı dizinde kendisi oluşturduğu için bazen database'i
oluşturmak istediği yer masaüstündeki diğer objelerle çakışabiliyor ve dolayısıyla
database'i oluşturamayabiliyor. Bu durumda yapılan işlemlere otomatikmen olumsuz
cevap verebiliyor. Bu durumdan sakınmak için jar dosyasını mutlaka masaüstünde çevresi bomboş bir yere koyun o şekilde çalıştırın.
Ayrıca bilgisayarınızda java(jre) ve sqlite'ın ikisi birden yüklü değil ise program düzgün çalışmayacaktır.
Programın tek eksiği print özelliğinin olmamasıdır. Print özelliğinin olmamasının nedeni
programı yazdığım sırada elimde yazıcı olmadığı için deneme olanağım olmamasıdır.
