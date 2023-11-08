package Classes.Files;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import java.util.*;
public class DbLList implements DbLListInterface{

    DbLlistElement currentObject;
    DbLlistElement anchor;

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
        DbLlistElement element = new DbLlistElement();
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
            DbLlistElement element = new DbLlistElement();
            element.content = pObject;
            if (currentObject.preElement != null) {
                DbLlistElement temp;
                temp = currentObject.preElement;
                currentObject.preElement = element;
                element.preElement = temp;
                element.nextElement = currentObject;
            }else{
                anchor = element;
                anchor.nextElement = currentObject;
                currentObject.preElement = anchor;
            }
        }
    }

    public void concat(DbLList plist){
        if(hasAccess() == true){
            toLast();
            DbLlistElement temp = currentObject;
            currentObject.nextElement = plist.anchor;
            plist.anchor.preElement = currentObject;

        }
    }

    public void remove(){
        if(hasAccess() == true){
            DbLlistElement temp;
            while(currentObject.nextElement !=null){
                temp = currentObject.nextElement;
                currentObject = temp;
            }
        }
    }

}
class DbLlistElement{

    Object content;
    DbLlistElement nextElement;
    DbLlistElement preElement;

}

