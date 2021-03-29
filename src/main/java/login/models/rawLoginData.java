package login.models;

public class rawLoginData {
    private final String username;
    private final char[] passwd;

    public rawLoginData(String username, char[] passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return String.valueOf(passwd);
    }
}
