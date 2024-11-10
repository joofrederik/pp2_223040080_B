package view.member;

import java.awt.event.*;
import javax.swing.*;
import model.*;
import dao.MemberDao;

public class MemberButtonUpdateActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;
    private JTable table;

    public MemberButtonUpdateActionListener(MemberFrame memberFrame, MemberDao memberDao, JTable table) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow != -1) {
            // Get the selected member from the table
            Member memberToUpdate = memberFrame.getMemberAt(selectedRow);

            // Get updated values from the text field and combo box
            String newNama = memberFrame.getNama();
            JenisMember newJenisMember = memberFrame.getJenisMember();

            if (!newNama.isEmpty()) {
                // Update the member object with new values
                memberToUpdate.setNama(newNama);
                memberToUpdate.setJenisMember(newJenisMember);

                // Update the member in the database
                memberFrame.updateMember(memberToUpdate);

                // Show success message
                memberFrame.showAlert("Member Berhasil Diupdate");
            } else {
                memberFrame.showAlert("Nama tidak boleh kosong");
            }
        } else {
            memberFrame.showAlert("Pilih Member yang mau diupdate");
        }
    }
}
