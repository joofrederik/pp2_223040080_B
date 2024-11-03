import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainApp2 extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuForm;
    private JMenuItem form1Item, form2Item, form3Item;
    private JPanel mainPanel;

    public MainApp2() {
        setTitle("Main Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        menuBar = new JMenuBar();
        menuForm = new JMenu("Forms");

        form1Item = new JMenuItem("Form 1");
    

        form1Item.addActionListener(e -> openForm(new Form1()));
      

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
        SwingUtilities.invokeLater(MainApp2::new);
    }

    // Form 1
    class Form1 extends JPanel {
        public Form1() {
            setLayout(new BorderLayout());
            JPanel inputPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JTextField textField = new JTextField();
            JTextArea textArea = new JTextArea(5, 20);
            JCheckBox checkBox = new JCheckBox("Check Me");
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

            gbc.gridx = 0;
            gbc.gridy = 0;
            inputPanel.add(new JLabel("Text Field:"), gbc);
            gbc.gridx = 1;
            inputPanel.add(textField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            inputPanel.add(new JLabel("Text Area:"), gbc);
            gbc.gridx = 1;
            inputPanel.add(new JScrollPane(textArea), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            inputPanel.add(new JLabel("Check Box:"), gbc);
            gbc.gridx = 1;
            inputPanel.add(checkBox, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            inputPanel.add(new JLabel("Combo Box:"), gbc);
            gbc.gridx = 1;
            inputPanel.add(comboBox, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            inputPanel.add(new JLabel("Spinner:"), gbc);
            gbc.gridx = 1;
            inputPanel.add(spinner, gbc);

            // Table to display data
            String[] columns = {"Text Field", "Text Area", "Check Box", "Combo Box", "Spinner"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            JTable table = new JTable(tableModel);
            JButton addButton = new JButton("Add");

            addButton.addActionListener(e -> {
                String text = textField.getText();
                String areaText = textArea.getText();
                boolean checked = checkBox.isSelected();
                String comboSelection = (String) comboBox.getSelectedItem();
                int spinnerValue = (int) spinner.getValue();

                tableModel.addRow(new Object[]{text, areaText, checked, comboSelection, spinnerValue});
            });

            add(inputPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
        }
    }



}
    

