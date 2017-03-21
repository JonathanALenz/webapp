package appLayer;

/**
 * Created by JonathanL on 21-03-2017.
 */
public class User {

    public boolean isValidUser(String username, String userPassword){
        if(username.equals("jonathan") && userPassword.equals("1234")){
            return true;
        }
        else return false;
    }

}
