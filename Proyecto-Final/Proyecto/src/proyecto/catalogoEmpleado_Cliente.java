
package proyecto;
import java.awt.TextArea;
import javax.swing.JOptionPane;
public class catalogoEmpleado_Cliente {
    private String nombre_Empleado_Cliente;
    private String apellido;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo_Electronico;
    private String estado_Cliente;
    
    public catalogoEmpleado_Cliente(String nombre_Empleado_Cliente, String apellido,String ciudad,String dirección,String telefono, String correo_Electronico, String estado_Cliente){
        this.nombre_Empleado_Cliente = nombre_Empleado_Cliente;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo_Electronico = correo_Electronico;
        this.estado_Cliente = estado_Cliente;
        
    }

    public String getNombre_Empleado_Cliente() {
        return nombre_Empleado_Cliente;
    }

    public void setNombre_Empleado_Cliente(String nombre_Empleado_Cliente) {
        this.nombre_Empleado_Cliente = nombre_Empleado_Cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getCorreo_Electronico() {
        return correo_Electronico;
    }

    public void setCorreo_Electronico(String correo_Electronico) {
        this.correo_Electronico = correo_Electronico;
    }

    public String getEstado_Cliente() {
        return estado_Cliente;
    }

    public void setEstado_Cliente(String estado_Cliente) {
        this.estado_Cliente = estado_Cliente;
    }
    
    
}
