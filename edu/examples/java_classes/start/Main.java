package edu.examples.java_classes.start;

import edu.examples.java_classes.controller.Controller;


public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request;
        String response;

        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Книга\nсоntent=Гарри Поттер";
        response = controller.doAction(request);
        System.out.println(response);

        request = "UPDATE\nid=2\ntitle=Книга\ncontent=Гарри Поттер 2 часть\ndate=2023-08-08";
        response = controller.doAction(request);
        System.out.println(response);

        request = "DELETE\nid=1";
        response = controller.doAction(request);
        System.out.println(response);

        request = "SORT\nTitle";
        response = controller.doAction(request);
        System.out.println(response);

        request = "SORT\nContent";
        response = controller.doAction(request);
        System.out.println(response);

        request = "CLEAR\n";
        response = controller.doAction(request);
        System.out.println(response);

        request = "OUTPUT\n";
        response = controller.doAction(request);
        System.out.println(response);

    }

}
