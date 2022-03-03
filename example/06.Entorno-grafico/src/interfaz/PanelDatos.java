package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel{

    private JLabel labNombre;
    private JLabel labApellido;
    private JLabel labSexo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtSexo;
     private Ventana interfazEmpleado;

    public PanelDatos(Ventana interfaz  ) {
        interfazEmpleado = interfaz;
        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Panel de Datos Personales" ) ) );

        GridBagConstraints gbc;

        labNombre = new JLabel( "Nombre: " );
        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labNombre, gbc );

        labApellido = new JLabel( "Apellido: " );
        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labApellido, gbc );

        labSexo = new JLabel( "Sexo: " );
        gbc = new GridBagConstraints( 0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( labSexo, gbc );

        txtNombre = new JTextField( 15 );
        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtNombre, gbc );
        txtNombre.setEnabled( false );

        txtApellido = new JTextField( 15 );
        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtApellido, gbc );
        txtApellido.setEnabled( false );

        txtSexo = new JTextField( 10 );
        gbc = new GridBagConstraints( 1, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSexo, gbc );
        txtSexo.setEnabled( false );
    }

    public void actualizarCampos( String nombre, String apellido, String sexo ){
        txtNombre.setText( nombre );
        txtApellido.setText( apellido );
        txtSexo.setText( sexo );
    }

    public String getNombre() {
        return txtNombre.getText();
    }

    public String getApellido() {
        return txtApellido.getText();
    }

    public String getSexo() {
        return txtSexo.getText();
    }
}