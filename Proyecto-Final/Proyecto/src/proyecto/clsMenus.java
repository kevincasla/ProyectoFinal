
package proyecto;


public class clsMenus {
    clsFunciones clsF = new clsFunciones();
    
    //USUARIOS
    static clsUsuario usuarios[] = new clsUsuario[0];
    clsUsuario clsU = new clsUsuario();
    //CLIENTES
    static clsCliente cliente[] = new clsCliente[0];
    clsCliente clsC = new clsCliente();
    //CASAS
    static clsCasaDeFabricantes casasF[]= new clsCasaDeFabricantes [0];
    clsCasaDeFabricantes clsCF = new clsCasaDeFabricantes();
    
    //MEDICAMENTOS
    static categoriaDeMedicamentos cantidadMeds[] = new categoriaDeMedicamentos [0];
    categoriaDeMedicamentos catM= new categoriaDeMedicamentos();
    
    clsCompras clsCP = new clsCompras();
    
    public static int totalDia=0;
    
    
    public void menuPrincipal(){
        clsMenus clsMU = new clsMenus();
        char opcion = ' ';
        
        do{
            opcion = clsF.recibeChar("Seleccione la opcion que desea:\n"
                    + "A.Usuario"
                    + "\nB.Cliente"
                    + "\nS.Salir");           
            switch(opcion){
                case  'A':
                   clsMU.MenuUsuario();
                    break;
                case  'B':
                    clsMU.MenuCliente();
                    break;
                case 'S':
                    clsF.imprimeMensaje("Saliendo del programa");
                    break;
                default:
                    clsF.imprimeMensaje("Seleccione una opcion correcta ");            
            }
            
        }while(opcion!= 'S');
    }
    public void MenuUsuario()  {
        clsMenus clsMU = new clsMenus();
        char opcion = ' ';
        int cantU=0;
        boolean generarUsuario = false, llenarUsuario =false;
        
        do{
            opcion = clsF.recibeChar("Seleccione la opcion que desea:"
                    + "\nA.Cantidad de usuarios."
                    + "\nB.Agregar Usuario."
                    + "\nC.Consultar Usuario."
                    + "\nD.Inactivar Usuario."
                    + "\nE.Medicamentos."
                    + "\nF.Total Facturado"
                    + "\nS.Salir");
            switch(opcion){
                case  'A':
                    usuarios = clsU.generarUsuario();
                    generarUsuario = true;
                    break;
                case  'B':
                    if (generarUsuario){
                        if(cantU < usuarios.length){
                            boolean guardo = clsU.agregarUsuario(usuarios, cantU);
                            if(guardo){
                                llenarUsuario = true;
                                cantU++;
                                clsF.imprimeMensaje("El usuario se registro correctamente");
              
                            }
                            else{
                                clsF.imprimeMensaje("El usuario no se registro correctamente");
                            }
                        }
                        else 
                            clsF.imprimeMensaje("Ha llegado al limite de usuarios");
                    }
                    else
                        clsF.imprimeMensaje("Debe digitar la cantidad de usuarios");
                    
                    break;

                case  'C':
                    
                    if (usuarios.length == 0) {
                        
                        clsF.imprimeMensaje("Debe agregar un Usuario");
                    }
                    else
                        
                        clsU.consultarUsuario(usuarios, usuarios.length);
                    
                    break;
                    // cambiar la cantU por usuarios.length*******************************************************
                case 'D':
                    if (usuarios.length == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    }                    
                    else{
                        String nombreUsuario =clsU.existeUsuario(usuarios , cantU);
                        if( nombreUsuario.equals("") ){
                            clsF.imprimeMensaje("No se encontró al usuario indicado");
                        }else{
                            usuarios  = clsU.inactivarUsuario(usuarios, usuarios.length , nombreUsuario);
                         if (usuarios.length == 0) {
                            clsF.imprimeMensaje("Error al eliminar al usuario");
                        }else{
                             cantU--;
                            clsF.imprimeMensaje("Se ha eliminado el usuario con éxito.");
                         }
                        }                               
                    }
                    break;  
                case 'E':
                    clsMU.menuMeds();
                case  'F':
                    clsF.imprimeMensaje("El monto total facturado es de "+totalDia+" colones.");   
                case  'S':
                    clsF.imprimeMensaje("Saliendo de la opcion de usuario");
                    break;
                default:
              
            }
            
        }while(opcion!= 'S');
    }  
    public void MenuCliente(){
        clsMenus clsMU = new clsMenus();
        char opcion = ' ';
        int cantC=0000;
        boolean generarCliente = false, llenarCliente =false;
        
        do{
            opcion = clsF.recibeChar("Seleccione la opcion que desea:"
                    + "\nA.Cantidad de clientes."                   
                    + "\nB.Agregar cliente."
                    + "\nC.Consultar cliente."
                    + "\nD.Inactivar cliente."
                    + "\nE.Compra"
                    + "\nS.Salir");
            switch(opcion){
                case  'A':
                    cliente = clsC.generarCliente();
                    generarCliente = true;
                    break;
                    
                case  'B':
                    if (generarCliente){
                        if(cantC < cliente.length){
                            boolean guardo = clsC.agregarCliente(cliente, cantC);
                            if(guardo){
                                llenarCliente = true;
                                cantC++;
                                clsF.imprimeMensaje("El cliente se registro correctamente");
              
                            }
                            else{
                                clsF.imprimeMensaje("El cliente no se registro correctamente");
                            }
                        }
                        else 
                            clsF.imprimeMensaje("Ha llegado al limite de cliente");
                    }
                    else
                        clsF.imprimeMensaje("Debe digitar la cantidad de cliente");
                    
                    break;

                case  'C':
                    
                    if (cliente.length == 0) {
                        
                        clsF.imprimeMensaje("Debe agregar un Usuario");
                    }
                    else
                        
                        clsC.consultarCliente(cliente, cliente.length);
                    
                    break;
                    
                case 'D':
                    if (cliente.length == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    }                    
                    else{
                        String nombreCliente =clsC.existeCliente(cliente , cantC);
                        if( nombreCliente.equals("") ){
                            clsF.imprimeMensaje("No se encontró al usuario indicado");
                        }else{
                            cliente  = clsC.inacticarCliente(cliente, cliente.length , nombreCliente);
                         if (cliente.length == 0) {
                            clsF.imprimeMensaje("Error al eliminar al usuario");
                        }else{
                             cantC--;
                            clsF.imprimeMensaje("Se ha eliminado el usuario con éxito.");
                         }
                        }                               
                    }
                    break;
                case 'E':
                    clsMU.menuCompras();
                    //Pasar el arreglo de medicamentos a compras y mostrar
                    break;
                    
                case 'S':
                    clsF.imprimeMensaje("Saliendo de la opcion de cliente");
                    break;
                default:
              
            }
            
        }while(opcion!= 'S');
    }
    public void menuCasas(){
        char opcion = ' ';
        int cantC = 0;
        boolean generarCasa = false, llenarCasa =false;
        
        // cambiar los cantC por casasF.length+++++++++++++++++++++++++++++++++++++++
        do {
            opcion = clsF.recibeChar("Digite la opcion que desee:\n "
                    + "A. Agregar Casas de Fabricante\n"
                    + "B. Agregar Informacion de Fabricantes\n"
                    + "C. Mostrar Fabricantes.\n"
                    + "D. Editar Informacion.\n"
                    + "E. Inactivar Fabricantes\n"
                    + "S. Salir\n");
            
            switch(opcion){
                case 'A':
                    casasF =clsCF.agregarCasaComercial();
                    generarCasa = true;
                break;
                
                case 'B':
                    if (generarCasa){
                        if(cantC < casasF.length){
                            boolean guardo = clsCF.infoFabricantes(casasF, cantC);
                            if(guardo){
                                llenarCasa = true;
                                cantC++;
                                clsF.imprimeMensaje("La casa fabricante se registro correctamente");
                            }else{
                                clsF.imprimeMensaje("La casa Fabricante no se registro correctamente");
                            }
                        }else{ 
                            clsF.imprimeMensaje("Ha llegado al limite de casas fabricantes");
                        }    
                    }else{
                        clsF.imprimeMensaje("Debe agregar al menos una casa fabricante");
                   }
                break;
                
                case 'C':
                    if (casasF.length == 0) {
                        clsF.imprimeMensaje("Debe agregar al menos una casa fabricante");
                    }
                    else{
                        clsCF.mostrarFabricantesCasas(casasF, casasF.length);
                    }
                break;
                
                case 'D':
                    if (casasF.length == 0) {
                        clsF.imprimeMensaje("Debe agregar al menos una casa fabricante");
                    }
                    else{
                        clsCF.editarInfo(casasF, opcion);
                    }
                    
                break;
                
                case 'E':
                    if (casasF.length == 0) {
                        clsF.imprimeMensaje("Debe agregar una casa comercial");
                    }                    
                    else{
                        String nombreCasa =clsCF.existeCasas(casasF , cantC);
                        if( nombreCasa.equals("") ){
                            clsF.imprimeMensaje("No se encontró al usuario indicado");
                        }else{
                            casasF  = clsCF.inactivarInfo(casasF, casasF.length , nombreCasa);
                         if (casasF.length == 0) {
                            clsF.imprimeMensaje("Error al eliminar al usuario");
                        }else{
                             cantC--;
                            clsF.imprimeMensaje("Se ha eliminado el usuario con éxito.");
                         }
                        }                               
                    }
                   
                break;
                case 'S':
                    clsF.imprimeMensaje("Saliendo de casas/fabricantes");
                break;
                
                default:
                    clsF.imprimeMensaje("Opcion incorrecta, digite una opcion nuevamente.");
            }
        } while (opcion!='S');
    }
    public void menuCategoriaMeds(){
        
        char opcion = ' ';
        int cantM = 0;
        boolean generarCateg = false, llenarCateg =false;
        
        do {
            opcion = clsF.recibeChar("Digite la opcion que desee:\n "
                    + "A. Agregar Medicamentos\n"
                    + "B. Agregar Informacion de Medicamentos\n"
                    + "C. Mostrar Medicamentos.\n"
                    + "D. Editar Informacion.\n"
                    + "E. Inactivar Medicamentos\n"
                    + "S. Salir\n");
            switch(opcion){
                case 'A':
                    cantidadMeds=catM.agregarMedicamentos();
                    generarCateg = true;
                   
                break;
                
                case 'B':
                    if (generarCateg) {
                        if (cantM<cantidadMeds.length){
                            boolean guardo = catM.agregarInfoMeds(cantidadMeds, cantM);
                            if (guardo) {
                                llenarCateg = true;
                                cantM++;
                                clsF.imprimeMensaje("La info del medicamento se registro correctamente.");
                            }else{
                                clsF.imprimeMensaje("La info del medicamento no se registro correctamente.");
                            }
                        }else{
                            clsF.imprimeMensaje("Ha llegado al limite de medicamentos agregados.");
                        }
                    }else{
                           clsF.imprimeMensaje("Debe ingresar los medicamentos primero.");
                    }
                break;
                case 'C':
                    if (cantidadMeds.length ==0) {
                        clsF.imprimeMensaje("Debe ingresar los medicamentos primero."); //ARREGLAR IMPRESION DE CATEGORIA
                    }else{
                        catM.imprimirMedicamentos(cantidadMeds, cantidadMeds.length);
                        //catM.mostrarInfo(cantidadMeds, cantCateg);
                    }
                break;
                case 'D':
                    if (cantidadMeds.length==0) {
                        clsF.imprimeMensaje("Debe ingresar los medicamentos primero.");
                    }else{
                        catM.editarInfo(cantidadMeds, cantM);
                    }
                break;
                
                case 'E':
                     if (cantidadMeds.length == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    }                    
                    else{
                        String nombreMedicamento =catM.existeMedicamento(cantidadMeds , cantM);
                        if( nombreMedicamento.equals("") ){
                            clsF.imprimeMensaje("No se encontró al usuario indicado");
                        }else{
                            cantidadMeds  = catM.inactivarInfo(cantidadMeds, cantidadMeds.length , nombreMedicamento);
                         if (cantidadMeds.length == 0) {
                            clsF.imprimeMensaje("Error al eliminar al usuario");
                        }else{
                             cantM--;
                            clsF.imprimeMensaje("Se ha eliminado el usuario con éxito.");
                         }
                        }                               
                    }
                break;
                case 'S':
                    clsF.imprimeMensaje("Saliendo de opcion de medicamentos");
                break;
                default:
                    clsF.imprimeMensaje("Opcion incorrecta, digite una opcion nuevamente.");    
            }  
        } while (opcion!='S');
    }   
    public void menuMeds(){
        char opcion = ' ';
        clsMenus clsME = new clsMenus();
        do {
            opcion = clsF.recibeChar("Seleccione la opcion que desea:\n "
                    + "A. Catalogo Empleados/Clientes.\n"  //????
                    + "B. Catalogo de Casas Fabricantes.\n"
                    + "C. Categoria de los Medicamentos.\n"
                    + "S. Salir");
            switch(opcion){
                case 'A':
                    clsC.catalogoCliente(cliente, cliente.length);
                    //clsU.catalogoUsuario(usuarios, usuarios.length);
                    break;
                case 'B':
                    clsME.menuCasas();
                    break;
                case 'C':
                    clsME.menuCategoriaMeds();
                    break;
                case 'S':
                    break;
                default:
                    clsF.imprimeMensaje("Opcion Invalida, seleccione nuevamente.");                    
                    
            }
        } while (opcion!='S');
        
    }
    public void menuCompras(){
        
        char opcion = ' ';
        do {
            opcion = clsF.recibeChar("Seleccione la opcion que desea:\n "
                    + "A. Mostrar catalogo de los medicamentos.\n"  
                    + "B. Comprar medicamento.\n"
                    + "S. Salir");
            
            switch(opcion){
                case 'A':
                    catM.imprimirMedicamentos(cantidadMeds, cantidadMeds.length); 
                        
                    break;
                case 'B':
                    catM.comprarMed(cantidadMeds, totalDia);
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
