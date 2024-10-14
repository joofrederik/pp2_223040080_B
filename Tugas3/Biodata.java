package Pertemuan3;
 

import javax.swing.*;
import java.awt.*;

public class Biodata {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Form Biodata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame

        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Title
        JLabel titleLabel = new JLabel("Form Biodata");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // nama
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Nama:"), gbc);

        JTextField nameField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // jenis kelamin
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Jenis Kelamin:"), gbc);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        gbc.gridx = 1;
        panel.add(genderPanel, gbc);

        // no Hp
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Nomor HP:"), gbc);

        JTextField phoneField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        // warga negara
        JCheckBox foreignCitizenCheckBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(foreignCitizenCheckBox, gbc);

        // Save button
        JButton saveButton = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(saveButton, gbc);

        // Add frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
