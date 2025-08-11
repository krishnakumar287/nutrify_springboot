package com.NutrifyShop.NutrifyShop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NutrifyShopusers")
public class User {
    @Id
    private String id;
    private String name;
    private String password;
    private String age;
    private String gender;
    private String phonenumber; 
    private String email;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String Name){
        this.name=Name; 
    }
    public String getName(){
        return this.name;
    }
    public void setPassword(String Password){
        this.password=Password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setAge(String Age){
        this.age=Age;
    }
    public String getAge(){
        return this.age;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setPhonenumber(String Phonenumber){
        this.phonenumber=Phonenumber;
    }
    public String getPhonenumber(){
        return this.phonenumber;
    }
    public void setEmail(String Email){
        this.email=Email;
    }
    public String getEmail(){
        return this.email;
    }
}
