package com.iba.kozlov.web;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


import lombok.Getter;
import lombok.Setter;

@XmlRootElement
public class BookDtoJson implements Serializable {
	@Override
	public String toString() {
		return "BookDtoJson [id=" + id + ", bookname=" + bookname + ", price=" + price + ", writer=" + writer + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1703961821090103148L;
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String bookname;
	@Setter
	@Getter
	private int price;
	/*
	 * @Setter
	 * 
	 * @Getter private ReaderDto reader;
	 */
	/*
	 * @Setter
	 * 
	 * @Getter private WriterDto writer;
	 */
	@Setter
	@Getter
	private String writer;

}
