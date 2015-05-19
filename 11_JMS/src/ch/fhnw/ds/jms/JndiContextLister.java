package ch.fhnw.ds.jms;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class JndiContextLister {

	public static void main(String[] args) throws Exception {
		listEntries(new InitialContext(), "");
	}
	
	private static void listEntries(Context context, String path) throws NamingException {
		NamingEnumeration<NameClassPair> it = context.list(path);
		while (it.hasMoreElements()) {
			NameClassPair elem = it.next();
			System.out.println(path + "/" + elem.getName());
			if("org.jnp.interfaces.NamingContext".equals(elem.getClassName())) {
				listEntries(context, path + "/" + elem.getName() );
			}
		}
		
	}

}
