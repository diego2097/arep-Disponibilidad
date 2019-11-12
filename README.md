# Taller práctico de Disponibilidad y Desempeño

## Objetivo

Construya un taller que le permita a los ingenieros crear una solución autoescalable en EC2 y en la que puedan demostrar que 
el sistema efectivamente escala bajo condiciones determinadas de carga

## Desarrollo 

### 1. Idee un problema interesante que necesite una solución distribida y que necesite alto consumo de procesamiento, 
por ejemplo, ordenamiento de cadenas, indexación de grandes cantidades de texto, etc.. Genere los requerimientos mínimos.

### 2. Construya un prototipo de la solución.

El problema elegido es el ordenamiento de cadenas, se tiene un servicio web el cual se encarga de ordenar las cadenas que sean ingresadas. 

El problema de este servicio es que cuando hay muchas solicitudes, no se puede responder a todas. Esto por falta de procesamiento. Por esto se 
requiere que cuando las solicitudes superene la capacidad del servidor se cree una nueva instancia para soportar estas solicitudes.

Se construyo el prototipo de la solucion usando spark. Como se puede observar en la imagen se tiene una interfaz donde el usuario puede ingresar la 
lista de cadenas para que sean ordenadas alfabeticamente.  

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/index.PNG "index")

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/order.PNG "ordenadas")

### 3. Despliegue la solución en AWS en EC2.

Se desplega el servicio en una maquina EC2, como se puede observar a continuacion: 	


![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/EC2.PNG "ec2")

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/servicio.PNG "servicio")


### 4. Configure la máquina para que inicie los servicios una vez se reinicia el servidor

Para configurar que el servicio se inicie con la maquina, utilice systemd el cual es una herramienta desarrollada por Red Hat la cual permite 
iniciar y detener servicios de la maquina. 

Primero se debe crear el servicio: 

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/myservice.PNG "myservice")

En la variable ExecStart se indica el proceso a correr, se puede utilizar un script .sh o simplemente indicar el comando a ejecutar. 

Despues de esto se debe copiar este archivo en la direccion  /etc/systemd/system/

y otorgale permisos de ejecucion 

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/startservice.PNG "start")


podemos ver con status que el programa se esta ejecutando en el background, ahora para que se ejecute cada vez que se inicie la maquina simplemente 
debemos ejecutar el comando

```linux
sudo systemctl enable myservice
``` 

ejecutamos el comando y debemos obtener la siguiente respuesta 

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/enable.PNG "enable")

Ahora reiniciamos la maquina y al obtener el status de nuestro servicio este debe estar corriendo. 

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/running.PNG "running")






 









