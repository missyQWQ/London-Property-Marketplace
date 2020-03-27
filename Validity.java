import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 * This class is mainly used to check the validity of user account 
 * in this software.
 * 
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class Validity {
    private static List<HashMap> accounts = new ArrayList();
    public static void Store_Info(HashMap info)
    {
        accounts.add(info);
    }

    /**
     * check wheter user's login information is right.
     * @return Boolean If_true.
     */
    public static boolean CheckInfo(String username,String password){
        boolean If_true = false;
        for(HashMap account: accounts){
            if(account.get("username").equals(username)&&account.get("password").equals(password)){
                If_true = true;
            }

        }
        return  If_true;
    }

    /**
     * check wheter user's address matches its username.
     * @return Boolean compare.
     */
    public static boolean CheckForget(String username,String Email){
        boolean compare = false;
        for(HashMap account: accounts){
            if(account.get("username").equals(username)&&account.get("email").equals(Email)){
                compare = true;
            }

        }
        return  compare;
    }

    /**
     * check if the username has been used.
     * @return Boolean If_true.
     */
    public static boolean CheckSame(String username){
        boolean If_true = false;
        for(HashMap account: accounts){
            if(account.get("username").equals(username)){
                If_true = true;
            }

        }
        return  If_true;
    }

    /**
     * check if the address has been used.
     * @return Boolean If_true.
     */
    public static boolean CheckMail(String Email){
        boolean If_true = false;
        for(HashMap account: accounts){
            if(account.get("email").equals(Email)){
                If_true = true;
            }

        }
        return  If_true;
    }

    /**
     * get the password for a account.
     * @return String password.
     */
    public static String getPassword(String username,String Email){
        String password;
        for(HashMap account: accounts){
            if(account.get("username").equals(username)&&account.get("email").equals(Email)){
                return account.get("password").toString();
            }

        }
        return null;
    }

}