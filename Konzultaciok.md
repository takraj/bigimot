# Tartalomjegyzék #



# -1. Konzultáció (2010.02.01., hely: msn) #

Jelenlévők: Boros, Rapp, Molnár, Takács

  * Kijelöltük a csapatkapitányt: **Boros**
  * Cspatnevet választottunk: **Bigimot**
  * Alapvető adminisztratív dolgok...

# 0. Konzultáció (2010.02.08., hely: IB026) #

LZ. tartotta, eligazítás volt a tárggyal kapcsolatban.

  * RUP-ban kell elkészíteni a projektet.
  * Először csak egy karakteres felületű program legyen, kifejezetten tesztelési célokra.
  * A későbbi grafikus felületre ne pazaroljunk túl sok időt. Elegendő, ha csak működik valahogy.
  * Idén könyebb dolgunk lesz, mert már kész vannak a dokumentációhoz a templatek.
  * Holnap délutánig kikerül a pontos feladatspecifikáció.
  * A specifikációt kis mértékben megváltoztatják a szkeleton elkészülését követően.
  * A hallgatók 90%-a sikeresen teljesíti a tárgyat, nagyrészük 5-össel.
  * Ha valaki kiesik a munkából azonnal szólni kell, illetve bele kell írni a jegyzőkönyvbe.
  * A félév során 3 demó lesz, ilyenkor minden csapat egy másik csapat programját teszteli.
  * A programnak alap JAVAC -al fordulnia kell. Érdemes beadás előtt kipróbálni a HSZK-ban.
  * A projekt hardver-, és szoftverkövetelménye fixen a HSZK-s gépekkel egyeznek meg. Ezt dokumentálni kell az elején.
  * Minden dokumentációt frissen kell tartani. Tehát, amennyiben egy hibát kijavítunk, és ezért vissza kell nyúlni egy korábban beadott dokumentumhoz, úgy a módosítást elvégezzük, de nem adjuk be az új változatot csak a legvégén. Mindenesetre írjunk a módosításról egy rövid jegyzőkönyvet.
  * A project eleje lesz inkább a nehezebb, hogy ne ütközzön más tárgyak teendőivel.
  * A konzultációkon értékelik az előzőleg beadott feladatokat és tippeket adnak a következőre, szóval érdemes megjelenni.



LZ. adott egy példát, hogy milyen változtatásra lehet számítani:
  * Pl. adott egy program ami négyzetes mátrixokkal számol. Változtatás: négyzetes helyett legyen méhsejt alakú.
  * Nem kell nagy változtatásra számítani, főleg egy jól megtervezett modell esetén.

# 1. Konzultáció (2010.02.15., hely: R.4M) #

  * Konzulensek elérhetőségeit ismertették.
  * Csütörtökön van az anyagleadás, 11:45 - 12:15
  * Megegyeztünk, hogy minden anyag legyen kész csütörtök reggel 09:00-re.
  * Konzultáción mindig értékelni fogják az előző heti munkánkat.
  * Ha nem sikerül a megadott időben leadni a heti anyagot, akkor mindenképp e-mailezzünk a **konzulensnek**.
  * _A konzulensek elérhetőségeit beírtam az [Elerhetosegek](Elerhetosegek.md) lapba._

## RUP, milestones ##

  1. modell
  1. szkeleton
  1. proto
  1. grafikus

### I. Modell ###

  * A legfontosabb mérföldkő.
  * A feladat **szövegéből** kell készíteni egy **UML** modellt.
    1. osztálydiagram
    1. belső működés: hívások, szekvencia diagramm, state chartok, stb...

### II. Szkeleton ###

  * Ez egy konzolos JAVA alkalmazás
  * Kérdés - Válasz struktúra, jól tesztelhető, hogy mi mit reagál egy bizonyos bemenetre.
  * Tulajdonképp elkészítjük a program vázát, de a metódusok törzsét nem írjuk meg, csak amennyire feltétlenül szükséges.
  * Célszerű megoldás, hogy ezek a metódusok egymást hívogatják.

