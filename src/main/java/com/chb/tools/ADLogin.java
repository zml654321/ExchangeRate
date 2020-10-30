package com.chb.tools;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
/*
登录认证
 */
public class ADLogin {

    String ldapUrl = "ldap://10.20.33.197:389";  // LDAP 访问地址
    String ldapFactory = "com.sun.jndi.ldap.LdapCtxFactory";
    String ldapAccount = "APADMIN";
    String ldapPwd = "CHB@2033";  //密码
    public static void main(String[] args) throws Exception {
        ADLogin adLogin=new ADLogin();
        //验证用户是否有权限,返回结果为1具有权限，0具有权限
        System.out.println(adLogin.findUser("900038"));
        //验证用户用户名或密码是否正确
        LdapContext ctx = connetLDAP("900038","%zml941025");
        System.out.println(ctx);

    }
    public static LdapContext connetLDAP(String ldapAccount,String ldapPwd) {
        Hashtable<String, String> env = new Hashtable<String, String>();
        String ldapUrl = "ldap://10.20.33.197:389";  // LDAP 访问地址
        String ldapFactory = "com.sun.jndi.ldap.LdapCtxFactory";
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
    public  int findUser(String umAccount) throws NamingException{
        LdapContext ctx = connetLDAP(ldapAccount,ldapPwd);
        String dn="OU=0826,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn";
        String userinfo = "";
        int flag = 0;
        // 设置搜索过滤条件
        String filter = "(&(sAMAccountName="+umAccount+")(memberof=CN=groupVersion,OU=All Area,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn))";
        // 定制返回属性
        String[] attrPersonArray = {"Nickname","mobile","mail","department"};
        SearchControls searchControls = new SearchControls();
        // 设置搜索范围
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(3000);
        searchControls.setReturningAttributes(attrPersonArray);
        NamingEnumeration<SearchResult> answer = ctx.search(dn, filter.toString(), searchControls);
        String[] a = searchControls.getReturningAttributes();
        if(!answer.hasMoreElements()) {
            return 0;
        }
        while(answer.hasMoreElements()) {
            SearchResult result = answer.next();
            NamingEnumeration<? extends Attribute> attrs = (NamingEnumeration<? extends Attribute>) result.getAttributes().getAll();
            // 读取属性值
            while(attrs.hasMoreElements()) {
                Attribute attr = attrs.next();
                if(attrPersonArray.length != flag) {
                    flag = flag +1;
                    userinfo = userinfo + attr.get()+",";
                }
            }
        }
        System.out.println(userinfo);
        return 1;
    }


}
