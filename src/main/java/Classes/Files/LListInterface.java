package Classes.Files;
import java.util.*;
import InterfacesAndLinkedLists.TwoTimesLinkedList;

public interface LListInterface {

    boolean isEmpty();
     // if List[] == null, dann return true, ansonsten false

    boolean hasAccess();
     // if currentObject != null, dann return true, ansonsten false

    void next();
    // if isEmpty() == false && hasAccess == true && currentObject.nextElement != null, dann currentObject hasAccess == true

    void toFirst();
    // if isEmpty() != false, dann erstes Object == currentObject

    void toLast();
    // if isEmpty() == false, dann letztes Object == currentObject

    Object getObject();
    // if hasAccess() == true, dann wird akutelles Object wiedergegeben
    // if hasAccess() == false, dann return null

    void setObject(Object pObject);
    // if hasAccess() == true && pObject == null, dann aktuelles Object = pObject

    void append(Object pObject);
    // pObject wird am ende der List angefügt
    // if isEmpty() == true, wird pObject in die List eingefügt und hasAcces() == false gesetzt
    // if pObject == null, List bleibt unverändert

    void insert(Object pObject);
    // if hasAccess() == true, wird neuesObject vor aktuellesObject in List eingefügt
    // if isEmpty() == true, wird pObject in List eingefügt
    // if hasAccess() == false && if isEmpty() == false oder pObject == null, dann Liste bleibt unverändert

    void concat(List pList);
    // plist wird an list angehängt && plist wird leer
    // if plist == null oder leer dann bleibt unverändert

    void remove();
    //falls hasAccess() == true, dann Object löschen und Objekt Stelle davor, ersetzt gelöschtes
    //falls letztes Objekt gelöscht (hasAccess() == false) kein aktuelles Objekt
    //falls Liste leer dann bleibt unverändert
}