### III. Proto ###

  * Függvénytörzsek megírása.
  * Teljes játék összeáll, de még csak konzolos felülete van.
  * Alkalmas a tesztfuttatásra.

### IV. Grafikus felület ###

  * Csak annyira amennyire szükséges.
  * Nem a csicsa fogja az értékelés alapját adni, hanem a mögötte lévő modell.

## A laborban lévő JAVA verzió ##

  * A laborban **1.6.0\_14**-es JAVA runtime van.
  * Ellenőrzés: ` java -version `
  * Kizárólag erre fejleszthetünk, addonok használata nem megengedett.

## Segítség a dokumentációhoz ##

  * Már megvannak a doksi vázak, mindössze be kell írni amit kér.

### 2.3 Feladatleírás ###

  * Nem átfogalmazás.
  * Ki irányítja? Ki mozog magától?
  * **Tipp:** Játékos irányítja a rablót/rendőrt, de esetleg lehet 2-player-mode is benne.
  * Az utak egysávosak/kétsávosak?
  * Milyenek a kanyarok?
  * **Tipp:** Csináljuk 90°-osra, de számítsunk olyan módosításra, hogy bármilyen fokosak lehetnek esetleg.
  * Táblákat mi találjuk ki.
  * **Tipp:** Legyen STOP és JELZŐLÁMPA, de ne legyen pl. ELSŐBBSÉGADÁS KÖTELEZŐ.

### 2.5 Use Case ###

  * Legyen egyszerű, fölösleges túlbonyolítani.
  * Kilépés is szerepeljen rajta.
  * Csak olyat tüntessünk fel rajta, amit a felhasználó képes a mi "fekete doboz"-unkkal csinálni. Tehát csak az ő interakciói szerepeljenek rajta.

## Mi lesz a következő héten? ##

  * Osztályok meghatározása a mostani doksi alapján.
  * NE LEGYEN ISTEN OBJEKTUM!!!!!
  * Legyen az egész játék amolyan Pac-Man jellegű.
  * Minél jobban általánosítsunk, használjunk interface-eket.

# 2. Konzultáció (2010.02.22., hely: R.4M) #

  * Autók nem ismerhetik a többi autót.
  * Ne legyen isten objektumunk.
  * 3.1: Mi mire való?
  * 3.2: Az attribútum az objektum állapotát írja le.
  * 3.3: Class Diagram
  * 3.4: Szekvencia Diagram, amiből majd kód lesz. Class Diagramal konzisztens legyen. Legyen belőle inicializálás is, ami nem csak függvények végighívása, meg create. Tehát követhető legyen az alapján, hogy mi zajlik le, mikor elkészül a pálya pl.
  * 3.5: State Chart, pl. rendőr.
  * Mindenképp egyszálú legyen a program, tehát nincs aszinkron hívás.
  * Márc 22-én szkeleton teszt, úgy készüljünk. Mindenkinek kötelező a megjelenés!!
  * Doksinál nagyon kell figyelni a külalakra! Legyen sorkizárt, és helyesírás szempontjából kifogástalan. Használjunk elválasztásokat!

## Megjegyzések a mi munkánkkal kapcsolatban ##

  * Tulajdonképp nem volt sok baj vele, néhol rosszul volt megfogalmazva a dolog.
  * Ajánlották, hogy ne bonyolódjunk bele a többsávos utakba, és ne "gondolkodjon" a rendőr. Elég, ha csak mászkál, és ha nekimegyünk akkor Game Over.
  * Előzést úgy kéne megoldani, hogy egyszerűen átugorják egymást a kocsik.
  * Lényeg, hogy kicsit túlspecifikáltuk, lazítsunk rajta, mert az a tapasztalat, hogy egy ilyen projektet nem tudnak a csapatok időre befejezni.


