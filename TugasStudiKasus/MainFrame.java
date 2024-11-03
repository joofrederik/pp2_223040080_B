import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuForm;
    private JMenuItem form1Item, form2Item, form3Item;
    private JPanel mainPanel;

    public MainApp() {
        setTitle("Main Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        menuBar = new JMenuBar();
        menuForm = new JMenu("Forms");
        
        form1Item = new JMenuItem("Form 1");
        form2Item = new JMenuItem("Form 2");
        form3Item = new JMenuItem("Form 3");

        form1Item.addActionListener(e -> openForm(new Form1()));
        form2Item.addActionListener(e -> openForm(new Form2()));
        form3Item.addActionListener(e -> openForm(new Form3()));

        menuForm.add(form1Item);
        menuForm.add(form2Item);
        menuForm.add(form3Item);
        menuBar.add(menuForm);
        setJMenuBar(menuBar);

        // Main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        setVisible(true);
    }

    private void openForm(JPanel formPanel) {
        mainPanel.removeAll();
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }

    // Form 1
    class Form1 extends JPanel {
        public Form1() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

            JTextField textField = new JTextField();
            JTextArea textArea = new JTextArea(5, 20);
            JCheckBox checkBox = new JCheckBox("Check Me");
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
            JSlider slider = new JSlider(0, 100, 50);

            inputPanel.add(new JLabel("Text Field:"));
            inputPanel.add(textField);
            inputPanel.add(new JLabel("Text Area:"));
            inputPanel.add(new JScrollPane(textArea));
            inputPanel.add(new JLabel("Check Box:"));
            inputPanel.add(checkBox);
            inputPanel.add(new JLabel("Combo Box:"));
            inputPanel.add(comboBox);
            inputPanel.add(new JLabel("Slider:"));
            inputPanel.add(slider);

            // Table to display data
            String[] columns = {"Text Field", "Text Area", "Check Box", "Combo Box", "Slider"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            JTable table = new JTable(tableModel);
            JButton addButton = new JButton("Add");

            addButton.addActionListener(e -> {
                String text = textField.getText();
                String areaText = textArea.getText();
                boolean checked = checkBox.isSelected();
                String comboSelection = (String) comboBox.getSelectedItem();
                int sliderValue = slider.getValue();

                tableModel.addRow(new Object[]{text, areaText, checked, comboSelection, sliderValue});
            });

            add(inputPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
        }
    }

    // Form 2
    class Form2 extends JPanel {
        public Form2() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

            JTextField textField = new JTextField();
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            JCheckBox checkBox = new JCheckBox("Agree");
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Choice 1", "Choice 2", "Choice 3"});
            JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});

            inputPanel.add(new JLabel("Text Field:"));
            inputPanel.add(textField);
            inputPanel.add(new JLabel("Spinner:"));
            inputPanel.add(spinner);
            inputPanel.add(new JLabel("Check Box:"));
            inputPanel.add(checkBox);
            inputPanel.add(new JLabel("Combo Box:"));
            inputPanel.add(comboBox);
            inputPanel.add(new JLabel("List:"));
            inputPanel.add(new JScrollPane(list));

            // Table to display data
            String[] columns = {"Text Field", "Spinner", "Check Box", "Combo Box", "List Selection"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            JTable table = new JTable(tableModel);
            JButton addButton = new JButton("Add");

            addButton.addActionListener(e -> {
                String text = textField.getText();
                int spinValue = (int) spinner.getValue();
                boolean checked = checkBox.isSelected();
                String comboSelection = (String) comboBox.getSelectedItem();
                String listSelection = list.getSelectedValue();

                tableModel.addRow(new Object[]{text, spinValue, checked, comboSelection, listSelection});
            });

            add(inputPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
        }
    }

    // Form 3
    class Form3 extends JPanel {
        public Form3() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

            JTextField textField = new JTextField();
            JRadioButton radio1 = new JRadioButton("Option A");
            JRadioButton radio2 = new JRadioButton("Option B");
            JCheckBox checkBox = new JCheckBox("Agree");
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Choice A", "Choice B", "Choice C"});
            ButtonGroup radioGroup = new ButtonGroup();
            radioGroup.add(radio1);
            radioGroup.add(radio2);

            inputPanel.add(new JLabel("Text Field:"));
            inputPanel.add(textField);
            inputPanel.add(new JLabel("Radio Buttons:"));
            JPanel radioPanel = new JPanel();
            radioPanel.add(radio1);
            radioPanel.add(radio2);
            inputPanel.add(radioPanel);
            inputPanel.add(new JLabel("Check Box:"));
            inputPanel.add(checkBox);
            inputPanel.add(new JLabel("Combo Box:"));
            inputPanel.add(comboBox);

            // Table to display data
            String[] columns = {"Text Field", "Radio Selection", "Check Box", "Combo Box"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            JTable table = new JTable(tableModel);
            JButton addButton = new JButton("Add");

            addButton.addActionListener(e -> {
                String text = textField.getText();
                String radioSelection = radio1.isSelected() ? "Option A" : "Option B";
                boolean checked = checkBox.isSelected();
                String comboSelection = (String) comboBox.getSelectedItem();

                tableModel.addRow(new Object[]{text, radioSelection, checked, comboSelection});
            });

            add(inputPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
        }
    }
}
