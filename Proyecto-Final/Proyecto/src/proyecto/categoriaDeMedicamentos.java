
package proyecto;
import java.awt.TextArea;
import javax.swing.JOptionPane;
import static proyecto.clsMenus.totalDia;// import desde menu
import java.time.LocalDate;
import java.time.LocalTime;

public class categoriaDeMedicamentos {
    
    public String nombreDelMedicamento;
    public String nombreDeCategoria;
    public String caracteristicasMedicamento;
    public int precio;
    public int cantidadExistente;
    public String fechaVencimiento; 
    
    //categoriaDeMedicamentos cantidadMeds[] = new categoriaDeMedicamentos[0];
    
    clsFunciones clsF = new clsFunciones();
    
    
    public categoriaDeMedicamentos (String nombreDelMedicamento,String nombreDeCategoria, String caracteristicasDelProducto, String fechaVencimiento, int precio, int cantidadExistente){
        this.nombreDelMedicamento = nombreDelMedicamento;
        this.nombreDeCategoria = nombreDeCategoria;
        this.caracteristicasMedicamento = caracteristicasDelProducto;   
        this.fechaVencimiento= fechaVencimiento;
        this.precio = precio;
        this.cantidadExistente = cantidadExistente;
    }
    public categoriaDeMedicamentos(){
        
    }

    public String getNombreDelMedicamento() {
        return nombreDelMedicamento;
    }

    public void setNombreDelMedicamento(String nombreDelMedicamento) {
        this.nombreDelMedicamento = nombreDelMedicamento;
    }

    public String getNombreDeCategoria() {
        return nombreDeCategoria;
    }

    public void setNombreDeCategoria(String nombreDeCategoria) {
        this.nombreDeCategoria = nombreDeCategoria;
    }

    public String getCaracteristicasMedicamento() {
        return caracteristicasMedicamento;
    }

    public void setCaracteristicasMedicamento(String caracteristicasMedicamento) {
        this.caracteristicasMedicamento = caracteristicasMedicamento;
    }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
        
    public categoriaDeMedicamentos[] agregarMedicamentos() {
        int cantidad = clsF.recibeInt("Digite la cantidad de medicamentos que desea agregar: ");
        categoriaDeMedicamentos cantidadMeds[] = new categoriaDeMedicamentos[cantidad];
        return cantidadMeds;
    }
    
    public boolean agregarInfoMeds(categoriaDeMedicamentos cantidadMeds[], int cantidad){
        
        String nombreDelMedicamento = clsF.recibeString("Digite el nombre del medicamento ");
        String caracteristicasMedicamento = clsF.recibeString("Ingrese las caracteristicas del medicamento\n"
                + "(Dolor de cabeza, cuerpo, garganta...)");
        String nombreDeCategoria = clsF.recibeString("Ingrese la categoria del medicamento(pastilla, jarabe...)");
        String fechaVencimiento = clsF.recibeString("Ingrese fecha de vencimiento en el siguiente formato "
                + "\n\t(anio-mes-dia) (xxxx-xx-xx)");
        precio = clsF.recibeInt("Ingrese el precio del medicamento");
        cantidadExistente = clsF.recibeInt("Ingrese la cantidad de este medicamento");
        
        
        categoriaDeMedicamentos medAgregado = new categoriaDeMedicamentos(nombreDelMedicamento,
                caracteristicasMedicamento,nombreDeCategoria,fechaVencimiento,precio,cantidadExistente);
        cantidadMeds[cantidad] = medAgregado;
        
       return true;
    }
    