# 3. Konzultáció (2010.03.01., hely: R.4M) #

  * Szkeleton: Írja ki a képernyőre, h milyen függvényhívások zajlanak le.
  * Minimálisan szükséges objektumokat példányosítsunk csak.
  * NINCS játéklogika!!
  * Kérje be a tesztelőtől, h merre menjen kereszteződésben a tetszőleges autó.
  * 5.1-ben pl. milyen szituációt szeretne látni a felhasználó?
  * 5.2: nem kell túl sokat írni, nem is nagyon tudnánk.
  * 5.3: tkp. "Ezt fogja látni a felhasználó...", tételesen írjuk le. Mindenről legyen use-case is!
  * 5.4: Ugyanaz kb., mint a 3. és a 4. doksinál.
  * Ha valamit módosítunk a modellen, akkor adjuk be Appendixként.

## Megjegyzések a mi munkánkkal kapcsolatban ##

  * Class Diagramot át kell alakítani.
  * Szekvenciadiagramot kicsit pontosítani.
  * A leírások néhol ellentmondanak, illetve hiányosak.
  * Dolgozzunk jobban össze.
  * State-Chart és init szekvenciadiagram rendben van.
  * Bármi gond van, nyugodtan írjunk e-mailt.
  * 8 pont a 20-ból.

# 4. Konzultáció (2010.03.08., hely: R.4M) #

  * Március 15-én szünet lesz, de csütörtökre le kell adni ettől függetlenül a feladatot.
  * Március 22-én közös **szkeleton** teszt lesz, **MINDEN CSAPATTAG JELENJEN MEG!!**

## 5. beadandó infói ##

  * Architektúra részben le kell írni, hogy:
    * A program 1 szálon fut, nem foglalkozunk szálkezeléssel.
    * Csinálni kell egy osztályt a felhasználói I/O-hoz, amit nagyjából le kell itt dokumentálni. Ezt a későbbiek folyamán nem használjuk fel.
  * Még nem foglalkozunk az MVC elvekkel.
  * A szkeletonban nincs logika, mindent a felhasználó irányít. Pl. elágazásnál megkérdezi. Ezeket use-case-en ábrázolni kell.
  * Sok extra use-case lesz, minden interakciós lehetőségről.
  * Amiről van szekvencia diagram, az feltétlen játszódjon le a szkeletonban.
  * Célszerű letölteni egy már kész szkeletont, és áttanulmányozni.

## 6. beadandó infói ##

  * A kódot fel kell tölteni, a doksit ki kell nyomtatni.
  * Határidő ugyanaz mindkettőre.
  * Kritériumok:
    * Egyetlen szabványos **ZIP** fájl legyen.
    * Összesen 3x kísérelhetjük meg a feltöltést, utána a rendszer blokkol.
    * **_KELL_** csinálni JavaDOC-ot, amit csatolunk a program mellé.
      * Ez egy generált dokumentum.
      * A Netbeans és az Eclipse tudja alapból.
      * Szabványos kommentezésből készül.
      * A legtöbb fejlesztőkörnyezet ad hozzá némi támogatást.
    * Csak a forráskódot (`*.java`) szabad feltölteni, `*.class` fájlokat nem!
    * Nem tölthetjük fel az egész projektmappát, úgyis konzolról fordítunk.
  * Ha nem fordul le a HSZK-ban valamiért a program, akkor már nincs lehetőség a projekt folytatására, megbuktunk. Mindenképp célszerű kipróbálni teszt előtt itt is.

### 6.1 ###

  * Hogyan fordítjuk, hogyan indítjuk?
  * Nagyon részletesen kell!
  * Mindenképp konzolos fordítás!
  * Csinálhatunk batch fájlt, amit mellékelünk feltöltéskor. Külön fordításra, külön futtatásra.
  * Alapból a HSZK gépein nincsenek beállítva a környezeti változók, erről nekünk kell gondoskodnunk. (`PATH=...`)
  * **HSZK**-ban a javac.exe és a java.exe elérési útja:
    * `D:\Program Files\Java\jdk1.6.0_14\bin`

### 6.1.1 ###

Tételesen a feltöltött fájlok, de a javadoc-ot nem kell felsorolni, csak a zip-et, amiben megtalálható.

### 6.2 ###

  * Értékelés, hogy eddig hogy sikerült a csapatnak összerázódnia, együttműködnie.
  * Hogy sikerült a munkamegosztás? Táblázatba beírni %-ban is!
    * A táblázatból hiányzik az aláírás mező, de ettől még **ALÁ KELL ÍRNI MINDENKINEK!**
  * Ha voltak konfliktusok, akkor azokat is le kell írni.

