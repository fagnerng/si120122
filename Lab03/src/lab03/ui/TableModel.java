package lab03.ui;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1195955144676649191L;
	@SuppressWarnings({ "rawtypes"})
	Class[] types = new Class[] { java.lang.String.class,
			java.lang.Integer.class };
	boolean[] canEdit = new boolean[] { true, false };

	public TableModel() {
		super( new Object [][] {
        },
    new String [] {
        "Palavra Chave", "Frequência"
    });

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}

}
