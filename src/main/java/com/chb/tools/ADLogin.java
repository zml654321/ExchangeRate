package com.chb.tools;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class ADLogin {
    //身份验证（用户名密码是否正确）IV：Identity verification，用户名，密码
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
        env.put(Context.INITIAL_CONTEXT_FACTORY,constant.LDAP_FACTORY);
        env.put(Context.PROVIDER_URL,constant.LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL,ldapAccount+ "@" + "chbcn.com.cn");
        env.put(Context.SECURITY_CREDENTIALS,ldapPwd);
        LdapContext ctxTDS = null;
        try {
            ctxTDS = new InitialLdapContext(env,null);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            System.out.println("用户名或密码错误！");
        }
        return ctxTDS;
    }
    //权限认证  Authority verification 用户名，groupName
    public static boolean AV(String umAccount,String groupName) throws NamingException{
        LdapContext ctx = connetLDAP(constant.LDAP_ACCOUNT,constant.LDAP_PWD);
        // 设置搜索过滤条件
        //memberof=CN=groupVersion,OU=All Area,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn
        String filter = "(&(sAMAccountName="+umAccount+")(memberof=CN="+groupName+",OU=All Area,OU=Staff,OU=Office,DC=chbcn,DC=com,DC=cn))";
        SearchControls searchControls = new SearchControls();
        // 设置搜索范围
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(3000);
        NamingEnumeration<SearchResult> answer = ctx.search(constant.DN, filter.toString(), searchControls);
        if(!answer.hasMoreElements()) {
            return false;
        }else{
            return true;
        }
    }
}
