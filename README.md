## <a name="api-exercises">Challenge - Crowdar </a>

### Casos de Prueba
Se pueden visualizar los [ Casos de Prueba ](https://drive.google.com/file/d/1J4aM9PA-SBfbGx2RIwLPrLDkM7KvQGEv/view?usp=sharing) desde Google Driver. 


### Automatización de los casos de prueba
Para la ejecución de los test se debe tener en cuenta el tipo de navegador , Chrome o Firefox . En el caso de no especificar un navegador en particular se toma por defecto Chrome.
```sh
$ mvn clean test -Dbrowser=chrome
```
### Reporte de ejecución:
El resultado de la ejecución se podrá obtener desde el reporte generado en:
```sh
challenge-automation/reports/testng/emailable-report.html
```

### Requerimientos para la ejecución.

Java 19.0.2

Mvn 3.6.0

ChromeDriver 111.0.5563.64

Geckodriver v0.33.0-linux







