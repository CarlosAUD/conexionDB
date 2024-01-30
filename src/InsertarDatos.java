import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    String nombre;
    String cedula;
    int Calif1;
    int Calif2;

    public InsertarDatos(String nombre, String cedula, int calif1, int calif2) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.Calif1 = calif1;
        this.Calif2 = calif2;
    }

    public InsertarDatos() {
    }
    public void ingresoDatos(String nombre, String cedula,int calificacion1, int calificacion2){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql//localhost/estudiante", "root", "")){
            String sql="INSERT INTO calificaciones(nombre, cedula, calificacion1, calificacion2) values(?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,nombre);
                preparedStatement.setString(2,cedula);
                preparedStatement.setInt(3, calificacion1);
                preparedStatement.setInt(4,calificacion2);
                int filasAdectadas = preparedStatement.executeUpdate();
                if (filasAdectadas>0){
                    System.out.println("Insercion Exitosa");
                }else{
                    System.out.println("Insercion Fallida");
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
