
package proyecto;

import java.awt.TextArea;

public class clsCompras {
    clsFunciones clsF = new clsFunciones();
    //Medicamentos 
    
    categoriaDeMedicamentos cantidadMeds[] = new categoriaDeMedicamentos [0];
    categoriaDeMedicamentos catM= new categoriaDeMedicamentos();
   
    //Clientes
    
    clsCliente cliente[] = new clsCliente[0];
    clsCliente clsC = new clsCliente();
    
    public void menuCompras(){
         boolean generarCateg = false, llenarCateg =false;
        char opcion = ' ';
        do {
            opcion = clsF.recibeChar("Seleccione la opcion que desea:\n "
                    + "A. Mostrar catalogo.\n"  
                    + "B. Comprar medicamento.\n"
                    + "S. Salir");
            
            switch(opcion){
                case 'A':
                        catM.mostrarInfo(cantidadMeds, opcion);
                    break;
                case 'B':
                    
                    break;
                case 'S':
                    clsF.imprimeMensaje("Saliendo al menu de cliente");
                    break;
                default:
                    clsF.imprimeMensaje("Opcion Invalida, seleccione nuevamente.");                    
                    
            }
        } while (opcion!='S');
        
    }
}

    
    
