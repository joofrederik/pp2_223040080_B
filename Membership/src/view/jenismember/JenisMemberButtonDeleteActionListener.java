package view.jenismember;

import java.awt.event.*;
import javax.swing.*;
import model.JenisMember;
import dao.JenisMemberDao;


public class JenisMemberButtonDeleteActionListener implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;
    private javax.swing.JTable table;

    public JenisMemberButtonDeleteActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao, javax.swing.JTable table) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            jenisMemberFrame.showAlert("Silakan pilih member yang ingin dihapus.");
        } else {
            
            JenisMember jenisMember = jenisMemberFrame.getJenisMemberAt(selectedRow);
            if (jenisMember != null) {
                int confirm = JOptionPane.showConfirmDialog(
                        jenisMemberFrame, "Apakah Anda yakin ingin menghapus member ini?", "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    jenisMemberFrame.removeJenisMember(jenisMember);
                }
            }
        }
    }
}
