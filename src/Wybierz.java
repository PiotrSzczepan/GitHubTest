import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import java.util.ArrayList;
import java.util.List;

public class Wybierz {
	
	static Scanner MainInput = new Scanner(System.in);
	static String imiona;
	static List<String> ListaImion = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		ListaImion.add("Adam Ma�ysz");
		ListaImion.add("Piotr Szczepa�ski");
		ListaImion.add("Adam Boro�");
		MenuImion();
	}

	public static void MenuImion()
	{
		System.out.println("######################");
		System.out.println("LISTA IMION: ");
		int k = 0;
		for(int i=0; i<ListaImion.size(); i++)
		{
			k += 1;
			System.out.println(k + ". " + ListaImion.get(i));
		}
		System.out.println("######################");
		System.out.println("1. Wybierz");
		System.out.println("2. Dodaj");
		System.out.println("3. Usu�");
		//Scanner input = new Scanner(System.in);
		int c = MainInput.nextInt();
		switch(c)
		{
		case 1:
			int nr = -1;
			while(nr<0 || nr>ListaImion.size()-1)
			{
				System.out.println("Podaj nr: ");
				nr = MainInput.nextInt();
			}
			Menu menu = new Menu(nr-1);
			break;
		case 2:
			System.out.println("Podaj Imie i nazwisko");
			String tekst = MainInput.nextLine(); // tutaj
			ListaImion.add(tekst);
			MenuImion();
			break;
		case 3:
			System.out.println("Podaj numer kt�ry chcesz usun�� ");
			try {
				ListaImion.remove(MainInput.nextInt()-1);				// Jak zabezpieczy� int przed przyjeciem liter np. "abc"?
			}
			catch(Exception e){
				System.out.println("Numer ktory podales nie istnieje w liscie!");
			}
			MenuImion();
			break;
		}
		
	}
	

	
}
