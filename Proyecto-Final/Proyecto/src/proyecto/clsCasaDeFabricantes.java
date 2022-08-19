
package proyecto;
import java.awt.TextArea;

public class clsCasaDeFabricantes {
    
    private String nombreDeCasaComercial;
    private String paisDeOrigen; 
    //clsCasaDeFabricantes casasF[]= new clsCasaDeFabricantes [0];
    
    clsFunciones clsF = new clsFunciones();
    

    public clsCasaDeFabricantes(String nombreDeCasaComercial, String paisDeOrigen){
        this.nombreDeCasaComercial = nombreDeCasaComercial;
        this.paisDeOrigen = paisDeOrigen;
   
    }
    public clsCasaDeFabricantes(){    
    }

    public String getNombreDeCasaComercial() {
        return nombreDeCasaComercial;
    }

    public void setNombreDeCasaComercial(String nombreDeCasaComercial) {
        this.nombreDeCasaComercial = nombreDeCasaComercial;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }
                
     
        
        
    public clsCasaDeFabricantes[] agregarCasaComercial() {
        int cantidad = clsF.recibeInt("Digite la cantidad de casas de Fabricantes que desea agregar: ");
        clsCasaDeFabricantes casasF[] = new clsCasaDeFabricantes[cantidad];
        return casasF;
    }
    public boolean infoFabricantes(clsCasaDeFabricantes casasF[], int cantidad){
        String nombreDeCasaComercial = clsF.recibeString("Digite el nombre del fabricante: ");
        String paisDeOrigen = clsF.recibeString("Digite el pais de origen del Fabricante: ");
        
        clsCasaDeFabricantes casaAgregada = new clsCasaDeFabricantes(nombreDeCasaComercial,paisDeOrigen);
        casasF[cantidad] = casaAgregada;
        
        return true;
    }
    
    public void mostrarFabricantesCasas(clsCasaDeFabricantes casasF[], int cantidad) {
        String mostrar = "Fabricante\tPais de Origen\n";
        for (int i = 0; i < cantidad; i++) {
            clsCasaDeFabricantes clsCF = casasF[i];
            if(clsCF!=null){
                mostrar += clsCF.getNombreDeCasaComercial()+"\t"+clsCF.getPaisDeOrigen()+"\n";
            }    
        }   
        clsF.imprimeMensaje(new TextArea(mostrar));
    }

    public int editarInfo(clsCasaDeFabricantes casasF[], int cantidad){
        String buscarFabricante = clsF.recibeString("Digite el nombre del Fabricante que desea editar: ");
        int posicionF= -1;
        for (int i = 0; i < cantidad; i++) {
            if (casasF[i].getNombreDeCasaComercial().equalsIgnoreCase(buscarFabricante)) {
                posicionF = i;
                break;
            }
            
        }
        if (posicionF == -1){
            return 2; 
            
        } else{
            char opcion = ' ';
            
            do {
                opcion = clsF.recibeChar("Seleccione la opcion que quiere editar:\n"
                        + "A. Nombre del Fabricante\n"
                        + "B. Pais De Origen del Fabricante\n"
                        + "S. Salir");
                
                switch(opcion){
                    case 'A':
                        casasF[posicionF].setNombreDeCasaComercial(clsF.recibeString("Digite el nuevo nombre del fabricante: "));
                        break;
                    case 'B':
                        casasF[posicionF].setPaisDeOrigen(clsF.recibeString("Digite el nuevo pais de origen: "));
                        break;
                    case 'S':
                        break;
                    default:
                        clsF.imprimeMensaje("Opcion incorrecta. Digite la opcion nuevamente.");
                        
                }
            } while (opcion!='S');
        
        }
        return 1;
    }
    public String existeCasas(clsCasaDeFabricantes casasF[],int cantC){
        String buscarCasa = clsF.recibeString("Digite el nombre del usuario que desea buscar:");
        int poscBuscar = -1;
        
        for (int i = 0; i < cantC; i++){
            if(casasF[i].getNombreDeCasaComercial().equalsIgnoreCase(buscarCasa)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar == -1){
            buscarCasa="";
            
        }
        return buscarCasa;
        
    }
    public clsCasaDeFabricantes[] inactivarInfo(clsCasaDeFabricantes casasF[], int cantC, String buscarCasa ){
        int poscBuscar = -1;
        //1
        clsCasaDeFabricantes[] casasActualizadas = casasF;
        for (int i = 0; i < cantC; i++){
            if(casasF[i].getNombreDeCasaComercial().equalsIgnoreCase(buscarCasa)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar!= -1){
            for(int i= poscBuscar; i < cantC-1; i++){
                casasF[i] = casasF[i+1];
            }
            casasF[cantC-1] = null;
            
            casasActualizadas = casasF;
        }                
        return casasActualizadas;
    
    }
    @Override
    public String toString() {
        return nombreDeCasaComercial + "\t\t" + paisDeOrigen + "\t" ;
    }

    
    
    
    
    
}
