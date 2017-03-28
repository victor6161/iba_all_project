package com.iba.kozlov.client;

import com.iba.kozlov.client.view.TableRowBean;
import com.iba.kozlov.web.BookDtoJson;

public class Mapper {

	public TableRowBean bookJsonToTableRowBean(BookDtoJson bookJson) {
		TableRowBean tableRowBean=new TableRowBean();
		tableRowBean.setId(bookJson.getId());
		tableRowBean.setBookname(bookJson.getBookname());
		tableRowBean.setPrice(bookJson.getPrice());
		tableRowBean.setWriterSurname(bookJson.getWriter());
		return tableRowBean;
	}



}
