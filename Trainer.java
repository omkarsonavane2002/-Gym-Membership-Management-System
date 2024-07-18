package gymmanagement;

public class Trainer {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String speciality;

    public Trainer(String name, String email, String phoneNumber, String speciality) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

    public Trainer(int id, String name, String email, String phoneNumber, String speciality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpeciality() {
        return speciality;
    }
}

