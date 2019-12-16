package bl.Construccion.Coordenadas;

public class CoordenasAtaque {
    public static int[] x1 = {0,1,0,-1,1,-1,-1,1};
    public static int[] y1 = {1,0,-1,0,1,-1,1,-1};

    public static int[] x2 = {0,1,2,0,-1,-2,0,1,2,0,-1,-2};
    public static int[] y2 = {2,1,0,-2,-1,0,-2,-1,0,2,1,0};

    public static int[] x3 = {0,1,2,3,0,-1,-2,-3,0,1,2,3,0,-1,-2,-3};
    public static int[] y3 = {3,2,1,0,-3,-2,-1,0,-3,-2,-1,0,3,2,1,0};

    public static int[] x4 = {0,1,2,3,4,0,-1,-2,-3,-4,0,1,2,3,4,0,-1,-2,-3,-4};
    public static int[] y4 = {4,3,2,1,0,-4,-3,-2,-1,0,-4,-3,-2,-1,0,4,3,2,1,0};

    public static int[] getX1() {
        return x1;
    }

    public static int[] getY1() {
        return y1;
    }

    public static int[] getX2() {
        return x2;
    }

    public static int[] getY2() {
        return y2;
    }

    public static int[] getX3() {
        return x3;
    }

    public static int[] getY3() {
        return y3;
    }

    public static int[] getX4() {
        return x4;
    }

    public static int[] getY4() {
        return y4;
    }

    public static boolean validarAtaqueAlcanze4(int x, int y){
        boolean response = validarAtaqueAlcanze3(x,y);
        if(!response){
            int x4[] = getX4();
            int y4[] = getY4();
            for (int i = 0; i < x4.length; i++){
                if(x4[i] == x && y4[i] == y){
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

    public static boolean validarAtaqueAlcanze3(int x, int y){
        boolean response = validarAtaqueAlcanze2(x,y);
        if(!response){
            int x3[] = getX3();
            int y3[] = getY3();
            for (int i = 0; i < x3.length; i++){
                if(x3[i] == x && y3[i] == y){
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

    public static boolean validarAtaqueAlcanze2(int x, int y){
        boolean response = validarAtaqueAlcanze1(x,y);
        if(!response){
            int x2[] = getX2();
            int y2[] = getY2();
            for (int i = 0; i < x2.length; i++){
                if(x2[i] == x && y2[i] == y){
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

    public static boolean validarAtaqueAlcanze1(int x, int y){
        int x1[] = getX1();
        int y1[] = getY1();
        boolean response = false;
        for (int i = 0; i < x1.length; i++){
            if(x1[i] == x && y1[i] == y){
                response = true;
                break;
            }
        }
        return response;
    }
}
