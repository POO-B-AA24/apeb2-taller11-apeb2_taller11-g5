package apeb_taller11;

import java.util.ArrayList;
import java.util.Scanner;

public class Problema2 {

    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        ArrayList<Menu> listaMenus = new ArrayList<>();
        int seguir;
        int otroCliente = 1;
        int menuSelec;
        Menu menu = null;
        Cuenta cuenta = null; 

        double valorMenuCarta = 10;
        double valorGuarnicionCarta = 3;
        double valorBebidaCarta = 1;
        double porcentajeServicioCarta = 10;
        String nombrePlatoCarta = "Papas Cocidas";

        double valorMenuDia = 3.5;
        double valorPostreDia = 1;
        double valorBebidaDia = 0.5;
        String nombrePlatoDia = "Arroz con Pollo";

        double valorMenuNinos = 3;
        double valorPastelNinos = 1;
        double valorHeladoNinos = 1;
        String nombrePlatoNinos = "Papas con nuggets";

        double valorMenuEconomico = 2;
        double porcentajeDescuentoEconomico = 10;
        String nombrePlatoEconomico = "Arroz con huevo";

        while (otroCliente == 1) {
            
            System.out.println("Ingrese un nombre para la cuenta");
            String nombreCuenta = put.nextLine();
            cuenta = new Cuenta(nombreCuenta, listaMenus, 15);
            seguir=1;
            while (seguir == 1) {
                System.out.println("""
                               Que menu desea el cliente?
                               [1] A la carta
                               [2] Del dia
                               [3] De ninos
                               [4] Economico
                               """);
                menuSelec = put.nextInt();
                switch (menuSelec) {
                    case 1:
                        menu = new MenuCarta(valorGuarnicionCarta, valorBebidaCarta,
                                porcentajeServicioCarta, nombrePlatoCarta,
                                valorMenuCarta);
                        break;
                    case 2:
                        menu = new MenuDia(valorPostreDia, valorBebidaDia,
                                nombrePlatoDia, valorMenuDia);
                        break;
                    case 3:
                        menu = new MenuNinos(valorHeladoNinos, valorPastelNinos,
                                nombrePlatoNinos, valorMenuNinos);
                        break;
                    case 4:
                        menu = new MenuEconomico(porcentajeDescuentoEconomico,
                                nombrePlatoEconomico, valorMenuEconomico);
                        break;
                }
                menu.calcularTotalMenu();
                cuenta.agregarMenuACuenta(menu);
                System.out.println("""
                                Desea agregar otro Menu?
                                [1] Si
                                [2] No
                                """);
                seguir = put.nextInt();

            }
            System.out.println(cuenta.imprimirFactura());
            cuenta.listaMenus.clear();
            System.out.println("""
                                Desea atender otro cliente?
                                [1] Si
                                [2] No
                                """);
            otroCliente = put.nextInt();
            put.nextLine();
        }

    }
}

class Cuenta {

    public String nombreCliente;
    public ArrayList<Menu> listaMenus;
    public double subTotal;
    public double valorCancelarTotal;
    public double iva;

    public Cuenta(String nombreCliente, ArrayList listaMenus, double iva) {
        this.nombreCliente = nombreCliente;
        this.listaMenus = listaMenus;
        this.iva = iva;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Menu menu : this.listaMenus) {
            subtotal += menu.valorMenu;
        }
        return subtotal;
    }

    public void agregarMenuACuenta(Menu menu) {
        listaMenus.add(menu);
    }

    public String imprimirFactura() {
        String factura = "=============CUENTA DE "+this.nombreCliente+"=============\n"
                + this.listaMenus
                + "\nSubtotal: " + calcularSubtotal()
                + "\nIVA: " + iva + "%"
                + "\nTotal a Pagar: " + (calcularSubtotal() + (calcularSubtotal() * (iva / 100)))
                + "\n===============================";
        
        return factura;
    }
}

abstract class Menu {

    public String nombrePlato;
    public double valorMenu;
    public double valorInicialMenu;

    public Menu(String nombrePlato, double valorInicialMenu) {
        this.nombrePlato = nombrePlato;
        this.valorInicialMenu = valorInicialMenu;
    }

    abstract public void calcularTotalMenu();

    @Override
    public String toString() {
        return "Menu{" + "nombrePlato=" + nombrePlato + ", valorMenu=" + valorMenu + ", valorInicialMenu=" + valorInicialMenu + '}';
    }

}

class MenuCarta extends Menu {

    public double valorGuarnicion;
    public double valorBebida;
    public double porcentajeServicio;

    public MenuCarta(double valorGuarnicion, double valorBebida, double porcentajeServicio,
            String nombrePlato, double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
    }

    @Override
    public void calcularTotalMenu() {
        this.valorMenu = this.valorInicialMenu + this.valorGuarnicion + this.valorBebida;
        this.valorMenu = this.valorMenu + ((this.porcentajeServicio / 100) * this.valorInicialMenu);
    }

    @Override
    public String toString() {
        return super.toString() + " MenuCarta{" + "valorGuarnicion=" + valorGuarnicion
                + ", valorBebida=" + valorBebida + ", porcentajeServicio=" + porcentajeServicio + "}\n";
    }

}

class MenuDia extends Menu {

    public double valorPostre;
    public double valorBebida;

    public MenuDia(double valorPostre, double valorBebida, String nombrePlato,
            double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    @Override
    public void calcularTotalMenu() {
        valorMenu = valorInicialMenu + valorPostre + valorBebida;
    }

    @Override
    public String toString() {
        return super.toString() + " MenuDia{" + "valorPostre=" + valorPostre + ", valorBebida=" + valorBebida + "}\n";
    }

}

class MenuNinos extends Menu {

    public double valorHelado;
    public double valorPastel;

    public MenuNinos(double valorHelado, double valorPastel, String nombrePlato,
            double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }

    @Override
    public void calcularTotalMenu() {
        valorMenu = valorInicialMenu + valorHelado + valorPastel;
    }

    @Override
    public String toString() {
        return super.toString() + " MenuNinos{" + "valorHelado=" + valorHelado + ", valorPastel=" + valorPastel + "}\n";
    }

}

class MenuEconomico extends Menu {

    public double porcentajeDescuento;

    public MenuEconomico(double porcentajeDescuento, String nombrePlato,
            double valorInicialMenu) {
        super(nombrePlato, valorInicialMenu);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void calcularTotalMenu() {
        valorMenu = valorInicialMenu;
        valorMenu = valorMenu - (valorInicialMenu * porcentajeDescuento);

    }

    @Override
    public String toString() {
        return super.toString() + " MenuEconomico{" + "porcentajeDescuento=" + porcentajeDescuento + "}\n";
    }

}
