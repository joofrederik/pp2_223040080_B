package view.member;

import javax.swing.table.*;
import java.util.List;
import model.Member;

class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Jenis Member"};
    private List<Member> data;

    public MemberTableModel(List<Member> data) {
        this.data = data;
    }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        if (rowItem == null) return "";
        
        switch (col) {
            case 0:  
                return rowItem.getNama();
            case 1:  
                return rowItem.getJenisMember() != null ? rowItem.getJenisMember().getNama() : "No Type";  // Handle null JenisMember
            default: 
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false; 
    }

   
    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    
    public void remove(Member value) {
        int row = data.indexOf(value);
        if (row != -1) {
            data.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }       
    public void update(Member value) {
            int rowIndex = data.indexOf(value);
            if (rowIndex != -1) {
                data.set(rowIndex, value);
                fireTableRowsUpdated(rowIndex, rowIndex);
            }
        }
        
    }

