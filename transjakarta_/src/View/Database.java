/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Wilson Fransicius
 */
@Entity
@Table(name = "DATABASE", catalog = "", schema = "WILSON")
@NamedQueries({
    @NamedQuery(name = "Database.findAll", query = "SELECT d FROM Database d")
    , @NamedQuery(name = "Database.findByUsername", query = "SELECT d FROM Database d WHERE d.username = :username")
    , @NamedQuery(name = "Database.findByPassword", query = "SELECT d FROM Database d WHERE d.password = :password")
    , @NamedQuery(name = "Database.findByName", query = "SELECT d FROM Database d WHERE d.name = :name")
    , @NamedQuery(name = "Database.findByData1", query = "SELECT d FROM Database d WHERE d.data1 = :data1")
    , @NamedQuery(name = "Database.findByData2", query = "SELECT d FROM Database d WHERE d.data2 = :data2")
    , @NamedQuery(name = "Database.findByData3", query = "SELECT d FROM Database d WHERE d.data3 = :data3")
    , @NamedQuery(name = "Database.findByEmail", query = "SELECT d FROM Database d WHERE d.email = :email")})
public class Database implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATA1")
    private String data1;
    @Column(name = "DATA2")
    private String data2;
    @Column(name = "DATA3")
    private String data3;
    @Column(name = "EMAIL")
    private String email;

    public Database() {
    }

    public Database(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        String oldData1 = this.data1;
        this.data1 = data1;
        changeSupport.firePropertyChange("data1", oldData1, data1);
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        String oldData2 = this.data2;
        this.data2 = data2;
        changeSupport.firePropertyChange("data2", oldData2, data2);
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        String oldData3 = this.data3;
        this.data3 = data3;
        changeSupport.firePropertyChange("data3", oldData3, data3);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Database)) {
            return false;
        }
        Database other = (Database) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Database[ username=" + username + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