    public int editarInfo(categoriaDeMedicamentos cantidadMeds[], int cantidad){                    
        String buscarMed = clsF.recibeString("Digite el nombre del Medicamento que desea editar: ");
        int posicion = -1;
        
        for (int i = 0; i < cantidad; i++) {
            if (cantidadMeds[i].getNombreDelMedicamento().equalsIgnoreCase(buscarMed)); 
                posicion = i;
                break;
            }
            
        if (posicion == -1){
            return 2;
            
        } else{
            char opcion = ' ';
            
            do {
                opcion = clsF.recibeChar("Seleccione la opcion que quiere editar:\n"
                        + "A. Nombre del medicamento\n"
                        + "B. Caracteristicas del medicamento\n"
                        + "C. Categoria del medicamento\n"
                        + "D. Cantidad Existente\n"
                        + "E. Precio\n"
                        + "F. Fecha de Vencimiento\n"
                        + "S. Salir");
                
                switch(opcion){
                    case 'A':
                        cantidadMeds[posicion].setNombreDelMedicamento(clsF.recibeString("Digite el nuevo nombre del medicamento:"));
                        break;
                    case 'B':
                        cantidadMeds[posicion].setCaracteristicasMedicamento(clsF.recibeString("Digite la nueva caracteristica del medicamento:"));
                        break;
                    case 'C':
                        cantidadMeds[posicion].setNombreDeCategoria(clsF.recibeString("Digite la nueva categoria del medicamento"));
                        break;
                    case 'D':
                        cantidadMeds[posicion].setCantidadExistente(clsF.recibeInt("Ingrese la nueva cantidad existente"));
                        break;
                    case 'E':
                        cantidadMeds[posicion].setPrecio(clsF.recibeInt("Digite el nuevo precio"));
                        break;
                    case 'F':
                        cantidadMeds[posicion].setFechaVencimiento(clsF.recibeString("Digite la nueva fecha de vencimiento"));
                        break;
                    case 'S':
                        break;
                    default:
                        clsF.imprimeMensaje("Opcion incorrecta. Digite la opcion nuevamente.");
                }
            } while (opcion!='S');
        return 1;    
        }
    }
    public String existeMedicamento(categoriaDeMedicamentos cantidadMeds[], int cantM){
        String buscarMedicamento = clsF.recibeString("Digite el nombre del medicamento que desea buscar:");
        int poscBuscar = -1;
        
        for (int i = 0; i < cantM; i++){
            if(cantidadMeds[i].getNombreDelMedicamento().equalsIgnoreCase(buscarMedicamento)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar == -1){
            buscarMedicamento="";
            
        }
        return buscarMedicamento;
        
    }
    public categoriaDeMedicamentos[] inactivarInfo(categoriaDeMedicamentos cantidadMeds[], int cantM, String buscarNombre){
        int poscBuscar = -1;
        categoriaDeMedicamentos[] medicamentosActualizados = cantidadMeds;
        for (int i = 0; i < cantM; i++){
            if(cantidadMeds[i].getNombreDelMedicamento().equalsIgnoreCase(buscarNombre)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar!= -1){
            for(int i= poscBuscar; i < cantM-1; i++){
                cantidadMeds[i] = cantidadMeds[i+1];
            }
            cantidadMeds[cantM-1] = null;
            
            medicamentosActualizados = cantidadMeds;
        }                
        return medicamentosActualizados;
    }
    public String toString() {
        return nombreDelMedicamento + "\t" + nombreDeCategoria + "\t" +caracteristicasMedicamento+ "\t\t" +fechaVencimiento +"\t\t" + precio+  "\t\t" + cantidadExistente ;
    }
    public void imprimirMedicamentos(categoriaDeMedicamentos cantidadMeds[], int cantidad) {
        String imprimir = "Nombre\tCaracteristicas\tCategoria\tFecha Vencimento\tPrecio\tCantidad\n";
        for (int i = 0; i < cantidad; i++) {
            categoriaDeMedicamentos tempMedicamento = cantidadMeds[i];
            if(tempMedicamento!=null){
                imprimir += tempMedicamento.getNombreDelMedicamento()+"\t"+tempMedicamento.getNombreDeCategoria()+"\t"+tempMedicamento.getCaracteristicasMedicamento()+"\t"+
                        tempMedicamento.getFechaVencimiento()+"\t"+tempMedicamento.precio+"\t"+tempMedicamento.cantidadExistente+"\n";
            }           
        }
        clsF.imprimeMensaje(new TextArea(imprimir));
        
    }
    public String toString2() {
        return nombreDelMedicamento + "\t "+ precio+  "\t" + cantidadExistente ;
    }
    
    public void mostrarInfo(categoriaDeMedicamentos cantidadMeds[], int cantidad){
        String imprimir = "Nombre\tPrecio\tCantidad\n";
        for (int i = 0; i < cantidad; i++) {
            categoriaDeMedicamentos temp = cantidadMeds[i];
            imprimir += cantidadMeds[i].toString2()+"\n";
        }
        clsF.imprimeMensaje(new TextArea(imprimir));
        
        
    }
    public void comprarMed(categoriaDeMedicamentos cantidadMeds[], int cantidad){
        categoriaDeMedicamentos catM= new categoriaDeMedicamentos();
        String buscarMed = clsF.recibeString("Ingrese el nombre del medicamento que desee comprar ");
        int cantCompra = 0;
        int posicion =-1;
        int precio =0;
        int cant=0;
        
        for (int i = 0; i < cantidad; i++) {
            if (cantidadMeds[i].getNombreDelMedicamento().equalsIgnoreCase(buscarMed)){
                
                posicion = i;
                precio= cantidadMeds[i].getPrecio();
                cant = cantidadMeds[i].getCantidadExistente();
                break;
            }   
        }
        do {
        cantCompra = clsF.recibeInt("Digite la cantidad de medicamentos que desea comprar :");
        
        
        } while (cantCompra<=cant);        
        int total = precio*cantCompra;
        LocalTime horaActual = LocalTime.now();
        LocalDate fechaActual = LocalDate.now();
        
        clsF.imprimeMensaje("                        *******FACTURA*******"
                + "\n                                                              "
                + "\nFARMACIA PASCAL          Factura emitida el dia "+fechaActual+""
                + "\n                                                              "
                + "\nSan Jose Costa Rica                a las "+horaActual+""
                + "\n                                                              "
                + "\n Medicamento comprado: "+buscarMed+" "
                + "\n Cantidad de medicamentos comprados: "+cantCompra
                + "\n                                                              "
                + "\nTotal a pagar  $"+total+" "
                + "\n****************************************************************");
        totalDia+= total;
    }
    

}
