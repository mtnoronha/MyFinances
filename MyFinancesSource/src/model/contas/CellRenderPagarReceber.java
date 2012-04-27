package model.contas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRenderPagarReceber extends DefaultTableCellRenderer {
 

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
       
       
        if(table.getModel() instanceof TableModelContasPagar){
            TableModelContasPagar modelo = (TableModelContasPagar)table.getModel();
            ContaPagar r = modelo.getContaPagar(row);
            
            if(!r.isPago()){
               comp.setForeground(Color.red);
           } else {
               comp.setForeground(table.getForeground());
           }

       } else if (table.getModel() instanceof TableModelContasReceber) {
           TableModelContasReceber modelo = (TableModelContasReceber) table.getModel();
           ContaReceber r = modelo.getContaReceber(row);

           if (!r.isRecebido()) {
               comp.setForeground(Color.red);
           } else {
               comp.setForeground(table.getForeground());
           }

       }
           
        return comp;
   }

}

