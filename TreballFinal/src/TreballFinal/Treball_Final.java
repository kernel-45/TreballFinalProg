/*
PROGRAMACIÓN II

Iker García e Ignasi Paredes 

Trabajo Final
 */
package Treballfinal;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Treball_Final extends JFrame {

    //Enumerado de los tipos de operación
    enum tipoOperacion {
        NUEVA_PARTIDA, HISTORIAL_GENERAL, HISTORIAL_SELECTIVO,
        CAMBIAR_DIRECTORIO_IMAGENES, NINGUNO
    };

    //ATRIBUTOS
    private JButton nuevaPartidaBoton, historialGeneralBoton, historialSelectivoBoton,
            salirBoton;
    private JButton nuevaPartidaIcono, historialGeneralIcono, historialSelectivoIcono,
            cambiarDirectorioIcono, salirIcono;
    private JMenuItem nuevaPartidaMenu, historialGeneralMenu, historialSelectivoMenu,
            cambiarDirectorioMenu, salirMenu;
    private JPanel panelVisualizaciones, panelStandby, panelPartida, panelImagenSolucion,
            panelHistorial;

    Container panelContenidos;

    private tipoOperacion estado = tipoOperacion.NINGUNO;
    private ImageIcon imagenPuzle = new ImageIcon("puzzzle.jpg");
    private JButton [] piezasPuzzleOrdenadas, piezasPuzzle;
    private JButton lastPressed;
    private String nombreJugador;
    private int nDivisionesHorizontal;
    private int nDivisionesVertical;
    private static final int dimX = 741;
    private static final int dimY = 460;

    public static void main(String[] args) {
        new Treball_Final();
    }

    public Treball_Final() {
        //título contenedor pruebaBotones
        setTitle("PRÁCTICA - PROGRAMACIÓN II - 2022-2023 - UIB");
        //activación cierre ejecución con salida ventana de windows
        setDefaultCloseOperation(Treball_Final.EXIT_ON_CLOSE);
        //redimensionamiento contenedor JFrame
        setSize(979, 602);
        //asignación a panelContenidos del panel de contenidos del contenedor JFrame
        panelContenidos = getContentPane();

        inicializacion();
    }

    private void inicializacion() {
////////////////////////////////////////////////////////////////////////////////
//                            MANIPULADORES DE EVENTOS                        //
////////////////////////////////////////////////////////////////////////////////

////////MANIPULADOR DE EVENTOS gestorEventos
        ActionListener gestorEventos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                CardLayout local = (CardLayout) (panelVisualizaciones.getLayout());

                switch (evento.getActionCommand()) {
                    case "NUEVA PARTIDA":
                        ventanaEmergenteDatos();
                        preparacionPanelPartida();
                        local.show(panelVisualizaciones, "Panel Partida");
                        panelVisualizaciones.repaint();
                        break;
                    case "HISTORIAL GENERAL":
                        local.show(panelVisualizaciones, "Panel Historial");
                        panelVisualizaciones.repaint();
                        break;
                    case "HISTORIAL SELECTIVO":
                        panelVisualizaciones.repaint();
                        break;
                    case "CAMBIAR DIRECTORIO DE IMÁGENES":
                        panelVisualizaciones.repaint();
                        break;
                    case "SALIR": //Salir de la aplicación
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

        JMenuItem[] botonesMenu = {nuevaPartidaMenu, historialGeneralMenu,
            historialSelectivoMenu, cambiarDirectorioMenu,
            salirMenu};
        String[] literalesMenu = {"NUEVA PARTIDA", "HISTORIAL GENERAL", "HISTORIAL SELECTIVO",
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

        JButton[] botonesIconos = {nuevaPartidaIcono, historialGeneralIcono,
            historialSelectivoIcono, cambiarDirectorioIcono,
            salirIcono};
        String[] literalesIconos = {"iconoNuevaPartida.jpg", "iconoHistorialGeneral.jpg",
            "iconoHistorialSelectivo.jpg", "iconoCambiarDirectorio.jpg",
            "iconoSalir.jpg"};

        for (int i = 0; i < botonesIconos.length; i++) {
            //////////DECLARACIÓN COMPONENTE JButton
            botonesIconos[i] = new JButton(new ImageIcon(literalesIconos[i]));
            //asignación color de fondo componente JButton
            botonesIconos[i].setBackground(Color.BLACK);
            //manipulador de evento asociado a la componente JButton
            botonesIconos[i].addActionListener(new ActionListener() {
                // Agregamos un oyente de evento a cada icono
                @Override
                public void actionPerformed(ActionEvent ev) {
                    // TRATAMIENTO DEL EVENTO
                    if (ev.getSource() == botonesIconos[0]) {
                        //Hacemos algo
                    } else if (ev.getSource() == botonesIconos[1]) {
                        //Hacemos algo
                    } else if (ev.getSource() == botonesIconos[2]) {
                        //Hacemos algo
                    } else if (ev.getSource() == botonesIconos[3]) {
                        //Hacemos algo
                    } else if (ev.getSource() == botonesIconos[4]) {
                        //Salir de la aplicación
                        System.exit(0);
                    }

                }
            });
            //inclusión de la componente JButton botonIcono en el contenedor JToolBar
            //iconosMenu
            iconosMenu.add(botonesIconos[i]);
        }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////                                                                         ///
////                    JPANEL panelBotones y COMPONENTES                    ///
////                                                                         ///
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN contenedor JPanel 
        JPanel panelBotones = new JPanel();

        //Asignación administrador GridLayout: 4 Filas y 1 Columna
        panelBotones.setLayout(new GridLayout(4, 1));

        JButton[] botonesAcciones = {nuevaPartidaBoton, historialGeneralBoton,
            historialSelectivoBoton, salirBoton};
        String[] literalesBotonesAcciones = {"NUEVA PARTIDA", "HISTORIAL GENERAL",
            "HISTORIAL SELECTIVO", "SALIR"};

        for (int i = 0; i < botonesAcciones.length; i++) {
            //////////DECLARACIÓN componente JButton
            botonesAcciones[i] = new JButton(literalesBotonesAcciones[i]);
            //asignación color de trazado componente JButton
            botonesAcciones[i].setForeground(Color.WHITE);
            //asignación color de fondo componente JButton
            botonesAcciones[i].setBackground(Color.BLACK);
            //asignación tipografía componente JButton
            botonesAcciones[i].setFont(new Font("Arial", Font.BOLD, 16));
            //manipulador de evento asociado a la componente JButton
            botonesAcciones[i].addActionListener(gestorEventos);
            //inclusión de la componente JButton botonCreacion en el contenedor JPanel
            //panelVarios
            panelBotones.add(botonesAcciones[i]);
        }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////                                                                         ///
////              JPANEL panelVisualizaciones y COMPONENTES                  ///
////                                                                         ///
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
//////////DECLARACIÓN contenedor JPanel 
        panelVisualizaciones = new JPanel();

        //asignación administradorde layout CardLayout
        panelVisualizaciones.setLayout(new CardLayout());

////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel panelStandby       /////////////
        panelStandby = new AreaVisualizaciones();

        //INTRODUCCIÓN CONTENEDOR panelStandby EN EL CONTENEDOR panelVisualizaciones
        //ASOCIADO AL LITERAL "Panel Standby"
        panelVisualizaciones.add(panelStandby, "Panel Standby");

////////////////////////////////////////////////////////////////////////////////
//////////        DECLARACIÓN CONTENEDOR JPanel panelPartida       /////////////
        panelPartida = new JPanel();

        //asignación administradorde layout BorderLayout
        panelPartida.setLayout(new BorderLayout());

        //INTRODUCCIÓN CONTENEDOR panelPartida EN EL CONTENEDOR panelVisualizaciones
        //ASOCIADO AL LITERAL "Panel Partida"
        panelVisualizaciones.add(panelPartida, "Panel Partida");

////////////////////////////////////////////////////////////////////////////////
//////////    DECLARACIÓN CONTENEDOR JPanel panelImagenSolucion    /////////////
        panelImagenSolucion = new JPanel();

        //asignación administradorde layout BorderLayout
        panelImagenSolucion.setLayout(new BorderLayout());

        //INTRODUCCIÓN CONTENEDOR panelImagenSolucion EN EL CONTENEDOR panelVisualizaciones
        //ASOCIADO AL LITERAL "Panel ImagenSolucion"
        panelVisualizaciones.add(panelImagenSolucion, "Panel ImagenSolución");

////////////////////////////////////////////////////////////////////////////////
//////////       DECLARACIÓN CONTENEDOR JPanel panelHistorial      /////////////
        panelHistorial = new JPanel();

        //asignación administradorde layout BorderLayout
        panelHistorial.setLayout(new BorderLayout());

        //INTRODUCCIÓN CONTENEDOR panelStandby EN EL CONTENEDOR panelVisualizaciones
        //ASOCIADO AL LITERAL "Panel Historial"
        panelVisualizaciones.add(panelHistorial, "Panel Historial");

////////////////////////////////////////////////////////////////////////////////
//             DECLARACIÓN SEPARADORES JSplitPane DE LA INTERFACE             //
////////////////////////////////////////////////////////////////////////////////         
        JSplitPane separadorNorte = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JSplitPane separadorCentral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        separadorCentral.setEnabled(false);
        JSplitPane separadorSur = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

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
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //////////////////////////////////////////////////////////////////////////////
    //                                                                          //
    //                     CLASE AreaVisualizaciones                            //
    //                                                                          //
    //////////////////////////////////////////////////////////////////////////////
    public class AreaVisualizaciones extends JPanel {

        private Graphics2D g2;
        private Image imagen = null;
        //private Rectangle2D rectangulo;

        //CONSTRUCTOR
        public AreaVisualizaciones() {
            try {
                imagen = Toolkit.getDefaultToolkit().getImage("UIB.jpg");
                imagen = imagen.getScaledInstance(741, 480,
                        java.awt.Image.SCALE_DEFAULT);
            } catch (Exception error) {
                System.out.println("ERROR FICHERO IMAGEN");
            }
        }

        //MÉTODO Paint
        @Override
        public void paintComponent(Graphics g) {
            g2 = (Graphics2D) g;
            g2.drawImage(imagen, 0, 0, this);
            /*    limpiarFondo();                                                   Todo lo comentado no hace falta (creo)
            if (estado!=tipoOperacion.NINGUNO){                                 pero puede ser útil
                //llevar a cabo el pintado de todo el panel de color colorFondo a
                //a través de la visualización de un rectángulo con las dimensiones
                //del panel
                 g2.setColor(Color.BLACK);
                 //declaración rectángulo con las dimensiones del panel
                 rectangulo=new Rectangle2D.Float(0,0,getWidth(),getHeight());
                 //pintarel rectángulo relleno
                 g2.fill(rectangulo);                   
             } 
            else {*/
            //g2.drawImage(imagen,0,0,this);
            //    }
        }

        /*private void limpiarFondo() {    
            g2.setColor(Color.BLACK);
            //declaración rectángulo con las dimensiones del panel
            rectangulo=new Rectangle2D.Float(0,0,getWidth(),getHeight());
            //pintarel rectángulo relleno
            g2.fill(rectangulo);  
        }*/
    }

    /*private void cambiarPanelACtividades(String nombrePanel) {
         CardLayout panel = (CardLayout)(panelActividades.getLayout());
         panel.show(panelActividades, nombrePanel);
    }*/
    private void preparacionPanelPartida() {
        //IMAGEN PARA EL PUZLE
        //redimensiona la imagen y la pone en la posicion 0 del array de subimagenes
        piezasPuzzleOrdenadas = new JButton[nDivisionesVertical * nDivisionesHorizontal];
        piezasPuzzle = new JButton[nDivisionesVertical * nDivisionesHorizontal];
        //Array de JButtons que contendran las divisiones de la imagen
        ImageIcon temp = imagenPuzle;
        //b.setIcon();
        int espacioEntreDivisionX = dimX / nDivisionesVertical;
        int espacioEntreDivisionY = dimY / nDivisionesHorizontal;
        //rellenaremos las posiciones restantes con los recortes de la imagen
        for (int x = 0; x < nDivisionesHorizontal; x++) {
            for (int y = 0; y < nDivisionesVertical; y++) {
                Image tempI = temp.getImage();
                tempI = createImage(new FilteredImageSource(tempI.getSource(),
                        new CropImageFilter(x * espacioEntreDivisionX, y * espacioEntreDivisionY, espacioEntreDivisionX, espacioEntreDivisionY)));
                piezasPuzzleOrdenadas[x + y * nDivisionesHorizontal] = new JButton(new ImageIcon(tempI));
            }
        }

        panelPartida.setLayout(new GridLayout(nDivisionesVertical, nDivisionesHorizontal));
        //Ahora creamos todos los JPanel que contendrán las fracciones de la imagen.
        JPanel fImagen[] = new JPanel[nDivisionesVertical * nDivisionesHorizontal];
        Random r = new Random();
        int [] posiciones = new int[nDivisionesVertical * nDivisionesHorizontal];
        for (int i = 1; i < nDivisionesVertical * nDivisionesHorizontal; i++) {
            while (true) {
                int numRandom = r.nextInt(nDivisionesVertical * nDivisionesHorizontal);
                boolean yaEsta = false;
                for (int j = 0; !yaEsta && j < posiciones.length; j++) {
                    if(posiciones[j] == numRandom) yaEsta = true;
                }
                if(!yaEsta){
                    posiciones[i] = numRandom;
                    break;
                }
            }
        }
        lastPressed = null;
        int numRandom2 = r.nextInt(nDivisionesVertical * nDivisionesHorizontal);
        posiciones[0] = posiciones[numRandom2];
        posiciones[numRandom2] = 0;
        Treball_Final instancia = this;
        for (int i = 0; i < nDivisionesVertical * nDivisionesHorizontal; i++) {
            piezasPuzzle[i] = piezasPuzzleOrdenadas[posiciones[i]];
            piezasPuzzle[i].addActionListener((ActionEvent e) -> {
                if(lastPressed != null) {
                    int ind1 = 0, ind2 = 0;
                    for (int j = 0; j < piezasPuzzle.length; j++) {
                        if(piezasPuzzle[j].equals(lastPressed)){
                            lastPressed = null;
                            ind1 = j;
                        }
                        if(piezasPuzzle[j].equals(((JButton)e.getSource()))){
                            ind2 = j;
                        }
                    }
                    JButton tempJB = piezasPuzzle[ind1];
                    piezasPuzzle[ind1] = piezasPuzzle[ind2];
                    piezasPuzzle[ind2] = tempJB;
                    panelPartida.removeAll();
                    for (JButton piezasPuzzle1 : piezasPuzzle) {
                        panelPartida.add(piezasPuzzle1);
                    }
                    panelPartida.repaint();
                    panelPartida.updateUI();
                    boolean solucion = true;
                    for (int j = 0; j < piezasPuzzle.length; j++) {
                        if (piezasPuzzle[j] != piezasPuzzleOrdenadas[j]) solucion = false;
                    }
                    if(solucion) {
                        ganar();
                    }
                } else {
                    lastPressed = ((JButton)e.getSource());
                }
            });
            panelPartida.add(piezasPuzzle[i]);
        }
    }
    
    private void ganar(){
        System.err.println("me follo a tu madre");
    }

    public ImageIcon redimensionarImagen(ImageIcon imagen) {
        Image image = imagen.getImage(); // transforma ImageIcon a image

        Image newimg = image.getScaledInstance(dimX, dimY, java.awt.Image.SCALE_DEFAULT);
        imagen = new ImageIcon(newimg);  // transforma  Image a imageIcon
        return imagen;
    }

    public void ventanaEmergenteDatos() {
        String[] literalesIntroduccion = {"NOMBRE DE JUGADOR", "NÚMERO DE SUBDIVISIONES HORIZONTALES",
            "NÚMERO DE SUBDIVISIONES VERTICALES"};
        literalesIntroduccion = new LTGraficos(this, literalesIntroduccion).getDatosTexto();
        nombreJugador = literalesIntroduccion[0];
        nDivisionesHorizontal = Integer.parseInt(literalesIntroduccion[1]);
        nDivisionesVertical = Integer.parseInt(literalesIntroduccion[2]);
    }
}
