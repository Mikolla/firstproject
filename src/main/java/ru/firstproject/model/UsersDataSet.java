package ru.firstproject.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 *         CREATE TABLE users
 * (
 *     id bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 *     name varchar(255)
 * );
 * CREATE UNIQUE INDEX UK_3g1j96g94xpk3lpxl2qbl985x ON users (name);
 */
@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = false, updatable = true)
    private String name;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password", unique = false, updatable = true)
    private String password;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public UsersDataSet(String name) {
        this.setId(-1);
        this.setName(name);
    }


    public UsersDataSet(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UsersDataSet(String name, String password) {
        this.setId(-1);
        this.name = name;
        this.password = password;
    }

    public UsersDataSet(long id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}