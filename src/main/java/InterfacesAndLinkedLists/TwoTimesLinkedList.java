package InterfacesAndLinkedLists;

import Classes.Files.LListInterface;

import java.util.List;

public class TwoTimesLinkedList implements LListInterface {
    TwoTimesListElement anchor;
    TwoTimesListElement current;
    @Override
    public boolean isEmpty() {
        if (anchor == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAccess() {
        if (current == null) {
            return false;
        }
        return true;
    }

    @Override
    public void next() {
        if (isEmpty() || !hasAccess() || current.getNext() == null) return;
        current = current.getNext();
    }

    @Override
    public void toFirst() {
        if (isEmpty()) return;
        current = anchor;
    }

    @Override
    public void toLast() {
        if (isEmpty()) return;
        toFirst();
        while(current.getNext() != null) {
            current = current.getNext();
        }
    }

    @Override
    public Object getObject() {
        if (hasAccess()) return current.getContent();
        return null;
    }

    @Override
    public void setObject(Object pObject) {
        if (!hasAccess() || pObject == null) return;
        current.setContent(pObject);
    }

    @Override
    public void append(Object pObject) {
        if (pObject == null) return;
        if (isEmpty()) {
            anchor = new TwoTimesListElement(pObject, null, null);
            current = null;
            return;
        }
        toLast();
        TwoTimesListElement newElement = new TwoTimesListElement(pObject, null, current);
    }

    @Override
    public void insert(Object pObject) {
        if ((!hasAccess() && !isEmpty()) || pObject == null) return;
        if (isEmpty()) {
            anchor = new TwoTimesListElement(pObject, null, null);
            current = null;
            return;
        }
        // must have access
        TwoTimesListElement previous = anchor;
        while (previous.getNext() != current) {
            previous = previous.getNext();
        }
        TwoTimesListElement newElement = new TwoTimesListElement(pObject, current, previous);
        previous.setNext(newElement);
        current.setPrevious(newElement);
    }

    @Override
    public void concat(List pList) {
        if (pList == null || pList.isEmpty() || this.isEmpty()) return;
        TwoTimesListElement startPosition = current;
        toLast();
        for (int i = 0; i < pList.size(); i++) {
            current.setNext(new TwoTimesListElement(pList.get(i), null, current));
        }
        current = startPosition;
    }

    @Override
    public void remove() {
        if (isEmpty() || !hasAccess()) return;
        TwoTimesListElement previous = anchor;
        while (previous.getNext() != current) {
            previous = previous.getNext();
        }
        previous.setNext(current.getNext());
        current.getNext().setPrevious(previous);
        current = current.getNext();
        current.setNext(null);
        current.setPrevious(null);
    }

    public TwoTimesLinkedList(TwoTimesListElement anchor, TwoTimesListElement current) {
        this.anchor = anchor;
        this.current = current;
    }

    public TwoTimesListElement getAnchor() {
        return anchor;
    }

    public void setAnchor(TwoTimesListElement anchor) {
        this.anchor = anchor;
    }

    public TwoTimesListElement getCurrent() {
        return current;
    }

    public void setCurrent(TwoTimesListElement current) {
        this.current = current;
    }
}

class TwoTimesListElement {
    private Object content;
    private TwoTimesListElement next;
    private TwoTimesListElement previous;

    public TwoTimesListElement(Object content, TwoTimesListElement next, TwoTimesListElement previous) {
        this.content = content;
        this.next = next;
        this.previous = previous;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public TwoTimesListElement getNext() {
        return next;
    }

    public void setNext(TwoTimesListElement next) {
        this.next = next;
    }

    public TwoTimesListElement getPrevious() {
        return previous;
    }

    public void setPrevious(TwoTimesListElement previous) {
        this.previous = previous;
    }
}
