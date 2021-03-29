package login.models;

import java.util.Arrays;

public class RawLoginData {
    private final String username;
    private final String passwd;

    public RawLoginData(String username, char[] passwd) {
        this.username = username;
        this.passwd = Arrays.toString(passwd);
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return String.valueOf(passwd);
    }
}
