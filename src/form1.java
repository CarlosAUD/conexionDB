import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JButton conectarALaBaseButton;
    public JPanel panel1;
    private JLabel mensaje;
    private JButton insertarButton;
    private JTextField nombreTextField;
    private JTextField cedulatextField2;
    private JTextField calificacion1textField3;
    private JTextField calificacion2textField4;
    private JButton borrarDatosButton;


    public form1() {
        conectarALaBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexionBDD miconexion=new conexionBDD();
                miconexion.conexionLocal("jdbc:mysql://localhost:3306/estudiante", "root", "");
                mensaje.setText(miconexion.getMensaje());
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertarDatos insertardatos= new InsertarDatos();
                String nombre = nombreTextField.getText();
                String cedula = cedulatextField2.getText();
                insertardatos.ingresoDatos(nombre,cedula,Integer.parseInt(calificacion1textField3.getText()),Integer.parseInt(calificacion2textField4.getText()));
            }
        });
    }
}
