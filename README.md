Kotlin Compose ToDo Task App

Projektin kuvaus
Pieni Android-sovellus, joka on tehty Kotlinilla ja Compose-käyttöliittymällä. Sovellus demonstroi MVVM-arkkitehtuuria, tilanhallintaa Compose-ympäristössä sekä ViewModelin ja StateFlow’n käyttöä.

Toteutetut ominaisuudet
Model
  - Task-data class
  - (id, title, description, priority, dueDate, done)

Data
  - Mock-data alustetaan sovelluksen käynnistyessä

ViewModel
  - TaskViewModel vastaa sovelluksen tilasta ja liiketoimintalogiikasta
  - Tila hallitaan StateFlow<List<Task>> -rakenteella

ViewModel-toiminnot:
  - addTask(task: Task) – lisää uuden tehtävän
  - toggleDone(id: Int) – vaihtaa tehtävän tilan
  - updateTask(task: Task) – päivittää tehtävän tiedot
  - removeTask(id: Int) – poistaa tehtävän
  - filterByDone(done: Boolean) – suodattaa tehtävät
  - sortByDueDate() – lajittelee tehtävät määräpäivän mukaan
  - showAll() – näyttää kaikki tehtävät
 
Käyttöliittymä
  - HomeScreen erillisessä tiedostossa
  - Tehtävälista näytetään LazyColumn-komponentilla
  - Jokaisella rivillä:
    - Checkbox (done-tila)
    - Tehtävän otsikko
  - Uuden tehtävän lisäys:
    - TextField + Button
  - Suodatus ja lajittelu painikkeilla
  - Tehtävän painallus avaa DetailDialog-ikkunan, jossa:
    - Tehtävää voi muokata
    - Tehtävän voi poistaa


MVVM erottaa käyttöliittymän sovelluslogiikasta. Tämä tekee Compose-sovelluksista selkeämpiä, helpommin testattavia ja paremmin ylläpidettäviä.
StateFlow on Kotlin Flow -pohjainen tilanhallintamekanismi. Se säilyttää aina viimeisimmän tilan ja lähettää sen automaattisesti UI:lle.
Compose kuuntelee StateFlow’ta collectAsState()-funktion avulla, jolloin käyttöliittymä päivittyy heti tilan muuttuessa.

Käyttöohje
1. Avaa projekti Android Studiossa.
2. Käynnistä sovellus emulaattorilla tai fyysisellä laitteella.
3. Näet tehtävälistan ja voit kokeilla lisäystä, suodatusta, tilan vaihtoa ja lajittelua.
