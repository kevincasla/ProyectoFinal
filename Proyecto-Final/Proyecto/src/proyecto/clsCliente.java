
package proyecto;
import java.awt.TextArea;

public class clsCliente {
    clsFunciones clsF = new clsFunciones();    
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo_Electronico;
    private String ciudad;
    private String direccion;
    private String telefono;
    private char estado;
    
    public clsCliente(String nombre, String apellido, String usuario,char estado,String correo_Electronico, String ciudad, String direccion,String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.estado = estado;
        this.correo_Electronico = correo_Electronico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public clsCliente(){       
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public char getEstado() {
        return estado;
    }
    public void setEstado(char estado) {
        this.estado = estado;
    }
    public String getCorreo_Electronico() {
        return correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        this.correo_Electronico = correo_Electronico;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public clsCliente[] generarCliente(){
        int cantidad = clsF.recibeInt("Digite la cantidad de clientes ");
        clsCliente cliente[] = new clsCliente[cantidad];
        return cliente;
        
    }
    public void consultarCliente(clsCliente cliente[], int cantidad){
       String imprimir = "Nombre\tApellido\tUsuario\tEstado\n";
        for (int i = 0; i < cantidad; i++){
            clsCliente tempCliente = cliente[i];
            if(tempCliente!=null){
                imprimir += tempCliente.getNombre()+"\t"+tempCliente.getApellido()+"\t"+tempCliente.getUsuario()+"\t"+tempCliente.getEstado()+ "\t" +"\n";               
            }
            
        }
        clsF.imprimeMensaje(new TextArea(imprimir));
    }
    
    public boolean agregarCliente(clsCliente cliente[], int cantidad){
        
        String nombre = clsF.recibeString("Digite el nombre del cliente");
        String apellido = clsF.recibeString("Digite el apellido del cliente");
        String usuario = clsF.recibeString("Digite el usuario del cliente");
        String correo_Electronico = clsF.recibeString("Digite el correo electronico");
        String ciudad = clsF.recibeString("Digite la ciudad");
        String direccion = clsF.recibeString("Digite la direccion");
        String telefono = clsF.recibeString("Digite el telefono");
        char estado = ' ';
        do{
            estado = clsF.recibeChar("Seleccione su estado \n Activo\nInactivo");
            
        }while(estado != 'A' && estado != 'I');
        System.out.print(nombre);
        clsCliente nuevoCliente = new clsCliente(nombre, apellido, usuario,estado,correo_Electronico,ciudad,direccion,telefono);
        cliente[cantidad] =nuevoCliente;
        return true;
        
    }
    public String existeCliente(clsCliente cliente[],int cantC){
        String buscarNombre = clsF.recibeString("Digite el nombre del cliente que desea buscar:");
        int poscBuscar = -1;
        
        for (int i = 0; i < cantC; i++){
            if(cliente[i].getNombre().equalsIgnoreCase(buscarNombre)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar == -1){
            buscarNombre="";
            
        }
        return buscarNombre;
        
    }
    public clsCliente[] inacticarCliente(clsCliente cliente[] ,int cantC, String buscarNombre){
        int poscBuscar = -1;
        
        clsCliente[] clientesActualizados = cliente;
        for (int i = 0; i < cantC; i++){
            if(cliente[i].getNombre().equalsIgnoreCase(buscarNombre)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar!= -1){
            for(int i= poscBuscar; i < cantC-1; i++){
                cliente[i] = cliente[i+1];
            }
            cliente[cantC-1] = null;
            
            clientesActualizados = cliente;
        }                
        return clientesActualizados;
    }
    public String toString(){
        return nombre + "\t" + apellido + "\t"+ usuario + "\t"+ estado + "\t"+ correo_Electronico + "\t"+ ciudad + "\t"+ direccion+ "\t"+ telefono ;
    }
    
    public void catalogoCliente(clsCliente cliente[], int cantCL){
        String mostrar = "Nombre\tApellido\tUsuario\tEstado\tCorreo\tCiudad\tDireccion\tTelefono\n";
        for (int i = 0; i < cantCL; i++) {
            mostrar += cliente[i].toString()+ "\n";
        }
        
        clsF.imprimeMensaje(new TextArea(mostrar));
}

    
    
}
