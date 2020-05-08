/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ
 * aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 08.05.2020
 *
 * Sogutucu sistemi calistiran program.
 *
 **/
package sogutmasistemi_nyat;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi {

    public int veriAl() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public boolean bilgiDogrulama() {
        System.out.println("Hesap bilgilerinize ulasiliyor...");
        return true;
    }

}
