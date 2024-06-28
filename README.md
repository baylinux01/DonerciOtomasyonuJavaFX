# DonerciOtomasyonuJavaFX
Java FX ile Döner Satan bir işletmede kullanılabilecek program

Repo indirildikten sonra program,
bilgisayarınızda Amazon Corretto JDK 21 ve sqlite yüklü ise 
içerisindeki jar dosyasına tıklanarak çalıştırılabilir.
Program çalıştırıldığında kendi database'ini kendisi oluşturur.
Ancak programı çalıştırırken jar dosyasını masaüstünde çevresi 
çepeçevre bomboş olan bir alana koymaya özen gösterin.
çünkü kendi database'ini aynı dizinde kendisi oluşturduğu için bazen database'i
oluşturmak istediği yer masaüstündeki diğer objelerle çakışabiliyor ve dolayısıyla
database'i oluşturamayabiliyor. Bu durumda yapılan işlemlere otomatikmen olumsuz
cevap verebiliyor. Bu durumdan sakınmak için jar dosyasını mutlaka masaüstünde çevresi bomboş bir yere koyun o şekilde çalıştırın.
Windows işletim sistemli bilgisayarlar için ikinci bir seçenek olarak exe uzantılı installer da eklenmiştir.installer'a tıklayıp next'leyerek program windows bilgisayara yüklenebilir.
Ayrıca bilgisayarınızda Amazon Corretto JDK 21 ve sqlite'ın ikisi birden yüklü değil ise program düzgün çalışmayacaktır. Ben sadece Amazon Corretto JDK 21 ile denedim diğer JDK veya versiyonlar ile muhtemelen yine çalışır ama belki şekillerde kaymalar olabilir.
Program aslen linux bilgisayarlar için tasarlanmış olduğundan
windows bilgisayarlarda yazılarda kayma gibi ufak uyumsuzluklar olabilir.
Programın tek eksiği print özelliğinin olmamasıdır. Print özelliğinin olmamasının nedeni
programı yazdığım sırada elimde yazıcı olmadığı için deneme olanağım olmamasıdır.
