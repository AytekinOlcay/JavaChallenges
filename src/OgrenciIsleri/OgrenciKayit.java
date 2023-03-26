package OgrenciIsleri;

import java.util.*;

/*
ÖĞRENCİ YÖNETİM PLATFORMU KODLAYINIZ.
1. BU PROGRAMDA ÖĞRENCİ KAYITLARI İLE İLGİLİ İŞLEMLER YAPILABİLMEKTEDİR. KAYITLARDA ŞU BİLGİLER OLMALIDIR:
    -AD SOYAD
    -KİMLİK NO
    -YAŞ
    -NUMARA
    -SINIF  BİLGİLERİNİ İÇERMELİDİR.
2. ============= İŞLEMLER =============
         1-EKLEME
         2-ARAMA
         3-LİSTELEME
         4-SİLME
         Q-ÇIKIŞ
    SEÇİMİNİZ:
  ŞEKLİNDE BİR MENÜ OLUŞTURULMALI.
3. ARAMA VE SİLME İŞLEMLERİ KİMLİK NO YA GÖRE YAPILMALIDIR.
NOT: PROJEYİ YAPARKEN NESNE YÖNELİMLİ PROGRAMLAMANIN BİZE SAĞLADIĞI İMKANLARI KULLANMAYA DİKKAT EDİNİZ.
 */
public class OgrenciKayit {
    static String ADSOYAD;
    static String TCKNO;
    static String YAS;
    static String OKULNO;
    static String SINIFI;
    static Scanner scan = new Scanner(System.in);
    static List<Student> ogrenci = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    private static void cikis() {
        System.out.println("**** PROGRAM BAŞARIYLA SONLANDIRILDI ****");
        System.exit(0);
    }

    private static void menu() {
        System.out.println(" Seçiminiz : \n" +
                "1-EKLEME\n" +
                "2-ARAMA \n" +
                "3-LİSTELEME\n" +
                "4-SİLME\n" +
                "Q-ÇIKIŞ \n");
        String secim = scan.nextLine(); // kullanıcının menu metodu ile seçeceği seçenekleri tutmak için;
        // string aldık.
        /*
         1-EKLEME
         2-ARAMA
         3-LİSTELEME
         4-SİLME
         Q-ÇIKIŞ
         */
        switch (secim) {
            case "1":
                ekleme();
                break;
            case "2":
                arama();
                break;
            case "3":
                listeleme();
                break;
            case "4":
                silme();
                break;
            case "q":
            case "Q":
                cikis();//
                break;
            default: {
                System.err.println("HATALI TUŞLAMA YAPTINIZ!");
                menu();
            }


        }


    }

    //ARAMA VE SİLME İŞLEMLERİ KİMLİK NO YA GÖRE YAPILMALIDIR.
    private static void silme() {
        System.out.println("*** SİLME ***\n");
        System.out.println("TCKN Girin");
        String girilentc = scan.nextLine();
        Student.deleteStudent(ogrenci, girilentc);
        System.out.println("*** ÖĞRENCİ BAŞARIYLA SİLİNDİ ***");
        menu();
    }

    private static void arama() {
        System.out.println("*** ARAMA ***\n");
        System.out.println("TCKN Girin");
        String girilentc = scan.nextLine();
        System.out.println(Student.findStudentByTckn(ogrenci, girilentc).toString());
        menu();
    }

    private static void listeleme() {
        System.out.println("*** TÜM ÖĞRENCİLERİN LİSTESİ *** ");
        Student.getAllStudents(ogrenci);
        menu();
    }

    private static void ekleme() {
        System.out.println("*** KAYIT EKLEME ***\n");
        System.out.println("ADI SOYADI:");
        ADSOYAD = scan.nextLine();
        System.out.println("TCKN: ");
        TCKNO = scan.nextLine();
        System.out.println("YAŞ: ");
        YAS = scan.nextLine();
        System.out.println("OKUL NO: ");
        OKULNO = scan.nextLine();
        System.out.println("SINIFI: ");
        SINIFI = scan.nextLine();
        Student.addNewStudent(ogrenci, TCKNO, ADSOYAD, YAS, OKULNO, SINIFI);
        System.out.println("*** KAYIT EKLENDİ ***\n");
        menu();
    }


}