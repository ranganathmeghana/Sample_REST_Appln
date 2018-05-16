package org.meghana.messenger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.meghana.messenger.database.Database;
import org.meghana.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> map = Database.getMessages();
	
	public MessageService() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		map.put(123L,new Message(123L, "Messge1",date,"Meghana"));
		map.put(456L,new Message(456L, "Messge2",date,"Meghana"));
		map.put(789L,new Message(789L, "Messge3",date,"Meghana"));
		// TODO Auto-generated constructor stub
	}
	
	public List<Message> getAllMsgs(int year){
		List<Message> msgsFinal = new ArrayList<Message>();
		
		List<Message> msgs = new ArrayList<Message>(map.values());
		for(Message message: msgs){
			Calendar cal = Calendar.getInstance();
			cal.setTime(message.getCreated());
			int year1= cal.get(Calendar.YEAR);
			if(year1==year){
				msgsFinal.add(message);
			}
		}
		return msgsFinal;
	}
	
	public List<Message> getAllMsgs (int start, int size){
		
		List<Message> msgs = new ArrayList<Message>(map.values());
		if(start + size > msgs.size())
			return msgs;
		else
			return msgs.subList(start, start + size);
		
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(map.values());	
	}
	
	
	public Message getMessage(long id){
		return map.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(map.size() +1);
		map.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		map.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		if(id <= 0){
			return null;
		}
		map.remove(id);
		return map.get(id);
	}
//	public List<Message> getAllMessages() throws ParseException{
//		
//		String dateInString = "17-Oct-1992";
//		SimpleDateFormat format= new SimpleDateFormat("dd-MMM-yyyy");
//		Date date;
//		
//			date = format.parse(dateInString);
//			
//			Message m1=new Message(123L, "Messge1",date,"Meghana");
//			Message m2=new Message(456L, "Messge2",date,"Meghana");
//			Message m3=new Message(789L, "Messge3",date,"Meghana");
//			
//			List<Message> l1 = new ArrayList<Message>();
//			l1.add(m1);
//			l1.add(m2);
//			l1.add(m3);
//		
//		return l1;
//	}
	
}
