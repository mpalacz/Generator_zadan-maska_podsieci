import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static short losowaOsmioBitowaLiczba(){
        return (short) (Math.random() * 255);
    }

    public static short[] wylosowanieSieci(char klasaSieci){
        short[] adresSieci = new short[4];

        switch (klasaSieci){
            case 'A':
                adresSieci[3] = (short) (Math.random() * 127);
                adresSieci[2] = 0;
                adresSieci[1] = 0;
                break;
            case 'B':
                adresSieci[3] = (short) (Math.random() * (191 - 128) + 128);
                adresSieci[2] = losowaOsmioBitowaLiczba();
                adresSieci[1] = 0;
                break;
            case 'C':
                adresSieci[3] = (short) (Math.random() * (223 - 192) + 192);
                adresSieci[2] = losowaOsmioBitowaLiczba();
                adresSieci[1] = losowaOsmioBitowaLiczba();
                break;
        }
        adresSieci[0] = 0;
        return adresSieci;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean czyKontynuowacDzialanieProgramu = true;
        char klasaSieci;
        short iloscPodsieci, iloscHostow;
        short[] adresSieci = new short[4];
        short[][][] podsieci = new short[3][4][4]; //pierwszy nawias - podsieci, drugi nawias - hosty, trzeci nawias - adres IPv4

        System.out.println("Program generujący przykładowe zadania na obliczenia maski podsieci\n");

        do {
            System.out.println("Podaj klasę sieci: ");
            klasaSieci = br.readLine().toUpperCase().charAt(0);

            System.out.println("Wylosować ilość hostów (H) czy podsieci (S)?");
            if (br.readLine().toUpperCase().charAt(0) == 'H'){
                short max = 0;
                switch (klasaSieci){
                    case 'A':
                        max = (short) (Math.pow(2, 23) - 2);
                        break;
                    case 'B':
                        max = (short) (Math.pow(2, 15) - 2);
                        break;
                    case 'C':
                        max = (short) (Math.pow(2, 7) - 2);
                        break;
                }
                iloscHostow = (short) (Math.random() * (max - 1) + 1);
                iloscPodsieci = (short) (Math.pow(2, ))
            }


        } while (czyKontynuowacDzialanieProgramu == true);
    }
}
