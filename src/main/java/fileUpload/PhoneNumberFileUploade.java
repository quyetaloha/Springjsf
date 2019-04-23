package fileUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.sun.faces.facelets.util.Path;

import entity.Phonenumber;
import entityDaoImpl.PhonenumberHome;

@ManagedBean(name = "phoneNumberFileUploade")
public class PhoneNumberFileUploade {
	private UploadedFile file;

	PhonenumberHome phonenumberHome = new PhonenumberHome();

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		System.out.println("in file.upload()");
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful" + file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/*
	 * public String insertNumbers() { try (InputStream input =
	 * file.getInputstream()) {
	 * 
	 * FileInputStream fileInputStream = (FileInputStream) file.getInputstream();
	 * Scanner sc = new Scanner(fileInputStream); ArrayList<String> phones = new
	 * ArrayList<String>(); while (sc.hasNext()) { String word = sc.next();
	 * 
	 * phones.add(word); } phonenumberHome.them(phones);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * return null;
	 * 
	 * File hi=new File(
	 * "G:\\eclipse-workspace\\FtuTask\\src\\main\\webapp\\resources\\FileUpload",
	 * fileName); System.out.println(hi.getAbsolutePath()); Files.copy(input,
	 * hi.toPath()); System.out.println(hi.getAbsolutePath());
	 * 
	 * 
	 * 
	 * try (BufferedReader br = new BufferedReader(new FileReader(
	 * "G:\\eclipse-workspace\\FtuTask\\src\\main\\webapp\\resources\\FileUpload\\"+
	 * fileName))) { String sCurrentLine;
	 * 
	 * while ((sCurrentLine = br.readLine()) != null) {
	 * System.out.println(sCurrentLine); }
	 * 
	 * 
	 * 
	 * FileInputStream fileInputStream=(FileInputStream) file.getInputstream(); int
	 * content; while ((content = fileInputStream.read()) != -1) { // convert to
	 * char and display it System.out.print((char) content); }
	 * 
	 * }
	 */

	public String insertNumbers() {
		phonenumberHome.them(file);
		FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
}
