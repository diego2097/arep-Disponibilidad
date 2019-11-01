# Taller práctico de Disponibilidad y Desempeño

## Objetivo

Construya un taller que le permita a los ingenieros crear una solución autoescalable en EC2 y en la que puedan demostrar que 
el sistema efectivamente escala bajo condiciones determinadas de carga

## Desarrollo 

1. Idee un problema interesante que necesite una solución distribida y que necesite alto consumo de procesamiento, 
por ejemplo, ordenamiento de cadenas, indexación de grandes cantidades de texto, etc.. Genere los requerimientos mínimos.

2. Construya un prototipo de la solución.

El problema elegido es el ordenamiento de cadenas, se tiene un servicio web el cual se encarga de ordenar las cadenas que sean ingresadas. 

El problema de este servicio es que cuando hay muchas solicitudes, no se puede responder a todas. Esto por falta de procesamiento. Por esto se 
requiere que cuando las solicitudes superene la capacidad del servidor se cree una nueva instancia para soportar estas solicitudes.

Se construyo el prototipo de la solucion usando spark. Como se puede observar en la imagen se tiene una interfaz donde el usuario puede ingresar la 
lista de cadenas para que sean ordenadas alfabeticamente.  

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/index.PNG "index")

![alt text](https://github.com/diego2097/arep-Disponibilidad/blob/master/img/order.PNG "ordenadas")




	