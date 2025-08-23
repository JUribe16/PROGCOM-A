// Importamos Scanner para leer datos desde teclado
import java.util.Scanner;

public class Main {                     
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // EJERCICIO 1: Recibe un número e indica si es positivo


        System.out.println("\n[1] Número positivo");            // Mensaje de título
        System.out.print("Ingresa un número (double): ");       // Pedimos el dato
        double num1 = sc.nextDouble();                          // Leemos el número como double
        String msg1a = "";                                      // Guardará el resultado del if/else
        String msg1b = "";                                      // Guardará el resultado del if/else if
        String msg1c = "";                                      // Guardará el resultado del ternario

        // --- if/else ---
        if (num1 > 0) {                                         // Si el número es mayor a 0
            msg1a = "if/else -> Positivo";                      // Guardamos que es positivo
        } else {                                                 // Si no es mayor a 0
            msg1a = "if/else -> No es positivo";                // Guardamos que no es positivo
        }                                                        // Fin if/else
        System.out.println(msg1a);                               // Mostramos el resultado

        // --- if/else if ---
        if (num1 > 0) {                                         // Si es mayor a 0
            msg1b = "if/else if -> Positivo";                   // Positivo
        } else if (num1 == 0) {                                  // Si es exactamente 0
            msg1b = "if/else if -> Cero";                       // Cero
        } else {                                                 // En cualquier otro caso
            msg1b = "if/else if -> Negativo";                   // Negativo
        }                                                        // Fin if/else if
        System.out.println(msg1b);                               // Mostramos el resultado

        // --- operador ternario ---
        msg1c = (num1 > 0) ? "ternario -> Positivo"             // Si > 0
                           : "ternario -> No es positivo";      // Si no
        System.out.println(msg1c);                               // Mostramos el resultado


        // EJERCICIO 2: Recibe edad y dice si es mayor de edad (>=18)


        System.out.println("\n[2] Mayor de edad");               // Título
        System.out.print("Ingresa tu edad (int): ");             // Pedimos la edad
        int edad = sc.nextInt();                                 // Leemos como entero
        String msg2a = "";                                       // Resultado if/else
        String msg2b = "";                                       // Resultado if/else if
        String msg2c = "";                                       // Resultado ternario

        // --- if/else ---
        if (edad >= 18) {                                        // Si edad es mayor o igual a 18
            msg2a = "if/else -> Mayor de edad";                  // Mayor
        } else {                                                 // Si no
            msg2a = "if/else -> Menor de edad";                  // Menor
        }                                                        // Fin if/else
        System.out.println(msg2a);                               // Imprimimos

        // --- if/else if ---
        if (edad > 18) {                                         // Si es mayor a 18
            msg2b = "if/else if -> Mayor de edad";               // Mayor
        } else if (edad == 18) {                                 // Exactamente 18
            msg2b = "if/else if -> Exactamente 18";              // Caso exacto
        } else {                                                 // Resto
            msg2b = "if/else if -> Menor de edad";               // Menor
        }                                                        // Fin if/else if
        System.out.println(msg2b);                               // Imprimimos

        // --- ternario ---
        msg2c = (edad >= 18) ? "ternario -> Mayor de edad"       // Si >= 18
                             : "ternario -> Menor de edad";      // Si no
        System.out.println(msg2c);                               // Imprimimos



        // EJERCICIO 3: Recibe dos números e imprime el mayor
   
        System.out.println("\n[3] Mayor de dos números");        // Título
        System.out.print("Ingresa el primer número: ");          // Pedimos a
        double a = sc.nextDouble();                              // Leemos a
        System.out.print("Ingresa el segundo número: ");         // Pedimos b
        double b = sc.nextDouble();                              // Leemos b
        String msg3a = "";                                       // if/else
        String msg3b = "";                                       // if/else if
        String msg3c = "";                                       // ternario

        // --- if/else ---
        if (a > b) {                                             // Si a es mayor
            msg3a = "if/else -> Mayor: " + a;                    // Guardamos a
        } else {                                                 // Si no
            msg3a = "if/else -> Mayor: " + b;                    // Guardamos b (si son iguales, muestra b)
        }                                                        // Fin if/else
        System.out.println(msg3a);                               // Imprimimos

        // --- if/else if ---
        if (a > b) {                                             // a mayor
            msg3b = "if/else if -> Mayor: " + a;                 // a
        } else if (b > a) {                                      // b mayor
            msg3b = "if/else if -> Mayor: " + b;                 // b
        } else {                                                 // iguales
            msg3b = "if/else if -> Son iguales";                 // iguales
        }                                                        // Fin if/else if
        System.out.println(msg3b);                               // Imprimimos

