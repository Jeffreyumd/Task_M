package view;

import controller.DAO;
import controller.DAOImple;
import model.Level;

import javax.swing.*;

public class SimpleView  extends JFrame{
    private JButton button1;
    private JPanel rootPanel;

    final DefaultListModel model = new DefaultListModel();
    final DefaultListModel model2 = new DefaultListModel();
    DAO data = new DAOImple();




    private JList list1;
    private JList list2;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public SimpleView() {

        data.getConnection();



        data.getAllCategory().forEach(i -> {
            model.addElement(i);
        });

        model2.addElement(Level.LOW);
        model2.addElement(Level.MEDIUM);
        model2.addElement(Level.HIGH);
        model2.addElement(Level.TOP);





            list1.setModel(model);
            list2.setModel(model2);



        add(rootPanel);
        setTitle("Simple test");
        setSize(500, 500);



    }

    public static void main(String[] args) {
        SimpleView view = new SimpleView();
        view.setVisible(true);

        view.list2.addListSelectionListener(e -> {
            System.out.println(view.list2.getSelectedValue());
        });

        view.button1.addActionListener( e -> {
            System.out.println("You click"+ view.button1.getName());
        });


    }
}
