package view.jenismember;

import java.awt.event.*;
import javax.swing.*;
import model.*;
import dao.JenisMemberDao;

public class JenisMemberButtonUpdateActionListener implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;
    private JTable table;

    public JenisMemberButtonUpdateActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao, JTable table) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            // Get the selected member from the table
            JenisMember jenisMemberToUpdate = jenisMemberFrame.getJenisMemberAt(selectedRow);

            // Get updated values from the text field and combo box
            String newNama = jenisMemberFrame.getNama();
            JenisMember newJenisMember = jenisMemberFrame.getJenisMember();

            if (!newNama.isEmpty()) {
                // Update the member object with new values
                jenisMemberToUpdate.setNama(newNama);
                jenisMemberToUpdate.setJenisMember(newJenisMember);

                // Update the member in the database
                jenisMemberFrame.updateJenisMember(jenisMemberToUpdate);

                // Show success message
                jenisMemberFrame.showAlert("Member Berhasil Diupdate");
            } else {
                jenisMemberFrame.showAlert("Nama tidak boleh kosong");
            }
        } else {
            jenisMemberFrame.showAlert("Pilih Member yang mau diupdate");
        }
    }
}
