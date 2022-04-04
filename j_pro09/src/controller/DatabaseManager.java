package controller;

import model.vo.Grade;
import model.vo.Student;

public class DatabaseManager implements ImplDatabaseManager {

	@Override
	public Grade[] search(String name) {
		return null;
	}

	@Override
	public boolean add(String name) {
		return false;
	}

	@Override
	public Student modify(String name, String subject, int score) {
		return null;
	}

	@Override
	public boolean remove(String name) {
		return false;
	}

}
