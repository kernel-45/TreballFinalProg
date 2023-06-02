/*
CLASE lecturaDatos

AGLUTINA LAS DECLARACIONES Y FUNCIONALIDADES PARA GESTIONAR LA LECTURA DE
DATOS A TRAVÉS DE UN CONTENEDOR JDialog

autor: Juan Montes de Oca
 */

package Treballfinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LTGraficos extends JDialog {
    //atributo array de componentes JTextField que representarán los valores
    //introducidos a través del contenedor JDialog
    private JTextField [] datos;
    //atributo entero que representa el número de valores a introducir a traves
    //del contenedor JDialog
    private int numeroValores=0;

    //MÉTODO CONSTRUCTOR
    //el parámetro frame representa el contenedor JFrame desde el que se le ha
    //llevado a cabo la instanciación, y el parámetro campos representan los
    //literales de los conceptos demandados para introducir     
    public LTGraficos(JFrame frame,String [] campos) {       
        super(frame, true);  
        setTitle("INTRODUCCIÓN DATOS");  
        
        //el número de componentes de campos (número de conceptos) representa
        //el número de valores a introducir
        numeroValores=campos.length;

        //declaración del panel de contenidos del contenedor JDialog
        Container panelContenidos=getContentPane();
        //asignación al panel de contenidos del administrador de layout
        //GridLayout estructurado en (numeroValores+1) filas y una
        //columna
        panelContenidos.setLayout(new GridLayout(numeroValores+1,1));
        
        
        //instanciación del array datos con el número de componentes igual
        //al número de valores, haciendo corresponder una componente JTextField
        //por cada valor a introducir
        datos=new JTextField[numeroValores];
        //de forma análoga se declara e instancia un array de componentes JLabel
        //para, a través de ellas, visualizar en el contenedor JDialog los
        //literales de los conceptos a introducir, estableciendose la relación
        //de una componente JLabel para cada concepto
        JLabel [] conceptos=new JLabel[numeroValores];
        //declaració de un array de contenedores JPanel, en número igual al 
        //número de valores, para introducir en cada uno de ellos, una
        //de las componentes JLabel, del array conceptos, y una de las
        //componentes JTextField del array datos
        JPanel [] paneles=new JPanel[numeroValores];

        
        int maximo=0;
        //bucle de instanciación de las componentes del array de JLabel conceptos,
        //del array de JTextField datos, del array de contenedores JPanel paneles
        //e introducción en cada uno de estos contenedores su correspondiente
        //etiqueta JLabel y componente JTextField, para acabar introduciendo
        //el contenedor JLabel en el panel de contenidos del contenedor JDialog
        for (int indice=0;indice<datos.length;indice++) {
            if (maximo<campos[indice].length()) {
                maximo=campos[indice].length();
            }
            //instanciación de los diferentes arrays 
            conceptos[indice]=new JLabel("  "+campos[indice]);
            conceptos[indice].setForeground(Color.white);
            conceptos[indice].setFont(new Font("Arial",Font.BOLD,10));
            datos[indice]=new JTextField();
            datos[indice].setText("");
            datos[indice].setHorizontalAlignment(JTextField.RIGHT);
            paneles[indice]=new JPanel();
            paneles[indice].setBackground(Color.black);
            paneles[indice].setLayout(new GridLayout());
            //introducción en el contenedor JPanel indice-ésimo de la 
            //componente JLabel indice-ésima y de la componente JTextField
            //indice-ésima
            paneles[indice].add(conceptos[indice]);
            paneles[indice].add(datos[indice]);
            //introducción del contenedor JPanel indice-ésimo en el
            //panel de contenidos del contenedor JDialog
            panelContenidos.add(paneles[indice]);
        }
        
        //declaración componente JButton salirBoton
        JButton salirBoton=new JButton("CONFIRMAR");
        //introducción de la componente JButton salirBoton en el panel
        //de contenidos del contenedor JDialog
        panelContenidos.add(salirBoton);
        //asignación e implementación del gestor de eventos asociado a la
        //componente JButton salirBoton
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //pone a FALSE la visibilidad del contenedor JDialog
                    setVisible(false);
            }
        });
        
        setSize(500, 150); 
        //centrar ventana contenedor JDialog en el centro de la ventana de la aplicación
        //desde donde se ha instanciado
        setLocationRelativeTo(frame);
        //pone a TRUE la visibilidad del contenedor JDialog
        setVisible(true);
    }

    //Método que lleva a cabo la devolución de los datos introducidos a través
    //del contenedor JDialog
    public String [] getDatosTexto() {
        String [] datosIntroducidos=new String[numeroValores];
        for (int indice=0;indice<datosIntroducidos.length;indice++) {
            //asignamos a la componente indice del array datosIntroducidos el
            //String introducido en la componente JTextField del array datos
            
            datosIntroducidos[indice]=(datos[indice].getText());
            if (datos[indice].getText().equals("")){
                ventanaInformativa("Por favor introduce todos los datos");
                return null;
            }
            try{ //Comprobamos que los dos números introducidos sean integers
                Integer.parseInt(datos[1].getText()); 
                Integer.parseInt(datos[2].getText()); 
            }catch(Exception numberFormatException){ //si no lo son damos un aviso
                ventanaInformativa("El número de subdivisiones debe ser un entero!");
                return null; 
            }
            
        }
        return datosIntroducidos;
    }
    
    private void ventanaInformativa(String informacion) {
        UIManager manipulador=new UIManager();
        manipulador.put("Panel.background", Color.BLACK);
        manipulador.put("OptionPane.background", Color.BLACK);
        manipulador.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 14));
        manipulador.put("OptionPane.messageForeground", Color.YELLOW);
        JOptionPane.showMessageDialog(this,informacion); 
    }

}
