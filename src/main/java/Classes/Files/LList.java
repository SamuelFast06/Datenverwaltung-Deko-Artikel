package Classes.Files;

public class LList implements LListInterface{
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
        if(isEmpty() == false){
            toLast();
            currentObject.nextElement.content = pObject;
        }
        if(isEmpty() == true){
            anchor.content = pObject;
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
            anchor.content = pObject;
        }
    }

    public void concat(LList plist){
        if(hasAccess() == true){
            lListElement temp;
            temp = plist.anchor;
            toLast();

            while(temp.nextElement != null){
                currentObject.content = temp.content;
                currentObject = currentObject.nextElement;
                temp = null;
                temp = temp.nextElement;
            }
        }
    }

    public void remove(){
        if(hasAccess() == true){
            lListElement temp;
            while(currentObject.nextElement !=null){
                temp = currentObject.nextElement;
                currentObject = null;
                currentObject = temp;
            }
        }
    }

    public static void maain(String[] args){
        LList list = new LList();

        User user1 = new User();

    }
}
class lListElement {
    Object content;
    lListElement nextElement;
}


