package p.tomaszewski.FastRace.model;

import javax.validation.constraints.NotEmpty;

public class Contact {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String subject;
    @NotEmpty
    private String message;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}