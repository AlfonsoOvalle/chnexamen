import React from "react";
import CardComponent from "./CardComponent";



export default class Cuentas extends React.Component {
    render() {
        return (
            //Contenido card 

            <CardComponent
                nombreIconoFontawesome="fas fa-money-check"
                cardTitle=" CUENTAS"
                cardBody={
                    <div className="">

                    </div>
                }
            />

        );
    }
}