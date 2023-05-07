# Compilando a aplicação

criar o Jar da aplicação: `./compilar_jar.sh`

# Docker

Criar a imagem: `docker build -t estudo-jmx-virtualvm .`

Montando um container: `docker run -p 9999:9999 -p 8080:8081 estudo-jmx-virtualvm`

# Docker-compose

Criando o network: `docker network create net-demo-jmx`

Iniciar a aplicação: `./up.sh`

Parar a aplicação: `./stop.sh`

Remover a aplicação: `./rm.sh`

# Reiniciando a JVM

Para reiniciar uma JVM em um sistema Linux, você pode seguir estes passos:

Obtenha o identificador do processo da JVM: você pode usar o comando jps para listar os processos Java em execução e seus identificadores correspondentes. Por exemplo, execute o seguinte comando:
Copy code
jps
Isso exibirá uma lista de processos Java em execução, cada um com seu identificador. Anote o identificador da JVM que deseja reiniciar.

Encerre a JVM: você pode encerrar a JVM usando o comando kill seguido do identificador do processo da JVM. Por exemplo, execute o seguinte comando:

```shell
kill <pid>
```
Substitua `<pid>` pelo identificador do processo da JVM que você deseja reiniciar.

Reinicie a JVM: após encerrar a JVM, você pode iniciá-la novamente executando o comando que você normalmente usaria para iniciar a JVM. Por exemplo, se você estiver executando um aplicativo Java a partir de um arquivo JAR, pode reiniciá-lo executando o seguinte comando:

```shell
java -jar app.jar

```

Certifique-se de usar as opções e argumentos corretos para iniciar a JVM, de acordo com sua configuração e ambiente.

Observe que, ao reiniciar a JVM, qualquer estado não salvo ou dados em memória serão perdidos. Além disso, dependendo da sua configuração, pode haver um tempo de inatividade enquanto a JVM é reiniciada e se recupera.



# Para usar o VisualVM

Para usar o VisualVM para acessar um contêiner Docker local, você precisa realizar algumas etapas adicionais para configurar a conexão entre o VisualVM e o contêiner.

1. Inicie o contêiner Docker com suporte JMX usando o comando abaixo:
arduino

```shell
docker run -p 9999:9999 -e JVM_OPTS="-Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false" -d myapp
```

Isso iniciará o contêiner Docker com a porta JMX 9999 exposta e as configurações para permitir conexões de clientes externos.

2. Abra o VisualVM e clique em "File" -> "Add JMX Connection".

3. Na janela "Add JMX Connection", insira as informações abaixo:

- Connection Name: um nome descritivo para identificar a conexão.
- Host: o endereço IP da máquina host.
- Port: a porta JMX exposta pelo contêiner Docker, que é 9999 neste exemplo.
- Display Name: um nome para exibir no VisualVM.
- Username e Password: deixe em branco, já que estamos usando a opção `-Dcom.sun.management.jmxremote.authenticate=false` na inicialização do contêiner.

4. Clique em "OK" para salvar a conexão.

5. O VisualVM agora deve exibir a conexão na lista de conexões. Clique na conexão para se conectar à JVM no contêiner Docker.