package view;

import controller.DAO;
import controller.DAOImple;

import javax.swing.*;

public class SimpleView  extends JFrame{
    private JButton button1;
    private JPanel rootPanel;

    DAO data = new DAOImple();




    private JList list1;

    public SimpleView() {

        data.getConnection();

        final DefaultListModel model = new DefaultListModel();

        data.getAllCategory().forEach(i -> {
            model.addElement(i.name());
        });


            list1.setModel(model);

        add(rootPanel);
        setTitle("Simple test");
        setSize(500, 500);



    }

    public static void main(String[] args) {
        SimpleView view = new SimpleView();
        view.setVisible(true);
    }
}
