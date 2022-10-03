package Models;

import java.io.Serializable;
import java.util.Objects;

public class Movie implements Serializable{
    private String name;

    public Movie(){

    }
    public Movie(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public int hashCode() {
        int hash=7;
        hash = 19*hash+Objects.hashCode(this.name);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        final Movie other = (Movie) obj;
        if(!Objects.equals(this.name, other.name)){
            return true;
        }
        return true;
    }
}
