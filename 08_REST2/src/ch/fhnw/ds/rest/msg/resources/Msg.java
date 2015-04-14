package ch.fhnw.ds.rest.msg.resources;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Msg {
	private String text;
	private Date date;

	@SuppressWarnings("unused")
	private Msg() {
	}

	public Msg(String text) {
		this(text, new Date());
	}

	public Msg(String text, Date date) {
		this.text = text;
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
