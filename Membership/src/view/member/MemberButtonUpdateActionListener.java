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
            
            Member memberToUpdate = memberFrame.getMemberAt(selectedRow);

           
            String newNama = memberFrame.getNama();
            JenisMember newJenisMember = memberFrame.getJenisMember();

            if (!newNama.isEmpty()) {
                
                memberToUpdate.setNama(newNama);
                memberToUpdate.setJenisMember(newJenisMember);

             
                memberFrame.updateMember(memberToUpdate);

              
                memberFrame.showAlert("Member Berhasil Diupdate");
            } else {
                memberFrame.showAlert("Nama tidak boleh kosong");
            }
        } else {
            memberFrame.showAlert("Pilih Member yang mau diupdate");
        }
    }
}
