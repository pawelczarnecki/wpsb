package praca;

import java.io.File;

import javax.swing.DefaultListModel;

public class FilesInLocation {
	public DefaultListModel<String> getFilesInLocation() {
		try {
			DefaultListModel<String> listModel = new DefaultListModel<>();
			File f = new File("dane/anteny");
			for (String path : f.list()) {
				listModel.addElement(path);
			}
			return listModel;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}