/*
PROGRAMACIÓN II

Iker García e Ignasi Paredes 

Trabajo Final
 */

package treballfinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Treball_Final extends JFrame{
    //Enumerado de los tipos de operación
    enum tipoOperacion {NUEVA_PARTIDA, HISTORIAL_GENERAL, HISTORIAL_SELECTIVO, 
                        CAMBIAR_DIRECTORIO_IMAGENES, NINGUNO};

    //ATRIBUTOS
    Container panelContenidos;
    private AreaVisualizaciones panelVisualizaciones;
    private JButton nuevaPartidaBoton, historialGeneralBoton, historialSelectivoBoton,
                    salirBoton;
    private JButton nuevaPartidaIcono, historialGeneralIcono, historialSelectivoIcono,
                    cambiarDirectorioIcono, salirIcono;
    private JMenuItem nuevaPartidaMenu, historialGeneralMenu, historialSelectivoMenu,
                    cambiarDirectorioMenu, salirMenu;

    public static void main(String[] args) {
        new Treball_Final();        
    }
    
    public Treball_Final(){
        //título contenedor pruebaBotones
        setTitle("PRÁCTICA - PROGRAMACIÓN II - 2022-2023 - UIB");
        //activación cierre ejecución con salida ventana de windows
        setDefaultCloseOperation(Treball_Final.EXIT_ON_CLOSE);
        //redimensionamiento contenedor JFrame
        setSize(1000,700);
        //asignación a panelContenidos del panel de contenidos del contenedor JFrame
        panelContenidos=getContentPane();
        
        inicializacion();
    }
    
    private void inicializacion() {
////////////////////////////////////////////////////////////////////////////////
//                            MANIPULADORES DE EVENTOS                        //
////////////////////////////////////////////////////////////////////////////////

////////MANIPULADOR DE EVENTOS gestorEventos
        ActionListener gestorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            
                            case "NUEVA PARTIDA":  break;
                            case "HISTORIAL GENERAL": break;
                            case "HISTORIAL SELECTIVO": break;
                            case "CAMBIAR DIRECTORIO DE IMÁGENES": break;
                            case "SALIR": //Salir de la aplicación
                                            System.exit(0);
                        }
                }
        }; 

        
////////MANIPULADOR DE EVENTOS gestorEventos
        ActionListener gestorEventosIconos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent ev)  { 
                        switch (ev.getActionCommand()){
                            case "iconoNuevaPartida.jpg": break;
                            case "iconoSalir.jpg": //Salir de la aplicación     /////// no funciona tal vez se debe hacer con
                                                                                // if (ev.getSource() == botonesIconos[?]) { lo q sea }
                                                    System.exit(0);
                        }
                        
                }
        }; 


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////                                                                         ///
////                     PANEL barraMenu y COMPONENTES                       ///
////                                                                         ///
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN componente JMenuBar
        JMenuBar barraMenu = new JMenuBar();
        
        //asignación color de fondo componente JMenuBar
        barraMenu.setBackground(Color.BLACK);

