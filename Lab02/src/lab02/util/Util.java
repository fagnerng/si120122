package lab02.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class Util {
	
	
	public static String getSmallTitle(String text, int maxNum){
		String temp = text;
		temp.replace("\n", " ");
		String[] tempArray = temp.split(" ");
		if (tempArray.length > maxNum) {
			temp  = tempArray[0];
			for(int  i = 1 ;i<maxNum; i++){
				temp += " " + tempArray[i];
			}
		}
		return temp;
	}
	
	public static int random(int maxValue){
		
		return (int) Math.ceil( ( Math.random() * maxValue ));
		
	}
	
	public static String listToString(List<String> lista){
		String temp = "";
		for (String string : lista) {
			temp += string +" ";	
		}
		return temp;
	}
	
	public static List<String> stringToList(String Texto){
		List<String> tempList = new ArrayList<String>();
		String[] tempString = Texto.split(" ");
		for (String string : tempString) {
			if (!tempList.contains(string)){
				tempList.add(string);
			}
		}
		return tempList;
	}
	
	public static void addMessagem(String messagem){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", messagem));
	}
}
