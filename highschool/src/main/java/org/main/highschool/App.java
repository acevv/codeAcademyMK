package org.main.highschool;

import org.main.highschool.controller.Controller;

public class App {
	public static void main(String[] args) {

		Controller c = new Controller();
		c.readStudent("/Users/acev/eclipse-workspace/codeAcademy/codeAcademyMK/highschool/src/main/resources/data.txt");
//		c.inputProfesorDb();
		


	}
}