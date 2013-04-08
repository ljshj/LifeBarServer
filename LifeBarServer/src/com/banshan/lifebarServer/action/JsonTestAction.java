package com.banshan.lifebarServer.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.banshan.lifebarServer.model.Gridext;
import com.banshan.lifebarServer.service.JsonTestService;

public class JsonTestAction extends BaseAction {

	private Gridext gridext;
	
	public Gridext getGridext() {
		return gridext;
	}

	public void setGridext(Gridext gridext) {
		this.gridext = gridext;
	}

	private String message;
	private ArrayList<Gridext> resultSet;
	public ArrayList<Gridext> getResultSet() {
		return resultSet;
	}

	public void setResultSet(ArrayList<Gridext> resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource JsonTestService jsonTestService;
 
	public void list()
	{
		resultSet = (ArrayList<Gridext>) jsonTestService.findAll(0, 10);
		outJsonArray(resultSet);
		
	}
	
	public String listAll()
	{
		resultSet = (ArrayList<Gridext>) jsonTestService.findAll(0, 10);
		message = "OKKKK";
		outJsonArray(resultSet);

		return SUCCESS;
	}
	
	public void add()
	{
		jsonTestService.save(gridext);
		message = "OK";
		outJson(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
