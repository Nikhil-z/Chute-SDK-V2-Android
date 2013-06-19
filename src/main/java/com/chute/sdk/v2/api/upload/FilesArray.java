package com.chute.sdk.v2.api.upload;

import java.util.ArrayList;

public class FilesArray {

	private ArrayList<String> chutes;
	private ArrayList<FileObject> files;

	public ArrayList<String> getChutes() {
		return chutes;
	}

	public void setChutes(ArrayList<String> chutes) {
		this.chutes = chutes;
	}

	public ArrayList<FileObject> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<FileObject> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FilesArray [chutes=" + chutes + ", files=" + files + "]";
	}

}
