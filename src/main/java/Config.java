public class Config {

    private String url ="jdbc:mysql://localhost/adlister_db?serverTimezone=UTC";
    private String user="adlister_user";
    private String password = "adlister_pwd";

    public String getUrl(){
        return url;
    }
    public String getUser(){
        return user;
    }
    public String getPassword() {
        return password;
    }



}
