import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa para simular BD de empleados
 * 
 * @author Sandra Martin, Israel Severiche, Jose Alvarez
 * @version 20190907
 */

public class empleados{
    private String name, dpto, poss;
    private int sal;

    public empleados(String name, String dpto, String poss, int sal){
        this.name = name;
        this.dpto = dpto;
        this.poss = poss;
        this.sal = sal;
    }

    public String getempname(){
        return this.name;
    }

    public String getdpto(){
        return this.dpto;
    }

    public String getposs(){
        return this.poss;
    }

    public int getsal(){
        return this.sal;
    }

    public void seedpto(){
        System.out.println("-Nombre: " +name);
        System.out.println("-Puesto: " +poss);
        System.out.println("-Salario: $"+sal);
    }

    public void seeposs(){
        System.out.println("-Nombre: " +name);
        System.out.println("-Departamento: " +dpto);
        System.out.println("-Salario: $"+sal);
    }

    public static void seeempdpto (ArrayList<empleados> bd){
        String dpto;
        empleados employee;
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿De cual de los departamento quiere conocer los empleados que hay?");
        dpto = teclado.nextLine();
        
        for(empleados newemp : bd){
            if (newemp.getdpto().equals(dpto)){
                newemp.seedpto();
            }
        }
    }

    public static void seeemposs(ArrayList<empleados> bd){
        String poss;
        empleados employee;
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿De cual de los puestos quiere conocer los empleados que hay?");
        poss = teclado.nextLine();
        for(empleados newemp : bd){
            if (newemp.getposs().equals(poss)){
                newemp.seeposs();
            }
        }
    }

    public static void main (String[] args){
        ArrayList<empleados> newempmer = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int select;
        String name;
        String dpto;
        String poss;
        int sal;
        empleados newemp;
        int qemp;

        do{
            System.out.println("Por favor seleccione una opción");
            System.out.println("Presione la tecla 1 para agregar un nuevo empleado a la base de datos.");
            System.out.println("Presione la tecla 2 para ver los empleados de un departamento.");
            System.out.println("Presione la tecla 3 para ver los empleados por puesto.");
            System.out.println("Presione la tecla 4 para ver todos los empleados.");
            System.out.println("Presione la tecla 0 para cerrar el programa.");
            select = teclado.nextInt();

            switch (select){
                case 1:
                teclado.nextLine();
                System.out.println("Inserte nombre y apellidos.");
                name = teclado.nextLine();
                System.out.println("¿En que departamento trabajará esta persona?");
                dpto = teclado.nextLine();
                System.out.println("¿Que puesto tendrá el empleado en este departamento?");
                poss = teclado.nextLine();
                System.out.println("¿Cual será el pago neto de este empleado?");
                sal = teclado.nextInt();

                newemp = new empleados(name, dpto, poss, sal);
                newempmer.add(newemp);

                break;

                case 2:
                seeempdpto(newempmer);
                break;

                case 3:
                seeemposs(newempmer);
                break;

                case 4:
                qemp = newempmer.size();
                System.out.println("En la empresa trabajan: "+qemp+ " empleados");
            }
        } while (select != 0);
    }
}