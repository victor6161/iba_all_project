package com.iba.kozlov.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.iba.kozlov.client.view.TableRowBean;
import com.iba.kozlov.web.BookDtoJson;
import com.iba.kozlov.web.BooksData;

public class TestRestDataFacade {
	private TestRestController controller;
	private static final Logger LOGGER = Logger.getLogger(TestRestDataFacade.class);
	public TestRestDataFacade(TestRestController pController) {
		controller = pController;
	}

	public void init() {
		//controller.mainBean.setTableRowBeanList(getBooks());
	}

	public void getBooks() {
		LOGGER.info("getBooks");
		Client client = ClientBuilder.newClient();
		Response res = client.target("http://localhost:8080/JSFTest/rest/demo/all_books").request("application/json")
				.get();

		BooksData booksData = res.readEntity(BooksData.class);
		List<TableRowBean> tableRowBean= new ArrayList<TableRowBean>() ;
		for (BookDtoJson bookJson : booksData.getBooks()) {
			tableRowBean.add(controller.mapper.bookJsonToTableRowBean(bookJson));
		}
		controller.mainBean.setTableRowBeanList(tableRowBean);
	}

	public void getBooksByAuthor() {
		WebTarget target = ClientBuilder.newClient()
				.target("http://localhost:8080/JSFTest/rest/demo/all_books_by_author");
		String writerId = controller.mainBean.getSearchBean().getWriterId();
		
		target = target.queryParam("id", new Integer(writerId));

		LOGGER.info("test3" + target.getUri().toString());
		//Response res = client.target("http://localhost:8080/JSFTest/rest/demo/all_books_by_author?id=2").request("application/json").get();

		Response res = target.request(MediaType.APPLICATION_JSON).get();
	
		BooksData booksData = res.readEntity(BooksData.class);
		List<TableRowBean> tableRowBean= new ArrayList<TableRowBean>() ;
		for (BookDtoJson bookJson : booksData.getBooks()) {
			tableRowBean.add(controller.mapper.bookJsonToTableRowBean(bookJson));
		}
		controller.mainBean.setTableRowBeanList(tableRowBean);
	}

}
