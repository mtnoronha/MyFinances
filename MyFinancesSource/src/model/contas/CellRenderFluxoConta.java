package model.contas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRenderFluxoConta extends DefaultTableCellRenderer {
 

    @Override
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
   {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
              
        
 
       if (isSelected) {
           comp.setBackground(table.getSelectionBackground());
           comp.setForeground(table.getSelectionForeground());
       }else{
           comp.setBackground(table.getBackground());
           comp.setForeground(table.getForeground());
       }

       TableModelLancamento modelo = (TableModelLancamento) table.getModel();
       Lancamento r = modelo.getLancamento(row);

       if (r.getIdContaCredito().equals(modelo.conta)) {
           comp.setForeground(table.getForeground());
       } else {
           comp.setForeground(Color.red);

       }

           
        return comp;
   }

}

