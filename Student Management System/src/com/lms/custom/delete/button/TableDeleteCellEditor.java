package com.lms.custom.delete.button;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author KEHAN HASALAWA
 */
public class TableDeleteCellEditor extends DefaultCellEditor {

    private TableDeleteEvent event;

    public TableDeleteCellEditor(TableDeleteEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelDelete action = new PanelDelete();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
