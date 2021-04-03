package login.models;

import common.models.Searchable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class LoginData implements Searchable {
    public String userName;
    public String password;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int ID;

    public LoginData(){
        // for hibernate
    }
    public LoginData(String userName, char[] password){
        this.userName = userName;
        this.password = Arrays.toString(password);
    }

    public LoginData(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public String getTableName() {
        return "LoginData";
    }

    @Override
    public String getSearchableAttribute() {
        return "userName";
    }
}
