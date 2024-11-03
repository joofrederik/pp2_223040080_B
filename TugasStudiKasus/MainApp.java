import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainApp extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuForm;
    private JMenuItem form1Item;
    private JPanel mainPanel;

    public MainApp() {
        setTitle("APLIKASI JUALAN");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        menuBar = new JMenuBar();
        menuForm = new JMenu("List");
        form1Item = new JMenuItem("Jual Makanan");
        form1Item.addActionListener(e -> openForm(new Form1()));
        menuForm.add(form1Item);
        menuBar.add(menuForm);
        setJMenuBar(menuBar);

        // Main panel
        mainPanel = new JPanel(new BorderLayout());
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
            
            // Input Panel
            JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
            JTextField textField = new JTextField();
            JTextArea textArea = new JTextArea();
            
            // Checkbox Panel for "Pakai Sarung Tangan"
            JPanel checkBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JCheckBox checkBoxSarungTangan = new JCheckBox("Ya");
            JCheckBox checkBoxSarungTangantidak = new JCheckBox("Tidak");
            checkBoxPanel.add(checkBoxSarungTangan);
            checkBoxPanel.add(checkBoxSarungTangantidak);

            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Level 0", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"});
            JSlider slider = new JSlider(1, 10, 1);

            // Add components to Input Panel
            inputPanel.add(new JLabel("Makanan:"));
            inputPanel.add(textField);
            inputPanel.add(new JLabel("Alamat:"));
            inputPanel.add(new JScrollPane(textArea));
            inputPanel.add(new JLabel("Pakai Sarung Tangan:"));
            inputPanel.add(checkBoxPanel);
            inputPanel.add(new JLabel("Tingkat Kepedasan:"));
            inputPanel.add(comboBox);
            inputPanel.add(new JLabel("Jumlah Pesanan:"));
            inputPanel.add(slider);

            // Table to display data
            String[] columns = {"Makanan", "Alamat", "Pakai Sarung Tangan", "Tingkat Kepedasan", "Jumlah Pesanan"};
            DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
            JTable table = new JTable(tableModel);
            JButton addButton = new JButton("Add");

            // Button ActionListener
            addButton.addActionListener(e -> {
                String text = textField.getText();
                String areaText = textArea.getText();
                boolean sarungTangan = checkBoxSarungTangan.isSelected();
                String comboSelection = (String) comboBox.getSelectedItem();
                int sliderValue = slider.getValue();

                tableModel.addRow(new Object[]{text, areaText, sarungTangan ? "Ya" : "Tidak", comboSelection, sliderValue});
            });

            // Add components to main layout
            add(inputPanel, BorderLayout.NORTH);
            add(new JScrollPane(table), BorderLayout.CENTER);
            add(addButton, BorderLayout.SOUTH);
        }
    }
}