        // --- ternario ---
        msg3c = (a == b) ? "ternario -> Son iguales"             // Si a == b
                         : ((a > b) ? "ternario -> Mayor: " + a  // Si a > b
                                   : "ternario -> Mayor: " + b); // Caso contrario
        System.out.println(msg3c);                               // Imprimimos



        // EJERCICIO 4: Nota (0-100) -> Aprobado (>=60) o Reprobado


        System.out.println("\n[4] Aprobado/Reprobado");          // Título
        System.out.print("Ingresa la nota (0-100): ");           // Pedimos nota
        int nota = sc.nextInt();                                 // Leemos nota
        String msg4a = "";                                       // if/else
        String msg4b = "";                                       // if/else if
        String msg4c = "";                                       // ternario

        // --- if/else ---
        if (nota >= 60) {                                        // Si nota >= 60
            msg4a = "if/else -> Aprobado";                       // Aprobado
        } else {                                                 // Si no
            msg4a = "if/else -> Reprobado";                      // Reprobado
        }                                                        // Fin if/else
        System.out.println(msg4a);                               // Imprimimos

        // --- if/else if ---
        if (nota >= 90) {                                        // 90-100
            msg4b = "if/else if -> Excelente";                   // Excelente
        } else if (nota >= 60) {                                 // 60-89
            msg4b = "if/else if -> Aprobado";                    // Aprobado
        } else {                                                 // <60
            msg4b = "if/else if -> Reprobado";                   // Reprobado
        }                                                        // Fin if/else if
        System.out.println(msg4b);                               // Imprimimos

        // --- ternario ---
        msg4c = (nota >= 60) ? "ternario -> Aprobado"            // Si >=60
                             : "ternario -> Reprobado";          // Si no
        System.out.println(msg4c);                               // Imprimimos


    
        // EJERCICIO 5: Par o impar
  

        System.out.println("\n[5] Par o impar");                  // Título
        System.out.print("Ingresa un número entero: ");           // Pedimos n
        int nPar = sc.nextInt();                                  // Leemos n
        String msg5a = "";                                        // if/else
        String msg5b = "";                                        // if/else if
        String msg5c = "";                                        // ternario

        // --- if/else ---
        if (nPar % 2 == 0) {                                      // Si n % 2 == 0
            msg5a = "if/else -> Par";                             // Par
        } else {                                                  // Si no
            msg5a = "if/else -> Impar";                           // Impar
        }                                                         // Fin if/else
        System.out.println(msg5a);                                // Imprimimos

        // --- if/else if ---
        if (nPar % 2 == 0) {                                      // Divisible por 2
            msg5b = "if/else if -> Par";                          // Par
        } else if (nPar % 2 != 0) {                               // No divisible por 2
            msg5b = "if/else if -> Impar";                        // Impar
        }                                                         // Fin if/else if
        System.out.println(msg5b);                                // Imprimimos

        // --- ternario ---
        msg5c = (nPar % 2 == 0) ? "ternario -> Par"               // Si es par
                                : "ternario -> Impar";            // Si no
        System.out.println(msg5c);                                // Imprimimos


        
        // EJERCICIO 6: Mayor de tres números
   

        System.out.println("\n[6] Mayor de tres números");        // Título
        System.out.print("Ingresa a: ");                          // Pedimos a
        double ta = sc.nextDouble();                              // Leemos a
        System.out.print("Ingresa b: ");                          // Pedimos b
        double tb = sc.nextDouble();                              // Leemos b
        System.out.print("Ingresa c: ");                          // Pedimos c
        double tc = sc.nextDouble();                              // Leemos c
        String msg6a = "";                                        // if/else
        String msg6b = "";                                        // if/else if
        String msg6c = "";                                        // ternario

        // --- if/else ---
        double mayorIf = ta;                                      // Tomamos a como mayor
        if (tb > mayorIf) { mayorIf = tb; }                       // Si b es mayor, actualizamos
        if (tc > mayorIf) { mayorIf = tc; }                       // Si c es mayor, actualizamos
        msg6a = "if/else -> Mayor: " + mayorIf;                   // Guardamos el mensaje
        System.out.println(msg6a);                                // Imprimimos

