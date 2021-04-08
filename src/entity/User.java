package entity;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

public class User extends AbstractEntity {
    private String login;
    private String firstName;
    private String lastName;
    private byte[] pinHash;

    public User(String login, String firstName, String lastName, String pin) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinHash = this.getHash(pin);

    }

    public User(String login, String pin) {
        this.login = login;
        this.pinHash = this.getHash(pin);
    }

    public boolean validatePin(String pin) {
        return MessageDigest.isEqual(getHash(pin), this.pinHash);
    }

    private byte[] getHash(String pin) {
        try {
            MessageDigest dg = MessageDigest.getInstance("md5"); // DO NOT USE ON PRODUCTION!!!
            return dg.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
            return new byte[0];
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) &&
                Arrays.equals(pinHash, user.pinHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(login);
        result = 31 * result + Arrays.hashCode(pinHash);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pinHash=" + Arrays.toString(pinHash) +
                '}';
    }
}
