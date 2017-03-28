package com.iba.kozlov.client;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.iba.kozlov.client.view.MainBean;
import com.iba.kozlov.web.BooksData;
import com.sun.xml.ws.api.ComponentFeature.Target;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "testRestController", eager = true)
@SessionScoped
public class TestRestController {
	private static final Logger LOGGER = Logger.getLogger(TestRestController.class);

	@Setter
	@Getter
	@ManagedProperty(value = "#{mainBean}")//требует паблик конструктор без параметров
	MainBean mainBean;
	TestRestDataFacade facade = new TestRestDataFacade(this);
	Mapper mapper = new Mapper();

	@PostConstruct
	public void init() {
		facade.init();
	}
	
	public void getBooks() {
		LOGGER.info("getBooks");
		facade.getBooks();
	}

	public void getBooksByAuthor() {
		LOGGER.info("getBooksByAuthor");
		facade.getBooksByAuthor();

	
		
	}
}
/*	public BooksData getBooks() {
		LOGGER.info("test");
		Client client = ClientBuilder.newClient();
		Response res = client.target("http://localhost:8080/JSFTest/rest/demo/all_books").request("application/json")
				.get();

		BooksData booksData = res.readEntity(BooksData.class);
		return booksData;
	}

	public BooksData getBooksByAuthor() {
		LOGGER.info("test1");
		WebTarget target = ClientBuilder.newClient()
				.target("http://localhost:8080/JSFTest/rest/demo/all_books_by_author");
		LOGGER.info("test2");
		target = target.queryParam("id", 1);

		LOGGER.info("test3" + target.getUri().toString());
		//Response res = client.target("http://localhost:8080/JSFTest/rest/demo/all_books_by_author?id=2").request("application/json").get();

		Response res = target.request(MediaType.APPLICATION_JSON).get();
		LOGGER.info("test4");
		BooksData booksData = res.readEntity(BooksData.class);
		LOGGER.info(booksData);
		return booksData;
	}*/


