package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "messages_2")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "msg")
	private String msg;

	public Model() {

	}

	public Model(String msg) {
		this.msg = msg;
	}

	public long getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", Message=" + msg  +"]";
	}
}
