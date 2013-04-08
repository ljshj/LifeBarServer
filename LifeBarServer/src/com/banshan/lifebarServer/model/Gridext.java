package com.banshan.lifebarServer.model;



/**
 * Gridext entity. @author MyEclipse Persistence Tools
 */

public class Gridext  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Double price;
     private String email;
     private String birthday;
     private String sex;


    // Constructors

    /** default constructor */
    public Gridext() {
    }

	/** minimal constructor */
    public Gridext(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /** full constructor */
    public Gridext(Long id, String name, Double price, String email, String birthday, String sex) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
   








}