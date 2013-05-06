package lab03.ui;

import java.util.Map;

import javax.swing.table.DefaultTableModel;

public class TabelaUi extends DefaultTableModel {
	
		public TabelaUi (){
		super(new Object[][] {},new String[] { "Palavra Chave", "Frequência" }); 
			
		}
		
		public TabelaUi (Map<String,Integer> mapa){
			super(getTable(mapa) ,new String[] { "Palavra Chave", "Frequência" }); 
				
		}
		
		
		private static Object[][] getTable(Map<String, Integer> mapa){
			Object[][] objeto = new Object[mapa.size()][2];
			int count = 0;
			for (String chave: mapa.keySet()){
				objeto[count][0]=  chave;
				objeto[count][1]=  mapa.get(chave);
				count++;
			}
			return objeto;
			
		}
		private static final long serialVersionUID = 7584618057417700327L;
		@SuppressWarnings("rawtypes")
		Class[] types = new Class[] { java.lang.String.class,
				java.lang.Integer.class };
		boolean[] canEdit = new boolean[] { true, false };

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int columnIndex) {
			return types[columnIndex];
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return canEdit[columnIndex];
		}
	

}
