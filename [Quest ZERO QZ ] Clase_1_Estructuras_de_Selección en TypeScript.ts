// main.ts - Adaptado para Node.js con readline
import * as readline from "readline";

// Helper para pedir datos en consola
function ask(question: string): Promise<string> {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  return new Promise((resolve) =>
    rl.question(question, (ans) => {
      rl.close();
      resolve(ans);
    })
  );
}

async function main() {
  // Ejercicio 1: número positivo o negativo
  let n: number = parseInt(await ask("Ingrese un número: "));
  if (n > 0) {
    console.log(`${n} es un número positivo`);
  } else {
    console.log(`${n} NO es un número positivo`);
  }

  // Ejercicio 2
  n = parseInt(await ask("Ingrese un número: "));
  if (n > 0) {
    console.log(`${n} es número positivo`);
  } else if (n < 0) {
    console.log(`${n} NO es número positivo`);
  } else {
    console.log(`${n} es 0`);
  }

  // Ejercicio 3: operador ternario
  n = parseInt(await ask("Ingrese un número: "));
  let a: string =
    n >= 0 ? `${n} es un número positivo` : `${n} NO es un número positivo`;
  console.log(a);

  // Ejercicio 4: edad
  let edad: number = parseInt(await ask("Escriba su edad: "));
  if (edad > 21) {
    console.log("Usted es mayor de edad en Colombia");
  } else if (edad > 18) {
    console.log("Usted es mayor de edad en cualquier parte del mundo");
  } else {
    console.log("Usted no es mayor de edad");
  }

  // Ejercicio 5: mayor de dos números
  let n1: number = parseInt(await ask("Escriba el primer número: "));
  let n2: number = parseInt(await ask("Escriba el segundo número: "));
  if (n1 > n2) {
    console.log(n1);
  } else if (n2 > n1) {
    console.log(n2);
  } else {
    console.log("Los números son iguales");
  }

  // Ejercicio 6: mayor de tres números
  let a1: number = parseInt(await ask("Escriba el primer número: "));
  let b1: number = parseInt(await ask("Escriba el segundo número: "));
  let c1: number = parseInt(await ask("Escriba el tercer número: "));
  if (a1 >= b1 && a1 >= c1) {
    console.log(a1);
  } else if (b1 >= a1 && b1 >= c1) {
    console.log(b1);
  } else {
    console.log(c1);
  }

  // Ejercicio 7: año bisiesto
  let anio: number = parseInt(await ask("Ingrese un año: "));
  if ((anio % 4 === 0 && anio % 100 !== 0) || anio % 400 === 0) {
    console.log(`${anio} es un año bisiesto`);
  } else {
    console.log(`${anio} no es un año bisiesto`);
  }

  // Ejercicio 8: calificación
  let nota: number = parseFloat(await ask("Ingrese su nota (0 a 5): "));
  if (nota >= 3.0) {
    console.log("Aprobado");
  } else {
    console.log("Reprobado");
  }

  // Ejercicio 9: descuento
  let cantidad: number = parseInt(await ask("Ingrese la cantidad de productos: "));
  let precioUnitario: number = 100;
  let total: number = cantidad * precioUnitario;
  if (cantidad >= 10) {
    total *= 0.9;
  }
  console.log(`El total a pagar es: ${total}`);

  // Ejercicio 10: par o impar
  let numPar: number = parseInt(await ask("Ingrese un número: "));
  if (numPar % 2 === 0) {
    console.log(`${numPar} es par`);
  } else {
    console.log(`${numPar} es impar`);
  }

  // Ejercicio 11: contraseña
  let clave: string = await ask("Ingrese la contraseña: ");
  if (clave === "1234") {
    console.log("Acceso concedido");
  } else {
    console.log("Acceso denegado");
  }

  // Ejercicio 12: menú
  let opcion: number = parseInt(await ask("Ingrese una opción (1-3): "));
  switch (opcion) {
    case 1:
      console.log("Opción 1 seleccionada");
      break;
    case 2:
      console.log("Opción 2 seleccionada");
      break;
    case 3:
      console.log("Opción 3 seleccionada");
      break;
    default:
      console.log("Opción inválida");
  }
}

main();
