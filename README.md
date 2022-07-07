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

##API végpontok:
###PUT   /{id}/increase?quantity=  
Az id alapján kiválasztott terméket a megadott mennyiséggel (quantity) növeli.  
###PUT   /{id}/decrease?quantity=  
Az id alapján kiválasztott terméket a megadott mennyiséggel (quantity) csökkenti.  
Amennyiben a raktáron nyilvántartott termékek számánál magasabb értéket adunk meg, 406-ot dob.
<br><br>
###GET   /stock/{id}  
Visszaadja az id alapján megadott termék adatait.
###PUT   /stock/{id}  
Módosítja az id alapján megadott termék adatait.
###DELETE   /stock/{id}
Eltávolítja az id alapján megadott terméket.
###GET   /stock  
Visszaadja az összes tárolt termék adatait.
###POST   /stock  
Új terméket ad hozzá.
<br><br>
###GET   /supplier/{id}
Visszaadja az id alapján megadott beszállító adatait.
###PUT   /supplier/{id}
Módosítja az id alapján megadott beszállító adatait.
###DELETE   /supplier/{id}
Eltávolítja az id alapján megadott beszállítót.
###GET   /supplier
Visszaadja az összes tárolt termék beszállító.
###POST  /supplier
Új beszállítót ad hozzá.
<br><br>
###GET   /shipment/{id}
Visszaadja az id alapján megadott szállítmány adatait.
###PUT   /shipment/{id}
Módosítja az id alapján megadott szállítmány adatait.
###DELETE   /shipment/{id}
Eltávolítja az id alapján megadott szállítmányt.
###GET   /shipment
Visszaadja az összes tárolt szállítmány adatait.
###POST  /shipment
Új szállítmányt ad hozzá.
<br><br>
###GET   /category/{id}
Visszaadja az id alapján megadott termékkategória adatait.
###PUT   /category/{id}
Módosítja az id alapján megadott termékkategória adatait.
###DELETE   /category/{id}
Eltávolítja az id alapján megadott termékkategóriát.
###GET   /category
Visszaadja az összes tárolt termékkategória adatait.
###POST  /category
Új termékkategóriát ad hozzá.  

##Táblák:
###Stock:
A termékek tárolására alkalmas tábla.
####id:
A termék azonosítója.
####name:
A termék neve.
####description:
A termék leírása.
####expiration:
A termék lejárati ideje.
####price:
A termék egységára.
####quantity:
A termék raktári nyilvántartásban szereplő mennyisége.
####countryOfOrigin:
A termék származási országa.
####category:
A termék kategóriája.
####shipment:
A szállítmány, azon belül pedig a beszállító adatai.
<br><br>
###Supplier:
A beszállítók adatait tárolja.
####id:
A beszállító azonosítója.
####name:
A beszállító neve.
####country:
A beszállító országa.
####registrationDate:
A beszállítónál való regisztráció dátuma.
####discount:
A beszállító által nyújtott viszonteladói kedvezmény mértéke százalékban.
<br><br>
###Shipment:
A szállítmányok adatait tárolja.
####id:
A szállítmány azonosítója.
####shipmentDate:
A szállítmány beérkezési dátuma.
####weight:
A szállítmány súlya
####currency:
A szállítmány beérkezése napján aktuális árfolyam.
####supplier:
A beszállító adatai.
<br><br>
###Category
A termékkategóriák tárolására alkalmas.
####id:
A kategória azonosítója.
####name:
A kategória neve.
<br><br>