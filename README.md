# Instrucciones ejecucion del proyecto

```sql
-- Ejemplo de consulta SQL
SELECT * FROM usuarios;

>Actualizamos los repositorios
```sh
apt-get update
```
>Descargamos el bash de miniOne
```sh
wget 'https://github.com/OpenNebula/minione/releases/latest/download/minione'
```

>Concedemos permisos al script
```sh
chmod 777 minione
```
**Si se trabaja sobre una instalación mínima de Ubuntu, se deben instalar las siguientes herramientas:**
```sh
sudo apt install curl -y
sudo apt-get install augeas-tools -y
sudo apt-get install openssh-server -y
```

>Para realizar una instalación detallada se hace uso del parámetro --verbose, este instalara un hipervisor KVM por defecto
>Algunos  [parámetros de instalación](#Parámetros-de-instalación) que se pueden utilizar
```sh
sudo bash minione --verbose
```
>Si se desea instalar un hipervisor LXD
```sh
sudo bash minione --verbose --lxd
```
> __Si todo marcha bien, se tendrá una salida parecida a la siguiente__

```sh
### Checks & detection
Checking AppArmor  SKIP will try to modify

### Main deployment steps:
Install OpenNebula frontend version 5.10
Configure bridge minionebr with IP 172.16.100.1/24
Enable NAT over wlp2s0
Modify AppArmor
Install OpenNebula KVM node
Export appliance and update VM template

Do you agree? [yes/no]:
yes

### Installation
Updating APT cache  OK
Download augeas lens oned.aug  OK
Creating bridge interface minionebr  OK
Bring bridge interfaces up  OK
Configuring NAT using iptables  OK
Saving iptables changes  OK
Installing DNSMasq  OK
Starting DNSMasq  OK
Configuring repositories  OK
Updating APT cache  OK
Installing OpenNebula packages  OK
Installing Ruby gems  OK
Installing OpenNebula node packages  OK
Updating AppArmor  OK
Disable default libvirtd networking  OK
Restart libvirtd  OK

### Configuration
Switching OneGate endpoint in oned.conf  OK
Switching scheduler interval in oned.conf  OK
Setting initial password for current user and oneadmin  OK
Changing WebUI to listen on port 80  OK
Starting OpenNebula services  OK
Enabling OpenNebula services  OK
Add ssh key to oneadmin user  OK
Update ssh configs to allow VM addresses reusig  OK
Ensure own hostname is resolvable  OK
Checking OpenNebula is working  OK
Disabling ssh from virtual network  OK
Adding localhost ssh key to known_hosts  OK
Testing ssh connection to localhost  OK
Updating datastores, TM_MAD=qcow2, SHARED=yes  OK
Creating KVM host  OK
Creating virtual network  OK
Exporting [CentOS 7] from Marketplace to local datastore  OK
Updating VM template  OK

### Report
OpenNebula 5.10 was installed
Sunstone [the webui] is runninng on:
  http://192.168.1.25/
Use following to login:
  user: oneadmin
  password: 48h4dE8arj
```

> __Listo ya está instalado OpenNebula correctamente__

![test](https://dc349.4shared.com/img/HoZMxd7Hea/s23/1727568b198/opennebula)
##### Parámetros de instalación                                                                                                 
| Parámetro | Descripción |
| ------ | ------ |
|--help	| Mostrar todos los modificadores de línea de comando disponibles.|
|--verbose |	Registro detallado.|
|--lxd|	Implemente el entorno para evaluar el hipervisor LXD.|
|--version|	Especifique una versión particular de OpenNebula para implementar|
|--frontend |Solo frontend. Omitir hipervisor / red. Configuración.|
|--sunstone-port|	Puerto para enlazar la interfaz de usuario web de Sunstone|
|--password |	Contraseña inicial para un usuario dedicado de oneadmin|
|--vm-password |	Contraseña para iniciar sesión en máquinas vrtuales a través de VNC integrado|
|--purge | Desinstale OpenNebula y elimine todos los rastros.|
