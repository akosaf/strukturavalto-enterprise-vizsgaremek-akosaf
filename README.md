# strukturavalto-enterprise-vizsgaremek-akosaf

###Az aktuális verzió a Development branch-en található! (v1.9.9)  

##Leírás
####Az alkalmazás beszállítók, beérkező szállítmányok, valamint az érkezett termékek kategóriákba rendezett rendszerezésére alkalmas.  
####Minden tábla tartalmához saját controller biztosít hozzáférést, a tárolt adatok kilistázhatók, id alapján lekérdezhetők, szerkeszthetők, törölhetők  
####Külön prezentációs réteg biztosít lehetőséget leltártöbblet, valamint leltárhiány rögzítésére.  

##Indítás:
Az alábbi fájlok futtatásával az adott sorrendben:
1. run_mvn-clean.bat
2. run_build.bat
3. run_compose.bat  
   (A helyes működéshez futtatás előtt meg kell várni, amíg az előző parancs végig lefut.)

##API végpontok:
http://localhost:8000/swagger-ui.html

##Tesztelés postmannel:
api-docs.yaml postmanbe való importálásával.

## Adatbázis:  
![image](https://user-images.githubusercontent.com/63594935/177060032-aae4aba2-2273-4bce-b444-a85a151f5781.png)

##Készültség:

###Követelmények:

☑Maven vagy Gradle projekt  
☑Spring Boot alkalmazás  
☑SQL backend (pl. MySQL, MariaDB, etc...)  
☑Flyway sémamigráció, SQL táblalétrehozás, adatbetöltés  
☑REST API, Swagger, OpenAPI dokumentációval  
☑Hibakezelés  
☑Spring Data JPA repository  
☑Integrációs tesztek

###Feladat nagysága:

☑Legalább két 1-n kapcsolatban lévő tábla  
☑Legalább két SQL migráció  
☑Legalább két entitás  
☑Legalább két service  
☑Legalább két controller  
☑Minden bemenő paraméter validálása  
☑Legalább egy property beolvasása  
☑Minden HTTP metódusra legalább egy végpont (GET, POST, PUT, DELETE)  
☐Legalább 60%-os tesztlefedettség, amely tartalmaz egység és integrációs teszteket is  
☑Egy Dockerfile  
☑Feladat dokumentáció(README), futtatási parancsok  
