package view.member;

import java.awt.event.*;
import javax.swing.*;
import model.Member;
import dao.MemberDao;

public class MemberButtonDeleteActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;
    private javax.swing.JTable table;

    public MemberButtonDeleteActionListener(MemberFrame memberFrame, MemberDao memberDao, javax.swing.JTable table) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            memberFrame.showAlert("Silakan pilih member yang ingin dihapus.");
        } else {
            // Get selected member from the table model
            Member member = memberFrame.getMemberAt(selectedRow);
            if (member != null) {
                int confirm = JOptionPane.showConfirmDialog(
                        memberFrame, "Apakah Anda yakin ingin menghapus member ini?", "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    memberFrame.removeMember(member);
                }
            }
        }
    }
}
