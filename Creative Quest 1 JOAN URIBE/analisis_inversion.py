
import streamlit as st
import numpy as np
import pandas as pd
import plotly.graph_objects as go

# ==============================================
# FUNCIONES FINANCIERAS
# ==============================================

def calcular_vpn(flujos, tasa_descuento):
    """
    Calcula el Valor Presente Neto (VPN).
    :param flujos: lista de flujos de caja (el primero = inversión inicial).
    :param tasa_descuento: tasa de descuento en % anual.
    :return: Valor Presente Neto (float)
    """
    tasa = tasa_descuento / 100
    return sum(f / ((1 + tasa) ** t) for t, f in enumerate(flujos))


def calcular_tir(flujos, tol=1e-6, max_iter=1000):
    """
    Calcula la Tasa Interna de Retorno (TIR) usando búsqueda binaria.
    :param flujos: lista de flujos de caja.
    :param tol: tolerancia numérica.
    :param max_iter: número máximo de iteraciones.
    :return: TIR en % (float)
    """
    low, high = -0.99, 2.0
    for _ in range(max_iter):
        mid = (low + high) / 2
        vpn_mid = sum(f / ((1 + mid) ** t) for t, f in enumerate(flujos))
        if abs(vpn_mid) < tol:
            return mid * 100
        if vpn_mid > 0:
            low = mid
        else:
            high = mid
    return mid * 100


def sensibilidad_vpn(flujos, tasas):
    """
    Calcula el VPN para una lista de tasas de descuento.
    :param flujos: flujos de caja.
    :param tasas: lista de tasas (%)
    :return: DataFrame con tasas y VPNs.
    """
    data = {"Tasa (%)": tasas, "VPN": [calcular_vpn(flujos, t) for t in tasas]}
    return pd.DataFrame(data)


def monte_carlo_vpn(flujos, tasa, desviacion=0.05, n=1000):
    """
    Simulación Monte Carlo del VPN.
    :param flujos: lista de flujos.
    :param tasa: tasa base (%).
    :param desviacion: desviación estándar de los flujos.
    :param n: número de simulaciones.
    :return: array de VPN simulados.
    """
    simulaciones = []
    for _ in range(n):
        flujos_sim = [f * np.random.normal(1, desviacion) for f in flujos]
        simulaciones.append(calcular_vpn(flujos_sim, tasa))
    return np.array(simulaciones)


# ==============================================
# INTERFAZ STREAMLIT
# ==============================================

def main():
    st.set_page_config(page_title="Análisis Financiero de Inversiones", layout="wide")
    st.title("Evaluador de Proyectos de Inversión")
    st.markdown("### Análisis de Rentabilidad, Sensibilidad y Simulación Monte Carlo")

    # Entrada de datos
    st.sidebar.header("Parámetros de Entrada")
    n_flujos = st.sidebar.number_input("Número de períodos (incluye inversión inicial)", 2, 20, 5)
    tasa_descuento = st.sidebar.slider("Tasa de descuento (%)", 0.0, 50.0, 10.0, step=0.5)

    st.sidebar.markdown("### Flujos de caja (negativo el año 0):")
    flujos = []
    for i in range(n_flujos):
        flujos.append(st.sidebar.number_input(f"Flujo año {i}", value=(-10000 if i == 0 else 3000 + i * 1000)))

    # Cálculos
    vpn = calcular_vpn(flujos, tasa_descuento)
    tir = calcular_tir(flujos)

    st.subheader("Resultados principales")
    col1, col2 = st.columns(2)
    col1.metric("Valor Presente Neto (VPN)", f"${vpn:,.2f}")
    col2.metric("Tasa Interna de Retorno (TIR)", f"{tir:.2f}%")

    if vpn > 0:
        st.success("El proyecto es rentable (VPN > 0)")
    else:
        st.error("El proyecto no es rentable (VPN ≤ 0)")

    # Gráfico de flujos
    st.markdown("### Flujos de Caja")
    fig1 = go.Figure()
    fig1.add_trace(go.Bar(x=list(range(n_flujos)), y=flujos, name="Flujos de caja"))
    fig1.update_layout(xaxis_title="Año", yaxis_title="Monto", template="plotly_white")
    st.plotly_chart(fig1, use_container_width=True)

    # Sensibilidad VPN
    st.markdown("###  Sensibilidad del VPN a la tasa de descuento")
    tasas = np.linspace(0, 40, 41)
    df_sens = sensibilidad_vpn(flujos, tasas)
    fig2 = go.Figure()
    fig2.add_trace(go.Scatter(x=df_sens["Tasa (%)"], y=df_sens["VPN"], mode="lines", name="VPN"))
    fig2.add_hline(y=0, line_dash="dash", line_color="red")
    fig2.update_layout(xaxis_title="Tasa de descuento (%)", yaxis_title="VPN ($)", template="plotly_white")
    st.plotly_chart(fig2, use_container_width=True)

    # Monte Carlo
    st.markdown("###  Simulación Monte Carlo del VPN")
    n_sim = st.slider("Número de simulaciones", 100, 5000, 1000, step=100)
    desviacion = st.slider("Desviación de los flujos (%)", 0.0, 0.5, 0.1)
    resultados = monte_carlo_vpn(flujos, tasa_descuento, desviacion, n_sim)
    st.write(f"**Promedio VPN:** ${np.mean(resultados):,.2f}")
    st.write(f"**Desviación estándar:** ${np.std(resultados):,.2f}")

    fig3 = go.Figure()
    fig3.add_trace(go.Histogram(x=resultados, nbinsx=30, name="Distribución VPN"))
    fig3.add_vline(x=np.mean(resultados), line_color="green", line_dash="dash", annotation_text="Media")
    fig3.update_layout(template="plotly_white", xaxis_title="VPN", yaxis_title="Frecuencia")
    st.plotly_chart(fig3, use_container_width=True)

    # Exportación
    st.markdown("### Exportar resultados")
    df_resultados = pd.DataFrame({
        "Año": list(range(n_flujos)),
        "Flujo": flujos
    })
    df_resultados["VPN Base"] = vpn
    df_resultados["TIR (%)"] = tir

    csv = df_resultados.to_csv(index=False).encode("utf-8")
    st.download_button("Descargar resultados (CSV)", csv, "resultados_inversion.csv", "text/csv")

    st.markdown("---")
    st.caption("Desarrollado por **Joan Sebastian Uribe Gonzalez - Constructor del distrito [PROGCOM- A]** | Basado en buenas prácticas de análisis financiero.")


if __name__ == "__main__":
    main()
