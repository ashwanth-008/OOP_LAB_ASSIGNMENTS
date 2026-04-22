package model;

/*DEFINING ABSTRACT USER CLASS TO AVOID REPETITIVE CREATION OF ROLE CLASSES*/

public abstract class DefaultUser {
    public int id;
    public String name, email, password, role;
}