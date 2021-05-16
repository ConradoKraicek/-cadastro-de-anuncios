package projetoCapgemini;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Calculadora {
	
	private static Anuncio anuncio = new Anuncio();
	
	private static List<Anuncio> anuncios = new ArrayList<>();

	public static void menu() throws ParseException{
		Scanner entrada = new Scanner(System.in);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome de seu an�ncio:");
		anuncio.setNome(entrada.next());
		
		System.out.print("Nome do cliente:");
		anuncio.setCliente(entrada.next());
		
		System.out.print("Data que deseja iniciar[dd/MM/yyyy]:");
		anuncio.setDataDeInicio(df.parse(entrada.next()));
		
		System.out.print("At� que Data deseja iniciar [dd/MM/yyyy]:");
		anuncio.setDataDeTermino(df.parse(entrada.next()));
		
		System.out.print("Deseja investir quanto por dia:");
		anuncio.setInvestimentoPorDia(entrada.nextInt());
		
		anuncios.add(anuncio);
		
		System.out.println("---------------------------------------------");
		
        System.out.println("Digite [1] para cadastrar outro an�ncio.");
        System.out.println("Digite [2] para gerar os relat�rios dos an�ncios cadastrados.");
        System.out.println("Opcao:");
    }

    public static void inclui() throws ParseException{
    	 menu();
    }
    
    public static void gerar_relatorio() throws ParseException{
        System.out.println("Deseja filtrar os relat�rios por:");
        System.out.println("[1] CLIENTE");
        System.out.println("[2] DATA");
        
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
            	filtrarCliente();
                break;
                
            case 2:
            	filtrarData();
                break;                
            
            }
        } while(opcao == 0);
        
    }
    
    public static void filtrarCliente(){
    	List<Anuncio> anuncioFiltrado = new ArrayList<>();
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Nome que deseja iniciar a filtragem:");
    	String anuncioNome = entrada.next();
    	for (Anuncio anuncio : anuncios) {
			if (anuncio.getCliente().equals(anuncioNome)) {
				anuncioFiltrado.add(anuncio);
			}
		}
    	
    	for (Anuncio anuncio : anuncioFiltrado) {
    		anuncio.getVisualizacoesAnucio(anuncio.getInvestimentoPorDia());
			System.out.println("-------------------------------");
		}
   }
    
    public static void filtrarData() throws ParseException{
    	List<Anuncio> anuncioFiltrado = new ArrayList<>();
    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Data que deseja iniciar a filtragem: [dd/MM/yyyy]");
    	Date dataInicial = df.parse(entrada.next());
    	System.out.println("At� a data: [dd/MM/yyyy]");
    	Date dataFinal = df.parse(entrada.next());
    	for (Anuncio anuncio : anuncios) {
			if (anuncio.getDataDeInicio().after(dataInicial) && anuncio.getDataDeTermino().before(dataFinal)) {
				anuncioFiltrado.add(anuncio);
			}
		}
    	
    	for (Anuncio anuncio : anuncioFiltrado) {
    		anuncio.getVisualizacoesAnucio(anuncio.getInvestimentoPorDia());
			System.out.println("-------------------------------");
		}
   } 
    
    
    public static void main(String[] args) throws ParseException {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                inclui();
                break;
                
            case 2:
                gerar_relatorio();
                break;
                
            default:
                System.out.println("Op��o inv�lida.");
            }
        } while(opcao == 0);
    }
}
