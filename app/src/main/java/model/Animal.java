package model;

import java.io.Serializable;

public enum Animal implements Serializable {
    TIGER("Tiger"), HORSE("Horse"), CAT("Cat"), DOG("Dog"), BEAR("Bear"), FISH("Fish"), TURTLE("Turtle"),
    TURKEY("Turkey"), DUCK("Duck"), SHEEP("Sheep"), SQUIRREL("Squirrel"), BAT("Bat"), ZEBRA("Zebra"), SNAKE("Snake");

    private String value;

    Animal(String value) {this.value = value;}

    public String getValue() {return value;}

    @Override
    public String toString() {return value;}
}
