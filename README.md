Kotlin Compose ToDo Task App

Projektin kuvaus
Pieni Android-sovellus, joka on tehty Kotlinilla ja Compose-käyttöliittymällä. Sovellus esittelee data classin, Kotlin-funktiot ja Compose UI:n käytön.

Toteutetut ominaisuudet
  - Task - data class, jossa kentät "id", "title", "description", "priority", "dueDate" ja "done". 
  
  - 5 valmista tehtävää, jotka näytetään käyttöliitymässä.
  
  Funktiot:
  
  - addTask(list, task) - lisää uuden tehtävän listaan.
  - toggleDone(list, id) - vaihtaa tehtävän tilan tehty/ei tehty.
  - filterByDone(list, done) - näyttää vain tehtävät, jotka ovat done-tilassa.
  - sortByDueDate(list) - järjestää tehtävät määräpäivän mukaan.
  - Napit käyttöliitymälle. 

Käyttöohje
1. Avaa projekti Android Studiossa.
2. Käynnistä sovellus emulaattorilla tai fyysisellä laitteella.
3. Näet tehtävälistan ja voit kokeilla lisäystä, suodatusta, tilan vaihtoa ja lajittelua.