        // --- if/else if ---
        if (ta >= tb && ta >= tc) {                               // a es mayor o igual a los otros
            msg6b = "if/else if -> Mayor: " + ta;                 // a
        } else if (tb >= ta && tb >= tc) {                        // b es mayor o igual a los otros
            msg6b = "if/else if -> Mayor: " + tb;                 // b
        } else {                                                  // Si no es a ni b
            msg6b = "if/else if -> Mayor: " + tc;                 // c
        }                                                         // Fin if/else if
        System.out.println(msg6b);                                // Imprimimos

        // --- ternario ---
        double mayorT = (ta > tb) ? ta : tb;                      // Mayor entre a y b
        mayorT = (tc > mayorT) ? tc : mayorT;                     // Comparamos con c
        msg6c = "ternario -> Mayor: " + mayorT;                   // Guardamos mensaje
        System.out.println(msg6c);                                // Imprimimos



        // EJERCICIO 7: Año bisiesto

        System.out.println("\n[7] Año bisiesto");                 // Título
        System.out.print("Ingresa un año (int): ");               // Pedimos el año
        int anio = sc.nextInt();                                  // Leemos el año
        String msg7a = "";                                        // if/else
        String msg7b = "";                                        // if/else if
        String msg7c = "";                                        // ternario

        // --- if/else ---
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) { // Condición de bisiesto
            msg7a = "if/else -> Bisiesto";                      // Bisiesto
        } else {                                                  // Si no
            msg7a = "if/else -> No bisiesto";                   // No bisiesto
        }                                                         // Fin if/else
        System.out.println(msg7a);                                // Imprimimos

        // --- if/else if ---
        if (anio % 400 == 0) {                                    // Multiplo de 400
            msg7b = "if/else if -> Bisiesto";                     // Bisiesto
        } else if (anio % 100 == 0) {                             // Multiplo de 100
            msg7b = "if/else if -> No bisiesto";                  // No bisiesto
        } else if (anio % 4 == 0) {                               // Multiplo de 4
            msg7b = "if/else if -> Bisiesto";                     // Bisiesto
        } else {                                                  // Resto
            msg7b = "if/else if -> No bisiesto";                  // No bisiesto
        }                                                         // Fin if/else if
        System.out.println(msg7b);                                // Imprimimos

        // --- ternario ---
        msg7c = ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0))
                ? "ternario -> Bisiesto"                          // Si cumple
                : "ternario -> No bisiesto";                      // Si no
        System.out.println(msg7c);                                // Imprimimos



        // EJERCICIO 8: Validar contraseña

        System.out.println("\n[8] Validación de contraseña");     // Título
        sc.nextLine();                                            // Limpiamos salto de línea pendiente
        System.out.print("Ingresa una contraseña: ");             // Pedimos la contraseña
        String pass = sc.nextLine();                              // Leemos la contraseña
        boolean okLong = pass.length() > 8;                       // ¿Largo > 8?
        boolean okNum = false;                                    // ¿Tiene número?
        boolean okMay = false;                                    // ¿Tiene mayúscula?
        String msg8a = "";                                        // if/else
        String msg8b = "";                                        // if/else if
        String msg8c = "";                                        // ternario

        for (int i = 0; i < pass.length(); i++) {                 // Recorremos cada carácter
            char ch = pass.charAt(i);                             // Obtenemos el carácter
            if (Character.isDigit(ch)) { okNum = true; }          // Marcamos si es dígito
            if (Character.isUpperCase(ch)) { okMay = true; }      // Marcamos si es mayúscula
        }                                                          // Fin del for

        // --- if/else ---
        if (okLong && okNum && okMay) {                           // Si cumple las 3
            msg8a = "if/else -> Contraseña válida";               // Válida
        } else {                                                  // Si no
            msg8a = "if/else -> Contraseña inválida";             // Inválida
        }                                                         // Fin if/else
        System.out.println(msg8a);                                // Imprimimos

        // --- if/else if ---
        if (!okLong) {                                            // Falla por largo
            msg8b = "if/else if -> Muy corta";                    // Mensaje
        } else if (!okNum) {                                      // Falla por número
            msg8b = "if/else if -> Falta número";                 // Mensaje
        } else if (!okMay) {                                      // Falla por mayúscula
            msg8b = "if/else if -> Falta mayúscula";              // Mensaje
        } else {                                                  // Si pasa todo
            msg8b = "if/else if -> Contraseña válida";            // Válida
        }                                                         // Fin if/else if
        System.out.println(msg8b);                                // Imprimimos

        // --- ternario ---
        msg8c = (okLong && okNum && okMay)                        // Condición completa
               ? "ternario -> Contraseña válida"                  // Válida
               : "ternario -> Contraseña inválida";               // Inválida
        System.out.println(msg8c);                                // Imprimimos



        // EJERCICIO 9: FizzBuzz


        System.out.println("\n[9] FizzBuzz");                     // Título
        System.out.print("Ingresa un número entero: ");           // Pedimos n
        int nFizz = sc.nextInt();                                 // Leemos n
        String msg9a = "";                                        // if/else (anidado)
        String msg9b = "";                                        // if/else if
        String msg9c = "";                                        // ternario

        // --- if/else (anidado dentro del else) ---
        if (nFizz % 3 == 0 && nFizz % 5 == 0) {                   // Si divisible por 3 y 5
            msg9a = "if/else -> FizzBuzz";                        // FizzBuzz
        } else {                                                  // Si no
            if (nFizz % 3 == 0) {                                 // Revisa divisible por 3
                msg9a = "if/else -> Fizz";                        // Fizz
            } else if (nFizz % 5 == 0) {                          // Revisa divisible por 5
                msg9a = "if/else -> Buzz";                        // Buzz
            } else {                                              // Ninguna
                msg9a = "if/else -> " + nFizz;                    // Imprime el número
            }                                                     // Fin if/else interno
        }                                                         // Fin if/else
        System.out.println(msg9a);                                // Imprimimos

        // --- if/else if ---
        if (nFizz % 3 == 0 && nFizz % 5 == 0) {                   // 3 y 5
            msg9b = "if/else if -> FizzBuzz";                     // FizzBuzz
        } else if (nFizz % 3 == 0) {                              // Sólo 3
            msg9b = "if/else if -> Fizz";                         // Fizz
        } else if (nFizz % 5 == 0) {                              // Sólo 5
            msg9b = "if/else if -> Buzz";                         // Buzz
        } else {                                                  // Ninguna
            msg9b = "if/else if -> " + nFizz;                     // Número
        }                                                         // Fin if/else if
        System.out.println(msg9b);                                // Imprimimos

        // --- ternario ---
        msg9c = (nFizz % 3 == 0 && nFizz % 5 == 0)                // 3 y 5
                ? "ternario -> FizzBuzz"
                : (nFizz % 3 == 0 ? "ternario -> Fizz"           // sólo 3
                                   : (nFizz % 5 == 0 ? "ternario -> Buzz" // sólo 5
                                                     : "ternario -> " + nFizz)); // número
        System.out.println(msg9c);                                // Imprimimos



        // EJERCICIO 10: Cajero automático
        // Recibe monto a retirar y dice si se puede (según saldo)


        System.out.println("\n[10] Cajero automático");           // Título
        double saldo = 500.0;                                     // Saldo disponible (ejemplo)
        System.out.println("Saldo disponible: " + saldo + " ");   // Mostramos saldo
        System.out.print("Monto a retirar: ");                    // Pedimos retiro
        double retiro = sc.nextDouble();                          // Leemos el retiro
        boolean posible = (retiro > 0 && retiro <= saldo);        // ¿Se puede retirar?
        String msg10a = "";                                       // if/else
        String msg10b = "";                                       // if/else if
        String msg10c = "";                                       // ternario

        // --- if/else ---
        if (posible) {                                            // Si es posible
            double nuevoSaldo = saldo - retiro;                   // Calculamos nuevo saldo
            msg10a = "if/else -> Retiro exitoso. Nuevo saldo: " + nuevoSaldo; // Mensaje
        } else {                                                  // Si no es posible
            msg10a = "if/else -> Operación no posible";           // Mensaje
        }                                                         // Fin if/else
        System.out.println(msg10a);                               // Imprimimos

        // --- if/else if ---
        if (retiro <= 0) {                                        // Si el monto no es válido
            msg10b = "if/else if -> Monto inválido";              // Mensaje
        } else if (retiro > saldo) {                              // Si no alcanza el saldo
            msg10b = "if/else if -> Fondos insuficientes";        // Mensaje
        } else {                                                  // Si pasa ambas
            msg10b = "if/else if -> Retiro posible";              // Mensaje
        }                                                         // Fin if/else if
        System.out.println(msg10b);                               // Imprimimos

        // --- ternario ---
        msg10c = posible ? "ternario -> Retiro posible"           // Si posible
                         : "ternario -> No se puede retirar";     // Si no
        System.out.println(msg10c);                               // Imprimimos

        sc.close();                                               // Cerramos el Scanner al final del programa
    }                                                             // Cierra main
}                                                                 // Cierra la clase



