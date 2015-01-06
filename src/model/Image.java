package model;

public abstract class Image {
    private Image next;
    private Image prev;

    public abstract BitMap getBitMap();

    public Image getNext() {
        return next;
    }

    public void setNext(Image next) {
        this.next = next;
    }

    public Image getPrev() {
        return prev;
    }

    public void setPrev(Image prev) {
        this.prev = prev;
    }
}
