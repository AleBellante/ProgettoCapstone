# Capstone-project

Il mio primo progetto.
Consiste in un website e-commerce/like (nella fattispecie un e-shop di prodotti da caffetteria), creato con react.js e gestito tramite postgresql, con due interfacce:


1- Sezione cliente, previa registrazione e login, che consente la :
-scelta di prodotti
-la creazione di un carrello
-la scelta del metodo di ricezione dei prodotti (prenotazione o consegna, con relativo form di info nel caso in cui venga scelta la consegna)
-una sezione area cliente nella quale poter controllare le varie fatture emesse a nome di cliente attualmente loggato, controllare l`importo totale e l`oggettistica acquistata

2-Sezione admin, previa registrazione tramite postman (O, se volete, modificando il metodo post che trovate nel file RegisterPage.jsx) e login tramite piattaforma, che accetta un json di questo genere:
http://localhost:8080/api/auth/register/admin POST 
raw json = 
   {
   "nome":"esempio",
   "cognome":"esempio",
   "username":"esempio",
   "email":"esempio",
   "password":"esempio",
   "roles":["ROLE_ADMIN"] {->importante!!!}
   }

Eseguendo il login dal website con il nome scelto {esempio} + la password scelta {esempio} si avrà invece accesso all`area admin, che svolge la funzione di piattaforma gestionale del database, dalla quale è possibile
-creare nuovi prodotti, aggiungervi un`immagine, un importo cada, o cancellarne uno già esistente
-gestire e visualizzare le fatture tramite un filtro che cercherà le fatture tramite l`username del cliente.
-é altresì possibile cancellare l`eventuale fattura (nel caso in cui il cliente decida di cambiare idea sulla prenotazione/consegna).


Il tutto è gestito e salvabile in un database (es postgresql ) che permette la visione più dettagliata di ordini, utenti, clienti, fatture, situazione magazzino e info aggiuntive per la consegna. 
l` autenticazione è il punto cruciale del progetto. senza di essa utilizzare la piattaforma è impossibile. questo permette un controllo sulla gestione del database sulla piattaforma. 
Modificare prodotti e fatture per uno user è impossibile. Solo un admin ne è in grado

è molto lontano dall` essere un buon sito, per quanto mi sia impegnato nonostante il mese difficile appena affrontato.
Vari problemi sono sorti durante il developing, ma ho imparato molto e soprattutto mi sono "divertito" per quanto si possa dire di un lavoro che cerca di prendersi il più sul serio possibile. 

Continuerò a lavorare sulla performance e soprattutto sulla UI del sito, che lascia molto a desiderare, anche dopo la consegna del progetto (01/06/2023)

Per maggiori informazioni potete contattarmi su linkedin @Alessandro Bellante

