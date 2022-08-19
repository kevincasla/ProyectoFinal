
package proyecto;
import javax.swing.JOptionPane;
public class Factura {
    private String fecha;
    private String hora;
    private String nombreDelCliente;
    
    public Factura(String fecha, String hora, String nombreDelCliente){
        this.fecha = fecha;
        this.hora = hora;
        this.nombreDelCliente = nombreDelCliente;
        
    }
    public Factura(){
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }
    public void agregarFecha(){
    
    }
    public void agregarHora(){
    
    }
    public void agregarNombreCliente(){
    
    }
    public void emitirFactura(){
    
    }
    
    
}
