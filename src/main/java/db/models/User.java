package db.models;


import javax.persistence.*;

@Entity
@Table(name = "userstable")
public class User {
    // Поля
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "phonenumber")
    private int phoneNumber;
    @Column
    private String email;

    // Конструкторы
    public User() {}
//    public User(String name, String lastName) {
//        this(name, lastName, -1, "");
//    }
//    public User(String name, String lastName, String email) {
//        this(name, lastName, -1, email);
//    }
//    public User(String name, String lastName, int phoneNumber) {
//        this(name, lastName, phoneNumber, "");
//    }
    public User(String name, String lastName, int phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    // Методы
    @Override
    public String toString() {
        return new StringBuilder("User with id-").append(getId()).append(" : ").append(getName()).append(" ")
                .append(getLastName()).append(" has Email: ").append(getEmail())
                .append(" and phone number: ").append(getPhoneNumber())
                .toString();
    }
    // Геттеры и сеттеры класса
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