//////////DECLARACIÓN componente JMenu
        JMenu menu = new JMenu("MENÚ");
        
        //asignación color de trazado componente JMenu
        menu.setForeground(Color.WHITE);
        
        JMenuItem [] botonesMenu={nuevaPartidaMenu, historialGeneralMenu,
                                    historialSelectivoMenu, cambiarDirectorioMenu,
                                    salirMenu};
        String [] literalesMenu={"NUEVA PARTIDA", "HISTORIAL GENERAL", "HISTORIAL SELECTIVO",
                                "CAMBIAR DIRECTORIO DE IMÁGENES", "SALIR"};
        
        for (int i = 0; i < botonesMenu.length; i++) {
            //////////DECLARACIÓN componente JMenuItem
            botonesMenu[i] = new JMenuItem(literalesMenu[i]);
            //asignación color de trazado componente JMenuItem
            botonesMenu[i].setForeground(Color.WHITE);
            //asignación color de fondo componente JMenuItem
            botonesMenu[i].setBackground(Color.BLACK);
            //manipulador de evento asociado a la componente JMenuItem
            botonesMenu[i].addActionListener(gestorEventos);
            //inclusión de la componente JMenuItem botonesMenu[i] en el contenedor 
            //JMenu menu
            menu.add(botonesMenu[i]);
        }
        
        //inclusión de la componente JMenu menu en el contenedor JMenuBar barraMenu
        barraMenu.add(menu);
        
        
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////                                                                         ///
////                    PANEL iconosMenu y COMPONENTES                       ///
////                                                                         ///
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN componente JToolBar
        JToolBar iconosMenu = new JToolBar();
        
        //asignación color de fondo componente JToolBar iconosMenu
        iconosMenu.setBackground(Color.BLACK);
        
        JButton [] botonesIconos={nuevaPartidaIcono, historialGeneralIcono,
                                    historialSelectivoIcono, cambiarDirectorioIcono,
                                    salirIcono};
        String [] literalesIconos={"iconoNuevaPartida.jpg", "iconoHistorialGeneral.jpg",
                                    "iconoHistorialSelectivo.jpg", "iconoCambiarDirectorio.jpg",
                                    "iconoSalir.jpg"};
        
        for (int i = 0; i < botonesIconos.length; i++) {
            //////////DECLARACIÓN COMPONENTE JButton
            botonesIconos[i] = new JButton(new ImageIcon(literalesIconos[i]));
            //asignación color de fondo componente JButton
            botonesIconos[i].setBackground(Color.BLACK);
            //manipulador de evento asociado a la componente JButton
            botonesIconos[i].addActionListener(gestorEventosIconos);
            //inclusión de la componente JButton botonIcono en el contenedor JToolBar
            //iconosMenu
            iconosMenu.add(botonesIconos[i]);
            //inclusión de separadores entre los botones
            iconosMenu.addSeparator();
        }


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////                                                                         ///
////                     PANEL panelBotones y COMPONENTES                    ///
////                                                                         ///
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN contenedor JPanel 
        JPanel panelBotones = new JPanel();

        //Asignación administrador GridLayout: 4 Filas y 1 Columna
        panelBotones.setLayout(new  GridLayout(4,1));

        JButton [] botonesAcciones={nuevaPartidaBoton, historialGeneralBoton,
                                    historialSelectivoBoton,salirBoton};
        String [] literalesBotonesAcciones={"NUEVA PARTIDA","HISTORIAL GENERAL",
                                            "HISTORIAL SELECTIVO","SALIR"};
        
        for (int i = 0; i < botonesAcciones.length; i++) {
            //////////DECLARACIÓN componente JButton
            botonesAcciones[i] = new JButton(literalesBotonesAcciones[i]);
            //asignación color de trazado componente JButton
            botonesAcciones[i].setForeground(Color.WHITE);
            //asignación color de fondo componente JButton
            botonesAcciones[i].setBackground(Color.BLACK);
            //asignación tipografía componente JButton
            botonesAcciones[i].setFont(new Font("Arial",Font.BOLD,16));
            //manipulador de evento asociado a la componente JButton
            botonesAcciones[i].addActionListener(gestorEventos);
            //inclusión de la componente JButton botonCreacion en el contenedor JPanel
            //panelVarios
            panelBotones.add(botonesAcciones[i]);  
        }


////////////////////////////////////////////////////////////////////////////////
//                   COMPONENTE JPanel dibujo ASOCIADA                    //
//////////////////////////////////////////////////////////////////////////////// 

        
////////DECLARACIÓN COMPONENTE AreaVisualizaciones dibujo
        panelVisualizaciones=new AreaVisualizaciones();
        
        
////////////////////////////////////////////////////////////////////////////////
//             DECLARACIÓN SEPARADORES JSplitPane DE LA INTERFACE             //
////////////////////////////////////////////////////////////////////////////////         

      JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      JSplitPane separadorCentral= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);      
      JSplitPane separadorSur= new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      
      
////////////////////////////////////////////////////////////////////////////////
//   DISTRIBUCIÓN PANELES Y COMPONENTES EN EL CONTENEDOR JFrame interface_1   //
//////////////////////////////////////////////////////////////////////////////// 

////////Inclusión del JToolBar iconosMenu en la zona NORTH del CONTENEDOR JFrame
////////e inclusión del JMenu barraMenu en el CONTENEDOR JFrame 
        setJMenuBar(barraMenu);
        separadorNorte.setTopComponent(iconosMenu);                         
                                                                                

////////Inclusión del separadorNorte en la zona NORTH del CONTENEDOR JFrame 
////////panelContenidos del CONTENEDOR JFrame
        panelContenidos.add(separadorNorte, BorderLayout.NORTH);

////////Inclusión del JPanel panelBotones y JPanel panelVisualizaciones en la 
////////zona CENTER del CONTENEDOR JFrame panelContenidos del CONTENEDOR JFrame
        separadorCentral.setLeftComponent(panelBotones);
        separadorCentral.setRightComponent(panelVisualizaciones);

////////Inclusión del separadorCentral en la zona CENTER del CONTENEDOR JFrame 
////////panelContenidos del CONTENEDOR JFrame
        panelContenidos.add(separadorCentral, BorderLayout.CENTER);

////////Inclusión del separadorSur en la zona SOUTH del CONTENEDOR JFrame 
////////panelContenidos del CONTENEDOR JFrame        
        panelContenidos.add(separadorSur, BorderLayout.SOUTH);



///////VISIBILIDAD CONTENEDOR JFrame
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //////////////////////////////////////////////////////////////////////////////
    //                                                                          //
    //                     CLASE AreaVisualizaciones                            //
    //                                                                          //
    //////////////////////////////////////////////////////////////////////////////
    public class AreaVisualizaciones extends JPanel {
        
    }
    
    /*private void cambiarPanelACtividades(String nombrePanel) {
         CardLayout panel = (CardLayout)(panelActividades.getLayout());
         panel.show(panelActividades, nombrePanel);
    }*/
}
