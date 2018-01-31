package ru.job4j;

/**
* Class Класс для вывода надписи "Hello World".
* @author Michael Yakimenko
* @since 29.01.2018
* @version 1
*/

class Calculate {
	
	/**
	* Метод main для вывода "Hello World".
	* @param args - args.
	*/
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
	
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}