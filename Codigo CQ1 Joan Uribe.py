escenario = stage
escenario.set_background("hauntedhouse")

jugador = codesters.Sprite("frankenstein")
jugador.go_to(-175, -150)

aro = codesters.Sprite("basketballnet")
aro.go_to(215, 175)

escenario.set_gravity(10)
jugador.set_gravity_off()

def click(jugador):
    pelota = codesters.Sprite("basketball")
    pelota.go_to(-175, -125)
    pelota.set_x_speed(10)
    pelota.set_y_speed(10)

jugador.event_click(click)
escenario.disable_right_wall()

def colision(aro, jugador_golpeado):
    mi_variable = jugador_golpeado.get_image_name()
    if mi_variable == "basketball":
        jugador.say("¡Cesta!")
        jugador_golpeado.hide()
        global puntos
        puntos += 1
        
        
        marcador.update(puntos)

aro.event_collision(colision)

instruccion = codesters.Text("Haz clic en el jugador para lanzar la pelota al arco.")

puntos = 0
marcador = codesters.Display(puntos, -200, 150)
