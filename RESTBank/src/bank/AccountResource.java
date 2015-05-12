package bank;

import bank.Server.ServerBank;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by benjamin on 20.04.2015.
 */
@Singleton
@Path("/bank/accounts")
public class AccountResource {

    private final Bank bank = new ServerBank();

    @GET
    @Produces("application/xml")
    public Account getAccounts() {
        return null;
    }
}
