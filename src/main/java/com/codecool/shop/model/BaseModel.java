package com.codecool.shop.model;


import java.lang.reflect.Field;

/**
 * This base model implements the base methods of classes.
 * Classes like Product will inherit from this class.
 */

public class BaseModel {

    protected int id;
    protected String name;
    protected String description;

    public BaseModel(String name) {
        this.name = name;
    }

    /**
     * Constructor
     * @param name name
     * @param description description
     */
    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructor
     * @param id id
     * @param name name
     * @param description description
     */
    public BaseModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    /**
     * Getter
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter
     * @param id id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter
     * @param description description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method creates string of class object
     * @return String object
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
