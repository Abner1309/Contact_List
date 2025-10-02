package Core;

import java.util.StringJoiner;

public class Contact {
    private String name;
    private String lastName;
    private String phone;
    private String email;    

    public Contact(String name, String lastName, String phone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("|");
        sj.add("Name: " + getName());
        sj.add("Last Name: " + getLastName());
        sj.add("Phone: " + getPhone());
        sj.add("E-mail: " + getEmail());
        return sj.toString();
    }
}
