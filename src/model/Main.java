package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

  public static void main(String[] args) {


    ArrayList<Task> list = new ArrayList<Task>();


    Task a = Task.builder().title("1").level(Level.top).complete(false).builder();
    Task b = Task.builder().title("1").level(Level.top).complete(false).builder();
    Task c = Task.builder().title("1").level(Level.top).complete(false).builder();


    list.add(a);
    list.add(b);
    list.add(c);




    SubProject sub = new SubProject(list,"Test", false, new Color(255, 8, 131), new Date());

    System.out.println(sub.getListSize());




  }




}
