package login.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class LoginData {
    public String username;
    public String password;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int ID;

    public LoginData(){
        // for hibernate
    }
    public LoginData(String username, char[] password){
        this.username = username;
        this.password = Arrays.toString(password);
    }

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyPasswd(rawLoginData enteredData) {
        return  (enteredData.getUsername().equals(username) &&
                BCrypt.checkpw(enteredData.getPasswd(), hashedPassword));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }
}
