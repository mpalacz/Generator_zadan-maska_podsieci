import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static short losowaOsmioBitowaLiczba(){
        return (short) (Math.random() * 255);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean czyKontynuowacDzialanieProgramu = true, czyHosty; //czy hosty definiuje czy program ma losować ilość hostów czy ilość podsieci
        char klasaSieci;
        short iloscPodsieci, iloscHostow, maska;
        short[] adresSieci = new short[4];
        short[][][] podsieci = new short[3][4][4]; //pierwszy nawias - podsieci, drugi nawias - hosty, trzeci nawias - adres IPv4

        System.out.println("Program generujący przykładowe zadania na obliczenia maski podsieci\n");

        do {
            System.out.println("Podaj klasę sieci: ");
            klasaSieci = br.readLine().toUpperCase().charAt(0);

            System.out.println("Losować ilość hostów (H) czy podsieci (S)?");
            czyHosty = 'H' == br.readLine().toUpperCase().charAt(0);

            switch (klasaSieci){
                case 'A':
                    maska = (short) (Math.random() * (23 - 1) + 1);
                    adresSieci[3] = (short) (Math.random() * 127);
                    adresSieci[2] = 0;
                    adresSieci[1] = 0;
                    break;
                case 'B':
                    maska = (short) (Math.random() * (15 - 1) + 1);
                    adresSieci[3] = (short) (Math.random() * (191 - 128) + 128);
                    adresSieci[2] = losowaOsmioBitowaLiczba();
                    adresSieci[1] = 0;
                    break;
                case 'C':
                    maska = (short) (Math.random() * (7 - 1) + 1);
                    adresSieci[3] = (short) (Math.random() * (223 - 192) + 192);
                    adresSieci[2] = losowaOsmioBitowaLiczba();
                    adresSieci[1] = losowaOsmioBitowaLiczba();
                    if (czyHosty){
                        double min = Math.pow(2, maska - 1);
                        iloscHostow = (short) (Math.random() * (Math.pow(2, maska) - 2 - min) + min);
                        iloscPodsieci = (short) (Math.pow(2, 8 - maska));
                    } else {
                        double min = Math.pow(2, 8 - maska - 1);
                        iloscPodsieci = (short) (Math.random() * (Math.pow(2, 8 - maska) - min) + min);
                    }
                    break;
            }
            adresSieci[0] = 0;

            System.out.println("Wylosować ilość hostów (H) czy podsieci (S)?");


        } while (czyKontynuowacDzialanieProgramu == true);
    }
}
