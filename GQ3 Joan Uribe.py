def calcular_vpn(flujos, tasa_descuento):
    """
    Calcula el Valor Presente Neto (VPN).
    flujos: lista de flujos de caja (primer valor = inversión inicial).
    tasa_descuento: tasa en % anual.
    """
    tasa = tasa_descuento / 100
    vpn = 0
    for t, flujo in enumerate(flujos):
        vpn += flujo / ((1 + tasa) ** t)
    return vpn


def calcular_tir(flujos, tol=1e-6, max_iter=1000):
    """
    Calcula la Tasa Interna de Retorno (TIR) usando búsqueda binaria.
    Retorna la tasa en %.
    """
    # Buscamos una tasa entre -0.99 (casi -100%) y 1 (100%)
    low, high = -0.99, 1.0

    for _ in range(max_iter):
        mid = (low + high) / 2
        vpn_mid = sum(flujo / ((1 + mid) ** t) for t, flujo in enumerate(flujos))
        if abs(vpn_mid) < tol:
            return mid * 100  # en %
        if vpn_mid > 0:
            low = mid
        else:
            high = mid
    return mid * 100  # devuelve lo que encontró


def main():
    print("=== Evaluación de Proyecto de Inversión ===")

    # Ejemplo: inversión inicial y flujos futuros
    flujos = [-10000, 3000, 4000, 5000, 6000]  # año 0, 1, 2, 3, 4
    tasa_descuento = 10  # % anual

    print(f"Flujos de caja: {flujos}")
    print(f"Tasa de descuento: {tasa_descuento}%")

    vpn = calcular_vpn(flujos, tasa_descuento)
    tir = calcular_tir(flujos)

    print(f"\nValor Presente Neto (VPN): ${vpn:,.2f}")
    print(f"Tasa Interna de Retorno (TIR): {tir:.2f}%")

    if vpn > 0:
        print("✅ El proyecto es rentable (VPN > 0)")
    else:
        print("❌ El proyecto NO es rentable (VPN <= 0)")


# Ejecutar directamente
main()
