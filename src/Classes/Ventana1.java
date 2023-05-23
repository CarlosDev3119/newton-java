package Classes;
import Classes.Ecuacion;
import Classes.Newton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Ventana1 extends JFrame{ //Ventana principal que se le muestra al usuario 
    public JPanel p1,p2;
    ActionListener a1,a2,a3,a4;
    JButton b1,b2, b3, b4;
    JTextField inputEcuacion,r2;
    JLabel etiqueta1,etiqueta2;
    
    public Ventana1() {
        this.setTitle("Método de Newton");
        //this.setVisible(true); //hacerlo visible
       //setBounds(270,200,700,500);//(X,Y,Ancho,Altura); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //setLayout(null);
        //setBackground(Color.MAGENTA);
        iniciarComponentes();
        eventos();
    }
 
    
    public void iniciarComponentes(){
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        this.getContentPane().add(p1);
        
        p2=new JPanel();
        p2.setLayout(null);
        //this.getContentPane().add(p2);

        etiqueta1 = new JLabel();
        etiqueta1.setVisible(true);
        etiqueta1.setText("Ingrese la función:");
        etiqueta1.setBounds(290,200,300,40);

        inputEcuacion=new JTextField("",20);
        inputEcuacion.setVisible(true);
        inputEcuacion.setBounds(401,200,450,40);

        p1.add(etiqueta1);
        p1.add(inputEcuacion);
        
        etiqueta2 = new JLabel();
        etiqueta2.setVisible(true);
        etiqueta2.setText("Ingrese el valor de xn: ");
        etiqueta2.setBounds(290,300,300,40);
    
        r2=new JTextField("",20);
        r2.setVisible(true);
        r2.setBounds(421,310,150,40);
        
            p1.add(etiqueta2);
            p1.add(r2);
        
        colocarbotones();
    }
    
    public void colocarbotones(){
        b1=new JButton();
        b1.setBounds(400,150,90,30);
        b1.setOpaque(true);
        b1.setText("^");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.CYAN);
        b1.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(b1);
        
        b2=new JButton();
        b2.setBounds(500,150,90,30);
        b2.setOpaque(true);
        b2.setText("cos");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.CYAN);
        b2.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(b2);
        
        b3=new JButton();
        b3.setBounds(600,150,90,30);
        b3.setText("sen");
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.CYAN);
        b3.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(b3);
        
        b4=new JButton();
        b4.setBounds(550,385,180,37);
        b4.setText("Calcular");
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.LIGHT_GRAY);
        b4.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(b4);
    }
    
    public void tabla( Object[][] data ){
        // Datos de ejemplo para la tabla
        // Object[][] datos = data;
        DefaultTableModel modelo = new DefaultTableModel(data, new Object[]{"n", "xn", "f(xn)", "f´(xn)", "g(xn)", "Eabs"});


        // Crear tabla
        JTable tabla = new JTable(modelo);

        // Crear un JScrollPane para agregar barras de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Crear una ventana para mostrar la tabla
        JFrame ventana = new JFrame();
        //ventana.setLayout(null);
        ventana.setBackground(Color.PINK);
        ventana.add(scrollPane);
        ventana.setSize(1366, 768);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }//Tabla
    
    
    public void eventos(){
        a1=new ActionListener() {//Evento del botón
            @Override
            public void actionPerformed(ActionEvent e) {
                inputEcuacion.setText(inputEcuacion.getText()+"^");
            }
        };
        b1.addActionListener(a1);
        
        a2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputEcuacion.setText(inputEcuacion.getText() + "cos");
            }
        };
        b2.addActionListener(a2);
        
        a3=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputEcuacion.setText(inputEcuacion.getText() + "sen");
            }
        };
        b3.addActionListener(a3);
        
        a4=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(inputEcuacion.getText());
                Ecuacion ecuacion = new Ecuacion(inputEcuacion.getText());
                Newton procesoNewton = new Newton(ecuacion);
                
                procesoNewton.metodoNewton(Double.parseDouble(r2.getText()));
                
                Object[][] datos = new Object[procesoNewton.datos.size()][];
                for (int i = 0; i < datos.length - 1; i++) {
                    datos[i] = procesoNewton.datos.get(i);
                }
                System.out.println(datos);

            
                add(p2);
                p1.setVisible(false);
                p2.setVisible(true);
                tabla(datos );
            }
        };
        b4.addActionListener(a4);
        
    }//Eventos
    } //fin public