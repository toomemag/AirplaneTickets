Tere, mina olen Erki ja
siin on minu CGI suvepraktika proovitöö 2025:

<h2>Kuidas minu programmi käivitada:</h2>

Kuna ma ise kasutasin programmi kirjutamiseks "Intellij IDEA ultimate edition" programmi siis näitan ka kuidas seda käima saada.
Esmalt tuleks gitist laadida programmi kaust alla. Seejärel laadida alla andmebaas 
<br>
<br>
Kuna kasutan andmebaasiks postgres andmebaasi, tuleks lisaks ka installeerida PostgreSQL endile. Installerid saab [siit](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) ja tuleks võtta versioon 17.4. 
Kui avada installer, installeris tekib võimalus valida mida installida, sealt valida kõik peale StackBuilderi: <br>![screenshot](images/components.png)<br> Järgmisena jätta valitud kaust, peale seda tuleb panna PostgreSQL superUser(kasutaja millega saab kõigele ligi) parool, parool peab olema selline mis jääb meelde(hiljem läheb vaja), peale seda küsib porti mida server kuulama hakkab(tavaliselt kas 5432 või 5433), see jääb nii nagu on, see port number võiks meelde jätta. Järgmisena jätta [Default Locale] ja alustada installeerimist.
Peale installimise lõpetamist avada programm "pgAdmin4", kus avaneb ekraan:![pgAdmin4](/images/pgadmin4.png)
<br> Peale seda avaneb ekraan, kus tuleb sisestada parool mille salvestasid varem SuperUserile. Kui sisestad parooli saab ligi Database serverile. nüüd kui vajutada paremat klikki Databases ![databases](/images/databaas.png) 
seal "Create" -> "Database...". Avanenud aknas tuleb anda Database lüngale nimi "lennuddb" ![databaseCreate](/images/databaasloomine.png)<br> ja vajutada nuppu "save", see võib visata mingitsorti errori, sellepeale vajutame "close". Peale seda vajutame uuesti paremat klikki Databases peale ja vajutame refresh. Peale seda võib panna programmi "pgAdmin 4" kinni.

<h2>Intellij IDEA</h2>
Nüüd kui andmebaas üles seatud, avame projekti kausta Intellij projektina. Kaust avatud tuleb veenduda, et oleks kõige uuem Intellij versioon ja project structure oleks selline: ![ProjektStructure](/images/struktuur.png)
<br>
Nüüd kui struktuur on laetud, tuleb muuta "application.properties" ![properties](/images/properties.png) väärtusi, fail asub "/src/main/resources/" kaustas. Selles failis tuleb muuta väärtusi.
<br><h4>Failisisu:</h4>![PortPassword](/images/paroolProt.png)
<br>
<h3>Väärtused mida muuta tuleb on rohelise kastikesega tähistatud:</h3>
spring.datasource.url=jdbc:postgresql://localhost:<strong>{Sinu PORT}</strong>/lennuddb<br>
ja<br>
spring.datasource.password=<strong>{Sinu parool}</strong>
<br>

Nüüd kui see on tehtud, avada kaust "/src/main/java/org.example.airplanetickets/" ja avada klass "AirplaneTicketsApplication". <br>![AirplaneTicketsApp](/images/application.png)
<br> Klass avatud, tuleb vajutada: ![jooksuta](/images/jooksuta.png)<br>
Peale jooksutamist minna [siia](http://localhost:8080/lennud), ja voila, oledki minu programmis.
<br>
Programmis on võimalik filtreerida lende erinevate filtrite põhjal, ja kõik lennud on klikitavad.
<br>![lennuuuud](/images/lennnnnuud.png)
Peale lennule klikkimist, on võimalik valitud lennu istumisgraafikut näha, ja valida kohta vastavalt filtreeringutele(kas on rohkema jalaruumiga, on väljapääsu lähedal või on aknaall), pilteteid saab veel vaadata ka kahele inimesele. ![leend](/images/lend.png)<br>

<h5>See oli minu programm, tänan vaatamast.</h5>

<h5>Erki Toomemägi</h5>
