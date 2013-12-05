Métodos de Optimización
Entrega: por Enero parece

Lenguaje a usar: Java

--- GIT BASH:

Para Empezar a trabajar se debe hacer un clone del proyecto, puedes presionar
la opción que se encuentra arriba o usar:
   git clone https://Theby@bitbucket.org/Theby/optimizaci-n-pickup-and-delivery.git
como comando directamente en la consola Git Bash.
Luego pueden realizar un push para actualizar información, aunque esto
no es necesario la primera vez:
   git push origin master
      -> introduzco clave

No olvidar realizar un commit claro cada vez que realiza un push.
   Ejemplo:
      (agrega todos los archivos modificados y no actualizados)
      git add --all 
         o bien
      (agrega el archivo especificado)
      git add nombre.asdf
		
      git commit -m "Explicando que cambio se ha realizado"
	  git push origin master
         -> introduzco clave
			
Antes de empezar a trabajar en algo nuevo recordar hacer un pull para
actualizar el contenido en el pc con el contenido actual del repositorio:
   git pull origin master
      -> introduzco clave

Si se van a realizar pruebas que pueden arruinar todo, se recomienda hacer
un Fork/Branch del Proyecto para hacer un merge después, si es que
todo funciona bien.

Si se encuentra algun error/bug o se sube contenido que aún no esta terminado
y por lo tanto presenta errores, es ALTAMENTE recomendable crear un
Issue en la pestaña Issue de Bitbucket, para que no se nos pasen errores
sin darnos cuenta.

--- GIT GUI:

Esto permite trabajar con interfaz grafica, todo esta allí, solo deben elegir
la carpeta del respositorio y todo se hace por botones.

En lo personal prefiero GIT BASH