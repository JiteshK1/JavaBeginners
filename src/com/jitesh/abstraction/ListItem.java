package com.jitesh.abstraction;

public abstract class ListItem {

    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

      abstract void next();
    abstract void setNext();
    abstract void previous();
    abstract void setPrevious();
    abstract void CompareTo();
     Object getValue(){
        return  this.value;
    }

    void  setValue(Object value){
         this.value=value;
    }

}
