Co trzeba wkleić i gdzie, żeby działało:

**Klasa NgrokManager, pole authToken - tutaj należy wklelić token z ngroka. Trzeba sobie założyć konto na ngrok.com i tak dalej.
 https://dashboard.ngrok.com/get-started/setup
Ważne; raczej każdy korzysta z wersji darmowej, a taka oferuje tylko jeden tunel na raz. 
Tak więc w przypadku undepoloyowania .war np. na Tomcat, trzeba tego agenta za każdym razem usuwać. 
Tu link: https://dashboard.ngrok.com/tunnels/agents


**Klasa PayuServiceImplementation pola CLIENT_ID i CLIENT_SECRET. Są to dane potrzebne do wygenerowania odpowiedniego tokena potrzebnego
do autoryzacji przy płatnościach. Trzeba się zarejestrować na https://registration-merch-prod.snd.payu.com/boarding/#/registerSandbox/.
Potem trzeba się zalogować, wejść do panelu i w zakładce Moje Sklepy dodać nowy sklep. W pierwszym formularzu na nasze potrzeby te dane
nie mają znaczenia, wypada jednak wybrać walutę PLN. W następnej części należy wybrać RestApiCheckout. W trzecim punkcie dostajemy dane potrzebne
do autoryzacji. 

**Plik mvc-dispatcher-servlet.xml. 
        <property name="jdbcUrl" value=""/>
        <property name="user" value=""/>
        <property name="password" value=""/>

Trzeba uzupełnić danymi własnej bazy.

Do projektu jest dołączona wyeksportowana baza danych z db4free.net
Passy do konta admina:
login: Scott
haslo: admin

Uzytkownika zwykłego sobie mozna stworzyc.



