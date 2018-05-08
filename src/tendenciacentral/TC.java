package tendenciacentral;

import tendenciacentral.interfaces.*;

public class TC implements desviacion, media, mediana, moda, rangoMedio, varianza {

    /**
     * public double desviacionPob;
     public double desviacionMuestral;
     public double media;
     public double mediana;
     public double moda;
     public double rango;
     public double varianza;
     */

    public int arrI[];
    public double arrD[];
    public String tipoDeDato;
    public int rangoP;
    public int rangoQ;
    public int dataTotal;



    public TC(double[] arrD, String tipoDeDato, int rangoP, int rangoQ, int dataTotal) {
        this.arrD = arrD;
        this.tipoDeDato = tipoDeDato;
        this.rangoP = rangoP;
        this.rangoQ = rangoQ;
        this.dataTotal = dataTotal;
    }

    public TC(int[] arrI, String tipoDeDato, int rangoP, int rangoQ, int dataTotal) {
        this.arrI = arrI;
        this.tipoDeDato = tipoDeDato;
        this.rangoP = rangoP;
        this.rangoQ = rangoQ;
        this.dataTotal = dataTotal;
    }

    public TC() {
        arrI = new int[dataTotal];
        arrD = new double[dataTotal];
    }


    public int[] getArrI() {
        return arrI;
    }

    public void setArrI(int[] arrI) {
        this.arrI = arrI;
    }

    public double[] getArrD() {
        return arrD;
    }

    public void setArrD(double[] arrD) {
        this.arrD = arrD;
    }

    public String getTipoDeDato() {
        return tipoDeDato;
    }

    public void setTipoDeDato(String tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }

    public int getRangoP() {
        return rangoP;
    }

    public void setRangoP(int rangoP) {
        this.rangoP = rangoP;
    }

    public int getRangoQ() {
        return rangoQ;
    }

    public void setRangoQ(int rangoQ) {
        this.rangoQ = rangoQ;
    }

    public int getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(int dataTotal) {
        this.dataTotal = dataTotal;
    }

    @Override
    public void desviacion(double[] arre, int data) {
        float media = 0;
        double varianza = 0.0;
        double desviacion= 0.0;
        double sumatoria = 0.0;

        for (int i = 0; i < data; i++ ){



            sumatoria = sumatoria + arre[i];

        }

        media = (float) (sumatoria / data);

        for(int i = 0 ; i < data; i++){
            double rango;
            rango = Math.pow(arre[i] - media, 2f);
            varianza = varianza + rango;
        }

        varianza = varianza / data;//suma de diferencias sobre "n"

        desviacion = Math.sqrt(varianza);

    }

    @Override
    public void desviacion(int[] arre, int data) {
        float media = 0;
        double varianza = 0.0;
        double desviacion= 0.0;
        double sumatoria = 0.0;

        for (int i = 0; i < data; i++ ){



            sumatoria = sumatoria + arre[i];

        }

        media = (float) (sumatoria / data);

        for(int i = 0 ; i < data; i++){
            double rango;
            rango = Math.pow(arre[i] - media, 2f);
            varianza = varianza + rango;
        }

        varianza = varianza / data;//suma de diferencias sobre "n"

        desviacion = Math.sqrt(varianza);

    }


    @Override
    public void media(int[] arre, int data) {


        int sum = 0;
        int x;

        for (int i = 0; i < arre.length; i++) {

            sum = sum + arre[i];

        }

        x = sum / data;

    }

    @Override
    public void media(double[] arre, int data) {

        double sum = 0;
        double x;

        for (int i = 0; i < arre.length; i++) {

            sum = sum + arre[i];

        }

        x = sum / data;
    }



    @Override
    public void varianza(double[] arre, int data) {


        float media = 0;
        double varianza = 0.0;
        double desviacion= 0.0;
        double sumatoria = 0.0;

        for (int i = 0; i < data; i++ ){



            sumatoria = sumatoria + arre[i];

        }

        media = (float) (sumatoria / data);


        for(int i = 0 ; i < data; i++){
            double rango;
            rango = Math.pow(arre[i] - media, 2f);
            varianza = varianza + rango;
        }

        varianza = varianza / 10f;//suma de diferencias sobre "n"

    }

    @Override
    public void varianza(int[] arre, int data) {


        float media = 0;
        double varianza = 0.0;
        double desviacion= 0.0;
        double sumatoria = 0.0;

        for (int i = 0; i < data; i++ ){



            sumatoria = sumatoria + arre[i];

        }

        media = (float) (sumatoria / data);


        for(int i = 0 ; i < data; i++){
            double rango;
            rango = Math.pow(arre[i] - media, 2f);
            varianza = varianza + rango;
        }

        varianza = varianza / 10f;//suma de diferencias sobre "n"

    }

    @Override
    public void mediana(int data) {

        double mediana = 0;
        if(data % 2 == 0 && data != 0){
            //par

            mediana = (data / 2) + 1;
            
        }else if(data == 0){
        }

        else{
            //impar
            

            mediana = data / 2;
        }



    }


    @Override
    public void moda(int[] arr) {


        int maximaVecesQueSeRepite = 0;
        int moda = 0;
        int M[] = arr;

        for(int i=0; i<M.length; i++){
            int vecesQueSeRepite = 0;
            for(int j=0; j<M.length; j++){
                if(M[i] == M[j])
                    vecesQueSeRepite++;
            }
            if(vecesQueSeRepite > maximaVecesQueSeRepite){
                moda = M[i];
                maximaVecesQueSeRepite = vecesQueSeRepite;
            }
        }

        System.out.println("La moda es "+moda+" y se repitió "+maximaVecesQueSeRepite+" veces.");

    }



    @Override
    public void moda(double[] arr) {

        double maximaVecesQueSeRepite = 0;
        double moda = 0;
        double M[] = arr;

        for(int i=0; i<M.length; i++){
            int vecesQueSeRepite = 0;
            for(int j=0; j<M.length; j++){
                if(M[i] == M[j])
                    vecesQueSeRepite++;
            }
            if(vecesQueSeRepite > maximaVecesQueSeRepite){
                moda = M[i];
                maximaVecesQueSeRepite = vecesQueSeRepite;
            }
        }

        System.out.println("La moda es "+moda+" y se repitió "+maximaVecesQueSeRepite+" veces.");

    }

    @Override
    public void rango(int maximo, int minimo) {
        double rm = (maximo + minimo) / 2;
    }
}