## Megjegyzések a mi munkánkkal kapcsolatban ##

  * Class Diagram-ban volt egy elvi hiba: nem szabad **változóval** eldönteni, hogy ki micsoda. Függvényt kell írni, és azt felüldefiniálni. Ez az épületek résznél volt.
  * Szekvencia Diagramokból nem derült ki, hogy mi történik kiértékeléskor.
  * 18 pont a 30-ból.

# 5. Konzultáció (2010.03.22., hely: R.4M) #

  * Modell - Szkeleton - **Protó** - Grafikus

## 7-es beadandó ##

### Protó infói ###

  * A szkeleton kódját kell kibővíteni a program logikájával.
  * Úgy kell megcsinálni, hogy a grafikus felület elkészítésénél már ehhez a kódhoz nem nyúlhatunk. Mindössze kap egy új osztályt, ami grafikusan jeleníti meg a cuccot.
  * Nem kell törekedni a jó olvashatóságra, nem fog a programmal senki se játszani. Külön fájlból kell beolvasni, hogy mit csináljon a program. Szal egy szkriptnyelvet kell kitalálni lényegében.
  * Lehessen a program aktuális állapotáról mentést készíteni, illetve azt be lehessen tölteni.
  * A program elsődleges kimenete és bemenete fájl legyen.
  * Írnunk kell tesztelést segítő programokat, amiket most szükséges specifikálni. Ilyen program lehet pl. egy szöveg összehasonlító. (Általában ez elég is.)
  * **Bemeneti nyelv:** Milyen utasításokat tud értelmezni a program? Nem elég konkrét példán illusztrálni, tökéletes specifikáció kell. Ha kell, használjunk reguláris kifejezéseket.
  * A tesztre olyan verziót célszerű vinni, ami nem véletlenszerű alapon működik. De vigyük el azt is ami véletlenszerű, hiszen érdekességképp azt is kitesztelhetjük. Nameg, ugye nem nyúlhatunk bele a kód ezen részébe utána. :)
  * A program továbbra is egyszálú kell legyen.

### Use-Case ###

  * A felhasználónak milyen lehetőségei vannak a vezérlésre? CSAK EZ!!
  * Beleértendőek a parancssori paraméterek is, ha vannak.

### Tesztelési terv ###

  * Milyen teszt esetek vannak? Az összes lehetségest fel kell sorolni!

### Programok ###

  * Csak specifikáció kell.
  * Pl.: Kimenetet és várt eredményt összehasonlító szövegfeldolgozó program.

## 8-as beadandó ##

### 8.1: Osztályok és metódusok ###

  * Ahol vannak nem triviális algoritmusok, ott kell folyamatábra is. Idegen szóval: activity diagram. :)

### 8.2: Fájlok előállítása ###

  * Szoftver-konfig
  * Teszt-konfig
    * Pl. milyen szoftver-konfigot töltsön be? Mennyit lépjen? Mentsen-e?
  * Várt eredmény

### 8.3: Tesztprogramok részletes tervei ###

  * Van egy új doksi felrakva ide: http://users.hszk.bme.hu/~nm770
  * Részletesen leírni a tesztprogramok működését.
  * Az új mintadoksit felraktam SVN-re is a könnyebb elérhetőség végett.

## Változás a specifikációban ##

  * Felkerült a tárgy honlapjára egy módosítás, miszerint legyen a játékban húsvéti nyuszi, amitől a rabló immunis lesz, ha elüti. (A rendőr nem kaphatja el addig.)

## A szkeleton teszt ##

  * Semmi konkrétumot nem mondtak a mi munkánkról, de annyit megállapítottak, hogy nem sok köze van a doksihoz. :)
  * A pontokkal majd jövőhéten számolnak el.

# 6. Konzultáció (2010.03.29., hely: R.4M) #

  * Április 5-én szünet lesz, viszont Április 19-én ismét mindenkinek kötelező a megjelenés!
  * Rajmundon kívül senki nem jött el a konzultációra!!!!

