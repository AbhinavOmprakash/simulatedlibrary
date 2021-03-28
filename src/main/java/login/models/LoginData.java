package login.models;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginData {
    public String username;
    public String hashedPassword;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int ID;

    public LoginData(){
        // for hibernate
    }
    public LoginData(String username, char[] password){
        this.username = username;
        this.hashedPassword = BCrypt.hashpw(String.valueOf(password), BCrypt.gensalt());
    }

    public LoginData(String username, String password) {
        this.username = username;
        this.hashedPassword = BCrypt.hashpw(String.valueOf(password), BCrypt.gensalt());
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginData loginData = (LoginData) o;
        return username.equals(loginData.username) && hashedPassword.equals(loginData.hashedPassword);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());
    }


}
