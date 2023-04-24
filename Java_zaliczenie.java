
package java_zaliczenie;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.UTFDataFormatException;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Java_zaliczenie {

  
    public static void main(String[] args) {
        Scanner tekst = new Scanner(System.in);
            try{
            System.out.println("Witam, na której bazie dzialamy? \n 1: Domyslnej \n 2: Importowana\n"); 
                 File plik;
                 if(tekst.nextLine().equals("1")){
                  plik = new File("Baza.csv");    
                } else {
                  System.out.println("Podaj nazwe bazy: ");
                 String plik_tekst = tekst.nextLine();  
                  plik = new File(plik_tekst+".csv");  
                }     
                      FileReader fr = new FileReader(plik);        
                      BufferedReader br = new BufferedReader(fr); 
                      String line;
                      String wartosci="";
                      while( (line= br.readLine())!=null){
                          wartosci +=line;
                          String[] values=line.split(";"); //wypisywanie
                          for(String index : values){                           
                              System.out.printf("%-70s",index);
                          } 
                          System.out.println();
                      }         
                                 String[] Tablica_0= wartosci.split(";");    //przypomnienie o wygazniesiu  
                                 System.out.println("\nPrzypomnienie o wygasnieciu karty: ");   
                                 int i =13; 
                                    do{
                                    System.out.println(Tablica_0[i-2] + " " + Tablica_0[i-1] + ", Data: " + Tablica_0[i]);
                                    i +=11;
                                    }while(i<Tablica_0.length);
                      System.out.println("\n Co chcesz zrobić z danymi(wybrać numer):\n 1:Dodać dane\n 2:Wyszukaj szczegolne dane\n3:Eksport danych\n4:Eksport danych(SQL)");                                
                      switch (tekst.nextLine()){
                               case "1":
                                    FileWriter fw = new FileWriter(plik,true);        
                                    BufferedWriter bw = new BufferedWriter(fw); 
                                    System.out.println("Prosze Podać następujące dane: \n Imie;Nazwisko;Data koncowa;Numer karty;Rodzaj karty;Umowa Nr;Numer seryjny certyfikatu;Telefon kontaktowy;Adres e-mail;Status;Uwagi");                                                       
                                    System.out.println("Imie: "); //wpisywanie danych do pliku
                                     String pattern_imie ="^[A-Z][a-z]*$";
                                    String imie = tekst.nextLine();
                                    do{
                                        if(Pattern.matches(pattern_imie, imie)) {
                                        bw.write("\r\n" +imie+ ";" );
                                        break;
                                        }else{
                                        imie = tekst.nextLine();
                                        }
                                    } while(true);
                                    System.out.println("Nazwisko: "); 
                                    String pattern_nazwisko ="^[A-Z][a-z]*$";
                                    String nazwisko = tekst.nextLine();
                                    do{
                                        if(Pattern.matches(pattern_nazwisko, nazwisko)) {
                                        bw.write(nazwisko+ ";" );
                                        break;
                                        }else{
                                        nazwisko = tekst.nextLine();
                                        }
                                    } while(true);
                                    System.out.println("Data koncowa(dd.MM.yyyy): ");  //data
                                    String pattern_date ="^\\d{2}\\p{Punct}\\d{2}\\p{Punct}\\d{4}$"; 
                                    String date = tekst.nextLine();
                                    do{
                                        if(Pattern.matches(pattern_date, date)) {
                                        bw.write(date+ ";" );
                                        break;
                                        }else{
                                        date = tekst.nextLine();
                                        }
                                    } while(true);
                                    System.out.println("Nr Karty(16 cyfr): ");  //nr karty
                                    String pattern_Karta ="^\\d{16}$"; 
                                    String Karta = tekst.nextLine();
                                    do{
                                        if(Pattern.matches(pattern_Karta, Karta)) {
                                        bw.write(Karta+ ";" );
                                        break;
                                        }else{
                                        Karta = tekst.nextLine();
                                        }
                                    } while(true);
                                    System.out.println("Prosze Podać Rodzaj Karty(wybrać numer):\n1:fizyczna\n2:wirtualna\n3:inna"); //rodzaj karty
                                        switch(tekst.nextLine()){
                                            case "1":
                                                bw.write("fizyczna"+ ";" );
                                                break;
                                            case "2":
                                                bw.write("wirtualna"+ ";" );
                                                break;
                                            case "3":
                                                bw.write("inna"+ ";" );
                                                break;
                                            default:
                                              bw.write("fizyczna"+ ";" );  
                                              break;
                                        }
                                        System.out.println("Umowa nr: ");  //umowa
                                        String pattern_Umowa ="^\\d{1,}$"; 
                                        String Umowa = tekst.nextLine();
                                        do{
                                            if(Pattern.matches(pattern_Umowa, Umowa)) {
                                            bw.write(Umowa+ ";" );
                                            break;
                                            }else{
                                            Umowa = tekst.nextLine();
                                            }
                                        } while(true);
                                        System.out.println("Numer Seryjny(przynajmniej 10 znakow): "); //numer seryjny
                                         String pattern_Numer ="^.{10,}$"; 
                                        String Numer = tekst.nextLine();
                                        do{
                                            if(Pattern.matches(pattern_Numer, Numer)) {
                                            bw.write(Numer+ ";" );
                                            break;
                                            }else{
                                            Numer = tekst.nextLine();
                                            }
                                        } while(true);
                                        System.out.println("Telefon kontaktowy(48xxxxxxxxx): "); //telefon
                                        String pattern_Telefon ="^48\\d{9}$"; 
                                        String Telefon = tekst.nextLine();
                                        do{
                                            if(Pattern.matches(pattern_Telefon, Telefon)) {
                                            bw.write(Telefon+ ";" );
                                            break;
                                            }else{
                                            Telefon = tekst.nextLine();
                                            }
                                        } while(true);
                                        System.out.println("Adres e-mail: "); //e-mail
                                        String pattern_Adres ="^(.+)@(.+)$"; 
                                        String Adres = tekst.nextLine();
                                        do{
                                            if(Pattern.matches(pattern_Adres, Adres)) {
                                            bw.write(Adres+ ";" );
                                            break;
                                            }else{
                                            Adres = tekst.nextLine();
                                            }
                                        } while(true);
                                        System.out.println("Prosze Podać Status(wybrać numer):\n 1:nowy\n2:proforma wysłana\n3:zapłacone\n4:wygasł\n5:odnowiony\n6:inny");
                                        switch(tekst.nextLine()){
                                            case "1":
                                                bw.write("nowy"+ ";" );
                                                break;
                                            case "2":
                                                bw.write("proforma wysłana"+ ";" );
                                                break;
                                            case "3":
                                                bw.write("zapłacone"+ ";" );
                                                break;
                                            case "4":
                                                bw.write("wygasł"+ ";" );
                                                break;
                                            case "5":
                                                bw.write("odnowiony"+ ";" );
                                                break;
                                            case "6":
                                                bw.write("inny"+ ";" );
                                                break; 
                                            default:
                                              bw.write("nowy"+ ";" );  
                                              break;
                                        }
                                        System.out.println("Uwagi(wpisz -, jesli brak uwag): ");
                                        String pattern_Uwagi ="^.{1,1000}$"; //minimum 1 do 1000
                                        String Uwagi = tekst.nextLine();
                                        do{
                                            if(Pattern.matches(pattern_Uwagi, Uwagi)) {
                                            bw.write(Uwagi+ ";" );
                                            break;
                                            }else{
                                            Uwagi = tekst.nextLine();
                                            }
                                        } while(true);
                                    bw.close();
                                    fw.close();                                 
                                  break;                      
                               case "2":  
                                   System.out.println("Wyszukaj dane po numerze karty:\n ");
                                   String Numer_kart=tekst.nextLine();
                                   String[] Tablica= wartosci.split(";");                               
                                   for(int j=0;j<Tablica.length;j++){
                                       if(Tablica[j].equals(Numer_kart)){     
                                           System.out.println("Imie: "+Tablica[j-3]);
                                           System.out.println("Nazwisko: "+Tablica[j-2]);
                                           System.out.println("Data koncowa: "+Tablica[j-1]);
                                           System.out.println("Numer karty: "+Tablica[j]);
                                           System.out.println("Rodzaj karty: "+Tablica[j+1]);
                                           System.out.println("Umowa Nr: "+Tablica[j+2]);
                                           System.out.println("Numer seryjny certyfikatu: "+Tablica[j+3]);
                                           System.out.println("Telefon kontaktowy: "+Tablica[j+4]);
                                           System.out.println("Adres e-mail: "+Tablica[j+5]); 
                                           System.out.println("Status: "+Tablica[j+6]);
                                           System.out.println("Uwagi: "+Tablica[j+7]);
                                       }
                                   }
                                   break;
                               case "3":
                               System.out.println("Nazwa pliku do eksportu danych do .csv: ");                  
                               String Plik_Eksport =tekst.nextLine();
                              DataOutputStream Eksport=new DataOutputStream(new FileOutputStream(Plik_Eksport+".csv"));
                              for(int x=0;x<Tablica_0.length;x++){
                                   if(x%11==0 && x>0){
                                   Eksport.writeChars("\n");
                                   }
                                   Eksport.writeChars(Tablica_0[x]+";");
                                   Eksport.flush();
                                 }
                             break;
                             case "4":
                               System.out.println("Nazwa pliku do eksportu danych do .sql: ");                  
                               String Plik_Eksport_sql =tekst.nextLine();
                              DataOutputStream Eksport_1=new DataOutputStream(new FileOutputStream(Plik_Eksport_sql+".sql"));
                              for(int x=0;x<Tablica_0.length;x++){
                                   if(x%11==0 && x>0){
                                   Eksport_1.writeChars("\n");
                                   }
                                   Eksport_1.writeChars(Tablica_0[x]+";");
                                   Eksport_1.flush();
                                 } 
                              break;
                           } 
                              
            } 
            catch (FileNotFoundException ex) { System.err.println("Nie mogę zrealizować dostępu do pliku...");}
            catch (IOException ex) {System.err.println("Błąd zapisu..."); }
            catch (PatternSyntaxException ex) {System.err.println("wprowadzono złe dane...");}
    }
    
}
