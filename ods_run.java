package my_tool;

import java.io.File;

public class run {

	public static void main(String[] args) {
		try {
			File file = new File("path\\t.txt");
			Printinfo_ods printinfo_ods = new Printinfo_ods();
			printinfo_ods.setods_file(file);
			printinfo_ods.print_base_info();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
