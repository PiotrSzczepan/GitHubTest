import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Wybierz {
	
	static Scanner MainInput = new Scanner(System.in);
	static String imiona;
	static List<String> ListaImion = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		ListaImion.add("Adam Malysz");
		ListaImion.add("Piotr Szczepanski");
		ListaImion.add("Adam Boron");
		ListaImion.add("Lukasz Kluczkowski");
		ListaImion.add("Magda Podolak");
		MenuImion();
	}
	
	public static int SprawdzZmienna()
	{
		try 
		{
			return MainInput.nextInt();
		}
		catch (InputMismatchException exception) 
		{ 
		    System.out.println("Podaj Tylko liczbe calkowita"); 
		    MainInput.nextLine();
		    return SprawdzZmienna();
		} 
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
		System.out.println("3. Usun");
		System.out.println("4. Wyjdz");
		
		switch(SprawdzZmienna())
		{
		case 1:
			int nr = -1;
			while(nr<0 || nr>ListaImion.size())
			{
				System.out.println("Podaj nr: ");
				nr = SprawdzZmienna();
			}
			new Menu(nr-1);
			break;
		case 2:
			System.out.println("Podaj Imie i nazwisko");
			ListaImion.add(MainInput.nextLine());
			MenuImion();
			break;
		case 3:
			System.out.println("Podaj numer ktory chcesz usunac ");
			try {
				ListaImion.remove(SprawdzZmienna()-1);				
			}
			catch(Exception e){
				System.out.println("Numer ktory podales nie istnieje w liscie!");
			}
			MenuImion();
			break;
		case 4: 
			System.exit(0);
			break;
		default: 
			MenuImion();
		}
		
		
	}
	

	
}
