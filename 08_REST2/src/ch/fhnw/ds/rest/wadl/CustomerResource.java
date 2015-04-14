package ch.fhnw.ds.rest.wadl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Singleton
@Path("/customers")
public class CustomerResource {
	
	private AtomicInteger counter = new AtomicInteger();
	private Map<Integer, Customer> customers = new HashMap<>();

	@GET
	@Produces("text/plain")
	public String getCustomers(@Context UriInfo uriInfo) {
		StringBuilder builder = new StringBuilder();
		UriBuilder url = uriInfo.getAbsolutePathBuilder();
		for(int id : customers.keySet()) {
			URI location = url.path("" + id).build();
			builder.append(location.toString()).append("\n");
		}
		return builder.toString();
	}

	@POST
	@Consumes("application/xml")
	public Response createCustomer(@Context UriInfo uriInfo, Customer c) {
		int id = counter.getAndIncrement();
		Customer newCustomer = new Customer(id, c.getName(), c.getPrename());
		customers.put(id,  newCustomer);
		URI location = uriInfo.getAbsolutePathBuilder().path("" + id).build();
		return Response.created(location).build();
	}


	@GET
	@Produces("application/xml")
	@Path("{id}")
	public Customer getCustomer(@PathParam("id") int id) {
		return customers.get(id);
	}

	@PUT
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("{id}")
	public Customer updateCustomer(@PathParam("id") int id, Customer c) {
		Customer cust = customers.get(id);
		cust.setName(c.getName());
		cust.setPrename(c.getPrename());
		return cust;
	}

	@DELETE
	@Path("{id}")
	public Response deleteCustomer(@PathParam("id") int id) {
		if(customers.containsKey(id)) {
			customers.remove(id);
			return Response.status(Status.OK).build();
		} else if(id < this.counter.get()) {
			return Response.status(Status.GONE).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