## Általános probléma ##

  * Túlságosan összevontuk a lehetséges teszteseteket. Mindenképp bontsuk szét a lehető legelemibb részekre. Pl. ne csak sima ütközésvizsgálat legyen, hanem legyen külön "rendőr vs rabló", "rabló vs civil", stb...
  * Minden egyes részfunkciót önmagában kell tesztelni, és szépen a legalapvetőbbtől haladni a legösszetettebbekig.

## Megváltozott a specifikáció ##

  * JELEZNI KELL A 8-as DOKSIBAN!!!!!! Csinálni kell egy 8.4-es alfejezetet neki.
  * Milyen változtatásokra volt szükség az analízis modellben?

## 8-as beadandó ##

  * **8.1:** Prototípus osztályai, metódusai. Ha kell activity diagram (folyamatábra) készítése. Úgy csináljuk meg, hogy ezen már nem nagyon szabad módosítani.
  * **8.2:** Teszteseteket bőven kifejteni!
    * Szoftver konfig pl. pályabetöltő szkript.
    * Teszt konfig pl. a pálya, amit betölt.
  * **8.3:** Nem jó az excel, totalcommander, stb... használata! Még a C# sem! Java kell!
  * **8.4:** Mi változott?
  * Kivételesen küldjük el a konzulensnek a munkánkat e-mailben is, mert nem lesz konzi hétfőn a húsvét miatt.

## 10-es beadandó ##

  * El kell végezni otthon is a teszteket, naplózni a hibákat, majd kijavítani.
  * Csatolni kell az összehasonlító programot.
  * A protó 2x annyi meló, mint a szkeleton. Viszont remekül szétdobálható pl. a teszt része.

## Probléma velünk ##

  * Nem buktunk meg.
  * Hol voltatok? Miért voltam egyedül? - `TakRaj` -

  * **5: 20/14**
    * Use-case túl sok, elég lett volna csak a játékos.
    * Kevés teszteset.
    * A dialógusok nincsenek fixen felsorolva. Minden lehetséges kimenetet le kellett volna írnunk.
    * Amúgy a többi korrekt.

  * **6: 20/15, szkeleton: 100/64**
    * A program jó, de jópár eltérés van a specifikáltakhoz képest.
    * Próbáljuk ellensúlyozni ezt a %-os megoszlást. 4-en vagyunk, senkinek se menjen 30% fölé a munkarésze, mert akkor a végén előfordulhat, hogy 3-man kaphatunk jegyet, és valaki kibukik, hiába dolgozott.

  * **7: 30/25**
    * Ezekre a parancsokra nincs szükség: win, loose, bunny, rob, money, health, speed
    * A kimeneti nyelvet sokkal általánosabban kell specifikálni. Nem elég a példa. Az lényeg, hogy a leírás alapján tudjon a konzulens kreálni egy lehetséges kimenetet.
    * Bontsuk szét sokkal elemibbre a use-case-eket, mert ez így túl komplex.
    * EXCEL????? - labvez majdnem hanyattvágta magát, mikor meglátta :D -

# 7. Konzultáció (2010.04.12., hely: R.4M) #

  * **Következő alkalommal PROTÓ TESZT! MINDENKINEK KÖTELEZŐ MEGJELENNI!**

## Az eheti beadandóhoz megjegyzések ##

  * Alá kell most is írni...
  * Legyen benne hiba, hogy tudjunk mit írni a teszteléshez mikor mi teszteljük.
  * Ha minden flottul lefut elsőre, akkor az pontlevonás, mert ilyen program nincs. :)

## 11.1 Grafikus Interfész ##

  * Paint vagy Visio -val screenshot jellegű képek legyártása.
  * Hogy fog kinézni?
  * Meg kell mindent tételesen rajzolni.

## 11.2 Architektúra ##

  * Kell osztálydiagramot is rajzolni a grafikus részekről.
  * A régiből csak azokat az osztályokat tüntessük fel, melyek kapcsolódnak a grafikus felülethez.

