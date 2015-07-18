package praca;

import javax.swing.*;
import java.io.File;

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