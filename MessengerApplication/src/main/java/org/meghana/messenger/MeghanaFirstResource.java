package org.meghana.messenger;



import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meghana.messenger.model.Message;

@Path("/messages")
public class MeghanaFirstResource {

/*	
@GET
@Produces(MediaType.TEXT_PLAIN)
public String getMessage(){
	return "Meghana's First Message"; 
}
*/

	/*
@GET
@Produces(MediaType.APPLICATION_XML)
public List<Message> getListMessages() throws ParseException{
	MessageService m1=new MessageService();
	return m1.getAllMessages();
}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getListMessages(@QueryParam ("year") int year,
										@QueryParam ("start") int start,
										@QueryParam ("size") int size) throws ParseException{
		MessageService m1=new MessageService();
		
		if(year>0){
			m1.getAllMsgs(year);
		}
		
		if(start>=0 && size>0){
			m1.getAllMsgs(start, size);
		}
		return m1.getAllMessages();
	
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		MessageService m1=new MessageService();
		return m1.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		MessageService m1=new MessageService();
		message.setId(id);
		return m1.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message removeMessage(@PathParam("messageId") long id){
		MessageService m1=new MessageService();
		return m1.removeMessage(id);
	}
	
//	@GET
//	@Path("/{messageId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Message getListMessages(@PathParam("messageId") long id) throws ParseException{
//		MessageService m1=new MessageService();
//		return m1.getMessage(id);
//	}	
}
