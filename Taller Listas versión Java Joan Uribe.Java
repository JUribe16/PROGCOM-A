

public class Main {
    public static void main(String[] args) {
        
        // 1. Crear una lista con los cuadrados de los números del 1 al 10
        List<Integer> cuadrados = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            cuadrados.add(i * i);
        }
        System.out.println(cuadrados);

        // 2. Obtener una lista con los números pares del 0 al 20
        List<Integer> pares = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) {
                pares.add(i);
            }
        }
        System.out.println(pares);

        // 3. Crear una lista con el doble de cada número del 1 al 5
        List<Integer> dobles = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            dobles.add(i * 2);
        }
        System.out.println(dobles);

        // 4. De la palabra "programacion", obtener solo las vocales
        String palabra = "programacion";
        List<Character> vocales = new ArrayList<>();
        for (char c : palabra.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vocales.add(c);
            }
        }
        System.out.println(vocales);

        // 5. Dada la lista ["python", "java", "c++"], obtener otra lista con las palabras en mayúsculas
        List<String> lenguajes = Arrays.asList("python", "java", "c++");
        List<String> mayusculas = new ArrayList<>();
        for (String l : lenguajes) {
            mayusculas.add(l.toUpperCase());
        }
        System.out.println(mayusculas);

        // 6. Crear una lista con "par" o "impar" para los números del 1 al 10
        List<String> clasificacion = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                clasificacion.add("par");
            } else {
                clasificacion.add("impar");
            }
        }
        System.out.println(clasificacion);

        // 7. Generar una lista de tuplas con el número y su cuadrado del 1 al 5
        List<String> tuplas = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            tuplas.add("(" + i + ", " + (i * i) + ")");
        }
        System.out.println(tuplas);

        // 8. Crear una lista con todas las combinaciones de letras en ["a","b"] y números en [1,2,3]
        List<String> combinaciones = new ArrayList<>();
        String[] letras = {"a", "b"};
        int[] numeros = {1, 2, 3};
        for (String letra : letras) {
            for (int num : numeros) {
                combinaciones.add("(" + letra + ", " + num + ")");
            }
        }
        System.out.println(combinaciones);

        // 9. De la lista ["sol", "estrella", "mar", "planeta"], obtener solo las palabras con más de 4 letras
        List<String> palabras = Arrays.asList("sol", "estrella", "mar", "planeta");
        List<String> largas = new ArrayList<>();
        for (String p : palabras) {
            if (p.length() > 4) {
                largas.add(p);
            }
        }
        System.out.println(largas);

        // 10. Clasificar la temperatura de una lista
        int[] temperaturas = {22, 27, 30, 25, 29, 31};
        List<String> clima = new ArrayList<>();
        for (int t : temperaturas) {
            if (t < 26) {
                clima.add("frío");
            } else if (t <= 29) {
                clima.add("templado");
            } else {
                clima.add("caliente");
            }
        }
        System.out.println(clima);
    }
}

