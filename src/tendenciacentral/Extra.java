package tendenciacentral;

import tendenciacentral.interfaces.*;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Extra  {
    public static final String[] options = {"Entero", "Real"};


    public void init(){
        try{
            JFrame frame = new JFrame("Tendencia central");
            String figura = (String) JOptionPane.showInputDialog(frame,
                    "Elige un tipo de dato numerico",
                    "TC",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
        System.out.println(figura);


            switch (figura){

                case "Entero":

                /*
                rango p y q
                 */

                TC tcEntero = new TC();
                tcEntero.setTipoDeDato("Entero");
                tcEntero.setRangoP(Integer.parseInt(rangoP()));
                tcEntero.setRangoQ(Integer.parseInt(rangoQ()));


                String dat = JOptionPane.showInputDialog("Ingresa el total de datos a utilizar");



                tcEntero.setDataTotal(Integer.parseInt(dat));

                int pVar = tcEntero.getRangoP();
                int qVar = tcEntero.getRangoQ();

                int[] Arreglo = new int[Integer.parseInt(dat)];
                    for (int i = 0; i < Integer.parseInt(dat); i++) {


                        Arreglo[i] =  ThreadLocalRandom.current().nextInt(pVar,qVar);

                    }



                    tcEntero.setArrI(Arreglo);


                    String rangos = pVar+", "+qVar;



                    salidaDatos(tcEntero.getTipoDeDato(), rangos,Arreglo);

                    media(tcEntero,Arreglo,Integer.parseInt(dat));
                    mediana(tcEntero,Integer.parseInt(dat));
                    moda(tcEntero,Arreglo);
                    rangoMedio(tcEntero,pVar,qVar);
                    varianza(tcEntero,Arreglo,Integer.parseInt(dat));
                    desviacion(tcEntero,Arreglo,Integer.parseInt(dat));

                    break;
                case "Real":

                /*
                rango p y q
                 */

                    TC tcDouble = new TC();
                    tcDouble.setTipoDeDato("Entero");
                    tcDouble.setRangoP(Integer.parseInt(rangoP()));
                    tcDouble.setRangoQ(Integer.parseInt(rangoQ()));


                    String datDou = JOptionPane.showInputDialog("Ingresa el total de datos a utilizar");



                    tcDouble.setDataTotal(Integer.parseInt(datDou));

                    int pVarDou = tcDouble.getRangoP();
                    int qVarDou = tcDouble.getRangoQ();

                    double[] ArregloDou = new double[Integer.parseInt(datDou)];
                    for (int i = 0; i < Integer.parseInt(datDou); i++) {

                            ArregloDou[i] = (float)ThreadLocalRandom.current().nextDouble(pVarDou,qVarDou);


                    }



                    tcDouble.setArrD(ArregloDou);


                    String rangosDou = pVarDou+", "+qVarDou;



                    salidaDatos(tcDouble.getTipoDeDato(), rangosDou,ArregloDou);


                    media(tcDouble,ArregloDou,Integer.parseInt(datDou));
                    mediana(tcDouble,Integer.parseInt(datDou));
                    rangoMedio(tcDouble,pVarDou,qVarDou);
                    moda(tcDouble,ArregloDou);
                    varianza(tcDouble,ArregloDou,Integer.parseInt(datDou));
                    desviacion(tcDouble,ArregloDou,Integer.parseInt(datDou));

                    break;

            }


        }catch (Exception e){
            System.err.println("Error");
        }


    }



    public void salidaDatos(String tipo, String rangos,int arr[]){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Tipo de dato elegido por el usuario: "+tipo, "Tipo de dato", JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Rangos elegidos por el usuario: "+rangos, "Rango", JOptionPane.DEFAULT_OPTION);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public void salidaDatos(String tipo, String rangos,double arr[]){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Tipo de dato elegido por el usuario: "+tipo, "Tipo de dato", JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Rangos elegidos por el usuario: "+rangos, "Rango", JOptionPane.DEFAULT_OPTION);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


    public String rangoP(){
        String p = "";
        try {
             p = JOptionPane.showInputDialog("Ingresa el valor del rango 'p' ");

        }catch (Exception e){
            System.err.println("Error");
        }
        return  p;
    }


    public String  rangoQ(){
        String q= "q";
        try {
         q = JOptionPane.showInputDialog("Ingresa el valor del rango  'Q'  " );
        }catch (Exception e){
            System.err.println("Error");
        }

        return q;
    }



    public static void media(media med, int arre[], int data){
        med.media(arre,data);

    }
    public static void media(media med, double arre[], int data){
        med.media(arre,data);

    }

    public static void mediana(mediana med, int data){
        med.mediana(data);
    }

    public static void moda(moda moda, int arr[]){
        moda.moda(arr);
    }
    public static void moda(moda moda, double arr[]){
        moda.moda(arr);
    }


    public static void rangoMedio(rangoMedio rango, int maximo, int minimo ){
        rango.rango(maximo, minimo);

    }


    public static void varianza(varianza varianza,double[] arre, int data){
        varianza.varianza(arre,data);
    }

    public static void varianza(varianza varianza,int[] arre, int data){
        varianza.varianza(arre,data);
    }


    public static void desviacion(desviacion desviacion, double[] arre, int data){
        desviacion.desviacion(arre,data);

    }

    public static void desviacion(desviacion desviacion, int[] arre, int data){
        desviacion.desviacion(arre,data);

    }




}
