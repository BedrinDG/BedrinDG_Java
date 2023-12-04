import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame{
    private final JTextField textField = new JTextField(10);
    private final JTextArea textFieldResult = new JTextArea(10,70);
    private final JTextField fieldNameProduct = new JTextField(15);
    private final JTextField fieldPrice = new JTextField(15);
    private final JTextField fieldDepartment = new JTextField(15);
    private final JFrame addProductFrame = new JFrame("Add Product");
    private final JTextField fieldNameDepart = new JTextField(15);
    private final JTextField fieldOpeningHours = new JTextField(15);
    private final JFrame addDepartmentFrame = new JFrame("Add Department");
    private final JFrame deleteProductFrame = new JFrame("Delete Product");
    private final JTextField nameFieldProduct = new JTextField(9);
    private final JTextField departmentName = new JTextField(9);
    private final JFrame deleteDepartmentFrame = new JFrame("Delete Department");
    private final JTextField nameFieldDepartment = new JTextField(9);
    public GUI(){
        super("Shop");
        this.setBounds(100,100, 300,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x1C373D));
        this.setResizable(false);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));

        JButton show = new JButton("Show");
        container.add(show);
        show.addActionListener(e -> showResult());

        JLabel label = new JLabel("Shop");
        container.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0xFFFFFF));

        JButton addProduct = new JButton("Append Product");
        container.add(addProduct);
        addProduct.addActionListener(e -> addNewProductFrame());
        JButton addDepartment = new JButton("Append Department");
        container.add(addDepartment);
        addDepartment.addActionListener(e -> addNewDepartment());

        JButton deleteProduct = new JButton("Delete Product");
        container.add(deleteProduct);
        deleteProduct.addActionListener(e -> deleteProduct());
        JButton deleteDepartment = new JButton("Delete Department");
        container.add(deleteDepartment);
        deleteDepartment.addActionListener(e -> deleteDepartment());
    }
    private void showResult(){
        JFrame showFrame = new JFrame("Show");
        showFrame.setResizable(false);

        JRadioButton rad1 = new JRadioButton("Empty department");

        JRadioButton rad2 = new JRadioButton("Products in the department");

        JRadioButton rad3 = new JRadioButton("All Product");
        rad3.setSelected(true);

        JScrollPane scroll = new JScrollPane(textFieldResult);

        JButton showResults = new JButton("Show");
        showResults.addActionListener(e -> textFieldResult.append(Results(rad3.isSelected() ?
                rad3.getText() : rad2.isSelected() ?
                rad2.getText() : rad1.getText())));

        ButtonGroup group = new ButtonGroup();
        group.add(rad1);
        group.add(rad2);
        group.add(rad3);

        Container containerRadioButton = new Container();
        containerRadioButton.setLayout(new GridLayout(1,3,0,0));
        containerRadioButton.add(rad3);
        containerRadioButton.add(rad2);
        containerRadioButton.add(rad1);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.add(textField);
        contents.add(containerRadioButton);
        contents.add(showResults);
        contents.add(scroll);

        showFrame.setContentPane(contents);
        showFrame.setSize(670, 420);
        showFrame.setVisible(true);

    }
    private void addNewProductFrame(){
        addProductFrame.setResizable(false);

        JLabel frameLabel = new JLabel("Add Product");

        JLabel nameLabel = new JLabel("Name");

        Container nameContainer = new Container();
        nameContainer.setLayout(new GridLayout(2,1,2,1));
        nameContainer.add(nameLabel);
        nameContainer.add(fieldNameProduct);

        JLabel departmentLabel = new JLabel("Department");

        Container departmentContainer = new Container();
        departmentContainer.setLayout(new GridLayout(2,1,2,1));
        departmentContainer.add(departmentLabel);
        departmentContainer.add(fieldDepartment);

        JLabel priceLabel = new JLabel("Price");

        Container priceContainer = new Container();
        priceContainer.setLayout(new GridLayout(2,1,2,1));
        priceContainer.add(priceLabel);
        priceContainer.add(fieldPrice);

        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(e -> add(fieldNameProduct.getText()
                ,fieldDepartment.getText()
                ,fieldPrice.getText()));
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contents.add(frameLabel);
        contents.add(nameContainer);
        contents.add(departmentContainer);
        contents.add(priceContainer);
        contents.add(addButton);

        addProductFrame.setContentPane(contents);
        addProductFrame.setSize(200,250);
        addProductFrame.setVisible(true);
    }
    private void addNewDepartment(){
        addDepartmentFrame.setResizable(false);

        JLabel frameLabel = new JLabel("Add Department");

        JLabel nameLabel = new JLabel("Name");

        Container nameContainer = new Container();
        nameContainer.setLayout(new GridLayout(2,1,2,1));
        nameContainer.add(nameLabel);
        nameContainer.add(fieldNameDepart);

        JLabel openingHoursLabel = new JLabel("Opening hours");

        Container openingHoursContainer = new Container();
        openingHoursContainer.setLayout(new GridLayout(2,1,2,1));
        openingHoursContainer.add(openingHoursLabel);
        openingHoursContainer.add(fieldOpeningHours);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> add(fieldNameDepart.getText()
                ,fieldOpeningHours.getText()));

        JPanel contents_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contents_1.add(frameLabel);
        contents_1.add(nameContainer);
        contents_1.add(openingHoursContainer);
        contents_1.add(addButton);

        addDepartmentFrame.setContentPane(contents_1);
        addDepartmentFrame.setSize(200,200);
        addDepartmentFrame.setVisible(true);
    }
    private void deleteProduct(){
        deleteProductFrame.setResizable(false);

        JLabel delProd = new JLabel("Delete product");

        JLabel name = new JLabel("Name");

        Container productContainer = new Container();
        productContainer.setLayout(new GridLayout(1,2,2,1));
        productContainer.add(name);
        productContainer.add(nameFieldProduct);

        JLabel department = new JLabel("Department");

        Container departmentContainer = new Container();
        departmentContainer.setLayout(new GridLayout(1,2,2,1));
        departmentContainer.add(department);
        departmentContainer.add(departmentName);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> delete(nameFieldProduct.getText()
                ,departmentName.getText()));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(delProd);
        panel.add(productContainer);
        panel.add(departmentContainer);
        panel.add(deleteButton);

        deleteProductFrame.setContentPane(panel);
        deleteProductFrame.setSize(200,150);
        deleteProductFrame.setVisible(true);
    }
    private void deleteDepartment(){
        deleteDepartmentFrame.setResizable(false);

        JLabel delProd = new JLabel("Delete Department");

        JLabel name = new JLabel("Name");

        Container departmentContainer = new Container();
        departmentContainer.setLayout(new GridLayout(1,2,2,1));
        departmentContainer.add(name);
        departmentContainer.add(nameFieldDepartment);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> delete(nameFieldDepartment.getText()));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(delProd);
        panel.add(departmentContainer);
        panel.add(deleteButton);

        deleteDepartmentFrame.setContentPane(panel);
        deleteDepartmentFrame.setSize(200,120);
        deleteDepartmentFrame.setVisible(true);

    }
    private String Results(String i){
        textFieldResult.setText(null);
        File file = new File();
        switch (i){
            case "All Product" -> {return file.showAllProducts();}
            case "Products in the department" -> {
                String name = textField.getText();
                textField.setText(null);
                return file.showProductInTheDepartment(name);}
            case "Empty department" -> {return file.showEmptyDepartment();}
        }
        return null;
    }
    private void add(String name, String department, String price){
        File file = new File();

        String message = file.addProduct(name, department, price);

        fieldNameProduct.setText(null);
        fieldPrice.setText(null);
        fieldDepartment.setText(null);

        JOptionPane.showMessageDialog(addProductFrame, message);
    }
    private void add(String nameDepartment, String openingHours){
        File file = new File();

        String message = file.addDepartment(nameDepartment, openingHours);

        fieldNameDepart.setText(null);
        fieldOpeningHours.setText(null);

        JOptionPane.showMessageDialog(addDepartmentFrame, message);
    }
    private void delete(String name, String department){
        File file = new File();

        String message = file.deleteProduct(name, department);

        nameFieldProduct.setText(null);
        departmentName.setText(null);

        JOptionPane.showMessageDialog(deleteProductFrame, message);
    }
    private void delete(String department){
        File file = new File();

        String message = file.deleteDepartment(department);

        nameFieldDepartment.setText(null);

        JOptionPane.showMessageDialog(deleteProductFrame, message);
    }
}