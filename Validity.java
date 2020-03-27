import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
/**
 * This class is mainly used to check the validity of user account in this software.
 */
public class Validity {
    private static List<HashMap> accounts = new ArrayList();

    private static Validity instance;

    private Validity() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("userinfo.txt")), "UTF-8"));
            String lineTxt = null;
            while((lineTxt = br.readLine()) != null) {
                String[] info = lineTxt.split(" ");
                HashMap<String, String> infoHashMap = new HashMap<String, String>();
                infoHashMap.put("username", info[0]);
                infoHashMap.put("password", info[1]);
                infoHashMap.put("email", info[2]);
                accounts.add(infoHashMap);

            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }

    }

    public static Validity getInstance() {
        if ( instance == null ) {
            instance = new Validity();
        }
        return instance;
    }

    public void Store_Info(HashMap info) {
        accounts.add(info);

        FileOutputStream out = null;
        try {
            File file = new File("userinfo.txt");
            if ( !file.exists() ) {
                if ( !file.getParentFile().exists() ) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            out = new FileOutputStream(file, true);
            StringBuffer sb = new StringBuffer();
            sb.append(info.get("username") + " " + info.get("password") + " " + info.get("email") + "\n");

            out.write(sb.toString().getBytes("utf-8"));
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        } finally {
            try {
                if ( out != null ) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * check wheter user's login information is right.
     * @return Boolean If_true.
     */
    public boolean CheckInfo(String username, String password) {
        boolean If_true = false;
        for ( HashMap account : accounts ) {
            if ( account.get("username").equals(username) && account.get("password").equals(password) ) {
                If_true = true;
            }

        }
        return If_true;
    }

    /**
     * check wheter user's address matches its username.
     * @return Boolean compare.
     */
    public boolean CheckForget(String username, String Email) {
        boolean compare = false;
        for ( HashMap account : accounts ) {
            if ( account.get("username").equals(username) && account.get("email").equals(Email) ) {
                compare = true;
            }

        }
        return compare;
    }

    /**
     * check if the username has been used.
     * @return Boolean If_true.
     */
    public boolean CheckSame(String username) {
        boolean If_true = false;
        for ( HashMap account : accounts ) {
            if ( account.get("username").equals(username) ) {
                If_true = true;
            }

        }
        return If_true;
    }

    /**
     * check if the address has been used.
     * @return Boolean If_true.
     */
    public boolean CheckMail(String Email) {
        boolean If_true = false;
        for ( HashMap account : accounts ) {
            if ( account.get("email").equals(Email) ) {
                If_true = true;
            }

        }
        return If_true;
    }

    /**
     * get the password for a account.
     * @return String password.
     */
    public String getPassword(String username, String Email) {
        String password;
        for ( HashMap account : accounts ) {
            if ( account.get("username").equals(username) && account.get("email").equals(Email) ) {
                return account.get("password").toString();
            }

        }
        return null;
    }

}