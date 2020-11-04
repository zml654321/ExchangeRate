
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class ADLogin {

    public static final String ldapUrl = "ldap://10.20.33.197:389";  // LDAP 访问地址
    public static final String ldapFactory = "com.sun.jndi.ldap.LdapCtxFactory";
    public static final  String dn="OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn";
    public static final String ldapAccount = "APADMIN";
    public static final String ldapPwd = "CHB@2033";  //密码
    public static void main(String[] args) throws Exception {
        ADLogin adLogin=new ADLogin();
        String path="groupERReview";
        String account="ertest2";
        String password="chb@0826";
        //验证用户是否有权限,返回结果为1具有权限，0具有权限
        System.out.println(adLogin.AV(account,path));
        //验证用户用户名或密码是否正确
       //LdapContext ctx = connetLDAP(account,password);
        //System.out.println(ctx);
    }
    //身份验证（用户名密码是否正确）IV：Identity verification
    public static boolean IV(String username,String password){
        LdapContext ctx=connetLDAP(username,password);
        if(ctx==null){
            return false;
        }else{
            return true;
        }
    }
    public static LdapContext connetLDAP(String ldapAccount,String ldapPwd) {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, ldapFactory);
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, ldapAccount+ "@" + "chbcn.com.cn");
        env.put(Context.SECURITY_CREDENTIALS, ldapPwd);
        LdapContext ctxTDS = null;
        try {
            ctxTDS = new InitialLdapContext(env,null);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            System.out.println("用户名或密码错误！");
        }
        return ctxTDS;
    }
    //权限认证  Authority verification
    public  boolean AV(String umAccount,String path) throws NamingException{
        LdapContext ctx = connetLDAP(ldapAccount,ldapPwd);
        // 设置搜索过滤条件
        //memberof=CN=groupVersion,OU=All Area,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn
        String filter = "(&(sAMAccountName="+umAccount+")(memberof=CN="+path+",OU=All Area,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn))";
        SearchControls searchControls = new SearchControls();
        // 设置搜索范围
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(3000);
        NamingEnumeration<SearchResult> answer = ctx.search(dn, filter.toString(), searchControls);
        if(!answer.hasMoreElements()) {
            return false;
        }else{
            return true;
        }
    }
}
