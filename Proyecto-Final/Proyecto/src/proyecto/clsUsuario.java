
package proyecto;

import java.awt.TextArea;


public class clsUsuario {
    clsFunciones clsF = new clsFunciones();
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private String correo_Electronico;
    private String ciudad;
    private String direccion;
    private String telefono;
    private char estado;
    
    public clsUsuario(String nombre, String apellido, String usuario, 
            String contraseña, char estado,String correo_Electronico, String ciudad, String direccion,String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.correo_Electronico = correo_Electronico;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public clsUsuario(){   
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getEstado() {
        switch(estado){
            case 'A':
                return "Activo";
            case 'I':
                return "Inactivo";
            default:
                return "Error";
        }
        
    }
    public void setEstado(char estado) {
        this.estado = estado;
    }
    public clsUsuario[] generarUsuario(){  
        int cantidad =clsF.recibeInt("Digite la cantidad de usuarios");
        clsUsuario usuarios[] = new clsUsuario[cantidad];
        return usuarios;
        
    }
    public void consultarUsuario(clsUsuario usuarios[],int cantU){
        String imprimir = "Nombre\tApellido\tUsuario\tEstado\n";
        for (int i = 0; i < cantU; i++){
            clsUsuario tempUsuario = usuarios[i];
            if(tempUsuario!=null){
                imprimir += tempUsuario.getNombre()+"\t"+tempUsuario.getApellido()+"\t"+tempUsuario.getUsuario()+"\t"+tempUsuario.getEstado()+ "\t" +"\n";
            }
            
        }
        clsF.imprimeMensaje(new TextArea(imprimir));
    }
    
    public String existeUsuario(clsUsuario usuarios[],int cantU){
        String buscarNombre = clsF.recibeString("Digite el nombre del usuario que desea buscar:");
        int poscBuscar = -1;
        
        for (int i = 0; i < cantU; i++){
            if(usuarios[i].getNombre().equalsIgnoreCase(buscarNombre)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar == -1){
            buscarNombre="";
            
        }
        return buscarNombre;
        
    }
    public clsUsuario[] inactivarUsuario(clsUsuario usuarios[],int cantU,  String buscarNombre){
        //String buscarNombre = clsF.recibeString("Digite el nombre del usuario que desea buscar:");
        int poscBuscar = -1;
        //1
        clsUsuario[] usuariosActualizados = usuarios;
        for (int i = 0; i < cantU; i++){
            if(usuarios[i].getNombre().equalsIgnoreCase(buscarNombre)){
                poscBuscar =i;
                break;
            }
        }
        if (poscBuscar!= -1){
            for(int i= poscBuscar; i < cantU-1; i++){
                usuarios[i] = usuarios[i+1];
            }
            usuarios[cantU-1] = null;
            
            usuariosActualizados = usuarios;
        }                
        return usuariosActualizados;
    }   
    public boolean agregarUsuario (clsUsuario usuarios[],int cantidad){
        String nombre = clsF.recibeString("Digite el nombre");
        String apellido = clsF.recibeString("Digite el apellido");
        String usuario = clsF.recibeString("Digite el usuario");
        String contraseña = clsF.recibeString("Digite su contraseña");
        char estado = ' ';
        do{
            estado = clsF.recibeChar("Seleccione su estado \n Activo\nInactivo");
            
        }while(estado != 'A' && estado != 'I');
        clsUsuario nuevoUsuario = new clsUsuario(nombre, apellido, usuario, contraseña, estado,correo_Electronico,ciudad,direccion,telefono);
        usuarios[cantidad] =nuevoUsuario;
        return true;
    }
    
    public String toString(){
        return nombre + "\t" + apellido + "\t"+ usuario + "\t"+ estado + "\t"+ correo_Electronico + "\t"+ ciudad + "\t"+ direccion+ "\t"+ telefono ;
    }
    
    public void catalogoUsuario(clsCliente usuarios[], int cantidad){
        String mostrar = "Nombre\tApellido\tUsuario\tEstado\tCorreo\t\tCiudad\tDireccion\tTelefono\n";
        for (int i = 0; i < cantidad; i++) {
            mostrar += usuarios[i].toString()+ "\n";
        }
        clsF.imprimeMensaje(new TextArea(mostrar));
    }
    
}
