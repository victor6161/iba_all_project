package com.iba.kozlov.client.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "mainBean", eager = true)
@SessionScoped
public class MainBean {
	@Setter
	@Getter
	List<TableRowBean> tableRowBeanList;
	@Setter
	@Getter
	SearchParameterBean searchBean;
	public MainBean(){
		searchBean=new SearchParameterBean();
	}
}
