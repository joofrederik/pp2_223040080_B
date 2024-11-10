package view.member;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;
import dao.MemberDao;
import dao.JenisMemberDao;

public class MemberFrame extends JFrame {
    private List<JenisMember> jenisMemberList;
    private List<Member> memberList;
    private JTextField textFieldNama;
    private MemberTableModel tableModel;
    private JComboBox<String> comboJenis;
    private MemberDao memberDao;
    private JenisMemberDao jenisMemberDao;

    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;
        this.memberList = this.memberDao.findAll();
        this.jenisMemberList = this.jenisMemberDao.findAll();

       
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 20);

        JLabel labelJenis = new JLabel("Jenis Member:");
        labelJenis.setBounds(15, 100, 100, 20);

        comboJenis = new JComboBox<>();
        comboJenis.setBounds(15, 120, 200, 20);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 150, 80, 30);

       
        JButton buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(100, 150, 80, 30);

      
        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(185, 150, 80, 30);

        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(buttonSimpan);
        this.add(buttonDelete);
        this.add(buttonUpdate);

      
        this.setSize(400, 300);
        this.setLayout(null);  

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 220, 250, 200);

        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);
        buttonSimpan.addActionListener(actionListener);

      
        MemberButtonDeleteActionListener deleteActionListener = new MemberButtonDeleteActionListener(this, memberDao, table);
        buttonDelete.addActionListener(deleteActionListener);

       
        MemberButtonUpdateActionListener updateActionListener = new MemberButtonUpdateActionListener(this, memberDao, table);
        buttonUpdate.addActionListener(updateActionListener);

        this.add(scrollableTable); 
    }

    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }

    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void removeMember(Member member) {
        tableModel.remove(member);
        this.memberDao.delete(member);
    }

 
    public Member getMemberAt(int row) {
        return memberList.get(row);
    }

    public void updateMember(Member member) {
        tableModel.update(member);
        this.memberDao.update(member);
    }
}
