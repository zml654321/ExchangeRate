import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

public class test {
    public static void main(String[] args) throws NamingException {
      // boolean result= ADLogin.IV("ertest1","chb@0826");
        LdapContext ldapContext=ADLogin.connetLDAP("900038","^zml941025");
        //System.out.println("result:"+result);
       System.out.println("LdapContext:"+ldapContext);
       //boolean result=ADLogin.AV("group0826","groupExrateIT");
        //System.out.println("result:"+result);
    }
}
