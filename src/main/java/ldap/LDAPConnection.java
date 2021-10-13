/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package ldap;

import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;

import java.io.IOException;

public class LDAPConnection {

    public static void main(String[] args) throws LdapException, IOException {
        LdapConnection connection = new LdapNetworkConnection( "localhost", 10389 );
        //LdapConnection connection = new LdapNetworkConnection( "localhost", 10636, true );
        //connection.setTimeOut(0);

        EntryCursor cursor = connection.search( "ou=system", "(objectclass=*)", SearchScope.ONELEVEL );
        for(Entry entry: cursor){
            System.out.println(entry);
        }


        /*connection.bind("uid=admin, ou=system", "secret");
        connection.unBind();*/
        connection.close();

    }
}
