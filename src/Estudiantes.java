import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estudiantes {
    public JButton okbutton;
    public JPanel panel1;
    public JLabel resultadoTxt;
    public List<Estudiantes2> estudiantes;

    public Estudiantes() {
        estudiantes = new ArrayList<>();
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String user = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "SELECT * FROM estudiantes";

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String cedula = resultSet.getString("cedula");
                        int bimestreUno = resultSet.getInt("b1");
                        int bimestreDos = resultSet.getInt("b2");

                        Estudiantes2 estudiante = new Estudiantes2(nombre, cedula, bimestreUno, bimestreDos);
                        estudiantes.add(estudiante);
                    }

                    StringBuilder resultado = new StringBuilder();
                    for (Estudiantes2 estudiante : estudiantes) {
                        resultado.append("Nombre: ").append(estudiante.getNombre())
                                .append(", Cedula: ").append(estudiante.getCedula())
                                .append(", Bimestre 1: ").append(estudiante.getBimestreUno())
                                .append(", Bimestre 2: ").append(estudiante.getBimestreDos())
                                .append(", Promedio: ").append(estudiante.getPromedio())
                                .append("\n");
                    }
                    resultadoTxt.setText("<html>" + resultado.toString().replace("\n", "<br>") + "</html>");
                } catch (SQLException ex) {
                    System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
                }
            }
        });
    }
}