## 11.3 ##

  * **A PROTÓBAN ELKÉSZÍTETT KÓDHOZ NE NYÚLJUNK HOZZÁ!!!!**
  * Legyen többszálú. A grafikus felület külön szálon fusson.
  * Kell dupla pufferelés.
  * Minél egyszerűbb, gagyibb legyen a megjelenítés.
  * Elég, ha csak különböző nagyságú és színű négyzeteket rajzolunk ki.

## 11.4 ##

  * Szekvencia diagram kell a grafikus felület frissítéséről, újrarajzolásáról.

## Mit alkottunk mi? ##

  * Kellett volna minden metódushoz Activity Diagram.
  * Kell teszteset az útkereszteződésre, lámpákra, illetve a kocsik pálya szélén való eltüntetésére is.
  * A metódusok egy jó része nagyon nincs kifejtve. Sokkal részletesebben kell leírni, hogy mi mit csinál, mire való, hogyan használjuk.
  * **Pontszám: 21/30**

# 8. Konzultáció (2010.04.19., hely: R.4M) #

## Ajándék pontok ##

Ha az utolsó leadandót (összefoglalás) időben leadjuk akkor ajándékba kapunk 30 pontot. Megéri...

## Két hét múlva ##

Lesz megint két hét kifejleszteni a grafikus verziót. A teszt ezúttal kevésbé lesz kötött, inkább játszani fogunk a programokkal. Ettől függetlenül gyertek el.

## Protó teszt ##

Úgy tűnik most nem voltak túl nagy fennakadások a protó tesztelése kapcsán, mindössze a Comparator nevű programom (Rajmund) sikerült túl szigorúra. A whitespace karaktereket nem kezelte elég rugalmasan. A késést leszámítva nem volt gond semmiből.

# 9. Konzultáció (2010.04.26., hely: R.4M) #

## Általános infók ##

  * Jövőhét csütörtökre grafikus leadása.
  * Utolsó hétre egy összefoglaló kell, ami ajándék 30 pont, de nem kötelező.
  * Konzultáció már nem lesz.
  * Nem is fogjuk tesztelni a grafikust, mindössze jegyosztás lesz, nem kötelező megjelenni.
  * Reklamációra nincs lehetőség.

## Probélma velünk ##

  * Két exception nem volt lekezelve, ami elég gyakran előjött.
    * FileNotFound: Amikor pl. nagybetűvel adom meg a fájlnevet.
    * BadNumericConversion: Amikor egy space rossz helyen van.
    * Trim() függvény megoldaná a problémát.
    * A comparátorból is hiányzott a trim(), de ettől eltekintve jól működött.
  * Nem értük el a 40%-ot a protó részből.
    * Rettenetes a kód, inkonzisztens a dokumentációval, illetve kezelhetetlen.
    * Nincs megfelelően ledokumentálva, látszik, hogy összecsapott munka.
    * Késtünk 3 napot, ez még 30%-ot elvett a megszerzett pontjainkból.
    * 10 pont.

Megj.: a grafikus specifikációval nem volt különösebb baj, de az egyik szekvencia diagramon fordítva voltak a nyilak. Ezért csak 24 pont a 30-ból.

## Amit tehetünk még ##

Ha a grafikus verziót időre elkészítjük, nem késünk vele, akkor átenged a konzulens, viszont ha nem oké a dolog, akkor hétvégéig küldeni kell neki egy e-mailt, és felbomlasztja a csapatot. Ez nagyjából azt jelenti, hogy berak mindenkit más csapatba, és elszámolunk a munkaórákkal.

Elmondtam neki (Rajmund), hogy mennyire szervezetlenek vagyunk, és hogy mennyire nem működik a belső kommunikáció. Nem örült a dolognak, de mivel már ez az utolsó beadandó, nincs értelme összehívni mindenkit, és így a végére újraszervezni a csapatokat. Ennek ellenére - a konzulens kérésére - le lesz ez a dolog is dokumentálva, viszont ez a jegyet nem befolyásolja.

Sajnálom, hogy így alakult, szerettem volna, ha jól együtt tudunk működni, és mindenki 5-öst kap. Nem rajtam múlt... (Rajmund)