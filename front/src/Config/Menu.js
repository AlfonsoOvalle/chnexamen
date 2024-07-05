/*Pantallas*/
import Clientes from "../partials/Clientes";
import Cuentas from "../partials/Cuentas";

const EstructuraMenu = [
    {
        id: 1,
        titulo: " CLIENTES",
        iconoFas5: "fas fa-users",
        ruta: "/clientes",
        exact: true,
        componente: Clientes

    },    
    {
        id: 2,
        titulo: " CUENTAS",
        iconoFas5: "fas fa-money-check",
        ruta: "/cuentas",
        exact: true,
        componente: Cuentas

       
    }
    
]


export default EstructuraMenu;