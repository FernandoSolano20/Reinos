package ui;

import bl.Factory.FabricaTropa;

public class Main {
    public static void main(String[] args) {
        FabricaTropa fac = new FabricaTropa();
        System.out.println(fac.crearTropa(10 , 1 ,4 ,10 ,3 ,3 ,3 ,2).getNombre());
        System.out.println(fac.crearTropa(10 , 2 ,1 ,15 ,6 ,2 ,5 ,2).getNombre());
        System.out.println(fac.crearTropa(15 , 3 ,2 ,25 ,10 ,1 ,10 ,6).getNombre());
        System.out.println(fac.crearTropa(10 , 4 ,3 ,10 ,6 ,2 ,3 ,2).getNombre());
        System.out.println(fac.crearTropa(10 , 5 ,2 ,5 ,3 ,4 ,3 ,2).getNombre());
        System.out.println(fac.crearTropa(10 , 6 ,1 ,15 ,4 ,6 ,4 ,6).getNombre());
        System.out.println(fac.crearTropa(2 , 7 ,3 ,5 ,1 ,5 ,1 ,10).getNombre());
        System.out.println(fac.crearTropa(2 , 8 ,3 ,5 ,1 ,5 ,1 ,10).getNombre());
        System.out.println(fac.crearTropa(30 , 9 ,20).getNombre());
        System.out.println(fac.crearTropa(3 , 10 ,2, 5, 2).getNombre());
        System.out.println(fac.crearTropa(3 , 10 ,2, 8, 5).getNombre());
    }
}
