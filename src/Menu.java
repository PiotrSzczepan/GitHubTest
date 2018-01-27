import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class Menu {


	Console konsola;
	String imieOryg;
	String imie;
	String info;
	boolean infobool = false;
	Scanner input;
	
 	public Menu(String i)
	{
		imie = new String(i);
		imieOryg = new String();
		imieOryg = i;
		input = new Scanner(System.in);
		WyswietlMenu();
		
	}
	
	public void WyswietlMenu()
	{
//		konsola.
		System.out.println("######################################");
		if(infobool) 
			{
			System.out.println(info);
			infobool = false;
			}
		System.out.println("######################################");
		System.out.println("Oryginalne imie: " + imieOryg);
		System.out.println("Obecne: " + imie);
		System.out.println("	### MENU ###	");
		System.out.println("1. Zmien	");
		System.out.println("2. Wyswietl samo nazwisko ");
		System.out.println("3. Wyswietl samo imie ");
		System.out.println("4. Obróæ imie i/lub nazwisko");
		System.out.println("5. losuj kolejnosc liter");
		System.out.println("6. Dodaj Litery");
		System.out.println("7. Wróæ");
		switch(input.nextInt())
		{
		case 1: Zmien();
		break;
		case 2: WyswietlNazwisko();
		break;
		case 3: WyswietlImie();
		break;
		case 4: WypiszOdwrotnie();
		break;
		case 5: LosujKolejnosc();
		break;
		case 6: DodajLitery();
		break;
		case 7: Wybierz.MenuImion();
		break;
		default: WyswietlMenu();
		}
	}
	
	
	private void Zmien()
	{ 
		System.out.println("Podaj nowe imie: ");
		Scanner skan = new Scanner(System.in);
		imieOryg = new String(skan.nextLine());
		imie = new String(imieOryg);
		info = "Imie zmienione pomyœlnie!";
		infobool = true;
		WyswietlMenu();
	}
	private void WyswietlImie()
	{
		if(imieOryg.indexOf(" ") == -1 || imieOryg.indexOf(" ") == 0)  
		{
		}
		else 
		{
			imie = new String(imieOryg.substring(0,imieOryg.indexOf(" ")));
		} 
		WyswietlMenu();
	}
	private void WyswietlNazwisko()
	{
		if(imieOryg.indexOf(" ") == -1)  
		{
			info = "Nie podales nazwiska!";
			infobool = true;
		}
		else 
		{
			imie = new String(imieOryg.substring(imieOryg.indexOf(" ")+1));
		} 
		WyswietlMenu();
	}
	private void WypiszOdwrotnie()
	{
		int i = 0;
		int l = imie.length() - 1;
		char[] chars = imie.toCharArray();
		while(i<l)
		{
			char temp = chars[i];
			chars[i] = chars[l];
			chars[l] = temp;
			i++;
			l--;
		}
		imie = String.valueOf(chars);
		WyswietlMenu();
	}
	private void LosujKolejnosc()
	{
		Random generator = new Random();
		int l = imie.length();
		char[] chars = imie.toCharArray();
		char[] newchar = new char[l];
		for(int i=0; i<=l-1; i++)
		{
			//if(chars[i] == ' ') newchar[i] = chars[i];
			 newchar[i] = '0';
		}
		for(int i=0; i<=l-1; i++)
		{
			do {
				int r = generator.nextInt(l);
				if(newchar[r] == '0')
				{
				newchar[r] = chars[i];
				break;
				}
			}while(true);
		}
		imie = String.valueOf(newchar);
		WyswietlMenu();
	}
	private void DodajLitery()
	{
		int sum = 0;
		info = "";
		char[] chars = imie.toCharArray();
		for(int i=0; i< imie.length(); i++)
		{
			sum += (int)chars[i];
			if(i==imie.length()-1)
			{
				info += chars[i] +"("+(int)chars[i]+") = "+ sum;
			}
			else info += chars[i] +"("+(int)chars[i]+")+";
		}
		infobool = true;
		WyswietlMenu();
	}
}
