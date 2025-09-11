from tkinter import *
import configuraciones
import utilidades

ventana = Tk()
# Configuración de la ventana
ventana.configure(bg="black")
ventana.geometry(f'{configuraciones.ANCHO}x{configuraciones.ALTO}')
ventana.title("Juego Buscaminas")
ventana.resizable(False, False)

marco_superior = Frame(
    ventana,
    bg='black',
    width=configuraciones.ANCHO,
    height=utilidades.altura_pct(25)
)
marco_superior.place(x=0, y=0)

marco_izquierdo = Frame(
    ventana,
    bg='black',
    width=utilidades.ancho_pct(25),
    height=utilidades.altura_pct(75)
)
marco_izquierdo.place(x=0, y=utilidades.altura_pct(25))

marco_central = Frame(
    ventana,
    bg='black',
    width=utilidades.ancho_pct(75),
    height=utilidades.altura_pct(75)
)
marco_central.place(
    x=utilidades.ancho_pct(25),
    y=utilidades.altura_pct(25),
)

# Ejecutar la ventana
ventana.mainloop()