import random

# Opciones disponibles
OPTIONS = ["piedra", "papel", "tijera", "lagarto", "spock"]

# Reglas de victoria
WIN_RULES = {
    ("tijera", "papel"): "Tijera corta papel",
    ("papel", "piedra"): "Papel envuelve piedra",
    ("piedra", "lagarto"): "Piedra aplasta lagarto",
    ("lagarto", "spock"): "Lagarto envenena a Spock",
    ("spock", "tijera"): "Spock rompe tijera",
    ("tijera", "lagarto"): "Tijera decapita lagarto",
    ("lagarto", "papel"): "Lagarto devora papel",
    ("papel", "spock"): "Papel desautoriza a Spock",
    ("spock", "piedra"): "Spock vaporiza piedra",
    ("piedra", "tijera"): "Piedra aplasta tijera",
}

def quien_gana(player, cpu):
    """Determina el ganador de una ronda"""
    if player == cpu:
        return "empate", "Empate"
    if (player, cpu) in WIN_RULES:
        return "player", WIN_RULES[(player, cpu)]
    if (cpu, player) in WIN_RULES:
        return "cpu", WIN_RULES[(cpu, player)]
    return "error", "Movimiento inválido"

def partida_automatica(jugadas_usuario):
    """Simula una partida con jugadas predefinidas"""
    score_p = score_c = 0
    ronda = 1
    for player in jugadas_usuario:
        cpu = random.choice(OPTIONS)
        ganador, razon = quien_gana(player, cpu)
        print(f"\nRonda {ronda}")
        print(f"Tú: {player}  |  CPU: {cpu}")
        if ganador == "player":
            score_p += 1
            print("Ganaste la ronda —", razon)
        elif ganador == "cpu":
            score_c += 1
            print("Perdiste la ronda —", razon)
        else:
            print(razon)
        ronda += 1

    # Resultado final
    print("\nResultado final:")
    if score_p > score_c:
        print(f"¡GANASTE! {score_p} a {score_c}")
    elif score_c > score_p:
        print(f"Perdiste. CPU {score_c} - Tú {score_p}")
    else:
        print(f"Empate total: {score_p} - {score_c}")

def main():
    print("=== Piedra, Papel, Tijera, Lagarto, Spock (Automático) ===")

    # Lista de jugadas simuladas del usuario (puedes cambiarla)
    jugadas_usuario = ["piedra", "papel", "spock", "lagarto", "tijera"]

    print(f"Jugadas del usuario: {jugadas_usuario}")
    partida_automatica(jugadas_usuario)

# Ejecutar directamente
main()
