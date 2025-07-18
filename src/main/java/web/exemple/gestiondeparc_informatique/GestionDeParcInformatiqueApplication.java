package web.exemple.gestiondeparc_informatique;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import web.exemple.gestiondeparc_informatique.entities.*;
import web.exemple.gestiondeparc_informatique.repository.*;

import java.time.LocalDate;

@SpringBootApplication
public class GestionDeParcInformatiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeParcInformatiqueApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(
            EcranRepository ecranRepository,
            CarteVideoRepository carteVideoRepository,
            EmplacementRepository emplacementRepository,
            FournisseurRepository fournisseurRepository,
            GarantieRepository garantieRepository,
            LogicielRepository logicielRepository,
            UtilisateurRepository utilisateurRepository,
            MachineRepository machineRepository,
            PeripheriqueRepository peripheriqueRepository,
            DdurRepository ddurRepository,
            MarqueRepository marqueRepository) {
        return args -> {
            // Fournisseurs
            var f11 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Dell France")
                            .adresseF("Paris")
                            .telF("0123456789")
                            .codePF("67000")
                            .build()
            );

            var f12 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("HP France")
                            .adresseF("Lyon")
                            .telF("0987654321")
                            .codePF("30000")
                            .build()
            );
            var f1 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("HP France")
                            .adresseF("Lyon")
                            .telF("0987654321")
                            .codePF("69000")
                            .build());

            var f2 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Dell Technologies")
                            .adresseF("Paris")
                            .telF("0123456789")
                            .codePF("75000")
                            .build());

            var f3 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Lenovo France")
                            .adresseF("Marseille")
                            .telF("0612345678")
                            .codePF("13000")
                            .build());

            var f4 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Asus Europe")
                            .adresseF("Nice")
                            .telF("0789456123")
                            .codePF("06000")
                            .build());

            var f5 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Acer France")
                            .adresseF("Toulouse")
                            .telF("0543219876")
                            .codePF("31000")
                            .build());

            var f6 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Samsung Electronics")
                            .adresseF("Strasbourg")
                            .telF("0632567890")
                            .codePF("67000")
                            .build());

            var f7 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Apple France")
                            .adresseF("Bordeaux")
                            .telF("0754321987")
                            .codePF("33000")
                            .build());

            var f8 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Microsoft France")
                            .adresseF("Nantes")
                            .telF("0649873210")
                            .codePF("44000")
                            .build());

            var f9 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Sony Europe")
                            .adresseF("Rennes")
                            .telF("0698765432")
                            .codePF("35000")
                            .build());

            var f10 = fournisseurRepository.save(
                    Fournisseur.builder()
                            .nomF("Toshiba France")
                            .adresseF("Grenoble")
                            .telF("0678901234")
                            .codePF("38000")
                            .build());

            // Garanties
            var g11 = garantieRepository.save(Garantie.builder().dateDebutGarantie(LocalDate.parse("2014-11-06")).dureeGarantie(25).typeGarantie("type11").build());
            var g12 = garantieRepository.save(Garantie.builder().dateDebutGarantie(LocalDate.parse("2015-05-07")).dureeGarantie(30).typeGarantie("type11").build());

            var g1 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2000-01-01"))
                            .dureeGarantie(24)
                            .typeGarantie("type1")
                            .build());

            var g2 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2001-03-15"))
                            .dureeGarantie(36)
                            .typeGarantie("type2")
                            .build());

            var g3 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2005-07-20"))
                            .dureeGarantie(12)
                            .typeGarantie("réparation")
                            .build());

            var g4 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2010-10-05"))
                            .dureeGarantie(48)
                            .typeGarantie("remplacement")
                            .build());

            var g5 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2015-01-30"))
                            .dureeGarantie(18)
                            .typeGarantie("type3")
                            .build());

            var g6 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2018-06-10"))
                            .dureeGarantie(60)
                            .typeGarantie("premium")
                            .build());

            var g7 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2019-11-25"))
                            .dureeGarantie(6)
                            .typeGarantie("basique")
                            .build());

            var g8 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2021-08-01"))
                            .dureeGarantie(24)
                            .typeGarantie("standard")
                            .build());

            var g9 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2022-02-14"))
                            .dureeGarantie(36)
                            .typeGarantie("étendue")
                            .build());

            var g10 = garantieRepository.save(
                    Garantie.builder()
                            .dateDebutGarantie(LocalDate.parse("2023-12-01"))
                            .dureeGarantie(12)
                            .typeGarantie("pièces uniquement")
                            .build());


            // Emplacements
            var e11 = emplacementRepository.save(Emplacement.builder().nomEmplacement("Bureau 101").service("reception").build());
            var e12 = emplacementRepository.save(Emplacement.builder().nomEmplacement("Salle serveur").service("control").build());
            var e1 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Bureau 101")
                            .service("Réception")
                            .build());

            var e2 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Bureau 102")
                            .service("Informatique")
                            .build());

            var e3 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Salle Serveurs")
                            .service("IT Support")
                            .build());

            var e4 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Open Space A")
                            .service("Développement")
                            .build());

            var e5 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Bureau 201")
                            .service("Ressources Humaines")
                            .build());

            var e6 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Bureau Direction")
                            .service("Direction Générale")
                            .build());

            var e7 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Salle Réunion 1")
                            .service("Administratif")
                            .build());

            var e8 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Bureau Comptabilité")
                            .service("Comptabilité")
                            .build());

            var e9 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Local Technique")
                            .service("Maintenance")
                            .build());

            var e10 = emplacementRepository.save(
                    Emplacement.builder()
                            .nomEmplacement("Laboratoire")
                            .service("Recherche")
                            .build());
            var mar11 = marqueRepository.save(Marque.builder().nomMarque("Marque 11").build());
            var mar12 = marqueRepository.save(Marque.builder().nomMarque("Marque 12").build());

            var mar1 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Marque 1")
                            .build());

            var mar2 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Marque 2")
                            .build());

            var mar3 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Lenovo")
                            .build());

            var mar4 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Dell")
                            .build());

            var mar5 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("HP")
                            .build());

            var mar6 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Acer")
                            .build());

            var mar7 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Asus")
                            .build());

            var mar8 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Samsung")
                            .build());

            var mar9 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Apple")
                            .build());

            var mar10 = marqueRepository.save(
                    Marque.builder()
                            .nomMarque("Toshiba")
                            .build());

            // Écrans
            var ec11 = ecranRepository.save(Ecran.builder().tailleEcran("24").fournisseur(f11).garantie(g11).marque(mar11).build());
            var ec12 = ecranRepository.save(Ecran.builder().tailleEcran("27").fournisseur(f12).garantie(g12).marque(mar12).build());
            var ec1 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("24")
                            .fournisseur(f1)
                            .garantie(g1)
                            .marque(mar1)
                            .build());

            var ec2 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("27")
                            .fournisseur(f2)
                            .garantie(g2)
                            .marque(mar2)
                            .build());

            var ec3 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("22")
                            .fournisseur(f3)
                            .garantie(g3)
                            .marque(mar3)
                            .build());

            var ec4 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("32")
                            .fournisseur(f4)
                            .garantie(g4)
                            .marque(mar4)
                            .build());

            var ec5 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("29")
                            .fournisseur(f5)
                            .garantie(g5)
                            .marque(mar5)
                            .build());

            var ec6 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("34")
                            .fournisseur(f6)
                            .garantie(g6)
                            .marque(mar6)
                            .build());

            var ec7 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("21")
                            .fournisseur(f7)
                            .garantie(g7)
                            .marque(mar7)
                            .build());

            var ec8 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("23")
                            .fournisseur(f8)
                            .garantie(g8)
                            .marque(mar8)
                            .build());

            var ec9 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("26")
                            .fournisseur(f9)
                            .garantie(g9)
                            .marque(mar9)
                            .build());

            var ec10 = ecranRepository.save(
                    Ecran.builder()
                            .tailleEcran("28")
                            .fournisseur(f10)
                            .garantie(g10)
                            .marque(mar10)
                            .build());

            // Disques Durs
            var dd11 = ddurRepository.save(Ddur.builder().capaciteDD("512").typeDD("SSD").build());
            var dd12 = ddurRepository.save(Ddur.builder().capaciteDD("1024").typeDD("HDD").build());
            var dd1 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("512")
                            .typeDD("SSD")
                            .build());

            var dd2 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("1024")
                            .typeDD("SSD")
                            .build());

            var dd3 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("2048")
                            .typeDD("HDD")
                            .build());

            var dd4 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("256")
                            .typeDD("SSD")
                            .build());

            var dd5 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("500")
                            .typeDD("HDD")
                            .build());

            var dd6 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("1000")
                            .typeDD("SSD")
                            .build());

            var dd7 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("320")
                            .typeDD("HDD")
                            .build());

            var dd8 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("750")
                            .typeDD("HDD")
                            .build());

            var dd9 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("128")
                            .typeDD("SSD")
                            .build());

            var dd10 = ddurRepository.save(
                    Ddur.builder()
                            .capaciteDD("1500")
                            .typeDD("HDD")
                            .build());

            // Cartes Vidéo
            var cv11 = carteVideoRepository.save(CarteVideo.builder().nomCarte("NVIDIA GTX 1660").typeCarte("6").build());

            var cv12 = carteVideoRepository.save(CarteVideo.builder().nomCarte("AMD RX 5600").typeCarte("8").build());
            var cv1 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("NVIDIA GTX 1660")
                            .typeCarte("6")
                            .build());

            var cv2 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("AMD Radeon RX 580")
                            .typeCarte("8")
                            .build());

            var cv3 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("NVIDIA RTX 3070")
                            .typeCarte("8")
                            .build());

            var cv4 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("Intel Iris Xe")
                            .typeCarte("4")
                            .build());

            var cv5 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("NVIDIA GTX 1050 Ti")
                            .typeCarte("4")
                            .build());

            var cv6 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("AMD Radeon RX 6700 XT")
                            .typeCarte("12")
                            .build());

            var cv7 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("NVIDIA RTX 3080 Ti")
                            .typeCarte("12")
                            .build());

            var cv8 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("AMD Radeon RX 5700")
                            .typeCarte("8")
                            .build());

            var cv9 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("NVIDIA Quadro P2200")
                            .typeCarte("5")
                            .build());

            var cv10 = carteVideoRepository.save(
                    CarteVideo.builder()
                            .nomCarte("Intel UHD Graphics 620")
                            .typeCarte("2")
                            .build());

            // Machines
            var machine11 = Machine.builder()
                    .processeur("Intel i7")
                    .fournisseur(f1)
                    .garantie(g1)
                    .marque(mar1)
                    .ecran(ec1)
                    .disqueDur(dd1)
                    .carteVideo(cv1)
                    .emplacement(e1)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2020-10-20"))
                    .ram("4gb")
                    .adrIP("172.168.1.1")
                    .build();
            var machine12 = Machine.builder()
                    .processeur("AMD Ryzen 5")
                    .fournisseur(f2)
                    .garantie(g2)
                    .marque(mar2)
                    .ecran(ec2)
                    .disqueDur(dd2)
                    .carteVideo(cv2)
                    .emplacement(e2)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2020-10-20"))
                    .ram("8GB")
                    .adrIP("172.168.1.1")
                    .build();
            var machine1 = Machine.builder()
                    .processeur("Intel i7")
                    .fournisseur(f1)
                    .garantie(g1)
                    .marque(mar1)
                    .ecran(ec1)
                    .disqueDur(dd1)
                    .carteVideo(cv1)
                    .emplacement(e1)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2020-10-20"))
                    .ram("8GB")
                    .adrIP("172.168.1.1")
                    .build();

            var machine2 = Machine.builder()
                    .processeur("AMD Ryzen 5")
                    .fournisseur(f2)
                    .garantie(g2)
                    .marque(mar2)
                    .ecran(ec2)
                    .disqueDur(dd2)
                    .carteVideo(cv2)
                    .emplacement(e2)
                    .typeMachine("portable")
                    .dateAchat(LocalDate.parse("2021-05-10"))
                    .ram("16GB")
                    .adrIP("172.168.1.2")
                    .build();

            var machine3 = Machine.builder()
                    .processeur("Intel i5")
                    .fournisseur(f3)
                    .garantie(g3)
                    .marque(mar3)
                    .ecran(ec3)
                    .disqueDur(dd3)
                    .carteVideo(cv3)
                    .emplacement(e3)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2019-11-30"))
                    .ram("8GB")
                    .adrIP("172.168.1.3")
                    .build();

            var machine4 = Machine.builder()
                    .processeur("AMD Ryzen 7")
                    .fournisseur(f4)
                    .garantie(g4)
                    .marque(mar4)
                    .ecran(ec4)
                    .disqueDur(dd4)
                    .carteVideo(cv4)
                    .emplacement(e4)
                    .typeMachine("portable")
                    .dateAchat(LocalDate.parse("2022-01-15"))
                    .ram("32GB")
                    .adrIP("172.168.1.4")
                    .build();

            var machine5 = Machine.builder()
                    .processeur("Intel Xeon")
                    .fournisseur(f5)
                    .garantie(g5)
                    .marque(mar5)
                    .ecran(ec5)
                    .disqueDur(dd5)
                    .carteVideo(cv5)
                    .emplacement(e5)
                    .typeMachine("serveur")
                    .dateAchat(LocalDate.parse("2018-07-23"))
                    .ram("64GB")
                    .adrIP("172.168.1.5")
                    .build();

            var machine6 = Machine.builder()
                    .processeur("Intel i3")
                    .fournisseur(f6)
                    .garantie(g6)
                    .marque(mar6)
                    .ecran(ec6)
                    .disqueDur(dd6)
                    .carteVideo(cv6)
                    .emplacement(e6)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2020-04-02"))
                    .ram("4GB")
                    .adrIP("172.168.1.6")
                    .build();

            var machine7 = Machine.builder()
                    .processeur("AMD Ryzen 3")
                    .fournisseur(f7)
                    .garantie(g7)
                    .marque(mar7)
                    .ecran(ec7)
                    .disqueDur(dd7)
                    .carteVideo(cv7)
                    .emplacement(e7)
                    .typeMachine("portable")
                    .dateAchat(LocalDate.parse("2023-03-12"))
                    .ram("8GB")
                    .adrIP("172.168.1.7")
                    .build();

            var machine8 = Machine.builder()
                    .processeur("Intel i9")
                    .fournisseur(f8)
                    .garantie(g8)
                    .marque(mar8)
                    .ecran(ec8)
                    .disqueDur(dd8)
                    .carteVideo(cv8)
                    .emplacement(e8)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2021-12-01"))
                    .ram("32GB")
                    .adrIP("172.168.1.8")
                    .build();

            var machine9 = Machine.builder()
                    .processeur("AMD Ryzen 9")
                    .fournisseur(f9)
                    .garantie(g9)
                    .marque(mar9)
                    .ecran(ec9)
                    .disqueDur(dd9)
                    .carteVideo(cv9)
                    .emplacement(e9)
                    .typeMachine("portable")
                    .dateAchat(LocalDate.parse("2019-08-19"))
                    .ram("16GB")
                    .adrIP("172.168.1.9")
                    .build();

            var machine10 = Machine.builder()
                    .processeur("Intel Pentium")
                    .fournisseur(f10)
                    .garantie(g10)
                    .marque(mar10)
                    .ecran(ec10)
                    .disqueDur(dd10)
                    .carteVideo(cv10)
                    .emplacement(e10)
                    .typeMachine("bureau")
                    .dateAchat(LocalDate.parse("2017-06-05"))
                    .ram("4GB")
                    .adrIP("172.168.1.10")
                    .build();


            machineRepository.save(machine1);
            machineRepository.save(machine2);
            machineRepository.save(machine3);
            machineRepository.save(machine4);
            machineRepository.save(machine5);
            machineRepository.save(machine6);
            machineRepository.save(machine7);
            machineRepository.save(machine8);
            machineRepository.save(machine9);
            machineRepository.save(machine10);
            machineRepository.save(machine11);
            machineRepository.save(machine12);


            // Périphériques
            var p1 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f1)
                            .nomMateriel("Clavier Logitech")
                            .typeP("Clavier")
                            .garantie(g1)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.101")
                            .build());

            var p2 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f2)
                            .nomMateriel("Souris Microsoft")
                            .typeP("Souris")
                            .garantie(g2)
                            .etatMateriel("Utilisé")
                            .adrIPMateriel("192.168.0.102")
                            .build());

            var p3 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f3)
                            .nomMateriel("Imprimante HP")
                            .typeP("Imprimante")
                            .garantie(g3)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.103")
                            .build());

            var p4 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f4)
                            .nomMateriel("Scanner Canon")
                            .typeP("Scanner")
                            .garantie(g4)
                            .etatMateriel("Reconditionné")
                            .adrIPMateriel("192.168.0.104")
                            .build());

            var p5 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f5)
                            .nomMateriel("Webcam Logitech")
                            .typeP("Webcam")
                            .garantie(g5)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.105")
                            .build());

            var p6 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f6)
                            .nomMateriel("Casque Bose")
                            .typeP("Casque Audio")
                            .garantie(g6)
                            .etatMateriel("Utilisé")
                            .adrIPMateriel("192.168.0.106")
                            .build());

            var p7 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f7)
                            .nomMateriel("Enceinte JBL")
                            .typeP("Enceinte")
                            .garantie(g7)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.107")
                            .build());

            var p8 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f8)
                            .nomMateriel("Dock USB-C")
                            .typeP("Station d'accueil")
                            .garantie(g8)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.108")
                            .build());

            var p9 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f9)
                            .nomMateriel("Disque Dur Externe Seagate")
                            .typeP("Stockage")
                            .garantie(g9)
                            .etatMateriel("Reconditionné")
                            .adrIPMateriel("192.168.0.109")
                            .build());

            var p10 = peripheriqueRepository.save(
                    Peripherique.builder()
                            .fournisseur(f10)
                            .nomMateriel("Projecteur Epson")
                            .typeP("Projecteur")
                            .garantie(g10)
                            .etatMateriel("Neuf")
                            .adrIPMateriel("192.168.0.110")
                            .build());
            peripheriqueRepository.save(p1);
            peripheriqueRepository.save(p2);
            peripheriqueRepository.save(p3);
            peripheriqueRepository.save(p4);
            peripheriqueRepository.save(p5);
            peripheriqueRepository.save(p6);
            peripheriqueRepository.save(p7);
            peripheriqueRepository.save(p8);
            peripheriqueRepository.save(p9);
            peripheriqueRepository.save(p10);





            // Logiciels
            var l1 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Microsoft Office")
                            .typeL("Suite bureautique")
                            .licenceL("Commerciale")
                            .versionL("2019")
                            .editeurL("Microsoft")
                            .numSerieL("MSOFF-2019-1234")
                            .dateL(LocalDate.parse("2019-05-01"))
                            .build());

            var l2 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Adobe Photoshop")
                            .typeL("Édition d'image")
                            .licenceL("Commerciale")
                            .versionL("22.3")
                            .editeurL("Adobe")
                            .numSerieL("ADBE-PS-223")
                            .dateL(LocalDate.parse("2021-03-15"))
                            .build());

            var l3 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("IntelliJ IDEA")
                            .typeL("IDE")
                            .licenceL("Commerciale")
                            .versionL("2023.1")
                            .editeurL("JetBrains")
                            .numSerieL("JB-IDEA-9876")
                            .dateL(LocalDate.parse("2023-02-20"))
                            .build());

            var l4 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Mozilla Firefox")
                            .typeL("Navigateur Web")
                            .licenceL("Open Source")
                            .versionL("114.0")
                            .editeurL("Mozilla Foundation")
                            .numSerieL("FF-114-2025")
                            .dateL(LocalDate.parse("2025-07-01"))
                            .build());

            var l5 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Slack")
                            .typeL("Communication")
                            .licenceL("Freemium")
                            .versionL("4.28")
                            .editeurL("Slack Technologies")
                            .numSerieL("SLK-428-2024")
                            .dateL(LocalDate.parse("2024-11-15"))
                            .build());

            var l6 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Visual Studio Code")
                            .typeL("IDE")
                            .licenceL("Open Source")
                            .versionL("1.80")
                            .editeurL("Microsoft")
                            .numSerieL("VS-1.80-2025")
                            .dateL(LocalDate.parse("2025-06-20"))
                            .build());

            var l7 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("AutoCAD")
                            .typeL("CAO")
                            .licenceL("Commerciale")
                            .versionL("2023")
                            .editeurL("Autodesk")
                            .numSerieL("ACAD-2023-5678")
                            .dateL(LocalDate.parse("2023-09-10"))
                            .build());

            var l8 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Zoom")
                            .typeL("Communication vidéo")
                            .licenceL("Freemium")
                            .versionL("5.15")
                            .editeurL("Zoom Video Communications")
                            .numSerieL("ZM-515-2024")
                            .dateL(LocalDate.parse("2024-04-05"))
                            .build());

            var l9 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("7-Zip")
                            .typeL("Compression")
                            .licenceL("Open Source")
                            .versionL("22.01")
                            .editeurL("Igor Pavlov")
                            .numSerieL("7Z-2201-OSS")
                            .dateL(LocalDate.parse("2022-12-30"))
                            .build());

            var l10 = logicielRepository.save(
                    Logiciel.builder()
                            .nomL("Docker")
                            .typeL("Virtualisation")
                            .licenceL("Open Source")
                            .versionL("24.0")
                            .editeurL("Docker, Inc.")
                            .numSerieL("DKR-240-2025")
                            .dateL(LocalDate.parse("2025-07-10"))
                            .build());
            logicielRepository.save(l1);
            logicielRepository.save(l2);
            logicielRepository.save(l3);
            logicielRepository.save(l4);
            logicielRepository.save(l5);
            logicielRepository.save(l6);
            logicielRepository.save(l7);
            logicielRepository.save(l8);
            logicielRepository.save(l9);
            logicielRepository.save(l10);


            // Utilisateurs avec BCrypt
            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("admin")
                    .prenomU("admin")
                    .droitU("admin")
                    .build());
            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("tech1")
                    .prenomU("tech")
                    .droitU("admin")
                    .build());
            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("user1")
                    .prenomU("user1")
                    .droitU("user")
                    .build());
            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("alice")
                    .prenomU("Alice")
                    .droitU("admin")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("bob")
                    .prenomU("Robert")
                    .droitU("user")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("carla")
                    .prenomU("Carla")
                    .droitU("manager")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("david")
                    .prenomU("David")
                    .droitU("guest")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("emily")
                    .prenomU("Emily")
                    .droitU("user")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("frank")
                    .prenomU("Franklin")
                    .droitU("editor")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("george")
                    .prenomU("Georges")
                    .droitU("admin")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("hannah")
                    .prenomU("Hannah")
                    .droitU("user")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("ivan")
                    .prenomU("Ivan")
                    .droitU("moderator")
                    .build());

            utilisateurRepository.save(Utilisateur.builder()
                    .nomU("julie")
                    .prenomU("Julie")
                    .droitU("manager")
                    .build());
            var u1 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Dupont")
                            .prenomU("Jean")
                            .droitU("ADMIN")
                            .build());

            var u2 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Martin")
                            .prenomU("Sophie")
                            .droitU("USER")
                            .build());

            var u3 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Durand")
                            .prenomU("Pierre")
                            .droitU("USER")
                            .build());

            var u4 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Lemoine")
                            .prenomU("Claire")
                            .droitU("MODERATOR")
                            .build());

            var u5 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Moreau")
                            .prenomU("Luc")
                            .droitU("ADMIN")
                            .build());

            var u6 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Petit")
                            .prenomU("Julie")
                            .droitU("USER")
                            .build());

            var u7 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Rousseau")
                            .prenomU("Antoine")
                            .droitU("USER")
                            .build());

            var u8 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Garnier")
                            .prenomU("Isabelle")
                            .droitU("MODERATOR")
                            .build());

            var u9 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Faure")
                            .prenomU("Nicolas")
                            .droitU("USER")
                            .build());

            var u10 = utilisateurRepository.save(
                    Utilisateur.builder()
                            .nomU("Bertrand")
                            .prenomU("Céline")
                            .droitU("ADMIN")
                            .build());
            utilisateurRepository.save(u1);
            utilisateurRepository.save(u2);
            utilisateurRepository.save(u3);
            utilisateurRepository.save(u4);
            utilisateurRepository.save(u5);
            utilisateurRepository.save(u6);
            utilisateurRepository.save(u7);
            utilisateurRepository.save(u8);
            utilisateurRepository.save(u9);
            utilisateurRepository.save(u10);


        };
    }



}
