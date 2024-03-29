package myodf;

import java.io.File;
import java.util.ArrayList;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.CellRange;
import org.odftoolkit.simple.table.Table;

public class Access_ods {
	private File ods_file;

	public File getods_file() {
		return ods_file;
	}

	public void setods_file(File ods_file) {
		this.ods_file = ods_file;
		// System.out.println(ods_file);
	}

	public void setods_file(String ods_file_String) {
		File file = new File(ods_file_String);
		this.ods_file = file;
	}

	public Access_ods() {
	}

	public void print_base_info() throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(0);
		System.out.println("spreadsheetDocument.getTableList().size()=" + spreadsheetDocument.getTableList().size());
		System.out.println("activetable_name= " + activetable.getTableName());
		System.out.println("activetable.getHeaderColumnCount()=" + activetable.getHeaderColumnCount());
		System.out.println("activetable.getColumnCount()=" + activetable.getColumnCount());
		System.out.println("activetable.getRowCount()=" + activetable.getRowCount());

	}

	public void print_base_info(int Sheetindex_startfrom0) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(Sheetindex_startfrom0);
		System.out.println("spreadsheetDocument.getTableList().size()=" + spreadsheetDocument.getTableList().size());
		System.out.println("activetable_name= " + activetable.getTableName());
		System.out.println("activetable.getHeaderColumnCount()=" + activetable.getHeaderColumnCount());
		System.out.println("activetable.getColumnCount()=" + activetable.getColumnCount());
		System.out.println("activetable.getRowCount()=" + activetable.getRowCount());

	}

	public void print_base_info(String Sheet_name) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByName(Sheet_name);
		System.out.println("spreadsheetDocument.getTableList().size()=" + spreadsheetDocument.getTableList().size());
		System.out.println("activetable_name= " + activetable.getTableName());
		System.out.println("activetable.getHeaderColumnCount()=" + activetable.getHeaderColumnCount());
		System.out.println("activetable.getColumnCount()=" + activetable.getColumnCount());
		System.out.println("activetable.getRowCount()=" + activetable.getRowCount());

	}

	public void print_all_cell(int Max_value_want_to_see) throws Exception {
		if (getods_file().exists()) {
			SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
			// beging from zero
			Table activetable = spreadsheetDocument.getSheetByIndex(0);
			if (Max_value_want_to_see > activetable.getColumnCount()
					&& Max_value_want_to_see > activetable.getRowCount()) {
				for (int i = 0, j = 0; i < activetable.getColumnCount() || j < activetable.getRowCount(); i++, j++) {
					Cell cell = activetable.getCellByPosition(i, j);
					System.out.println("cell.getDisplayText()=" + cell.getDisplayText());
				}
			} else {
				System.out.println(activetable.getTableName());
				System.out.println("activetable.getHeaderColumnCount()=" + activetable.getHeaderColumnCount());
				System.out.println("activetable.getColumnCount()=" + activetable.getColumnCount());
				System.out.println("activetable.getRowCount()=" + activetable.getRowCount());
			}

		} else {
			System.out.println("ods_file.exists()=" + getods_file().exists());
		}
	}

	public void print_all_cell() throws Exception {
		if (getods_file().exists()) {

			SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
			// beging from zero
			Table activetable = spreadsheetDocument.getSheetByIndex(0);

			for (int i = 0, j = 0; i < activetable.getColumnCount() || j < activetable.getRowCount(); i++, j++) {
				Cell cell = activetable.getCellByPosition(i, j);
				System.out.println("cell.getDisplayText()=" + cell.getDisplayText());
			}
			System.out.println(activetable.getTableName());
			System.out.println("activetable.getHeaderColumnCount()=" + activetable.getHeaderColumnCount());
			System.out.println("activetable.getColumnCount()=" + activetable.getColumnCount());
			System.out.println("activetable.getRowCount()=" + activetable.getRowCount());

		} else {
			System.out.println("ods_file.exists()=" + getods_file().exists());
		}
	}

	public void print_cell(int colindex, int rowindex) throws Exception {
		if (getods_file().exists()) {

			SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
			// beging from zero
			Table activetable = spreadsheetDocument.getSheetByIndex(0);

			Cell cell = activetable.getCellByPosition(colindex, rowindex);
			System.out.println("cell.getDisplayText()=" + cell.getDisplayText());
			System.out.println(activetable.getTableName());

		} else {
			System.out.println("ods_file.exists()=" + getods_file().exists());
		}
	}

	public ArrayList<Cell> all_data(int index_of_shhet) throws Exception {
		File file = getods_file();
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(file);
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_shhet);
		ArrayList<Cell> arrayList = new ArrayList<Cell>();
		for (int i = 0, j = 0; i < activetable.getColumnCount() || j < activetable.getRowCount(); i++, j++) {
			Cell cell = activetable.getCellByPosition(i, j);
			// System.out.println("cell.getDisplayText()=" + cell.getDisplayText());
			arrayList.add(cell);
		}
		return arrayList;
	}

	public ArrayList<Cell> all_data() throws Exception {
		File file = getods_file();
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(file);
		Table activetable = spreadsheetDocument.getSheetByIndex(0);
		ArrayList<Cell> arrayList = new ArrayList<Cell>();
		for (int i = 0, j = 0; i < activetable.getColumnCount() || j < activetable.getRowCount(); i++, j++) {
			Cell cell = activetable.getCellByPosition(i, j);
			// System.out.println("cell.getDisplayText()=" + cell.getDisplayText());
			arrayList.add(cell);
		}
		return arrayList;
	}

	public void copydata(int Sheetindex_startfrom0_containtable, int startcol, int startrow, int endcol, int endrow,
			String newSheetname, String filename) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(this.getods_file());
		Table table = spreadsheetDocument.getSheetByIndex(Sheetindex_startfrom0_containtable);
		CellRange dataCellRange = table.getCellRangeByPosition(startcol, startrow, endcol, endrow);
		spreadsheetDocument.appendSheet(newSheetname);
		Table activeTable = spreadsheetDocument.getSheetByName(newSheetname);

		for (int row = 0; row < dataCellRange.getRowNumber(); row++) {
			for (int col = 0; col < dataCellRange.getColumnNumber(); col++) {
				activeTable.getCellByPosition(col, row)
						.setDisplayText(table.getCellByPosition(col, row).getDisplayText());
			}
		}
		spreadsheetDocument.save(filename);
		System.out.println("finish~!");

	}

	public SpreadsheetDocument spreadsheetDocument_object() throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		return spreadsheetDocument;
	}

	public void addtable(boolean isremove_first_sheet, File output_file, Table referenceTable, String name_of_new_sheet)
			throws Exception {

		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		spreadsheetDocument.appendSheet(referenceTable, name_of_new_sheet);
		if (isremove_first_sheet) {
			spreadsheetDocument.removeSheet(0);
		}
		spreadsheetDocument.save(output_file);
	}

	public void addtable(boolean isremove_first_sheet, String output_file_string, Table referenceTable,
			String name_of_new_sheet) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		File output_file = new File(output_file_string);
		spreadsheetDocument.appendSheet(referenceTable, name_of_new_sheet);
		if (isremove_first_sheet) {
			spreadsheetDocument.removeSheet(0);
		}
		spreadsheetDocument.save(output_file);
	}

	public void remove_cell(int index_of_sheet, int startcolumnIndex, int deleteColumnCount, int startrowIndex,
			int deleterowCount, File outputFile) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_sheet);
		activetable.removeColumnsByIndex(startcolumnIndex, deleteColumnCount);
		activetable.removeRowsByIndex(startrowIndex, deleterowCount);
		spreadsheetDocument.save(outputFile);
	}

	public void remove_cell(int index_of_sheet, int startcolumnIndex, int deleteColumnCount, int startrowIndex,
			int deleterowCount, String outputfile) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_sheet);
		activetable.removeColumnsByIndex(startcolumnIndex, deleteColumnCount);
		activetable.removeRowsByIndex(startrowIndex, deleterowCount);
		File file = new File(outputfile);
		spreadsheetDocument.save(file);
	}

	public void remove_column(int index_of_sheet_start_from0, int startcolumnIndex, int deleteColumnCount,
			String outputFilestring) throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_sheet_start_from0);
		activetable.removeColumnsByIndex(startcolumnIndex, deleteColumnCount);
		File file = new File(outputFilestring);
		spreadsheetDocument.save(file);
		System.out.println("finished");
	}

	public void remove_column(int index_of_sheet_start_from0, int startcolumnIndex, int deleteColumnCount, File file)
			throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_sheet_start_from0);
		activetable.removeColumnsByIndex(startcolumnIndex, deleteColumnCount);
		spreadsheetDocument.save(file);
		System.out.println("finished");
	}

	public void remove_row(int index_of_sheet, int startrowindex, int deleterowCount, String outputFilestring)
			throws Exception {
		SpreadsheetDocument spreadsheetDocument = SpreadsheetDocument.loadDocument(getods_file());
		Table activetable = spreadsheetDocument.getSheetByIndex(index_of_sheet);
		activetable.removeColumnsByIndex(startrowindex, deleterowCount);
		File file = new File(outputFilestring);
		spreadsheetDocument.save(file);
		System.out.println("finished");
	}

}
