/*
 * Copyright (c) 2021.
 * All Intellectual Property Rights to this File/Digital Product belong to the @Author
 * @PriyadarshiChaudhuri. Contact priyadarshi.c@gmail.com for enquiries.
 * This File maybe used for Non-commercial purpose only with Credits and link to GitHub repository.
 */

package database;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.mariadb.r2dbc.api.MariadbConnection;

public class MariaDBConnect {

    public static void main(String[] args) {

        MariadbConnectionConfiguration conf = MariadbConnectionConfiguration.builder()
                .host("localhost")
                .port(3306)
                .username("myUser")
                .password("MySuperPassword")
                .database("db")
                .build();
        MariadbConnectionFactory factory = new MariadbConnectionFactory(conf);

        MariadbConnection connection = factory.create().block();

//OR

        //ConnectionFactory factory = ConnectionFactories.get("r2dbc:mariadb://user:password@host:3306/myDB?option1=value");

    }
}
