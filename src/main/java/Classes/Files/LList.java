package Classes.Files;

import java.util.UUID;

public class LList implements LListInterface {
    lListElement currentObject;
    lListElement anchor;

    @Override
    public boolean isEmpty() {
        if (anchor == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAccess() {
        if (currentObject != null){
            return true;
        }
        return false;
    }

    @Override
    public void next() {
        if(isEmpty() == false && hasAccess() == true && currentObject.nextElement != null){
            currentObject = currentObject.nextElement;
        }
    }

    @Override
    public void toFirst() {
        if(isEmpty() == false){
            currentObject = anchor;
        }
    }

    @Override
    public void toLast() {
        if(isEmpty() == false){
            toFirst();
            while(currentObject.nextElement != null){
                currentObject = currentObject.nextElement;
            }
        }
    }

    public Object getObject(){
       if(hasAccess() == true){
           return currentObject.content;
       }
        return null;
    }

    public void setObject(Object pObject){
        if(hasAccess() == true && pObject != null){
            currentObject.content = pObject;
        }
    }

    public void append(Object pObject){
        lListElement element = new lListElement();
        if(isEmpty() == false){
            toLast();
            currentObject.nextElement = element;
            element.content = pObject;
        }
        if(isEmpty() == true){
            anchor = element;
            element.content = pObject;
        }
    }

    public void insert(Object pObject){
        if(hasAccess() == true){
            lListElement temp;
            temp = anchor;

            while(temp.nextElement != currentObject){
                temp = temp.nextElement;
            }
            temp.content = pObject;
        }
        if(isEmpty() == true) {
            lListElement element = new lListElement();
            anchor = element;
            anchor.content = pObject;
        }
    }

    public void concat(LList plist){
        if(hasAccess() == true){
            lListElement temp;
            temp = plist.anchor;
            toLast();

            while(temp.nextElement != null){
                temp = temp.nextElement;
                currentObject.nextElement = temp;
            }
        }
    }

    public void remove(){
        if(hasAccess() == true){
            lListElement temp;
            while(currentObject.nextElement !=null){
                temp = currentObject.nextElement;
                currentObject = temp;
            }
        }
    }


    public static void main(String[] args){


        User user1 = new User(UUID.randomUUID(),"tomas", "kamin187");
        User user2 = new User(UUID.randomUUID(),"fridolin", "kamin187");
        User user3 = new User(UUID.randomUUID(),"randalf", "kamin187");
        User user4 = new User(UUID.randomUUID(),"gandalf", "kamin187");
        User user5 = new User(UUID.randomUUID(),"tisch", "kamin187");
        User user6 = new User(UUID.randomUUID(),"urnaiumgolem", "kamin187");
        User user7 = new User(UUID.randomUUID(),"gorlock", "kamin187");

        LList list = new LList();

        list.insert(user1);
        list.currentObject = list.anchor;
        list.append(user2);
        list.append(user3);
        list.toLast();
        System.out.println(list.currentObject.content);



        LList plist = new LList();
        plist.insert(user4);
        plist.currentObject = plist.anchor;
        plist.append(user5);
        plist.append(user6);

        list.concat(plist);
        list.toLast();
        System.out.println(list.currentObject.content);


    }
}
class lListElement {
    Object content;
    lListElement nextElement;
}


