# StreamBox-BackendFinal

# Uso

Debido a que el frontend y el backend se encuentran en repositorios diferentes con despliegue independiente se recomienda para garantizar el funcionamiento correcto de la aplicación se procedera a:

* Iniciar el servidor backend mediante la url:

  [streambox-backend](https://streamboxback.herokuapp.com/)

* Ingresar a StreamBox mediante la siguiente url:

  [https://streamabox.herokuapp.com/](https://streamabox.herokuapp.com/)
  
Una vez ingresemos a la pagina web nos encontraremos con la siguiente vista que corresponde a la pagina principal de StreamBox.

![]()

Para acceder a una sala se deben llenar los siguientes campos

* **Nickname**: Corresponde a su nombre o apodo que utilizara en la sala.
* **Room**: Corresponde al nombre con el cual se creara la sala o a la cual desea ingresar.

A continuacíon se une a la sala respectiva la cual tiene la siguiente vista:

![]()

Se encontraran los siguentes componentes en la vista.

* En la parte superior izquierda se encuentra un campo llamado **Youtube video URL** con su respectivo boton **Search**, este recibe cualquier **URL** de un video de youtube y lo cargara en la zona del reproductor.

* **Reproductor**: Similar al reproductor de Youtube, las acciones realizadas en el reproductor se compartiran con todos los participantes que se encuentren en la sala, permitiendo que cualquier participante pueda:

    - **Pausar** el video.

    - **Reproducir** el video.

    - **Adelantar** el video.

    - **Retroceder** el video.

    - **Cambiar** el video.

**La sincronización se realiza de manera automatica al momento de que exista alguna pausa en el video** sin embargo contamos con un boton llamado **Synchronize** el cual se mencionara a continuación.

* **Synchronize**: Es un boton que permite sincronizar el video manualmente a todos los participantes de la sala, se usa en caso de un error en la sincronizacion automatica, por ejemplo:

Cuando se unen nuevos participantes despues del inicio del video, este solo cargara el video en el reproductor, así que la persona que se encuentra en el minuto correspondiente debera utilizar el boton **Synchronize** para que los nuevos participantes en la sala se emparejen con el resto.

* **Chat**: Se ubica en el lado derecho de la pantalla y se puede utilizar poniendo el mensaje que se desea enviar y con la tecla enter o click en **send**, el chat utiliza el nombre de usuario ingresado, en dado caso se ingrese mediante la URL de la sala se cargara automaticamente como **Anonímo**.

 
 [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/CAndresRa/StreamBox-BackendFinal)

![](https://github.com/CAndresRa/StreamBox-BackendFinal/blob/master/ImgReadme/ArquitecturaStreambox.png)
