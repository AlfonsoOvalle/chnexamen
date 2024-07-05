import React from "react";
import CardComponent from "./CardComponent";
import { Button, Col, Container, Row, Table, Modal, ModalHeader, ModalBody, ModalFooter, UncontrolledTooltip } from 'reactstrap';

import '../pages/Estilos.css'
import { customFetchAll, customFetchGET } from "../funciones";
import rutaBaseApi from '../Config/Conf'
import Swal2 from "sweetalert2";

export default class Clientes extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            lstClientes: [],
            filtro: '',
            nombre: '',
            editando: false,
            correo: '',
            openModal: false

        };
    }
    setTxtFiltro(texto) {
        this.setState({ filtro: texto }, () => {

        })
    }
    componentDidMount() {
        const fetchData = async () => {

            const res = await customFetchGET(`${rutaBaseApi}obtenerClientes`)
            if (res != null || res !== undefined) {
                this.setState({ lstClientes: res.data })
            }
        };
        fetchData();

    }
    toggleOpenModal() {
        this.setState({ openModal: !this.state.openModal }, () => {
            if (this.state.openModal === false) {
                //this.setState({ editando: false, lstTelefonos: [''], nombre: '', correo: '', itemEmpresaSeleccionada:null })
            }
        });
    }

    async agregarCliente() {
        let Cliente = {
            "nombre": this.state.nombre,
            "apellido": this.state.apellido,
            "numeroIdentificacion": this.state.noIdentificacion,
            "fechaNacimiento": this.state.fechaNac,
            "direccion": this.state.direccion,
            "correoElectronico": this.state.correoElectronico,
            "telefono": this.state.telefono,
            "estado": "A"
        }


        const res = await customFetchAll(`${rutaBaseApi}agregarCliente`, "POST", Cliente)
        if (res != null || res !== undefined) {
            if (res.estado === "exito") {

                Swal2.fire(
                    {
                        title: "Clientes",
                        text: res.mensaje,
                        icon: "success",
                        confirmButtonColor: '#198754'
                    });
                this.setState({ openModal: false }, () => {
                    const fetchData = async () => {

                        const res = await customFetchGET(`${rutaBaseApi}obtenerClientes`)
                        if (res != null || res !== undefined) {
                            this.setState({ lstClientes: res.data })
                        }
                    };
                    fetchData();
                    this.limpiarCampos();
                })
                return;
            } else {
                Swal2.fire(
                    {
                        title: "Clientes",
                        text: res.mensaje,
                        icon: "error",
                        confirmButtonColor: '#DC3545'
                    });
                return;
            }
            //this.setState({ lstClientes: res.data })
        }
    }

    limpiarCampos() {
        this.setState({
            nombre: '', apellido: '', noIdentificacion: '', fechaNac: '', direccion: '', correoElectronico: '', telefono: ''
        })
    }

    async inactivarCliente(itemCliente) {
        Swal2.fire({
            title: "Activar o Inactivar ",
            text: itemCliente.estado === "A" ? "Desea Inactivar al cliente" : "Desea Activar al cliente",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí'
        }).then(async (result) => {
            if (result.isConfirmed) {
                if (itemCliente.estado === "I") {
                    itemCliente.estado = 'A'
                } else {
                    itemCliente.estado = 'I'
                }

                // console.log(itemCliente)
                const res = await customFetchAll(`${rutaBaseApi}editarCliente`, "POST", itemCliente)
                if (res != null || res !== undefined) {
                    if (res.estado === "exito") {
                        Swal2.fire(
                            {
                                title: "Clientes",
                                text: itemCliente.estado === "I" ? "Cliente Inactivado Exitosamente" : "Cliente Activado Exitosamente",
                                icon: "success",
                                confirmButtonColor: '#198754'
                            });
                        const fetchData = async () => {

                            const res = await customFetchGET(`${rutaBaseApi}obtenerClientes`)
                            if (res != null || res !== undefined) {
                                this.setState({ lstClientes: res.data })
                            }
                        };
                        fetchData();
                    } else {
                        Swal2.fire(
                            {
                                title: "Clientes",
                                text: res.mensaje,
                                icon: "error",
                                confirmButtonColor: '#DC3545'
                            });
                    }

                }
            }
        });



    }

    abrirEdicionCliente(itemCliente) {

        this.setState({ openModal: true, editando: true })
        this.setState({
            estado: itemCliente.estado, idCliente: itemCliente.idCliente, nombre: itemCliente.nombre, apellido: itemCliente.apellido, noIdentificacion: itemCliente.numeroIdentificacion, fechaNac: itemCliente.fechaNacimiento, direccion: itemCliente.direccion, correoElectronico: itemCliente.correoElectronico, telefono: itemCliente.telefono, estado: itemCliente.estado
        })
    }
    async actualizarCliente() {
        let Cliente = {
            "idCliente": this.state.idCliente,
            "nombre": this.state.nombre,
            "apellido": this.state.apellido,
            "numeroIdentificacion": this.state.noIdentificacion,
            "fechaNacimiento": this.state.fechaNac,
            "direccion": this.state.direccion,
            "correoElectronico": this.state.correoElectronico,
            "telefono": this.state.telefono,
            "estado": this.state.estado
        }

        const res = await customFetchAll(`${rutaBaseApi}editarCliente`, "POST", Cliente)
        if (res != null || res !== undefined) {
            if (res.estado === "exito") {
                Swal2.fire(
                    {
                        title: "Clientes",
                        text: res.mensaje,
                        icon: "success",
                        confirmButtonColor: '#198754'
                    });
                const fetchData = async () => {

                    const res = await customFetchGET(`${rutaBaseApi}obtenerClientes`)
                    if (res != null || res !== undefined) {
                        this.setState({ lstClientes: res.data,openModal:false })
                    }
                };
                fetchData();
                this.limpiarCampos()
            } else {
                Swal2.fire(
                    {
                        title: "Clientes",
                        text: res.mensaje,
                        icon: "error",
                        confirmButtonColor: '#DC3545'
                    });
            }

        }
    }
    render() {
        return (
            //Contenido card 

            <CardComponent
                nombreIconoFontawesome="fas fa-users"
                cardTitle=" CLIENTES"
                cardBody={
                    <Container className="py-3" fluid>
                        <Row className="py-1">
                            <Col>
                                <Button color="success" size="sm" onClick={() => { this.toggleOpenModal() }}>
                                    <i className="fas fa-user-plus"></i> Nuevo Cliente
                                </Button>
                            </Col>
                        </Row>
                        <Row className="py-1">
                            <Col sm="12" lg="6">
                                <div className="inputGroup">
                                    <i className="fas fa-search"> </i>
                                    <input placeholder="Buscar Clientes" type="text" onChange={(text) => { this.setTxtFiltro(text.target.value) }}></input>
                                </div>
                            </Col>
                        </Row>
                        <div style={{
                            maxHeight: '500px',
                            overflowY: 'auto'
                        }}>
                            <Table hover className="tblClientes">
                                <thead>
                                    <tr>
                                        <th>
                                            #
                                        </th>
                                        <th>
                                            Nombre
                                        </th>
                                        <th>
                                            Apellido
                                        </th>
                                        <th>
                                            No Identificacion
                                        </th>
                                        <th>
                                            fecha Nacimiento
                                        </th>
                                        <th>
                                            Direccion
                                        </th>
                                        <th>
                                            Correo
                                        </th>
                                        <th>
                                            Telefono
                                        </th>

                                        <th>
                                            Estado
                                        </th>
                                        <th>
                                            Opciones
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.lstClientes?.map((item, index) => {
                                            return (
                                                <tr key={"tr-" + index} >
                                                    <th key={"tdID-" + index} >
                                                        {item.idCliente}
                                                    </th>
                                                    <td key={"tdnombre-" + index} >
                                                        {item.nombre ? item.nombre : ""}
                                                    </td>
                                                    <td key={"tdapellido-" + index} >
                                                        {item.apellido ? item.apellido : ""}
                                                    </td>
                                                    <td key={"tdIdentificacion-" + index} >
                                                        {item.numeroIdentificacion ? item.numeroIdentificacion : ""}
                                                    </td>
                                                    <td key={"tdfechaNac-" + index} >
                                                        {item.fechaNacimiento ? item.fechaNacimiento : ""}
                                                    </td>
                                                    <td key={"tddireccion-" + index} >
                                                        {item.direccion ? item.direccion : ""}
                                                    </td>
                                                    <td key={"tdcorreo-" + index} >
                                                        {item.correoElectronico ? item.correoElectronico : ""}
                                                    </td>
                                                    <td key={"tdTelefono-" + index} >
                                                        {item.telefono ? item.telefono : ""}
                                                    </td>
                                                    <td key={"tdEstado-" + index} >
                                                        {item.estado ? item.estado : ""}
                                                    </td>
                                                    <td key={"tdacciones-" + index} className="text-center">
                                                        <Button key={"tdbtneditar-" + index} color="warning" size="sm" className="mx-1 my-1 fas fa-user-edit botonSm"
                                                            onClick={() => { this.abrirEdicionCliente(item) }}
                                                            id="TooltipEditar"
                                                        />
                                                        <UncontrolledTooltip placement="top" target="TooltipEditar" >
                                                            Editar Cliente
                                                        </UncontrolledTooltip>
                                                        <Button key={"tdbInactivar-" + index} color="danger" size="sm" className="mx-1 my-1 fas fa-user-lock botonSm"
                                                            onClick={() => { this.inactivarCliente(item) }}
                                                            id="TooltipInactivar"
                                                        />
                                                        <UncontrolledTooltip placement="top" target="TooltipInactivar" >
                                                            Activar o Inactivar Cliente
                                                        </UncontrolledTooltip>
                                                    </td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </Table>
                        </div>
                        <Modal fullscreen="sm" size="md" isOpen={this.state.openModal} >
                            <ModalHeader>
                                {
                                    this.state.editando ?
                                        <>
                                            <i className="fas fa-user-edit"></i> Editar Cliente
                                        </>
                                        :
                                        <>
                                            <i className="fas fa-user-plus"></i> Nuevo Cliente
                                        </>
                                }
                            </ModalHeader>
                            <ModalBody>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-user-tie"> </i>
                                    <input placeholder="Nombre Cliente" type="text" onChange={(text) => { this.setState({ nombre: text.target.value }) }} value={this.state.editando ? this.state.nombre : this.state.nombre} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-user-tie"> </i>
                                    <input placeholder="Apellido Cliente" type="text" onChange={(text) => { this.setState({ apellido: text.target.value }) }} value={this.state.editando ? this.state.apellido : this.state.apellido} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-barcode"> </i>
                                    <input placeholder="No Identificacion" type="text" onChange={(text) => { this.setState({ noIdentificacion: text.target.value }) }} value={this.state.editando ? this.state.noIdentificacion : this.state.noIdentificacion} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-calendar"> </i>
                                    <input placeholder="Fecha Nacimiento" type="date" onChange={(text) => { this.setState({ fechaNac: text.target.value }) }} value={this.state.editando ? this.state.fechaNac : this.state.fechaNac} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-location-arrow"> </i>
                                    <input placeholder="Direccion" type="text" onChange={(text) => { this.setState({ direccion: text.target.value }) }} value={this.state.editando ? this.state.direccion : this.state.direccion} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-at"> </i>
                                    <input placeholder="Correo" type="text" onChange={(text) => { this.setState({ correoElectronico: text.target.value }) }} value={this.state.editando ? this.state.correoElectronico : this.state.correoElectronico} ></input>
                                </div>
                                <div className="inputGroup mt-2">
                                    <i className="fas fa-phone"> </i>
                                    <input placeholder="Telefono" type="text" onChange={(text) => { this.setState({ telefono: text.target.value }) }} value={this.state.editando ? this.state.telefono : this.state.telefono} ></input>
                                </div>
                            </ModalBody>
                            <ModalFooter>
                                {
                                    this.state.editando ?
                                        <Button color="success" size="sm" onClick={() => { this.actualizarCliente() }}>
                                            <i className="fas fa-edit"></i> Actualizar
                                        </Button>
                                        :
                                        <Button color="success" size="sm" onClick={() => { this.agregarCliente() }}>
                                            <i className="fas fa-save"></i> Guardar
                                        </Button>
                                }
                                <Button size="sm" onClick={() => { this.toggleOpenModal() }} >
                                    <i className="fas fa-times-circle"></i> Cancel
                                </Button>
                            </ModalFooter>
                        </Modal>
                    </Container>
                }
            />

        );
    }
}