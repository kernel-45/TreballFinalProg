/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treballfinal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 34655
 */
public class VentanaPrincipal {

    private JFrame ventana;
    private Container panelContenidos;
    private JPanel panelBotones  = new JPanel();
    //En este array irán los botones
    private JButton[] botones = new JButton[4]; 
    private JButton nuevaPartidaBoton, clasificacionBoton, historialBoton, salirBoton;
    //En este array los iconos
    private JButton[] iconos = new JButton[5]; 
    private JButton nuevaPartidaIcono, clasificacionIcono, historialIcono, cambiarDirectorioIcono, salirIcono;
    //En este array los items del menú
    private JMenuItem[] opcionesMenu = new JMenuItem[5]; 
    private JMenuItem nuevaPartidaMenu, clasificacionMenu, historialMenu, cambiarDirectorioMenu, salirMenu; 
    private JMenu menu;
    private JMenuBar barraMenu;
    private JToolBar iconosMenu = new JToolBar();
    private JPanel panelVisualizaciones = new JPanel();
    private JSplitPane separador1, separador2, separador3, separador4;

    public void metodoPrincipal() {
        ventana = new JFrame();
        //título contenedor pruebaBotones
        ventana.setTitle("PRACTICA - PROGRAMACION 2 - 2022-2023 - UIB");
        //asignación a panelContenidos del panel de contenidos del contenedor
        //JFrame
        panelContenidos = ventana.getContentPane();
        inicializacion();
    }

    private void inicializacion() {
        ActionListener gestorEventos=new ActionListener()  { 
                @Override
                public void actionPerformed(ActionEvent evento)  { 
                        switch (evento.getActionCommand()) {
                            case "Nueva partida"         :System.out.println("hola");break;
                            case "Clasificación"      :;break;
                            case "Historial selectivo"     :;break;
                            case "Cambiar directorio" :;break; 
                            case "Salir"        ://Salir de la aplicación
                                                 System.exit(0);
                        }
                    
                }
        };
        //Separadores
        separador1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, iconosMenu,panelBotones); 
        //Inicialización de los diferentes elementos que componen los botones del menú
        panelContenidos.add(panelBotones, BorderLayout.WEST);
        panelContenidos.add(panelVisualizaciones); 
        panelContenidos.add(iconosMenu, FlowLayout.LEADING); 
        panelBotones.setLayout(new GridLayout(4, 1));
        /////BOTONES Creación de los botones
        botones[0] = (nuevaPartidaBoton = new JButton("Nueva partida"));
        botones[1] = (clasificacionBoton = new JButton("Clasificación"));
        botones[2] = (historialBoton = new JButton("Historial selectivo"));
        botones[3] = (salirBoton = new JButton("Salir")); 
        //Asignación de los colores a los botones
        for (int i = 0; i < botones.length; i++) {
            botones[i].setForeground(Color.WHITE);
            botones[i].setBackground(Color.BLACK); 
        } 
        //Asignación de funciones a los botones
         for (int i = 0; i < botones.length; i++) {
            botones[i].addActionListener(gestorEventos); 
        } 
        //Asignación de botones al panel  
         for (int i = 0; i < botones.length; i++) {
            panelBotones.add(botones[i]); 
        } 
        
        /////MENU
        menu = new JMenu("Menu"); 
        opcionesMenu[0] = (nuevaPartidaMenu = new JMenuItem("Nueva partida")); 
        opcionesMenu[1] = (clasificacionMenu = new JMenuItem("Clasificación")); 
        opcionesMenu[2] = (historialMenu = new JMenuItem("Historial")); 
        opcionesMenu[3] = (cambiarDirectorioMenu = new JMenuItem("Cambiar directorio"));  
        opcionesMenu[4] = (salirMenu = new JMenuItem("Salir"));  
        //nuevaPartidaMenu.addActionListener(new GestorEvento())
        barraMenu = new JMenuBar(); 
        barraMenu.add(menu); 
        //Colores items menu
        for (int i = 0; i < opcionesMenu.length; i++) {
            opcionesMenu[i].setForeground(Color.WHITE); 
            opcionesMenu[i].setBackground(Color.BLACK); 
        }
        panelContenidos.add(barraMenu, BorderLayout.NORTH); 
                //Asignación de funciones a los botones
         for (int i = 0; i < opcionesMenu.length; i++) {
            opcionesMenu[i].addActionListener(gestorEventos);
         }
        //Asignacion al menu
        for (int i = 0; i < opcionesMenu.length; i++) {
            menu.add(opcionesMenu[i]); 
        }
        ///ICONOS
        iconos[0] = (nuevaPartidaIcono = new JButton("Nueva partida")); 
        iconos[1] = (clasificacionIcono = new JButton("Clasificación")); 
        iconos[2] = (historialIcono = new JButton("Historial")); 
        iconos[3] = (cambiarDirectorioIcono = new JButton("Cambiar directorio"));  
        iconos[4] = (salirIcono = new JButton("Salir")); 
        for (int i = 0; i < iconos.length; i++) {
            iconosMenu.add(iconos[i]); 
        }
        ventana.setJMenuBar(barraMenu); 
        //Crear ventana
        ventana.setSize(650, 550);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
