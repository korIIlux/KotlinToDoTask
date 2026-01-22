Kotlin Compose ToDo Task App

Projektin kuvaus
Pieni Android-sovellus, joka on tehty Kotlinilla ja Compose-käyttöliittymällä. Sovellus esittelee data classin, Kotlin-funktiot ja Compose UI:n käytön.

Toteutetut ominaisuudet 
- Task-data class (id, title, description, priority, dueDate, done)
- Mock-data alustetaan sovelluksen käynnistyessä
- TaskViewModel vastaa sovelluksen tilasta ja logiikasta
  
  ViewModel-toiminnot:
  
  - addTask(task: Task) - lisää uuden tehtävän listaan.
  - toggleDone(id: Int) - vaihtaa tehtävän tilan tehty/ei tehty.
  - filterByDone(done: Boolean) - näyttää vain tehtävät, jotka ovat done-tilassa.
  - sortByDueDate() - järjestää tehtävät määräpäivän mukaan.
  - removeTask(id: Int)
  - Napit käyttöliitymälle.
 
Käyttöliittymä
- HomeScreen erillisessä tiedostossa
- Lista näytetään LazyColumn-komponentilla
- Jokaisella rivillä:
  - Checkbox (done-tila)
  - Tehtävän otsikko
  - Poista-painike
- Uuden tehtävän lisäys TextField + Button -yhdistelmällä
- Suodatus ja lajittelu painikkeilla


Miksi ViewModel?
ViewModel erottaa käyttöliittymän ja sovelluslogiikan toisistaan.  
Se säilyttää tilan oikein konfiguraatiomuutoksissa ja on parempi ratkaisu kuin pelkkä remember.


Käyttöohje
1. Avaa projekti Android Studiossa.
2. Käynnistä sovellus emulaattorilla tai fyysisellä laitteella.
3. Näet tehtävälistan ja voit kokeilla lisäystä, suodatusta, tilan vaihtoa ja lajittelua.
